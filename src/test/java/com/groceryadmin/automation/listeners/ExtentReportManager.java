package com.groceryadmin.automation.listeners;

import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import com.groceryadmin.automation.base.BaseTest;
import com.groceryadmin.automation.utils.ScreenshotCapture;

public class ExtentReportManager implements ITestListener {

	ExtentSparkReporter sparkReporter;
	ExtentReports reports;
	ExtentTest test;

	private void configureReport() {
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("ddMMyyyy_hhmmss");
		String strDate = formatter.format(date);
		File reportPath = new File(System.getProperty("user.dir") + "//ExtentReport");
		if (!reportPath.exists()) {
			reportPath.mkdir();
		}
		// create file
		sparkReporter = new ExtentSparkReporter(
				System.getProperty("user.dir") + "//ExtentReport//" + "ExtentReport_" + strDate + ".html");
		reports = new ExtentReports();
		reports.attachReporter(sparkReporter);

		// System details — read dynamically so the report is accurate on any machine
		try {
			reports.setSystemInfo("Host", InetAddress.getLocalHost().getHostName());
		} catch (UnknownHostException e) {
			reports.setSystemInfo("Host", "Unknown");
		}
		reports.setSystemInfo("OS", System.getProperty("os.name"));

		sparkReporter.config().setDocumentTitle("GroceryStore Admin Panel — Test Execution Report");
		sparkReporter.config().setReportName("Selenium UI Automation Test Results");
		sparkReporter.config().setTheme(Theme.DARK);
	}

	public void onTestStart(ITestResult result) {
		test = reports.createTest(result.getName());
		test.log(Status.INFO,
				MarkupHelper.createLabel("Starting test: " + result.getName(), ExtentColor.BLUE));
	}

	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS,
				MarkupHelper.createLabel("Name of the Passed Test Case is : " + result.getName(), ExtentColor.GREEN));
	}

	public void onTestFailure(ITestResult result) {
		test.log(Status.FAIL,
				MarkupHelper.createLabel("Name of the Failed Test Case is : " + result.getName(), ExtentColor.RED));

		Object currentTestInstance = result.getInstance();
		if (currentTestInstance instanceof BaseTest) {
			WebDriver driver = ((BaseTest) currentTestInstance).driver;
			try {
				ScreenshotCapture sc = new ScreenshotCapture();
				String screenshotPath = sc.captureScreenshot(driver, result.getName());
				test.addScreenCaptureFromPath(screenshotPath);
			} catch (IOException e) {
				test.log(Status.WARNING, "Screenshot capture failed: " + e.getMessage());
			}
		}
	}

	public void onTestSkipped(ITestResult result) {
		test.log(Status.SKIP,
				MarkupHelper.createLabel("Name of the skipped test case is : " + result.getName(), ExtentColor.YELLOW));
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	}

	public void onTestFailedWithTimeout(ITestResult result) {
	}

	public void onStart(ITestContext context) {
		configureReport();
	}

	public void onFinish(ITestContext context) {
		reports.flush(); //refreshes on its own
	}
}