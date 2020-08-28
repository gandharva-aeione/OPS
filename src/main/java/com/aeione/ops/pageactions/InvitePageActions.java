package com.aeione.ops.pageactions;

import com.aeione.ops.generic.DriverManager;
import com.aeione.ops.generic.ExtentTestManager;
import com.aeione.ops.generic.GenericFunctions;
import com.aeione.ops.pageobjects.HomePageObjects;
import com.aeione.ops.pageobjects.InvitePageObjects;
import com.aeione.ops.pageobjects.LoginPageObjects;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.io.IOException;

public class InvitePageActions {

    GenericFunctions genericfunctions;
    LoginPageObjects loginpageobjects = new LoginPageObjects();
    HomePageObjects homepageobjects = new HomePageObjects();
    InvitePageObjects invitepageobjects = new InvitePageObjects();
    Actions actions = null;


    public InvitePageActions() throws IOException {
        genericfunctions = new GenericFunctions(DriverManager.getDriver());
        PageFactory.initElements(DriverManager.getDriver(), this);
        PageFactory.initElements(DriverManager.getDriver(), loginpageobjects);
        PageFactory.initElements(DriverManager.getDriver(), homepageobjects);
        PageFactory.initElements(DriverManager.getDriver(), invitepageobjects);

        actions = new Actions(DriverManager.getDriver());

    }

    /////////////////////////// Page Actions ////////////////////////////////
    public void clickOnInviteFriendsOption(String... strings) {
        ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " :: click On Invite Friends Option ");
        try {

            genericfunctions.waitTillTheElementIsVisible(invitepageobjects.invite_friends_option);

            invitepageobjects.invite_friends_option.click();
        } catch (Exception e) {
            Assert.fail("Could not perform action on \" Invite Friends\"" + "&" + e.getMessage() + "");

        }

    }

    public void clickOnInviteFriendsTextBox(String... strings) {
        ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " :: click On Invite Friends TextBox ");
        try {

            genericfunctions.waitTillTheElementIsVisible(invitepageobjects.email_address_textbox);

            invitepageobjects.email_address_textbox.click();
        } catch (Exception e) {
            Assert.fail("Could not perform action on \" Invite Friends Textbox \"" + "&" + e.getMessage() + "");

        }

    }

    public void enterEmailIdOnEmailAddressTextArea(String... strings) {
        String email_id = strings[1];
        try {

            ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " :: Enter email address on  Text Area");
            genericfunctions.waitTillTheElementIsVisible(invitepageobjects.email_address_textarea);

            invitepageobjects.email_address_textarea.sendKeys(email_id);
            actions.sendKeys(Keys.ENTER).build().perform();
        } catch (Exception e) {
            Assert.fail("Could not perform action on \"email address Text Area\"" + "&" + e.getMessage() + "");
        }
    }

    public void clickOnSendInviteButton(String... strings) {
        ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " :: click On Invite Friends Option ");
        try {

            genericfunctions.waitTillTheElementIsVisible(invitepageobjects.invite_friends_send_button);

            invitepageobjects.invite_friends_send_button.click();
        } catch (Exception e) {
            Assert.fail("Could not perform action on \" Invite Friends\"" + "&" + e.getMessage() + "");

        }

    }
    public void logInToGmail(String... strings)
    {
        String userCredentials= strings[1];

        ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " :: Login to gmail "+userCredentials+"");

        String email_id = strings[2].trim();
        String password = strings[3].trim();

        enterEmailid(email_id);
        clickOnEmaiIdNext();
        enterEmailPassword(password);
        clickOnPasswordNext();
    }

    public void enterEmailid(String... strings) {
        ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " :: click and enter email id ");
        try {String emailid = strings[0];

            genericfunctions.waitTillTheElementIsVisible(invitepageobjects.gmail_id);

            invitepageobjects.gmail_id.sendKeys(emailid);
        } catch (Exception e) {
            Assert.fail("Could not perform action on \"Email id\"" + "&" + e.getMessage() + "");

        }

    }

    public void clickOnEmaiIdNext(String... strings) {
        ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " :: click and enter email id ");
        try {

            genericfunctions.waitTillTheElementIsVisible(invitepageobjects.gmail_id_next_button);

            invitepageobjects.gmail_id_next_button.click();
        } catch (Exception e) {
            Assert.fail("Could not perform action on \"next button\"" + "&" + e.getMessage() + "");

        }

    }
    public void enterEmailPassword(String... strings) {
        ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " :: click and enter email password");
        try {
            String email_password = strings[0];

            genericfunctions.waitTillTheElementIsVisible(invitepageobjects.gmail_password);

            invitepageobjects.gmail_password.sendKeys(email_password);
        } catch (Exception e) {
            Assert.fail("Could not perform action on \"Email password\"" + "&" + e.getMessage() + "");

        }

    }
    public void clickOnPasswordNext(String... strings) {
        ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " :: click and enter email id ");
        try {

            genericfunctions.waitTillTheElementIsVisible(invitepageobjects.gmail_id_next_button);

            invitepageobjects.gmail_id_next_button.click();
        } catch (Exception e) {
            Assert.fail("Could not perform action on \"next button\"" + "&" + e.getMessage() + "");

        }

    }



    //////////////////////////// Page Verifications /////////////////////////////////////

    public void verifyDisplayOfInviteFriendsOption(String... strings) {
        ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " :: Invite Friends Option is displaying or not :");

        try {
            genericfunctions.waitTillTheElementIsVisible(invitepageobjects.invite_friends_option);
            Assert.assertTrue(invitepageobjects.invite_friends_option.isDisplayed());
            ExtentTestManager.getTest().log(LogStatus.PASS, "\"Invite Friend Option\" is displaying");
        } catch (Exception e) {
            Assert.fail("Expected :: \"Invite Friend Option\"  should be displayed ; Actual :: \"Invite Friend Option\"  is not displaying" + "&" + e.getMessage() + "");
        }
    }

    public void verifyDisplayoFInvitationSentPopup(String... strings) {
        ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " ::  Invite Friends Option is displaying or not :");

        try {
            genericfunctions.waitTillTheElementIsVisible(invitepageobjects.invitation_sent_popup);
            Assert.assertTrue(invitepageobjects.invitation_sent_popup.isDisplayed());
            ExtentTestManager.getTest().log(LogStatus.PASS, "\" Invitation Sent Popup\" is displaying");
        } catch (Throwable e) {
            Assert.fail("Expected :: \"Invitation Sent Popup\"  should be displayed ; Actual :: \"Invitation Sent Popup\"  is not displaying" + "&" + e.getMessage() + "");
        }
    }

}



