package net.proventis.training.pages.supertype;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Abstract heise page object model.
 * 
 * @author pkabus
 *
 */
public abstract class AbstractHeisePage extends AbstractPage {

	@FindBy(name = "rubriknavi.ho.it")
	private WebElement it;

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

	/**
	 * Waits until nav 'IT' is clickable and then clicks it.
	 * 
	 * @return self-reference
	 */
	public AbstractHeisePage clickNavigationIT() {
		this.getDriverWait().until(ExpectedConditions.elementToBeClickable(it)).click();
		return this;
	}
}
