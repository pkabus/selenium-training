package net.proventis.training.pages.supertype;

import org.openqa.selenium.WebDriver;

/**
 * Abstract heise page object model.
 * 
 * @author pkabus
 *
 */
public abstract class AbstractHeisePage extends AbstractPage {

	/**
	 * Constructor.
	 * 
	 * @param driver
	 *            driver to use
	 */
	public AbstractHeisePage(final WebDriver driver) {
		super(driver);
	}

	@Override
	public AbstractHeisePage goTo() {
		getDriver().get("https://www.heise.de");
		return this;
	}
}
