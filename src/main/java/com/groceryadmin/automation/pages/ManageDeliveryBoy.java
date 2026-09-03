package com.groceryadmin.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.groceryadmin.automation.utils.GeneralUtilities;

public class ManageDeliveryBoy {

	WebDriver driver;
	GeneralUtilities gu = new GeneralUtilities();

	public ManageDeliveryBoy(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//body[1]/div[1]/aside[1]/div[1]/div[4]/div[1]/div[1]/nav[1]/ul[1]/li[14]/a[1]/p[1]")
	WebElement manageDeliveryBoy;

	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']/tbody/tr[1]/td[7]/div/a")
	WebElement showPassword;

	@FindBy(xpath = "//body/div[1]/div[1]/section[1]/div[1]/a[2]")
	WebElement searchBtn;

	public String verifyToolKit() throws InterruptedException {
		gu.clickOnElement(manageDeliveryBoy);
		gu.threadSleep(3000);
		return gu.toolTip(showPassword);
	}

	public String stylePropertyVerification() {
		gu.clickOnElement(manageDeliveryBoy);
		String color = gu.stylePropertyValidation(searchBtn, "color");
		return color;
	}

	public Boolean verifySearchButtonClickability() {
		gu.clickOnElement(manageDeliveryBoy);
		return gu.elementIsEnabled(searchBtn);
	}


}
