package com.example.resourceserver.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * StartupEventListener is a component that listens for the application startup event.
 * It performs specific actions when the application is fully started.
 */
@Component
public class StartupEventListener {

    /**
     * The URL of the UAA (User Account and Authentication) server.
     * This value is injected from the application's configuration properties.
     */
    @Value("${uaa.server.url}")
    private String uaaServerUrl;

    /**
     * Handles the application ready event. This method is triggered when the application is fully started.
     * It sends a request to the UAA server to validate a predefined API key.
     *
     * @param event the ApplicationReadyEvent indicating that the application is ready
     */
    @EventListener
    public void onApplicationReadyEvent(ApplicationReadyEvent event) {
        try {
            RestTemplate restTemplate = new RestTemplate();
            String url = uaaServerUrl + "/validate-api-key?apiKey=valid-api-key";
            System.out.println(restTemplate.getForObject(url, String.class));

        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Running startup logic");
    }
}