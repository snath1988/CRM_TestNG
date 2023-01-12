package com.crm.qa.testcases;

import java.util.ArrayList;
import java.util.List;

import org.testng.ITestNGListener;
import org.testng.TestListenerAdapter;
import org.testng.TestNG;

import com.crm.qa.ExtentReportListener.ExtentReporter;
import com.crm.qa.util.AnnotationTransformer;

public class TestRunner {
	///////////create runnable jar files
	
	static TestNG testng;
//	static List<Class<? extends ITestNGListener>> ex;
	static List<Class<? extends ITestNGListener>> ex;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		testng = new TestNG();
		ex= new  ArrayList<Class<? extends ITestNGListener>>();
		ex.add(ExtentReporter.class);
		ex.add(AnnotationTransformer.class);
		testng.setTestClasses(new Class[] {BaseUrlTest.class,LoginPageTest.class});  //,LoginPageTest.class
		testng.setListenerClasses(ex);
		
///////////either the above setListenerClasses by  A list of classes
//		but by above method can pass multiple listener class like AnnotationTransformer and Extentreporter
//		or below addListener method via object of the listener class	
		
		
//		ExtentReporter ext = new ExtentReporter();
//		testng.addListener(ext);

		
		testng.run();

	}

}
