package net.proventis.training.test.selenium.general;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import net.proventis.training.test.selenium.AbstractWebDriverTest;

/**
 * A simple test, that shows if a driver can start a browser.
 * 
 * @author pkabus
 *
 */
public class GeneralTest extends AbstractWebDriverTest {

	/**
	 * Try to access a website.
	 */
	@Test
	public void testDriver() {
		this.getDriver().get("http://google.de");
		// wait here
		assertTrue(this.getDriver().getCurrentUrl().contains("google.de"));
	}

}
