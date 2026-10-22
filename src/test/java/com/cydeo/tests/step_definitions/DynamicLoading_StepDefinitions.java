package com.cydeo.tests.step_definitions;

import com.cydeo.tests.pages.DynamicLoadingPage;
import com.cydeo.tests.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DynamicLoading_StepDefinitions {

    DynamicLoadingPage dynamicLoadingPage = new DynamicLoadingPage();

    @Given("user is on the dynamic loading page")
    public void user_is_on_the_dynamic_loading_page() {
        Driver.getDriver().get("https://the-internet.herokuapp.com/dynamic_loading/1");
    }

    @When("user clicks the Start button")
    public void user_clicks_the_start_button() {
        dynamicLoadingPage.startButton.click();
    }

    @Then("user waits for loading bar to disappear and verifies text is {string}")
    public void user_waits_for_loading_bar_to_disappear_and_verifies_text_is(String expectedText) {
        // Krijojmë Explicit Wait me kohë maksimale 10 sekonda
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));

        // Presim derisa shiriti i ngarkimit (loading bar) të zhduket plotësisht
        wait.until(ExpectedConditions.invisibilityOf(dynamicLoadingPage.loadingBar));

        // Pasi loading zhduket, teksti bëhet i dukshëm menjëherë
        Assert.assertTrue(dynamicLoadingPage.finishText.isDisplayed());
        Assert.assertEquals(expectedText, dynamicLoadingPage.finishText.getText());
    }
}
