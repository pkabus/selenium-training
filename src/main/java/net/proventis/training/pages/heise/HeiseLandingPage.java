package net.proventis.training.pages.heise;

import org.openqa.selenium.WebDriver;

import net.proventis.training.pages.supertype.AbstractHeisePage;

/**
 * Page Object Model for the start page of heise.de.
 * 
 * @author pkabus
 *
 */
public class HeiseLandingPage extends AbstractHeisePage {

	/**
	 * Constructor.
	 * 
	 * @param driver
	 *            driver
	 */
	public HeiseLandingPage(final WebDriver driver) {
		super(driver);
	}

	/* TODO EXERCISE 1 & 2 */

	/**
	 * EXERCISE 3
	 * 
	 * @return self-reference
	 */
	public HeiseLandingPage clickTopDownloads() {
		/* TODO implement method */
		return this;
	}

}
