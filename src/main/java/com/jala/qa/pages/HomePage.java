package com.jala.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.jala.qa.base.TestBaseClass;

public class HomePage extends TestBaseClass {

	@FindBy(linkText = "Employee")
	WebElement employeeTab;
	
	@FindBy(linkText = "Create")
	WebElement createTab;
	
	@FindBy(linkText = "More")
	WebElement moretab;
	
	@FindBy(linkText = "Multiple Tabs")
	WebElement multipleTab;
		
	
	public HomePage() throws IOException {
		PageFactory.initElements(driver, this);
	}

	public void VarifyHomeTitle() {
		String expectedTitle = "https://magnus.jalatechnologies.com/Home/Index";
		String actualTitle = driver.getCurrentUrl();
		if (expectedTitle.equals(actualTitle)) {
			System.out.println("Title matched TC passed");
		}
	}
	
	public CreateEmployeePage clickOnEmployeeAndCreateTab() throws IOException {
		employeeTab.click();
		createTab.click();
		return new CreateEmployeePage();
	}
	
	
	public void clickOnMoreTab() {
		moretab.click();
	}
	
//	public MupltipleTabPage clickOnMultipleTab() {
//		multipleTab.click();
//		return new MupltipleTabPage();
//	}
	

}
