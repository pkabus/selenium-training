package net.proventis.training.test.selenium.demo;

import static org.junit.Assert.*;

import org.apache.commons.net.imap.IMAPClient.SEARCH_CRITERIA;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import net.proventis.training.pages.heise.HeiseLandingPage;
import net.proventis.training.pages.orangehrm.OrangeHrmLoginPage;
import net.proventis.training.pages.orangehrm.OrangeHrmSearchPage;
import net.proventis.training.test.selenium.AbstractWebDriverTest;

/**
 * @author peter
 *
 */
public class DemoTest extends AbstractWebDriverTest {


	private OrangeHrmLoginPage loginPage;
	private OrangeHrmSearchPage sarchPage;
	
	
	@Before
	@Override
	public void setUp() {
		super.setUp();
		loginPage = new OrangeHrmLoginPage(this.getDriver());
		sarchPage = new OrangeHrmSearchPage(this.getDriver());
	}
	

	
	/**
	 * Navigates to a webpage, logs a user in and expects that another webpage is shown.
	 */
	@Test
	public void testLoginPositive() {
		loginPage.goTo();		
		
		// wait for presence of UI elements and fill them
		WebElement elementUsername = getWait().until(ExpectedConditions.presenceOfElementLocated(loginPage.getFieldUsername()));
		elementUsername.sendKeys("opensourcecms");
		WebElement elementPassword = getWait().until(ExpectedConditions.presenceOfElementLocated(loginPage.getFieldPassword()));
		elementPassword.sendKeys("opensourcecms");

		// wait until button is clickable and click
		getWait().until(ExpectedConditions.elementToBeClickable(loginPage.getButtonLogin())).click();
		
		// wait until URL contains index.php
		getWait().until(ExpectedConditions.urlContains("orangehrm/index.php"));

		// look for an element on the webpage which is shown only when a user is logged in
		WebElement elementTopMenu = getWait().until(ExpectedConditions.presenceOfElementLocated(sarchPage.getTopMenu()));
		assertTrue("Top menu not displayed", elementTopMenu.isDisplayed());
		
	}

}
