package com.cydeo.tests.step_definitions;

import com.cydeo.tests.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.JavascriptExecutor;

public class JSExecutor_StepDefinitions {

    @Given("user is on the infinite scroll page")
    public void user_is_on_the_infinite_scroll_page() {
        Driver.getDriver().get("https://the-internet.herokuapp.com/infinite_scroll");
    }

    @When("user scrolls down {int} pixels using JavaScriptExecutor")
    public void user_scrolls_down_pixels_using_java_script_executor(Integer pixels) {
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();

        // Bëjmë scroll poshtë 5 herë me nga 1 sekondë pauzë që ta shohësh qartë me sy
        for (int i = 1; i <= 5; i++) {
            js.executeScript("window.scrollBy(0, " + pixels + ")");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Then("user scrolls up {int} pixels using JavaScriptExecutor")
    public void user_scrolls_up_pixels_using_java_script_executor(Integer pixels) {
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();

        // Me vlerë negative lëvizim prapë lart
        js.executeScript("window.scrollBy(0, -" + pixels + ")");

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}