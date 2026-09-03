package com.groceryadmin.automation.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.groceryadmin.automation.constants.Constants;
import com.groceryadmin.automation.pages.*;
import com.groceryadmin.automation.base.BaseTest;

public class HomeTestCases extends BaseTest{

	LoginPage lp;
	HomePage hp;

	@Test(priority=1, description="Validating the background color of home page", groups = {"sanity"})
	public void homeBgColorValidation() {
		lp = new LoginPage(driver);
		lp.presteps();
		hp = new HomePage(driver);
		String actualBgColor = hp.stylePropertyVerificationOfHome();
		String expectedBgColor = Constants.EXPECTED_BG_COLOR;
		Assert.assertEquals(actualBgColor, expectedBgColor, Constants.STYLE_ERROR);
	}

	@Test(priority=2, description="Validating the text of manage expense", groups = {"sanity"})
	public void manageExpenseTextValidation() {
		lp = new LoginPage(driver);
		lp.presteps();
		hp = new HomePage(driver);
		String expectedText_ME = hp.manageExpenseTextVerification();
		String actualText_ME = Constants.MANAGE_EXPENSE_TEXT;
		Assert.assertEquals(actualText_ME, expectedText_ME, Constants.WRONG_TEXT_ERROR);
	}

	@Test(priority=3, description="Validating the text of manage users", groups = {"smoke"})
	public void manageUsersTextValidation() {
		lp = new LoginPage(driver);
		lp.presteps();
		hp = new HomePage(driver);
		String expectedText_MU = hp.manageUsersTextVerification();
		String actualText_MU = Constants.MANAGE_USERS_TEXT;
		Assert.assertEquals(actualText_MU, expectedText_MU, Constants.WRONG_TEXT_ERROR);
	}


}
