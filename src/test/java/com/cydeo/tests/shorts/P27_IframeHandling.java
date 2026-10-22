package com.cydeo.tests.shorts;

import com.cydeo.tests.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class P27_IframeHandling {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        // Navigojme tek faqja e testimit per iframe
        driver.get("https://practice.expandtesting.com/iframe");
    }

    @Test
    public void iframeInteractionTest() throws InterruptedException {
        System.out.println("Starting iFrame handling test...");

        // Hapi 1: Kalojme fokusin brenda kornizes iframe permes ID-se
        driver.switchTo().frame("mce_0_ifr");
        System.out.println("Switched inside the iframe successfully.");

        // Hapi 2: Lokalizojme paragrafin <p> brenda editorit TinyMCE
        WebElement paragraph = driver.findElement(By.xpath("//body[@id='tinymce']/p"));
        System.out.println("Text inside iframe before update: " + paragraph.getText());

        // Perditesojme tekstin pa shkaktuar InvalidElementStateException
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].innerText = 'Selenium Automation inside iFrame - Sabit';", paragraph);
        Thread.sleep(1500);

        // Verifikojme qe teksti i ri ndodhet ne iframe
        String updatedText = paragraph.getText();
        System.out.println("Updated text inside iframe: " + updatedText);
        Assert.assertTrue(updatedText.contains("Sabit"), "Text verification inside iframe failed!");

        // Hapi 3: Kthehemi ne dokumentin kryesor HTML
        driver.switchTo().defaultContent();
        System.out.println("Switched back to main HTML content.");

        // Hapi 4: Verifikojme titullin kryesor jashte kornizes
        WebElement pageHeader = driver.findElement(By.tagName("h1"));
        Assert.assertTrue(pageHeader.isDisplayed(), "Header on main page is not visible!");
        System.out.println("Main page header verified: " + pageHeader.getText());
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
            System.out.println("Browser closed successfully.\n");
        }
    }
}