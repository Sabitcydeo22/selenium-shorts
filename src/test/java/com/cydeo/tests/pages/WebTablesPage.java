package com.cydeo.tests.pages;

import com.cydeo.tests.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WebTablesPage {

    public WebTablesPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    // Tabela e parë
    @FindBy(id = "table1")
    public WebElement table1;

    // Metodë ndihmëse për të marrë vlerën e pagesës (Due) bazuar te emri
    public WebElement getDueAmountByFirstName(String firstName) {
        String xpath = "//table[@id='table1']//td[text()='" + firstName + "']/following-sibling::td[2]";
        return Driver.getDriver().findElement(By.xpath(xpath));
    }
}
