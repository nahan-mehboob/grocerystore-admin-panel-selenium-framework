package com.groceryadmin.automation.tests;

import java.io.File;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.groceryadmin.automation.constants.Constants;
import com.groceryadmin.automation.pages.*;
import com.groceryadmin.automation.base.BaseTest;
import com.groceryadmin.automation.utils.ExcelUtils;

public class LoginTestCases extends BaseTest{
	LoginPage lp;

	@Test(priority=1, description="Validating the profile name of logged user", groups = {"smoke"})
	public void loggedInProfileNameValidation() {
		lp = new LoginPage(driver);
		lp.presteps();
		String expectedProfileName = Constants.EXPECTED_PROFILE_NAME;
		String actualProfileName = lp.profileNameVerification();
		Assert.assertEquals(actualProfileName, expectedProfileName,Constants.LOGIN_ERROR);
	}

	@Test(priority = 2, description="Login using data provider", dataProvider = "loginData", groups = {"regression"})
	public void loginFailureWithInvalidCredentials(String username, String password) {
		lp = new LoginPage(driver);
		lp.getUserName(username);
		lp.getPassword(password);
		lp.clickSignin();
		Boolean actualResult = lp.signinFailAlert();
		Assert.assertTrue(actualResult,Constants.LOGIN_ERROR);
	}

	@Test(priority=3, description="Validating color property of profile name", groups = {"sanity"})
	public void profileNameStyleValidation() {
		lp = new LoginPage(driver);
		lp.presteps();
		String actualProfileColor = lp.stylePropertyVerification();
		String expectedProfileClr = Constants.EXPECTED_PROFILE_CLR;
		Assert.assertEquals(actualProfileColor, expectedProfileClr,Constants.STYLE_ERROR);
	}

	@Test(priority = 4, description = "Validating whether remember checkbox is unchecked", groups = {"sanity"})
	public void validationOfRememberMeCheckbox() {
		lp = new LoginPage(driver);
		lp.getUserName("admin");
		lp.getPassword("admin");
		Boolean actualStatus = lp.rememberMeCheckboxVerficiation();
		Boolean expectedStatus = false;
		Assert.assertEquals(actualStatus, expectedStatus,Constants.CHECKBOX_ERROR);
	}

	@Test(priority=5, description="Login using excel data", dataProvider = "excelData",groups = {"regression"})
	public void excelRead(String username, String password) {
		lp = new LoginPage(driver);
		lp.excelSteps(username, password);
		String expectedProfileName = Constants.EXPECTED_PROFILE_NAME;
		String actualProfileName = lp.profileNameVerification();
		Assert.assertEquals(actualProfileName, expectedProfileName,Constants.LOGIN_ERROR);
	}
	
	@Test(priority = 6, description = "Validating that login fails when both fields are submitted empty", groups = {"regression","negative"})
	public void validateLoginWithEmptyCredentials() {
		lp = new LoginPage(driver);
		lp.clickSignin();
		Boolean actualResult = lp.signinFailAlert();
		Assert.assertTrue(actualResult, Constants.LOGIN_ERROR);
	}
	
	@Test(priority = 7, description = "Validating that login fails when password field is empty", groups = {"regression","negative"})
	public void validateLoginWithEmptyPassword() {
		lp = new LoginPage(driver);
		lp.getUserName("admin");
		lp.clickSignin();
		Boolean actualResult = lp.signinFailAlert();
		Assert.assertTrue(actualResult, Constants.LOGIN_ERROR);
	}

	@DataProvider(name = "loginData")
	public Object [][] getUserData(){
		return new Object[][] {
			{"admin5", "admin"},
			{"admin", "admin4"},
			{"admin1", "admin2"},
		};
	}

	@DataProvider(name = "excelData")
	public Object[][] getExcelLoginData(){
		String path = System.getProperty("user.dir") + File.separator + "src" + File.separator + "test"
				+ File.separator + "resources" + File.separator + "testdata" + File.separator + "LoginTestData.xlsx";
		return ExcelUtils.getExcelData(path, "Sheet1");
	}
}