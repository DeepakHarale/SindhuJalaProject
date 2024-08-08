package com.jala.qa.pages;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class utililty {
	FileInputStream file;
	XSSFWorkbook book;
	String sheetName = "Sheet1";
	XSSFSheet sheet;
	String excelPath = "C:\\Users\\Sarvadnya\\eclipse-workspace\\DataDrivenFrameWork\\src\\test\\java\\com\\jala\\qa\\pages\\OKPAY.xlsx";
	
	@Test
	public Object[][] getData() throws IOException {
		 file = new FileInputStream(excelPath);
		  book = new XSSFWorkbook(file);
		 sheet = book.getSheet("Sheet1");
		  
		  Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		  
		  for(int i=0; i<sheet.getLastRowNum();i++) {
			  for(int j=0;j<sheet.getRow(0).getLastCellNum();j++) {
//				  System.out.println(" "+sheet.getRow(i).getCell(j).getStringCellValue());
				   data[i][j] = sheet.getRow(i+1).getCell(j).getStringCellValue();
			  }
		  }
		  return data;
	}
}
