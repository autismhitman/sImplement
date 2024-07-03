package com.neopane.reports;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.neopane.constants.FrameworkConstants;
import com.neopane.enums.CategoryType;

import lombok.SneakyThrows;

public final class ExtentReport {

	private ExtentReport() {
	}

	static ExtentReports extent;
	static ExtentTest test;

	public static void initReports() {
		if (Objects.isNull(extent)) {
			extent = new ExtentReports();
			ExtentSparkReporter spark = new ExtentSparkReporter(FrameworkConstants.getExtentfolderpath());
			spark.config().setDocumentTitle("POM Framework");
			spark.config().setTheme(Theme.STANDARD);
			spark.config().setReportName("Regression Tests");
			extent.attachReporter(spark);
		}
	}

	public static void closeReports() {
		if (Objects.nonNull(extent)) {
			extent.flush();
			// Desktop.getDesktop().browse(new
			// File(FrameworkConstants.getExtentfolderpath()).toURI());

		}
		ExtentManager.unload();

	}

	public static void creatTest(String name) {

		test = extent.createTest(name);
		ExtentManager.setExTest(test);

	}

	public static void addAuthor(String[] authors) {

		for (String author : authors) {
			ExtentManager.getExTest().assignAuthor(author);
		}
	}

	public static void addCategory(CategoryType[] category) {

		for (CategoryType cat : category) {
			ExtentManager.getExTest().assignCategory(cat.name());
		}
	}
}
