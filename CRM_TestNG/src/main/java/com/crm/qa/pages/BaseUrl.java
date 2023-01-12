package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.crm.qa.base.TestBase;
import com.crm.qa.util.TestUtil;

public class BaseUrl extends TestBase {
	
	@FindBy(linkText = "Login")
	WebElement login;
	
	@FindBy(xpath = "//iframe[contains(@class,'intercom-borderless-frame intercom')]")
	WebElement Frame;
	
	@FindBy(xpath = "//div[contains(@class,'intercom-scrollable intercom')]")
	WebElement chatBox;
	@FindBy(xpath="//div[contains(@role,'button') and contains(@aria-label,'Dismiss')]")
	WebElement cross;
	
	@FindBy(xpath="//span[@class='mdi-chart-bar icon icon-md']")  
	WebElement SignUp;
	
	@FindBy(xpath="//img[@alt='free crm logo']")   ///images/cogtiny1.jpg
	WebElement logo;
	
	
	public BaseUrl()
	{
		PageFactory.initElements(driver, this);
		
//		PageFactory.initElements(driver, HomePage.class);
	}
	
	public String validateHomePageTittle()
	{
		String tittle= driver.getTitle();
		return tittle;
	}
	
	public Boolean validateHomePageLogo()
	{
			
		cancelChatPopup();
		Boolean crmLogo= logo.isDisplayed();
		return crmLogo;
		
	}
	
	public LoginPage clickLogin()
	{
		
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//		wait.until(ExpectedConditions.elementToBeClickable(login)).click();
		TestUtil.clickon(login);
		
		return new LoginPage();
	}
	
	public void cancelChatPopup()
	{
		driver.switchTo().frame(Frame);
		Actions action =new Actions(driver);
		action.moveToElement(chatBox).build().perform();
		cross.click();
	}

}
