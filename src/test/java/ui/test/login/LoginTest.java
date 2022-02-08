package ui.test.login;

import org.junit.Test;
import org.openqa.selenium.By;

import ui.helper.Constants;
import ui.helper.TestHelper;
import ui.page.LoginPage;

public class LoginTest extends TestHelper {

	@Test
	public void loginWithValidData() {
		// Navigate to saucedemo.com
		LoginPage loginPage = new LoginPage(driver);
		loginPage.submitLogin(Constants.USERNAME, Constants.PASSWORD);
		// verify cart icon shows
		verifyTrue("Cart not found after login", driver.findElement(By.id("shopping_cart_container")).isDisplayed());
	}

	@Test
	public void loginWithInvalidDataShouldNotBeSuccessful() {
		String expectedErrorMessage = "Epic sadface: Username and password do not match any user in this service";
		// Navigate to saucedemo.com
		LoginPage loginPage = new LoginPage(driver);
		loginPage.submitLogin("standard_user", "fake_password");
		// Get error message
		String actualErrorMessage = driver.findElement(By.cssSelector(".login-box h3[data-test='error']")).getText();
		// Verify VALID error message showed
		verifyEquals("Login error message not matched.", expectedErrorMessage, actualErrorMessage);
	}
}