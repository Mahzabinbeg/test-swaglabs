package ui.helper;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageHelper {
	protected WebDriver driver;

	public PageHelper(WebDriver driver) {
		this.driver = driver;
	}

	public void setField(By by, String text) {
		driver.findElement(by).clear();
		driver.findElement(by).sendKeys(text);
	}

	public void clickOnElement(By by) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Constants.DEFAULT_TIMEOUT_SECONDS_TEN));
		wait.until(ExpectedConditions.elementToBeClickable(by)).click();
	}

	/**
	 * Get string and trim
	 * 
	 * @param by
	 * @return
	 */
	public String getText(By by) {
		return driver.findElement(by).getText().trim();
	}

	/**
	 * Returns list strings by common locator
	 * 
	 * @param by
	 * @return
	 */
	public List<String> getListOfString(By by) {
		List<String> strings = new ArrayList<String>();
		List<WebElement> elements = driver.findElements(by);
		for (WebElement webElement : elements) {
			strings.add(webElement.getText());
		}
		return strings;
	}
}
