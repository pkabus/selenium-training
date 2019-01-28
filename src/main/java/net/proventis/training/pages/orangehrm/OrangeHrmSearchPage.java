package net.proventis.training.pages.orangehrm;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import net.proventis.training.pages.supertype.AbstractPage;

/**
 * @author peter
 *
 */
public class OrangeHrmSearchPage extends AbstractPage {

	
	private final static By topMenu = By.id("top-menu");	
	/**
	 * @param driver
	 */
	public OrangeHrmSearchPage(WebDriver driver) {
		super(driver);
	}

	/**
	 * @return
	 */
	public By getTopMenu() {
		return topMenu;
	}

}
