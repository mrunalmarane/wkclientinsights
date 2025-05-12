package com.client.insights.service;

import com.client.insights.dto.CpmContactDto;
import com.client.insights.entity.CpmContact;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import java.io.ByteArrayOutputStream;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.nio.file.Files;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Service
public class FileService {

    @Value("${response.file.path}")
    private String filePath;

    @Value("${response.file.path.excel}")
    private String excelFilePath;

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

    public void exportToPdf(List<CpmContact> contacts) {
        PDDocument document = new PDDocument();
        PDPageContentStream contentStream = null;

        try {
            PDPage page = new PDPage(PDRectangle.LETTER);
            document.addPage(page);

            contentStream = new PDPageContentStream(document, page);
            contentStream.setFont(PDType1Font.HELVETICA, 8);
            float margin = 40;
            float yStart = page.getMediaBox().getHeight() - margin;
            float y = yStart;
            float leading = 12f;

            Field[] fields = CpmContact.class.getDeclaredFields();

            // Draw headers
            contentStream.beginText();
            contentStream.newLineAtOffset(margin, y);
            for (Field field : fields) {
                field.setAccessible(true);
                contentStream.showText(field.getName() + " | ");
            }
            contentStream.endText();

            y -= leading;

            // Draw each contact row
            for (CpmContact contact : contacts) {
                if (y < margin) {
                    contentStream.close();
                    page = new PDPage(PDRectangle.LETTER);
                    document.addPage(page);
                    contentStream = new PDPageContentStream(document, page);
                    contentStream.setFont(PDType1Font.HELVETICA, 8);
                    y = yStart;
                }

                contentStream.beginText();
                contentStream.newLineAtOffset(margin, y);

                for (Field field : fields) {
                    field.setAccessible(true);
                    Object value = field.get(contact);
                    contentStream.showText((value != null ? value.toString() : "") + " | ");
                }

                contentStream.endText();
                y -= leading;
            }

            contentStream.close();
            document.save(filePath);
            System.out.println("PDF created at: " + filePath);

        } catch (IOException | IllegalAccessException e) {
            System.err.println("Error while creating PDF: " + e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                if (contentStream != null) {
                    contentStream.close();
                }
                document.close();
            } catch (IOException e) {
                System.err.println("Error while closing resources: " + e.getMessage());
            }
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

    public <T> void exportToExcel(List<T> data, Map<String, String> headers, Class<T> clazz) {
        if (data == null || data.isEmpty()) {
            System.out.println("No data to export.");
            return;
        }

        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet(clazz.getSimpleName());

        // Create a bold font style for headers
        Font headerFont = workbook.createFont();
        headerFont.setBold(true);
        CellStyle headerCellStyle = workbook.createCellStyle();
        headerCellStyle.setFont(headerFont);

        int rowNum = 0;
        Row headerRow = sheet.createRow(rowNum++);

        // Write custom headers
        int colNum = 0;
        for (String headerTitle : headers.values()) {
            Cell cell = headerRow.createCell(colNum++);
            cell.setCellValue(headerTitle);
            cell.setCellStyle(headerCellStyle);
        }

        // Write data
        for (T item : data) {
            Row row = sheet.createRow(rowNum++);
            colNum = 0;
            for (String fieldName : headers.keySet()) {
                try {
                    Field field = clazz.getDeclaredField(fieldName);
                    field.setAccessible(true);
                    Object value = field.get(item);
                    row.createCell(colNum++).setCellValue(value != null ? value.toString() : "");
                } catch (Exception e) {
                    row.createCell(colNum++).setCellValue("ERR");
                }
            }
        }

        // Auto-size columns
        for (int i = 0; i < headers.size(); i++) {
            sheet.autoSizeColumn(i);
        }

        try (FileOutputStream outputStream = new FileOutputStream(excelFilePath)) {
            workbook.write(outputStream);
            System.out.println("Excel file written to: " + excelFilePath);
        } catch (IOException e) {
            System.err.println("Error writing Excel file: " + e.getMessage());
        } finally {
            try {
                workbook.close();
            } catch (IOException e) {
                System.err.println("Error closing workbook: " + e.getMessage());
            }
        }
    }

    public void exportToExcel(List<CpmContactDto> contacts) {

        Map<String, String> headers = new LinkedHashMap<>();
        headers.put("companyNameOrPersonName", "Company Name");
        headers.put("legalEntityLegalForm", "Legal Entity");
        headers.put("firmOrgStructure", "Firm Org");
        headers.put("personSurname", "Last Name");
        headers.put("personFirstName", "First Name");
        headers.put("orgNumber", "Org Number");
        headers.put("personNiNo", "Person Ni Number");
        headers.put("personNumber", "Person Number");
        headers.put("personBirthday", "Birthday");
        headers.put("personTaxRef", "Person Tax Ref");
        headers.put("legalEntityTaxRef", "Legal Entity Tax Ref");
        headers.put("personProfession", "Profession");
        headers.put("contactCode", "Contact Code");
        //headers.put("responsibleEmployee", "Responsible Employee");
        headers.put("legalEntityBusiness", "Legal Entity Business");
        headers.put("legalEntityFoundingDate", "Legal Entity Founding date");
        headers.put("email", "Email");
        headers.put("alias", "Alias");
        headers.put("responsibleEmployeeName", "Responsible Employee");

        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Contacts");

        int rowNum = 0;
        Row headerRow = sheet.createRow(rowNum++);

        // Write custom headers
        int colNum = 0;
        for (String headerTitle : headers.values()) {
            Cell cell = headerRow.createCell(colNum++);
            cell.setCellValue(headerTitle);
        }

        // Write data
        for (CpmContactDto contact : contacts) {
            Row row = sheet.createRow(rowNum++);
            colNum = 0;
            for (String fieldName : headers.keySet()) {
                try {
                    Field field = CpmContactDto.class.getDeclaredField(fieldName);
                    field.setAccessible(true);
                    Object value = field.get(contact);
                    row.createCell(colNum++).setCellValue(value != null ? value.toString() : "");
                } catch (Exception e) {
                    row.createCell(colNum++).setCellValue("ERR");
                }
            }
        }

        // Auto-size columns
        for (int i = 0; i < headers.size(); i++) {
            sheet.autoSizeColumn(i);
        }
         // Delete the file if it already exists
        File file = new File(excelFilePath);
        if (file.exists()) {
            file.delete();
        }
        // Create a new FileOutputStream to overwrite the file

        try (FileOutputStream outputStream = new FileOutputStream(excelFilePath)) {
            workbook.write(outputStream);
            System.out.println("Excel file written to: " + excelFilePath);
        } catch (IOException e) {
            System.err.println("Error writing Excel file: " + e.getMessage());
        } finally {
            try {
                workbook.close();
            } catch (IOException e) {
                System.err.println("Error closing workbook: " + e.getMessage());
            }
        }
    }

    public byte[] writeCsvToExcel(String csv) throws IOException {
        String[] lines = csv.split("\n");

        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Client Data");

        for (int i = 0; i < lines.length; i++) {
            Row row = sheet.createRow(i);
            String[] cells = lines[i].split(",");
            for (int j = 0; j < cells.length; j++) {
                row.createCell(j).setCellValue(cells[j].trim());
            }
        }

        try (ByteArrayOutputStream bos = new ByteArrayOutputStream()) {
            workbook.write(bos);
            System.out.println("Excel file written successfully.");
            return bos.toByteArray(); // Return the generated file as a byte array
        } finally {
            workbook.close();
        }
    }

    public byte[] createNoDataExcel() {
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("No Data");

        // Add a message in the first cell
        Row row = sheet.createRow(0);
        Cell cell = row.createCell(0);
        cell.setCellValue("No data found");

        try (ByteArrayOutputStream bos = new ByteArrayOutputStream()) {
            workbook.write(bos);
            return bos.toByteArray();
        } catch (IOException e) {
            throw new RuntimeException("Error creating Excel file", e);
        } finally {
            try {
                workbook.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
