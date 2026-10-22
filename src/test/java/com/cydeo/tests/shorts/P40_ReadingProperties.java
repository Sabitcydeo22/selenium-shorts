package com.cydeo.tests.shorts;

import com.cydeo.tests.utilities.ConfigurationReader;
import com.cydeo.tests.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class P40_ReadingProperties {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        // Lexojme browser-in dinamikisht nga skedari configuration.properties
        String browserType = ConfigurationReader.getProperty("browser");
        driver = WebDriverFactory.getDriver(browserType);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Lexojme URL-ne dinamikisht nga skedari configuration.properties
        String targetUrl = ConfigurationReader.getProperty("practice.url");
        driver.get(targetUrl);
    }

    @Test
    public void readPropertiesTest() throws InterruptedException {
        System.out.println("Starting test driven by configuration.properties...");

        // Pauze 2 sekonda per vezhgim
        Thread.sleep(2000);

        // Verifikojme qe faqja u hap me sukses duke perdorur fushen e tekstit
        WebElement inputField = driver.findElement(By.id("input-text"));
        inputField.sendKeys("Config Reader Works Perfectly!");
        System.out.println("Input entered successfully using dynamic config.");

        // Pauze 2 sekonda per ta pare tekstin e shkruar
        Thread.sleep(2000);

        Assert.assertTrue(inputField.isDisplayed(), "Input field is not displayed!");

        // Pauze 3 sekonda para mbylljes
        Thread.sleep(3000);
        System.out.println("Dynamic configuration verification completed successfully.");
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
            System.out.println("Browser closed successfully.\n");
        }
    }
}
