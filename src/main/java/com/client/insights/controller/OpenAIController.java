package com.client.insights.controller;

import com.client.insights.service.OpenAIService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OpenAIController {


    private final OpenAIService openAIService;

    public OpenAIController(OpenAIService openAIService) {
        this.openAIService = openAIService;
    }

    @GetMapping(path = "/analyze", produces = MediaType.APPLICATION_JSON_VALUE)
    public String analyzeUrl(@RequestParam String url) {
        System.out.println("Analyzing URL: " + url);
        return openAIService.fetchAndAnalyzeUrlContent(url);
    }

}
