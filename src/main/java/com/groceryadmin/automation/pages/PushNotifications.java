package com.groceryadmin.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.groceryadmin.automation.utils.GeneralUtilities;

public class PushNotifications {

	WebDriver driver;
	GeneralUtilities gu = new GeneralUtilities();

	public PushNotifications(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//p[contains(text(),'Push Notifications')]")
	WebElement pushNotifications;

	@FindBy(xpath = "//body/div[1]/div[1]/section[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[1]/div[1]/div[1]/div[1]/label[2]/span[1]")
	WebElement mandatoryField;

	@FindBy(xpath = "//input[@id=\"title\"]")
	WebElement titleInputBox;

	@FindBy(xpath = "//input[@id=\"description\"]")
	WebElement descInputBox;

	@FindBy(xpath = "//body/div[1]/div[1]/section[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[2]/button[1]")
	WebElement sendBtn;

	@FindBy(xpath = "//body/div[1]/div[1]/section[1]/div[1]/div[1]/div[1]")
	WebElement alertMsg;

	public String verifyTitleOfPage() {
		gu.clickOnElement(pushNotifications);
		return gu.getTitleOfPage(driver);
	}

	public String verifyStylePropertyOfSendButton() {
		gu.clickOnElement(pushNotifications);
		String color = gu.stylePropertyValidation(sendBtn, "color");
		return color;
	}

	public String verifyStylePropertyOfMandatoryField() {
		gu.clickOnElement(pushNotifications);
		String fieldColor = gu.stylePropertyValidation(mandatoryField, "color");
		return fieldColor;
	}

	public String verifyAlertMessage() {
		gu.clickOnElement(pushNotifications);
		gu.sendText(titleInputBox, "Notification verification");
		gu.sendText(descInputBox, "Checking whether push notification is received");
		gu.clickOnElement(sendBtn);
		String msg_Displayed = gu.getElementText(alertMsg);
		return msg_Displayed;
	}

	public String verifyBgColorOfAlertMsg() {
		gu.clickOnElement(pushNotifications);
		gu.sendText(titleInputBox, "Notification verification");
		gu.sendText(descInputBox, "Checking whether push notification is received");
		gu.clickOnElement(sendBtn);
		String bgColor = gu.stylePropertyValidation(alertMsg, "background");
		return bgColor;

	}

}
