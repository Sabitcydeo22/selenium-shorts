package com.cydeo.tests.step_definitions;

import com.cydeo.tests.pages.GoogleSearchPage;
import com.cydeo.tests.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Keys;
import org.testng.Assert;

public class GoogleSearch_StepDefinitions {

    // Instantiate the page object
    GoogleSearchPage googleSearchPage = new GoogleSearchPage();

    @Given("user is on Google search page")
    public void user_is_on_google_search_page() {
        // Navigate to Google search page
        Driver.getDriver().get("https://www.google.com");
    }

    @When("user types {string} in the Google search box and clicks enter")
    public void user_types_in_the_google_search_box_and_clicks_enter(String searchKeyword) throws InterruptedException {
        // Using WebElement from Page Object Model
        googleSearchPage.searchBox.sendKeys(searchKeyword + Keys.ENTER);

        // Wait briefly for search results to load
        Thread.sleep(2000);
    }

    @Then("user sees {string} in the Google title")
    public void user_sees_in_the_google_title(String expectedKeyword) {
        // Retrieve current page title
        String actualTitle = Driver.getDriver().getTitle();
        System.out.println("Actual page title: " + actualTitle);

        // Verify title with both standard text and URL format
        boolean containsRegular = actualTitle.toLowerCase().contains(expectedKeyword.toLowerCase());
        boolean containsWithPlus = actualTitle.toLowerCase().contains(expectedKeyword.toLowerCase().replace(" ", "+"));

        Assert.assertTrue(containsRegular || containsWithPlus);
    }
}