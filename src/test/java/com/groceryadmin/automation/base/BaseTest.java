package com.groceryadmin.automation.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	public WebDriver driver;
	public static Properties prop;
	
	
	public static void testBasic() throws IOException {
		prop = new Properties();
		FileInputStream fileIo = new FileInputStream(System.getProperty("user.dir")+"//src//main//resources//Properties//Config.properties");
		prop.load(fileIo); //loading config.property file
	}
	
	
	@Parameters({"Browser", "Headless"})
	@BeforeMethod(alwaysRun = true)
	public void beforeMethod(String browser, @Optional("false") String headless) throws IOException {
		//boolean isHeadless = Boolean.parseBoolean(headless);
		boolean isHeadless = System.getProperty("headless") != null
				? Boolean.parseBoolean(System.getProperty("headless"))
				: Boolean.parseBoolean(headless);
		if(browser.equals("chrome")) {
			testBasic();
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			if(isHeadless) {
				options.addArguments("--headless=new");
				options.addArguments("--window-size=1920,1080");
			}
			driver  = new ChromeDriver(options);
		}
		else if (browser.equals("edge")){
			testBasic();
			WebDriverManager.edgedriver().setup();
			EdgeOptions options = new EdgeOptions();
			if(isHeadless) {
				options.addArguments("--headless=new");
				options.addArguments("--window-size=1920,1080");
			}
			driver  = new EdgeDriver(options);
		}
		else{
			testBasic();
			WebDriverManager.firefoxdriver().setup();
			FirefoxOptions options = new FirefoxOptions();
			if(isHeadless) {
				options.addArguments("--headless");
				options.addArguments("--width=1920", "--height=1080");
			}
			driver  = new FirefoxDriver(options);
		}
		driver.get(prop.getProperty("baseURL"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	
	@AfterMethod(alwaysRun = true)
	public void afterMethod(ITestResult iTestResult) throws IOException {
		driver.quit();
	}
}