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
import java.util.Set;

public class P28_WindowHandling {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        // Hapim faqen me butonin qe cel nje tab te ri
        driver.get("https://practice.expandtesting.com/windows");
    }

    @Test
    public void switchWindowTest() throws InterruptedException {
        System.out.println("Starting Window/Tab handling test...");

        // Hapi 1: Ruajme kodin e dritares kryesore te pare
        String mainWindowHandle = driver.getWindowHandle();
        System.out.println("Main Window ID: " + mainWindowHandle);

        // Pauze 2 sekonda para klikimit
        Thread.sleep(2000);

        // Hapi 2: Klikojme linkun qe hap dritaren/tab-in e ri
        WebElement clickHereLink = driver.findElement(By.linkText("Click Here"));
        clickHereLink.click();
        System.out.println("Clicked link to open a new tab.");

        // Pauze 2 sekonda qe te shohesh me sy hapjen e tab-it te dyte
        Thread.sleep(2000);

        // Hapi 3: Marrim kodet e te gjitha dritareve te hapura
        Set<String> allWindowHandles = driver.getWindowHandles();
        System.out.println("Total open windows: " + allWindowHandles.size());

        // Hapi 4: Kalojme fokusin te tab-i i ri
        for (String eachHandle : allWindowHandles) {
            if (!eachHandle.equals(mainWindowHandle)) {
                driver.switchTo().window(eachHandle);
                System.out.println("Switched focus to new window ID: " + eachHandle);
                break;
            }
        }

        // Pauze 2 sekonda brenda tab-it te ri
        Thread.sleep(2000);

        // Hapi 5: Verifikojme tekstin ne faqen e re
        WebElement newPageText = driver.findElement(By.tagName("h1"));
        System.out.println("Header in new tab: " + newPageText.getText());
        Assert.assertTrue(newPageText.isDisplayed(), "Header on new tab is not visible!");

        // Hapi 6: Kthehemi serish te tab-i i pare kryesor
        driver.switchTo().window(mainWindowHandle);
        System.out.println("Switched back to main window.");

        // Pauze 3 sekonda ne fund qe ta shohesh shfletuesin te kthyer te faqja e pare para mbylljes
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