package com.bookerapi.mock.testcases;

import java.io.File;

import static org.hamcrest.Matchers.containsString;

import org.testng.annotations.Test;

import com.bookerapi.configuration.ConfigurationManager;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

// TODO: Auto-generated Javadoc
/**
 * The Class BookingManagement.
 * 
 * @author Sandhiya
 */
public class BookingManagement {

	/**
	 * Creates the booking.
	 */
	@Test
	public void createBooking() {
		RestAssured.baseURI = ConfigurationManager.configuration().getMockServer();
		RestAssured.given().contentType(ContentType.JSON).when()
		.body(new File(ConfigurationManager.configuration().getResourcePath() + "CreateBooking1.json"))
		.post(ConfigurationManager.configuration().getBookingPath()).then().assertThat()
		.statusCode(ConfigurationManager.configuration().getSuccessStatus())
		.body(containsString("bookingid"), containsString("booking"));

	}

	/**
	 * Gets the booking Ids.
	 *
	 */
	@Test
	public void getBookingIDs() {
		RestAssured.baseURI = ConfigurationManager.configuration().getMockServer();
		RestAssured.given().queryParam("lastName", "brown").get(ConfigurationManager.configuration().getBookingPath())
		.then().assertThat().statusCode(ConfigurationManager.configuration().getSuccessStatus());

	}

	/**
	 * Gets the booking by ID.
	 *
	 */
	@Test
	public void getBookingByID() {
		RestAssured.baseURI = ConfigurationManager.configuration().getMockServer();
		RestAssured.given()
		.get(ConfigurationManager.configuration().getBookingPath() + "/"
				+ ConfigurationManager.configuration().getMockBookingID())
		.then().assertThat().statusCode(ConfigurationManager.configuration().getSuccessStatus());

	}
}
