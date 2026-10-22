package com.cydeo.tests.shorts;

import com.cydeo.tests.utilities.WebDriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class P37_JS_Alert_ExplicitWait {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://practice.expandtesting.com/js-dialogs");
    }

    @Test
    public void explicitWaitAlertTest() throws InterruptedException {
        System.out.println("Starting Explicit Wait for JS Alert test...");

        // Pauze 2 sekonda para klikimit
        Thread.sleep(2000);

        // Hapi 1: Klikojme butonin qe shfaq JS Alert
        WebElement jsAlertBtn = driver.findElement(By.id("js-alert"));
        jsAlertBtn.click();
        System.out.println("Triggered JS Alert.");

        // Hapi 2: Presim ne menyre eksplicite qe alert-i te jete i pranishem
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        System.out.println("Alert detected dynamically: " + alert.getText());

        // Pauze 2 sekonda qe ta shohesh alert-in hapur ne ekran
        Thread.sleep(2000);

        // Hapi 3: E pranojme alert-in (OK)
        alert.accept();
        System.out.println("Alert accepted successfully.");

        // Pauze 2 sekonda per te pare mesazhin e kthyer
        Thread.sleep(2000);

        // Hapi 4: Verifikojme rezultatin ne faqe
        WebElement dialogResponse = driver.findElement(By.id("dialog-response"));
        Assert.assertTrue(dialogResponse.isDisplayed(), "Response text is not displayed!");
        System.out.println("Dialog response confirmed: " + dialogResponse.getText());

        // Pauze 3 sekonda para mbylljes
        Thread.sleep(3000);
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
            System.out.println("Browser closed successfully.\n");
        }
    }
}