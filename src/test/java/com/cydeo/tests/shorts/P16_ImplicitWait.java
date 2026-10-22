package com.cydeo.tests.shorts;

import com.cydeo.tests.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;

public class P16_ImplicitWait {

    public static void main(String[] args) {

        // 1. Inicializimi i drajverit
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        // 2. Vendosja e Implicit Wait per 10 sekonda
        // Selenium do te prese deri ne 10 sekonda per cdo element para se te jape gabim
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        try {
            // 3. Hapim faqen e testimit
            driver.get("https://practice.expandtesting.com/dynamic-loading");

            // 4. Klikojme shembullin e pare per elementet qe vonojne te shfaqen
            WebElement example1Link = driver.findElement(By.partialLinkText("Example 1"));
            example1Link.click();

            // 5. Klikojme butonin Start
            WebElement startBtn = driver.findElement(By.xpath("//button[text()='Start']"));
            startBtn.click();

            // 6. Selenium pret ne menyre dinamike derisa teksti te shfaqet brenda kufirit prej 10 sekondash
            WebElement resultText = driver.findElement(By.xpath("//div[@id='finish']/h4"));
            System.out.println("Teksti i shfaqur pas ngarkimit: " + resultText.getText());

        } catch (Exception e) {
            System.out.println("Testi deshtoi ose elementi nuk u gjet brenda kohes: " + e.getMessage());
        } finally {
            // 7. Mbyllja e shfletuesit
            driver.quit();
        }
    }
}
