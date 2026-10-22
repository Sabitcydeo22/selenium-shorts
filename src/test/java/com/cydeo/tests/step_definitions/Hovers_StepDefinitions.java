package com.cydeo.tests.step_definitions;

import com.cydeo.tests.pages.HoversPage;
import com.cydeo.tests.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.interactions.Actions;

public class Hovers_StepDefinitions {

    HoversPage hoversPage = new HoversPage();

    @Given("user is on the hovers page")
    public void user_is_on_the_hovers_page() {
        Driver.getDriver().get("https://the-internet.herokuapp.com/hovers");
    }

    @When("user hovers over the first avatar")
    public void user_hovers_over_the_first_avatar() {
        Actions actions = new Actions(Driver.getDriver());
        // Kalojmë kursorin mbi avatar
        actions.moveToElement(hoversPage.firstAvatar).perform();

        // Ndalim 2 sekonda për ta vëzhguar shfaqjen e emrit me sy
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Then("user should see the text {string} displayed")
    public void user_should_see_the_text_displayed(String expectedName) {
        // Verifikojmë që teksti shfaqet dhe ka vlerën e pritur
        Assert.assertTrue(hoversPage.firstAvatarName.isDisplayed());
        Assert.assertEquals(expectedName, hoversPage.firstAvatarName.getText());
    }
}
