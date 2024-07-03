package com.neopane.flisteners;

import java.util.Arrays;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.neopane.frameworkAnnotations.Annotations;
import com.neopane.reports.ExtentLogger;
import com.neopane.reports.ExtentManager;
import com.neopane.reports.ExtentReport;
import com.neopane.util.ELKUtils;

public class Frameworklistener implements ITestListener, ISuiteListener{

	@Override
	public void onStart(ISuite suite) {
	    ExtentReport.initReports();
	}

	@Override
	public void onFinish(ISuite suite) {
		 ExtentReport.closeReports();
	}

	@Override
	public void onTestStart(ITestResult result) {
		 ExtentReport.creatTest(result.getMethod().getMethodName());
		 ExtentReport.addAuthor(
				 result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(Annotations.class).author());
		 ExtentReport.addCategory(result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(Annotations.class).category());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		 ExtentLogger.pass(result.getMethod().getMethodName());
		 ELKUtils.getElkDocs(result.getMethod().getMethodName(), "Pass");
	}

	@Override
	public void onTestFailure(ITestResult result) {
	
	  //   ExtentLogger.fail (result.getThrowable().toString(), true) ;
	  //   ExtentLogger.fail (Arrays.toString(result.getThrowable().getStackTrace()));
		// ExtentLogger.fail(result.getMethod().getMethodName());
		// ELKUtils.getElkDocs(result.getMethod().getMethodName(), "Fail");
	}

	@Override
	public void onTestSkipped(ITestResult result) {
	      ExtentLogger.skip(result.getMethod().getMethodName());
	      ELKUtils.getElkDocs(result.getMethod().getMethodName(), "Skip");
	}

	
	
	
}
