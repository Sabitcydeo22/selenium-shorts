package com.cydeo.tests.shorts;

import com.cydeo.tests.utilities.ConfigurationReader;
import com.cydeo.tests.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class P41_DriverUtilityClass {


    @Test
    public void test_driver_utility() {
        Driver.getDriver().get(ConfigurationReader.getProperty("practice.url"));

        String actualTitle = Driver.getDriver().getTitle();
        String expectedTitle = "Web inputs page for Automation Testing Practice";

        Assert.assertEquals(actualTitle, expectedTitle);
    }

    @AfterMethod
    public void tearDown() {
        // Mbyll shfletuesin dhe pastron instancën
        Driver.closeDriver();
    }
}