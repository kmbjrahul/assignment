package com.example.uaaserver.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

/**
 * SecurityConfig is a configuration class for setting up web security in the application.
 * It uses Spring Security to define security policies and configure the security filter chain.
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig {

    /**
     * Configures the security filter chain for the application.
     *
     * @param http the HttpSecurity object to configure
     * @return the configured SecurityFilterChain
     * @throws Exception if an error occurs during configuration
     */
    @Bean
    protected SecurityFilterChain configure(HttpSecurity http) throws Exception {
        return http
                .csrf(AbstractHttpConfigurer::disable) // Disables Cross-Site Request Forgery protection
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/validate-api-key**").permitAll() // Allows unrestricted access to the /validate-api-key endpoint
                        .anyRequest().authenticated() // Requires authentication for all other requests
                )
                .sessionManagement(sess -> sess.sessionCreationPolicy(SessionCreationPolicy.STATELESS)) // Configures session management to be stateless
                .build(); // Builds and returns the SecurityFilterChain
    }
}
