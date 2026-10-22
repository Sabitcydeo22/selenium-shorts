package com.cydeo.tests.pages;

import com.cydeo.tests.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DynamicLoadingPage {

    public DynamicLoadingPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    // Butoni "Start"
    @FindBy(xpath = "//div[@id='start']/button")
    public WebElement startButton;

    // Shiriti/ikona e ngarkimit (loading bar)
    @FindBy(id = "loading")
    public WebElement loadingBar;

    // Teksti që shfaqet pasi përfundon ngarkimi ("Hello World!")
    @FindBy(xpath = "//div[@id='finish']/h4")
    public WebElement finishText;
}