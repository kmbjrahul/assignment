package com.example.uaaserver.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
/**
 * ApiKeyValidationController is a REST controller that provides an endpoint
 * for validating API keys against an external authentication provider.
 */
@RestController
public class ApiKeyValidationController {

    /**
     * The URL of the external authentication provider for validating API keys.
     * This value is injected from the application's configuration properties.
     */
    @Value("${apikey.auth.provider.url}")
    private String apiKeyAuthProviderUrl;

    /**
     * Validates the provided API key by making a request to the external authentication provider.
     *
     * @param apiKey the API key to be validated
     * @return a response from the authentication provider indicating whether the API key is valid
     */
    @GetMapping("/validate-api-key")
    public String validateApiKey(@RequestParam String apiKey) {
        RestTemplate restTemplate = new RestTemplate();
        String url = apiKeyAuthProviderUrl + "/authenticate?apiKey=" + apiKey;
        return restTemplate.getForObject(url, String.class);
    }
}
