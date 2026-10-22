package com.cydeo.tests.pages;

import com.cydeo.tests.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AlertsPage {

    public AlertsPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    // Butoni i parë: "Click for JS Alert"
    @FindBy(xpath = "//button[@onclick='jsAlert()']")
    public WebElement jsAlertButton;

    // Butoni i dytë: "Click for JS Confirm"
    @FindBy(xpath = "//button[@onclick='jsConfirm()']")
    public WebElement jsConfirmButton;

    // Butoni i tretë: "Click for JS Prompt"
    @FindBy(xpath = "//button[@onclick='jsPrompt()']")
    public WebElement jsPromptButton;

    // Mesazhi i rezultatit poshtë butonave
    @FindBy(id = "result")
    public WebElement resultText;
}
