package com.cydeo.tests.shorts;

import com.cydeo.tests.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;

public class P17_RadioButtons_CheckBoxes {

    public static void main(String[] args) throws InterruptedException {

        // 1. Inicializimi i WebDriver permes fabrikes
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // 2. Krijimi i JavascriptExecutor per klikime te sigurta ne rast bllokimi te kursorit
        JavascriptExecutor js = (JavascriptExecutor) driver;

        try {
            // ----------------- RADIO BUTTONS VERIFICATION -----------------
            driver.get("https://practice.expandtesting.com/radio-buttons");

            // Lokalizimi i radio button per Blue
            WebElement blueRadioBtn = driver.findElement(By.cssSelector("input#blue"));
            System.out.println("Is Blue radio button selected initially? -> " + blueRadioBtn.isSelected());

            // Lokalizimi i radio button per Black
            WebElement blackRadioBtn = driver.findElement(By.cssSelector("input#black"));
            System.out.println("Is Black radio button selected before click? -> " + blackRadioBtn.isSelected());

            // Klikimi i sigurt me JavaScript
            js.executeScript("arguments[0].click();", blackRadioBtn);
            System.out.println("Is Black radio button selected after click? -> " + blackRadioBtn.isSelected());

            Thread.sleep(2000);

            // ----------------- CHECKBOXES VERIFICATION -----------------
            driver.get("https://practice.expandtesting.com/checkboxes");

            WebElement checkbox1 = driver.findElement(By.id("checkbox1"));
            WebElement checkbox2 = driver.findElement(By.id("checkbox2"));

            System.out.println("\nCheckbox 1 selected before click: " + checkbox1.isSelected());
            System.out.println("Checkbox 2 selected before click: " + checkbox2.isSelected());

            // Klikimi i checkbox1 per ta zgjedhur
            js.executeScript("arguments[0].click();", checkbox1);

            // Nese checkbox2 eshte i zgjedhur, e klikojme per ta çzgjedhur (deselect)
            if (checkbox2.isSelected()) {
                js.executeScript("arguments[0].click();", checkbox2);
            }

            System.out.println("Checkbox 1 selected after click: " + checkbox1.isSelected());
            System.out.println("Checkbox 2 selected after click: " + checkbox2.isSelected());

            Thread.sleep(2000);

        } finally {
            // Mbyllja e sesionit te drajverit
            driver.quit();
            System.out.println("\nRadio Buttons and Checkboxes test execution completed successfully.");
        }
    }
}
