package com.cydeo.tests.shorts;

import com.cydeo.tests.utilities.WebDriverFactory;
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

public class P33_ExplicitWait {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        // Hapim faqen e testimit me ngarkim dinamik (Dynamic Loading)
        driver.get("https://practice.expandtesting.com/dynamic-loading/1");
    }

    @Test
    public void explicitWaitVisibilityTest() throws InterruptedException {
        System.out.println("Starting Explicit Wait verification test...");

        // Pauze 2 sekonda para klikimit
        Thread.sleep(2000);

        // Hapi 1: Klikojme butonin 'Start' per te nisur ngarkimin dinamik
        WebElement startBtn = driver.findElement(By.xpath("//div[@id='start']/button"));
        startBtn.click();
        System.out.println("Clicked 'Start' button. Loading bar appeared...");

        // Hapi 2: Krijojme instancen e WebDriverWait me kohezgjatje maksimale 15 sekonda
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        // Hapi 3: Presim ne menyre dinamike derisa teksti i perfunduar te behet i dukshem
        WebElement finishText = driver.findElement(By.xpath("//div[@id='finish']/h4"));
        wait.until(ExpectedConditions.visibilityOf(finishText));
        System.out.println("Explicit Wait condition met: Element is now visible!");

        // Pauze 2 sekonda qe ta shohesh tekstin 'Hello World!' ne ekran
        Thread.sleep(2000);

        // Hapi 4: Verifikojme tekstin me Assertion
        System.out.println("Loaded text: " + finishText.getText());
        Assert.assertEquals(finishText.getText(), "Hello World!", "Dynamically loaded text does not match!");

        // Pauze 3 sekonda para mbylljes se shfletuesit
        Thread.sleep(3000);
        System.out.println("Explicit Wait test passed successfully.");
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
            System.out.println("Browser closed successfully.\n");
        }
    }
}
