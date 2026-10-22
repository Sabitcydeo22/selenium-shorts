package com.cydeo.tests.shorts;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class P10_FindElementByPartialLinkText {

    public static void main(String[] args) throws InterruptedException {

        // 1. Setup ChromeDriver and open the browser
        // Konfigurimi i drajverit dhe hapja e Chrome
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // 2. Navigate to stable test website
        // Shkon te faqja e sigurt per testim
        driver.get("https://the-internet.herokuapp.com/");

        // 3. Locate element using By.partialLinkText (takes only part of visible link text)
        // Gjen linkun duke dhene vetem nje pjese te tekstit: "Testing" ne vend te "A/B Testing"
        WebElement ABTestingLink = driver.findElement(By.partialLinkText("Testing"));

        // 4. Click the matched link
        // Klikon mbi linkun e gjetur
        ABTestingLink.click();

        // 5. Wait 3 seconds to see the new page
        // Pret 3 sekonda per te pare faqen e hapur
        Thread.sleep(3000);

        // 6. Close the browser cleanly
        // Mbyll shfletuesin teresisht
        driver.quit();
    }
}