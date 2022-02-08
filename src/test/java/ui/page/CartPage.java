package ui.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import ui.helper.PageHelper;

public class CartPage extends PageHelper {
	public CartPage(WebDriver driver) {
		super(driver);
	}

	public String getCartProductQuantity() {
		return driver.findElement(By.className("cart_quantity")).getText();
	}

	public String getCartProductName() {
		return driver.findElement(By.className("inventory_item_name")).getText();
	}

	public String getCartProductPrice() {
		return driver.findElement(By.className("invrntory_item-price")).getText();
	}

	public boolean isContinueButtonDisplayed() {
		return driver.findElement(By.id("continue-shopping")).isDisplayed();
	}

	public boolean isCheckoutButtonDisplayed() {
		return driver.findElement(By.id("checkout")).isDisplayed();
	}
}
