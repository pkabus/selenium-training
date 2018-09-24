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



# Exercise 1
We want to define the heise.de navigation bar. Therefore we extend the class AbstractHeisePage.

## Step 1: Define a Page Object Model and determine locators
Use your browser's developer tools to determine locators for all the navigation headers 'IT', 'Mobiles', 'Entertainment', 'Wissen', 'Netzpolitik', 'Wirtschaft' and 'Journal'.

## Step 2: In HeiseNavigationTest
implement testClickIT(), testClickWissen() and testClickJournal()


# Exercise 2
We want to test the search engine of heise.de:
First, we will create one or multiple page object models. Then, our junit test class is going to search the keyword 'selenium'. We expect heise to return a result. Heise.de prints a number of search results. If this number is greater than 0, we want to ensure, that search results are displayed. The test should fail either if no number of search results is displayed or if the number of search results is greater than 0, but no search results (<article> nodes) are displayed.

## Step 1: Go through the test case manually
Before you start to implement page object models or test classes, you should manually click through all the steps in your browser. Think about how you can define locators (id, name, class, css, xpath) for the DOM elements that you later need for your test.

## Step 2: Page Object Model
Implement the Page Object Model HeiseLandingPage in src/main/java. Define only the WebElements, that are necessary for our test. Feel free to define as many Page Object Models as you like.

## Step 3: Write a test script
Implement the test method HeiseTest#testSearchEngine. What do we need in our test class? Don't forget to specify meaningful assertions.
