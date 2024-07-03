package com.neopane.util;

public final class DynamicXpathUtils {
	
	private DynamicXpathUtils() {}
	
	
	public static String getXpath(String xpath, String value) {
		//a[text()='%s']
		return String.format(xpath, value);
	}

}
