package com.cydeo.tests.shorts;

import org.testng.Assert;
import org.testng.annotations.Test;

public class P18_TestNG_Intro {

    // Anotacioni @Test i tregon TestNG-se qe kjo metode eshte nje rast testimi i pavarur
    @Test
    public void test1() {
        System.out.println("Running Test 1: Verifying string values...");

        String actualWord = "apple";
        String expectedWord = "apple";

        // Assertion: verifikon nese vlera aktuale perputhet me ate te pritur
        Assert.assertEquals(actualWord, expectedWord, "Words do not match!");
    }

    @Test
    public void test2() {
        System.out.println("Running Test 2: Verifying numeric logic...");

        int actualNumber = 10;
        int expectedNumber = 10;

        // Kontrollon barazimin e numrave
        Assert.assertEquals(actualNumber, expectedNumber);
    }
}
