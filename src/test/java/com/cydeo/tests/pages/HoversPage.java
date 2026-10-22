package com.cydeo.tests.pages;

import com.cydeo.tests.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HoversPage {

    public HoversPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    // Fotoja/Avatari i parë
    @FindBy(xpath = "(//div[@class='figure'])[1]")
    public WebElement firstAvatar;

    // Teksti/emri që shfaqet vetëm pasi kalon miu mbi foton e parë
    @FindBy(xpath = "(//div[@class='figcaption']/h5)[1]")
    public WebElement firstAvatarName;
}