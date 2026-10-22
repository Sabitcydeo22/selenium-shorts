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
import java.time.Duration;

public class P36_FileDownload {

    WebDriver driver;
    File downloadedFile;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        // Hapim faqen e testimit per File Download
        driver.get("https://practice.expandtesting.com/download");
    }

    @Test
    public void fileDownloadVerificationTest() throws InterruptedException {
        System.out.println("Starting File Download verification test...");

        // Pauze 2 sekonda para klikimit
        Thread.sleep(2000);

        // Hapi 1: Lokalizojme linkun e shkarkimit
        WebElement downloadLink = driver.findElement(By.xpath("//a[contains(@data-testid,'test-file') or contains(@href,'download')]"));
        String fileName = downloadLink.getText().trim();
        System.out.println("File targeted for download: " + fileName);

        // Hapi 2: Scroll te linku dhe klikim me JavascriptExecutor per te shmangur interception
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", downloadLink);
        Thread.sleep(1000);
        js.executeScript("arguments[0].click();", downloadLink);
        System.out.println("Clicked download link successfully via JS.");

        // Hapi 3: Ndertojme rrugen e dosjes Downloads ne Windows
        String userHome = System.getProperty("user.home");
        String downloadPath = userHome + File.separator + "Downloads" + File.separator + fileName;
        downloadedFile = new File(downloadPath);

        System.out.println("Waiting for file to appear in: " + downloadPath);

        // Hapi 4: Presim deri ne 10 sekonda qe skedari te shkarkohet realisht ne disk
        boolean isDownloaded = false;
        for (int i = 0; i < 10; i++) {
            if (downloadedFile.exists() && downloadedFile.length() > 0) {
                isDownloaded = true;
                break;
            }
            Thread.sleep(1000);
        }

        // Hapi 5: Verifikojme ekzistencen e skedarit ne disk
        Assert.assertTrue(isDownloaded, "Downloaded file was not found in Downloads folder: " + downloadPath);
        System.out.println("File download verified successfully on local disk!");

        // Pauze 3 sekonda para mbylljes
        Thread.sleep(3000);
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
            System.out.println("Browser closed successfully.\n");
        }

        // Fshijme skedarin e shkarkuar per te lene dosjen te paster
        if (downloadedFile != null && downloadedFile.exists()) {
            downloadedFile.delete();
            System.out.println("Cleaned up downloaded test file.");
        }
    }
}