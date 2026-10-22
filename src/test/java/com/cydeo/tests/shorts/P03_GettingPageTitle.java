package com.cydeo.tests.shorts;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class P03_GettingPageTitle {

    public static void main(String[] args) {

        // 1. Konfigurimi i drajverit dhe hapja e shfletuesit Chrome
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // 2. Navigimi te faqja e testimit
        driver.get("https://practice.expandtesting.com/");

        // 3. Marrja e titullit dhe URL-se aktuale nga shfletuesi
        String actualTitle = driver.getTitle();
        String actualUrl = driver.getCurrentUrl();

        System.out.println("Actual Title: " + actualTitle);
        System.out.println("Actual URL: " + actualUrl);

        // 4. Verifikimi i titullit (Basic Title Verification)
        String expectedTitle = "Automation Testing Practice";

        if (actualTitle.contains(expectedTitle)) {
            System.out.println("TEST PASSED: Title verification successful!");
        } else {
            System.out.println("TEST FAILED: Title verification failed!");
        }

        // 5. Verifikimi i URL-se (URL Verification)
        String expectedUrl = "practice.expandtesting.com";

        if (actualUrl.contains(expectedUrl)) {
            System.out.println("TEST PASSED: URL verification successful!");
        } else {
            System.out.println("TEST FAILED: URL verification failed!");
        }

        // 6. Mbyllja e plote e shfletuesit
        driver.quit();
    }
}