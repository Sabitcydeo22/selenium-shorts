package com.cydeo.tests.shorts;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class P09_FindElementByLinkText {

    public static void main(String[] args) throws InterruptedException {

        // 1. Setup ChromeDriver and open browser
        // Konfigurimi i drajverit dhe hapja e Chrome
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // 2. Navigate to stable practice site
        // Shkon te faqja e sigurt per testim (e cila hapet gjithmone)
        driver.get("https://the-internet.herokuapp.com/");

        // 3. Locate the link using By.linkText
        // Gjen elementin permes tekstit te plote te dukshem te linkut
        WebElement ABTestingLink = driver.findElement(By.linkText("A/B Testing"));

        // 4. Click the link
        // Klikon mbi link
        ABTestingLink.click();

        // 5. Wait 3 seconds to see the newly opened page
        // Pret 3 sekonda per te pare faqen qe u hap pas klikimit
        Thread.sleep(3000);

        // 6. Close the browser
        // Mbyll shfletuesin teresisht
        driver.quit();
    }
}