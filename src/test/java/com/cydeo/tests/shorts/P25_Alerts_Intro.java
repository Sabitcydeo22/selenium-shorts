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

public class P25_Alerts_Intro {

    WebDriver driver;

    // 1. Inicializimi i shfletuesit para testimit
    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        // Hapim faqen e testimit per Alerts
        driver.get("https://practice.expandtesting.com/js-dialogs");
    }

    // 2. Testimi i Information Alert (Alert me butonin OK)
    @Test
    public void jsInformationAlertTest() throws InterruptedException {
        System.out.println("Starting JS Information Alert test...");

        // Hapi 1: Klikojme butonin qe shfaq dritaren kercyese (JS Alert)
        WebElement jsAlertBtn = driver.findElement(By.id("js-alert"));
        jsAlertBtn.click();

        Thread.sleep(1500);

        // Hapi 2: Kalojme fokusin e Seleniumit tek dritarja Alert
        Alert alert = driver.switchTo().alert();

        // Hapi 3: Marrim tekstin e alert-it dhe e verifikojme (me 'Js' ekzakt)
        String alertText = alert.getText();
        System.out.println("Alert message text: " + alertText);
        Assert.assertEquals(alertText, "I am a Js Alert", "Alert text does not match!");

        // Hapi 4: Klikojme OK per ta pranuar dhe mbyllur alert-in
        alert.accept();

        Thread.sleep(1500);

        // Hapi 5: Verifikojme mesazhin e suksesit ne faqe
        WebElement resultText = driver.findElement(By.id("dialog-response"));
        System.out.println("Result text on page: " + resultText.getText());
        Assert.assertTrue(resultText.getText().contains("OK"), "Result verification failed!");
        System.out.println("JS Alert handled and verified successfully.");
    }

    // 3. Mbyllja e shfletuesit pas testimit
    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
            System.out.println("Browser closed successfully.");
        }
    }
}
