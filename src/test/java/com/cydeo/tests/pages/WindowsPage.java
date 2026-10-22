package com.cydeo.tests.pages;

import com.cydeo.tests.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WindowsPage {

    public WindowsPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    // Linku që hap dritaren e re: "Click Here"
    @FindBy(linkText = "Click Here")
    public WebElement clickHereLink;
}