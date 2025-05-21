package com.client.insights.controller;

import com.client.insights.service.ClientDetailsService;
import com.client.insights.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    @PostMapping(path = "/prompt", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<byte[]> handlePrompt(@RequestBody Map<String, String> request) {
        String prompt = request.get("prompt");

        try {
            byte[] fileContent = clientDetailsService.execute(prompt);

            if (fileContent == null) {
                return ResponseEntity.badRequest().body(null);
            }

            HttpHeaders headers = new HttpHeaders();
            headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=response.xlsx");
            headers.setContentType(MediaType.parseMediaType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"));

            return ResponseEntity.ok()
                    .headers(headers)
                    .body(fileContent);
        } catch (Exception e) {
            return ResponseEntity.status(500).body(null);
        }
    }
}
