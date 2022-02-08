package ui.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import ui.helper.PageHelper;

public class LoginPage extends PageHelper {

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	public void submitLogin(String username, String password) {
		// Enter user name
		setField(By.id("user-name"), username);

		// Enter password
		setField(By.id("password"), password);

		// click on login
		clickOnElement(By.id("login-button"));
	}

}
