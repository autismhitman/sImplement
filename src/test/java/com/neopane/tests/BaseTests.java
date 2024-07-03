package com.neopane.tests;

import java.util.Map;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.neopane.drivers.Driver;

public class BaseTests {

	protected BaseTests() {}
	
 
	
	@SuppressWarnings("unchecked")
	@BeforeMethod
	protected  void setUp(Object[] data)   {
		 
		Map<String, String> map = (Map<String, String>) data[0];
		 Driver.init(map.get("browser"));
	}
	
	@AfterMethod
	protected  void tearDown() {
		
		Driver.close();
	}
}
