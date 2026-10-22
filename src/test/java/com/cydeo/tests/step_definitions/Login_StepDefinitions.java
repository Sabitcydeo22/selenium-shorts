package com.cydeo.tests.step_definitions;

import com.cydeo.tests.pages.LibraryLoginPage;
import com.cydeo.tests.utilities.ConfigurationReader;
import com.cydeo.tests.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class Login_StepDefinitions {

    LibraryLoginPage loginPage = new LibraryLoginPage();

    @Given("user is on the library login page")
    public void user_is_on_the_library_login_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("library.url"));
    }

    @When("user enters librarian username")
    public void user_enters_librarian_username() {
        loginPage.inputEmail.sendKeys(ConfigurationReader.getProperty("librarian.username"));
    }

    @When("user enters librarian password")
    public void user_enters_librarian_password() {
        loginPage.inputPassword.sendKeys(ConfigurationReader.getProperty("librarian.password"));
        loginPage.signInButton.click();
    }

    @Then("user should see {string} in the url")
    public void user_should_see_in_the_url(String expectedInUrl) {
        org.openqa.selenium.support.ui.WebDriverWait wait =
                new org.openqa.selenium.support.ui.WebDriverWait(Driver.getDriver(), java.time.Duration.ofSeconds(10));

        wait.until(org.openqa.selenium.support.ui.ExpectedConditions.urlContains(expectedInUrl));

        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains(expectedInUrl));
    }

    @When("user logs in as a {string}")
    public void user_logs_in_as_a(String userType) {
        String username = "";
        String password = "";

        if (userType.equalsIgnoreCase("librarian")) {
            username = ConfigurationReader.getProperty("librarian.username");
            password = ConfigurationReader.getProperty("librarian.password");
        } else if (userType.equalsIgnoreCase("student")) {
            username = ConfigurationReader.getProperty("student.username");
            password = ConfigurationReader.getProperty("student.password");
        }

        loginPage.login(username, password);
    }
    @When("user enters invalid email and password")
    public void user_enters_invalid_email_and_password() {
        loginPage.login("wronguser@library.com", "wrongpassword123");
    }

    @Then("user should see the {string} message")
    public void user_should_see_the_message(String expectedMessage) {
        org.openqa.selenium.support.ui.WebDriverWait wait =
                new org.openqa.selenium.support.ui.WebDriverWait(Driver.getDriver(), java.time.Duration.ofSeconds(5));

        // Presim që mesazhi i gabimit të bëhet i dukshëm në faqe
        wait.until(org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf(loginPage.errorAlertMessage));

        // Verifikojmë që teksti në faqe përputhet me mesazhin e pritur
        String actualMessage = loginPage.errorAlertMessage.getText();
        Assert.assertEquals(expectedMessage, actualMessage);
    }

    @Then("user should see below modules")
    public void user_should_see_below_modules(java.util.List<String> expectedModules) {
        org.openqa.selenium.support.ui.WebDriverWait wait =
                new org.openqa.selenium.support.ui.WebDriverWait(Driver.getDriver(), java.time.Duration.ofSeconds(15));

        // Presim derisa lista e moduleve të mos jetë më e zbrazët (madhësia më e madhe se 0)
        wait.until(driver -> !loginPage.navigationModules.isEmpty());

        // Mbledhim tekstin e secilit modul nga faqja
        java.util.List<String> actualModules = new java.util.ArrayList<>();
        for (org.openqa.selenium.WebElement each : loginPage.navigationModules) {
            actualModules.add(each.getText().trim());
        }

        // Krahasojmë listën që erdhi nga Gherkin me listën reale nga UI
        org.junit.Assert.assertEquals(expectedModules, actualModules);
    }

}