package com.neopane.strategy;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.neopane.drivers.DriverManager;
import com.neopane.enums.WaitType;

public final class WaitStrategy {
	
	private WaitStrategy() {}
	  
	 public static WebElement performExplicitWait(WaitType waitType, By by) {
		 
		 WebElement element = null;
		 
		 if(waitType==waitType.CLICKABLE) {
			 
			 element= new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(10))
			          .until(ExpectedConditions.elementToBeClickable(by));
		 }
		 else if(waitType==waitType.PRESENCE) {
			 
			 element= new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(10))
			            .until(ExpectedConditions.presenceOfElementLocated(by));
		 } else if (waitType==waitType.VISIBLE) {
			 
			 element= new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(10))
			            .until(ExpectedConditions.visibilityOfElementLocated(by));
		 }  else if(waitType==waitType.NONE) {
			 
			 element=  DriverManager.getDriver().findElement(by);
		 }
		   
		 return element;
		 
	 }

}
