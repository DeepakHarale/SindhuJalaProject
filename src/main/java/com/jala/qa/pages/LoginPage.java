package com.jala.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.jala.qa.base.TestBaseClass;

public class LoginPage extends TestBaseClass{
	
	@FindBy(id="UserName")
	WebElement username;
	
	@FindBy(id="Password")
	WebElement password;
	
	@FindBy(id="btnLogin")
	WebElement signIn;
	@FindBy(linkText = "JALA Academy")
	WebElement varifyLoginText;
	
	public LoginPage() throws IOException {
		PageFactory.initElements(driver, this);
		
	}
	
	public void varifyLoginPage(String uname, String pass) {

		username.sendKeys(uname);
		password.sendKeys(pass);
		signIn.click();
}
	
	public void verifyLogintext() {
		String expectedName = "JALA Academy";
		String actualLogintext = varifyLoginText.getText();
		if(expectedName.equals(actualLogintext)) {
			System.out.println("matched result");
		}
	}
}