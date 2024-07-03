package com.neopane.pages;

import org.openqa.selenium.By;

import com.neopane.drivers.DriverManager;
import com.neopane.enums.WaitType;
import com.neopane.reports.ExtentLogger;
import com.neopane.strategy.WaitStrategy;

public class BasePage {
	
	
	protected void click(By by, WaitType waitType, String elementName) {
		
		WaitStrategy.performExplicitWait( waitType, by).click();
		ExtentLogger.pass(elementName +" is clicked", true);
	}
    
	protected void sendKeys(By by, WaitType waitType, String value, String elementName) {
		WaitStrategy.performExplicitWait( waitType, by).sendKeys(value);
		ExtentLogger.pass(elementName +" is entered", true);
	}
	
     protected String getText(By by, WaitType waitType) {
    	 ExtentLogger.pass("Text is fetched ", true);
		return WaitStrategy.performExplicitWait( waitType, by).getText();
		 
	}
     
     protected String getPageTitle() {
    	 ExtentLogger.pass("Title is fetched", true);	
 		return DriverManager.getDriver().getTitle();
 		 
 	}
     
   
}
