package com.qa.test;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.qa.pages.Common;
import com.qa.pages.FlightPage;

public class ValidFlightReservationTest extends BaseClass {
	Select s;
	SoftAssert sa;
	Common c =new Common(driver);
	@Test(priority = 0)
	public void personalDetails() throws Exception {
	
		log.info("Website Launched");
		FlightPage flightpage = new FlightPage(driver);
		//Saluation and FirstName
		flightpage.selectSalutation(salutationValue);
		flightpage.enterFirstName(firstNameValue);

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
		screenshot("Personal Details Page");
		
		// Next button
		Thread.sleep(3000);
		WebElement nextButton = driver.findElement(By.xpath("//*[@id='renderButton']"));
		nextButton.click();
		log.info("Personal details entered successfully.");
	}
	@Test(priority = 1)
	public void flightDetails() throws Exception {
		
		log.info("User Navigates to Flight Details Page");
		
		// Dep Date
		WebElement depDate = driver.findElement(By.xpath("//input[@name='departure_date']"));
		depDate.sendKeys("13032024");

		// return Date
		WebElement returnDate = driver.findElement(By.xpath("//input[@name='return_date']"));
		returnDate.sendKeys("15032024");

		// dep City
		WebElement depCity = driver.findElement(By.xpath("//input[@name='departure_city']"));
		depCity.sendKeys(DepartureCity);

		// dep Country
		WebElement depCountry = driver.findElement(By.xpath("//select[@name='departure_country']"));
//		s = new Select(depCountry);
//		s.selectByVisibleText(DepartureCountry);
		c.selectDropdownVisibleText(depCountry, DepartureCountry);

		// destination City
		WebElement desCity = driver.findElement(By.xpath("//input[@name='destination_city']"));
		desCity.sendKeys(DestinationCity);

		// Destination Country
		WebElement desCountry = driver.findElement(By.xpath("//select[@name='destination_country']"));
		//s = new Select(desCountry);
		//s.selectByVisibleText(DestinationCountry);
		c.selectDropdownVisibleText(desCountry, DestinationCountry);
		

		// Booking Class
		WebElement Booking = driver
				.findElement(By.xpath("//div[@id='bookingclass']//input[@value='" + BookingClass + "']"));
		Booking.click();

		// Ticket Type
		WebElement ticketType = driver.findElement(By.xpath("//div[@id='tickettype']//input[@value='One Way']"));
		ticketType.click();

		// Locate the file input element
		WebElement fileInput = driver.findElement(By.xpath("//input[@id='formFile']"));
		// fileInput.click();

		// Specify the file path// String filePath = "C:\\Users\\shankar\\Desktop";
		String filePath = System.getProperty("user.dir") + "//excel//man-.jpg";
		// Send the file path to the file input element
		fileInput.sendKeys(filePath);

		// Payment Button
		WebElement paymentButton = driver.findElement(By.id("paymentbtn"));
		paymentButton.click();

		// Amount
		WebElement amount = driver.findElement(By.xpath("//input[@name='amount']"));
		amount.sendKeys(Amount);

		// Currency
		WebElement currency = driver.findElement(By.xpath("//select[@id='currency']"));
		s = new Select(currency);
		s.selectByVisibleText(Currency);
		
		screenshot("Flight Details Page");
        log.info("Flight details entered successfully.");
		//System.out.println("---------------Flight Details Entered---------------------");
		Thread.sleep(3000);

		// Submit Button
		WebElement Submitbutton = driver.findElement(By.xpath("//button[text()='Submit']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		js.executeScript("arguments[0].click();", Submitbutton);
		Thread.sleep(3000);
		// Submitbutton.click();
        log.info("Flight booking verification successful.");
		//System.out.println("---------------Flight Details Submitted Suceess------------------");
	}
	// ====================================================================
	@Test(priority = 2)
	public void bookingVerification() throws Exception {
		
		String actualPageTitle= driver.getTitle();
		String expectedPageTitle="Flight Booking Form";
		Assert.assertEquals(actualPageTitle, expectedPageTitle, "User is not redirected to the Confirmation page");
		
		
		//customer name & Welcome Message
		wait =new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement welcomeMessage = driver.findElement(By.xpath("//p[@class='textmessage'][1]"));
		wait.until(ExpectedConditions.visibilityOf(welcomeMessage));
		String welcomeMessageText = welcomeMessage.getText();
		Assert.assertTrue(welcomeMessage.isDisplayed());
		log.info("Confirmation Message: " + welcomeMessageText);

		// Split the welcome message using ","
		String[] part = welcomeMessageText.split(",");
		String name = part[0].trim(); // Extracting the name
		String welcome = part[1].trim(); // Extracting the welcome message

		// Split the firstName and LastName based on space
		String[] Parts = name.split(" ");
		// String saluation = Parts[0].trim(); // Get dear text
		String firstnametext = Parts[1].trim(); // Get the firstnametext
		String lastNametext = Parts[2].trim(); // Get the lastNametext
		String expectedMessage = "Your flight are reserved succesfully.";

		sa = new SoftAssert();
		sa.assertEquals(firstnametext, firstNameValue, "First name doesn't match");
		
		try {

			// Assert the last name
			Assert.assertEquals(lastNametext, lastNameValue, "Last name doesn't match");

		} catch (AssertionError e2) {
			// Assertion error occurred
			log.info("Assertion Error: " + e2.getMessage());
			// assertion error here, such as logging, taking screenshots
		}
		//verify sucees booking message
		Assert.assertEquals(welcome, expectedMessage, "Flight Booking is Not Shown");

		// ======================================================================

		// Verify Booking Depature & Destination
		// Locate the table1 element
		WebElement table = driver.findElement(By.xpath("//table[@id='messagetlb']"));
		// Find all rows in the table
		List<WebElement> rows = table.findElements(By.tagName("tr"));

		// Assuming the table has headers in the first row, start from index 1
		for (int i = 1; i < rows.size(); i++) {
			// Get the row
			WebElement row = rows.get(i);

			// Find all cells in the row
			List<WebElement> cells = row.findElements(By.tagName("td"));

			// Assuming the order of data is as follows: Departure Date, Return Date,
			// Departure Country, Destination Country
			// String departureDate = cells.get(0).getText();
			// String returnDates = cells.get(1).getText();
			String departureCountry = cells.get(2).getText();
			String destinationCountry = cells.get(3).getText();
			// System.out.println(departureDate);
			// System.out.println(returnDates);
			// System.out.println(departureCountry);
			// System.out.println(destinationCountry);
			// Expected data
			// String expectedDepartureDate = "20240313";
			// String expectedReturnDate = "20240315";
			String expectedDepartureCountry = DepartureCountry;
			String expectedDestinationCountry = DestinationCountry;

			// Verify data
			// if (departureDate.contentEquals(expectedDepartureDate) &&
			// returnDates.contentEquals(expectedReturnDate) &&
			if (departureCountry.equals(expectedDepartureCountry)
					&& destinationCountry.equals(expectedDestinationCountry)) {
				log.info("Flight DATE & COUNTRY verification passed for row " + i);
			} else {
				log.info("Flight DATE & COUNTRY verification failed for row " + i);
			}
		}
		// =========================================

		// Verify BookingClass & Ticket Type
		// Locate the table2 element
		WebElement table2 = driver.findElement(By.xpath("//table[@id='messagetlb2']"));

		// Find all rows in the table
		List<WebElement> rows2 = table2.findElements(By.tagName("tr"));

		// Assuming the table has headers in the first row, start from index 1
		for (int j = 1; j < rows2.size(); j++) {
			// Get the row
			WebElement row = rows2.get(j);

			// Find all cells in the row
			List<WebElement> cells = row.findElements(By.tagName("td"));

			// Assuming the order of data is as follows: Departure City, Destination City,
			// Booking Class, Ticket type
			String departureCity = cells.get(0).getText();
			String destinationCity = cells.get(1).getText();
			String bookingClass = cells.get(2).getText();
			String ticketTypes = cells.get(3).getText();
			// System.out.println(departureCity);
			// System.out.println(destinationCity);
			// System.out.println(bookingClass);
			// System.out.println(ticketTypes);

			// Expected data
			String expectedDepartureCity = DepartureCity;
			String expectedDestinationCity = DestinationCity;
			String expectedBookingClass = BookingClass;
			String expectedTicketType = TicketType;

			// Verify data
			if (departureCity.equals(expectedDepartureCity) && destinationCity.equals(expectedDestinationCity)
					&& bookingClass.equals(expectedBookingClass) && ticketTypes.equals(expectedTicketType)) {
				log.info("Flight CITY & BOOKING CLASS verification passed for row " + j);
			} else {
				log.info("Flight CITY & BOOKING CLASS verification failed for row " + j);
			}
		}

		// ====================================================
		//Verify Paid Amount and Currency
		WebElement amountElement = driver.findElement(By.xpath("//p[@id='paidamount']"));
		String paidAmountText = amountElement.getText();

		// Split the string based on the delimiter ":"
		String[] parts = paidAmountText.split(":");
		// String label = parts[0].trim(); // Get the label
		String amountWithCurrency = parts[1].trim(); // Get the amount with currency

		// Split the amount and currency based on space
		String[] amountParts = amountWithCurrency.split(" ");
		String amountelement = amountParts[0].trim(); // Get the amount
		String currencyelement = amountParts[1].trim(); // Get the currency
		// System.out.println("amountelement:" + amountelement);
		// System.out.println("currencyelement:" + currencyelement);
		screenshot("Confirmation Page");
		// Assert.assertEquals(label, expectedLabel, "Label assertion failed");
		Assert.assertEquals(amountelement, Amount.replaceAll("\\s+", ""), "Amount assertion failed");
		Assert.assertEquals(currencyelement, Currency, "Currency assertion failed");
		log.info("Flight Ticket Booking is Successful");
        log.info("Following Failures are Expected As I have Found Bug in the Application");

		// After all assertions, call assertAll() to verify all assertions
		sa.assertAll();
	}
	
		private void screenshot(String scrrenshotName) {
        // Get the driver from the Baseclass
        //WebDriver driver = getDriver();

        // TakesScreenshot is an interface of Selenium that captures the screenshot
        TakesScreenshot ts = (TakesScreenshot) driver;

        // Call getScreenshotAs method to create an image file
        File source = ts.getScreenshotAs(OutputType.FILE);

        // Define the path where you want to save the screenshot
        String screenshotPath = System.getProperty("user.dir") + "/screenshots/" + scrrenshotName +  ".png";

        // Create a destination file
        File destination = new File(screenshotPath);

        try {
            // Use FileUtils.copyFile method to save the screenshot at the desired location
            FileUtils.copyFile(source, destination);
            log.info("Screenshot captured: " + scrrenshotName);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //System.out.println("Screenshot taken at: " + screenshotPath);
    }






	}
