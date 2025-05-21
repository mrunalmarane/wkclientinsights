package com.client.insights.service;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Map;

@Service
public class FileService {

    @Value("${response.file.path}")
    private String filePath;

    @Value("${response.file.path.excel}")
    private String excelFilePath;

    public byte[] writeCsvToExcelMultipleSheets(Map<String, String> allCsv) throws IOException {
        System.out.println("Excel file writing in process.");

        Workbook workbook = new XSSFWorkbook();

        allCsv.forEach((sheetName, csvValue) -> {
            String[] lines = csvValue.split("\n");
            Sheet sheet = workbook.createSheet(sheetName);
            for (int i = 0; i < lines.length; i++) {
                Row row = sheet.createRow(i);
                String[] cells = lines[i].split(",");
                for (int j = 0; j < cells.length; j++) {
                    row.createCell(j).setCellValue(cells[j].trim());
                }
            }
        });

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
