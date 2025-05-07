package com.client.insights.controller;

import com.client.insights.FABService;
import com.client.insights.service.ClientDetailsService;
import com.client.insights.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
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
    @GetMapping(path = "/download", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<Resource> downloadFile() {
        try {
            // Path to the file in the writable directory
            String filePath = "/home/site/wwwroot/response.xlsx";
            File file = new File(filePath);

            if (!file.exists()) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }

            // Load the file as a resource
            Resource resource = new FileSystemResource(file);

            // Set headers for file download
            HttpHeaders headers = new HttpHeaders();
            headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=response.xlsx");

            return new ResponseEntity<>(resource, headers, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
