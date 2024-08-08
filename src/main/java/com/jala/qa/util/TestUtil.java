package com.jala.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.jala.qa.base.TestBaseClass;

import net.bytebuddy.utility.RandomString;

public class TestUtil extends TestBaseClass {
	String excelPath = "C:\\Users\\Sarvadnya\\eclipse-workspace\\DataDrivenFrameWork\\src\\test\\java\\com\\jala\\qa\\pages\\OKPAY.xlsx";
	
	String EXCEL_SHEET_PATH ="C:\\Users\\Sarvadnya\\eclipse-workspace\\DataDrivenFrameWork\\src\\main\\java\\com\\jala\\qa\\testdata\\LoginData.xlsx";
	FileInputStream path;
	XSSFWorkbook sheetname;
	XSSFSheet sheetnumber;
	public TestUtil() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	public static long IMPLICIT_WAIT =20;
//	***************************************ScreenShot******************************************************
	public void screenShot(String getName) throws IOException {
		 
		File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File des = new File("C:\\Users\\Sarvadnya\\eclipse-workspace\\DataDrivenFrameWork\\Reports\\"+getName+".png");
		FileHandler.copy(source, des);
	}
	
	
	

	
//	*************************** ExcelSheet Data*******************************************
	
	public Object[][] getData() throws IOException {
		 path = new FileInputStream(EXCEL_SHEET_PATH);
		 sheetname = new XSSFWorkbook(path);
		 sheetnumber = sheetname.getSheet("Sheet1");
		 
		 Object[][] data =new Object[sheetnumber.getLastRowNum()][sheetnumber.getRow(0).getLastCellNum()];
		 
		 for(int i=0; i<sheetnumber.getLastRowNum();i++) {
			 for(int j=0;j<sheetnumber.getRow(0).getLastCellNum();j++) {
//				 System.out.print(" "+sheetnumber.getRow(i+1).getCell(j).toString());
				 data[i][j] = sheetnumber.getRow(i).getCell(j).getStringCellValue();
				 
//			 System.out.println();
		 }
		 }	
		
		 return data;
	}
	
	
	
}
