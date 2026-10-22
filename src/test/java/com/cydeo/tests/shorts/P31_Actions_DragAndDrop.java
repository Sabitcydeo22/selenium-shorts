package com.cydeo.tests.shorts;

import com.cydeo.tests.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class P31_Actions_DragAndDrop {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        // Hapim faqen e testimit per Drag and Drop
        driver.get("https://practice.expandtesting.com/drag-and-drop");
    }

    @Test
    public void dragAndDropTest() throws InterruptedException {
        System.out.println("Starting Drag and Drop test...");

        // Krijojme objektin Actions
        Actions actions = new Actions(driver);

        // Pauze 2 sekonda perpara veprimit
        Thread.sleep(2000);

        // Hapi 1: Lokalizojme elementin burim (Kutia A) dhe destinacion (Kutia B)
        WebElement columnA = driver.findElement(By.id("column-a"));
        WebElement columnB = driver.findElement(By.id("column-b"));

        System.out.println("Text in Box A before drag: " + columnA.getText());
        System.out.println("Text in Box B before drag: " + columnB.getText());

        // Hapi 2: Terheqim Kutine A dhe e leshojme mbi Kutine B
        actions.dragAndDrop(columnA, columnB).perform();
        System.out.println("Executed Drag and Drop action.");

        // Pauze 2 sekonda qe te shohesh me sy shkembimin e kutive ne ekran
        Thread.sleep(2000);

        // Hapi 3: Verifikojme qe kutia e pare tani permban shkronjen 'B'
        Assert.assertEquals(columnA.getText(), "B", "Drag and Drop verification failed!");
        System.out.println("Drag and Drop successfully verified.");

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