package com.crm.qa.testcases;

import java.util.ArrayList;
import java.util.Iterator;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.BaseUrl;
import com.crm.qa.pages.ContactPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class ContactPageTest extends TestBase{

	
	BaseUrl baseurl;
	LoginPage loginpage;
	HomePage homepage;
	ContactPage contactpage;
	
	public ContactPageTest()
	{
		super();
		
	}
	
	@BeforeMethod()
	public void setUp()
	{
		initialization();
		baseurl= new BaseUrl();
		loginpage= baseurl.clickLogin();
		homepage= loginpage.Login(prop.getProperty("user"), prop.getProperty("password"));
		contactpage= homepage.selectContact();
	}
	
	@DataProvider()
	public Iterator<String[]> AddContactData()
	{
		ArrayList<String[]> data= TestUtil.getTestData(System.getProperty("user.dir")+prop.getProperty("createContactDataPath"));
		return data.iterator();
	}
	
	@Test(dataProvider = "AddContactData")
	public void saveNewContactTest(String name, String surname, String status)
	{
		contactpage.saveNewContact(name, surname, status);
	}
	
	@AfterMethod()
	public void tearDown()
	{
		driver.quit();
	}

}
