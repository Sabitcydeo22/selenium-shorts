package com.cydeo.tests.shorts;

// Import tools from external libraries
// Importon veglat e nevojshme nga libraritë e jashtme të Selenium dhe WebDriverManager
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class P01_BasicNavigations {

    // Main method to run Java code
    // Metoda kryesore nga ku nis ekzekutimi i çdo kodi në Java
    public static void main(String[] args) {

        // 1. Set up the Chrome browser driver
        // Shkarkon dhe konfigurimin automatikisht drajverin e përshtatshëm për versionin tënd të Chrome
        WebDriverManager.chromedriver().setup();

        // 2. Open an empty Chrome browser window
        // Hap një dritare krejt të re dhe të zbrazët në shfletuesin Chrome
        WebDriver driver = new ChromeDriver();

        // 3. Maximize the browser window
        // Zmadhon dritaren e shfletuesit në madhësinë e plotë të ekranit
        driver.manage().window().maximize();

        // 4. Navigate to the target web page
        // Dërgon shfletuesin te faqja e caktuar e testimit
        driver.get("https://practice.expandtesting.com/");

        // 5. Get the page title and print it in the console
        // Merr titullin aktual të faqes së hapur dhe e shfaq në konzollën e IntelliJ
        String title = driver.getTitle();
        System.out.println("Page Title is: " + title);

    }
}
