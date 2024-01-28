package com.bookerapi.configuration;

import org.aeonbits.owner.ConfigCache;

// TODO: Auto-generated Javadoc
/**
 * The Class ConfigurationManager.
 * 
 * @author Sandhiya
 */
public class ConfigurationManager {

	/**
	 * Configuration.
	 *
	 * @return the configuration
	 */
	public static Configuration configuration() {
		return ConfigCache.getOrCreate(Configuration.class);
	}
}
