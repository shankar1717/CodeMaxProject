package com.qa.test;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import com.qa.utilities.ExcelDataReader;
import com.qa.utilities.ReadConfig;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public WebDriver driver;
	WebDriverWait wait;
	public Select s;
	// ---------Data From Excel Sheet Personal Details---------------
	public String salutationValue;
	public String firstNameValue;
	public String lastNameValue;
	public String emailValue;
	public String phoneNumberValue;
	public String dateOfBirthValue;
	public String addressValue;
	public String cityValue;
	public String stateValue;
	public String zipCodeValue;
	public String countryValue;
	// ---------Data From Excel Sheet Filght Details------------------
	public ReadConfig rd = new ReadConfig();
	public String DepartureCity = rd.getDepartureCity();
	public String DepartureCountry = rd.getDepartureCountry();
	public String DestinationCity = rd.getDestinationCity();
	public String DestinationCountry = rd.getDestinationCountry();
	public String BookingClass = rd.getBookingClass();
	public String TicketType = rd.getTicketType();
	public String Amount = rd.getAmount();
	public String Currency = rd.getCurrency();

	@BeforeClass
	public void setUp() throws IOException {

		// Use WebDriverManager to setup chromedriver
		WebDriverManager.chromedriver().setup();
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("https://flight-reservation.cx24.net");
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		ExcelDataReader e = new ExcelDataReader();
		ArrayList<ArrayList<String>> excelData = e.getXl_Customer1();
		System.out.println(excelData);
		for (ArrayList<String> formData : excelData) {
			salutationValue = formData.get(0);
			firstNameValue = formData.get(1);
			lastNameValue = formData.get(2);
			emailValue = formData.get(3);
			phoneNumberValue = formData.get(4);
			dateOfBirthValue = formData.get(5);
			addressValue = formData.get(6);
			cityValue = formData.get(7);
			stateValue = formData.get(8);
			zipCodeValue = formData.get(9);
			countryValue = formData.get(10);

		}
	}

	@AfterClass
	public void tearDown() {
//		if (driver != null) {
//			driver.quit();
//		}
	}
}
