package com.groceryadmin.automation.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.groceryadmin.automation.constants.Constants;
import com.groceryadmin.automation.pages.*;
import com.groceryadmin.automation.base.BaseTest;

public class ManageDeliveryBoyTestCases extends BaseTest {

	LoginPage lp;
	ManageDeliveryBoy mdb;

	@Test(priority = 1, description = "Tool kit validation", groups = {"smoke"})
	public void validateToolKit() throws InterruptedException {
		lp = new LoginPage(driver);
		lp.presteps();
		mdb = new ManageDeliveryBoy(driver);
		String actualToolKit = mdb.verifyToolKit();
		String expectedToolKit = Constants.EXPECTED_SHOW_DETAILS;
		Assert.assertEquals(actualToolKit, expectedToolKit, Constants.TOOL_KIT_ERROR);
	}
	
	@Test(priority=2, description="Validating whether the search button is enabled", groups = {"smoke"})
	public void validateSearchButtonClickability() {
		lp = new LoginPage(driver);
		lp.presteps();
		mdb = new ManageDeliveryBoy(driver);
		Boolean actualResult = mdb.verifySearchButtonClickability();
		Assert.assertTrue(actualResult, Constants.CLICK_ERROR);
	}

	@Test(priority = 3, description = "Validating the color property of search button", groups = {"sanity"})
	public void validateSearchButtonColor() {
		lp = new LoginPage(driver);
		lp.presteps();
		mdb = new ManageDeliveryBoy(driver);
		String actualColor = mdb.stylePropertyVerification();
		String expectedColor = Constants.EXPECTED_SEARCHBTN_COLOR;
		Assert.assertEquals(actualColor, expectedColor, Constants.STYLE_ERROR);
	}


}
