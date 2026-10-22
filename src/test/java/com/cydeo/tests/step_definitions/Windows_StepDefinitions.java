package com.cydeo.tests.step_definitions;

import com.cydeo.tests.pages.WindowsPage;
import com.cydeo.tests.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.Set;

public class Windows_StepDefinitions {

    WindowsPage windowsPage = new WindowsPage();

    @Given("user is on the multiple windows page")
    public void user_is_on_the_multiple_windows_page() {
        Driver.getDriver().get("https://the-internet.herokuapp.com/windows");
    }

    @When("user clicks the Click Here link to open a new window")
    public void user_clicks_the_click_here_link_to_open_a_new_window() {
        windowsPage.clickHereLink.click();
    }

    @Then("user should switch to the new window and verify title is {string}")
    public void user_should_switch_to_the_new_window_and_verify_title_is(String expectedTitle) {
        // Marrim të gjitha dritaret (handles) që janë hapur aktualisht
        Set<String> allWindowHandles = Driver.getDriver().getWindowHandles();

        // Kalojmë nëpër secilën dritare derisa të gjejmë dritaren e re me titullin përkatës
        for (String eachHandle : allWindowHandles) {
            Driver.getDriver().switchTo().window(eachHandle);
            if (Driver.getDriver().getTitle().equals(expectedTitle)) {
                break;
            }
        }

        // Pauzë e vogël 2 sekonda për ta vëzhguar dritaren e re me sy
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Verifikojmë titullin e dritares aktuale
        Assert.assertEquals(expectedTitle, Driver.getDriver().getTitle());
    }
}
