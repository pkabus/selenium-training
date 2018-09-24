# selenium-training
## Download your OS-dependent browser driver (chrome and or firefox)
Chromedrivers are available here: http://chromedriver.chromium.org/
Firefoxdrivers are available here: https://github.com/mozilla/geckodriver/releases

### After the download has finished,...
extract the driver to any directory you like to and reference the absolute filepath in the properties file selenium.properties (under linux you may need to make the driver executable in its file properties)


## Build
mvn clean install

## Run integration-test
mvn clean verify

## Example
You can switch to the git branch 'google', if you like to see an example of a Page Object Model (GooglePage) and a selenium test (GoogleTest).