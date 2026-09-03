package com.groceryadmin.automation.utils;

import java.io.File;
import java.io.IOException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class ScreenshotCapture {
	public String captureScreenshot(WebDriver driver, String name) throws IOException {
		TakesScreenshot scrShot = (TakesScreenshot) driver;
		File screenShot = scrShot.getScreenshotAs(OutputType.FILE);
		File f1 = new File(System.getProperty("user.dir") + File.separator + "ScreenShots");
		if (!f1.exists()) {
			f1.mkdirs();
		}
		File finalDestination = new File(System.getProperty("user.dir") + File.separator + "ScreenShots" + File.separator + name + ".png");
		FileHandler.copy(screenShot, finalDestination);
		return finalDestination.getAbsolutePath();
	}
}