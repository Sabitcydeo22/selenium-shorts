package com.cydeo.tests.shorts;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class P13_FindElementByXpath {

    public static void main(String[] args) throws InterruptedException {

        // 1. Setup ChromeDriver and open the browser
        // Konfigurimi i drajverit dhe hapja e shfletuesit Chrome
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        try {
            // 2. Navigate to login page
            // Shkon te faqja e formes se hyrjes
            driver.get("https://practice.expandtesting.com/login");

            // 3. Fill Username using XPath
            // Gjen fushen e username-it dhe shkruan vleren
            WebElement usernameInput = driver.findElement(By.xpath("//input[@id='username']"));
            usernameInput.sendKeys("practice");

            // 4. Fill Password using XPath
            // Gjen fushen e password-it dhe shkruan fjalekalimin
            WebElement passwordInput = driver.findElement(By.xpath("//input[@id='password']"));
            passwordInput.sendKeys("SuperSecretPassword!");

            // 5. Submit form directly using submit()
            // Ben submit direkt formes pa pasur nevoje te klikoje butonin me maus
            passwordInput.submit();

            // 6. Locate confirmation message using XPath
            // Gjen mesazhin e konfirmimit
            WebElement alertMessage = driver.findElement(By.xpath("//div[@id='flash']"));

            // 7. Text verification with getText()
            // Verifikon nese teksti permban mesazhin e suksesit
            if (alertMessage.getText().contains("You logged into a secure area!")) {
                System.out.println("Text verification is passed!");
            } else {
                System.out.println("Text verification is failed!");
            }

            // 8. Retrieve and print attribute value using getAttribute()
            // Merr dhe shfaq vleren e atributit id
            System.out.println("alertMessage.getAttribute(\"id\") = " + alertMessage.getAttribute("id"));

            // 9. Wait 3 seconds to observe
            // Pret 3 sekonda
            Thread.sleep(3000);

        } finally {
            // 10. Guaranteed clean exit
            // Blloku finally ekzekutohet gjithmone duke mbyllur shfletuesin
            driver.quit();
            System.out.println("Browser closed successfully.");
        }
    }
}