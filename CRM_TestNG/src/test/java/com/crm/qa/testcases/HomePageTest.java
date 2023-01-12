package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.BaseUrl;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class HomePageTest extends TestBase {
	
	BaseUrl baseurl;
	LoginPage loginpage;
	HomePage homepage;
	
	HomePageTest()
	{
		super();
	}
	
	
	@BeforeMethod()
	public void setUp()
	{
		initialization();
		baseurl= new BaseUrl();
		loginpage=baseurl.clickLogin();
//		homepage=loginpage.Login(prop.getProperty("user"), prop.getProperty("password"));
		
		homepage=loginpage.Login("Sayantannath1988@gmail.com", "Kolkata@21");
		
	}
	
	@Test(priority = 1)
	public void T06_HomePageTittletest()
	{
		String tittle= homepage.ValidateHomePageTittle();
		Assert.assertEquals(tittle, "Cogmento CRM23");
	}
	
	@Test(priority = 2)
	public void T07_HomepageUsertest()
	{
		String username =homepage.ValidateUsername();
		
		System.out.println(username);
		
		Assert.assertEquals(username, "Sayantan Nath");
	}
	
	@Test(priority=3)
	public void T08_HomepageSelectContactTest()
	{
		homepage.selectContact();
	}
	
	@AfterMethod()
	public void tearDown()
	{
		driver.quit();
	}

}
