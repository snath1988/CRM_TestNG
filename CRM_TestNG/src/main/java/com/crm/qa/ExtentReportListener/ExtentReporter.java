package com.crm.qa.ExtentReportListener;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.crm.qa.util.TestUtil;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;


public class ExtentReporter implements ITestListener{
	public static ExtentReports extent = new ExtentReports(System.getProperty("user.dir")+ "/test-output/ExtentReport.html", true);
	
	public static ExtentTest test;
	
	public void onTestStart(ITestResult result) {
        System.out.println("onTestStart called ...");
        test = extent.startTest(result.getMethod().getMethodName());
        		
    }

	 public void onTestSuccess(ITestResult result) {
		 
		 System.out.println("onTestSuccess called ...");
		 test.setStartedTime(getTime(result.getStartMillis()));
		 test.setEndedTime(getTime(result.getEndMillis()));
		 String group[]= result.getMethod().getGroups();
//		 System.out.println(group.length);
		 if (group.length>0)
		 test.assignCategory(group[0]);
			
		 test.log(LogStatus.PASS, "Test Case" + result.getName()+"Passed");
		 extent.endTest(test);
	    }
	 public void onTestFailure(ITestResult result) {
		 System.out.println("onTestFailure called ...");
		 String group[]= result.getMethod().getGroups();
		 if (group.length>0)
		 test.assignCategory(group[0]);
	        test.log(LogStatus.FAIL, result.getThrowable());
	        try {
				String screenshotpath= TestUtil.takeScreenshotAtEndOfTest(result.getName());
				test.log(LogStatus.FAIL, test.addScreenCapture(screenshotpath));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        //test.log(Status.FAIL, MarkupHelper.createLabel(result.getThrowable() + " - Test Case Failed", ExtentColor.RED));
	        extent.endTest(test);
	 }
	 
	 public void onTestSkipped(ITestResult result) {
		 System.out.println("onTestSkipped called ...");
		 	String group[]= result.getMethod().getGroups();
		 	 if (group.length>0)
		 	test.assignCategory(group[0]);
	        test.log(LogStatus.SKIP, result.getMethod().getMethodName() + " - Test Case Skipped");
	        extent.endTest(test);
	    }
	 
	  public void onStart(ITestContext context) {
	        System.out.println("onStart called ...");
	        //System.out.println("test name ::: "+ context.getName());
	        //test = extent.createTest(context.getName());
	    }
	  
	  public void onFinish(ITestContext context) {
	        System.out.println("onFinish called ...");
		  extent.flush();
			extent.close();
	    }
	private Date getTime (long millis) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(millis);
		return calendar.getTime();
	}
}
