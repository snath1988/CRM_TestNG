package com.crm.qa.util;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer{
	
	int count=1;
	int limit=2;
	@Override
	public boolean retry(ITestResult result) {
		
		if(count<=limit)
		{
			count++;
			return true;
		}
		
		return false;
	}

	
	//interface ijk { interface vs class
//  
//   declare constant fields
//   declare methods that abstract 
//   by default.
//	Like a class, an interface can have methods and variables, 
//	but the methods declared in interface are by default abstract (only method signature, no body).   
//}
}
