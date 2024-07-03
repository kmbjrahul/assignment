package com.example.apikeyauthprovider.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ApiKeyAuthControllerUnderlyingHttpStructTest {

    @Autowired
    private MockMvc mockMvc;

    /**
     * Test case to verify that the /authenticate endpoint returns a valid API token
     * when provided with a valid API key.
     */
    @Test
    void shouldReturnValidApiToken() throws Exception {
        this.mockMvc.perform(get("/authenticate?apiKey=valid-api-key"))
                .andDo(print()) // Print the request and response details for debugging
                .andExpect(status().isOk()) // Expect HTTP status code 200 (OK)
                .andExpect(content().string(containsString("internal-token"))); // Expect response body containing "internal-token"
    }

    /**
     * Test case to verify that the /authenticate endpoint returns an invalid API token
     * when provided with an invalid API key.
     */
    @Test
    void shouldReturnInvalidApiToken() throws Exception {
        this.mockMvc.perform(get("/authenticate?apiKey=invalid-api-key"))
                .andDo(print()) // Print the request and response details for debugging
                .andExpect(status().isOk()) // Expect HTTP status code 200 (OK)
                .andExpect(content().string(containsString("invalid-api-key"))); // Expect response body containing "invalid-api-key"
    }

    /**
     * Test case to verify that the /authenticate endpoint returns HTTP status code 400 (Bad Request)
     * when called without providing an API key.
     */
    @Test
    void shouldReturn400() throws Exception {
        this.mockMvc.perform(get("/authenticate"))
                .andDo(print()) // Print the request and response details for debugging
                .andExpect(status().isBadRequest()); // Expect HTTP status code 400 (Bad Request)
    }
}
