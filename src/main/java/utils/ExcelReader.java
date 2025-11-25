package utils;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;

public class ExcelReader {


    private Sheet sheet;

    public ExcelReader(String filePath, String sheetName) {
        try {
            FileInputStream fis = new FileInputStream(filePath);
            Workbook workbook = new XSSFWorkbook(fis);
            sheet = workbook.getSheet(sheetName);
        } catch ( IOException e) {
            throw new RuntimeException("Excel dosyası açılamadı: " + filePath + " => " + e.getMessage());
        }
    }

    public String getCellData(int row, int column) {
        Row r = sheet.getRow(row);
        Cell c = r.getCell(column);
        return c.toString();
    }

    public int getRowCount() {
        return sheet.getPhysicalNumberOfRows();
    }
}

