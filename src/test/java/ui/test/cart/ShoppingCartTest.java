package ui.test.cart;

import org.junit.Test;

import ui.helper.Constants;
import ui.helper.TestHelper;
import ui.page.CartPage;
import ui.page.LoginPage;
import ui.page.ProductPage;

public class ShoppingCartTest extends TestHelper {

	@Test
	public void shouldBeAbleToAddProductToCart() {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.submitLogin(Constants.USERNAME, Constants.PASSWORD);

		//Add click on[Sauce Labs Backpack] add to cart
		ProductPage productPage = new ProductPage(driver);
		productPage.clickOnAddToCart("Sauce Labs Backpack");

		// Verify cart icon shows quantity [1] badge
		String cartQuantityBadge = productPage.getCartBadgeQuantity();
		verifyEquals("Cart quantity not matched", "1", cartQuantityBadge);
	}

	@Test
	public void verifyShoppingCart() {
		String productName = "Sauce Labs Bike Light";

		LoginPage loginPage = new LoginPage(driver);
		loginPage.submitLogin(Constants.USERNAME, Constants.PASSWORD);
		// Add one of the product to the cart
		ProductPage productPage = new ProductPage(driver);
		productPage.clickOnAddToCart(productName);
		productPage.clickOnCartIcon();
		CartPage cartPage = new CartPage(driver);
		// verify cart
		// Shows quantity in the cart page
		String actualQuantity = cartPage.getCartProductQuantity();
		verifyEquals("Cart quantity not matched", "1", actualQuantity);
		// Shows added product name in the cart page
		String actualProductName = cartPage.getCartProductName();
		verifyEquals("Product name not matched", productName, actualProductName);
		// Shows amount in the cart page
		String cartProductPrice = cartPage.getCartProductPrice();
		verifyEquals("Cart product price not matched", "$1.99", cartProductPrice);
		// Shows continue shopping option in the cart
		boolean continueButton = cartPage.isContinueButtonDisplayed();
		verifyTrue("Continue shopping button not showed.", continueButton);
		// Shows checkout button in the cart
		boolean checkoutButton = cartPage.isCheckoutButtonDisplayed();
		verifyTrue("Checkout button not displayed", checkoutButton);
	}
}
