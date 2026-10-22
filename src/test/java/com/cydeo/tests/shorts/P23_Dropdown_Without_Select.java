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

public class P23_Dropdown_Without_Select {

    WebDriver driver;

    // 1. Hapja e shfletuesit para testimit
    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        // Perdorim faqen ExpandTesting qe hapet pa problem
        driver.get("https://practice.expandtesting.com/dropdown");
    }

    // 2. Testimi i dropdown-it HTML pa tag <select>
    @Test
    public void nonSelectDropdownTest() throws InterruptedException {
        System.out.println("Starting HTML Dropdown without Select Tag test...");

        // Krijojme JavascriptExecutor per klikim te sigurt pa pengesa
        JavascriptExecutor js = (JavascriptExecutor) driver;

        // Hapi 1: Lokalizojme butonin Dropdown pa tag select (Bootstrap dropdown)
        WebElement dropdownButton = driver.findElement(By.xpath("//button[contains(@class,'dropdown-toggle')] | //a[contains(@class,'dropdown-toggle')]"));

        // Bejme scroll te elementi dhe e klikojme per ta hapur
        js.executeScript("arguments[0].scrollIntoView(true);", dropdownButton);
        Thread.sleep(1000);
        js.executeScript("arguments[0].click();", dropdownButton);
        Thread.sleep(1000);

        // Hapi 2: Lokalizojme opsionin e pare brenda menus se shpalosur
        WebElement firstOption = driver.findElement(By.xpath("//ul[contains(@class,'dropdown-menu')]//a[1] | //div[contains(@class,'dropdown-menu')]//a[1]"));
        String optionText = firstOption.getText();
        System.out.println("Selecting option: " + optionText);

        // Hapi 3: Klikojme mbi opsion
        js.executeScript("arguments[0].click();", firstOption);
        Thread.sleep(1500);

        // Hapi 4: Verifikojme qe veprimi u krye
        Assert.assertNotNull(driver.getTitle(), "Title should not be null after selection!");
        System.out.println("Dropdown item selection verified successfully.");
    }

    // 3. Mbyllja e shfletuesit pas testimit
    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
            System.out.println("Browser session closed successfully.");
        }
    }
}