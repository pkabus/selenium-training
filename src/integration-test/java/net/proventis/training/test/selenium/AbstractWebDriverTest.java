package net.proventis.training.test.selenium;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
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
import org.openqa.selenium.remote.RemoteWebDriver;

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
	private static final String SELENIUM_HUB = "selenium.hub";
	private static final boolean DISABLE_BROWSER_LOGGING = false;

	private WebDriver driver;

	/**
	 * Loads the selenium.properties file and merges it in the system-properties.
	 * Furthermore, a web driver is created.
	 */
	@Before
	public void setUp() {
		loadSeleniumProperties();

		String hubUrl = seleniumHubUrl();
		if (hubUrl != null) {
			// use a hub to start selenium test case
			createRemoteWebDriver();
		} else {
			// otherwise run selenium locally
			createLocalWebDriver();
		}
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

	private WebDriver createRemoteWebDriver() {
		try {
			driver = new RemoteWebDriver(new URL(seleniumHubUrl()), getCapabilities());
			return driver;
		} catch (MalformedURLException e) {
			throw new RuntimeException(e);
		}
	}

	private ChromeOptions createChromeOptions() {
		ChromeOptions co = new ChromeOptions();

		// logging in file
		if (DISABLE_BROWSER_LOGGING) {
			System.setProperty("webdriver.chrome.logfile",
					Thread.currentThread().getContextClassLoader().getResource("").getPath()
							+ System.getProperty(SELENIUM_BROWSER) + "_log");
		}

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

		// turn off logging
		if (DISABLE_BROWSER_LOGGING) {
			System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "/dev/null");
		}

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

	private String seleniumHubUrl() {
		return System.getProperty(SELENIUM_HUB);
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
