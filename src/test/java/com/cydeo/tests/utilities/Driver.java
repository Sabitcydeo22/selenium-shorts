package com.cydeo.tests.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class Driver {

    // Konstruktori privat ndalon krijimin e instancave me "new Driver()"
    private Driver() {}

    // Instanca e vetme e WebDriver (Singleton)
    private static WebDriver driver;

    public static WebDriver getDriver() {
        if (driver == null) {
            // Lexon nga komanda nëse ekziston (-Dbrowser=...), përndryshe nga configuration.properties
            String browserType = System.getProperty("browser") != null
                    ? System.getProperty("browser")
                    : ConfigurationReader.getProperty("browser");

            switch (browserType.toLowerCase()) {
                case "chrome":
                    driver = WebDriverFactory.getDriver("chrome");
                    break;
                case "chrome-headless":
                    ChromeOptions options = new ChromeOptions();
                    options.addArguments("--headless=new");
                    driver = new ChromeDriver(options);
                    break;
                case "firefox":
                    driver = WebDriverFactory.getDriver("firefox");
                    break;
                default:
                    throw new RuntimeException("Shfletuesi i panjohur: " + browserType);
            }

            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        }

        return driver;
    }

    public static void closeDriver() {
        if (driver != null) {
            driver.quit(); // mbyll të gjitha dritaret e sesionit
            driver = null; // rikthen instancën në null për testin pasues
        }
    }
}
