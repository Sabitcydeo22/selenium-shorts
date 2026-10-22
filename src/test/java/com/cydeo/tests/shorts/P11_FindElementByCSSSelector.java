package com.cydeo.tests.shorts;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class P11_FindElementByCSSSelector {

    public static void main(String[] args) throws InterruptedException {

        // 1. Setup ChromeDriver and open browser
        // Konfigurimi i drajverit dhe hapja e Chrome
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // 2. Navigate to stable practice website
        // Shkon te faqja e sigurt per testim
        driver.get("https://the-internet.herokuapp.com/");

        // 3. Locate element using CSS Selector: tagName[attribute='value']
        // Gjen elementin duke perdorur sintaksen CSS: tag[atribut='vlere']
        WebElement pageHeader = driver.findElement(By.cssSelector("h1[class='heading']"));

        // 4. Verify text content
        // Verifikon nese teksti i elementit perputhet me ate qe presim
        if (pageHeader.getText().equals("Welcome to the-internet")) {
            System.out.println("Text verification of header is passed!");
        } else {
            System.out.println("Text verification of header is failed!");
        }

        // 5. Wait 3 seconds to observe
        // Pret 3 sekonda
        Thread.sleep(3000);

        // 6. Close the browser cleanly
        // Mbyll shfletuesin teresisht
        driver.quit();
    }
}
