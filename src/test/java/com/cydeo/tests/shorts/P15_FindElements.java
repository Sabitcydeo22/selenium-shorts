package com.cydeo.tests.shorts;

import com.cydeo.tests.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class P15_FindElements {

    public static void main(String[] args) throws InterruptedException {

        // 1. Marrim drajverin duke perdorur WebDriverFactory
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        try {
            // 2. Hapim faqen e testimit
            driver.get("https://practice.expandtesting.com/");

            // 3. Gjejme te gjitha linket ne faqe (tag name eshte "a")
            // findElements kthen List<WebElement>
            List<WebElement> allLinks = driver.findElements(By.tagName("a"));

            // 4. Printojme numrin e pergjithshem te linqeve
            System.out.println("Numri i pergjithshem i linqeve: " + allLinks.size());

            // 5. Lexojme tekstin e disa prej linqeve me ane te ciklit for-each
            int counter = 0;
            for (WebElement eachLink : allLinks) {
                String text = eachLink.getText();
                String href = eachLink.getAttribute("href");

                // Printojme vetem ato linqe qe kane tekst te dukshem (deri ne 5 shembuj)
                if (!text.isEmpty() && counter < 5) {
                    System.out.println("Link " + (counter + 1) + ": " + text + " -> " + href);
                    counter++;
                }
            }

            Thread.sleep(2000);

        } finally {
            // 6. Mbyllim shfletuesin
            driver.quit();
        }
    }
}
