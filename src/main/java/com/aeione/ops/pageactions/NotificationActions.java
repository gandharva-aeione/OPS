package com.aeione.ops.pageactions;

import com.aeione.ops.generic.DriverManager;
import com.aeione.ops.generic.ExtentTestManager;
import com.aeione.ops.generic.GenericFunctions;
import com.aeione.ops.pageobjects.LoginPageObjects;
import com.aeione.ops.pageobjects.NotificationObjects;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.io.IOException;

public class NotificationActions
{

    GenericFunctions genericfunctions;
    NotificationObjects notificationObjects = new NotificationObjects();
    Actions action;
    public static String newline="";

    public NotificationActions() throws IOException {
        genericfunctions = new GenericFunctions(DriverManager.getDriver());
        PageFactory.initElements(DriverManager.getDriver(), this);
        PageFactory.initElements(DriverManager.getDriver(), notificationObjects);
        action=new Actions(DriverManager.getDriver());
        newline = System.getProperty("line.separator");
    }

    /////////////////////////// Page Actions////////////////////////////////////////////////////////////////////////////


    public void clickOnNotificationBellIcon(String... strings)
    {
        ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " :: Click on notification bell icon");
        try
        {
            genericfunctions.waitTillTheElementIsVisible(notificationObjects.topbar_notification_bell_icon);
            notificationObjects.topbar_notification_bell_icon.click();
        }catch (Exception e)
        {
            Assert.fail("Could not perform action on \"Notification bell\" icon "+"&"+e.getMessage()+"" );

        }
    }



    /////////////////////////////// Page verification //////////////////////////////////////////////////////////////////


    public void verifyDisplayOfNotificationDropdown(String ...strings)
    {
        ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " :: Display of Notification dropdown or not  on clicking \"Notification bell\" icon with following assertions :");

        try {
            genericfunctions.waitForPageToLoad(notificationObjects.notification_dropdown);
            genericfunctions.waitTillTheElementIsVisible(notificationObjects.notification_dropdown);
            Assert.assertTrue(notificationObjects.notification_dropdown.isDisplayed());
            ExtentTestManager.getTest().log(LogStatus.PASS, "\"Notification\" dropdown is displaying");
        } catch (Exception e)
        {
            Assert.fail("Expected :: \"Notification\" dropdown should be displayed ; Actual :: \"Notification\" dropdown is not displaying "+"&"+e.getMessage()+"" );
        }
    }



}
