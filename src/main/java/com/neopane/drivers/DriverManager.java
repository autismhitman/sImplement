package com.neopane.drivers;

import java.util.Objects;

import org.openqa.selenium.WebDriver;

public final class DriverManager {
	
	private DriverManager() {}
	
	private static ThreadLocal<WebDriver> thdriver = new ThreadLocal<>();

	public static  WebDriver  getDriver() {
		return thdriver.get();
	}

	public static void setDriver( WebDriver  driverRef) {
	  
		 if(Objects.nonNull(driverRef)) {
			 thdriver.set(driverRef);
			}
	}

    public static void unload() {
    	thdriver.remove();
    }

		
			

}
