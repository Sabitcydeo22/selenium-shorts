package com.cydeo.tests.pages;

import com.cydeo.tests.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UploadPage {

    public UploadPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    // Butoni / Inputi për përzgjedhje skedari (type='file')
    @FindBy(id = "file-upload")
    public WebElement chooseFileButton;

    // Butoni "Upload" për ta dërguar
    @FindBy(id = "file-submit")
    public WebElement uploadButton;

    // Mesazhi i suksesit "File Uploaded!"
    @FindBy(tagName = "h3")
    public WebElement uploadSuccessMessage;
}