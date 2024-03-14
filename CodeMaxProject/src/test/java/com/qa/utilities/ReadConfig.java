package com.qa.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadConfig {

	Properties prop = new Properties();

	public ReadConfig() {

		try {
			FileInputStream source = new FileInputStream(
					System.getProperty("user.dir") + "/configuration/config.properties");
			prop.load(source);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public String getDepartureCity() {
		return prop.getProperty("DepartureCity");
	}

	public String getDepartureCountry() {
		return prop.getProperty("DepartureCountry");
	}

	public String getDestinationCity() {
		return prop.getProperty("DestinationCity");
	}
	public String getDestinationCountry() {
		return prop.getProperty("DestinationCountry");

	}

	public String getBookingClass() {
		return prop.getProperty("BookingClass");
	}
	public String getTicketType() {
		return prop.getProperty("TicketType");

	}
	
	public String getAmount() {
		return prop.getProperty("Amount");
	}
	public String getCurrency() {
		return prop.getProperty("Currency");

	}


	
}
