package com.groceryadmin.automation.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.groceryadmin.automation.constants.Constants;
import com.groceryadmin.automation.pages.*;
import com.groceryadmin.automation.base.BaseTest;

public class SettingsPageTestCases extends BaseTest{

	LoginPage lp;
	SettingsPage sp;

	@Test(priority = 1, description = "Validating whether logout button logs out of the page", groups = {"smoke"})
	public void validateLogout(){
		lp = new LoginPage(driver);
		lp.presteps();
		sp = new SettingsPage(driver);
		String actualUrl = sp.verifyLogout();
		String expectedUrl = Constants.LOGIN_PAGE_URL;
		Assert.assertEquals(actualUrl, expectedUrl, Constants.URL_ERROR);
	}
}
