package com.jala.qa.extendReportListner;

import java.io.IOException;
import java.security.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.model.Report;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.jala.qa.base.TestBaseClass;
import com.jala.qa.util.TestUtil;

import net.bytebuddy.utility.RandomString;

public class ExtendReporteLisnter extends TestBaseClass implements ITestListener {
	
	public ExtendReporteLisnter() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}


	String random = RandomString.make(3);
	ExtentSparkReporter htmlReporter;
	ExtentReports reports;
	ExtentTest test;
	TestUtil util;
	public void onStart(ITestContext context) {
		
		htmlReporter = new  ExtentSparkReporter("C:\\Users\\Sarvadnya\\eclipse-workspace\\DataDrivenFrameWork\\Reports\\extent_"+random+".html");
		htmlReporter.config().setReportName("Functional Testing");
		htmlReporter.config().setDocumentTitle("Automation Report");
		htmlReporter.config().setTheme(Theme.STANDARD);
		 
		reports = new ExtentReports();
		reports.attachReporter(htmlReporter);
		 
		reports.setSystemInfo("Computer Name", "localhost");
		reports.setSystemInfo("Environment", "QA");
		reports.setSystemInfo("TesteName", "Dipak");
		reports.setSystemInfo("Os", "Windows 10");
		   
		  }
	
	
	
	public void onTestStart(ITestResult result) {
		reports.createTest(result.getName());
		
		
		
	  }
	
	 public void onTestSuccess(ITestResult result) {
		 
		 test.log(Status.PASS, "Test Passed");
		   
		    
		  }
	 
	 public void onTestFailure(ITestResult result) {
		  try {
			util = new TestUtil();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		 try {
			util.screenShot(result.getMethod().getMethodName()+"_"+random);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	
		 
		  }
	 
	 public void onTestSkipped(ITestResult result) {
		 test.log(Status.SKIP, "Test Skipped") ;
		  }
	 
	 
	 
	 public void onFinish(ITestContext context) {
		 Reporter.log("Name of test method finished : "+ context.getName(), true);
		 reports.flush();
		  }
	
}
