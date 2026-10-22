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

public class P30_WebTable_Dynamic {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        // Navigojme tek faqja e tabelave
        driver.get("https://practice.expandtesting.com/tables");
    }

    @Test
    public void dynamicTableCellVerificationTest() throws InterruptedException {
        System.out.println("Starting dynamic WebTable verification test...");

        // Pauze 2 sekonda para zbritjes te tabela
        Thread.sleep(2000);

        // Hapi 1: Bëjmë scroll te tabela që ta shohësh qartë në ekran
        WebElement table = driver.findElement(By.id("table1"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", table);

        // Pauze 2 sekonda për ta vëzhguar tabelën
        Thread.sleep(2000);

        // Hapi 2: Lokalizojmë dinamikisht vlerën 'Due' ($50.00) për personin 'John'
        // XPath: Gjen qelizen me emrin 'John' dhe shkon te qeliza 'Due' (kolona 4)
        String targetName = "John";
        WebElement johnDueCell = driver.findElement(By.xpath("//table[@id='table1']//td[.='" + targetName + "']/following-sibling::td[2]"));

        String actualDueAmount = johnDueCell.getText();
        System.out.println("Due amount for " + targetName + " is: " + actualDueAmount);

        // Pauze 2 sekonda për të konfirmuar leximin
        Thread.sleep(2000);

        // Hapi 3: Verifikojmë me Assertion vlerën e nxjerrë
        Assert.assertEquals(actualDueAmount, "$50.00", "Due amount verification failed!");

        // Pauze 3 sekonda para mbylljes së shfletuesit
        Thread.sleep(3000);
        System.out.println("Dynamic WebTable assertion verified successfully.");
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
            System.out.println("Browser closed successfully.\n");
        }
    }
}