package net.proventis.training.test.selenium.heise;

import static org.junit.Assert.assertFalse;

import org.junit.Before;
import org.junit.Test;

import net.proventis.training.pages.heise.HeiseLandingPage;
import net.proventis.training.test.selenium.AbstractWebDriverTest;

/**
 * Test case(s) for heise.de.
 * 
 * @author pkabus
 *
 */
public class HeiseSearchTest extends AbstractWebDriverTest {

	private HeiseLandingPage heisePage;

	@Before
	@Override
	public void setUp() {
		super.setUp();
		heisePage = new HeiseLandingPage(this.getDriver());
	}

	/**
	 * Your useful test.
	 */
	@Test
	public void testSearchEngine() {
		heisePage.goTo();
		heisePage.searchFor("selenium");
		assertFalse(heisePage.getSearchResults().isEmpty());
	}
}
