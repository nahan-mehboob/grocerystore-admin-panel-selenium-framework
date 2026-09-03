package com.groceryadmin.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.groceryadmin.automation.utils.GeneralUtilities;

public class SettingsPage {

	WebDriver driver;
	GeneralUtilities gu = new GeneralUtilities();

	public SettingsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//body[1]/div[1]/aside[1]/div[1]/div[4]/div[1]/div[1]/nav[1]/ul[1]/li[19]/a[1]/p[1]")
	WebElement settings;

	@FindBy(xpath = "//p[contains(text(),'Logout')]")
	WebElement logout;

	public String verifyLogout() {
		gu.scrollToTheElement(settings, driver);
		gu.clickOnElement(settings);
		gu.scrollToTheElement(logout, driver);
		gu.clickOnElement(logout);
		String url = gu.gettingCurrentUrl(driver);
		return url;
	}


}
