package com.crm.qa.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.crm.qa.base.TestBase;
import com.crm.qa.util.TestUtil;

public class ContactPage extends TestBase {
	
	@FindBy(xpath="//i[@class='users icon']")
	WebElement contact;
	
	@FindBy(xpath="//span[normalize-space()='Contacts']/parent::a/following-sibling::button")
	WebElement newcontact;
	
	@FindBy(xpath="//input[@name='first_name']")
	WebElement fstname;
	
	@FindBy(xpath="//input[@name='last_name']")
	WebElement lstname;
	
	@FindBy(xpath= "//div[@name='status' and @role='listbox']")
	WebElement status;
	
//	@FindBy(xpath= "//div[@name='status']//span[contains(text(),'Active')]")
//	WebElement selectstatus;
	
	@FindBy(xpath="//button[normalize-space()='Save']")
	WebElement save;
	
	@FindBy(xpath="//i[@class='large user red icon']")  //(//p[contains(text(),'(0, 0): (403) ACCESS_REFUSED - Login was refused u')])[1]
	WebElement redlogo;
	public ContactPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	
	
	public String validateContactPageTittle()
	{
		String tittle= driver.getTitle();
		return tittle;
	}
	
	public void saveNewContact(String name, String surname,String stat )
	{
		Actions actions = new Actions(driver);
		actions.moveToElement(contact).build().perform();  //mouse over Actions
//		newcontact.click();
		TestUtil.clickon(newcontact);
		TestUtil.clickon(fstname);
		fstname.sendKeys(name);
		TestUtil.clickon(lstname);
		lstname.sendKeys(surname);		
//		Select select = new Select(status);  //select from drop down not working as not select element
//		select.selectByVisibleText(stat);
		
		status.click();
		
		String selectstatus= "//div[@name='status']//span[contains(text(),'"+stat+"')]";
		
		driver.findElement(By.xpath(selectstatus)).click();
		
		TestUtil.clickon(save);
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		
		wait.until(ExpectedConditions.visibilityOf(redlogo));
		
	}
	

}
