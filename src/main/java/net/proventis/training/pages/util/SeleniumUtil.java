package net.proventis.training.pages.util;

import java.util.function.Function;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Utility class with helpful selenium functions.
 * 
 * @author pkabus
 *
 */
public class SeleniumUtil {

	/**
	 * Returns a function that is used to ensure the current web page is completely
	 * loaded. Use this function in a {@link WebDriverWait}.
	 * 
	 * @return page-is-ready function
	 */
	public static Function<WebDriver, Boolean> pageIsReady() {
		return driver -> {
			return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
		};
	}

}
