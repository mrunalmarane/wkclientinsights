package com.client.insights.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {

    // Add any additional configuration beans or properties here
    // For example, you can define beans for database connections, security, etc.
    // This is a placeholder for your application configuration.


    // Example: Define a bean for a RestTemplate

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
