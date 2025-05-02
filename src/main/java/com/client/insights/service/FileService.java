package com.client.insights.service;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

@Service
public class FileService {

    @Value("${response.file.path}")
    private String filePath;

    public void writeResponseToPdf(String response) {
        try (PDDocument document = new PDDocument()) {
            // Create a new page
            PDPage page = new PDPage();
            document.addPage(page);

            // Write content to the page
            try (PDPageContentStream contentStream = new PDPageContentStream(document, page)) {
                contentStream.setFont(PDType1Font.HELVETICA, 12);
                contentStream.beginText();
                contentStream.setLeading(14.5f);
                contentStream.newLineAtOffset(50, 750);

                // Define the maximum width for text on the page
                int maxWidth = 500; // Adjust as needed
                float fontSize = 12;
                String[] words = response.split(" ");
                StringBuilder line = new StringBuilder();

                for (String word : words) {
                    // Calculate the width of the current line with the new word
                    float textWidth = (PDType1Font.HELVETICA.getStringWidth(line + word) / 1000) * fontSize;
                    if (textWidth > maxWidth) {
                        // Write the current line and start a new one
                        contentStream.showText(line.toString().trim());
                        contentStream.newLine();
                        line = new StringBuilder();
                    }
                    line.append(word).append(" ");
                }

                // Write the remaining text
                if (line.length() > 0) {
                    contentStream.showText(line.toString().trim());
                }

                contentStream.endText();
            }

            // Save the document in the resources folder
            document.save(filePath);
            System.out.println("Response written to: " + filePath);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public byte[] downloadFile() {
        try {
            // Define the file you want to send (adjust this path accordingly)
            File file = new File(filePath);

            // Check if file exists
            if (!file.exists()) {
                return null; // Return null if file not found
            }

            // Read file content into a byte array
            return Files.readAllBytes(file.toPath());

        } catch (IOException e) {
            e.printStackTrace();
            return null; // Handle error with a 500 status
        }
    }
}
