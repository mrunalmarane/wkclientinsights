package com.client.insights.service;


import com.azure.ai.openai.OpenAIClient;
import com.azure.ai.openai.models.Completions;
import com.client.insights.config.AzureOpenAiConfig;
import com.theokanning.openai.completion.CompletionRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OpenAIService {


    private final RestTemplate restTemplate;
    private AzureOpenAiConfig azureOpenAiConfig;

    public OpenAIService(OpenAIClient openAIClient, RestTemplate restTemplate, AzureOpenAiConfig azureOpenAiConfig) {
        this.restTemplate = restTemplate;
        this.azureOpenAiConfig = azureOpenAiConfig;
    }

    public String fetchAndAnalyzeUrlContent(String url) {
        String content = restTemplate.getForObject(url, String.class);
        CompletionRequest request = new CompletionRequest();
        request.setPrompt("Analyze the following content: " + content);
        Completions response = azureOpenAiConfig.azureOpenAiClient().getCompletions(azureOpenAiConfig.getModel(), content);
        return response.getChoices().get(0).getText();
    }

}
