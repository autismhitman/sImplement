package com.neopane.reports;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.neopane.enums.PropertyType;
import com.neopane.util.PropertyUtils;
import com.neopane.util.ScreenshotUtils;

public final class ExtentLogger {

	private ExtentLogger() {}

	public static void info(String message) {

		ExtentManager.getExTest().info(MarkupHelper.createLabel(message, ExtentColor.BLUE));
	}

	public static void pass(String message) {

		ExtentManager.getExTest().pass(MarkupHelper.createLabel(message, ExtentColor.GREEN));
	}

	public static void skip(String message) {

		ExtentManager.getExTest().skip(MarkupHelper.createLabel(message, ExtentColor.ORANGE));
	}

	public static void fail(String message) {

		ExtentManager.getExTest().fail(MarkupHelper.createLabel(message, ExtentColor.RED));
	}

	public static void fail( String message, boolean isScreenshotRequired) {

		if (PropertyUtils.getValue(PropertyType.FAILEDSTEPSSCREENSHOT).equalsIgnoreCase("yes") && isScreenshotRequired) {

			ExtentManager.getExTest().fail(MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtils.getBase64Image()).build());

		}
		else {
			fail(message);
		}
	}

	public static void pass( String message, boolean isScreenshotRequired) {

		if (PropertyUtils.getValue(PropertyType.PASSEDSTEPSSCREENSHOT).equalsIgnoreCase("yes") && isScreenshotRequired) {

			ExtentManager.getExTest().pass(MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtils.getBase64Image()).build());

		}
		else {
			pass(message);
		}
	}

	public static void skip( String message, boolean isScreenshotRequired) {

		if (PropertyUtils.getValue(PropertyType.SKIPPEDSTEPSSCREENSHOT).equalsIgnoreCase("yes") && isScreenshotRequired) {

			ExtentManager.getExTest().skip(MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtils.getBase64Image()).build());

		}
		else {
			skip(message);
		}
	}

}
