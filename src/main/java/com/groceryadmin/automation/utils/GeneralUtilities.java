package com.groceryadmin.automation.utils;


import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class GeneralUtilities {

	public String getElementText(WebElement element) {
		String text = element.getText();
		return text;
	}

	public void clickOnElement(WebElement element) {
		element.click();
	}

	public void sendText(WebElement element, String text) {
		element.sendKeys(text);
	}

	public void submit(WebElement element) {
		element.submit();
	}

	public void clearInputField(WebElement element) {
		element.clear();
	}

	public String gettingTagName(WebElement element) {
		return element.getTagName();
	}

	public Dimension getSizeOfElement(WebElement element) {
		return element.getSize();
	}

	public Point getLocationOfElement(WebElement element) {
		return element.getLocation();
	}

	public String stylePropertyValidation(WebElement element, String propertyType ) {
		return element.getCssValue(propertyType);
	}

	public String toolTip(WebElement element) {
		return element.getAttribute("title");
	}

	public Boolean elementIsEnabled(WebElement element) {
		return element.isEnabled();
	}

	public Boolean elementIsDisplayed(WebElement element) {
		return element.isDisplayed();
	}

	public Boolean elementIsSelected(WebElement element) {
		return element.isSelected();
	}

	public String getTitleOfPage(WebDriver driver) {
		return driver.getTitle();
	}

	public String gettingCurrentUrl(WebDriver driver) {
		return driver.getCurrentUrl();
	}

	public String gettingPageSource(WebDriver driver) {
		return driver.getPageSource();
	}

	public void navigateToThePage(WebDriver driver, String url) {
		driver.navigate().to(url);
	}

	public void navigateBack(WebDriver driver) {
		driver.navigate().back();
	}

	public void navigateForward(WebDriver driver) {
		driver.navigate().forward();
	}

	public void refreshPage(WebDriver driver) {
		driver.navigate().refresh();
	}

	public void keyUpAction(WebDriver driver, CharSequence keyName) {
		Actions a = new Actions(driver);
		a.keyUp(keyName).build().perform();
	}

	public void keyDownAction(WebDriver driver, CharSequence keyName) {
		Actions a = new Actions(driver);
		a.keyDown(keyName).build().perform();
	}

	public void clickAndHoldAction(WebDriver driver, WebElement element) {
		Actions a = new Actions(driver);
		a.clickAndHold(element).build().perform();
	}

	public void contextClickAction(WebDriver driver, WebElement element) {
		Actions a = new Actions(driver);
		a.contextClick(element).build().perform();
	}

	public void doubleClickAction(WebDriver driver, WebElement element) {
		Actions a = new Actions(driver);
		a.doubleClick(element).build().perform();
	}

	public void moveToTheElement(WebDriver driver, WebElement element) {
		Actions a = new Actions(driver);
		a.moveToElement(element).build().perform();
	}

	public void dragandDropElement(WebElement source, WebElement destination, WebDriver driver) {
		Actions a = new Actions(driver);
		a.dragAndDrop(source, destination).perform();
	}

	public void sendKeysUsingAction(WebDriver driver, WebElement element, CharSequence keyName) {
		Actions a = new Actions(driver);
		a.sendKeys(element, keyName);
	}

	public void threadSleep(int x) throws InterruptedException {
		Thread.sleep(x);
	}

	public void scrollToTheElement(WebElement element, WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();",element);
	}

	public void clickOnElementByJavaScript(WebDriver driver, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();",element);
	}

	public void acceptingAlerts(WebDriver driver) {
		driver.switchTo().alert().accept();
	}

	public void dismissingAlerts(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}

	public String getTextOfAlerts(WebDriver driver) {
		return driver.switchTo().alert().getText();
	}

	public void sendTextToAlert(WebDriver driver, String text) {
		driver.switchTo().alert().sendKeys(text);
	}

	public void selectFuncbyindex(WebElement element, int index) {
		Select select = new Select(element);
		select.selectByIndex(index);
	}

	public void deselectFuncbyindex(WebElement element, int index) {
		Select select = new Select(element);
		select.deselectByIndex(index);
	}

	public void selectFuncbyValue(WebElement element, String value) {
		Select select = new Select(element);
		select.selectByValue(value);
	}

	public void deselectFuncbyValue(WebElement element, String value) {
		Select select = new Select(element);
		select.deselectByValue(value);
	}

	public void selectFuncbyViText(WebElement element, String visisbletext) {
		Select select = new Select(element);
		select.selectByVisibleText(visisbletext);
	}

	public void deselectFuncbyViText(WebElement element, String visisbletext) {
		Select select = new Select(element);
		select.deselectByVisibleText(visisbletext);
	}

	public String getFirstSelectedOption(WebElement element) {
		Select select = new Select(element);
		String firstoption = select.getFirstSelectedOption().getText();
		return (firstoption);
	}

	public Boolean isDropdownMultiSelect(WebElement element) {
		Select select = new Select(element);
		return select.isMultiple();
	}

	public void deselectAllOptions(WebElement element) {
		Select select = new Select(element);
		select.deselectAll();
	}

	public void switchToIFrameByIndex(WebDriver driver, int index) {
		driver.switchTo().frame(index);
	}

	public void switchToIFrameByIdOrName(WebDriver driver, String nameOrId) {
		driver.switchTo().frame(nameOrId);
	}

	public void switchToIFrameByElementName(WebDriver driver, WebElement frameElement) {
		driver.switchTo().frame(frameElement);
	}

	public void switchToParentFrame(WebDriver driver) {
		driver.switchTo().parentFrame();
	}

	public void switchToMainPage(WebDriver driver) {
		driver.switchTo().defaultContent();
	}

}