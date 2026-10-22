package com.cydeo.tests.shorts;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class P02_Close_Quit_Page {

    public static void main(String[] args) throws InterruptedException {

        // 1. Konfigurimi i drajverit per Chrome
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // 2. Navigimi te faqja e testimit
        driver.get("https://practice.expandtesting.com/");

        // 3. Pritje 3 sekonda per vezhgim
        Thread.sleep(3000);

        // 4. close() mbyll vetem tab-in aktiv aktual
        driver.close();

        // 5. quit() mbyll te gjitha dritaret/tab-et dhe shuan plotesisht sesionin e drajverit
        // (ketu eshte komentuar sepse close() e mbylli tab-in e vetem)
        // driver.quit();
    }
}