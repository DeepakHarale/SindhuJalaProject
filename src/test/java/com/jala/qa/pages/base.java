package com.jala.qa.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class base {
 static  WebDriver driver;
 utililty util ;
@BeforeMethod
public void setup() throws InterruptedException {
	driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://magnus.jalatechnologies.com/");
	Thread.sleep(2000);
}

@DataProvider
public Object[][] fetchdata() throws IOException{
	util = new utililty();
	Object data[][] = util.getData();
	return data;
}

@Test (dataProvider = "fetchdata")
public void login(String uname, String pass) {
	driver.findElement(By.id("UserName")).sendKeys(uname);;
	driver.findElement(By.id("Password")).sendKeys(pass);;
	driver.findElement(By.id("btnLogin"));
}

@AfterMethod
public void tearDown() {
	driver.close();
}
}
