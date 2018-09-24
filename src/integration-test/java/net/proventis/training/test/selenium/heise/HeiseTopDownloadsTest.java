package net.proventis.training.test.selenium.heise;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import net.proventis.training.pages.heise.HeiseLandingPage;
import net.proventis.training.test.selenium.AbstractWebDriverTest;

/**
 * Another heise test case.
 * 
 * @author pkabus
 *
 */
public class HeiseTopDownloadsTest extends AbstractWebDriverTest {

	private HeiseLandingPage heisePage;

	@Before
	@Override
	public void setUp() {
		super.setUp();
		this.heisePage = new HeiseLandingPage(getDriver());
	}

	/**
	 * This test will pass as soon as you have solved exercise 3.
	 */
	@Test
	public void testClickTopDownloadsButton() {
		heisePage.goTo();
		heisePage.clickTopDownloads();
		assertTrue(getDriver().getTitle().contains("heise Download"));
	}

}
