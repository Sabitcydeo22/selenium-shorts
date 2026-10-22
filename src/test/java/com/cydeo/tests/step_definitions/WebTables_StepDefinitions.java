package com.cydeo.tests.step_definitions;

import com.cydeo.tests.pages.WebTablesPage;
import com.cydeo.tests.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class WebTables_StepDefinitions {

    WebTablesPage webTablesPage = new WebTablesPage();

    @Given("user is on the tables page")
    public void user_is_on_the_tables_page() {
        Driver.getDriver().get("https://the-internet.herokuapp.com/tables");
    }

    @When("user locates the record for {string}")
    public void user_locates_the_record_for(String firstName) {
        // Verifikojmë që elementi i personit ndodhet dhe është i dukshëm në tabelë
        Assert.assertTrue(webTablesPage.getDueAmountByFirstName(firstName).isDisplayed());
    }

    @Then("user verifies that {string} has a due amount of {string}")
    public void user_verifies_that_has_a_due_amount_of(String firstName, String expectedDue) {
        // Marrim vlerën e faturës me metodën dinamike XPath
        String actualDue = webTablesPage.getDueAmountByFirstName(firstName).getText();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Bëjmë verifikimin përfundimtar
        Assert.assertEquals(expectedDue, actualDue);
    }
}