package com.jala.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.jala.qa.util.TestUtil;

public class TestBaseClass {
	public static Properties prop;
	public static WebDriver driver;
	
	public TestBaseClass() throws IOException {
	try {
	prop = new Properties();
	 FileInputStream ip = new FileInputStream("C:\\Users\\Sarvadnya\\eclipse-workspace\\DataDrivenFrameWork\\src\\main\\java\\com\\jala\\qa\\propertiesFile\\Config.properties");
	prop.load(ip);
	}
	catch(FileNotFoundException e) {
		e.printStackTrace();
	}catch(IOException e) {
		e.printStackTrace();
	}	
	}
	
	public static void Initinilization() {
		String browsername = prop.getProperty("Browser");
		if(browsername.equalsIgnoreCase("Chrome")) {
			 driver = new ChromeDriver();
		}
		else if(browsername.equalsIgnoreCase("FireFox")) {
			driver = new FirefoxDriver();
		}
		else if(browsername.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("URL"));
		
	}
	
	
	
	
}
