package com.bookerapi.configuration;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.Config.LoadPolicy;
import org.aeonbits.owner.Config.LoadType;

// TODO: Auto-generated Javadoc
/**
 * The Interface Configuration.
 * 
 * @author Sandhiya
 */
@LoadPolicy(LoadType.MERGE)
@Config.Sources({ "system:properties", "classpath:config.properties" })
public interface Configuration extends Config {

	/**
	 * Gets the server.
	 *
	 */
	@Key("server")
	String getServer();

	/**
	 * Gets the mock server.
	 *
	 */
	@Key("mockServer")
	String getMockServer();

	/**
	 * Gets the valid booking ID.
	 *
	 */
	@Key("valid_bookingID")
	String getValidBookingID();

	/**
	 * Gets the invalid booking ID.
	 *
	 */
	@Key("invalid_bookingID")
	String getInvalidBookingID();

	/**
	 * Gets the mock booking ID.
	 *
	 */
	@Key("mock_bookingID")
	String getMockBookingID();

	/**
	 * Gets the health check path.
	 *
	 */
	@Key("healthCheck_path")
	String getHealthCheckPath();

	/**
	 * Gets the booking path.
	 *
	 */
	@Key("Booking_path")
	String getBookingPath();

	/**
	 * Gets the resource path.
	 *
	 */
	@Key("resource_path")
	String getResourcePath();

	/**
	 * Gets the auth value.
	 *
	 */
	@Key("auth_value")
	String getAuthValue();

	/**
	 * Gets the cookie value.
	 *
	 */
	@Key("cookie_value")
	String getCookieValue();

	/**
	 * Gets the bad req status.
	 *
	 */
	@Key("badReq_status")
	int getBadReqStatus();

	/**
	 * Gets the not found status.
	 *
	 */
	@Key("notFound_status")
	int getNotFoundStatus();

	/**
	 * Gets the success status.
	 *
	 */
	@Key("success_status")
	int getSuccessStatus();

	/**
	 * Gets the method not allowed status.
	 *
	 */
	@Key("methodNotAllowed_status")
	int getMethNotAllowedStatus();
}
