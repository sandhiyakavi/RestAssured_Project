package com.bookerapi.services;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.Test;

import com.bookerapi.configuration.ConfigurationManager;

import io.restassured.RestAssured;

// TODO: Auto-generated Javadoc
/**
 * The negative test cases of the Booking api are added under this class
 * 
 * @author Sandhiya
 */
public class BookingNegativeTest extends BaseRequest {

	/**
	 * Gets the booking with invalid ID.
	 *
	 */
	@Test
	public void getBookingWithInvalidID() {
		RestAssured.given()
		.get(ConfigurationManager.configuration().getBookingPath() + "/"
				+ ConfigurationManager.configuration().getInvalidBookingID())
		.then().assertThat().statusCode(ConfigurationManager.configuration().getNotFoundStatus());
	}

	/**
	 * Update booking with incorrect body.
	 */
	@Test
	public void updateBookingWithIncorrectBody() {
		RestAssured.given().header("Authorization", ConfigurationManager.configuration().getAuthValue())
		.header("Cookie", ConfigurationManager.configuration().getCookieValue()).contentType("application/json")
		.when()
		.body(new File(ConfigurationManager.configuration().getResourcePath() + "PutBookingIncorrectReq.json"))
		.put(ConfigurationManager.configuration().getBookingPath() + "/"
				+ ConfigurationManager.configuration().getValidBookingID())
		.then().assertThat().statusCode(ConfigurationManager.configuration().getBadReqStatus());

	}

	/**
	 * Update booking with invalid ID.
	 */
	@Test
	public void updateBookingWithInvalidID() {
		RestAssured.given().header("Authorization", ConfigurationManager.configuration().getAuthValue())
		.header("Cookie", ConfigurationManager.configuration().getCookieValue()).contentType("application/json")
		.when().body(new File(ConfigurationManager.configuration().getResourcePath() + "UpdateBooking.json"))
		.put(ConfigurationManager.configuration().getBookingPath() + "/"
				+ ConfigurationManager.configuration().getInvalidBookingID())
		.then().assertThat().statusCode(ConfigurationManager.configuration().getMethNotAllowedStatus());
	}

}
