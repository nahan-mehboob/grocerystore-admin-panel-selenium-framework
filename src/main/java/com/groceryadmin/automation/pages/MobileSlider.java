package com.groceryadmin.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.groceryadmin.automation.utils.GeneralUtilities;

public class MobileSlider {

	WebDriver driver;
	GeneralUtilities gu = new GeneralUtilities();

	public MobileSlider(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//p[contains(text(),'Mobile Slider')]")
	WebElement mobileSlider;

	@FindBy(xpath = "//img[@src='https://groceryapp.uniqassosiates.com/public/assets/admin/dist/img/avatar5.png']")
	WebElement firstImage;

	@FindBy(xpath = "//tbody/tr[1]/td[2]/a[1]/span[1]")
	WebElement statusOfImage;

	public String verifyTitleOfPage() {
		gu.clickOnElement(mobileSlider);
		return gu.getTitleOfPage(driver);
	}

	public Boolean verifyImageIsDisplayed() {
		gu.clickOnElement(mobileSlider);
		return gu.elementIsDisplayed(firstImage);
	}

	public String verifyStatusOfFirstImage() {
		gu.clickOnElement(mobileSlider);
		String status = gu.getElementText(statusOfImage);
		return status;
	}
}
