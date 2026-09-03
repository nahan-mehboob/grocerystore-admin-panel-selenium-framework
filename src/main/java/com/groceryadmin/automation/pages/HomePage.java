package com.groceryadmin.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.groceryadmin.automation.utils.GeneralUtilities;

public class HomePage {

	WebDriver driver;
	GeneralUtilities gu = new GeneralUtilities();

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//a[text()='Home']")
	WebElement home;

	@FindBy(xpath="(//p[contains(text(),'Manage Expe')])[1]")
	WebElement manageExpense;

	@FindBy(xpath="(//p[text()='Manage Users'])[1]")
	WebElement manageUsers;

	public String stylePropertyVerificationOfHome() {
		String bgColor = gu.stylePropertyValidation(home, "background-color");
		return bgColor;
	}

	public String manageExpenseTextVerification() {
		return gu.getElementText(manageExpense);
	}

	public String manageUsersTextVerification() {
		return gu.getElementText(manageUsers);
	}

}
