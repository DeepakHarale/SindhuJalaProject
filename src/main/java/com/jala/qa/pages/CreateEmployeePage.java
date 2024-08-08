package com.jala.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.jala.qa.base.TestBaseClass;

public class CreateEmployeePage extends TestBaseClass
{
	@FindBy(id = "FirstName")
	WebElement firstName;
	
	@FindBy(id = "LastName")
	WebElement lastName;
	
	@FindBy(id = "EmailId")
	WebElement email;
	
	@FindBy(id = "DOB")
	WebElement dateOfbirth;
	
	@FindBy(id = "rdbMale")
	WebElement gender;
	
	@FindBy(id = "Address")
	WebElement address;
	
	@FindBy(id = "CountryId")
	WebElement country;
	
	@FindBy(id = "CityId")
	WebElement city;
	
	@FindBy(id = "chkSkill_6")
	WebElement skills;
	
	@FindBy(xpath = "//button[@type='button']")
	WebElement save;

	public CreateEmployeePage() throws IOException {
		PageFactory.initElements(driver, this);
	}
	
	public void createEpmloyeeInfo() throws InterruptedException {
		firstName.sendKeys("paul");
		lastName.sendKeys("hemmant");
		email.sendKeys("paul@gmail.com");
		dateOfbirth.sendKeys("02/05/1995");
		gender.click();
		address.sendKeys("Mumbai, India");
		Select select = new Select(country);
		select.selectByVisibleText("India");
		
		Select select1 = new Select(city);
		select.selectByValue("5");
		skills.click();
		save.click();
	}
	

}
