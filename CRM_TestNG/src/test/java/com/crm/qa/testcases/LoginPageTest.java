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
import com.crm.qa.util.TestUtil;

public class LoginPageTest extends TestBase {
	
	LoginPage loginpage;
	BaseUrl baseurl;
	ITestResult result;
	public LoginPageTest()
	{
		super();
	}
	
	@BeforeMethod
	
	public void setUp()
	{
		initialization();
		baseurl= new BaseUrl(); 
		loginpage= baseurl.clickLogin();		
	}
	
	@Test(priority = 1,groups =  "Tittle")
	public void T04_LoginPageTittleTest()
	{
		String tittle= loginpage.validateLoginPageTittle();
		
			Assert.assertEquals(tittle, "Cogmento CRM");  //Cogmento CRM
			
	}
	
	@Test(priority = 2,groups =  "Login")
	public void T05_LoginTest()
	{
		
			loginpage.Login(prop.getProperty("user"), prop.getProperty("password"));
			
	}
	
	
	@AfterMethod
	public void tearDown() 
	{
		
		driver.quit();
	
	}
	

}
