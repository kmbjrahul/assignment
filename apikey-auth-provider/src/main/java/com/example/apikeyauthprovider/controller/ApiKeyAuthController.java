package com.example.apikeyauthprovider.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * ApiKeyAuthController is a REST controller that provides an endpoint
 * for authenticating API keys and generating internal tokens.
 */
@RestController
public class ApiKeyAuthController {

    /**
     * Authenticates the provided API key and generates an internal token.
     *
     * @param apiKey the API key to be authenticated
     * @return a response indicating whether the API key is valid or invalid, and an internal token if valid
     */
    @GetMapping("/authenticate")
    public String authenticate(@RequestParam String apiKey) {
        // Validate API key and generate internal token
        if ("valid-api-key".equals(apiKey)) {
            return "internal-token";
        } else {
            return "invalid-api-key";
        }
    }
}