package com.groceryadmin.automation.tests;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.groceryadmin.automation.constants.Constants;
import com.groceryadmin.automation.pages.*;
import com.groceryadmin.automation.base.BaseTest;

public class ManageExpenseTestCases extends BaseTest{

	LoginPage lp;
	ManageExpense me;

	@Test(priority = 1, description = "Validating whether product title already exists", groups = {"regression"})
	public void validatingTheProductTitleAlreadyExists() throws InterruptedException {
		lp = new LoginPage(driver);
		lp.presteps();
		me = new ManageExpense(driver);
		String actualAlert = me.verifyTheProductTitleAlreadyExists();
		SoftAssert softAssert = new SoftAssert();
		String expectedAlert = Constants.EXPECTED_NEW_TITLE_ALERT;
		softAssert.assertNotEquals(actualAlert, expectedAlert,Constants.ALERT_MSG_ERROR);
		softAssert.assertAll();
	}



}
