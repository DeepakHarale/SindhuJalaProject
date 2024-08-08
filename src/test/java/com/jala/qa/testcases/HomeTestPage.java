package com.jala.qa.testcases;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.jala.qa.base.TestBaseClass;
import com.jala.qa.pages.HomePage;
import com.jala.qa.pages.LoginPage;

public class HomeTestPage extends TestBaseClass{
	public static LoginPage login;
	public static HomePage homePage;
	public HomeTestPage() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@BeforeMethod
	public void setup() throws IOException {
		Initinilization();
		login = new LoginPage();
		login.varifyLoginPage(prop.getProperty("Username"), prop.getProperty("Password"));
		 homePage = new HomePage();
		
	}
	
	@Test(priority = 1)
	public void validateHomePageUrl() {
		homePage.VarifyHomeTitle();
	}
	
	@Test(priority = 2)
	public void validateEmployeeAndCreateTab() {
//		homePage.clickOnEmployeeAndCreateTab();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.close();
		driver.quit();
	}

}
