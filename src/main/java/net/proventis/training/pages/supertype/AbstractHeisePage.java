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

	public AbstractHeisePage(final WebDriver driver) {
		super(driver);
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
