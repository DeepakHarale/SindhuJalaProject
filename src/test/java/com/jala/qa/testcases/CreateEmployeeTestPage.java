package com.jala.qa.testcases;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.jala.qa.base.TestBaseClass;
import com.jala.qa.pages.CreateEmployeePage;
import com.jala.qa.pages.HomePage;
import com.jala.qa.pages.LoginPage;

public class CreateEmployeeTestPage extends TestBaseClass {

	public static LoginPage login;
	public static HomePage homePage;
	public static CreateEmployeePage emp;

	public CreateEmployeeTestPage() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	@BeforeMethod
	public void setup() throws IOException {
		Initinilization();
		login = new LoginPage();
		login.varifyLoginPage(prop.getProperty("Username"), prop.getProperty("Password"));
		homePage = new HomePage();
		homePage.clickOnEmployeeAndCreateTab();
		 emp = new CreateEmployeePage();
	}

	@Test
	public void ValidateCreateNewEmployee() throws InterruptedException {
		emp.createEpmloyeeInfo();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	
	}

}
