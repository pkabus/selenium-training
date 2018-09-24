package net.proventis.training.pages.supertype;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractPage {

	private WebDriver driver;
	private WebDriverWait wait;

	/**
	 * Constructor.
	 * 
	 * @param driver
	 *            driver to use
	 */
	public AbstractPage(final WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		this.wait = new WebDriverWait(driver, 30);
	}

	/**
	 * Returns this page's driver.
	 * 
	 * @return the web driver
	 */
	protected WebDriver getDriver() {
		return driver;
	}

	/**
	 * Returns this page's web driver wait.
	 * 
	 * @return the web driver wait
	 */
	protected WebDriverWait getDriverWait() {
		return wait;
	}
}
