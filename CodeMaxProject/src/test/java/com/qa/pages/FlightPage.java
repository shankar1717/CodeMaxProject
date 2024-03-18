package com.qa.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.qa.test.BaseClass;




public class FlightPage extends BaseClass {

	WebDriver ldriver;

	public FlightPage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(xpath = "//select[@name='salutation']")
	WebElement salutation;

	@FindBy(xpath = "//input[@id='firstname']")
	WebElement firstName;

	// Add more WebElements and FindBy annotations for other fields on the page

	public void selectSalutation(String string) {
		Select s = new Select(salutation);
		s.selectByVisibleText(string);
	}

	public void enterFirstName(String string) {
		firstName.sendKeys(string);
	}

}
