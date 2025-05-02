package com.client.insights.config;

import com.azure.ai.openai.OpenAIClient;
import com.azure.ai.openai.OpenAIClientBuilder;
import com.azure.core.credential.AzureKeyCredential;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@Configuration
@PropertySource("classpath:application.properties")
public class AzureOpenAiConfig {

    @Value("${api.key}")
    private String azureApiKey;

    @Value("${azure.openai.endpoint}")
    private String azureApiEndpoint;

    @Value("${azure.openai.deployment}")
    private String model;

    @Bean
    public OpenAIClient azureOpenAiClient() {
        return new OpenAIClientBuilder()
                .endpoint(azureApiEndpoint)
                .credential(new AzureKeyCredential(azureApiKey))
                .buildClient();
    }

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }
    @PostConstruct
    public void logProperties() {
        System.out.println("API Key: " + azureApiKey);
        System.out.println("Endpoint: " + azureApiEndpoint);
        System.out.println("Model: " + model);
    }



    public String getModel() {
        return model;
    }
}

