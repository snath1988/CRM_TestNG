package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase{
	
	@FindBy(xpath= "//div[@class='header item']")
	WebElement image;
		
	@FindBy(xpath="//span[@class='user-display']")
	WebElement name;
	
	@FindBy(xpath="//i[@class='users icon']")
	WebElement contact;
	
		
	public HomePage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String ValidateHomePageTittle()
	{
		String title= driver.getTitle();
		return title;
	}
	
	public String ValidateUsername()
	{
		String uname= name.getText();
		return uname;
	}
	
	public ContactPage selectContact()
	{
		contact.click();
		
		return new ContactPage();
	}
	

}
