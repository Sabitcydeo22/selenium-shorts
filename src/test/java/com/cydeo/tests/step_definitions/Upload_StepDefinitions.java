package com.cydeo.tests.step_definitions;

import com.cydeo.tests.pages.UploadPage;
import com.cydeo.tests.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class Upload_StepDefinitions {

    UploadPage uploadPage = new UploadPage();

    @Given("user is on the upload page")
    public void user_is_on_the_upload_page() {
        Driver.getDriver().get("https://the-internet.herokuapp.com/upload");
    }

    @When("user uploads a test file")
    public void user_uploads_a_test_file() {
        // Përdorim pom.xml që ekziston me siguri brenda projektit si skedar prove
        String filePath = System.getProperty("user.dir") + "/pom.xml";

        // Dërgojmë rrugën e skedarit direkt te inputi
        uploadPage.chooseFileButton.sendKeys(filePath);

        // Pauzë e shkurtër 2 sekonda për të parë emrin e skedarit të shfaqur
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Then("user clicks upload button and verifies text is {string}")
    public void user_clicks_upload_button_and_verifies_text_is(String expectedMessage) {
        uploadPage.uploadButton.click();

        // Verifikojmë mesazhin e suksesit
        Assert.assertEquals(expectedMessage, uploadPage.uploadSuccessMessage.getText());
    }
}
