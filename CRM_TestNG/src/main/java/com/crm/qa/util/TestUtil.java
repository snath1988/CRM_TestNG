package com.crm.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.crm.qa.base.TestBase;

public class TestUtil extends TestBase{
public static long PageTimeout=20;
public static long ImplicitWait= 20;

public static void clickon(WebElement element)
{
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	wait.until(ExpectedConditions.elementToBeClickable(element)).click();
	
	
	
}


public static ArrayList<String[]> getTestData(String excelpath)
{
	File fp= new File(excelpath);
	XSSFSheet sheet = null ;
	XSSFWorkbook wb = null;
	try {
		FileInputStream fs= new FileInputStream(fp);
		wb = new XSSFWorkbook(fs);
		 sheet= wb.getSheetAt(0);
		 
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	int lastcol= sheet.getRow(0).getLastCellNum();
	ArrayList<String[]> data2= new ArrayList<String[]>();
	Iterator<Row> rowiterator= sheet.rowIterator();
	
	Row row= rowiterator.next();
	
	while(rowiterator.hasNext())
	{
		int i=0;
		String[] data1= new String[lastcol];
		 row = rowiterator.next();
		
		Iterator<Cell> celliterator= row.cellIterator();
		
		while(celliterator.hasNext())
		{
			Cell cell= celliterator.next();
			data1[i]=cell.getStringCellValue();
			i++;
		}
		data2.add(data1);
	}
	try {
		wb.close();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return data2;
}

public static String takeScreenshotAtEndOfTest(String testcase) throws IOException {
	String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
	File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	//instead of driver we can pass the webelement also to take element screenshot
	String currentDir = System.getProperty("user.dir");
	String path= currentDir + "/screenshots/" + testcase+ "_"+dateName + ".png";
	FileUtils.copyFile(scrFile, new File(path));
	System.out.println("Screenshot path:"+ path);
	return path;
	
}

}
