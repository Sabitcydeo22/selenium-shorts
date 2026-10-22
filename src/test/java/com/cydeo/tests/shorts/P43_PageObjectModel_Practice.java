package com.cydeo.tests.shorts;

// Importojmë klasën e faqes POM që sapo krijuam në paketën pages
import com.cydeo.tests.pages.LibraryLoginPage;

// Importojmë klasën Driver për të hapur dhe menaxhuar shfletuesin
import com.cydeo.tests.utilities.Driver;

// Importojmë Assert nga TestNG për të bërë verifikimet
import org.testng.Assert;

// Importojmë anotacionet e TestNG
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class P43_PageObjectModel_Practice {

    @Test
    public void login_negative_test_with_pom() throws InterruptedException {
        // 1. Hapim faqen e testimit të librarisë
        Driver.getDriver().get("https://library1.cydeo.com/login.html");

        // 2. Krijojmë objektin e faqes LibraryLoginPage
        // Me këtë objekt kemi qasje të menjëhershme te të gjithë WebElement-et e asaj faqeje
        LibraryLoginPage loginPage = new LibraryLoginPage();

        // 3. Shkruajmë email të gabuar duke përdorur direkt WebElement-in nga klasa POM
        loginPage.inputEmail.sendKeys("wrongemail@example.com");

        // 4. Shkruajmë fjalëkalim të gabuar
        loginPage.inputPassword.sendKeys("wrongPassword123");

        // 5. Klikojmë butonin Sign in
        loginPage.signInButton.click();

        // 6. Presim 2 sekonda që mesazhi i gabimit të shfaqet në ekran
        Thread.sleep(2000);

        // 7. Verifikojmë që mesazhi i gabimit është shfaqur (isDisplayed kthen true)
        Assert.assertTrue(loginPage.errorAlertMessage.isDisplayed());
    }

    @AfterMethod
    public void tearDown() {
        // Mbyllim shfletuesin dhe pastrojmë sesionin
        Driver.closeDriver();
    }
}