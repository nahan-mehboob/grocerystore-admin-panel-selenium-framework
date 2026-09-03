package com.groceryadmin.automation.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.groceryadmin.automation.utils.ExcelUtils;
import com.groceryadmin.automation.utils.GeneralUtilities;

public class LoginPage {

	WebDriver driver;
	GeneralUtilities gu = new GeneralUtilities();
	ExcelUtils eu;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@placeholder='Username']")
	WebElement userName;

	@FindBy(xpath = "//input[@placeholder='Password']")
	WebElement password;

	@FindBy(xpath = "//button[@class='btn btn-dark btn-block']")
	WebElement signin;

	@FindBy(xpath = "//a[@data-toggle='dropdown']")
	WebElement profileName;

	@FindBy(xpath = "//label[contains(text(),'Remember Me')]")
	WebElement rememberCheckBox;

	@FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
	WebElement signInAlert;

	public void getUserName(String username) {
		gu.sendText(userName, username);
	}

	public void getPassword(String password1) {
		gu.sendText(password, password1);
	}

	public void clickSignin() {
		gu.clickOnElement(signin);
	}

	public String profileNameVerification() {
		return gu.getElementText(profileName);
	}

	public Boolean signinFailAlert() {
		return gu.elementIsDisplayed(signInAlert);
	}


	public String stylePropertyVerification() {
		String color = gu.stylePropertyValidation(profileName, "color");
		return color;
	}

	public Boolean rememberMeCheckboxVerficiation() {
		Boolean status= gu.elementIsSelected(rememberCheckBox);
		return status;
	}

	public List<String> getLoginDetails() {
		eu = new ExcelUtils();
		List<String>excelList= eu.readDataFromExcel("Sheet1");
		return excelList;
	}

	public void excelSteps(String username, String password1) {
		gu.sendText(userName, username);
		gu.sendText(password, password1);
		gu.clickOnElement(signin);
	}

	public void presteps() {
		getUserName("admin");
		getPassword("admin");
		clickSignin();
	}

}



