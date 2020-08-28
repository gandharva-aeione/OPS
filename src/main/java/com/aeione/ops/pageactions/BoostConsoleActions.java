package com.aeione.ops.pageactions;
import com.aeione.ops.generic.DriverManager;
import com.aeione.ops.generic.ExtentTestManager;
import com.aeione.ops.generic.GenericFunctions;
import com.aeione.ops.pageobjects.HomePageObjects;
import com.aeione.ops.pageobjects.BoostConsolePageObject;
import com.aeione.ops.pageobjects.LoginPageObjects;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.io.IOException;



public class BoostConsoleActions {
    GenericFunctions genericfunctions;
    LoginPageObjects loginpageobjects = new LoginPageObjects();
    HomePageObjects homepageobjects = new HomePageObjects();
    BoostConsolePageObject boostConsolePageObjects = new BoostConsolePageObject();
    Actions actions = null;

    public BoostConsoleActions() throws IOException {
        genericfunctions = new GenericFunctions(DriverManager.getDriver());
        PageFactory.initElements(DriverManager.getDriver(), this);
        PageFactory.initElements(DriverManager.getDriver(), loginpageobjects);
        PageFactory.initElements(DriverManager.getDriver(), homepageobjects);
        PageFactory.initElements(DriverManager.getDriver(), boostConsolePageObjects);

        actions = new Actions(DriverManager.getDriver());

    }
    /////////////////////////// Page Actions ////////////////////////////////


    //////////////////////////// Page Verifications /////////////////////////////////////

    public void verifyDisplayOfBoostConsoleOption(String... strings) {
        ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " :: Boost Console Option is displaying or not :");

        try {
            genericfunctions.waitTillTheElementIsVisible(boostConsolePageObjects.boostConsole_link);
            Assert.assertTrue(boostConsolePageObjects.boostConsole_link.isDisplayed());
            ExtentTestManager.getTest().log(LogStatus.PASS, "\"Boost Console\" is displaying");
        } catch (Exception e) {
            Assert.fail("Expected :: \"Boost Consolen\"  should be displayed ; Actual :: \"Boost Console\"  is not displaying" + "&" + e.getMessage() + "");
        }
    }
}
