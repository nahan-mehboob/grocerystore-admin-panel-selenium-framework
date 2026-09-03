package com.groceryadmin.automation.tests;

import java.awt.AWTException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.groceryadmin.automation.constants.Constants;
import com.groceryadmin.automation.pages.*;
import com.groceryadmin.automation.base.BaseTest;
import com.groceryadmin.automation.listeners.RetryAnalyzer;

public class ManageProductTestCases extends BaseTest{

	LoginPage lp;
	ManageProduct mp;

	@Test(priority =1, description = "Validating whether veg is selected by default", groups = {"sanity"})
	public void validateVegIsSelectedByDefault() {
		lp = new LoginPage(driver);
		lp.presteps();
		mp = new ManageProduct(driver);
		Boolean actualStatus = mp.verifyVegIsSelectedByDefault();
		Assert.assertTrue(actualStatus, Constants.RADIO_BTN_ERROR);
	}

	@Test(priority =2, description = "Validating whether yes button is selected by default for stock", groups = {"sanity"})
	public void validateStockIsYesByDefault() {
		lp = new LoginPage(driver);
		lp.presteps();
		mp = new ManageProduct(driver);
		Boolean actualStatus = mp.verifyStockIsYesByDefault();
		Assert.assertTrue(actualStatus, Constants.RADIO_BTN_ERROR);
	}

	@Test(priority =3, description = "Validating the font color of save button", groups = {"sanity"})
	public void validateStylePropertyOfSaveButton() {
		lp = new LoginPage(driver);
		lp.presteps();
		mp = new ManageProduct(driver);
		String actualColor = mp.verifyStylePropertyOfSaveButton();
		String expectedColor = Constants.EXPECTED_SAVEBTN_COLOR;
		Assert.assertEquals(actualColor, expectedColor, Constants.STYLE_ERROR);
	}

	@Test(priority =4, description = "Validating whether the uploaded file is previewed", retryAnalyzer = RetryAnalyzer.class, groups = {"regression"})
	public void validateUploadedFileIsPreviewDisplayed() throws AWTException, InterruptedException {
		lp = new LoginPage(driver);
		lp.presteps();
		mp = new ManageProduct(driver);
		Boolean actualStatus = mp.verifyUploadedFileIsPreviewDisplayed();
		Assert.assertTrue(actualStatus, Constants.IMAGE_DISPLAY_ERROR);
	}
}
