package com.cydeo.tests.step_definitions;

import com.cydeo.tests.pages.IframePage;
import com.cydeo.tests.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class Iframe_StepDefinitions {

    IframePage iframePage = new IframePage();

    @Given("user is on the iframe page")
    public void user_is_on_the_iframe_page() {
        Driver.getDriver().get("https://the-internet.herokuapp.com/iframe");
    }

    @When("user switches to the iframe and writes {string}")
    public void user_switches_to_the_iframe_and_writes(String text) {
        // Kalojmë brenda në iframe duke përdorur ID-në e tij "mce_0_ifr"
        Driver.getDriver().switchTo().frame("mce_0_ifr");

        // Fshijmë tekstin ekzistues dhe shkruajmë tekstin tonë
        iframePage.textArea.clear();
        iframePage.textArea.sendKeys(text);

        // Ndalim 2 sekonda për ta vëzhguar qartë tekstin e shkruar
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Then("user switches back to default content and verifies header is {string}")
    public void user_switches_back_to_default_content_and_verifies_header_is(String expectedHeader) {
        // Kthehemi nga iframe te faqja kryesore
        Driver.getDriver().switchTo().defaultContent();

        // Verifikojmë titullin në faqen kryesore
        Assert.assertEquals(expectedHeader, iframePage.headerText.getText());
    }
}
