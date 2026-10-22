package com.cydeo.tests.shorts;

import com.cydeo.tests.utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;

public class P14_UsingWebDriverFactory {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        try {
            driver.get("https://practice.expandtesting.com/");

            String actualTitle = driver.getTitle();
            System.out.println("Titulli aktual i faqes: " + actualTitle);

            if (actualTitle.toLowerCase().contains("practice")) {
                System.out.println("Verifikimi i titullit: PASSED!");
            } else {
                System.out.println("Verifikimi i titullit: FAILED!");
            }

            Thread.sleep(3000);

        } finally {
            driver.quit();
            System.out.println("Shfletuesi u mbyll me sukses.");
        }
    }
}
