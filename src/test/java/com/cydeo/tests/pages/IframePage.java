package com.cydeo.tests.pages;

import com.cydeo.tests.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class IframePage {

    public IframePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    // Titulli kryesor jashtë iframe-it
    @FindBy(tagName = "h3")
    public WebElement headerText;

    // Fusha e tekstit brenda iframe-it
    @FindBy(id = "tinymce")
    public WebElement textArea;
}
