package com.cydeo.tests.shorts;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class P12_FindElementByXpath {

    public static void main(String[] args) throws InterruptedException {

        // 1. Setup ChromeDriver and open the browser
        // Konfigurimi i drajverit dhe hapja e Chrome
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // 2. Navigate to Forgot Password practice page
        // Shkon te faqja e rikuperimit te fjalekalimit
        driver.get("https://the-internet.herokuapp.com/forgot_password");

        // 3. Locate email input field using XPath syntax: //tagName[@attribute='value']
        // Gjen fushen e email-it permes XPath
        WebElement emailBox = driver.findElement(By.xpath("//input[@type='text']"));

        // 4. Send email text into the input field
        // Shkruan adresen e email-it ne fushe
        emailBox.sendKeys("abc@email.com");

        // 5. Locate retrieve password button using XPath
        // Gjen butonin e formes permes ID-se me sintaksen XPath
        WebElement retrievePasswordButton = driver.findElement(By.xpath("//button[@id='form_submit']"));

        // 6. Click the submit button
        // Klikon mbi buton
        retrievePasswordButton.click();

        // 7. Wait 3 seconds to observe the result
        // Pret 3 sekonda per te pare rezultatin
        Thread.sleep(3000);

        // 8. Close the browser cleanly
        // Mbyll shfletuesin plotesisht
        driver.quit();
    }
}
