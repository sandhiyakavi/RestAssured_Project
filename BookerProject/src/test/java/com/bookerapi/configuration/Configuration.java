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
	
	@Key("mock_bookingID")
	String getMockBookingID();
	
	@Key("healthCheck_path")
	String getHealthCheckPath();
	
	@Key("Booking_path")
	String getBookingPath();
	
	@Key("resource_path")
	String getResourcePath();
	
	@Key("auth_value")
	String getAuthValue();
	
	@Key("cookie_value")
	String getCookieValue();

	@Key("badReq_status")
	int getBadReqStatus();
	
	@Key("notFound_status")
	int getNotFoundStatus();
	
	@Key("success_status")
	int getSuccessStatus();
	
	@Key("methodNotAllowed_status")
	int getMethNotAllowedStatus();
}
