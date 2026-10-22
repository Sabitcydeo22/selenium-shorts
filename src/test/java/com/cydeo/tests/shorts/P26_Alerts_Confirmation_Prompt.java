package com.cydeo.tests.shorts;

import com.cydeo.tests.utilities.WebDriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class P26_Alerts_Confirmation_Prompt {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://practice.expandtesting.com/js-dialogs");
    }

    // 1. Testimi i Confirmation Alert (Klikimi i Cancel me dismiss())
    @Test
    public void jsConfirmationAlertTest() throws InterruptedException {
        System.out.println("Starting JS Confirmation Alert test...");

        // Klikojme butonin e konfirmimit
        WebElement confirmBtn = driver.findElement(By.id("js-confirm"));
        confirmBtn.click();
        Thread.sleep(1000);

        // Kalojme tek alerti dhe klikojme Cancel
        Alert alert = driver.switchTo().alert();
        System.out.println("Confirmation text: " + alert.getText());
        alert.dismiss(); // Klikon 'Cancel'

        Thread.sleep(1000);

        // Verifikojme rezultatin ne faqe
        WebElement resultText = driver.findElement(By.id("dialog-response"));
        System.out.println("Result text: " + resultText.getText());
        Assert.assertTrue(resultText.getText().contains("Cancel"), "Verification of Cancel failed!");
    }

    // 2. Testimi i Prompt Alert (Shkrimi i tekstit dhe klikimi OK)
    @Test
    public void jsPromptAlertTest() throws InterruptedException {
        System.out.println("Starting JS Prompt Alert test...");

        // Klikojme butonin Prompt
        WebElement promptBtn = driver.findElement(By.id("js-prompt"));
        promptBtn.click();
        Thread.sleep(1000);

        // Kalojme tek alerti, shkruajme tekstin dhe pranojme
        Alert alert = driver.switchTo().alert();
        String inputText = "Sabit Automation";
        alert.sendKeys(inputText);
        alert.accept(); // Klikon 'OK'

        Thread.sleep(1000);

        // Verifikojme qe teksti i shkruar shfaqet ne rezultat
        WebElement resultText = driver.findElement(By.id("dialog-response"));
        System.out.println("Result text: " + resultText.getText());
        Assert.assertTrue(resultText.getText().contains(inputText), "Prompt text verification failed!");
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
            System.out.println("Browser closed successfully.\n");
        }
    }
}