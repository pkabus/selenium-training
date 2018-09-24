package net.proventis.training.test.selenium.heise;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import net.proventis.training.pages.heise.HeiseLandingPage;
import net.proventis.training.test.selenium.AbstractWebDriverTest;

/**
 * Test case(s) for heise.de
 * 
 * @author pkabus
 *
 */
public class HeiseTest extends AbstractWebDriverTest {

	private HeiseLandingPage heisePage;

	@Before
	@Override
	public void setUp() {
		super.setUp();
		heisePage = new HeiseLandingPage(this.getDriver());
	}

	@Test
	public void testClickIT() {
		heisePage.clickNavigationIT();
		assertTrue(this.getDriver().getCurrentUrl().endsWith("newsticker/it/"));
	}

	/* YOUR CODE HERE */
}
