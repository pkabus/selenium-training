package net.proventis.training.pages.heise;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import net.proventis.training.pages.supertype.AbstractHeisePage;

/**
 * Page Object Model for the start page of heise.de.
 * 
 * @author pkabus
 *
 */
public class HeiseLandingPage extends AbstractHeisePage {

	@FindBy(name = "rubriknavi.ho.it")
	private WebElement navIT;

	@FindBy(xpath = "//*[@id='heisetopnavi_search']//input[@name='q']")
	private WebElement searchBox;

	@FindBy(xpath = "//div[@class='search-result']/article/a")
	private List<WebElement> searchResults;

	@FindBy(xpath = "//div[@class='stage--download__col']//a[@class='btn btn-primary']")
	private WebElement downloadsButton;

	/**
	 * Constructor.
	 * 
	 * @param driver
	 *            driver
	 */
	public HeiseLandingPage(final WebDriver driver) {
		super(driver);
	}

	/**
	 * Waits until navigation header named 'IT' is clickable and then clicks it.
	 * 
	 * @return self-reference
	 */
	public AbstractHeisePage clickNavIt() {
		this.getDriverWait().until(ExpectedConditions.elementToBeClickable(navIT));
		this.navIT.click();
		return this;
	}

	/**
	 * Returns the web element which represents the navigation header 'IT'.
	 * 
	 * @return the web element 'IT'
	 */
	public WebElement getNavIt() {
		return this.navIT;
	}

	/**
	 * Searches the given text in the search box and submits the search form.
	 * 
	 * @param text
	 *            to search
	 * @return self-reference
	 */
	public HeiseLandingPage searchFor(final String text) {
		this.getDriverWait().until(ExpectedConditions.elementToBeClickable(searchBox)).sendKeys(text);
		this.searchBox.submit();
		return this;
	}

	/**
	 * EXERCISE 3
	 * 
	 * @return self-reference
	 */
	public HeiseLandingPage clickTopDownloads() {
		this.downloadsButton.click();
		return this;
	}

	/**
	 * Returns the search results.
	 * 
	 * @return list of web elements
	 */
	public List<WebElement> getSearchResults() {
		return this.searchResults;
	}

}
