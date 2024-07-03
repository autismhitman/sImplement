package com.neopane.flisteners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import com.neopane.enums.PropertyType;
import com.neopane.util.PropertyUtils;

public class RetryFailedTests implements IRetryAnalyzer {

	 int count= 0;
	 int retries = 1;
	  
	@Override
	public boolean retry(ITestResult result) {
	  if(PropertyUtils.getValue(PropertyType.RETRYFAILEDTESTS).equalsIgnoreCase("yes")) {
		  
		  if( count<retries) {
			   count++;
			   return true;
		   }
			 
		}
	        return false;
		  
		  
	  }
		
	   

}
