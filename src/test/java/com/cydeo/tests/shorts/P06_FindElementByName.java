package com.cydeo.tests.shorts;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class P06_FindElementByName {

    public static void main(String[] args) {

        // Konfigurimi i drajverit te Chrome
        WebDriverManager.chromedriver().setup();

        // Hapja e shfletuesit Chrome
        WebDriver driver = new ChromeDriver();

        // Zmadhimi i dritares ne madhesi maksimale
        driver.manage().window().maximize();

        // Shkon te faqja e Google
        driver.get("https://google.com");

        // Gjen fushen e kerkimit permes atributit name="q"
        WebElement searchBox = driver.findElement(By.name("q"));

        // Shkruan fjalen "apple" dhe shtyp tastin ENTER automatikisht
        searchBox.sendKeys("apple" + Keys.ENTER);

    }
}