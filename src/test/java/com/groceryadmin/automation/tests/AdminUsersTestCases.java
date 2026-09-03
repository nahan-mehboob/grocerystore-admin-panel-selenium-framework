package com.groceryadmin.automation.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.groceryadmin.automation.constants.Constants;
import com.groceryadmin.automation.pages.*;
import com.groceryadmin.automation.base.BaseTest;

public class AdminUsersTestCases extends BaseTest {

	LoginPage lp;
	AdminUsers au;

	@Test(priority = 1, description = "validating a user profile already exists while using faker class", groups = {"regression"})
	public void validateAdminProfileWithFaker() {
		lp = new LoginPage(driver);
		lp.presteps();
		au = new AdminUsers(driver);
		String actualAlert = au.verifyAdminProfileWithFaker();
		String expectedAlert = Constants.EXPECTED_USER_ADMIN_ALERT;
		Assert.assertEquals(actualAlert, expectedAlert, Constants.ALERT_MSG_ERROR);
	}

	@Test(priority = 2, description = "validating a user profile already exists", groups = {"regression"})
	public void validateAdminProfileAlreadyExists() {
		lp = new LoginPage(driver);
		lp.presteps();
		au = new AdminUsers(driver);
		String actualAlert = au.verifyAdminProfileAlreadyExists();
		String expectedAlert = Constants.EXPECTED_USER_ADMIN_ALERT;
		Assert.assertNotEquals(actualAlert, expectedAlert, Constants.ALERT_MSG_ERROR);
	}
}
