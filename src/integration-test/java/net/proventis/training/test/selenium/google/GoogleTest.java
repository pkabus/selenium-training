package net.proventis.training.test.selenium.google;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import net.proventis.training.pages.google.GooglePage;
import net.proventis.training.test.selenium.AbstractWebDriverTest;

/**
 * Test cases related to google.
 * 
 * @author pkabus
 * @version 1.0 Date: 13.06.2018
 */
public class GoogleTest extends AbstractWebDriverTest {

	private GooglePage google;

	/**
	 * First, the super method is called. Afterwards the page object is initialized.
	 */
	@Override
	@Before
	public void setUp() {
		super.setUp();
		google = new GooglePage(getDriver());
	}

	/**
	 * Test case that navigates to the google search engine and asks for search
	 * results. The test case fails, if no search results are being returned by
	 * google for the search key 'automation'.
	 * 
	 * @throws InterruptedException
	 */
	@Test
	public void askGoogleForAutomationTest() throws InterruptedException {
		google.goTo();
		google.searchFor("automation");
		Assert.assertFalse(google.getResults().isEmpty());
	}

}
