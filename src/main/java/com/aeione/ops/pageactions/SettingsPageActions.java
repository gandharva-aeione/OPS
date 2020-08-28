package com.aeione.ops.pageactions;

import com.aeione.ops.generic.DriverManager;
import com.aeione.ops.generic.ExtentTestManager;
import com.aeione.ops.generic.GenericFunctions;
import com.aeione.ops.pageobjects.*;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.io.IOException;
import java.util.List;

import static com.aeione.ops.generic.TestSetUp.driver;

public class SettingsPageActions
{

    GenericFunctions genericfunctions;
    LoginPageObjects loginpageobjects = new LoginPageObjects();
    HomePageObjects homepageobjects = new HomePageObjects();
    PostWithHashTagObjects postwithhashtagobjects= new PostWithHashTagObjects();
    GenericPageObjects genericPageObjects = new GenericPageObjects();
    SettingsPageObject settingspageobject = new SettingsPageObject();
    Actions action;
    Select selectdropdownOption=null;


    public SettingsPageActions() throws IOException
    {


        genericfunctions = new GenericFunctions(DriverManager.getDriver());
        PageFactory.initElements(DriverManager.getDriver(), this);
        PageFactory.initElements(DriverManager.getDriver(), settingspageobject);
        PageFactory.initElements(DriverManager.getDriver(), loginpageobjects);
        PageFactory.initElements(DriverManager.getDriver(), homepageobjects);
        PageFactory.initElements(DriverManager.getDriver(), postwithhashtagobjects);
        PageFactory.initElements(DriverManager.getDriver(), genericPageObjects);
        action=new Actions(DriverManager.getDriver());
    }

    /////////////////////////// Page Actions////////////////////////////////////////////////////////////////////////////

    /**
     * Click On DropDown Actions
     * Author:- Gandahrva
     * Date:- 29-05-2020
     */
    public void clickOnDropDownActions(String... strings)
    {
        String action= strings[1];
        ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " ::  Click on " +" \"<b>" + action +"\"   </b>"+ " option of Dropdown " );

        try
        {
            switch (action)
            {
                case "view-Profile":
                    
                    DriverManager.getDriver().findElement(By.id("topbar-dropdown-"+action)).click();
                    ExtentTestManager.getTest().log(LogStatus.PASS, " "+ " \"Clicked on View Profile \" ");
                    break;

                case "organizationname":
                   
                    DriverManager.getDriver().findElement(By.id("topbar-dropdown-"+action)).click();
                    ExtentTestManager.getTest().log(LogStatus.PASS, " "+ " \"Clicked on Organization  \" ");
                    break;

                case "boostConsole":
                    
                    DriverManager.getDriver().findElement(By.id("topbar-dropdown-"+action)).click();
                    ExtentTestManager.getTest().log(LogStatus.PASS, " "+ " \"Clicked on Boost Console  \" ");
                    break;

                case "invitefriends":
                    
                    DriverManager.getDriver().findElement(By.id("topbar-dropdown-"+action)).click();
                    ExtentTestManager.getTest().log(LogStatus.PASS, " "+ " \"Clicked on Invite Friends \" ");
                    break;

                case "settings":
                    
                    DriverManager.getDriver().findElement(By.id("topbar-dropdown-"+action)).click();
                    ExtentTestManager.getTest().log(LogStatus.PASS, " "+ " \"Clicked on Settings \" ");
                    break;

                case "aboutpage":
                    
                    DriverManager.getDriver().findElement(By.id("topbar-dropdown-"+action)).click();
                    ExtentTestManager.getTest().log(LogStatus.PASS, " "+ " \"Clicked on About Page \" ");
                    break;

                case "signout":
                   
                    DriverManager.getDriver().findElement(By.id("topbar-dropdown-"+action)).click();
                    ExtentTestManager.getTest().log(LogStatus.PASS, " "+ " \"Clicked on Signout \" ");
                    break;

            }
        }
        catch (Throwable e)
        {
            Assert.fail("Could not perform an action DropDown"+ action + "Option" + "&"+e.getMessage()+"" );
        }
    }

    /**
     * Click On Tabs
     * Author:- Gandahrva
     * Date:- 29-05-2020
     */
    public void clickOnTabs(String... strings)
    {
        String action= strings[1];
        ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " ::  Click on : " +" \"<b>" + action +"\"   </b>" + "Tab");

        try
        {
            switch (action)
            {
                case "general" :
                    
                    DriverManager.getDriver().findElement(By.id("settings-"+action)).click();
                    ExtentTestManager.getTest().log(LogStatus.PASS, " "+ " \"Clicked on General Tab \" ");
                    break;

                case "privacy-and-security":
                    
                    DriverManager.getDriver().findElement(By.id("settings-"+action)).click();
                    ExtentTestManager.getTest().log(LogStatus.PASS, " "+ " \"Clicked on Privacy and Security Tab \" ");
                    break;

                case "notification" :
                   
                    DriverManager.getDriver().findElement(By.id("settings-"+action)).click();
                    ExtentTestManager.getTest().log(LogStatus.PASS, " "+ " \"Clicked on Notification Tab \" ");
                    break;

                case "pay-per-post" :
                   
                    DriverManager.getDriver().findElement(By.id("settings-"+action)).click();
                    ExtentTestManager.getTest().log(LogStatus.PASS, " "+ " \"Clicked on Pay Per Post Tab \" ");
                    break;

                case "support" :
                   
                    DriverManager.getDriver().findElement(By.id("settings-"+action)).click();
                    ExtentTestManager.getTest().log(LogStatus.PASS, " "+ " \"Clicked on Support Tab \" ");
                    break;
            }
        }
        catch (Throwable e)
        {
            Assert.fail("Could not perform an action on" + action + "Tab" + " &"+e.getMessage()+"" );
        }
    }

    public void verticleScrollTillEnd()
    {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
    }

    /**
     * Click on Change Password
     * Author:- Gandahrva
     * Date:- 29-05-2020
     */
    public void clickOnChangePassword(String... strings)
    {
        ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " ::  Click on Change Password ");

        try
        {
            genericfunctions.waitTillTheElementIsVisible(settingspageobject.privacy_security_change_password);
            Assert.assertTrue(settingspageobject.privacy_security_change_password.isDisplayed());
            settingspageobject.privacy_security_change_password.click();
            ExtentTestManager.getTest().log(LogStatus.PASS,  "  Clicked on Change Password ");
        }
        catch (Throwable e)
        {
            Assert.fail("Could not perform an action Change \"Password \" "  + " &"+e.getMessage()+"" );
        }
    }

    /**
     * Enter Current Password
     * Author:- Gandahrva
     * Date:- 29-05-2020
     */
    public void enterCurrentPassword(String... strings)
    {
        String password = strings[1];
        ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " :: Enter Current Password In Input Box :: "+" \"<b>" + password +"\"   </b>");

        try
        {
            genericfunctions.waitWebDriver(2000);
            genericfunctions.waitTillTheElementIsVisible(settingspageobject.privacy_security_current_password);
            settingspageobject.privacy_security_current_password.sendKeys(password);
        }
        catch (Throwable e)
        {
            Assert.fail("Could not perform an action on \"Current Password Input Box\" "  + " &"+e.getMessage()+"" );
        }
    }

    /**
     * Enter New Password
     * Author:- Gandahrva
     * Date:- 29-05-2020
     */
    public void enterNewPassword(String... strings)
    {
        String password = strings[1];
        ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " :: Enter New Password In Input Box :: "+" \"<b>" + password +"\"   </b>");

        try
        {
            genericfunctions.waitTillTheElementIsVisible(settingspageobject.privacy_security_new_password);
            settingspageobject.privacy_security_new_password.sendKeys(password);
        }
        catch (Throwable e)
        {
            Assert.fail("Could not perform an action on \"New Password Input Box\" "  + " &"+e.getMessage()+"" );
        }
    }

    /**
     * Enter Confirm Password
     * Author:- Gandahrva
     * Date:- 29-05-2020
     */
    public void enterConfirmPassword(String... strings)
    {
        String password = strings[1];
        ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " :: Enter Confirm Password In Input Box :: "+" \"<b>" + password +"\"   </b>");

        try
        {
            genericfunctions.waitTillTheElementIsVisible(settingspageobject.privacy_security_confirm_password);
            settingspageobject.privacy_security_confirm_password.sendKeys(password);
        }
        catch (Throwable e)
        {
            Assert.fail("Could not perform an action on \"Confirm Password Input Box\" "  + " &"+e.getMessage()+"" );
        }
    }

    /**
     *  Click on Update Password Button
     * Author:- Gandahrva
     * Date:- 29-05-2020
     */
    public void clickOnUpdatePasswordButton(String... strings)
    {
        ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " :: Click on Update Password Button");

        try
        {
            genericfunctions.waitTillTheElementIsVisible(settingspageobject.privacy_security_update_password);
            settingspageobject.privacy_security_update_password.click();
        }
        catch (Throwable e)
        {
            Assert.fail("Could not perform an action on \"Update Password Button\" "  + " &"+e.getMessage()+"" );
        }
    }

    /**
     * Click on Close All Session Button
     * Author:- Gandahrva
     * Date:- 29-05-2020
     */
    public void clickOnCloseAllSessionButton(String... strings)
    {
        ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " :: Click on Close All Session Button ");

        try
        {
            genericfunctions.waitTillTheElementIsVisible(settingspageobject.privacy_security_close_sessions);
            settingspageobject.privacy_security_close_sessions.click();
        }
        catch (Throwable e)
        {
            Assert.fail(" Could not perform an action on \" Close All Session Button\" "  + " &"+e.getMessage()+"" );
        }
    }


    /**
     * Click on Delete Account CheckBox
     * Author:- Gandahrva
     * Date:- 09-06-2020
     */
    public void clickOnDeleteAccountCheckBox(String... strings)
    {
        ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " :: Click on Delete Account CheckBox ");

        try
        {
            verticleScrollTillEnd();
            genericfunctions.waitTillTheElementIsVisible(settingspageobject.delete_account);
            settingspageobject.delete_account.click();
        }
        catch (Throwable e)
        {
            Assert.fail(" Could not perform an action on \" Delete Account CheckBox\" "  + " &"+e.getMessage()+"" );
        }
    }

    /**
     * Enter Password for Delete Account
     * Author:- Gandahrva
     * Date:- 09-06-2020
     */
    public void enterPasswordForDeleteAccount(String... strings)
    {
        String password=strings[1];

        ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " :: Enter Passowrd for Delete Account :: " +" \"<b>" + password +"\"   </b>");

        try
        {
            genericfunctions.waitTillTheElementIsVisible(settingspageobject.general_password_delete_account);
            settingspageobject.general_password_delete_account.sendKeys(password);
        }
        catch (Throwable e)
        {
            Assert.fail(" Could not perform an action on \" Enter Passowrd for Delete Account\" "  + " &"+e.getMessage()+"" );
        }
    }

    /**
     * Click on Delete Account Button
     * Author:- Gandahrva
     * Date:- 09-06-2020
     */
    public void clickOnConfirmDeleteButton(String... strings)
    {
        ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " :: Click On Confirm Delete Button ");


        try
        {
            genericfunctions.waitTillTheElementIsVisible(settingspageobject.general_confirm_delete_button);
            settingspageobject.general_confirm_delete_button.click();
        }
        catch (Throwable e)
        {
            Assert.fail(" Could not perform an action on \"  Confirm Delete Button\" "  + " &"+e.getMessage()+"" );
        }
    }

    /**
     * Cancel Delete Account Button
     * Author:- Gandahrva
     * Date:- 11-06-2020
     */
    public void clickOnCancelDeleteAccountButton(String... strings)
    {
        ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " :: Click On Cancel Delete Account Button ");


        try
        {
            genericfunctions.waitTillTheElementIsVisible(settingspageobject.general_delete_cancel_button);
            settingspageobject.general_delete_cancel_button.click();
        }
        catch (Throwable e)
        {
            Assert.fail(" Could not perform an action on \"  Cancel Delete Account Button \" "  + " &"+e.getMessage()+"" );
        }
    }

    /**
     * Click on DeActivate Account Check Box
     * Author:- Gandahrva
     * Date:- 09-06-2020
     */
    public void clickOnDeActivateAccountCheckBox(String... strings)
    {
        ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " :: Click on Deactivate Account CheckBox ");

        try
        {
            verticleScrollTillEnd();

            genericfunctions.waitTillTheElementIsVisible(settingspageobject.deactivate_account);
            settingspageobject.deactivate_account.click();
        }
        catch (Throwable e)
        {
            Assert.fail(" Could not perform an action on \" Deactivate Account CheckBox\" "  + " &"+e.getMessage()+"" );
        }
    }

    /**
     * Click on DeActivate Account Check Box List
     * Author:- Gandahrva
     * Date:- 09-06-2020
     */
    public void clickOnDeactivateAccountCheckBoxList(String... strings)
    {
        String reason = strings[1];
        ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " :: Click on Deactivate Account CheckBox Reason as : "+" \"<b>" + reason +"\"  </b>");

        try
        {
            verticleScrollTillEnd();

            genericfunctions.waitTillTheElementIsVisible(settingspageobject.general_checkbox);
            settingspageobject.general_checkbox.click();
        }
        catch (Throwable e)
        {
            Assert.fail(" Could not perform an action on \" Deactivate Account CheckBox List\" "  + " &"+e.getMessage()+"" );
        }
    }

    /**
     * Click on DeActivate Account Check Box List
     * Author:- Gandahrva
     * Date:- 09-06-2020
     */
    public void clickOnDeactivateConfirmButton(String... strings)
    {
        ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " :: Click on Deactivate Confirm Account Button");

        try
        {

            genericfunctions.waitTillTheElementIsVisible(settingspageobject.general_confirm_deactivate_button);
            settingspageobject.general_confirm_deactivate_button.click();
        }
        catch (Throwable e)
        {
            Assert.fail(" Could not perform an action on \" Deactivate Confirm Account Button \" "  + " &"+e.getMessage()+"" );
        }
    }

    /**
     * Click on Close All Session Button
     * Author:- Gandahrva
     * Date:- 29-05-2020
     */
    public void clickOnSavePayPerPostBackgroundImageButton(String... strings)
    {
        ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " :: Click on Save PayPerPost Background Image Button ");

        try
        {
            genericfunctions.waitTillTheElementIsVisible(settingspageobject.wire_save_backgroung_image_button);
            settingspageobject.wire_save_backgroung_image_button.click();
        }
        catch (Throwable e)
        {
            Assert.fail(" Could not perform an action on \" Save PayPerPost Background Image Button \" "  + " &"+e.getMessage()+"" );
        }
    }

    /**
     * Click on Mature Flag Toggle
     * Author:- Gandahrva
     * Date:- 10-06-2020
     */
    public void clickOnMatureFlagToggle(String... strings)
    {
        ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " ::  \"<b>" + strings[1] +"\"   </b>"+ " Mature Flag Toggle Button ");

        try
        {
            genericfunctions.waitTillTheElementIsVisible(settingspageobject.general_flag_mature);
            genericfunctions.scrollToElement(settingspageobject.general_flag_mature);
            settingspageobject.general_flag_mature.click();
        }
        catch (Throwable e)
        {
            Assert.fail(" Could not perform an action on \" Mautre Flag Toggle Button \" "  + " &"+e.getMessage()+"" );
        }
    }

    /**
     * Click on Save Button
     * Author:- Gandahrva
     * Date:- 10-06-2020
     */
    public void clickOnSaveButton(String... strings)
    {
        ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " :: Click on Save Button ");

        try
        {
            genericfunctions.waitTillTheElementIsVisible(settingspageobject.general_save_button);
            settingspageobject.general_save_button.click();
        }
        catch (Throwable e)
        {
            Assert.fail(" Could not perform an action on \" Save Button \" "  + " &"+e.getMessage()+"" );
        }
    }

    /**
     * Click on Portfolio Toggle
     * Author:- Gandahrva
     * Date:- 11-06-2020
     */
    public void clickOnPortfolioFlagToggle(String... strings)
    {
        ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " " + " ::  \"<b>" + strings[1] +"\"   </b>"+ " Portfolio Flag Toggle Button");

        try
        {
            verticleScrollTillEnd();

            genericfunctions.waitTillTheElementIsVisible(settingspageobject.general_portfoilo);
            settingspageobject.general_portfoilo.click();
        }
        catch (Throwable e)
        {
            Assert.fail(" Could not perform an action on \" Portfolio Flag Toggle Button \" "  + " &"+e.getMessage()+"" );
        }
    }

    /**
     * Click on others
     * Author:- Gandahrva
     * Date:- 12-06-2020
     */
    public void clickOnDeactivateAccountOthersOthersCheckBox(String... strings)
    {
        ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " :: Click on Deactivate Account Others CheckBox");

        try
        {
            genericfunctions.waitTillTheElementIsVisible(settingspageobject.general_others);
            settingspageobject.general_others.click();
        }
        catch (Throwable e)
        {
            Assert.fail(" Could not perform an action on \" Deactivate Account Others CheckBox \" "  + " &"+e.getMessage()+"" );
        }
    }

    /**
     * Click on Deactivate Account Cancel Button
     * Author:- Gandahrva
     * Date:- 12-06-2020
     */
    public void clickOnDeactivateAccountCancelButton(String... strings)
    {
        ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " :: Click on DeactivateAccount Cancel Button");

        try
        {
            genericfunctions.waitTillTheElementIsVisible(settingspageobject.general_deactivate_cancel_button);
            settingspageobject.general_deactivate_cancel_button.click();
        }
        catch (Throwable e)
        {
            Assert.fail(" Could not perform an action on \" DeactivateAccountCancelButton \" "  + " &"+e.getMessage()+"" );
        }
    }

    /**
     * Click on User Full Name
     * Author:- Gandahrva
     * Date:- 12-06-2020
     */
    public void clickOnUserFullName(String... strings)
    {
        ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " :: Click on User Full Name");

        try
        {
            genericfunctions.waitTillTheElementIsVisible(settingspageobject.suggested_user_profile_name);
            settingspageobject.suggested_user_profile_name.click();
        }
        catch (Exception e)
        {
            Assert.fail(" Could not perform an action on \" User Full Name \" "  + " &"+e.getMessage()+"" );
        }
    }

    ////////////////////////// Page Verifications /////////////////////////////////////////////////////////////////


    public void verifyDisplayOfSettingsOption(String ...strings)
    {
        ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " :: Settings option is displayed or not on clicking topdropdown with following assertions :");


        try
        {
            genericfunctions.waitTillTheElementIsVisible(settingspageobject.topbar_dropdown_settings_option);
            Assert.assertTrue(settingspageobject.topbar_dropdown_settings_option.isDisplayed());
            ExtentTestManager.getTest().log(LogStatus.PASS, "\"Settings \" option is displaying");
        }
        catch (Throwable e)
        {
            Assert.fail("Expected :: \"Settings\" option should be displayed ; Actual :: \"Settings\" option is not displayed"+"&"+e.getMessage()+"");
        }
    }

    /**
     * Display of Settings Page tabs List
     * Author:- Gandahrva
     * Date:- 29-05-2020
     */
    public void verifyDisplayOfTabsListOfSettingsPage(String... strings)
    {
        ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[1] + " :: Settings Page Tab Lists are displayed or not");
        List<WebElement> tabs=null;
        String[] expectedTabs=strings[0].split("\\,");
        String currentExpectedTab= null;
        String currentActualTab = null;
        try
        {
            ExtentTestManager.getTest().log(LogStatus.INFO, " " + "<b>"+" Tab Lists are :- "+"</b>");
            genericfunctions.waitTillTheElementIsVisible(settingspageobject.tabs_list_settings_tabs.get(0));
            Assert.assertTrue(settingspageobject.tabs_list_settings_tabs.get(0).isDisplayed());
        }
        catch (Throwable e)
        {
            Assert.fail("Could not found \"Tabs List\"" + "&" + e.getMessage() + "");
        }

        tabs = settingspageobject.list_name;

        try
        {
            for (int i = 0; i < tabs.size(); i++)
            {
                currentExpectedTab = expectedTabs[i];

                currentActualTab = tabs.get(i).getText();

                genericfunctions.waitTillTheElementIsVisible(settingspageobject.list_name.get(i));

                Assert.assertTrue(currentActualTab.trim().equals(currentExpectedTab.trim()));

                ExtentTestManager.getTest().log(LogStatus.PASS, " " +   "<b>" + settingspageobject.list_name.get(i).getText() + "</b>");
            }

            ExtentTestManager.getTest().log(LogStatus.PASS, " Tabs list are displayed");
        }
        catch (Throwable e)
        {
            Assert.fail("Expected :: " + currentExpectedTab + " Tab should be displayed  ; Actual ::" + currentActualTab + " Tab is not displayed"+"&"+e.getMessage()+"");
        }
    }

    /**
     * Display of Privacy Security Password Title
     * Author:- Gandahrva
     * Date:- 29-05-2020
     */
    public void verifyDisplayOfPrivacySecurityPasswordTitle(String... strings)
    {
        ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " :: Privacy Security Password Title is displayed or not");

        try
        {
            genericfunctions.waitTillTheElementIsVisible(settingspageobject.privacy_security_password_title);
            Assert.assertTrue(settingspageobject.privacy_security_password_title.isDisplayed());
            ExtentTestManager.getTest().log(LogStatus.PASS,   "  \" Privacy Security Password Title \" is displayed ");
        }
        catch (Throwable e)
        {
            Assert.fail("Could not found \"Privacy Security Password Title \" "  + " &"+e.getMessage()+"" );
        }
    }

    /**
     *  Display of Current Password Input Box
     * Author:- Gandahrva
     * Date:- 29-05-2020
     */
    public void verifyDisplayOfCurrentPasswordInputBox(String... strings)
    {
        ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " :: Current Password Input Box is displayed or not");

        try
        {
            genericfunctions.waitTillTheElementIsVisible(settingspageobject.privacy_security_current_password);
            Assert.assertTrue(settingspageobject.privacy_security_current_password.isDisplayed());
            ExtentTestManager.getTest().log(LogStatus.PASS,   "  \" Current Password Input Box \" is displayed ");
        }
        catch (Throwable e)
        {
            Assert.fail("Could not found \"Current Password Input Box\" "  + " &"+e.getMessage()+"" );
        }
    }

    /**
     * Display of New Password Input Box
     * Author:- Gandahrva
     * Date:- 29-05-2020
     */
    public void verifyDisplayOfNewPasswordInputBox(String... strings)
    {
        ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " :: New Password Input Box is displayed or not");

        try
        {
            genericfunctions.waitTillTheElementIsVisible(settingspageobject.privacy_security_new_password);
            Assert.assertTrue(settingspageobject.privacy_security_new_password.isDisplayed());
            ExtentTestManager.getTest().log(LogStatus.PASS,   "  \" New Password Input Box \" is displayed ");
        }
        catch (Throwable e)
        {
            Assert.fail("Could not found \"New Password Input Box\" "  + " &"+e.getMessage()+"" );
        }
    }

    /**
     *  Display of Confirm Password Input Box
     * Author:- Gandahrva
     * Date:- 29-05-2020
     */
    public void verifyDisplayOfConfirmPasswordInputBox(String... strings)
    {
        ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " :: Confirm Password Input Box is displayed or not");

        try
        {
            genericfunctions.waitTillTheElementIsVisible(settingspageobject.privacy_security_confirm_password);
            Assert.assertTrue(settingspageobject.privacy_security_confirm_password.isDisplayed());
            ExtentTestManager.getTest().log(LogStatus.PASS,   "  \" Confirm Password Input Box \" is displayed ");
        }
        catch (Throwable e)
        {
            Assert.fail("Could not found \"Confirm Password Input Box\" "  + " &"+e.getMessage()+"" );
        }
    }

    /**
     *  Display of Update Password Button
     * Author:- Gandahrva
     * Date:- 29-05-2020
     */
    public void verifyDisplayOfUpdatePasswordButton(String... strings)
    {
        ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " :: Update Password Button is displayed or not");

        try
        {
            genericfunctions.waitTillTheElementIsVisible(settingspageobject.privacy_security_update_password);
            Assert.assertTrue(settingspageobject.privacy_security_update_password.isDisplayed());
            ExtentTestManager.getTest().log(LogStatus.PASS,   "  \" Update Password Button \" is displayed ");
        }
        catch (Throwable e)
        {
            Assert.fail("Could not found \"Update Password Button\" "  + " &"+e.getMessage()+"" );
        }
    }

    /**
     * Display of Cancel Button
     * Author:- Gandahrva
     * Date:- 29-05-2020
     */
    public void verifyDisplayOfCancelButton(String... strings)
    {
        ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " :: Cancel Button is displayed or not");

        try
        {
            genericfunctions.waitTillTheElementIsVisible(settingspageobject.privacy_security_cancel_button);
            Assert.assertTrue(settingspageobject.privacy_security_cancel_button.isDisplayed());
            ExtentTestManager.getTest().log(LogStatus.PASS,   "  \" Cancel Button \" is displayed ");
        }
        catch (Throwable e)
        {
            Assert.fail("Could not found \" Cancel Button\" "  + " &"+e.getMessage()+"" );
        }
    }

    /**
     * Display of Toast Container
     * Author:- Gandahrva
     * Date:- 29-05-2020
     */
    public void verifyDisplayOfToastContainer(String... strings)
    {
        String action = strings[1];
        ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " :: Toast Container is displayed or not after " + "  \"<b>" + action +"\"  </b>"+ " Action");

        try
        {
            genericfunctions.waitTillTheElementIsVisible(settingspageobject.toast_container);
            String toast_container= settingspageobject.toast_container.getText();
            Assert.assertTrue(settingspageobject.toast_container.isDisplayed());
            ExtentTestManager.getTest().log(LogStatus.PASS,   "  \" Toast Container \" is displayed as :: " +" \"<b>" + toast_container +"\" </b>");
        }
        catch (Throwable e)
        {
            Assert.fail("Could not found \" Toast Container\" "  + " &"+e.getMessage()+"" );
        }
    }

    /**
     * Display of Close All Session Button
     * Author:- Gandahrva
     * Date:- 29-05-2020
     */
    public void verifyDisplayOfCloseAllSessionButton(String... strings)
    {
        ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " :: Close All Session Button is displayed or not ");

        try
        {
            genericfunctions.waitTillTheElementIsVisible(settingspageobject.privacy_security_close_sessions);
            Assert.assertTrue(settingspageobject.privacy_security_close_sessions.isDisplayed());
            ExtentTestManager.getTest().log(LogStatus.PASS,   "  \" Close All Session Button \" is displayed ");
        }
        catch (Throwable e)
        {
            Assert.fail("Could not found \" Close All Session Button\" "  + " &" +e.getMessage()+"" );
        }
    }

    /**
     * Display of Page Title
     * Author:- Gandahrva
     * Date:- 29-05-2020
     */
    public void verifyDisplayOfPageTitle(String... strings)
    {
        String exceptedTitle=strings[1];
        String action = strings[2];
        String actualTitle =null;
        ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " :: Navigated to Log_in Page or not after " +" \"<b>" + action +"\"   </b>" +" Action ");

        try
        {
            System.out.println("PageTitle:-"+DriverManager.getDriver().getTitle());
              actualTitle= DriverManager.getDriver().getTitle().replaceAll("[^A-Za-z^|]", " ").trim();
             //actualTitle= DriverManager.getDriver().getTitle();
             //actualTitle= Title.split("[, ?.@(*)]+");

             System.out.println("Title:-"+actualTitle);
            Assert.assertTrue(actualTitle.equals(exceptedTitle));
            ExtentTestManager.getTest().log(LogStatus.PASS, " Expected :: \"Page Title\" should be displayed as "
                    +  ":: \"<b>" + actualTitle +"\"   </b>" +" ; Actual :: \"Page Title\" is displayed as"  + ":: \"<b>" + exceptedTitle +"\"   </b>"+"");
        }

        catch(Throwable e)
        {
            String actualException=e.getClass().getName();

            switch (actualException)
            {
                case "NoSuchElementException":
                    Assert.fail(" Could not found \"LogIn Page \" "  + " &" +e.getMessage());
                    break;
                case "AssertionError":
                    Assert.fail(" Could not found \"LogIn Page \" "  + " &" +e.getMessage()+"" );
                    break;
                default:
                    Assert.fail(""+ actualTitle+" \"<b>" + DriverManager.getDriver().getTitle() +"\"   </b>" +" &" + e.getMessage()+ "");
            }
        }
    }

    /**
     * Display of Delete Account Button
     * Author:- Gandahrva
     * Date:- 09-06-2020
     */
    public void verifyDisplayOfDeleteAccountCheckBox(String... strings)
    {
        ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " :: Delete Account CheckBox is displayed or not ");

        try
        {
            genericfunctions.waitTillTheElementIsVisible(settingspageobject.delete_account);
            Assert.assertTrue(settingspageobject.delete_account.isDisplayed());
            ExtentTestManager.getTest().log(LogStatus.PASS,   "  \" Delete Account CheckBox \" is displayed ");
        }
        catch (Throwable e)
        {
            Assert.fail("Could not found \" Delete Account CheckBox\" "  + " &" +e.getMessage()+"" );
        }
    }

    /**
     * Display of General Password Delete Account InputBox
     * Author:- Gandahrva
     * Date:- 09-06-2020
     */
    public void verifyDisplayOfGeneralPasswordDeleteAccountInputBox(String... strings)
    {
        ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " :: General Password Delete Account InputBox is displayed or not ");

        try
        {
            genericfunctions.waitTillTheElementIsVisible(settingspageobject.general_password_delete_account);
            Assert.assertTrue(settingspageobject.general_password_delete_account.isDisplayed());
            ExtentTestManager.getTest().log(LogStatus.PASS,   "  \" General Password Delete Account InputBox \" is displayed ");
        }
        catch (Throwable e)
        {
            Assert.fail("Could not found \" General Password Delete Account InputBox\" "  + " &" +e.getMessage()+"" );
        }
    }

    /**
     * Display of Cofirm Delete Account Button
     * Author:- Gandahrva
     * Date:- 11-06-2020
     */
    public void verifyDisaplayOfConfirmDeleteAccountButton(String... strings)
    {
        ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " :: Confirm Delete Account Button is displayed or not ");

        try
        {
            genericfunctions.waitTillTheElementIsVisible(settingspageobject.general_confirm_delete_button);
            Assert.assertTrue(settingspageobject.delete_account.isDisplayed());
            ExtentTestManager.getTest().log(LogStatus.PASS,   "  \" Confirm Delete Account Button \" is displayed ");
        }
        catch (Throwable e)
        {
            Assert.fail("Could not found \" Confirm Delete Account Button \" "  + " &" +e.getMessage()+"" );
        }
    }

    /**
     * Display of Cofirm Delete Account Button
     * Author:- Gandahrva
     * Date:- 11-06-2020
     */
    public void verifyDisplayOfCancelDeleteAccountButton(String... strings)
    {
        ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " :: Cancel Delete Account Button is displayed or not ");

        try
        {
            genericfunctions.waitTillTheElementIsVisible(settingspageobject.general_delete_cancel_button);
            Assert.assertTrue(settingspageobject.general_delete_cancel_button.isDisplayed());
            ExtentTestManager.getTest().log(LogStatus.PASS,   "  \" Cancel Delete Account Button \" is displayed ");
        }
        catch (Throwable e)
        {
            Assert.fail("Could not found \"  Cancel Delete  Account Button \" "  + " &" +e.getMessage()+"" );
        }
    }

    /**
     * Display of Deactivate Account Button
     * Author:- Gandahrva
     * Date:- 09-06-2020
     */
    public void verifyDisplayOfDeActivateAccountCheckBox(String... strings)
    {
        ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " :: Deactivate Account CheckBox is displayed or not ");

        try
        {
            genericfunctions.waitTillTheElementIsVisible(settingspageobject.deactivate_account);
            Assert.assertTrue(settingspageobject.deactivate_account.isDisplayed());
            ExtentTestManager.getTest().log(LogStatus.PASS,   "  \" Deactivate Account CheckBox \" is displayed ");
        }
        catch (Throwable e)
        {
            Assert.fail("Could not found \" Deactivate Account CheckBox\" "  + " &" +e.getMessage()+"" );
        }
    }


    /**
     * Display of Alert PopUp
     * Author:- Gandahrva
     * Date:- 09-06-2020
     */
    public void verifyDisplayOfAlertPopUp(String... strings)
    {
        ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " :: AlertPopUp is displayed or not ");
        String alerExceptedMessage = strings[1];
        try
        {
            Alert alert =DriverManager.getDriver().switchTo().alert();

            // Capturing alert message.
            String alertActualMessage= DriverManager.getDriver().switchTo().alert().getText();
            Assert.assertTrue(alertActualMessage.equals(alerExceptedMessage));

            // Accepting alert
            alert.accept();

            Assert.fail(" \"<b>" + alertActualMessage +"\"   </b>");
        }
        catch(NoAlertPresentException e)
        {
            ExtentTestManager.getTest().log(LogStatus.PASS, " AlertPopUp is not displayed");
        }
    }



    /**
     * PayPerPost Background Image is displayed or not
     * Author:- Gandahrva
     * Date:- 29-05-2020
     */
    public void verifyDisplayOfPayPerPostBackgroundImage(String... strings)
    {
        ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " :: PayPerPost Background Image is displayed or not ");

        try
        {
            genericfunctions.waitTillTheElementIsVisible(settingspageobject.feed_paywall_background.get(0));
            Assert.assertTrue(settingspageobject.feed_paywall_background.get(0).isDisplayed());
            ExtentTestManager.getTest().log(LogStatus.PASS,   "  \" PayPerPost Background Image \" is displayed ");
        }
        catch (Throwable e)
        {
            Assert.fail(" Could not found \" PayPerPost Background Image \" "  + " &"+e.getMessage()+"" );
        }
    }

    /**
     * Display of UserName Input Box
     * Author:- Gandahrva
     * Date:- 10-06-2020
     */
    public void verifyDisplayOfUserNameInputBox(String... strings)
    {
        ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " :: UserName InputBox is displayed or not ");

        try
        {
            genericfunctions.waitTillTheElementIsVisible(settingspageobject.general_user_name_readonly);
            Assert.assertTrue(settingspageobject.general_user_name_readonly.isDisplayed());

            ExtentTestManager.getTest().log(LogStatus.PASS,   "  UserName InputBox is displayed  ");
        }
        catch (Throwable e)
        {
            Assert.fail(" Could not found \" UserName InputBox \" "  + " &"+e.getMessage()+"" );
        }
    }

    /**
     * Display of Email Input Box
     * Author:- Gandahrva
     * Date:- 10-06-2020
     */
    public void verifyDisplayOfPrimaryEmailAddressInputBox(String... strings)
    {
        ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " :: Primary Email Address InputBox is displayed or not ");

        try
        {
            genericfunctions.waitTillTheElementIsVisible(settingspageobject.general_email_readonly);
            Assert.assertTrue(settingspageobject.general_email_readonly.isDisplayed());

            ExtentTestManager.getTest().log(LogStatus.PASS,   "  Primary Email Address InputBox is displayed  ");
        }
        catch (Throwable e)
        {
            Assert.fail(" Could not found \" Priamry Eamil Address InputBox \" "  + " &"+e.getMessage()+"" );
        }
    }

    /**
     * Display of Phone Number Input Box
     * Author:- Gandahrva
     * Date:- 10-06-2020
     */
    public void verifyDisplayOfPhoneNumberInputBox(String... strings)
    {
        ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " :: Phone Number InputBox is displayed or not ");

        try
        {
            genericfunctions.waitTillTheElementIsVisible(settingspageobject.general_phone_readonly);
            Assert.assertTrue(settingspageobject.general_phone_readonly.isDisplayed());

            ExtentTestManager.getTest().log(LogStatus.PASS,   "  Phone Number InputBox is displayed  ");
        }
        catch (Throwable e)
        {
            Assert.fail(" Could not found \" Phone Number InputBox \" "  + " &"+e.getMessage()+"" );
        }
    }

    /**
     * Display of Language Dropdown
     * Author:- Gandahrva
     * Date:- 10-06-2020
     */
    public void verifyDisplayOfLanguageDropdown(String... strings)
    {
        ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " :: Language Dropdown is displayed or not ");

        try
        {
            genericfunctions.waitTillTheElementIsVisible(settingspageobject.general_language_drop_down);
            Assert.assertTrue(settingspageobject.general_language_drop_down.isDisplayed());

            ExtentTestManager.getTest().log(LogStatus.PASS,   " Language Dropdown is displayed  ");
        }
        catch (Throwable e)
        {
            Assert.fail(" Could not found \" Language Dropdown \" "  + " &"+e.getMessage()+"" );
        }
    }

    /**
     * Display of Mature Flag
     * Author:- Gandahrva
     * Date:- 10-06-2020
     */
    public void verifyDisplayOfMatureToggleFlag(String... strings)
    {
        ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " :: Mature Toggle Flag is displayed or not ");

        try
        {
            genericfunctions.waitTillTheElementIsVisible(settingspageobject.general_flag_mature);
            Assert.assertTrue(settingspageobject.general_flag_mature.isDisplayed());

            ExtentTestManager.getTest().log(LogStatus.PASS,   " Mature Toggle Flag is displayed  ");
        }
        catch (Throwable e)
        {
            Assert.fail(" Could not found \" Mature Toggle Flag \" "  + " &"+e.getMessage()+"" );
        }
    }

    /**
     * Display of Portfolio Flag
     * Author:- Gandahrva
     * Date:- 10-06-2020
     */
    public void verifyDisplayOfPortfolioToggleFlag(String... strings)
    {
        ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " :: Portfolio ToggleFlag is displayed or not ");

        try
        {
            genericfunctions.waitTillTheElementIsVisible(settingspageobject.general_portfoilo);
            Assert.assertTrue(settingspageobject.general_portfoilo.isDisplayed());

            ExtentTestManager.getTest().log(LogStatus.PASS, " Portfolio Toggle Flag is displayed  ");
        }
        catch (Throwable e)
        {
            Assert.fail(" Could not found \" Portfolio Toggle Flag \" "  + " &"+e.getMessage()+"" );
        }
    }

    /**
     * Display of Save Button
     * Author:- Gandahrva
     * Date:- 10-06-2020
     */
    public void verifyDisplayOfSaveButton(String... strings)
    {
        ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " :: Save Button is displayed or not ");

        try
        {
            genericfunctions.waitTillTheElementIsVisible(settingspageobject.general_save_button);
            Assert.assertTrue(settingspageobject.general_save_button.isDisplayed());

            ExtentTestManager.getTest().log(LogStatus.PASS, " Save Button is displayed  ");
        }
        catch (Throwable e)
        {
            Assert.fail(" Could not found \" Save Button \" "  + " &"+e.getMessage()+"" );
        }
    }

    /**
     * Display of Deactivate Account Reasons
     * Author:- Gandahrva
     * Date:- 11-06-2020
     */
    public void verifyDisplayOfDeactivateAccountReasons(String... strings)
    {
        verticleScrollTillEnd();

        ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[1] + " :: Deactivate Account Reasons are displayed or not with following assertions :");
        List<WebElement> tabs=null;
        String[] expectedTabs=strings[0].split("\\,");
        String currentExpectedTab= null;
        String currentActualTab = null;
        /*try
        {
            ExtentTestManager.getTest().log(LogStatus.INFO, " " + "<b>"+" Reasons are :- "+"</b>");
            genericfunctions.waitTillTheElementIsVisible(settingspageobject.general_checkox_reasons.get(0));
            Assert.assertTrue(settingspageobject.general_checkox_reasons.get(0).isDisplayed());
        }
        catch (Throwable e)
        {
            Assert.fail("Could not found \" Deactivate Account Reasons \"" + "&" + e.getMessage() + "");
        }*/

        tabs = settingspageobject.general_checkox_reasons;

        List<WebElement> tabsReasons=settingspageobject.general_checkbox_reason_name;


        try
        {
            for (int i = 0; i < tabs.size(); i++)
            {
                currentExpectedTab = expectedTabs[i].trim();

                currentActualTab = tabsReasons.get(i).getText().trim();

                genericfunctions.waitTillTheElementIsVisible(settingspageobject.general_checkbox_reason_name.get(i));

                Assert.assertTrue(currentActualTab.equals(currentExpectedTab));

                ExtentTestManager.getTest().log(LogStatus.PASS, " " +   "<b>" + settingspageobject.general_checkbox_reason_name.get(i).getText() + "</b>");
            }

            ExtentTestManager.getTest().log(LogStatus.PASS, " Deactivate Account Reasons are displayed ");
        }
        catch (Throwable e)
        {
            Assert.fail("Expected :: " + currentExpectedTab + " :: Deactivate Account Reasons should be displayed  ; " +
                    "Actual ::" + currentActualTab + " :: Deactivate Account Reasons is not displayed"+"&"+e.getMessage()+"");
        }
    }

    /**
     * Display of Deactivate Account Others TextArea
     * Author:- Gandahrva
     * Date:- 10-06-2020
     */
    public void verifyDisplayOfDeactivateAccountOthersTextArea(String... strings)
    {
        ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " :: Deactivate Account Others TextArea is displayed or not ");

        try
        {
            verticleScrollTillEnd();
            genericfunctions.waitTillTheElementIsVisible(settingspageobject.general_textarea);
            Assert.assertTrue(settingspageobject.general_textarea.isDisplayed());

            ExtentTestManager.getTest().log(LogStatus.PASS, " Deactivate Account Others TextArea is displayed ");
        }
        catch (Throwable e)
        {
            Assert.fail(" Could not found \" Deactivate Account Others TextArea \" "  + " &"+e.getMessage()+"" );
        }
    }

    /**
     * Display of Deactivate Account Cancel Button
     * Author:- Gandahrva
     * Date:- 11-06-2020
     */
    public void verifyDisplayOfDeactivateAccountCancelButton(String... strings)
    {
        ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " :: Deactivate Account Cancel Button is displayed or not ");

        try
        {
            genericfunctions.waitTillTheElementIsVisible(settingspageobject.general_deactivate_cancel_button);
            Assert.assertTrue(settingspageobject.general_deactivate_cancel_button.isDisplayed());

            ExtentTestManager.getTest().log(LogStatus.PASS, " Deactivate Account Cancel Button is displayed ");
        }
        catch (Throwable e)
        {
            Assert.fail(" Could not found \" Deactivate Account Cancel Button \" "  + " &"+e.getMessage()+"" );
        }
    }

    /**
     * Display of Report DropDown
     * Author:- Gandahrva
     * Date:- 12-06-2020
     */
    public void verifyDisplayOfReportDropDown(String... strings)
    {
        ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " :: RePort DropDown is displayed or not ");

        try
        {
            genericfunctions.waitTillTheElementIsVisible(settingspageobject.support_dropdown);
            Assert.assertTrue(settingspageobject.support_dropdown.isDisplayed());

            ExtentTestManager.getTest().log(LogStatus.PASS, " RePort DropDown is displayed ");
        }
        catch (Throwable e)
        {
            Assert.fail(" Could not found \" RePort DropDown \" "  + " &"+e.getMessage()+"" );
        }
    }

    /**
     * verify Display Of Report Drop Down Options
     * 12-06-2020
     * Author:- Gandharva
     */
    public void verifyDisplayOfReportDropDownOptions(String... strings)
    {
        String[] expectedOptions=strings[0].split("\\,");
        List<WebElement> opstions = null;

        ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[1] + " :: Report DropDown Options are Displayed or Not");

        try
        {
            ExtentTestManager.getTest().log(LogStatus.INFO, " " + " Report DropDown Options :-");
            selectdropdownOption=new Select(settingspageobject.support_dropdown);
            opstions=selectdropdownOption.getOptions();

            System.out.println("OptionSize:-"+opstions.size());

            for (int i=0; i < opstions.size();i++)
            {
                String actualOption = opstions.get(i).getText();

                Assert.assertTrue(actualOption.trim().equals(expectedOptions[i].trim()));

                ExtentTestManager.getTest().log(LogStatus.PASS, " " + "<b>" +  actualOption  + "</b>" + "");
            }
        }

        catch (Throwable e)
        {
            Assert.fail(" \"Report DropDown Options\"  are not Displayed "+ "&"+e.getMessage());
        }
    }

    /**
     * Display of Portfolio Button On Profile Card
     * Author:- Gandahrva
     * Date:- 12-06-2020
     */
    public void verifyDisplayOfPortfolioButtonOnProfileCard(String... strings)
    {
        ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " :: Portfolio Button On Profile Card is displayed or not ");

        try
        {
            genericfunctions.waitTillTheElementIsVisible(postwithhashtagobjects.sidebar_portfolio_button);
            Assert.assertTrue(postwithhashtagobjects.sidebar_portfolio_button.isDisplayed());

            ExtentTestManager.getTest().log(LogStatus.PASS, " Portfolio Button On Profile Card is displayed ");
        }
        catch (Throwable e)
        {
            Assert.fail(" Could not found \" Portfolio Button On Profile Card \" "  + " &"+e.getMessage()+"" );
        }
    }

    /**
     * Display of Portfolio Button On Profile Card
     * Author:- Gandahrva
     * Date:- 12-06-2020
     */
    public void verifyPortfolioButtonIsNotDisplayedOnProfileCard(String... strings)
    {
        ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " :: Portfolio Button On Profile Card is displayed or not ");

        try
        {
            Assert.assertTrue(postwithhashtagobjects.sidebar_portfolio_button.isDisplayed());

            Assert.fail( " &"+ " \" Portfolio Button is Dispaled On Profile Card \" ");

        }
        catch (Throwable e)
        {
            ExtentTestManager.getTest().log(LogStatus.PASS, " Portfolio Button On Profile Card is not displayed ");
        }
    }



}
