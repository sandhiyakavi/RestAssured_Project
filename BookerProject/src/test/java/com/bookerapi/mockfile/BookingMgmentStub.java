package com.bookerapi.mockfile;

import org.testng.annotations.BeforeMethod;

import com.bookerapi.configuration.ConfigurationManager;
import com.github.tomakehurst.wiremock.client.WireMock;

// TODO: Auto-generated Javadoc
/**
 * The Class BookingMgmentStub.
 * 
 * @author Sandhiya
 */
public class BookingMgmentStub {

	/**
	 * Creates the Stub for Create Booking.
	 */
	@BeforeMethod
	public void createBooking() {
		WireMock.stubFor(WireMock.post("/" + ConfigurationManager.configuration().getBookingPath())
				.willReturn(WireMock.aResponse().withStatus(ConfigurationManager.configuration().getSuccessStatus())
						.withBody("{\r\n" + "    \"bookingid\": 2243,\r\n" + "    \"booking\": {\r\n"
								+ "        \"firstname\": \"Kolby\",\r\n" + "        \"lastname\": \"Brown\",\r\n"
								+ "        \"totalprice\": 111,\r\n" + "        \"depositpaid\": true,\r\n"
								+ "        \"bookingdates\": {\r\n" + "            \"checkin\": \"2018-01-01\",\r\n"
								+ "            \"checkout\": \"2019-01-01\"\r\n" + "        },\r\n"
								+ "        \"additionalneeds\": \"Breakfast\"\r\n" + "    }\r\n" + "}")));
	}

	/**
	 * Creates Stub for getting Booking IDs
	 *
	 */
	@BeforeMethod
	public void getBookingIDs() {
		WireMock.stubFor(WireMock.get("/booking?lastName=brown").willReturn(WireMock.aResponse()
				.withStatus(ConfigurationManager.configuration().getSuccessStatus())
				.withBody("[\r\n" + "    {\r\n" + "        \"bookingid\": 5\r\n" + "    },\r\n" + "    {\r\n"
						+ "        \"bookingid\": 159\r\n" + "    },\r\n" + "    {\r\n"
						+ "        \"bookingid\": 201\r\n" + "    },\r\n" + "    {\r\n"
						+ "        \"bookingid\": 51\r\n" + "    },\r\n" + "    {\r\n" + "        \"bookingid\": 89\r\n"
						+ "    },\r\n" + "    {\r\n" + "        \"bookingid\": 71\r\n" + "    },\r\n" + "    {\r\n"
						+ "        \"bookingid\": 375\r\n" + "    },\r\n" + "    {\r\n"
						+ "        \"bookingid\": 83\r\n" + "    },\r\n" + "    {\r\n" + "        \"bookingid\": 37\r\n"
						+ "    },\r\n" + "    {\r\n" + "        \"bookingid\": 373\r\n" + "    },\r\n" + "    {\r\n"
						+ "        \"bookingid\": 119\r\n" + "    },\r\n" + "    {\r\n" + "        \"bookingid\": 4\r\n"
						+ "    },\r\n" + "    {\r\n" + "        \"bookingid\": 73\r\n" + "    }\r\n" + "]")));

	}

	/**
	 * Creates the Stub for getting Booking by ID
	 *
	 */
	@BeforeMethod
	public void getBookingById() {
		WireMock.stubFor(WireMock.get("/booking/2243")
				.willReturn(WireMock.aResponse().withStatus(ConfigurationManager.configuration().getSuccessStatus())
						.withBody("{\r\n" + "    \"firstname\": \"Josh\",\r\n" + "    \"lastname\": \"Allen\",\r\n"
								+ "    \"totalprice\": 111,\r\n" + "    \"depositpaid\": true,\r\n"
								+ "    \"bookingdates\": {\r\n" + "        \"checkin\": \"2018-01-01\",\r\n"
								+ "        \"checkout\": \"2019-01-01\"\r\n" + "    },\r\n"
								+ "    \"additionalneeds\": \"super bowls\"\r\n" + "}")));

	}

}
