package com.cydeo.tests.shorts;

// Importojmë klasën POM LibraryLoginPage nga paketa pages
import com.cydeo.tests.pages.LibraryLoginPage;

// Importojmë Driver për të hapur dhe kontrolluar shfletuesin
import com.cydeo.tests.utilities.Driver;

// Importojmë Assert nga TestNG për të bërë verifikimet
import org.testng.Assert;

// Importojmë anotacionet nga TestNG
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class P44_POM_Practice_Part2 {

    @Test
    public void negative_login_using_page_method() throws InterruptedException {
        // 1. Hapim faqen e testimit të librarisë
        Driver.getDriver().get("https://library1.cydeo.com/login.html");

        // 2. Krijojmë objektin e faqes LibraryLoginPage
        LibraryLoginPage loginPage = new LibraryLoginPage();

        // 3. Thërrasim metodën e vetme login() nga klasa POM
        loginPage.login("student3@library.com", "wrongPassword123");

        // 4. Presim 2 sekonda për të parë rezultatin në ekran
        Thread.sleep(2000);

        // 5. Verifikojmë që mesazhi i gabimit është shfaqur
        Assert.assertTrue(loginPage.errorAlertMessage.isDisplayed());
    }

    @AfterMethod
    public void tearDown() {
        // Mbyllim shfletuesin dhe pastrojmë sesionin
        Driver.closeDriver();
    }
}