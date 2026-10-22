package com.cydeo.tests.step_definitions;

import com.cydeo.tests.pages.AlertsPage;
import com.cydeo.tests.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Alert;

public class Alerts_StepDefinitions {

    AlertsPage alertsPage = new AlertsPage();

    @Given("user is on the javascript alerts page")
    public void user_is_on_the_javascript_alerts_page() {
        Driver.getDriver().get("https://the-internet.herokuapp.com/javascript_alerts");
    }

    @When("user clicks the JS Alert button")
    public void user_clicks_the_js_alert_button() {
        alertsPage.jsAlertButton.click();
    }

    @Then("user should see the alert message and accept it")
    public void user_should_see_the_alert_message_and_accept_it() {
        // Kalojmë kontrollin nga shfletuesi te dritarja Alert
        Alert alert = Driver.getDriver().switchTo().alert();

        // Ndalim 2 sekonda për ta parë dritaren alert me sy
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Klikojmë butonin OK në Alert
        alert.accept();

        // Verifikojmë që në faqe shfaqet teksti i konfirmimit
        Assert.assertEquals("You successfully clicked an alert", alertsPage.resultText.getText());
    }

    @When("user clicks the JS Confirm button")
    public void user_clicks_the_js_confirm_button() {
        alertsPage.jsConfirmButton.click();
    }

    @Then("user cancels the alert and sees confirmation message")
    public void user_cancels_the_alert_and_sees_confirmation_message() {
        Alert alert = Driver.getDriver().switchTo().alert();

        // Pauzë e shkurtër 2 sekonda për ta vëzhguar qartë dritaren
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Shtypim butonin Cancel përmes dismiss()
        alert.dismiss();

        // Verifikojmë mesazhin e kthyer në faqe
        Assert.assertEquals("You clicked: Cancel", alertsPage.resultText.getText());
    }

    @When("user clicks the JS Prompt button")
    public void user_clicks_the_js_prompt_button() {
        alertsPage.jsPromptButton.click();
    }

    @Then("user sends text {string} to the alert and accepts it")
    public void user_sends_text_to_the_alert_and_accepts_it(String input) {
        Alert alert = Driver.getDriver().switchTo().alert();

        // Shkruajmë tekstin brenda dritares Alert
        alert.sendKeys(input);

        // Pauzë e shkurtër 2 sekonda për ta vëzhguar
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Klikojmë OK përmes accept()
        alert.accept();

        // Verifikojmë që teksti i shkruar u shfaq në faqe
        Assert.assertEquals("You entered: " + input, alertsPage.resultText.getText());
    }
}
