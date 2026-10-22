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

public class P32_Actions_HoverOver {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        // Hapim faqen e posacme per Hovering
        driver.get("https://practice.expandtesting.com/hovers");
    }

    @Test
    public void hoverOverTest() throws InterruptedException {
        System.out.println("Starting Actions Hover Over test...");

        // Krijojme objektin e klases Actions
        Actions actions = new Actions(driver);

        // Pauze 2 sekonda perpara se te fillojme veprimin
        Thread.sleep(2000);

        // Hapi 1: Lokalizojme foton e perdoruesit te pare (User 1)
        WebElement user1Image = driver.findElement(By.xpath("(//div[@class='figure'])[1]"));

        // Hapi 2: Levizim mausin mbi foton e pare (Hover)
        actions.moveToElement(user1Image).perform();
        System.out.println("Hovered over User 1 avatar.");

        // Pauze 2 sekonda qe te shohesh me sy emrin dhe linkun qe shfaqen nen foto
        Thread.sleep(2000);

        // Hapi 3: Verifikojme qe teksti 'name: user1' eshte shfaqur dhe eshte i dukshem
        WebElement user1Text = driver.findElement(By.xpath("//h5[contains(text(),'name: user1')]"));
        Assert.assertTrue(user1Text.isDisplayed(), "User 1 text is not displayed after hover!");
        System.out.println("Verified visible text: " + user1Text.getText());

        // Hapi 4: Levizim mausin mbi foton e dyte (User 2)
        WebElement user2Image = driver.findElement(By.xpath("(//div[@class='figure'])[2]"));
        actions.moveToElement(user2Image).perform();
        System.out.println("Hovered over User 2 avatar.");

        // Pauze 2 sekonda qe te shohesh kalimin e kursorit te perdoruesi i dyte
        Thread.sleep(2000);

        // Hapi 5: Verifikojme qe teksti 'name: user2' eshte shfaqur
        WebElement user2Text = driver.findElement(By.xpath("//h5[contains(text(),'name: user2')]"));
        Assert.assertTrue(user2Text.isDisplayed(), "User 2 text is not displayed after hover!");
        System.out.println("Verified visible text: " + user2Text.getText());

        // Pauze 3 sekonda para mbylljes
        Thread.sleep(3000);
        System.out.println("Actions hover test completed successfully.");
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
            System.out.println("Browser closed successfully.\n");
        }
    }
}