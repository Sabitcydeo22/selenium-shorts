package com.cydeo.tests.shorts;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class P04_FullScreenMode {

    public static void main(String[] args) throws InterruptedException {

        // 1. Setup ChromeDriver and open the browser
        // Konfigurimi i drajverit dhe hapja e dritares se Chrome
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        // 2. Maximize the window (standard maximized view)
        // Zmadhon dritaren normale ne madhesine e plote te ekranit
        driver.manage().window().maximize();

        // 3. Navigate to a test website
        // Shkon te faqja e testimit
        driver.get("https://practice.expandtesting.com/");

        // 4. Wait for 2 seconds to see maximize state
        // Pret 2 sekonda per te pare gjendjen e zmadhuar
        Thread.sleep(2000);

        // 5. Switch to full screen mode (hides browser tabs, address bar, and OS taskbar - like F11)
        // Kalon ne Full Screen te plote (zhduk shiritin e shfletuesit dhe taskbar-in, njelloj si F11)
        driver.manage().window().fullscreen();

        // 6. Wait for 3 seconds in full screen mode
        // Pret 3 sekonda ne Full Screen
        Thread.sleep(3000);

        // 7. Close and quit the browser
        // Mbyll shfletuesin teresisht
        driver.quit();
    }
}