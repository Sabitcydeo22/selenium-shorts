package com.cydeo.tests.shorts;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class P08_FindElementByTagName {

    public static void main(String[] args) throws InterruptedException {

        // 1. Setup ChromeDriver and open browser
        // Konfigurimi i drajverit dhe hapja e Chrome
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // 2. Navigate to practice site
        // Shkon te faqja e testimit
        driver.get("https://the-internet.herokuapp.com/");

        // 3. Locate element using By.tagName
        // Gjen elementin kryesor h1 duke perdorur emrin e tag-ut HTML "h1"
        WebElement mainHeader = driver.findElement(By.tagName("h1"));

        // 4. Retrieve and print text from tag
        // Merr dhe shfaq tekstin qe ndodhet brenda tag-ut h1
        String headerText = mainHeader.getText();
        System.out.println("Text from H1 tag: " + headerText);

        // 5. Locate another element by tag name (shembull tag-u "h2")
        // Gjen nentitullin permes tag-ut "h2"
        WebElement subHeader = driver.findElement(By.tagName("h2"));
        System.out.println("Text from H2 tag: " + subHeader.getText());

        // 6. Wait 3 seconds
        // Pret 3 sekonda per vezhgim
        Thread.sleep(3000);

        // 7. Quit browser
        // Mbyll shfletuesin teresisht
        driver.quit();
    }
}