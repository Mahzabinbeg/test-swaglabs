package ui.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import ui.helper.PageHelper;

public class ProductPage extends PageHelper {

	public ProductPage(WebDriver driver) {
		super(driver);
	}

	public void clickOnAddToCart(String productName) {
		clickOnElement(By.xpath(
				"//*[@class='inventory_item_name'][contains(text(),'" + productName + "')]//..//..//..//button"));

	}

	public void clickOnCartIcon() {
		clickOnElement(By.className("shopping_cart_link"));
	}

	public String getCartBadgeQuantity() {
		return getText(By.className("shopping_cart_badge"));
	}
}
