/*
 * Author: Sayantan Nath
 * 
 * */



package com.crm.qa.testcases;
import java.io.IOException;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.BaseUrl;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.RetryAnalyzer;
import com.crm.qa.util.TestUtil;

public class BaseUrlTest extends TestBase{
	
	BaseUrl baseurl;
	LoginPage loginpage;
//	Logger log = Logger.getLogger(BaseUrlTest.class);
	
	public BaseUrlTest()
	{
		super();
	}
	
	
	@BeforeMethod	
	public void setUp()
	{
//		 PropertyConfigurator.configure("log4j.properties");
		initialization();
		 baseurl= new BaseUrl();		
	}
	
	@Test (priority=3, groups =  "Tittle")  //,retryAnalyzer = RetryAnalyzer.class
	public void T03_BaseUrlTittletest()
	{
		String tittle= baseurl.validateHomePageTittle();
		
		  log.info("Test");
		 
			Assert.assertEquals(tittle, "Free CRM software for any business with sales, support and customer relationship management");  //Free CRM 
	}
	
	
	@Test (priority=2, groups =  "Logo")
	public void T02_BaseUrlPageLogoTest()
	{
		Boolean logo= baseurl.validateHomePageLogo();
		
		Assert.assertTrue(logo);
//			Assert.assertTrue(false);
			
	}
	
	
	@Test (priority=1, groups =  "Login")
	public void T01_clickLoginTest()
	{	
		baseurl.cancelChatPopup();
		
		loginpage= baseurl.clickLogin();
	}
	
	
	@AfterMethod()
	public void tearDown()
	{
		
		driver.quit();
	}

}
