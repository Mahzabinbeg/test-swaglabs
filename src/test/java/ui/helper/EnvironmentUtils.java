package ui.helper;

import java.util.ResourceBundle;

import org.apache.commons.lang.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class EnvironmentUtils {
	private static Logger log = LogManager.getLogger(EnvironmentUtils.class);

	public static String getEnvironmentProperties(String propertyName) {
		String environment = System.getProperty("ENVIRONMENT");
		if (StringUtils.isBlank(environment)) {
			environment = Constants.DEFAULT_ENVIRONMENT;
			log.info("ENVIRONMENT property was not set. Using default environment: {}", environment);
		}
		ResourceBundle resource = ResourceBundle.getBundle(environment.toLowerCase());
		log.info("Running test in: {}", environment);
		return resource.getString(propertyName);
	}
}
