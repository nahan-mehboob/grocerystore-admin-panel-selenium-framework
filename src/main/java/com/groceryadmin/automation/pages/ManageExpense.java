package com.groceryadmin.automation.pages;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.groceryadmin.automation.utils.GeneralUtilities;

public class ManageExpense {

	WebDriver driver;
	GeneralUtilities gu = new GeneralUtilities();

	public ManageExpense(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//body[1]/div[1]/aside[1]/div[1]/div[4]/div[1]/div[1]/nav[1]/ul[1]/li[2]/a[1]/p[1]")
	WebElement manageExpense;

	@FindBy(xpath = "//p[contains(text(),'Expense Category')]")
	WebElement expenseCategory;

	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	WebElement newBtn;

	@FindBy(xpath = "//input[@id='name']")
	WebElement newTitleInputBox;

	@FindBy(xpath = "(//button[@class='btn btn-block-sm btn-danger'])[2]")
	WebElement saveBtn;

	@FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
	WebElement newTitleFailAlert;

	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement newTitleSuccessAlert;

	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']//tbody//tr[3]")
	WebElement thirdPrdTitle;

	public String verifyTheProductTitleAlreadyExists() throws InterruptedException {
		gu.clickOnElement(manageExpense);
		gu.threadSleep(4000);
		gu.keyDownAction(driver,Keys.TAB);
		gu.keyUpAction(driver,Keys.TAB);
		gu.keyDownAction(driver, Keys.ENTER);
		gu.keyUpAction(driver, Keys.ENTER);
		gu.clickOnElement(newBtn);
		gu.clearInputField(newTitleInputBox);
		gu.sendText(newTitleInputBox, "SpicesOrg9937");
		gu.clickOnElement(saveBtn);
		return gu.getElementText(newTitleFailAlert);
	}

}