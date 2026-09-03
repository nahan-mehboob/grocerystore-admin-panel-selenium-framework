package com.groceryadmin.automation.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * Reads tabular test data from an Excel (.xlsx) file for data-driven testing.
 * Every cell is read via DataFormatter so numeric, boolean, and text cells
 * all come back as consistent, safe-to-parse Strings. Column count is
 * determined from the sheet's header row, so this works for any sheet
 * shape rather than one fixed dataset.
 */
public class ExcelUtils {

	private ExcelUtils() {
		// Prevent instantiation
	}

	public static Object[][] getExcelData(String filePath, String sheetName) {
		InputStream fis = null;
		XSSFWorkbook workbook = null;
		try {
			fis = new FileInputStream(new File(filePath));
			workbook = new XSSFWorkbook(fis);
			Sheet sheet = workbook.getSheet(sheetName);
			if (sheet == null) {
				throw new RuntimeException("Sheet '" + sheetName + "' not found in file: " + filePath);
			}

			int totalRowCount = sheet.getLastRowNum() + 1; // includes header row (row 0)
			int dataRowCount = totalRowCount - 1;           // exclude header row
			if (dataRowCount < 0) {
				dataRowCount = 0;
			}

			Row headerRow = sheet.getRow(0);
			int columnCount = (headerRow == null) ? 0 : headerRow.getLastCellNum();

			DataFormatter formatter = new DataFormatter();
			Object[][] data = new Object[dataRowCount][columnCount];

			for (int rowIndex = 1; rowIndex < totalRowCount; rowIndex++) {
				Row row = sheet.getRow(rowIndex);
				int dataIndex = rowIndex - 1;
				for (int colIndex = 0; colIndex < columnCount; colIndex++) {
					if (row == null) {
						data[dataIndex][colIndex] = "";
						continue;
					}
					Cell cell = row.getCell(colIndex);
					data[dataIndex][colIndex] = (cell == null) ? "" : formatter.formatCellValue(cell);
				}
			}
			return data;
		} catch (FileNotFoundException e) {
			throw new RuntimeException("Excel file not found at path: " + filePath, e);
		} catch (IOException e) {
			throw new RuntimeException("Failed to read excel file: " + filePath, e);
		} finally {
			try {
				if (workbook != null) {
					workbook.close();
				}
			} catch (IOException e) {
				System.err.println("Failed to close workbook: " + e.getMessage());
			}
			try {
				if (fis != null) {
					fis.close();
				}
			} catch (IOException e) {
				System.err.println("Failed to close file input stream: " + e.getMessage());
			}
		}
	}
}