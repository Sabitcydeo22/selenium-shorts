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

public class P34_ExplicitWait_Invisibility {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        // Hapim faqen e testimit me element qe ngarkohet dinamikisht (Example 2)
        driver.get("https://practice.expandtesting.com/dynamic-loading/2");
    }

    @Test
    public void waitForInvisibilityTest() throws InterruptedException {
        System.out.println("Starting Invisibility Explicit Wait test...");

        // Pauze 2 sekonda para klikimit
        Thread.sleep(2000);

        // Hapi 1: Klikojme butonin 'Start'
        WebElement startBtn = driver.findElement(By.xpath("//div[@id='start']/button"));
        startBtn.click();
        System.out.println("Clicked 'Start' button.");

        // Hapi 2: Lokalizojme ikonen/shiritin e ngarkimit (loading spinner)
        WebElement loadingBar = driver.findElement(By.id("loading"));

        // Hapi 3: Presim dinamikisht derisa shiriti i ngarkimit te zhduket plotesisht nga ekrani
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.invisibilityOf(loadingBar));
        System.out.println("Loading bar is now invisible!");

        // Pauze 2 sekonda per te pare rezultatin e shfaqur
        Thread.sleep(2000);

        // Hapi 4: Lokalizojme dhe verifikojme tekstin perfundimtar
        WebElement finishText = driver.findElement(By.xpath("//div[@id='finish']/h4"));
        System.out.println("Result text: " + finishText.getText());
        Assert.assertEquals(finishText.getText(), "Hello World!", "Loaded text does not match!");

        // Pauze 3 sekonda para mbylljes
        Thread.sleep(3000);
        System.out.println("Invisibility verification test completed successfully.");
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
            System.out.println("Browser closed successfully.\n");
        }
    }
}
