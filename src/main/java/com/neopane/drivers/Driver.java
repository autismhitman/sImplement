package com.neopane.drivers;

import java.util.Objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.neopane.enums.PropertyType;
import com.neopane.util.PropertyUtils;

import io.github.bonigarcia.wdm.WebDriverManager;


/**
 * Driver class is responsible for invoking and closing the browsers.
 * <p>
 * Also responsible for setting the driver variable to Drivermanager 
 * which handles the thread safety for the webdriver instance.<p>
 * 
 * @author Navin Sharma
 * @version 1.0
 * @since 1.0
 * @see DriverManager
 * @see com.neopane.tests.BaseTests 
 */

public final class Driver {
    
	/** Private constructor to avoid external Instantiation.
	 * 
	 */
	private Driver() {}

	
	/**
	 * @param browser value will be passed from {@link com.neopane.tests.BaseTests}, currently configured for chrome and firefox.
	 * 
	 * @author Navin Sharma
	 * @version 1.0
	 * @since 1.0
	 */
	public static void init(String browser)   {



		if(Objects.isNull(DriverManager.getDriver())) {
			
			if(browser.equalsIgnoreCase("chrome")) {
				WebDriverManager.chromedriver().setup();
				WebDriver driver = new ChromeDriver();
				DriverManager.setDriver(driver);
			}
			
			else if(browser.equalsIgnoreCase("ff")) {
				WebDriverManager.firefoxdriver().setup();
				WebDriver driver = new FirefoxDriver();
				DriverManager.setDriver(driver);
			}
			
			
			DriverManager.getDriver().manage().window().maximize();
			DriverManager.getDriver().get(PropertyUtils.getValue(PropertyType.URL));
			//DriverManager.getDriver().get(JsonUtils.getValue(PropertyType.URL));
		}
	}


	public static void close() {
		if(Objects.nonNull(DriverManager.getDriver())) {
			DriverManager.getDriver().quit();
			DriverManager.unload();
		}
	}

}
