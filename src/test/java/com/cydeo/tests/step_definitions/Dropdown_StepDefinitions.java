package com.cydeo.tests.step_definitions;

import com.cydeo.tests.pages.DropdownPage;
import com.cydeo.tests.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.List;

public class Dropdown_StepDefinitions {

    DropdownPage dropdownPage = new DropdownPage();

    @Given("user is on the dropdown page")
    public void user_is_on_the_dropdown_page() {
        Driver.getDriver().get("https://the-internet.herokuapp.com/dropdown");
    }

    @Then("user should see below options in the dropdown")
    public void user_should_see_below_options_in_the_dropdown(List<String> expectedOptions) {
        Select select = new Select(dropdownPage.dropdownElement);
        List<WebElement> actualWebElements = select.getOptions();

        List<String> actualOptions = new ArrayList<>();
        for (WebElement each : actualWebElements) {
            actualOptions.add(each.getText());
        }

        // Zgjedhim me klikim opsionin e dytë për ta parë me sy
        select.selectByVisibleText("Option 2");

        // Ndalim i vogël 2 sekonda vetëm për ta vëzhguar
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Assert.assertEquals(expectedOptions, actualOptions);
    }
}