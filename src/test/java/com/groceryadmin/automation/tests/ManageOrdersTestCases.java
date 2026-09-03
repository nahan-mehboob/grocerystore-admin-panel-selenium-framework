package com.groceryadmin.automation.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.groceryadmin.automation.constants.Constants;
import com.groceryadmin.automation.pages.*;
import com.groceryadmin.automation.base.BaseTest;

public class ManageOrdersTestCases extends BaseTest {

	LoginPage lp;
	ManageOrders mo; 
	
	@Test(priority = 1, description = "Validating size of the status dropdown", groups = {"sanity"})
	public void validateSizeOfStatusDropdown() {
		lp = new LoginPage(driver);
		lp.presteps();
		mo = new ManageOrders(driver);
		int actualStatus = mo.verifySizeOfStatusDropdown();
		Assert.assertTrue(actualStatus==Constants.STATUS_DROPDOWN_SIZE,Constants.LIST_SIZE_ERROR);
	}
	
	@Test(priority = 2, description = "Validating whether the payment mode is bank itself while selecting bank from dropdown", groups = {"sanity"})
	public void validatePaymentModeIsBank() {
		lp = new LoginPage(driver);
		lp.presteps();
		mo = new ManageOrders(driver);
		Boolean actualText = mo.verifyPaymentModeIsBank();
		Assert.assertTrue(actualText,Constants.PAYMENT_MODE_ERROR);
	}
	
	@Test(priority = 3, description = "Validating the text of given order id and its payment mode", groups = {"regression"})
	public void validateOrderIdAndPaymentMode() throws InterruptedException {
		lp = new LoginPage(driver);
		lp.presteps();
		mo = new ManageOrders(driver);
		String actualOrderId = mo.verifyOrderId();
		String expectedOrderId = mo.searchOrderId();
		String actualMethod = mo.verifyPaymentMethod();
		String expectedMethod =mo.searchPaymentMode();
		SoftAssert softAssert  = new SoftAssert();
		softAssert.assertEquals(actualOrderId, expectedOrderId,Constants.WRONG_TEXT_ERROR);
		softAssert.assertEquals(actualMethod, expectedMethod, Constants.WRONG_TEXT_ERROR);
		softAssert.assertAll();
	}

	@Test(priority = 4, description = "Validating whether the delete action is successfully performed", groups = {"regression"})
	public void validateDeletionOfProductOrder() throws InterruptedException {
		lp = new LoginPage(driver);
		lp.presteps();
		mo = new ManageOrders(driver);
		String actualStatus = mo.verifyDeletionOfProductOrder();
		String expectedStatus = Constants.EXPECTED_TABLE_RESULT;
		Assert.assertEquals(actualStatus, expectedStatus,Constants.DELETION_ERROR);
	}

		
}
