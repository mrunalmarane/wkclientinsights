package com.client.insights.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

@Service
public class FABService {

    @Value("${agent.url}")
    private String agentUrl;

    @Value("${api.key}")
    private String apiKey;

    public StringBuilder execute(String prompt) {
        try {
            // URL of the endpoint
            HttpURLConnection connection = getHttpURLConnection(prompt);

            // Read the response
            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                try (BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream(), StandardCharsets.UTF_8))) {
                    StringBuilder response = new StringBuilder();
                    String responseLine;
                    while ((responseLine = br.readLine()) != null) {
                        response.append(responseLine.trim());
                    }
                    System.out.println("Response: " + response);

                    return response;
                }
            } else {
                System.out.println("HTTP error code: " + responseCode);
            }

            connection.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private HttpURLConnection getHttpURLConnection(String prompt) throws IOException {
        // Create a connection
        HttpURLConnection connection = (HttpURLConnection) new URL(agentUrl).openConnection();
        connection.setRequestMethod("POST");
        connection.setRequestProperty("Content-Type", "application/json");
        connection.setRequestProperty("x-authentication", apiKey);
        connection.setRequestProperty("x-user-id", "test-user");
        connection.setDoOutput(true);

        // JSON payload
        String jsonInputString = "{\n" +
                "    \"input\": {\n" +
                "        \"persistent\": false,\n" +
                "        \"conversationId\": \"0d69a7a9-08cb-4d3b-b736-d6679f1c3646\",\n" +
                "        \"expyId\": \"agents-playground-test\",\n" +
                "        \"source\": \"agents-playground\",\n" +
                "        \"messages\": [\n" +
                "            {\n" +
                "                \"role\": \"user\",\n" +
                "                \"payload\": {\n" +
                "                    \"content\": \"" + prompt + "\"\n" +
                "                },\n" +
                "                \"context\": {\n" +
                "                    \"selectedDocuments\": [],\n" +
                "                    \"hiddenFilters\": {}\n" +
                "                }\n" +
                "            }\n" +
                "        ]\n" +
                "    }\n" +
                "}";

        // Write the JSON payload to the request body
        try (OutputStream os = connection.getOutputStream()) {
            byte[] input = jsonInputString.getBytes(StandardCharsets.UTF_8);
            os.write(input, 0, input.length);
        }
        return connection;
    }
}
