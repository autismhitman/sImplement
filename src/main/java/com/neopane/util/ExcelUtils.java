package com.neopane.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.neopane.exceptions.FrameworkException;
import com.neopane.exceptions.InvalidPathForExcelException;

public class ExcelUtils {
	
	XSSFWorkbook book;
	XSSFSheet sheet;
	
	public ExcelUtils(String filePath) {
		
		try(FileInputStream fis = new FileInputStream(filePath)){
			
			book = new XSSFWorkbook(fis);
		 
		} catch (FileNotFoundException e) {
			 throw new InvalidPathForExcelException("File not found in the mentioned path!!!", e.getCause());
		 
		} catch (IOException e) {
			throw new FrameworkException("Exception related to IOException!!!",e.getCause());
			 
		} 
	}
	
	public int getRowCount(String sheetName) {
		 
		sheet = book.getSheet(sheetName);
		return sheet.getLastRowNum();
	}
	
	public int getColCount(String sheetName) {
		 
		sheet = book.getSheet(sheetName);
		return sheet.getRow(0).getLastCellNum();
	}
	
	public String readData(int row, int col) {
		 
		 
		return sheet.getRow(row).getCell(col).getStringCellValue();
	}

}
// try with resources if class is implementing Closeable 