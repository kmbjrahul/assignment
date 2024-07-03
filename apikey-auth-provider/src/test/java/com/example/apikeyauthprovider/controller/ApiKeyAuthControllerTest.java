package com.example.apikeyauthprovider.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.springframework.boot.test.web.server.LocalServerPort;

/**
 * Test class for ApiKeyAuthController.
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ApiKeyAuthControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    /**
     * Tests the /authenticate endpoint with a valid API key.
     *
     * @throws Exception if an error occurs during the test
     */
    @Test
    public void testAuthenticate_validApiKey() throws Exception {
        ResponseEntity<String> response = restTemplate.getForEntity(
                "http://localhost:" + port + "/authenticate?apiKey=valid-api-key", String.class);
        assertEquals("internal-token", response.getBody());
        assertTrue(response.getStatusCode().is2xxSuccessful());
    }

    /**
     * Tests the /authenticate endpoint with an invalid API key.
     *
     * @throws Exception if an error occurs during the test
     */
    @Test
    public void testAuthenticate_invalidApiKey() throws Exception {
        ResponseEntity<String> response = restTemplate.getForEntity(
                "http://localhost:" + port + "/authenticate?apiKey=invalid-api-key", String.class);
        assertEquals("invalid-api-key", response.getBody());
    }

    /**
     * Tests the /authenticate endpoint with no API key parameter.
     *
     * @throws Exception if an error occurs during the test
     */
    @Test
    public void testAuthenticate_noApiKey() throws Exception {
        ResponseEntity<String> response = restTemplate.getForEntity(
                "http://localhost:" + port + "/no-authenticate", String.class);
        assertEquals(403, response.getStatusCodeValue());
    }
}