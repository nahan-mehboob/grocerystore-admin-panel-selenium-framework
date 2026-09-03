package com.groceryadmin.automation.pages;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.groceryadmin.automation.utils.GeneralUtilities;

public class ManageLocation {

	WebDriver driver;
	GeneralUtilities gu = new GeneralUtilities();

	public ManageLocation(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "(//p[text()='Manage Location'])[1]")
	WebElement manageLocation;

	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']//tbody//tr//td[5]")
	WebElement statusColumn;

	@FindBy(xpath = "(//i[@class='fas fa-edit'])[2]")
	WebElement editBtn;

	@FindBy(xpath = "//select[@name='state_id']")
	WebElement stateDropdown;

	public Boolean verifyCountOfActiveStatus() {
		gu.clickOnElement(manageLocation);
		List<WebElement> list = driver.findElements(By.xpath("//table[@class='table table-bordered table-hover table-sm']//tbody//tr//td[5]"));
		int size = list.size();
		int count = 0;
		for (int i=0; i<size; i++) {
			String x = list.get(i).getText();
			if(x.equals("Active")) {
				count++;
			}
		}
		if(count==17) {
			return true;
		}
		else {
			return false;
		}
	}

	public String verifyStateNameFromDropdown() {
		gu.clickOnElement(manageLocation);
		gu.clickOnElement(editBtn);
		gu.clickOnElement(stateDropdown);
		gu.selectFuncbyViText(stateDropdown, "Belfast");
		return gu.getFirstSelectedOption(stateDropdown);
	}
}
