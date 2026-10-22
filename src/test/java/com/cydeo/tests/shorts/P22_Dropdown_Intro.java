package com.cydeo.tests.shorts;

import com.cydeo.tests.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class P22_Dropdown_Intro {

    WebDriver driver;

    // 1. Ekzekutohet para testit: Inicializon drajverin dhe hap shfletuesin
    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://practice.expandtesting.com/dropdown");
    }

    // 2. Testi kryesor per perzgjedhjen nga dropdown
    @Test
    public void selectDropdownTest() throws InterruptedException {
        System.out.println("Starting Dropdown selection test...");

        // Lokalizojme elementin <select> ne HTML
        WebElement dropdownElement = driver.findElement(By.id("dropdown"));

        // Krijojme objektin e klases Select duke i kaluar elementin e gjetur
        Select simpleDropdown = new Select(dropdownElement);

        // A. Perzgjedhja me Visible Text (sipas tekstit qe shihet)
        simpleDropdown.selectByVisibleText("Option 1");
        String actualSelectedText = simpleDropdown.getFirstSelectedOption().getText();
        Assert.assertEquals(actualSelectedText, "Option 1", "Visible text selection failed!");
        System.out.println("Selected by visible text: " + actualSelectedText);

        Thread.sleep(1500);

        // B. Perzgjedhja me Index (pozita e elementit, 2 per Option 2)
        simpleDropdown.selectByIndex(2);
        actualSelectedText = simpleDropdown.getFirstSelectedOption().getText();
        Assert.assertEquals(actualSelectedText, "Option 2", "Index selection failed!");
        System.out.println("Selected by index: " + actualSelectedText);

        Thread.sleep(1500);

        // C. Perzgjedhja me Value (sipas atributit value='1')
        simpleDropdown.selectByValue("1");
        actualSelectedText = simpleDropdown.getFirstSelectedOption().getText();
        Assert.assertEquals(actualSelectedText, "Option 1", "Value selection failed!");
        System.out.println("Selected by attribute value: " + actualSelectedText);
    }

    // 3. Ekzekutohet pas testit: Mbyll shfletuesin
    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
            System.out.println("Browser closed successfully.");
        }
    }
}
