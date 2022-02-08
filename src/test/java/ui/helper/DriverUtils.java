package ui.helper;

import org.apache.commons.lang.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import static ui.helper.Constants.DEFAULT_DRIVER_TYPE;
import io.github.bonigarcia.wdm.WebDriverManager;


public class DriverUtils {
	private static WebDriver driver = null;
	private static Logger log = LogManager.getLogger(DriverUtils.class);

	public static WebDriver loadDriver() {

		String driverType = System.getProperty("DRIVER_TYPE");

		if (StringUtils.isBlank(driverType)) {
			// Set a default browser type
			driverType = Constants.DEFAULT_DRIVER_TYPE;
			log.info("DRIVER_TYPE not set. Using deafault driver type: {}", driverType);
		}

		if (driverType.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (driverType.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (driverType.equals("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		} else if (driverType.equals("safari")) {
			WebDriverManager.safaridriver().setup();
			driver = new SafariDriver();
		}

		if (driver == null) {
			log.error("Failed to load driver: {}", driverType);
		}

		log.info("Running tests on: {}", driverType);
		return driver;
	}

}
