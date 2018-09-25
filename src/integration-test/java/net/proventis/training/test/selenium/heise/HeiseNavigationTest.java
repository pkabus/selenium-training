package net.proventis.training.test.selenium.heise;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import net.proventis.training.pages.heise.HeiseLandingPage;
import net.proventis.training.test.selenium.AbstractWebDriverTest;

/**
 * Test cases that are related to the heise navigation bar.
 * 
 * @author pkabus
 *
 */
public class HeiseNavigationTest extends AbstractWebDriverTest {

	private HeiseLandingPage heisePage;

	@Override
	@Before
	public void setUp() {
		super.setUp();
		heisePage = new HeiseLandingPage(getDriver());
	}

	/**
	 * Test click on navigation link 'IT'.
	 */
	@Test
	public void testClickIT() {
		heisePage.goTo();
		heisePage.clickNavIt();
		assertTrue(this.getDriver().getCurrentUrl().contains("newsticker/it/"));
	}

	/**
	 * Click on navigation link 'IT' and check if the browser has selected the
	 * section 'IT'.
	 */
	@Test
	public void testITSelected() {
		heisePage.goTo();
		heisePage.clickNavIt();
		assertTrue(heisePage.getNavIt().getAttribute("class").contains("active"));

	}
}