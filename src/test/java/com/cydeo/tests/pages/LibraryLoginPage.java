package com.cydeo.tests.pages;

// Importojmë klasën Driver nga paketa utilities
import com.cydeo.tests.utilities.Driver;

// Importojmë WebElement
import org.openqa.selenium.WebElement;

// Importojmë anotacionin @FindBy
import org.openqa.selenium.support.FindBy;

// Importojmë PageFactory
import org.openqa.selenium.support.PageFactory;

public class LibraryLoginPage {

    // Konstruktori që lidh shfletuesin me elementet e kësaj faqeje
    public LibraryLoginPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    // Kutia e email-it
    @FindBy(id = "inputEmail")
    public WebElement inputEmail;

    // Kutia e fjalëkalimit
    @FindBy(id = "inputPassword")
    public WebElement inputPassword;

    // Butoni Sign in
    @FindBy(xpath = "//button[.='Sign in']")
    public WebElement signInButton;

    // Mesazhi i gabimit kur kredencialet janë gabim
    @FindBy(xpath = "//div[.='Sorry, Wrong Email or Password']")
    public WebElement errorAlertMessage;

    // Metodë dinamike që kryen procesin e hyrjes me një thirrje të vetme
    // Metodë dinamike që kryen procesin e hyrjes me një thirrje të vetme
    public void login(String username, String password) {
        inputEmail.sendKeys(username);
        inputPassword.sendKeys(password);
        signInButton.click();
    }

    // Merr të gjitha modulet e navigimit në krye të faqes
    @FindBy(xpath = "//ul[@id='menu_list']//li//a")
    public java.util.List<WebElement> navigationModules;

}

