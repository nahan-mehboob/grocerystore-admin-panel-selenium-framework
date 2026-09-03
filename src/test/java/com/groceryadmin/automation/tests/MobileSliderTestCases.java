package com.groceryadmin.automation.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.groceryadmin.automation.constants.Constants;
import com.groceryadmin.automation.pages.*;
import com.groceryadmin.automation.base.BaseTest;

public class MobileSliderTestCases extends BaseTest {

	LoginPage lp;
	MobileSlider ms;

	@Test(priority=1, description="Validating the title of mobile slider page", groups = {"smoke"})
	public void validateTitleOfThePage() {
		lp = new LoginPage(driver);
		lp.presteps();
		ms = new MobileSlider(driver);
		String actualTitle = ms.verifyTitleOfPage();
		String expectedTitle = Constants.EXPECTED_TITLE_MOBILE_SLIDER;
		Assert.assertEquals(actualTitle, expectedTitle, Constants.TITLE_ERROR);
	}

	@Test(priority=2, description="Validating whether the first image is displayed", groups = {"smoke"})
	public void validateImageDisplay() {
		lp = new LoginPage(driver);
		lp.presteps();
		ms = new MobileSlider(driver);
		Boolean actualResult = ms.verifyImageIsDisplayed();
		Assert.assertTrue(actualResult, Constants.IMAGE_DISPLAY_ERROR);
	}

	@Test(priority=3, description="Validating the status of first image", groups = {"sanity"})
	public void validateStatusOfFirstImage() {
		lp = new LoginPage(driver);
		lp.presteps();
		ms = new MobileSlider(driver);
		String actualImageStatus = ms.verifyStatusOfFirstImage();
		String expectedImageStatus = Constants.EXPECTED_IMAGE_STATUS;
		Assert.assertEquals(actualImageStatus, expectedImageStatus, Constants.IMAGE_STATUS_ERROR);
	}



}
