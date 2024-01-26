package com.bookerapi.services;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.BeforeMethod;

import com.bookerapi.configuration.ConfigurationManager;

import io.restassured.RestAssured;

// TODO: Auto-generated Javadoc
/**
 * Setup for BaseURI are added under this class
 * 
 * @author Sandhiya
 */
public class BaseRequest {

	/**
	 * Setup the BaseURI.
	 */
	@BeforeMethod
	public void setup() {
			RestAssured.baseURI = "https://" + ConfigurationManager.configuration().getServer() + "/";
			// RestAssured.authentication = RestAssured.basic(prop.getProperty("username"),
			// prop.getProperty("password"));
	}
}
