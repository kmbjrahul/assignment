package com.example.uaaserver.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

/**
 * Integration test class for validating the behavior of ApiKeyValidationController using MockMvc.
 */
@SpringBootTest
@AutoConfigureMockMvc
public class ApiKeyValidationControllerMockMvcTest {

    @Autowired
    private MockMvc mockMvc;

    /**
     * Tests the validation of a valid API key by sending a GET request to /validate-api-key endpoint.
     *
     * @throws Exception if an error occurs during the test
     */
    @Test
    public void testValidateApiKey_ValidApiKey() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/validate-api-key")
                        .param("apiKey", "valid-api-key"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    /**
     * Tests the validation of an invalid API key by sending a GET request to /validate-api-key endpoint.
     *
     * @throws Exception if an error occurs during the test
     */
    @Test
    public void testValidateApiKey_InvalidApiKey() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/validate-api-key")
                        .param("apiKey", "invalid-api-key"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

}


