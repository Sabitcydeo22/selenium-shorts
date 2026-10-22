package com.cydeo.tests.shorts;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class P07_FindElementByClassName {

    public static void main(String[] args) throws InterruptedException {

        // 1. Setup ChromeDriver and open browser
        // Konfigurimi dhe hapja e Chrome
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // 2. Navigate to stable practice website
        // Shkon te faqja e sigurt per ushtrime automatizimi
        driver.get("https://the-internet.herokuapp.com/");

        // 3. Locate element by ClassName (titulli kryesor h1 ka pikerisht class="heading")
        // Gjen elementin me klasen "heading"
        WebElement pageHeader = driver.findElement(By.className("heading"));

        // 4. Print text to console
        // Shfaq tekstin ne console (do te dale: "Welcome to the-internet")
        System.out.println("Element text: " + pageHeader.getText());

        // 5. Wait 3 seconds
        // Pret 3 sekonda
        Thread.sleep(3000);

        // 6. Close the browser
        // Mbyll shfletuesin
        driver.quit();
    }
}