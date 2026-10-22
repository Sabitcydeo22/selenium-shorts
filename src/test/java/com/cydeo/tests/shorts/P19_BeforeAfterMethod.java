package com.cydeo.tests.shorts;

import com.cydeo.tests.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class P19_BeforeAfterMethod {

    // Deklarimi i variables globale te drajverit per tu perdorur ne te gjitha metodat
    WebDriver driver;

    // 1. Ekzekutohet automatikisht PARA cdo metode qe ka @Test
    @BeforeMethod
    public void setUpMethod() {
        System.out.println("--> Running @BeforeMethod: Setting up browser environment...");
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    // 2. Rasti i pare i testimit: Verifikimi i titullit te faqes se login-it
    @Test
    public void testLoginTitle() {
        System.out.println("Executing Test 1: Verifying login page title...");
        driver.get("https://practice.expandtesting.com/login");

        String actualTitle = driver.getTitle();
        String expectedTitle = "Test Login Page for Automation Testing Practice";

        // Assertion qe verifikon titullin
        Assert.assertEquals(actualTitle, expectedTitle, "Title verification failed!");
        System.out.println("Test 1 Result: Title matched successfully.");
    }

    // 3. Rasti i dyte i testimit: Verifikimi i prezences se butonit Login
    @Test
    public void testLoginButtonDisplayed() {
        System.out.println("Executing Test 2: Verifying login button visibility...");
        driver.get("https://practice.expandtesting.com/login");

        WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));

        // Assertion qe kontrollon nese butoni eshte i dukshem ne ekran (true)
        Assert.assertTrue(loginButton.isDisplayed(), "Login button is not visible on page!");
        System.out.println("Test 2 Result: Login button is visible as expected.");
    }

    // 4. Ekzekutohet automatikisht PAS cdo metode @Test, pavaresisht nese testi kalon apo deshton
    @AfterMethod
    public void tearDownMethod() {
        System.out.println("--> Running @AfterMethod: Tearing down and closing browser...\n");
        if (driver != null) {
            driver.quit();
        }
    }
}