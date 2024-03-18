package com.qa.pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.test.BaseClass;

public class Common extends BaseClass {

	public WebDriver driver;

	public Common(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	public void selectDropdownVisibleText(WebElement dropdown, String optionText) {
		s = new Select(dropdown);
		s.selectByVisibleText(optionText);

	}
//	public void waitForElementVisibility(WebDriver driver, By locator, int timeoutInSeconds) {
//	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
//	    wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
//	}

//	public void waitForElementVisibility(WebElement element) {
//	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//	    wait.until(ExpectedConditions.visibilityOf(element));
//	}
//
//	public void waitForElementClickable(WebElement element) {
//	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//	    wait.until(ExpectedConditions.elementToBeClickable(element));
//	}


	public void clickElement(WebElement element) {
		element.click();
	}

	
}
