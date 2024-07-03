package com.neopane.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.neopane.drivers.DriverManager;
import com.neopane.enums.WaitType;
import com.neopane.reports.ExtentLogger;

public final class OrangeLoginPage extends BasePage{

	
	private final By username= By.cssSelector("[name='username']");
	private final By password= By.cssSelector("[name='password']");
	private final By loginbtn = By.cssSelector("button[type='submit']");
	
	public OrangeLoginPage enterUsername(String uname) {
		
		sendKeys(username,WaitType.VISIBLE,uname, "username" );
		
		return this;
	}
	
	public OrangeLoginPage enterPassword(String pwd) {
		 
		sendKeys(password,WaitType.VISIBLE,pwd,"Password");
	    return this;
	}
	
	public OrangeHomePage login() {
		 
		
	    click(loginbtn,WaitType.CLICKABLE,"Login");
	   
		return new OrangeHomePage();
	}
	
    public String getTitle() {
    	
		return getPageTitle();
		 
	}
	
}
