package net.proventis.training.pages.supertype;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Abstract page object model.
 * 
 * @author pkabus
 *
 */
public abstract class AbstractPage {

	private final WebDriver driver;
	private final WebDriverWait wait;

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

	public abstract AbstractPage goTo();

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
