package com.cydeo.tests.shorts;

import com.cydeo.tests.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class P38_Actions_DoubleClick_RightClick {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        // Hapim faqen e testimit me klikim te dyfishte dhe klikim te djathte
        driver.get("https://practice.expandtesting.com/context-menu");
    }

    @Test
    public void rightClickContextTest() throws InterruptedException {
        System.out.println("Starting Context Click (Right-Click) test...");

        // Krijojme instancen e klases Actions
        Actions actions = new Actions(driver);

        // Pauze 2 sekonda para veprimit
        Thread.sleep(2000);

        // Hapi 1: Lokalizojme zonen/kutine per klikim te djathte
        WebElement hotSpotBox = driver.findElement(By.id("hot-spot"));

        // Bejme scroll qe ta kesh plotesisht para syve
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", hotSpotBox);
        Thread.sleep(1000);

        // Hapi 2: Ekzekutojme klikimin me te djathten (Context Click)
        actions.contextClick(hotSpotBox).perform();
        System.out.println("Right-clicked on the target area.");

        // Pauze 2 sekonda qe te shohesh shfaqjen e alert-it te sistemit
        Thread.sleep(2000);

        // Hapi 3: Menaxhojme alert-in qe shfaqet nga klikimi i djathte
        String alertText = driver.switchTo().alert().getText();
        System.out.println("Alert message after right-click: " + alertText);
        Assert.assertTrue(alertText.contains("You selected a context menu"), "Context click verification failed!");

        // Pranojme alert-in
        driver.switchTo().alert().accept();
        System.out.println("Alert accepted successfully.");

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