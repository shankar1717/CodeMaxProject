package com.qa.test;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EmptyFieldsTest extends BaseClass {
	Select s;

	@Test
	public void test3() throws Exception {

		// Salutation
		WebElement salutation = driver.findElement(By.xpath("//select[@name='salutation']"));
		s = new Select(salutation);
		s.selectByVisibleText(salutationValue);

		// FirstName
		WebElement firstName = driver.findElement(By.xpath("//input[@id='firstname']"));
		firstName.sendKeys(firstNameValue);

		// LastName
		WebElement lastName = driver.findElement(By.xpath("//input[@id='lastname']"));
		lastName.sendKeys(lastNameValue);

		// Email
		WebElement email = driver.findElement(By.xpath("//input[@id='email']"));
		email.sendKeys(emailValue);

		// PhoneNumber
		WebElement phoneNumber = driver.findElement(By.xpath("//input[@id='PN']"));
		phoneNumber.sendKeys(phoneNumberValue);

		// DOB
		WebElement dob = driver.findElement(By.xpath("//div[@class='form-group']//input[@type='date']"));
		dob.sendKeys(dateOfBirthValue);

		// Address
		WebElement address = driver.findElement(By.xpath("//input[@placeholder='Enter Address']"));
		address.sendKeys(addressValue);

		// City
		WebElement cityElement = driver.findElement(By.xpath("//input[@name='city']"));
		cityElement.sendKeys(cityValue);

		// State
		WebElement StateElement = driver.findElement(By.xpath("//input[@name='state']"));
		StateElement.sendKeys(stateValue);

		// ZipCode
		WebElement zipCode = driver.findElement(By.xpath("//input[@name='zipcode']"));
		zipCode.sendKeys(zipCodeValue);

		// Country
		WebElement countryElement = driver.findElement(By.xpath("//select[@id='Country']"));
		s = new Select(countryElement);
		s.selectByVisibleText(countryValue);

		// Next
		Thread.sleep(3000);
		WebElement nextButton = driver.findElement(By.xpath("//*[@id='renderButton']"));
		nextButton.click();

		System.out.println("Personal Details Entered");

		// Dep Date
		WebElement depDate = driver.findElement(By.xpath("//input[@name='departure_date']"));
		depDate.sendKeys("13032024");

		// return Date
		// WebElement returnDate =
		// driver.findElement(By.xpath("//input[@name='return_date']"));
		// returnDate.sendKeys("15032024");

		// dep City
		// WebElement depCity =
		// driver.findElement(By.xpath("//input[@name='departure_city']"));
		// depCity.sendKeys("Chennai");

		// dep Country
		WebElement depCountry = driver.findElement(By.xpath("//select[@name='departure_country']"));
		s = new Select(depCountry);
		s.selectByVisibleText("India");

		// destination City
		WebElement desCity = driver.findElement(By.xpath("//input[@name='destination_city']"));
		desCity.sendKeys("Dallas");

		// Destination Country
		WebElement desCountry = driver.findElement(By.xpath("//select[@name='destination_country']"));
		s = new Select(desCountry);
		s.selectByVisibleText("USA");

		// Booking Class
		WebElement BookingClass = driver
				.findElement(By.xpath("//div[@id='bookingclass']//input[@value='First class']"));
		BookingClass.click();

		// Ticket Type
		WebElement ticketType = driver.findElement(By.xpath("//div[@id='tickettype']//input[@value='One Way']"));
		ticketType.click();

		// file
		// Locate the file input element
		WebElement fileInput = driver.findElement(By.xpath("//input[@id='formFile']"));
		// fileInput.click();

		// Specify the file path
		String filePath = System.getProperty("user.dir") + "//excel//man-.jpg";
		// String filePath = "C:\\Users\\shankar\\Desktop";

		// Send the file path to the file input element
		fileInput.sendKeys(filePath);

		// Payment Button
		WebElement paymentButton = driver.findElement(By.id("paymentbtn"));
		paymentButton.click();

		// Amount
		WebElement amount = driver.findElement(By.xpath("//input[@name='amount']"));
		amount.sendKeys("10000");

		// Currency
		WebElement currency = driver.findElement(By.xpath("//select[@id='currency']"));
		s = new Select(currency);
		s.selectByVisibleText("INR");

		// Submit Button
		WebElement Submitbutton = driver.findElement(By.xpath("//button[@id='submitbtn']"));

		Actions a = new Actions(driver);
		a.moveToElement(Submitbutton).build().perform();

		Submitbutton.click();

		System.out.println("------------------------------------------------");
		List<WebElement> errorMessage1 = driver.findElements(By.xpath("//label[@class='error']"));
		for (WebElement errorelement : errorMessage1) {
			log.error("Error Message : " + errorelement.getText());
			Assert.assertTrue(errorelement.isDisplayed(), "Validation error message not found for empty Fields");
			log.info("---------------------------------------------");

		}
		screenshot("EmptyFields-ErrorMeaage");
	}

	private void screenshot(String scrrenshotName) {
		// Get the driver from the Baseclass
		// WebDriver driver = getDriver();

		// TakesScreenshot is an interface of Selenium that captures the screenshot
		TakesScreenshot ts = (TakesScreenshot) driver;

		// Call getScreenshotAs method to create an image file
		File source = ts.getScreenshotAs(OutputType.FILE);

		// Define the path where you want to save the screenshot
		String screenshotPath = System.getProperty("user.dir") + "/screenshots/" + scrrenshotName + ".png";

		// Create a destination file
		File destination = new File(screenshotPath);

		try {
			// Use FileUtils.copyFile method to save the screenshot at the desired location
			FileUtils.copyFile(source, destination);
			log.info("Screenshot captured: " + scrrenshotName);
		} catch (IOException e) {
			e.printStackTrace();
		}
		// System.out.println("Screenshot taken at: " + screenshotPath);
	}

}
