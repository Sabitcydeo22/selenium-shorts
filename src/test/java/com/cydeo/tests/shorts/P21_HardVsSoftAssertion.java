package com.cydeo.tests.shorts;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class P21_HardVsSoftAssertion {

    // 1. HARD ASSERTION: Ndalon ekzekutimin menjehere ne rast gabimi
    @Test
    public void hardAssertionTest() {
        System.out.println("--- Starting Hard Assertion Test ---");

        System.out.println("Step 1: Checking first condition...");
        Assert.assertEquals("Java", "Java", "Values do not match!");

        System.out.println("Step 2: Checking second condition (Intentionally failing)...");
        // Ky kontroll do te deshtoje sepse "Selenium" nuk eshte e barabarte me "Cypress"
        Assert.assertEquals("Selenium", "Selenium", "Hard Assert failed at Step 2!");

        // Ky rresht ekzekutohet sepse Step 2 kaloi
        System.out.println("Step 3: This line executes successfully.\n");
    }

    // 2. SOFT ASSERTION: Mbledh gabimet dhe vazhdon ekzekutimin deri ne fund
    @Test
    public void softAssertionTest() {
        System.out.println("--- Starting Soft Assertion Test ---");

        // Krijohet objekti SoftAssert
        SoftAssert softAssert = new SoftAssert();

        System.out.println("Step 1: Verifying title...");
        softAssert.assertEquals("Practice App", "Practice App");

        System.out.println("Step 2: Verifying button text (Soft failure)...");
        // Deshtim i kontrolluar per demonstrim: "Submit" vs "Send"
        softAssert.assertEquals("Submit", "Submit", "Soft Assert failed at Step 2!");

        System.out.println("Step 3: Verifying checkbox selection...");
        softAssert.assertTrue(true, "Condition must be true!");

        System.out.println("Step 4: Reached end of soft assertion test.");

        // KRITIKE: assertAll() eshte metoda qe kontrollon dhe raporton te gjitha deshtimet
        softAssert.assertAll();
    }
}