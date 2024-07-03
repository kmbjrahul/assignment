package com.example.uaaserver.controller;

import com.example.uaaserver.controller.ApiKeyValidationController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ApiKeyValidationControllerIntegrationTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testValidateApiKey_ValidApiKey() {
        String apiKey = "valid-api-key";
        ResponseEntity<String> response = restTemplate.getForEntity(
                "http://localhost:" + port + "/validate-api-key?apiKey=" + apiKey,
                String.class);
        assertEquals("internal-token", response.getBody());
        // Add more assertions based on your expected behavior
    }

    @Test
    public void testValidateApiKey_InvalidApiKey() {
        String apiKey = "invalid-api-key";
        ResponseEntity<String> response = restTemplate.getForEntity(
                "http://localhost:" + port + "/validate-api-key?apiKey=" + apiKey,
                String.class);
        assertEquals("invalid-api-key", response.getBody());
        // Add more assertions based on your expected behavior
    }

    // Add more integration test cases as needed
}

