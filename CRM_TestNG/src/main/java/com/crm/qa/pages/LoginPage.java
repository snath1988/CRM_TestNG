package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;
import com.crm.qa.util.TestUtil;

public class LoginPage extends TestBase{
	
//	@FindBy(xpath="//input[@placeholder='E-mail address']")
//	WebElement email;
	@FindBy(xpath="//input[contains(@placeholder,'E-mail')]")
	WebElement email;
	//input[contains(@placeholder,'E-mail')]
	
	@FindBy(xpath="//input[@name='password']")
	WebElement pwd;
	@FindBy(xpath="//div[contains(text(),'Login') and contains(@class,'ui fluid')]")
	WebElement login;
	
	public LoginPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String validateLoginPageTittle()
	{
		String title= driver.getTitle();
		return title;
	}
	
	public HomePage Login(String user, String password)
	{
		
//		email.click();
		
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		TestUtil.clickon(email);
		email.sendKeys(user);
		
//		pwd.click();
//		pwd.clear();
		
		TestUtil.clickon(pwd);
		pwd.sendKeys(password);
		
		TestUtil.clickon(login);
//		login.click();
		
		return new HomePage();
	}
}
