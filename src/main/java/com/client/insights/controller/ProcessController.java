package com.client.insights.controller;

import com.client.insights.FABService;
import com.client.insights.service.ClientDetailsService;
import com.client.insights.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class ProcessController {

    @Value("${response.file.path}")
    private String filePath;

    @Autowired
    private ClientDetailsService clientDetailsService;

    @Autowired
    private FileService fileService;

    // Method to handle the prompt
    @PostMapping(path = "/prompt",  produces = MediaType.APPLICATION_JSON_VALUE)
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<String> handlePrompt(@RequestBody Map<String, String> request) {
        String prompt = request.get("prompt");
        // Process the prompt
        clientDetailsService.execute(prompt); // Call the execute method with the prompt
        return ResponseEntity.ok("Response to: " + prompt);
    }

    // Method to download a file
    @GetMapping(path = "/download",  produces = MediaType.APPLICATION_JSON_VALUE)
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<byte[]> downloadFile() {

        byte[] fileContent = fileService.downloadFile();

        if(fileContent == null) {
            return ResponseEntity.badRequest().body(null); // Return 404 if file not found
        }

        // Set headers for the file download
        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=generated-file.txt"); // Set the filename
        headers.add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_OCTET_STREAM_VALUE); // Use generic binary type

        // Return file content as the body of the response
        return ResponseEntity.ok()
                .headers(headers)
                .body(fileContent);
    }
}
