package com.groceryadmin.automation.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.groceryadmin.automation.constants.Constants;
import com.groceryadmin.automation.pages.*;
import com.groceryadmin.automation.base.BaseTest;

public class PushNotificationsTestCases extends BaseTest{

	LoginPage lp;
	PushNotifications pn;

	@Test(priority=1, description="Validating the title of push notifications page", groups = {"smoke"})
	public void validateTitleOfThePage() {
		lp = new LoginPage(driver);
		lp.presteps();
		pn = new PushNotifications(driver);
		String actualTitle  = pn.verifyTitleOfPage();
		String expectedTitle = Constants.EXPECTED_TITLE_PUSH_NOTIFICATIONS;
		Assert.assertEquals(actualTitle, expectedTitle,Constants.TITLE_ERROR);
	}
	
	@Test(priority=2, description="Validating the color of mandatory field", groups = {"sanity"})
	public void validateColorOfMandatoryField() {
		lp = new LoginPage(driver);
		lp.presteps();
		pn = new PushNotifications(driver);
		String actualFieldColor  = pn.verifyStylePropertyOfMandatoryField();
		String expectedFieldColor = Constants.EXPECTED_MANDATORY_FIELD_CLR;
		Assert.assertEquals(actualFieldColor, expectedFieldColor,Constants.STYLE_ERROR);
	}

	@Test(priority=3, description="Validating the color of send button", groups = {"sanity"})
	public void validateColorOfSendButton() {
		lp = new LoginPage(driver);
		lp.presteps();
		pn = new PushNotifications(driver);
		String actualColor  = pn.verifyStylePropertyOfSendButton();
		String expectedColor = Constants.EXPECTED_SENDBTN_CLR;
		Assert.assertEquals(actualColor, expectedColor,Constants.STYLE_ERROR);
	}

	@Test(priority=4, description="Validating the text of alert message", groups = {"regression"})
	public void validateAlertMessage() {
		lp = new LoginPage(driver);
		lp.presteps();
		pn = new PushNotifications(driver);
		String actualMsg  = pn.verifyAlertMessage();
		String expectedMsg = Constants.EXPECTED_ALERT_MSG;
		Assert.assertEquals(actualMsg, expectedMsg,Constants.ALERT_MSG_ERROR);
	}

	@Test(priority=5, description="Validating the background color of alert message", groups = {"regression"})
	public void validateAlertMsgBgColor() {
		lp = new LoginPage(driver);
		lp.presteps();
		pn = new PushNotifications(driver);
		String actualBgColor  = pn.verifyBgColorOfAlertMsg();
		String expectedBgColor = Constants.EXPECTED_ALERT_BGCLR;
		Assert.assertEquals(actualBgColor, expectedBgColor,Constants.STYLE_ERROR);
	}


}
