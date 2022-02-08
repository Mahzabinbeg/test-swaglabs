package ui.helper;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.ErrorCollector;
import org.openqa.selenium.WebDriver;

public class TestHelper {
	public WebDriver driver;

	@Rule
	public ErrorCollector error = new ErrorCollector();

	private String url = EnvironmentUtils.getEnvironmentProperties("url");

	@Before
	public void setupDriver() {
		// From run-time environment: test, dev, preprod, uat, prod

		// Open browser
		driver = DriverUtils.loadDriver();

		// Navigate to saucedemo.com
		driver.get(url);
	}

	@After
	public void teardownDriver() {
		driver.quit();
	}

	public void verifyEquals(String message, String expected, String actual) {
		try {
			Assert.assertEquals(message, expected, actual);
		} catch (Error e) {
			// catch error
			error.addError(e);
			// capture screenshot
		}
	}

	public void verifyTrue(String message, boolean isTrue) {
		try {
			assertTrue(message, isTrue);
		} catch (AssertionError e) {
			error.addError(e);
			// capture screenshot
		}
	}

}
