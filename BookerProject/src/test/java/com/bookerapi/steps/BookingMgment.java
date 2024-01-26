package com.bookerapi.steps;

import java.io.File;
import java.util.Map;

import com.bookerapi.configuration.ConfigurationManager;
import com.github.fge.jsonschema.messages.JsonSchemaValidationBundle.*;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

// TODO: Auto-generated Javadoc
/**
 * The Class BookingMgment.
 * 
 *  @author Sandhiya
 */
public class BookingMgment extends Common {

	/**
	 * Health check.
	 */
	@When("get bookingapi health")
	public void healthCheck() {
		response = RestAssured.given().contentType(ContentType.JSON).when().get(ConfigurationManager.configuration().getHealthCheckPath());
		response.then().assertThat().statusCode(201);
	}

	/**
	 * Validate response.
	 *
	 * @param statusCode the status code
	 */
	@Then("Validate response code as {int}")
	public void validateResponse(int statusCode) {
		response.then().assertThat().statusCode(statusCode);
	}

	/**
	 * Creates the booking with string body.
	 *
	 * @param body the request body
	 */
	@When("Create booking with string body {string}")
	public void createBookingWithStringBody(String body) {
		input = RestAssured.given().contentType(ContentType.JSON).when().body(body);
		response = input.post(ConfigurationManager.configuration().getBookingPath());
		//response.prettyPrint();
		bookingID = response.jsonPath().get("bookingid");
	}

	/**
	 * Createbooking with multiple files.
	 *
	 * @param fileName the JSON file name that contains the request body
	 */
	@When("create booking with file {string}")
	public void createbookingWithMultipleFiles(String fileName) {
		File file = new File(ConfigurationManager.configuration().getResourcePath() + fileName);
		input = RestAssured.given().contentType(ContentType.JSON).when().body(file);
		response = input.post(ConfigurationManager.configuration().getBookingPath());
		//response.prettyPrint();
	}

	/**
	 * Update booking with file.
	 *
	 * @param fileName the JSON file name that contains the request body
	 */
	@When("update Booking with file {string}")
	public void updateBookingWithFile(String fileName) {
		File file = new File(ConfigurationManager.configuration().getResourcePath() + fileName);
		input = RestAssured.given().header("Authorization", ConfigurationManager.configuration().getAuthValue())
				.header("Cookie", "token=abc123").contentType(ContentType.JSON).body(file);
		response = input.put(ConfigurationManager.configuration().getBookingPath()+"/" + bookingID);
		//response.prettyPrint();
	}

	/**
	 * Gets the booking with query params.
	 *
	 * @param dt the DataTable
	 */
	@When("get BookingIds with queryparams")
	public void getBookingWithQueryParams(DataTable dt) {
		Map<String, String> QP = dt.asMap();
		response = RestAssured.given().queryParams(QP).get(ConfigurationManager.configuration().getBookingPath());
	}

	/**
	 * Gets the booking by ID.
	 *
	 */
	@When("get Booking detail by ID")
	public void getBookingByID() {
		response = RestAssured.get(ConfigurationManager.configuration().getBookingPath()+"/" + bookingID);
		//response.prettyPrint();
	}

	/**
	 * Validate schema.
	 *
	 * @param fileName the JSON file name containing the schema
	 */
	@Then("Validate the schema of the response using file {string}")
	public void validateSchema(String fileName) {
		File schema = new File(ConfigurationManager.configuration().getResourcePath() + fileName);
		response.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(schema));
	}
}
