# selenium-training
## Download your OS-dependent browser driver (chrome and or firefox)
Chromedrivers are available here: http://chromedriver.chromium.org/
Geckodrivers (for firefox) are available here: https://github.com/mozilla/geckodriver/releases

### After the download has finished,...
extract the driver to any directory you like to and reference the absolute filepath in the properties file selenium.properties (under linux you may need to make the driver executable in its file properties)


## Build
mvn clean install

## Run integration-test
mvn clean verify

## Example
You can switch to the git branch 'google', if you like to see an example of a Page Object Model (GooglePage) and a selenium test (GoogleTest).

# Exercise
We want to test the search engine of heise.de:
First we will create one or multiple page object models. Our junit test class will try to search the keyword 'selenium'. We expect heise to return a result. Heise.de prints a number of search results. If this number is greater than 0, we want to ensure, that search results are displayed. The test should fail either if no number of search results is displayed or if the number of search results is greater 0, but no search results (<article> nodes) are displayed.

## Step 1: Page Object Model
Implement a Page Object Model in src/main/java. Only define the WebElements, that are necessary for our test.

## Step 2: Write test script
What do we need in our test class? Don't forget to specify important and useful assertions.