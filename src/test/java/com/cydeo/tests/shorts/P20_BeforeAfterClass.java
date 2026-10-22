package com.cydeo.tests.shorts;

import com.cydeo.tests.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class P20_BeforeAfterClass {

    WebDriver driver;

    // 1. Ekzekutohet VETEM NJE HERE perpara se te nise i tere vargu i testeve ne kete klase
    @BeforeClass
    public void setUpClass() {
        System.out.println("====== [START] Running @BeforeClass: Opening browser once for the entire suite ======");
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Navigojme tek faqja kryesore vetem nje here
        driver.get("https://practice.expandtesting.com/");
    }

    // 2. Testi i pare: Verifikon URL-ne aktuale
    @Test
    public void testPageUrl() {
        System.out.println("Executing Test 1: Verifying Home Page URL...");
        String actualUrl = driver.getCurrentUrl();
        Assert.assertTrue(actualUrl.contains("practice.expandtesting.com"), "URL does not match!");
        System.out.println("Test 1 Result: URL verification passed.");
    }

    // 3. Testi i dyte: Verifikon tekstin e titullit kryesor ne te njejten dritare te hapur
    @Test
    public void testHeaderVisibility() {
        System.out.println("Executing Test 2: Verifying main heading...");
        WebElement mainHeading = driver.findElement(By.tagName("h1"));
        Assert.assertTrue(mainHeading.isDisplayed(), "Main heading is not displayed!");
        System.out.println("Test 2 Result: Header is displayed with text: " + mainHeading.getText());
    }

    // 4. Ekzekutohet VETEM NJE HERE ne fund, pasi te gjitha metodat @Test te kene mbaruar
    @AfterClass
    public void tearDownClass() {
        System.out.println("====== [FINISH] Running @AfterClass: Closing browser session once at the very end ======");
        if (driver != null) {
            driver.quit();
        }
    }
}