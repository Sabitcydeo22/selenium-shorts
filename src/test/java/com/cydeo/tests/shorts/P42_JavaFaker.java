package com.cydeo.tests.shorts;

// Importojmë klasën Driver për të hapur dhe kontrolluar shfletuesin
import com.cydeo.tests.utilities.Driver;

// Importojmë Faker për gjenerimin e të dhënave dinamike
import com.github.javafaker.Faker;

// Importojmë By dhe WebElement për të lokalizuar elementet në faqe
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

// Importojmë anotacionet nga TestNG
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class P42_JavaFaker {

    @Test
    public void java_faker_live_browser_practice() throws InterruptedException {
        // 1. Krijojmë objektin e Faker
        Faker faker = new Faker();

        // 2. Gjenerojmë të dhënat dinamike në fillim që të jenë gati
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();

        // 3. Hapim faqen e Google me Driver
        Driver.getDriver().get("https://www.google.com");

        // 4. Gjejmë kutinë e kërkimit dhe shkruajmë emrin e mbiemrin e rastësishëm
        WebElement searchBox = Driver.getDriver().findElement(By.name("q"));
        searchBox.sendKeys(firstName + " " + lastName);

        // 5. Presim 3 sekonda që ta shohësh të shkruar në ekran
        Thread.sleep(3000);
    }

    @AfterMethod
    public void tearDown() {
        // Mbyllim shfletuesin dhe pastrojmë sesionin
        Driver.closeDriver();
    }
}