package net.proventis.training.pages.orangehrm;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import net.proventis.training.pages.supertype.AbstractPage;

/**
 * @author peter
 *
 */
public class OrangeHrmLoginPage extends AbstractPage {

	private final static By fieldUsername = By.id("txtUsername");

	private final static By fieldPassword = By.id("txtPassword");
	
	private final static By buttonLogin = By.id("btnLogin");
	
	
	
	/**
	 * @param driver
	 */
	public OrangeHrmLoginPage(WebDriver driver) {
		super(driver);
	}

	@Override
	public AbstractPage goTo() {
		this.getDriver().get("https://s2.demo.opensourcecms.com/orangehrm");
		return this;
	}

	
	/** Field Username.
	 * @return username
	 */
	public By getFieldUsername() {
		return fieldUsername;
	}
	
	/** Field Password.
	 * @return password
	 */
	public By getFieldPassword() {
		return fieldPassword;
	}
	
	/** Button login.
	 * @return login
	 */
	public By getButtonLogin() {
		return buttonLogin;
	}
}
