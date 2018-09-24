package net.proventis.training.pages.google;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import net.proventis.training.pages.supertype.AbstractPage;

/**
 * Page object model for the google search engine.
 * 
 * @author pkabus
 *
 */
public class GooglePage extends AbstractPage {

	@FindBy(name = "q")
	private WebElement searchBox;

	@FindBy(css = "input.lsb")
	private WebElement searchButton;

	@FindBy(className = "rc")
	private List<WebElement> searchResults;

	@FindBy(id = "foot")
	private WebElement footer;

	public GooglePage(final WebDriver driver) {
		super(driver);
	}

	/**
	 * Go to google.com. Use this method to start the test run.
	 */
	@Override
	public GooglePage goTo() {
		this.getDriver().get("https://www.google.com");
		return this;
	}

	/**
	 * Types in the specified search text and clicks the search button.
	 * 
	 * @param text
	 *            text to search
	 */
	public GooglePage searchFor(final String text) {
		this.searchBox.sendKeys(text);
		getDriverWait().until(ExpectedConditions.elementToBeClickable(this.searchButton));
		this.searchButton.click();
		getDriverWait().until(ExpectedConditions.elementToBeClickable(By.className("rc")));
		return this;
	}

	/**
	 * Returns a lis of web elements that contain the single search results.
	 * 
	 * @return list of search results
	 */
	public List<WebElement> getResults() {
		return this.searchResults;
	}

}
