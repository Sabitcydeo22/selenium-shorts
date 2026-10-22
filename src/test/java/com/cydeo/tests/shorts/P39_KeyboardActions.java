package com.cydeo.tests.shorts;

import com.cydeo.tests.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class P39_KeyboardActions {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        // Hapim faqen e fushave te inputit
        driver.get("https://practice.expandtesting.com/inputs");
    }

    @Test
    public void keyboardActionsTest() throws InterruptedException {
        System.out.println("Starting Keyboard Actions test...");

        // Pauze 2 sekonda para fillimit
        Thread.sleep(2000);

        // Hapi 1: Lokalizojme fushen e pare te tekstit (Input text)
        WebElement inputField = driver.findElement(By.id("input-text"));

        // Bejme scroll te fusha per ta pare qarte ne ekran
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", inputField);
        Thread.sleep(1000);

        // Hapi 2: Krijojme objektin Actions per tastieren
        Actions actions = new Actions(driver);

        // Hapi 3: Klikojme fushen, mbajme SHIFT te shtypur, shkruajme 'sabit', dhe e leshojme SHIFT
        // Kjo duhet ta shkruaje fjalen plotesisht me te medha: 'SABIT'
        actions.click(inputField)
                .keyDown(Keys.SHIFT)
                .sendKeys("sabit")
                .keyUp(Keys.SHIFT)
                .perform();

        System.out.println("Typed 'sabit' while holding SHIFT key.");

        // Pauze 2 sekonda qe ta shohesh qarte ne ekran tekstin me te medha 'SABIT'
        Thread.sleep(2000);

        // Hapi 4: Verifikojme qe teksti u shkrua me shkronja te medha
        String typedText = inputField.getAttribute("value");
        System.out.println("Text inside input field: " + typedText);
        Assert.assertEquals(typedText, "SABIT", "Keyboard SHIFT action verification failed!");

        // Hapi 5: Shtypim tastin BACK_SPACE per te fshire shkronjen e fundit ('T')
        inputField.sendKeys(Keys.BACK_SPACE);
        System.out.println("Pressed BACK_SPACE key.");

        // Pauze 2 sekonda qe ta shohesh ne ekran ndryshimin ne 'SABI'
        Thread.sleep(2000);

        // Hapi 6: Verifikojme qe mbeti 'SABI'
        Assert.assertEquals(inputField.getAttribute("value"), "SABI", "BACK_SPACE verification failed!");

        // Pauze 3 sekonda para mbylljes
        Thread.sleep(3000);
        System.out.println("Keyboard actions test completed successfully.");
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
            System.out.println("Browser closed successfully.\n");
        }
    }
}