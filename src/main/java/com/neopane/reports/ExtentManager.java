package com.neopane.reports;

import java.util.Objects;

import com.aventstack.extentreports.ExtentTest;

public final class ExtentManager {
	
	private ExtentManager() {}
	
	private static ThreadLocal<ExtentTest> exTest = new ThreadLocal<>();

	 static ExtentTest getExTest() {
		return exTest.get();
	}

	 static void setExTest(ExtentTest exTestRef) {
		 if(Objects.nonNull(exTestRef)) {
			 
			 exTest.set(exTestRef);
		 }
	}
	
	 static void unload() {
	    exTest.remove();
}

}
