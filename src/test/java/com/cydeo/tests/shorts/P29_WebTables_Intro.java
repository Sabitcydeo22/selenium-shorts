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
import java.util.List;

public class P29_WebTables_Intro {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        // Hapim faqen e testimit per Web Tables
        driver.get("https://practice.expandtesting.com/tables");
    }

    @Test
    public void webTableDataReadTest() throws InterruptedException {
        System.out.println("Starting WebTable verification test...");

        // Pauze 2 sekonda para zbritjes te tabela
        Thread.sleep(2000);

        // Hapi 1: Lokalizojme tabelen e pare (Table 1)
        WebElement table1 = driver.findElement(By.id("table1"));

        // Bejme scroll te tabela qe ta shohesh qarte ne ekran
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", table1);
        System.out.println("Scrolled into view of Table 1.");

        // Pauze 2 sekonda per ta pare tabelen ne ekran
        Thread.sleep(2000);

        // Hapi 2: Gjejme numrin e rreshtave brenda trupit te tabeles (tbody -> tr)
        List<WebElement> allRows = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr"));
        int rowCount = allRows.size();
        System.out.println("Total rows count in table: " + rowCount);
        Assert.assertTrue(rowCount > 0, "Table should have at least one row!");

        // Hapi 3: Lexojme te gjitha te dhenat e rreshtit te pare
        WebElement firstRow = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[1]"));
        System.out.println("First row data: " + firstRow.getText());

        // Hapi 4: Lexojme nje qelize specifike (psh. Rreshti 2, Kolona 2 - Emri)
        WebElement cellRow2Col2 = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[2]/td[2]"));
        String cellText = cellRow2Col2.getText();
        System.out.println("Specific Cell (Row 2, Column 2 - First Name): " + cellText);

        // Pauze 3 sekonda para mbylljes qe te shohesh te dhenat ne ekran
        Thread.sleep(3000);
        System.out.println("WebTable data read successfully.");
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
            System.out.println("Browser closed successfully.\n");
        }
    }
}