package com.neopane.flisteners;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;
import org.testng.annotations.Test;

import com.neopane.util.ExcelDataUtils;

public class AnnotationTransformer implements IAnnotationTransformer {

	@Override
	public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
		 
		annotation.setDataProvider("getData");
		annotation.setDataProviderClass(ExcelDataUtils.class);
		annotation.setRetryAnalyzer(RetryFailedTests.class);
	}

	  
	//@Test(dataProvider= "getData", dataProviderClass=ExcelDataUtils.class, retryAnalyzer=RetryFailedTests.class)
}
