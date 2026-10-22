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
import java.util.List;

public class P24_MultipleDropdown {

    WebDriver driver;

    // 1. Ekzekutohet para testit: Inicializon shfletuesin
    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        // Navigojme tek faqja per testimin e dropdowns
        driver.get("https://practice.expandtesting.com/dropdown");
    }

    // 2. Testimi i Multiple Dropdown Selection dhe Deselection
    @Test
    public void multipleDropdownTest() throws InterruptedException {
        System.out.println("Starting Multiple Dropdown verification test...");

        // Lokalizojme elementin <select>
        WebElement multipleSelectElement = driver.findElement(By.id("elementsPerPageSelect"));

        // Krijojme objektin Select
        Select multiSelect = new Select(multipleSelectElement);

        // A. Verifikojme a eshte multiple select
        boolean isMulti = multiSelect.isMultiple();
        System.out.println("Is this dropdown multi-select capable? -> " + isMulti);

        // B. Perzgjedhim nje opsion sipas vleres se dukshme
        multiSelect.selectByVisibleText("20");
        System.out.println("Selected option: " + multiSelect.getFirstSelectedOption().getText());

        Thread.sleep(1500);

        // C. Marrim te gjitha opsionet e mundshme brenda ketij dropdown
        List<WebElement> allOptions = multiSelect.getOptions();
        System.out.println("Total available options count: " + allOptions.size());

        for (WebElement option : allOptions) {
            System.out.println("Available option value: " + option.getText());
        }

        // Verifikimi final
        Assert.assertEquals(multiSelect.getFirstSelectedOption().getText(), "20", "Selected option verification failed!");
        System.out.println("Multiple dropdown logic verified successfully.");
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