package com.cydeo.tests.shorts;

import com.cydeo.tests.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Duration;

public class P35_UploadFile {

    WebDriver driver;
    File tempFile;

    @BeforeMethod
    public void setUp() throws IOException {
        // Krijojme nje skedar te thjeshte te perkohshem per testim
        tempFile = new File("test_upload.txt");
        if (!tempFile.exists()) {
            FileWriter writer = new FileWriter(tempFile);
            writer.write("Selenium File Upload Test - Sabit");
            writer.close();
        }

        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        // Hapim faqen e testimit per File Upload
        driver.get("https://practice.expandtesting.com/upload");
    }

    @Test
    public void fileUploadTest() throws InterruptedException {
        System.out.println("Starting File Upload test...");

        // Pauze 2 sekonda para ngarkimit
        Thread.sleep(2000);

        // Hapi 1: Marrim rrugen absolute te skedarit tone ne disk
        String filePath = tempFile.getAbsolutePath();
        System.out.println("File path to upload: " + filePath);

        // Hapi 2: Lokalizojme elementin input me type='file'
        WebElement chooseFileInput = driver.findElement(By.id("fileInput"));

        // Hapi 3: Dergojme rrugen e skedarit direkt me sendKeys
        chooseFileInput.sendKeys(filePath);
        System.out.println("Sent file path to file input element.");

        // Pauze 2 sekonda qe te shohesh emrin e skedarit te shfaqur ne ekran
        Thread.sleep(2000);

        // Hapi 4: Lokalizojme butonin 'Upload'
        WebElement uploadSubmitBtn = driver.findElement(By.id("fileSubmit"));

        // Bejme scroll te butoni dhe e klikojme me JavaScriptExecutor per te shmangur intercepts
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", uploadSubmitBtn);
        Thread.sleep(1000);
        js.executeScript("arguments[0].click();", uploadSubmitBtn);
        System.out.println("Clicked 'Upload' submit button successfully.");

        // Pauze 2 sekonda per te pare faqen e konfirmimit
        Thread.sleep(2000);

        // Hapi 5: Verifikojme mesazhin e suksesit
        WebElement successHeader = driver.findElement(By.tagName("h1"));
        System.out.println("Page response: " + successHeader.getText());
        Assert.assertEquals(successHeader.getText(), "File Uploaded!", "File upload verification failed!");

        // Pauze 3 sekonda para mbylljes qe te shohesh rezultatin
        Thread.sleep(3000);
        System.out.println("File upload verified successfully.");
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
            System.out.println("Browser closed successfully.\n");
        }

        // Fshijme skedarin e perkohshem pas testimit
        if (tempFile != null && tempFile.exists()) {
            tempFile.delete();
        }
    }
}