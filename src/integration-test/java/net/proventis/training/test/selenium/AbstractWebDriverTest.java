package net.proventis.training.test.selenium;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

/**
 * Abstract JUnit test case, that loads selenium-specific properties and creates
 * and configures a web driver (so far only CHROME or FIREFOX).
 * 
 * @author pkabus
 * @version 1.0 Date: 18.06.2018
 */
public abstract class AbstractWebDriverTest {

	private static final String SELENIUM_PROPERTIES_FILE = "selenium.properties";
	private static final String SELENIUM_BROWSER = "selenium.browser";
	private static final String BROWSER_HEADLESS = "browser.headless";

	private WebDriver driver;

	/**
	 * Loads the selenium.properties file and merges it in the system-properties.
	 * Furthermore, a web driver is created.
	 * 
	 * @throws MalformedURLException
	 */
	@Before
	public void setUp() {
		loadSeleniumProperties();
		createLocalWebDriver();
		// driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),
		// getCapabilities());
	}

	private void loadSeleniumProperties() {
		String propsPath = Thread.currentThread().getContextClassLoader().getResource("").getPath()
				+ SELENIUM_PROPERTIES_FILE;
		Properties seleniumProps = new Properties();
		try {
			seleniumProps.load(new FileInputStream(propsPath));
		} catch (FileNotFoundException ex) {
			throw new RuntimeException("No properties file named " + SELENIUM_PROPERTIES_FILE + " found.");
		} catch (IOException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}

		Objects.requireNonNull(seleniumProps.getProperty(SELENIUM_BROWSER));

		// merge system and selenium properties
		Properties sysProps = System.getProperties();
		Properties merged = new Properties();
		merged.putAll(sysProps);
		merged.putAll(seleniumProps);
		System.setProperties(merged);
	}

	private WebDriver createLocalWebDriver() {
		switch (System.getProperty(SELENIUM_BROWSER).toUpperCase()) {
		case "CHROME":
			driver = new ChromeDriver(createChromeOptions());
			break;
		case "FIREFOX":
			driver = new FirefoxDriver(createFirefoxOptions());
			break;
		default:
			throw new IllegalArgumentException("Either set CHROME or FIREFOX as selenium.browser");
		}

		return driver;
	}

	private ChromeOptions createChromeOptions() {
		ChromeOptions co = new ChromeOptions();
		if (startHeadless()) {
			co.addArguments("--headless");
		}
		Map<String, Object> prefs = new HashMap<String, Object>();
		prefs.put("credentials_enable_service", Boolean.FALSE);
		prefs.put("profile.password_manager_enabled", Boolean.FALSE);
		co.setExperimentalOption("prefs", prefs);
		return co;
	}

	private FirefoxOptions createFirefoxOptions() {
		// Firefox options
		FirefoxOptions fo = new FirefoxOptions();
		if (startHeadless()) {
			// TODO headless option for firefox
			System.out.println("Firefox ignores -headless option");
		}
		// Firefox profile
		FirefoxProfile profile = new FirefoxProfile();
		profile.setPreference("network.proxy.type", 4);
		profile.setPreference("network.proxy.autoconfig_url", "http://wpad/wpad.dat");
		fo.setProfile(profile);
		return fo;
	}

	private MutableCapabilities getCapabilities() {
		String browserProp = System.getProperty(SELENIUM_BROWSER);

		// create capabilities depending from browser
		switch (browserProp.toUpperCase()) {
		case "CHROME":
			return createChromeOptions();

		case "FIREFOX":
			return createFirefoxOptions();
		default:
			throw new RuntimeException(
					"Browser according to '" + browserProp + "' not supported. Use Firefox or Chrome.");
		}
	}

	private boolean startHeadless() {
		return Boolean.parseBoolean(System.getProperty(BROWSER_HEADLESS));
	}

	/**
	 * Returns the web driver.
	 * 
	 * @return the selenium web driver
	 */
	public WebDriver getDriver() {
		return driver;
	}

	/**
	 * Kills the web driver.
	 */
	@After
	public void tearDown() {
		driver.quit();
	}
}
