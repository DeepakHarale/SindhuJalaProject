package com.jala.qa.testcases;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.jala.qa.base.TestBaseClass;
import com.jala.qa.pages.LoginPage;
import com.jala.qa.util.TestUtil;

public class LoginTestPage extends TestBaseClass {
	LoginPage login;
	TestUtil util;
	
	static Logger log = LogManager.getLogger(LoginTestPage.class);

	public LoginTestPage() throws IOException {
		super();

	}

	@BeforeMethod
	public void setup() throws IOException {
		Initinilization();
		login = new LoginPage();

	}

//	@DataProvider
//	public Object[][] SampleData(){
//		
//		Object data[][]= {{"abc","xyz"},
//				         {"apqr","sdt"}};
//		return data;
//	}
	
	@DataProvider
	public Object[][] setData() throws IOException{
		 util = new TestUtil();
		Object a[][] = util.getData();
		
		return a;
	}
	
	
	@Test(dataProvider = "setData")
	public void validateLoginCredential(String uname, String pass) throws IOException {
		log.info("**************************Validating login Page***********************");
		login.varifyLoginPage(uname,pass);
		
	}

	@AfterMethod
	public void tearDown() {
		log.info("**************************Application is closed successfully***********************");
		driver.close();
		driver.quit();
	}
}
