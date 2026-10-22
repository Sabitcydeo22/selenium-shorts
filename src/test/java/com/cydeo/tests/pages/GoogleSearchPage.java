package com.cydeo.tests.pages;

import com.cydeo.tests.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GoogleSearchPage {

    // Constructor initializes WebElements using PageFactory
    public GoogleSearchPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    // Locate the search input box using @FindBy annotation
    @FindBy(name = "q")
    public WebElement searchBox;
}
