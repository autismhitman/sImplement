package com.neopane.pages;

import org.openqa.selenium.By;

import com.neopane.drivers.DriverManager;
import com.neopane.enums.WaitType;
import com.neopane.reports.ExtentLogger;
import com.neopane.reports.ExtentManager;

public final  class OrangeHomePage extends BasePage{
	
	

	private final By dashboardText= By.xpath("//span/h6");
	private final By avatar =  By.cssSelector(".oxd-userdropdown-name");
    private final By lgnout =By.cssSelector(".oxd-dropdown-menu li:nth-child(4)");
	
	public String getText() {
		
		return  getText(dashboardText,WaitType.PRESENCE);
		 
	}
	
	public OrangeHomePage clickAvatar() {
		
		click(avatar,WaitType.CLICKABLE, "avatarddl");
		 
		return this;
	}
	
	public OrangeLoginPage clickLogout() {
		
		click(lgnout,WaitType.CLICKABLE,"logout");
		return new OrangeLoginPage();
	}

}
