package com.groceryadmin.automation.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.groceryadmin.automation.constants.Constants;
import com.groceryadmin.automation.pages.*;
import com.groceryadmin.automation.base.BaseTest;


public class ManageLocationTestCases extends BaseTest{

	LoginPage lp;
	ManageLocation ml;

	@Test(priority = 1,  description = "Validate the count for the status active", groups = {"sanity"})
	public void validateCountOfActiveStatus() {
		lp = new LoginPage(driver);
		lp.presteps();
		ml = new ManageLocation(driver);
		Boolean actualCount = ml.verifyCountOfActiveStatus();
		Assert.assertTrue(actualCount, Constants.WRONG_TEXT_ERROR);
	}

	@Test(priority = 2, description = "Validate the value selected from the  state dropdown", groups = {"sanity"})
	public void validateStateNameFromDropdown() {
		lp = new LoginPage(driver);
		lp.presteps();
		ml = new ManageLocation(driver);
		String actualText = ml.verifyStateNameFromDropdown();
		String expectedText = Constants.EXPECTED_STATE_NAME;
		Assert.assertEquals(actualText,expectedText,Constants.WRONG_TEXT_ERROR);
	}


}
