package com.aeione.ops.pageactions;

import com.aeione.ops.generic.DriverManager;
import com.aeione.ops.generic.ExtentTestManager;
import com.aeione.ops.generic.GenericFunctions;
import com.aeione.ops.pageobjects.GenericPageObjects;
import com.aeione.ops.pageobjects.HomePageObjects;
import com.aeione.ops.pageobjects.LoginPageObjects;
import com.aeione.ops.pageobjects.PostWithHashTagObjects;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.List;

public class PostWithHashTagActions
{

    GenericFunctions genericfunctions;
    LoginPageObjects loginpageobjects = new LoginPageObjects();
    HomePageObjects homepageobjects = new HomePageObjects();
    PostWithHashTagObjects postwithhashtagobjects= new PostWithHashTagObjects();
    GenericPageObjects genericPageObjects = new GenericPageObjects();

    Actions actions = null;

    Select selectCurrencydropdownOption=null;
    Select selectdropdownOption=null;

    public PostWithHashTagActions()
    {
        genericfunctions = new GenericFunctions(DriverManager.getDriver());
        PageFactory.initElements(DriverManager.getDriver(), this);
        PageFactory.initElements(DriverManager.getDriver(), loginpageobjects);
        PageFactory.initElements(DriverManager.getDriver(), homepageobjects);
        PageFactory.initElements(DriverManager.getDriver(), postwithhashtagobjects);
        PageFactory.initElements(DriverManager.getDriver(), genericPageObjects);
        actions = new Actions(DriverManager.getDriver());
    }

    ////////////////////////////////////////////////////ACTION STEP//////////////////////////////////////////////////

    /**
     * Click On HashTag Drop_Down
     * Author:- Gandharva
     */
    public void clickOnHashTagDropDown(String... strings)
    {
        ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " :: Click on HashTag Drop Down");
        try
        {
            genericfunctions.waitTillTheElementIsVisible(homepageobjects.post_menu_dropdown);
            homepageobjects.post_menu_dropdown.click();
            ExtentTestManager.getTest().log(LogStatus.PASS, " Clicked on HashTag Drop Down");
        }
        catch (Throwable e)
        {
            Assert.fail("Could not perform action on \"HashTag Dropdown\""+"&"+e.getMessage()+"" );
        }
    }
    /**
     * Click On NSFW Check Box
     * Author:- Gandharva
     */
    public void clickOnRestrictedContentToggleButton(String... strings)
    {
        ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " :: Click on Restricted Content Toggle Button");
        try
        {
            genericfunctions.waitTillTheElementIsVisible(postwithhashtagobjects.post_form_nsfw_check_box);
            postwithhashtagobjects.post_form_nsfw_check_box.click();
            ExtentTestManager.getTest().log(LogStatus.PASS, "  Clicked on Restricted Content Toggle Button");
        }
        catch (Throwable e)
        {
            Assert.fail("Could not perform action on \"Restricted Content Toggle Button\""+"&"+e.getMessage()+"" );
        }
    }

    /**
     * Click On UnCover Button to View Restricted Content
     * Author:- Gandharva
     */
    public void clickOnUnCoverButton(String... strings)
    {
        ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + ":: Click on UnCover Button to View Restricted Content  ");
        try
        {
            genericfunctions.waitForPageToLoad(postwithhashtagobjects.activity_uncover_button.get(0));
            postwithhashtagobjects.activity_uncover_button.get(0).click();
            ExtentTestManager.getTest().log(LogStatus.PASS, " Clicked on UnCover Button");
        }
        catch (Throwable e)
        {
            Assert.fail("Could not perform action on \"UnCover Button\""+"&"+e.getMessage()+"" );
        }
    }

    /**
     * Click On Cover Button to Cover Restricted Content
     * Author:- Gandharva
     */
    public void clickOnCoverButton(String... strings)
    {
        ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + ":: Click on Cover Button to Cover Restricted Content  ");
        try
        {
            genericfunctions.waitForPageToLoad(postwithhashtagobjects.activity_cover_button.get(0));
            postwithhashtagobjects.activity_cover_button.get(0).click();
            ExtentTestManager.getTest().log(LogStatus.PASS, " Clicked on Cover Button");
        }
        catch (Throwable e)
        {
            Assert.fail("Could not perform action on \"Cover Button\""+"&"+e.getMessage()+"" );
        }
    }

    /**
     * Click On UnLock Button To View Paid Post
     * Author:- Gandharva
     */
    public void clickOnUnlockThisPostButtonOnPaywallWindow(String... strings)
    {
        ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + ":: Click on Unlock This Post Button on Paywall Window");
        try
        {
            genericfunctions.waitForPageToLoad(postwithhashtagobjects.creator_paywall_submit_button);
            postwithhashtagobjects.creator_paywall_submit_button.click();
            ExtentTestManager.getTest().log(LogStatus.PASS, "  Clicked on Unlock This Post Button on Paywall Window");
        }
        catch (Exception e)
        {
            Assert.fail("Could not perform action on \"Unlock This Post Button on Paywall Window\""+"&"+e.getMessage()+"" );
        }
    }

    /**
     * Click On Close Paywall Window
     * Author:- Gandharva
     */
    public void closePaywallWindow(String... strings)
    {
        ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + ":: Click on Close Paywall Window");
        try
        {
            genericfunctions.waitForPageToLoad(postwithhashtagobjects.overlay_dismiss);
            postwithhashtagobjects.overlay_dismiss.click();
        }
        catch (Exception e)
        {
            Assert.fail("Could not perform action on \"Close Paywall Window\" "+" &"+e.getMessage()+"" );
        }
    }

    /**
     * Click On Set Paid Post
     * Author:- Gandharva
     */
    public void setPaidPostPopUp(String... strings)
    {
        ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " :: Click on PayPerPost Icon");
        try
        {
            genericfunctions.waitTillTheElementIsVisible(postwithhashtagobjects.post_form_set_paywall_icon);
            postwithhashtagobjects.post_form_set_paywall_icon.click();
            ExtentTestManager.getTest().log(LogStatus.PASS, " Clicked on PayPerPost Icon");
        }
        catch (Throwable e)
        {
            Assert.fail("Could not perform action on \"PayPerPost Icon\""+"&"+e.getMessage()+"" );
        }
    }

    /**
     * Click On Set Coins for Pay Per Post
     * Author:- Gandharva
     */
    public void setCoinsForPaidPost(String... strings)
    {
        ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " :: Set Coins For Paid Post");
        String coins= strings[1];
        try
        {
            genericfunctions.waitTillTheElementIsVisible(postwithhashtagobjects.post_set_coins);
            postwithhashtagobjects.post_set_coins.sendKeys(coins);
            ExtentTestManager.getTest().log(LogStatus.PASS, " Post to be Restricted with ::" +
                    " \"<b>" + coins +"\"   </b>" +"Conis");
        }
        catch (Exception e)
        {
            Assert.fail("Could not perform action on \"Set Coins\""+"&"+e.getMessage()+"" );
        }
    }

    /**
     * Click On Set Message for Pay Per Post
     * Author:- Gandharva
     */
    public void setMessageForPaidPost(String... strings)
    {
        ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " :: Set Message For Paid Post");
        String message= strings[1];
        try
        {
            genericfunctions.waitTillTheElementIsVisible(postwithhashtagobjects.post_coins_message);
            postwithhashtagobjects.post_coins_message.sendKeys(message);
            ExtentTestManager.getTest().log(LogStatus.PASS, "  Post to be Restricted with message :: "+ " \"<b>" + message +"\" </b>"+"");
        }
        catch (Throwable e)
        {
            Assert.fail("Could not perform action on \"Set Message\""+"&"+e.getMessage()+"" );
        }
    }
    /**
     * Click On Add Button Coins for Pay Per Post
     * Author:- Gandharva
     */
    public void clickOnAddCoinsButtonForPaidPost(String... strings)
    {
        ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + ":: Click on Add Button for Set Paywall");
        try
        {
            genericfunctions.waitTillTheElementIsVisible(postwithhashtagobjects.post_set_coins);
            postwithhashtagobjects.post_coins_add_button.click();
            ExtentTestManager.getTest().log(LogStatus.PASS, "  Clicked on Add Button for Set Paywall");
        }
        catch (Throwable e)
        {
            Assert.fail("Could not perform action on \"Add Button\""+"&"+e.getMessage()+"" );
        }
    }

    /**
     * Click On UnLock Button To View Paid Post
     * Author:- Gandharva
     */
    public void clickOnUnlockThisPostButton(String... strings)
    {
        ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + ":: Click on Unlock This Post Button");
        genericfunctions.waitWebDriver(2000);
        try
        {
            genericfunctions.waitForPageToLoad(postwithhashtagobjects.paywall_unlock_button.get(0));
            postwithhashtagobjects.paywall_unlock_button.get(0).click();
            ExtentTestManager.getTest().log(LogStatus.PASS, "  Clicked on \"Unlock This Post\" Button");
        }
        catch (Throwable e)
        {
            Assert.fail("Could not perform action on \"Unlock This Post Button\""+"&"+e.getMessage()+"" );
        }
    }

    /**
     * Click On More Menu
     * Author:- Gandharva
     */
    public void clickOnMoreMenuInPostCard(String... strings)
    {
        ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + ":: Click on More Post Menu");
        try
        {
            genericfunctions.waitWebDriver(2000);
            genericfunctions.waitForPageToLoad(postwithhashtagobjects.more_menu_post.get(0));
            postwithhashtagobjects.more_menu_post.get(0).click();
        }
        catch (Throwable e)
        {
            Assert.fail("Could not perform action on \"More Post Menu\" "+" &"+e.getMessage()+"" );
        }
    }

    /**
     * Perform Post Action
     * Author:- Gandharva
     */
    public void postMenuDropDownActions(String... strings)
    {
        String action = strings[1];
        ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + ":: Post Menu Drop Down Actions");
        try
        {
            switch (action)
            {
                case "edit":
                    ExtentTestManager.getTest().log(LogStatus.INFO, " "+ " \"Click on Edit\" ");
                    DriverManager.getDriver().findElement(By.id("post-menu-"+action)).click();
                    ExtentTestManager.getTest().log(LogStatus.PASS, " "+ " \"Clicked on Edit\" ");
                    break;

                case "delete":
                    ExtentTestManager.getTest().log(LogStatus.INFO, " "+ " \"Click on Delete\" ");
                    DriverManager.getDriver().findElement(By.id("post-menu-"+action)).click();
                    ExtentTestManager.getTest().log(LogStatus.PASS, " "+ " \"Clicked on Delete\" ");
                    break;

                case "follow-post":
                    ExtentTestManager.getTest().log(LogStatus.INFO, " "+ " \"Click on Follow Post\" ");
                    DriverManager.getDriver().findElement(By.id("post-menu-"+action)).click();
                    ExtentTestManager.getTest().log(LogStatus.PASS, " "+ " \"Clicked on Follow Post\" ");
                    break;

                case "unfollow-post":
                    ExtentTestManager.getTest().log(LogStatus.INFO, " "+ " \"Click on UnFollow Post\" ");
                    DriverManager.getDriver().findElement(By.id("post-menu-"+action)).click();
                    ExtentTestManager.getTest().log(LogStatus.PASS, " "+ " \"Clicked on UnFollow Post\" ");
                    break;

                case "set-explicit":
                    ExtentTestManager.getTest().log(LogStatus.INFO, " "+ " \"Click on Set Explicit\" ");
                    DriverManager.getDriver().findElement(By.id("post-menu-"+action)).click();
                    ExtentTestManager.getTest().log(LogStatus.PASS, " "+ "\" Clicked on Set Explicit\" ");
                    break;

                case "remove-explicit":
                    ExtentTestManager.getTest().log(LogStatus.INFO, " "+ " \"Click on Remove Explicit\" ");
                    DriverManager.getDriver().findElement(By.id("post-menu-"+action)).click();
                    ExtentTestManager.getTest().log(LogStatus.PASS, " "+ " \"Clicked on Remove Explicit\" ");
                    break;

                case "report":
                    ExtentTestManager.getTest().log(LogStatus.INFO, " "+ " \"Click on Report\" ");
                    DriverManager.getDriver().findElement(By.id("post-menu-"+action)).click();
                    ExtentTestManager.getTest().log(LogStatus.PASS, " "+ "\"Clicked on Report\" ");
                    break;

                case "block-user":
                    ExtentTestManager.getTest().log(LogStatus.INFO, " "+ " \"Click on Block User\" ");
                    DriverManager.getDriver().findElement(By.id("post-menu-"+action)).click();
                    ExtentTestManager.getTest().log(LogStatus.PASS, " "+ " \"Clicked on Block User\" ");
                    break;

            }
        }
        catch (Throwable e)
        {
            Assert.fail("Could not perform an action :: " + "\"<b>" + action + " </b>" + " &"+e.getMessage()+"" );
        }
    }

    /**
     * Perform Edit-Post Action
     * Author:- Gandharva
     */
    public void postEditAction(String... strings)
    {
        String editedText = strings[1];
        try
        {
            ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + ":: Enter text on Message Text Area as :: "  + "\"<b>" + editedText +"\"   </b>" );
            genericfunctions.waitForPageToLoad(postwithhashtagobjects.activity_edit_action);
            postwithhashtagobjects.activity_edit_action.clear();
            postwithhashtagobjects.activity_edit_action.sendKeys(editedText);
        }
        catch (Throwable e)
        {
            Assert.fail("Could not perform an \" Edit \"action"  + " &"+e.getMessage()+"" );
        }
    }

    /**
     * Perform Edit-Post Action
     * Author:- Gandharva
     */
    public void saveEditedPostAction(String... strings)
    {
        try
        {
            ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + ":: Click on Save Button ");
            genericfunctions.waitForPageToLoad(postwithhashtagobjects.activity_save_action);
            postwithhashtagobjects.activity_save_action.click();
        }
        catch (Throwable e)
        {
            Assert.fail("Could not perform \" Save \" Button"  + " &"+e.getMessage()+"" );
        }
    }

    /**
     * Perform Post Action
     * Author:- Gandharva
     */
    public void selectHashTagFromDropdownList(String... strings)
    {
        String action = strings[1];
        ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + ":: Select "  + "<b>" + action + "</b>" +  " HashTags From Drop Down List");
        try
        {
            switch (action)
            {
                case "showtimez":
                    ExtentTestManager.getTest().log(LogStatus.INFO, " "+ " Click on  \"#Showtimez \" ");
                    DriverManager.getDriver().findElement(By.id("post-menu-"+action)).click();
                    ExtentTestManager.getTest().log(LogStatus.PASS, " "+ " Clicked on  \"#Showtimez \" ");
                    break;
                case "opportunity":
                    ExtentTestManager.getTest().log(LogStatus.INFO, " "+ " Click on  \"#Opportunity \" ");
                    DriverManager.getDriver().findElement(By.id("post-menu-"+action)).click();
                    ExtentTestManager.getTest().log(LogStatus.PASS, " "+ " Clicked on \"#Opportunity \" ");
                    break;
                case "the-bluestore":
                    ExtentTestManager.getTest().log(LogStatus.INFO, " "+ "Click on \"#TheBlueStore \" ");
                    DriverManager.getDriver().findElement(By.id("post-menu-"+action)).click();
                    ExtentTestManager.getTest().log(LogStatus.PASS, " "+ "Clicked on \"#TheBlueStore \" ");
                    break;
                case "portfolio":
                    ExtentTestManager.getTest().log(LogStatus.INFO, " "+ "Click on \"#Portfolio \" ");
                    DriverManager.getDriver().findElement(By.id("post-menu-"+action)).click();
                    ExtentTestManager.getTest().log(LogStatus.PASS, " "+ " Clicked on \"#Portfolio \" ");
                    break;
                case "my-journey":
                    ExtentTestManager.getTest().log(LogStatus.INFO, " "+ " Click on \"#MyJourney \" ");
                    DriverManager.getDriver().findElement(By.id("post-menu-"+action)).click();
                    ExtentTestManager.getTest().log(LogStatus.PASS, " "+ " Clicked on \"#MyJourney \" ");
                    break;

            }
        }
        catch (Throwable e)
        {
            Assert.fail("Could not perform an action ::" + "<b>" + action  + "</b>" + ""  + " &"+e.getMessage()+"" );
        }
    }

    /**
     * Enter ShowTimez Title
     * Author:- Gandharva
     */
    public void enterShowTimezTitle(String... strings)
    {
        String title = strings[1];
        ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + ":: Enter ShowTimes Title as " + "\"<b>" + title +"\"   </b>"  );
        try
        {
            genericfunctions.waitForPageToLoad(postwithhashtagobjects.showtimez_title);
            postwithhashtagobjects.showtimez_title.clear();

            postwithhashtagobjects.showtimez_title.sendKeys(title);
        }
        catch (Throwable e)
        {
            Assert.fail("Could not able to enter ShowTimes title" + " &"+e.getMessage()+ "");
        }
    }

    /**
     * Enter ShowTimez Discription
     * Author:- Gandharva
     */
    public void enterShowTimezDescription(String... strings)
    {
        String description = strings[1];
        ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + ":: Enter ShowTimes Description as " + "\"<b>" + description +"\"   </b>" );
        try
        {
            genericfunctions.waitForPageToLoad(postwithhashtagobjects.showtimez_description);
            postwithhashtagobjects.showtimez_description.clear();

            postwithhashtagobjects.showtimez_description.sendKeys(description);
        }
        catch (Exception e)
        {
            Assert.fail("Could not able to enter ShowTimes description" + " &"+e.getMessage()+ "");
        }
    }

    /**
     * Enter ShowTimez Location
     * Author:- Gandharva
     */
    public void enterShowTimezLocation(String... strings)
    {
        String location = strings[1];
        ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + ":: Enter ShowTimes Location as "  + "\"<b>" + location +"\"   </b>" );
        try
        {
            genericfunctions.waitForPageToLoad(postwithhashtagobjects.showtimez_location);
            postwithhashtagobjects.showtimez_location.clear();

            postwithhashtagobjects.showtimez_location.sendKeys(location);
        }
        catch (Throwable e)
        {
            Assert.fail("Could not able to enter ShowTimes Location" + " &"+e.getMessage()+ "");
        }
    }

    /**
     * Enter ShowTimez Date
     * Author:- Gandharva
     */
    public void enterShowTimezDate(String... strings)
    {
        String date = strings[1];
        ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + ":: Enter ShowTimes Date as "+ "\"<b>" + date +"\"   </b>" );
        try
        {
            genericfunctions.waitForPageToLoad(postwithhashtagobjects.showtimez_date);
            postwithhashtagobjects.showtimez_date.clear();

            postwithhashtagobjects.showtimez_date.sendKeys(date);
        }
        catch (Throwable e)
        {
            Assert.fail("Could not able to enter ShowTimes Date" + " &"+e.getMessage()+ "");
        }
    }

    /**
     * Enter ShowTimez Time
     * Author:- Gandharva
     */
    public void enterShowTimezTime(String... strings)
    {
        String time = strings[1];
        ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + ":: Enter ShowTimes Time as "  + "\"<b>" + time +"\"   </b>" );
        try
        {
            genericfunctions.waitForPageToLoad(postwithhashtagobjects.showtimez_time);
            postwithhashtagobjects.showtimez_time.clear();

            postwithhashtagobjects.showtimez_time.sendKeys(time);
        }
        catch (Throwable e)
        {
            Assert.fail("Could not able to enter ShowTimes Time" + " &"+e.getMessage()+ "");
        }
    }

    /**
     * Click on ShowTimez Post Button
     * Gandharva
     */
    public void clickOnShowTimezSubmitButton(String... strings)
    {
        ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " :: Click on ShowTimez Submit Button");
        try
        {
            genericfunctions.waitTillTheElementIsVisible(postwithhashtagobjects.showtimez_submit_button);
            postwithhashtagobjects.showtimez_submit_button.click();

        }
        catch (Throwable e)
        {
            Assert.fail("Could not perform action on \"ShowTimez Submit Button\""+"&"+e.getMessage()+"" );
        }
    }

    /**
     * Enter BlueStore Title
     * Author:- Gandharva
     */
    public void enterBlueStoreTitle(String... strings)
    {
        String title = strings[1];
        ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + ":: Enter BlueStore Title as " + "\"<b>" + title +"\"   </b>" );
        try
        {

            genericfunctions.waitTillTheElementIsVisible(postwithhashtagobjects.bluestore_title);
            postwithhashtagobjects.bluestore_title.clear();

            postwithhashtagobjects.bluestore_title.sendKeys(title);
        }
        catch (Throwable e)
        {
            Assert.fail("Could not able to enter bluestore title" + " &"+e.getMessage()+ "");
        }
    }

    /**
     * Enter BlueStore Discription
     * Author:- Gandharva
     */
    public void enterBlueStoreDescription(String... strings)
    {
        String description = strings[1];
        ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + ":: Enter BlueStore Description as " + "\"<b>" + description +"\"   </b>");
        try
        {

            genericfunctions.waitTillTheElementIsVisible(postwithhashtagobjects.bluestore_description);
            postwithhashtagobjects.bluestore_description.clear();
            postwithhashtagobjects.bluestore_description.sendKeys(description);
        }
        catch (Throwable e)
        {
            Assert.fail("Could not able to enter bluestore description" + " &"+e.getMessage()+ "");
        }
    }

    /**
     * Enter BlueStore Units
     * Author:- Gandharva
     */
    public void enterBlueStoreUnits(String... strings)
    {
        String units = strings[1];
        ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + ":: Enter BlueStore Units as " +  "\"<b>" + units +"\"   </b>");
        try
        {

            genericfunctions.waitTillTheElementIsVisible(postwithhashtagobjects.bluestore_units);
            postwithhashtagobjects.bluestore_units.clear();
            postwithhashtagobjects.bluestore_units.sendKeys(units);
        }
        catch (Throwable e)
        {
            Assert.fail("Could not able to enter bluestore Units" + " &"+e.getMessage()+ "");
        }
    }

    /**
     * Enter BlueStore Price
     * Author:- Gandharva
     */
    public void enterBlueStorePrice(String... strings)
    {
        String price = strings[1];
        ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + ":: Enter BlueStore Price as "+ "\"<b>" + price +"\"   </b>");
        try
        {
            genericfunctions.waitTillTheElementIsVisible(postwithhashtagobjects.bluestore_price);
            postwithhashtagobjects.bluestore_price.clear();
            postwithhashtagobjects.bluestore_price.sendKeys(price);
        }
        catch (Throwable e)
        {
            Assert.fail("Could not able to enter bluestore Price" + " &"+e.getMessage()+ "");
        }
    }

    /**
     * Click on Share Post Button
     * Author:- Gandharva
     */
    public void clickOnShareButton(String... strings)
    {
        ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + ":: Click On Share Button");
        try
        {
            genericfunctions.waitForPageToLoad(postwithhashtagobjects.share_menu.get(0));
            postwithhashtagobjects.share_menu.get(0).click();
        }
        catch (Throwable e)
        {
            Assert.fail("Could not perform an action on \" Share Button\" " + " &"+e.getMessage()+ "");
        }
    }

    /**
     * Click on Share BlueStore Submit  Post
     * Author:- Gandharva
     */
    public void clickOnBluestoreSubmitButton(String... strings)
    {
        ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + ":: Click On BlueStore Submit Button");
        try
        {
            genericfunctions.waitForPageToLoad(postwithhashtagobjects.bluestore_submit);
            postwithhashtagobjects.bluestore_submit.click();
        }
        catch (Throwable e)
        {
            Assert.fail("Could not perform an action on \" Post BlueStore\" " + " &"+e.getMessage()+ "");
        }
    }
    /**
     * Click on Share Menu Repost
     * Author:- Gandharva
     */
    public void clickOnShareMenuRepost(String... strings)
    {
        ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + ":: Click On Repost Button");
        try
        {
            genericfunctions.waitForPageToLoad(postwithhashtagobjects.share_menu_repost.get(0));
            postwithhashtagobjects.share_menu_repost.get(0).click();
        }
        catch (Throwable e)
        {
            Assert.fail("Could not perform an action on \" Repost Button\" " + " &"+e.getMessage()+ "");
        }
    }
    /**
     * Enter RepostMessage
     * Author:- Gandharva
     */
    public void enterRepostMessage(String... strings)
    {
        String message = strings[1];
        ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + ":: Enter RePost Message as " + " \"<b>" + message +"\" </b>");
        try
        {
            genericfunctions.waitForPageToLoad(postwithhashtagobjects.repost_message);
            postwithhashtagobjects.repost_message.sendKeys(message);
        }
        catch (Throwable e)
        {
            Assert.fail("Could not perform an action on \" RePost Message\" " + " &"+e.getMessage()+ "");
        }
    }

    /**
     * Click on RePost Sahre Button
     * Author:- Gandharva
     */
    public void clickOnRePostShareButton(String... strings)
    {
        ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + ":: Click On RePost Share Button");
        try
        {
            genericfunctions.waitTillTheElementIsVisible(postwithhashtagobjects.repost_share_button);
            postwithhashtagobjects.repost_share_button.click();
        }
        catch (Throwable e)
        {
            Assert.fail("Could not perform an action on \" RePost Share \" " + " &"+e.getMessage()+ "");
        }
    }

    /**
     * Verify RePost Post
     * Author:- Gandharva
     */
    public void verifyDisplayOfRepostHeaderOnTimeLine(String... strings)
    {
        ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " ::  Reposted Post Header is Displayed or Not on  TimeLine");

        try
        {
            genericfunctions.waitForPageToLoad(postwithhashtagobjects.repost_on_home_timeline);
            Assert.assertTrue(postwithhashtagobjects.repost_on_home_timeline.isDisplayed());
            ExtentTestManager.getTest().log(LogStatus.PASS,  "  \"Reposted Post Header \" is Displayed on  TimeLine");
        }

        catch(Throwable e)
        {
            Assert.fail("Expected :: \"Reposted Post Header \" should be displayed on  TimeLine;" +
                    " Actual :: \"Reposted Post Header \" is not displayed on  TimeLine"+"&"+e.getMessage()+"");
        }
    }
    /**
     * Click on MyJourney Post Button
     * Gandharva
     */
    public void clickOnMyJourneySubmitButton(String... strings)
    {
        ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " :: Click on MyJourney Submit Button");
        try
        {
            genericfunctions.waitTillTheElementIsVisible(postwithhashtagobjects.myjourney_submit_button);
            postwithhashtagobjects.myjourney_submit_button.click();

        }
        catch (Throwable e)
        {
            Assert.fail("Could not perform action on \"MyJourney Submit Button\""+"&"+e.getMessage()+"" );
        }
    }

    /**
     * Click on Profile Details
     * Gandharva
     */
    public void clickOnProfileDetails(String... strings)
    {
        ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " :: Click on Profile Details ");

        try
        {
            genericfunctions.waitTillTheElementIsVisible(postwithhashtagobjects.user_profile_details);
            postwithhashtagobjects.user_profile_details.click();

        }
        catch (Throwable e)
        {
            Assert.fail("Could not perform action on \"Profile Details\""+"&"+e.getMessage()+"" );
        }
    }

    /**
     * Click on ReachOut Button
     * Gandharva
     */
    public void clickOnReachOutButton(String... strings)
    {
        ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " :: Click on ReachOut Button");
        try
        {
            genericfunctions.waitTillTheElementIsVisible(postwithhashtagobjects.reach_out_button.get(0));
            postwithhashtagobjects.reach_out_button.get(0).click();
        }
        catch (Throwable e)
        {
            Assert.fail("Could not perform action on \"ReachOut Button\""+"&"+e.getMessage()+"" );
        }
    }

    /**
     * Click on Send Button
     * Gandharva
     */
    public void clickOnSendButton(String... strings)
    {
        ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " :: Click on Send Button");
        try
        {
            genericfunctions.waitTillTheElementIsVisible(postwithhashtagobjects.send_button);
            postwithhashtagobjects.send_button.click();

        }
        catch (Throwable e)
        {
            Assert.fail("Could not perform action on \"Send Button\""+"&"+e.getMessage()+"" );
        }
    }

    /**
     * Click on Send Button
     * Gandharva
     * Date:- 22-15-2020
     */
    public void selectCurrencyType(String... strings)
    {

        String currency=strings[1];
        ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " :: Select Currency Type as "+  "\"<b>" + currency +"\"   </b>");
        try
        {
            selectCurrencydropdownOption=new Select(postwithhashtagobjects.bluestore_currency_type);
            selectCurrencydropdownOption.selectByValue(currency);
        }
        catch (Throwable e)
        {
            Assert.fail("Could not perform an action on \"Currency Type\" "+"&"+e.getMessage()+"" );
        }
    }

    /**
     * Delete HashTag Post
     * Gandharva
     * Date:- 22-15-2020
     */
    public void deleteHashTagPost(String... strings)
    {
        String expectedPostTitle = strings[1];
        String header_value= strings[2];
        String actualPostTitle = null;
        ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " :: Delete Action to be Performed");
        try
        {
            actualPostTitle=DriverManager.getDriver().findElement(By.id("activity-"+header_value)).getText();
            Assert.assertTrue(actualPostTitle.equals(expectedPostTitle));
        }
        catch(Throwable e)
        {
            Assert.fail("Could not perform action on \" Delete Hash Tag Post\""+e.getMessage());
        }
    }

    /**
     * Click on Portfolio Post Button
     * Gandharva
     * Date:- 27-05-2020
     */
    public void clickOnPortfolioSubmitButton(String... strings)
    {
        ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " :: Click on Portfolio Submit Button");
        try
        {
            genericfunctions.waitTillTheElementIsVisible(postwithhashtagobjects.portfolio_submit_button);
            postwithhashtagobjects.portfolio_submit_button.click();

        }
        catch (Throwable e)
        {
            Assert.fail("Could not perform action on \"Portfolio Submit Button\""+"&"+e.getMessage()+"" );
        }
    }

    /**
     * Click on Portfolio  Button on Profile Page
     * Gandharva
     * Date:- 27-05-2020
     */
    public void clickOnPortfolioButtonOnProfilePage(String... strings)
    {
        ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " :: Click on Portfolio Button on Profile Page");
        try
        {
            genericfunctions.waitTillTheElementIsVisible(postwithhashtagobjects.sidebar_portfolio_button);
            postwithhashtagobjects.sidebar_portfolio_button.click();

        }
        catch (Throwable e)
        {
            Assert.fail("Could not perform action on \"Portfolio Submit Button\""+"&"+e.getMessage()+"" );
        }
    }

    /**
     * Click On NSFW Check Box for Portfolio
     * Author:- Gandharva
     * Date:- 27-05-2020
     */
    public void clickOnPortfolioRestrictedContentToggleButton(String... strings)
    {
        ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " :: Click on Portfolio Restricted Content Toggle Button");
        try
        {
            genericfunctions.waitTillTheElementIsVisible(postwithhashtagobjects.portfolio_nsfw_toggle_Button);
            postwithhashtagobjects.portfolio_nsfw_toggle_Button.click();
            ExtentTestManager.getTest().log(LogStatus.PASS, "  Clicked on Portfolio Restricted Content Toggle Button");
        }
        catch (Throwable e)
        {
            Assert.fail("Could not perform action on \"Portfolio Restricted Content Toggle Button\""+"&"+e.getMessage()+"" );
        }
    }

    /**
     * Perform  Action
     * Author:- Gandharva
     * Date:- 27-05-2020
     */
    public void clickOnCreatedHashTagPostOnFollowersFeed(String... strings)
    {
        String action = strings[1].trim();
        String activity = null;
        ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + ":: Click On Created HashTag Post On Followers Feed");

        try
        {
            switch (action)
            {
                case "#Showtimez":
                    ExtentTestManager.getTest().log(LogStatus.INFO, " "+ " User to be navigates to " + " \"<b>" + action +"\"   </b>" + " Inner Page ");
                    genericfunctions.waitTillTheElementIsVisible(postwithhashtagobjects.hashTag_header.get(0));
                    activity = postwithhashtagobjects.hashTag_header.get(0).getText().trim();
                    Assert.assertTrue(activity.equals(action));
                    postwithhashtagobjects.hashTag_header.get(0).click();
                    ExtentTestManager.getTest().log(LogStatus.PASS, " "+ " User navigated to \"#ShowTime Post \" Inner Page ");
                    break;
                case "#Opportunity":
                    ExtentTestManager.getTest().log(LogStatus.INFO, " "+ " User to be navigates to " + " \"<b>" + action +"\"   </b>" + " Inner Page ");
                    genericfunctions.waitTillTheElementIsVisible(postwithhashtagobjects.hashTag_header.get(0));
                    activity = postwithhashtagobjects.hashTag_header.get(0).getText().trim();
                    Assert.assertTrue(activity.equals(action));
                    postwithhashtagobjects.hashTag_header.get(0).click();
                    ExtentTestManager.getTest().log(LogStatus.PASS, " "+ " User navigated to \"#Opportunity Post \" Inner Page ");
                    break;
                case "#TheBlueStore":
                    ExtentTestManager.getTest().log(LogStatus.INFO, " "+ " User to be navigates to " + " \"<b>" + action +"\"   </b>" + " Inner Page ");
                    genericfunctions.waitTillTheElementIsVisible(postwithhashtagobjects.hashTag_header.get(0));
                    activity = postwithhashtagobjects.hashTag_header.get(0).getText().trim();
                    Assert.assertTrue(activity.equals(action));
                    postwithhashtagobjects.hashTag_header.get(0).click();
                    ExtentTestManager.getTest().log(LogStatus.PASS, " "+ " User navigated to \"#The-BlueStore Post \" Inner Page  ");
                    break;
                case "#Portfolio":
                    ExtentTestManager.getTest().log(LogStatus.INFO, " "+ " User to be navigates to " + " \"<b>" + action +"\"   </b>" + " Inner Page ");
                    genericfunctions.waitTillTheElementIsVisible(postwithhashtagobjects.hashTag_header.get(0));
                    activity = postwithhashtagobjects.hashTag_header.get(0).getText().trim();
                    Assert.assertTrue(activity.equals(action));
                    postwithhashtagobjects.hashTag_header.get(0).click();
                    ExtentTestManager.getTest().log(LogStatus.PASS, " "+ " User navigated to \"#Portfolio Post \" Inner Page ");
                    break;
                case "#Myjourney":
                    ExtentTestManager.getTest().log(LogStatus.INFO, " "+ " User to be navigates to " + " \"<b>" + action +"\"   </b>" + " Inner Page ");
                    genericfunctions.waitTillTheElementIsVisible(postwithhashtagobjects.hashTag_header.get(0));
                    activity = postwithhashtagobjects.hashTag_header.get(0).getText().trim();
                    Assert.assertTrue(activity.equals(action));
                    postwithhashtagobjects.hashTag_header.get(0).click();
                    ExtentTestManager.getTest().log(LogStatus.PASS, " "+ " User navigated to \"#MyJourney Post \" Inner Page  ");
                    break;
            }
        }
        catch (Throwable e)
        {
            Assert.fail("Expected :: " + action + " HashTag should be displayed  ; Actual ::" + activity + " HashTag is  displayed"+"&"+e.getMessage()+"");
        }
    }

    /**
     * Profile Activity Details
     * Author:- Gandharva
     * Date:- 27-05-20202
     */
    public String getProfileActivityDetails(String... strings)
    {
        String action =strings[1];
        String count = null;
        ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " :: Profile Activity Details are displayed or not");

        try
        {
            switch (action)
            {
                case "like-count":
                    count= DriverManager.getDriver().findElement(By.id("view-profile-"+action)).getText();
                    ExtentTestManager.getTest().log(LogStatus.PASS, " "+ " Post \" Like \" Counts are "+ "<b>"+ count+ "</b>");

                    break;
                case "sahred":
                    count= DriverManager.getDriver().findElement(By.id("view-profile-"+action)).getText();
                    ExtentTestManager.getTest().log(LogStatus.INFO, " "+ " Post \" Share \" Counts are "+ "<b>"+ count+ "</b>");

                    break;

                case "contributed":
                    count= DriverManager.getDriver().findElement(By.id("view-"+action)).getText();
                    ExtentTestManager.getTest().log(LogStatus.INFO, " "+ " Post \" Contribute \" Counts are "+ "<b>"+ count+ "</b>");

                    break;

                case "impressions":
                    count= DriverManager.getDriver().findElement(By.id("view-profile"+action)).getText();
                    ExtentTestManager.getTest().log(LogStatus.INFO, " "+ " Post \" Impressions \" Counts are "+ "<b>"+ count+ "</b>");

                    break;

                default:
                    break;

            }
        }
        catch (Throwable e)
        {
            Assert.fail("Could not found \"Profile Activity Details\" " + "&" + e.getMessage() + "");
        }

        return count;
    }


    /**
     *  Click On Like
     * Author:- Gandharva
     * Date:- 27-05-20202
     */
    public void clickOnLikeInPostInnerPage(String... strings)
    {
        ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " :: Click on Like In Post Inner Page ");
        try
        {
            genericfunctions.waitTillTheElementIsVisible(postwithhashtagobjects.like_count);
            Assert.assertTrue(postwithhashtagobjects.like_count.isDisplayed());

            postwithhashtagobjects.like_count.click();
        }
        catch (Throwable e)
        {
            Assert.fail("Could not perform action on \" Like \" "+ "&" + e.getMessage() + "");
        }
    }


    /**
     *  Click On Like
     * Author:- Gandharva
     * Date:- 27-05-20202
     */
    public void verifLikeAndShareCount(String... strings)
    {
        ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " ::  Profile Activity Counts are Updated or not after Click on Action In Post Inner Page ");
        String action = strings[1];
        String exceptedCount= strings[2];
        try
        {
            String count= DriverManager.getDriver().findElement(By.id("view-profile-"+action)).getText().replaceAll("[^0-9]"," ");

            //System.out.println("Like Data:-"+count);
            //System.out.println("Like:-"+count.replaceAll("[^0-9]"," "));

            if (!count.equals(exceptedCount))
            {
                ExtentTestManager.getTest().log(LogStatus.PASS, " "+ " Profile Activity Counts are :: "+ "<b>"+ count+ "</b>");
            }
            /*else
            {
                Assert.fail("Profile Activity Counts are not Increased..!!!!");
            }*/
        }
        catch (Throwable e)
        {
            Assert.fail("Could not perform action on \" Profile Activity Counts \" "+ "&" + e.getMessage() + "");
        }
    }

    /**
     *  Click On Share
     * Author:- Gandharva
     * Date:- 27-05-20202
     */
    public void clickOnShareInPostInnerPage(String... strings)
    {
        ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " :: Click on Share In Post Inner Page");
        try
        {
            genericfunctions.waitTillTheElementIsVisible(postwithhashtagobjects.share_menu_share);
            Assert.assertTrue(postwithhashtagobjects.share_menu_share.isDisplayed());
            postwithhashtagobjects.share_menu_share.click();
        }
        catch (Throwable e)
        {
            Assert.fail("Could not perform action on \" Share \" "+ "&" + e.getMessage() + "");
        }
    }

    /**
     * Click Onn Bookmark Icon
     * Author:- Gandharva
     * Date:- 27-05-20202
     */
    public void clickOnBookmarkIconInPostInnerPage(String... strings)
    {
        ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " :: Click on Bookmark Icon In Post Inner Page");

        try
        {
            genericfunctions.waitTillTheElementIsVisible(postwithhashtagobjects.bookmark_turned_in_not);
            Assert.assertTrue(postwithhashtagobjects.bookmark_turned_in_not.isDisplayed());
        }
        catch (Throwable e)
        {
            Assert.fail(" " + "&" + e.getMessage() + "");
        }
        try
        {
            genericfunctions.waitTillTheElementIsVisible(postwithhashtagobjects.view_profile_bookmark_icon);
            Assert.assertTrue(postwithhashtagobjects.view_profile_bookmark_icon.isDisplayed());
            postwithhashtagobjects.view_profile_bookmark_icon.click();

            ExtentTestManager.getTest().log(LogStatus.PASS, " " + strings[0] + " :: Clicked on Bookmark Icon In Post Inner Page");
        }
        catch (Throwable e)
        {
            Assert.fail("Could not perform action on \" Bookmark \" "+ "&" + e.getMessage() + "");
        }
        try
        {
            genericfunctions.waitTillTheElementIsVisible(postwithhashtagobjects.bookmark_turned_in);
            Assert.assertTrue(postwithhashtagobjects.bookmark_turned_in.isDisplayed());
        }
        catch (Throwable e)
        {
            Assert.fail(" " + "&" + e.getMessage() + "");
        }
    }


////////////////////////////////////////////////////VERIFY STEP//////////////////////////////////////////////////

    /**
     * Verify Post Contents
     * Author:- Gandahrva
     */
    public void verifyContentsOfCreatePostWidget(String... strings)
    {
        ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " :: Contents of Poster Text Area with following assertion :");
        verifyDisplayOfDropdownHashTag(strings[0]);
        verifyDisplayOfWriteBlogLink(strings[0]);
        verifyDisplayOfClosePostIcon(strings[0]);
        verifyDisplayOfProfileImage(strings[0]);
        verifyDisplayOfTextArea(strings[0]);
        verifyDisplayOfAttachIcon(strings[0]);
        verifyDisplayOfNSFWToggle(strings[0]);
        verifyDisplayOfPayPerPost(strings[0]);
        verifyDisplayOfPostButton(strings[0]);
    }


    /**
     * Verify Drop Down
     * Author:- Gandahrva
     */
    public void verifyDisplayOfDropdownHashTag(String... strings)
    {
        try
        {
            genericfunctions.waitForPageToLoad(homepageobjects.post_menu_dropdown);
            Assert.assertTrue(homepageobjects.post_menu_dropdown.isDisplayed());
            ExtentTestManager.getTest().log(LogStatus.PASS, "" + "  \"Drop_Down\" is displayed");
        } catch (Throwable e)
        {
            Assert.fail("Expected :: \"Drop_Down \" should be displayed ; Actual :: \"Drop_Down\" is not displayed"+"&"+e.getMessage()+"");
        }
    }

    /**
     * Verify Blog Link
     * Author:- Gandahrva
     */
    public void verifyDisplayOfWriteBlogLink(String... strings)
    {
        try
        {
            genericfunctions.waitTillTheElementIsVisible(postwithhashtagobjects.poster_write_blog_link);
            Assert.assertTrue(postwithhashtagobjects.poster_write_blog_link.isDisplayed());
            ExtentTestManager.getTest().log(LogStatus.PASS, "" + "  \"Write Blog Icon\" is displayed");
        }
        catch(Throwable e)
        {
            String actualThrowable=e.getClass().getName();

            switch (actualThrowable)
            {
                case "java.lang.NoSuchElementThrowable":
                    Assert.fail("Expected :: \"Write Blog Icon\" Post should be displayed ; Actual :: \"Write Blog Icon\" post is not displayed"+"&"+e.getMessage()+"" );
                    break;
                case "java.lang.AssertionError":
                    Assert.fail("Expected :: \"Write Blog Icon\" Post should be displayed as " + " ; Actual :: \"Write Blog Icon\" post is displayed as");
                    break;
                default:
                    Assert.fail(""+"&"+e.getMessage()+"");
            }
        }
    }

    /**
     * Verify Post Close Icon
     * Author:- Gandahrva
     */
    public void verifyDisplayOfClosePostIcon(String... strings)
    {
        try
        {
            genericfunctions.waitForPageToLoad(postwithhashtagobjects.poster_exit);
            Assert.assertTrue(postwithhashtagobjects.poster_exit.isDisplayed());
            ExtentTestManager.getTest().log(LogStatus.PASS, "" + "  \"Post Close Icon\" is displayed");
        }
        catch (Throwable e)
        {
            Assert.fail("Expected :: \"Post Close Icon \" should be displayed ; Actual :: \"Post Close Icon\" is not displayed"+"&"+e.getMessage()+"");
        }
    }

    /**
     * Verify Blog Link
     * Author:- Gandahrva
     */
    public void verifyDisplayOfProfileImage(String... strings)
    {
        try
        {
            genericfunctions.waitForPageToLoad(postwithhashtagobjects.post_form_profile_image);
            Assert.assertTrue(postwithhashtagobjects.post_form_profile_image.isDisplayed());
            ExtentTestManager.getTest().log(LogStatus.PASS, "" + "  \"Profile Image\" is displayed");
        }
        catch (Throwable e)
        {
            Assert.fail("Expected :: \"Profile Image \" should be displayed ;" +
                    " Actual :: \"Profile Image\" is not displayed"+"&"+e.getMessage()+"");
        }
    }


    /**
     * Verify Post Text Area
     * Author:- Gandahrva
     */
    public void verifyDisplayOfTextArea(String... strings)
    {
        try
        {
            genericfunctions.waitWebDriver(2000);
            genericfunctions.waitForPageToLoad(homepageobjects.message_textarea);
            Assert.assertTrue(homepageobjects.message_textarea.isDisplayed());
            ExtentTestManager.getTest().log(LogStatus.PASS, "" + " \"Message Text Area\" is displayed");
        }
        catch (Throwable e)
        {
            Assert.fail("Expected :: \"Message Text Area \" should be displayed ; Actual :: \"Message Text Area\" is not displayed"+"&"+e.getMessage()+"");
        }
    }

    /**
     * Verify Post Upload File Icon
     * Author:- Gandahrva
     */
    public void verifyDisplayOfAttachIcon(String... strings)
    {
        try
        {
            genericfunctions.waitForPageToLoad(postwithhashtagobjects.upload_file);
            Assert.assertTrue(postwithhashtagobjects.upload_file.isDisplayed());
            ExtentTestManager.getTest().log(LogStatus.PASS, "" + "  \"Attach file Icon\" is displayed");
        }
        catch (Throwable e)
        {
            Assert.fail("Expected :: \"Attach file Icon \" should be displayed ; " +
                    "Actual :: \"Attach file Icon\" is not displayed"+"&"+e.getMessage()+"");
        }
    }

    /**
     * Verify Post NSFW_Restricted_Content_Check_Box_Is_Displayed
     * Author:- Gandahrva
     */
    public void verifyDisplayOfNSFWToggle(String... strings)
    {
        try
        {
            genericfunctions.waitForPageToLoad(postwithhashtagobjects.post_form_nsfw_check_box);
            Assert.assertTrue(postwithhashtagobjects.post_form_nsfw_check_box.isDisplayed());
            ExtentTestManager.getTest().log(LogStatus.PASS, "" + "  \"NSFW_Restricted_Content Toggle Icon\" is displayed");
        }
        catch (Throwable e)
        {
            Assert.fail("Expected :: \"NSFW_Restricted_Content Toggle Icon \" should be displayed ; " +
                    "Actual :: \"NSFW_Restricted_Content Toggle Icon\" is not displayed"+"&"+e.getMessage()+"");
        }
    }
    /**
     * Verify Audio File
     * Author:- Gandahrva
     */
    public void verifyDisplayOfAudioPost(String... strings)
    {
        ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " :: Created Audio Post");
        genericfunctions.waitWebDriver(1000);
        try
        {
            genericfunctions.waitTillTheElementIsVisible(postwithhashtagobjects.audio_post.get(0));
            Assert.assertTrue(postwithhashtagobjects.audio_post.get(0).isDisplayed());
            ExtentTestManager.getTest().log(LogStatus.PASS, ""+ " \"Posted Audio\" is displayed");
        }
        catch (Throwable e)
        {
            Assert.fail("Expected :: \"Posted Audio \" should be displayed ; Actual ::\"Posted Audio\" is not displayed"+"&"+e.getMessage()+"");
        }
    }

    /**
     * Verify Video File
     * Author:- Gandahrva
     */
    public void verifyDisplayOfCreatedVideoPost(String... strings)
    {
        ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " :: Created Video Post");
        genericfunctions.waitWebDriver(1000);
        try
        {
            genericfunctions.waitTillTheElementIsVisible(postwithhashtagobjects.video_post.get(0));
            Assert.assertTrue(postwithhashtagobjects.video_post.get(0).isDisplayed());
            ExtentTestManager.getTest().log(LogStatus.PASS, ""+ " \"Posted Video\" is displayed");
        }
        catch (Throwable e)
        {
            Assert.fail("Expected :: \"Posted Video \" should be displayed ; Actual ::\"Posted Video\" is not displayed"+"&"+e.getMessage()+"");
        }
    }


    /**
     * Verify HashTag's
     * Author:- Gandharva
     */
    public void verifyDisplayOfHashTagList(String ...strings)
    {
        String[] expectedHashTags=strings[0].split("\\,");
        List<WebElement> tags=null;
        String currentExpectedHashTag = null;
        String currentActualHashTag = null;

        ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[1]  + " :: HashTags dropdown List are displayed or not with following assertions: ");

        try
        {
            ExtentTestManager.getTest().log(LogStatus.INFO, " " + "<b>"+" HashTags dropdown List are :- "+"</b>");
            genericfunctions.waitTillTheElementIsVisible(postwithhashtagobjects.hashtags_list_options.get(0));
            Assert.assertTrue(postwithhashtagobjects.hashtags_list_options.get(0).isDisplayed());
        }
        catch (Throwable e)
        {
            Assert.fail("Could not find \"HashTags dropdown List\"" + "&" + e.getMessage() + "");
        }

        try
        {
            tags =postwithhashtagobjects.hashtags_list_options;
        }
        catch(Throwable e)
        {
            Assert.fail("Could not find \"HashTags List\"" + "&" + e.getMessage() + "");
        }
        try
        {

            for (int i = 0; i < tags.size(); i++)
            {
                currentExpectedHashTag = expectedHashTags[i];
                currentActualHashTag = tags.get(i).getAttribute("id");

                genericfunctions.waitTillTheElementIsVisible(postwithhashtagobjects.hashtags_list_options.get(i));
                Assert.assertTrue(postwithhashtagobjects.hashtags_list_options.get(i).isDisplayed());
                ExtentTestManager.getTest().log(LogStatus.PASS, " " + " "+ " " + "<b>" + postwithhashtagobjects.hashtags_list_options.get(i).getText() + "</b>");

            }

            ExtentTestManager.getTest().log(LogStatus.PASS, "HashTag list are displayed");
        }
        catch (Throwable e)
        {
            Assert.fail("Expected :: " + currentExpectedHashTag + " HashTags should be displayed  ; Actual ::" + currentActualHashTag + " HashTags are not displayed"+"&"+e.getMessage()+"");
        }

    }

    /**
     * Verify Pay Per Post
     * Author:- Gandahrva
     */
    public void verifyDisplayOfPayPerPost(String... strings)
    {
        try
        {
            genericfunctions.waitTillTheElementIsVisible(postwithhashtagobjects.post_form_set_paywall_icon);
            Assert.assertTrue(postwithhashtagobjects.post_form_set_paywall_icon.isDisplayed());
            ExtentTestManager.getTest().log(LogStatus.PASS, "" + "  \"Pay Per Post Content Icon\" is displayed");
        } catch (Throwable e)
        {
            Assert.fail("Expected :: \"Pay Per Post Content Icon \" should be displayed ;" +
                    " Actual :: \"Pay Per Post Content Icon\" is not displayed"+"&"+e.getMessage()+"");
        }
    }

    /**
     * Verify Post Button
     * Author:- Gandahrva
     */
    public void verifyDisplayOfPostButton(String... strings)
    {
        try
        {
            genericfunctions.waitTillTheElementIsVisible(homepageobjects.post_button);
            Assert.assertTrue(homepageobjects.post_button.isDisplayed());
            ExtentTestManager.getTest().log(LogStatus.PASS, "" + "  \"Post Button\" is displayed");
        } catch (Throwable e)
        {
            Assert.fail("Expected :: \"Post Button \" should be displayed ;" +
                    " Actual :: \"Post Button\" is not displayed"+"&"+e.getMessage()+"");
        }
    }

    /**
     * Verify NSFW_Restricted_Content_Is_Enabeld
     * Author:- Gandharva
     */
    public void verifyRestrictedContentToggleIsEnabled(String... strings)
    {
        ExtentTestManager.getTest().log(LogStatus.INFO, "" +strings[0]+ "::  Restricted Content Toggle Button is Enabled or Not with following assertion :");
        try
        {
            genericfunctions.waitForPageToLoad(postwithhashtagobjects.post_form_nsfw_check_box);
            Assert.assertTrue(postwithhashtagobjects.post_form_nsfw_check_box.isEnabled());
            ExtentTestManager.getTest().log(LogStatus.PASS, "" + "  \"Restricted Content Toggle Button\" is Enabled");
        }
        catch (Throwable e)
        {
            Assert.fail("Expected :: \"Restricted_Content Toggle Button \" should be Enabled ; " +
                    "Actual :: \"Restricted_Content Toggle Button\" is not Enabled"+"&"+e.getMessage()+"");
        }
    }

    /**
     * Verify on Cover Button to  Restrict the post
     * Author:- Gandharva
     * Date:- 27-05-2020
     * */
    public void verifyDisplayOfUnCoverButtonOnFeed(String... strings)
    {
        ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + ":: \"UnCover Button\" is displayed or not ");
        try
        {
            genericfunctions.waitForPageToLoad(postwithhashtagobjects.activity_uncover_button.get(0));
            Assert.assertTrue(postwithhashtagobjects.activity_uncover_button.get(0).isDisplayed());
            ExtentTestManager.getTest().log(LogStatus.PASS, " UnCover Button is Displayed");
        }
        catch (Throwable e)
        {
            Assert.fail("Could not perform action on \"UnCover Button\""+"&"+e.getMessage()+"" );
        }
    }

    /**
     * Verify On Cover Button to  Restrict the post
     * Author:- Gandharva
     * Date:- 27-05-2020
     * */
    public void verifyDisplayOfCoverButtonOnFeed(String... strings)
    {
        ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + ":: Cover Button is displayed or not ");
        try
        {
            genericfunctions.waitForPageToLoad(postwithhashtagobjects.activity_cover_button.get(0));
            Assert.assertTrue(postwithhashtagobjects.activity_cover_button.get(0).isDisplayed());
            ExtentTestManager.getTest().log(LogStatus.PASS, " \"Cover Button\" is Displayed");
        }
        catch (Throwable e)
        {
            Assert.fail("Could not perform action on \"Cover Button\""+"&"+e.getMessage()+"" );
        }
    }

    /**
     * Verify Restricted_Covered_Content_Post
     * Author:- Gandharva
     */
    public void verifyDisplayOfRestrictedContentCoveredPost(String... strings)
    {
        ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " ::  Created Restricted Content is Covered or not");
        try
        {
            genericfunctions.waitTillTheElementIsVisible(postwithhashtagobjects.nsfw_media_post_blanket.get(0));
            Assert.assertTrue(postwithhashtagobjects.nsfw_media_post_blanket.get(0).isDisplayed());
            ExtentTestManager.getTest().log(LogStatus.PASS, ""+ " \"Restricted Content\" is Covered");
        }
        catch (Throwable e)
        {
            Assert.fail("Expected :: \"Restricted Content  \" should be Displayed ; Actual ::\"Restricted Content \" is not Displayed"+"&"+e.getMessage()+"");
        }
    }


    /**
     * Verify Restricted_UnCovered_Content_Post
     * Author:- Gandharva
     */
    public void verifyDisplayOfRestrictedContentUnCoveredPost(String... strings)
    {
        ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " ::  Created Restricted Content is UnCovered or not");
        try
        {
            genericfunctions.waitForPageToLoad(postwithhashtagobjects.nsfw_media_post_blanket_shown.get(0));
            Assert.assertTrue(postwithhashtagobjects.nsfw_media_post_blanket_shown.get(0).isDisplayed());
            ExtentTestManager.getTest().log(LogStatus.PASS, ""+ " \"Restricted Content \" is UnCovered");
        }
        catch (Throwable e)
        {
            Assert.fail("Expected :: \"Restricted Content  \" should be Displayed ; Actual ::\"Restricted Content \" is not Displayed"+"&"+e.getMessage()+"");
        }
    }

    /**
     * Verify Paywall Contents
     * Author:- Gandharva
     */
    public void verifySetPaywllContents(String... strings)
    {
        ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " :: Paywall Contents with following assertion");
        verifySetCoinsField(strings[0]);
        verifySetDescriptionField(strings[0]);
    }

    /**
     * Verify Set Coin Filed
     * Author:- Gandharva
     */
    public void verifySetCoinsField(String... strings)
    {
        ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " ::  Set Coins Field is displayed or not");
        try
        {
            genericfunctions.waitTillTheElementIsVisible(postwithhashtagobjects.post_set_coins);
            Assert.assertTrue(postwithhashtagobjects.post_coins_message.isDisplayed());
            ExtentTestManager.getTest().log(LogStatus.PASS, ""+ " \"Set Coins Field\" is displayed");
        }
        catch (Throwable e)
        {
            Assert.fail("Expected :: \"Set Coins Field \" should be displayed ; " +
                    "Actual ::\"Set Coins Field\" is not displayed"+"&"+e.getMessage()+"");
        }
    }

    /**
     * Verify Set Description Filed
     * Author:- Gandharva
     */
    public void verifySetDescriptionField(String... strings)
    {
        ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " ::  Description Field is displayed or not");
        try
        {
            genericfunctions.waitTillTheElementIsVisible(postwithhashtagobjects.post_coins_message);
            Assert.assertTrue(postwithhashtagobjects.post_coins_message.isDisplayed());
            ExtentTestManager.getTest().log(LogStatus.PASS, ""+ " \"Description Field\" is displayed");
        }
        catch (Throwable e)
        {
            Assert.fail("Expected :: \"Description Field \" should be displayed ; " +
                    "Actual ::\"Description Field\" is not displayed"+"&"+e.getMessage()+"");
        }
    }
    /**
     * Verify Add Button
     * Author:- Gandharva
     */
    public void verifyDisplayOfAddButton(String... strings)
    {
        ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " :: Add Button is displayed & enabled or not with following assertion : ");
        try
        {
            genericfunctions.waitForPageToLoad(postwithhashtagobjects.post_coins_add_button);
            Assert.assertTrue(postwithhashtagobjects.post_coins_add_button.isEnabled());
            ExtentTestManager.getTest().log(LogStatus.PASS, ""+ " \"Add Button\" is Enabled");
        }
        catch (Throwable e)
        {
            Assert.fail("Expected :: \"Add Button \" should be Enabled ; " +
                    "Actual ::\"Add Button\" is not Enabled"+"&"+e.getMessage()+"");
        }
    }

    /**
     * Verify Header Paywall
     * Author:- Gandharva
     */
    public void verifyHeaderPaywall(String... strings)
    {
        ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " ::  Paywall Header is displayed or not");
        try
        {
            genericfunctions.waitForPageToLoad(postwithhashtagobjects.paywall_header.get(0));
            Assert.assertTrue(postwithhashtagobjects.paywall_header.get(0).isDisplayed());
            ExtentTestManager.getTest().log(LogStatus.PASS, ""+ " \"Paywall Header\" is displayed");
        }
        catch (Throwable e)
        {
            Assert.fail("Expected :: \"Paywall Header \" should be displayed ; " +
                    "Actual ::\"Paywall Header\" is not displayed" + "&"+e.getMessage()+"");
        }
    }
    public String payperpostValue()
    {
        String actualPaywallValue=postwithhashtagobjects.paywall_header.get(0).getText();
        String actualPaywallHeaderValue = actualPaywallValue.replaceAll("[^0-9^.]", "");
        return actualPaywallHeaderValue ;
    }

    /**
     * Verify Header Paywall_Value
     * Author:- Gandharva
     */
    public void verifyDisplayOfHeaderPaywallValue(String... strings)
    {
        String exceptedPaywallHeaderValue=strings[1];
        String actualPaywallHeaderValue= strings[2];
        ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " ::  Paywall Header Value is displayed or not");

        System.out.println("actual coins:"+actualPaywallHeaderValue);

        try
        {
            genericfunctions.waitForPageToLoad(postwithhashtagobjects.paywall_header.get(0));
            Assert.assertTrue(actualPaywallHeaderValue.equals(exceptedPaywallHeaderValue));
            ExtentTestManager.getTest().log(LogStatus.PASS, "Expected :: \"Paywall Header Value\" should be displayed as "
                    + ":: " + "<b>"  + exceptedPaywallHeaderValue + "</b>" + "coins " + " " +
                    "; Actual :: \"Paywall Header Value\" is displayed as " + ":: " + "<b>" +actualPaywallHeaderValue+ "</b>" + "coins " + "");
        }
        catch (Throwable e)
        {
            Assert.fail(" " + "&"+e.getMessage()+"");
        }
    }
    /**
     * Verify Header Paywall UnLock Button
     * Author:- Gandharva
     */
    public void verifyDisplayOfPaywallUnlockButton(String... strings)
    {
        ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " ::  Paywall Unlock This Post Button is displayed or not");
        try
        {
            genericfunctions.waitForPageToLoad(postwithhashtagobjects.paywall_unlock_button.get(0));
            Assert.assertTrue(postwithhashtagobjects.paywall_unlock_button.get(0).isDisplayed());
            ExtentTestManager.getTest().log(LogStatus.PASS, ""+ " Paywall \"Unlock This Post\" Button is displayed");
        }
        catch (Throwable e)
        {
            Assert.fail("Expected :: Paywall \"Unlock This Post \" Button should be displayed ; " +
                    "Actual :: Paywall \"Unlock This Post \" Button is not displayed" + "&"+e.getMessage()+"");
        }
    }

    /**
     * Verify Paywall Window
     * Author:- Gandharva
     */
    public void verifyDisplayOfPaywallWindow(String... strings)
    {
        ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " :: Paywall Window is displayed or not To view Pay Per Post");
        try
        {
            genericfunctions.waitForPageToLoad(postwithhashtagobjects.paywall_contribute_window);
            Assert.assertTrue(postwithhashtagobjects.paywall_contribute_window.isDisplayed());
            ExtentTestManager.getTest().log(LogStatus.PASS, ""+ " \"Paywall Window\" is displayed");
        }
        catch (Throwable e)
        {
            Assert.fail("Paywall Window has not displayed and You have already subscribed to the User Posts for a Month" + "&"+e.getMessage()+"");
        }
    }

    /**
     * Verify Paywall Window Header Message
     * Author:- Gandharva
     */
    public void verifyDisplayOfPaywallWindowHeader(String... strings)
    {
        ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " :: Paywall Window Header Message is displayed or not");
        try
        {
            genericfunctions.waitForPageToLoad(postwithhashtagobjects.creator_paywall_pay_per_post);
            Assert.assertTrue(postwithhashtagobjects.creator_paywall_pay_per_post.isDisplayed());
            ExtentTestManager.getTest().log(LogStatus.PASS, ""+ " \"Paywall Window Header\" is displayed");
        }
        catch (Throwable e)
        {
            Assert.fail("Paywall Window Header Message has not displayed" + "&"+e.getMessage()+"");
        }
    }

    /**
     * Verify Paywall Window UnLock Button Enabled
     * Author:- Gandharva
     */
    public void verifyUnlockThisPostButtonIsEnabled(String... strings)
    {
        ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " :: Unlock This Post Button is Enabled or not on Paywall Window To Unlock the Post");
        try
        {
            genericfunctions.waitForPageToLoad(postwithhashtagobjects.creator_paywall_submit_button);
            Assert.assertTrue(postwithhashtagobjects.creator_paywall_submit_button.isEnabled());
            ExtentTestManager.getTest().log(LogStatus.PASS, "  \"Unlock This Post Button\" is Enabled on Paywall Window");
        }
        catch (Throwable e)
        {
            Assert.fail("Insufficient Balance on Your Wallet" + "&"+e.getMessage()+"");
        }
    }

    /**
     * Verify verifyPayPerPostConfirmationMessage
     * Author:- Gandharva
     */
    public void verifyPayPerPostConfirmationMessage(String... strings)
    {
        String exceptedConfirmationMessage = strings[1];
        String coins = strings[2];
        String actualConfirmationMessage = null;
        ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " :: PayPerPost Confirmation Message is displayed or not after Paying " +" \"<b>" + coins +"\"   </b>" + " Coins");
        try
        {
            genericfunctions.waitForPageToLoad(postwithhashtagobjects.lock_screen_transaction_made_notice);
            Assert.assertTrue(postwithhashtagobjects.lock_screen_transaction_made_notice.get(0).isDisplayed());
            ExtentTestManager.getTest().log(LogStatus.PASS, "  \"PayPerPost Confirmation Message \" is displayed after Paying");
        }
        catch (Throwable e)
        {
            Assert.fail("PayPerPost Confirmation Message is not displayed" + "&"+e.getMessage()+"");
        }

        try
        {
            actualConfirmationMessage = postwithhashtagobjects.lock_screen_transaction_made_notice.get(0).getText();
            Assert.assertTrue(actualConfirmationMessage.equals(exceptedConfirmationMessage));
            ExtentTestManager.getTest().log(LogStatus.PASS, "  PayPerPost Confirmation Message is displayed as :: "+ " \"<b>" + actualConfirmationMessage +"\" </b>"+"");

        }
        catch ( Throwable e)
        {
            Assert.fail("Expected :: PayPerPost Confirmation Message is displayed as  <b>\"" + exceptedConfirmationMessage+ "\"</b> ;" +
                    " Actual :: PayPerPost Confirmation Message is displayed as <b>\"" + actualConfirmationMessage + "\"</b> " );
        }
    }


    /**
     * Verify_Edited Post
     * Author:- Gandahrva
     * Date:- 28-05-2020
     */
    public void verifyDisplayOfEditedPost(String... strings)
    {
        ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " :: Edited Post is displayed or not");
        String expectedTextPost = strings[1].trim();
        String actualTextPost = null;
        genericfunctions.waitWebDriver(2000);

        try
        {
            genericfunctions.waitForPageToLoad(homepageobjects.activity_text.get(0));
            actualTextPost=homepageobjects.activity_text.get(0).getText().trim();

            genericfunctions.waitTillTheElementIsVisible(homepageobjects.activity_text.get(0));
            Assert.assertTrue(actualTextPost.equals(expectedTextPost));
            ExtentTestManager.getTest().log(LogStatus.PASS,  " Expected :: \"Edited Text Post\" should be displayed as :: "
                    + "\"<b>" + expectedTextPost +"\"   </b>"  + " ;" +
                    " Actual :: \"Edited Text Post \" is displayed as :: "    + "\"<b>" + actualTextPost +"\"   </b>"   +" ");
        }
        catch(Throwable e)
        {
            String actualException=e.getClass().getName();
            switch (actualException)
            {
                case "java.lang.NoSuchElementException":
                    Assert.fail(actualException +"Expected :: \"Edited Post \" should be displayed ; Actual :: \"Edited Post \" is not displayed" + "&" + e.getMessage() + "");
                    break;
                case "java.lang.AssertionError":
                    Assert.fail(actualException + " " + " Expected :: \"Edited Text Post\" should be displayed as :: "
                            + "<b>" + expectedTextPost  + "</b>"  + " ;" +
                            " Actual :: \"Edited Text Post \" is displayed as :: "  +  "<b>" + actualTextPost +  "</b>"  + "&" + e.getMessage() + "");
                    break;
                default:
                    Assert.fail(actualException + "&" + e.getMessage() + "");
            }
        }
    }

    /**
     * Verify_Deleted Text Post
     * Author:- Gandharva
     */
    public void verifyDisplayOfDeletedPost(String... strings)
    {
        ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " ::  Post is deleted or not on timeline with following assertion :");
        String expectedTextPost = strings[1].trim();
        genericfunctions.waitWebDriver(2000);

        try
        {
            for (WebElement webElement : homepageobjects.activity_text)
            {

                if (expectedTextPost.equals(webElement.getText()))
                {
                    Assert.assertFalse(webElement.isDisplayed());
                }
            }
            ExtentTestManager.getTest().log(LogStatus.PASS, " \" Post \" is deleted");


        }
        catch (Throwable e)
        {
            Assert.fail("Expected :: \"Post\" should be deleted ; Actual :: \"Post \" is not deleted" + "&" + e.getMessage() + "");
        }
    }

    /**
     * Verify_Uploaded_Thumbnail_Of_ShowTimez
     * Author:- Gandharva
     */
    public void verifyDisplayOfUploadedShowtimezThumbnail(String... strings)
    {

        ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " ::  Media Thumbnail is Uploaded or not");

        try
        {
            genericfunctions.waitWebDriver(2000);
            genericfunctions.waitTillTheElementIsVisible(postwithhashtagobjects.showtimez_thumbnail);
            Assert.assertTrue(postwithhashtagobjects.showtimez_thumbnail.isDisplayed());
            ExtentTestManager.getTest().log(LogStatus.PASS, " \"Media Thumbnail\" is displayed");
        }
        catch (Throwable e)
        {
            Assert.fail("Could not found \"Media Thumbnail\" " + "&" + e.getMessage() + "");
        }
    }



    /**
     * Verify_Uploaded_Thumbnail_On_BlueStores
     * Author:- Gandharva
     */
    public void verifyDisplayOfUploadedBlueStoreThumbnail(String... strings)
    {
        genericfunctions.waitWebDriver(2000);
        ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " ::  Media Thumbnail has Uploaded or not");

        try
        {
            genericfunctions.waitTillTheElementIsVisible(postwithhashtagobjects.bluestore_thumbnail);
            Assert.assertTrue(postwithhashtagobjects.bluestore_thumbnail.isDisplayed());
            ExtentTestManager.getTest().log(LogStatus.PASS, " \"Media Thumbnail\" has displayed");
        }
        catch (Throwable e)
        {
            Assert.fail("Could not found \"Media Thumbnail\" " + "&" + e.getMessage() + "");
        }
    }

    /**
     * Verify_BlueStore  Post
     * Author:- Gandharva
     */
    public void verifyDisplayOfCreatedBluestorePostOnFeed(String... strings)
    {
        ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " ::  Created BlueStore Post is Displayed or Not on Feed");
        String expectedStoreTitle = strings[1].trim();
        String actualStoreTitle = null;
        genericfunctions.waitWebDriver(2000);

        try
        {
            genericfunctions.waitForPageToLoad(postwithhashtagobjects.activity_bluestore_title.get(0));
            actualStoreTitle=postwithhashtagobjects.activity_bluestore_title.get(0).getText().trim();
            genericfunctions.waitTillTheElementIsVisible(postwithhashtagobjects.activity_bluestore_title.get(0));
            Assert.assertTrue(actualStoreTitle.equals(expectedStoreTitle));
            ExtentTestManager.getTest().log(LogStatus.PASS, " Expected :: \" BlueStore Post\" should be displayed as "
                    + ":: \"<b>" + expectedStoreTitle +"\"   </b> ; Actual :: \" BlueStore  Post\" is displayed as" + ":: \"<b>" + actualStoreTitle +"\"   </b>");
        }
        catch(Throwable e)
        {
            String actualException=e.getClass().getName();

            switch (actualException)
            {
                case "java.lang.NoSuchElementException":
                    Assert.fail(actualException +"Expected :: \" BlueStore Post \" should be displayed ; Actual :: \"  BlueStore Post \" is not displayed" + "&" + e.getMessage() + "");
                    break;
                case "java.lang.AssertionError":
                    Assert.fail(actualException + " " + " Expected :: \" BlueStore Post\" should be displayed as :: "
                            + "<b>" + expectedStoreTitle  + "</b>"  + " ;" +
                            " Actual :: \" BlueStore Post\" is displayed as :: "  +  "<b>" + actualStoreTitle +  "</b>"  + "&" + e.getMessage() + "");
                    break;
                default:
                    Assert.fail("Expected :: \" BlueStore Post \" should be displayed ; Actual :: \" BlueStore Post \" is not displayed" + "&" + e.getMessage() + "");
            }
        }
    }

    /**
     * Verify RePost PopUp
     * Author:- Gandharva
     */
    public void verifyDisplayOfRepostPopUp(String... strings)
    {
        ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " ::  Repost PopUp is Displayed or Not");

        try
        {
            genericfunctions.waitForPageToLoad(postwithhashtagobjects.repost_popup);
            Assert.assertTrue(postwithhashtagobjects.repost_popup.isDisplayed());
            ExtentTestManager.getTest().log(LogStatus.PASS,  "  \"Repost PopUp \" is Displayed ");
        }
        catch(Throwable e)
        {
            Assert.fail("Expected :: \"Repost PopUp \" should be displayed ; Actual :: \"Repost PopUp \" is not displayed"+"&"+e.getMessage()+"");
        }
    }

    /**
     * Verify_Uploaded_Thumbnail_On_MyJourney
     * Author:- Gandharva
     */
    public void verifyDisplayOfMyJourneyThumbnail(String... strings)
    {
        genericfunctions.waitWebDriver(2000);
        ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " ::  Elements has Uploaded or not");

        try
        {
            genericfunctions.waitTillTheElementIsVisible(postwithhashtagobjects.myjourney_thumbnail);
            Assert.assertTrue(postwithhashtagobjects.myjourney_thumbnail.isDisplayed());
            ExtentTestManager.getTest().log(LogStatus.PASS, " \"Media Thumbnail\" has displayed");
        }
        catch (Throwable e)
        {
            Assert.fail("Could not found \"Media Thumbnail\" " + "&" + e.getMessage() + "");
        }
    }

    /**
     * Verify MyJourney Post
     * Author:- Gandharva
     */
    public void verifyDisplayOfMyJourneyPostOnFeed(String... strings)
    {
        String exceptedtext= strings[1];
        String actualText = null;

        ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " ::  MyJourney Post is Displayed or Not on  TimeLine");
        genericfunctions.waitWebDriver(2000);
        try
        {
            genericfunctions.waitForPageToLoad(postwithhashtagobjects.video_post.get(0));
            Assert.assertTrue(postwithhashtagobjects.video_post.get(0).isDisplayed());
            ExtentTestManager.getTest().log(LogStatus.PASS,  "  \"MyJourney Post \" is Displayed on TimeLine");
        }
        catch(Throwable e)
        {
            Assert.fail("Expected :: \"MyJourney Post \" should be displayed on  TimeLine;" +
                    " Actual :: \"MyJourney Post \" is not displayed on  TimeLine"+"&"+e.getMessage()+"");
        }

        try
        {
            genericfunctions.waitTillTheElementIsVisible(homepageobjects.activity_text.get(0));
            actualText = homepageobjects.activity_text.get(0).getText();
            Assert.assertTrue(actualText.equals(exceptedtext));

            ExtentTestManager.getTest().log(LogStatus.PASS, " Expected :: \" MyJourney Post\" should be displayed as "
                    + ":: \"<b>" + exceptedtext +"\"   </b> ; Actual :: \" MyJourney  Post\" is displayed as" + ":: \"<b>" + actualText +"\"   </b>");

        }

        catch(Throwable e)
        {
            String actualException=e.getClass().getName();

            switch (actualException)
            {
                case "java.lang.NoSuchElementException":
                    Assert.fail(actualException +"Expected :: \"MyJourney Post Text Content \" should be displayed ; Actual :: \"MyJourney Post Text Content \" is not displayed" + "&" + e.getMessage() + "");
                    break;
                case "java.lang.AssertionError":
                    Assert.fail(actualException + " " + " Expected :: \" MyJourney Post\" should be displayed as "
                            + ":: \"<b>" + exceptedtext +"\"   </b> ; Actual :: \" MyJourney  Post\" is displayed as" + ":: \"<b>" + actualText +"\"   </b>" + "&" + e.getMessage() + "");
                    break;
                default:
                    Assert.fail(actualException + "&"  + e.getMessage() + "");
            }
        }
    }




    /**
     * Verify MyJourney Post Header
     * Author:- Gandharva
     */
    public void verifyDisplayOfMyJourneyPostHeaderOnFeed(String... strings)
    {
        ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " ::  MyJourney Post Header is Displayed or Not on TimeLine");

        try
        {
            genericfunctions.waitForPageToLoad(postwithhashtagobjects.myjourney_header.get(0));
            Assert.assertTrue(postwithhashtagobjects.myjourney_header.get(0).isDisplayed());
            ExtentTestManager.getTest().log(LogStatus.PASS,  "  \"MyJourney Header \" is Displayed on TimeLine");
        }
        catch(Throwable e)
        {
            String actualException = e.getClass().getName();

            switch (actualException) {
                case "java.lang.NoSuchElementException":
                    Assert.fail("Expected :: \"MyJourney Header \" should be displayed on TimeLine;" +
                            " Actual :: \"MyJourney Header \" is not displayed on TimeLine" + "&" + e.getMessage() + "");
                    break;
                case "java.lang.AssertionError":
                    Assert.fail("error message  is  displaying " + "&" + e.getMessage() + "");
                    break;
                default:
                    Assert.fail(""+ "&" + e.getMessage() + "");
            }
        }
    }

    /**
     * Verify MyJourney Post on Widget
     * Author:- Gandharva
     */
    public void verifyDisplayOfMyJouneyPostOnWidget(String... strings)
    {
        ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " ::  MyJourney Post is Displayed or Not On Widget ");
        genericfunctions.waitWebDriver(2000);
        try
        {
            genericfunctions.waitForPageToLoad(postwithhashtagobjects.myjourney_widget_myjourney_post.get(1));
            Assert.assertTrue(postwithhashtagobjects.myjourney_widget_myjourney_post.get(1).isDisplayed());
            ExtentTestManager.getTest().log(LogStatus.PASS,  "  \"MyJourney Post \" is Displayed on Widget");
        }
        catch(Throwable e)
        {
            Assert.fail("Expected :: \"MyJourney Post \" should be displayed on Widget;" +
                    " Actual :: \"MyJourney Post \" is not displayed on Widget"+"&"+e.getMessage()+"");
        }
    }

    /**
     * Verify MyJourney Post
     * Author:- Gandharva
     */
    public void verifyDisplayOfMyJourneyEditedPostOnFeed(String... strings)
    {
        String exceptedtext= strings[1];
        String actualText = null;
        ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " ::  MyJourney Edited Post is Displayed or Not on TimeLine");

        try
        {
            genericfunctions.waitTillTheElementIsVisible(homepageobjects.activity_text.get(0));
            actualText = homepageobjects.activity_text.get(0).getText();
            Assert.assertTrue(actualText.equals(exceptedtext));

            ExtentTestManager.getTest().log(LogStatus.PASS, " Expected :: \" MyJourney Edited Post Text Content\" should be displayed as "
                    + ":: \"<b>" + exceptedtext +"\"   </b> ; Actual :: \" MyJourney Edited Post Text Content\" is displayed as" + ":: \"<b>" + actualText +"\"   </b>" +"");
        }

        catch(Throwable e)
        {
            String actualException = e.getClass().getName();

            switch (actualException) {
                case "java.lang.NoSuchElementException":
                    Assert.fail("Expected :: \"MyJourney Edited Post Text Content \" should be displayed on TimeLine;" +
                            " Actual :: \"MyJourney Edited Post Text Content \" is not displayed on TimeLine" + "&" + e.getMessage() + "");
                    break;
                case "java.lang.AssertionError":
                    Assert.fail(actualException + " " + " Expected :: \" MyJourney Edited Post Text Content\" should be displayed as "
                            + ":: \"<b>" + exceptedtext +"\"   </b> ; Actual :: \" MyJourney Edited Post Text Content\" is displayed as" + ":: \"<b>" + actualText +"\"   </b>" + "&" + e.getMessage() + "" + "&" + e.getMessage() + "");
                    break;
                default:
                    Assert.fail(actualException + "&" + e.getMessage() + "");
            }
        }
    }

    /**
     * Verify_Showtimez Post
     * Author:- Gandharva
     */
    public void verifyDisplayOfEditShowTimezPopUp(String... strings)
    {
        ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " ::  Showtimez PopUp is Displayed or Not");


        try
        {
            genericfunctions.waitForPageToLoad(postwithhashtagobjects.showtimez_edit_popup);
            Assert.assertTrue(postwithhashtagobjects.showtimez_edit_popup.isDisplayed());
            ExtentTestManager.getTest().log(LogStatus.PASS, " \"Showtimez PopUp\" is displayed");

        }
        catch(Exception e)
        {
            Assert.fail("Expected :: \" Showtimez PopUp \" should be displayed ; Actual :: \"Showtimez PopUp \" is not displayed"+"&"+e.getMessage()+"");
        }
    }

    /**
     * Verify_Showtimez Post_TiTle
     * Author:- Gandharva
     */
    public void verifyDisplayOfCreatedShowTimezPostTitleOnFeed(String... strings)
    {
        ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " ::  Created ShowTimez Post Title is Displayed or Not on  NewsFeed");
        String expectedShowTitle = strings[1].trim();
        String actualShowTitle = null;
        genericfunctions.waitWebDriver(2000);

        try
        {
            genericfunctions.waitForPageToLoad(postwithhashtagobjects.showtimez_event_title.get(0));
            actualShowTitle=postwithhashtagobjects.showtimez_event_title.get(0).getText().trim();
            genericfunctions.waitTillTheElementIsVisible(postwithhashtagobjects.showtimez_event_title.get(0));
            Assert.assertTrue(actualShowTitle.equals(expectedShowTitle));
            ExtentTestManager.getTest().log(LogStatus.PASS, " Expected :: \" ShowTimez Post Title\" should be displayed as "
                    + ":: \"<b>" + expectedShowTitle +"\"   </b> ; Actual :: \"  ShowTimez Post Title \" is displayed as" + ":: \"<b>" + actualShowTitle +"\"   </b>" +"");
        }

        catch(Throwable e)
        {
            String actualException=e.getClass().getName();

            switch (actualException)
            {
                case "java.lang.NoSuchElementException":
                    Assert.fail("Expected :: \"Created ShowTimez Post Title \" should be displayed ; " +
                            "Actual :: \"Created ShowTimez Post Title \" is not displayed"+"&"+e.getMessage()+"");
                    break;
                case "java.lang.AssertionError":
                    Assert.fail(actualException + " Expected :: \" ShowTimez Post Title\" should be displayed as "
                            + ":: \"<b>" + expectedShowTitle +"\"   </b> ; Actual :: \"  ShowTimez Post Title \" is displayed as" + ":: \"<b>" + actualShowTitle +"\" </b>" +"&"+e.getMessage()+"");
                    break;
                default:
                    Assert.fail(actualException + "&"  + e.getMessage()+ "");
            }
        }
    }

    /**
     * Verify_Showtimez Post_TiTle
     * Author:- Gandharva
     */
    public void verifyDisplayOfEditedShowTimezPostTitleOnFeed(String... strings)
    {
        ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " ::  Edited ShowTimez Post Title is Displayed or Not on NewsFeed");
        String expectedShowTitle = strings[1].trim();
        String actualShowTitle = null;
        genericfunctions.waitWebDriver(2000);

        try
        {
            genericfunctions.waitForPageToLoad(postwithhashtagobjects.showtimez_event_title.get(0));
            actualShowTitle=postwithhashtagobjects.showtimez_event_title.get(0).getText().trim();
            genericfunctions.waitTillTheElementIsVisible(postwithhashtagobjects.showtimez_event_title.get(0));
            Assert.assertTrue(actualShowTitle.equals(expectedShowTitle));
            ExtentTestManager.getTest().log(LogStatus.PASS, " Expected :: \"Edited ShowTimez Post Title\" should be displayed as "
                    + ":: \"<b>" + expectedShowTitle +"\"   </b> ; Actual :: \" Edited ShowTimez Post Title \" is displayed as" + ":: \"<b>" + actualShowTitle +"\"   </b>");
        }

        catch(Throwable e)
        {
            String actualException=e.getClass().getName();

            switch (actualException)
            {
                case "java.lang.NoSuchElementException":
                    Assert.fail("Expected :: \"Edited ShowTimez Post Title \" should be displayed ; " +
                            "Actual :: \"Edited ShowTimez Post Title \" is not displayed"+"&"+e.getMessage()+"");
                    break;
                case "java.lang.AssertionError":
                    Assert.fail(actualException+" Expected :: \"Edited ShowTimez Post Title\" should be displayed as "
                            + ":: \"<b>" + expectedShowTitle +"\" </b> ; Actual :: \" Edited ShowTimez Post Title \" is displayed as" + ":: \"<b>" + actualShowTitle +"\" </b>" +"&"+e.getMessage()+"");
                    break;
                default:
                    Assert.fail(actualException + "&"  + e.getMessage()+ "");
            }
        }
    }

    /**
     * Verify_Showtimez Post Card
     * Author:- Gandharva
     */
    public void verifyDisplayOfCreatedShowTimezPostCardOnFeed(String... strings)
    {
        ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " ::  ShowTimez Post Card is Displayed or Not on Feed");

        genericfunctions.waitWebDriver(2000);

        try
        {
            genericfunctions.waitForPageToLoad(postwithhashtagobjects.activity_showtimez_postcard.get(0));

            Assert.assertTrue(postwithhashtagobjects.activity_showtimez_postcard.get(0).isDisplayed());
            ExtentTestManager.getTest().log(LogStatus.PASS, " \" ShowTimez Post Card \" is displayed");
        }
        catch(Exception e)
        {
            Assert.fail("Expected :: \" ShowTimez Post Card \" should be displayed ; " +
                    "Actual :: \" ShowTimez Post Card \" is not displayed"+"&"+e.getMessage()+"");
        }
    }

    /**
     * Verify_ReachOut Message_PopUp
     * Author:- Gandharva
     */
    public void verifyDispalyOfReachOutLinkOnMessangerTextAreaPopUp(String... strings)
    {
        ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " ::  ReachOut Link is Displayed or Not");


        try
        {
            genericfunctions.waitForPageToLoad(postwithhashtagobjects.reachout_message_area);
            Assert.assertTrue(postwithhashtagobjects.reachout_message_area.isDisplayed());
            ExtentTestManager.getTest().log(LogStatus.PASS, " \"ReachOut Link\" is displayed");

        }
        catch(Exception e)
        {
            Assert.fail("Expected :: \" ReachOut Link  \" should be displayed ; Actual :: \"ReachOut Link \" is not displayed"+"&"+e.getMessage()+"");
        }
    }

    /**
     * Verify_Deleted ShowTimez Post
     * Author:- Gandharva
     */
    public void verifyDisplayOfDeletedShowtimezPost(String... strings)
    {
        ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " ::  Showtimez Post is deleted or not with following assertion : ");
        String expectedTextPost = strings[1].trim();
        genericfunctions.waitWebDriver(2000);

        try
        {
            for (WebElement webElement : postwithhashtagobjects.showtimez_event_title)
            {

                if (expectedTextPost.equals(webElement.getText()))
                {
                    Assert.assertFalse(webElement.isDisplayed());
                }

            }
            ExtentTestManager.getTest().log(LogStatus.PASS, " \" Showtimez Post \" is deleted");


        }
        catch (Throwable e)
        {
            Assert.fail("Expected :: \"Showtimez Post\" should be deleted ; Actual :: \" Showtimez Post \" is not deleted" + "&" + e.getMessage() + "");
        }
    }

    /**
     * Verify_BlueStore_RePost_Post
     * Author:- Gandharva
     */
    public void verifyDisplayOfRepostedBluestorePostOnFeed(String... strings)
    {
        ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " ::  RePosted BlueStore Post is Displayed or Not on Feed");
        String expectedShareStore = strings[1].trim();
        String actualShareStore = null;
        genericfunctions.waitWebDriver(2000);

        try
        {
            genericfunctions.waitForPageToLoad(homepageobjects.activity_text.get(0));
            actualShareStore=homepageobjects.activity_text.get(0).getText().trim();

            genericfunctions.waitTillTheElementIsVisible(homepageobjects.activity_text.get(0));
            Assert.assertTrue(actualShareStore.equals(expectedShareStore));
            ExtentTestManager.getTest().log(LogStatus.PASS, " Expected :: \"RePosted BlueStore Post \" should be displayed as "
                    +  ":: \"<b>" + expectedShareStore +"\"  </b> " + "" +" ;" +
                    " Actual :: \"RePosted BlueStore Post \" is displayed as"  + ":: \"<b>" + actualShareStore +"\"  </b> " + "");
        }

        catch(Throwable e)
        {
            Assert.fail("Expected :: \"RePosted BlueStore Post \" should be displayed ; Actual :: \"RePosted BlueStore Post \" is not displayed"+"&"+e.getMessage()+"");
        }
    }

    /**
     * Verify_Deleted BlueStore_Reposted Post
     * Author:- Gandharva
     */
    public void verifyDisplayOfDeletedBlueStorePost(String... strings)
    {
        ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " ::  BlueStore Post is deleted or not with following assertion ");
        String expectedTextPost = strings[1].trim();
        genericfunctions.waitWebDriver(2000);

        try
        {
            for (WebElement webElement : postwithhashtagobjects.activity_bluestore_title)
            {

                if (expectedTextPost.equals(webElement.getText()))
                {
                    Assert.assertFalse(webElement.isDisplayed());
                }

            }
            ExtentTestManager.getTest().log(LogStatus.PASS, " \" BlueStore Post \" is deleted");
        }
        catch (Throwable e)
        {
            Assert.fail("Expected :: \"BlueStore Post\" should be deleted ; Actual :: \" BlueStore Post \" is not deleted" + "&" + e.getMessage() + "");
        }
    }


    /**
     * Verify Opportunity  Post
     * Author:- Gandharva
     */
    public void verifyDisplayOfOpportunityPostCardOnFeed(String... strings)
    {
        ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " ::  Created Opportunity Post is Displayed or Not on  NewsFeed");
        genericfunctions.waitWebDriver(2000);

        try
        {
            genericfunctions.waitForPageToLoad(postwithhashtagobjects.activity_opportunity_postcard.get(0));


            Assert.assertTrue(postwithhashtagobjects.activity_opportunity_postcard.get(0).isDisplayed());

            ExtentTestManager.getTest().log(LogStatus.PASS, " \" Opportunity Post Card \" is displayed");
        }

        catch(Throwable e)
        {
            Assert.fail("Expected :: \" Opportunity Post Card \" should be displayed ; Actual :: \" Opportunity Post Card \" is not displayed"+"&"+e.getMessage()+"");
        }
    }

    /**
     * Verify Opportunity  Post
     * Author:- Gandharva
     */
    public void verifyDisplayOfCreatedOpportunityPostOnFeed(String... strings)
    {
        ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " ::  Created Opportunity Post Title is Displayed or Not on  NewsFeed");
        String expectedOpportunityTitle = strings[1].trim();
        String actualOpportunityTitle = null;
        genericfunctions.waitWebDriver(2000);

        try
        {
            genericfunctions.waitForPageToLoad(postwithhashtagobjects.activity_opportunity_title.get(0));
            actualOpportunityTitle=postwithhashtagobjects.activity_opportunity_title.get(0).getText().trim();
            genericfunctions.waitTillTheElementIsVisible(postwithhashtagobjects.activity_opportunity_title.get(0));
            Assert.assertTrue(actualOpportunityTitle.equals(expectedOpportunityTitle));
            ExtentTestManager.getTest().log(LogStatus.PASS, " Expected :: \"Created Opportunity Post Title\" should be displayed as "
                    + ":: \"<b>" + expectedOpportunityTitle +"\"   </b>  ; Actual :: \"Created Opportunity Post Title\" is displayed as" + ":: \"<b>" + actualOpportunityTitle +"\"   </b>");
        }

        catch(Throwable e)
        {
            String actualException=e.getClass().getName();

            switch (actualException)
            {
                case "java.lang.NoSuchElementException":
                    Assert.fail("Expected :: \"Created Opportunity Post Title \" should be displayed ; Actual :: \"Created Opportunity Post Title \" is not displayed"+"&"+e.getMessage()+"");
                    break;
                case "java.lang.AssertionError":
                    Assert.fail("error message  is  displaying "+"&"+e.getMessage()+"");
                    break;
                default:
                    Assert.fail(actualException + "&" +  e.getMessage()+ "");
            }
        }
    }

    /**
     * Verify Opportunity Category
     * 26-05-2020
     * Author:- Gandharva
     */
    public void verifyDisplayOfCategoryField(String... strings)
    {
        ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " ::  Opportunity Category field is Displayed or Not");
        try
        {
            genericfunctions.waitTillTheElementIsVisible(homepageobjects.opportunity_category);
            Assert.assertTrue(homepageobjects.opportunity_category.isDisplayed());
            ExtentTestManager.getTest().log(LogStatus.PASS, " " + "  \"Opportunity Category\" field is Displayed ");
        }
        catch (Throwable e)
        {
            Assert.fail(" \"Opportunity Category\" field is not Displayed "+ "&"+e.getMessage());
        }

    }

    /**
     * Verify Opportunity Category Options List
     * 26-05-2020
     * Author:- Gandharva
     */
    public void verifyDisplayOfCategoryOptionsList(String... strings)
    {
        String[] expectedCategories=strings[0].split("\\,");
        List<WebElement> opstions = null;

        ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[1] + " :: Opportunity Category Options are Displayed or Not");

        try
        {
            ExtentTestManager.getTest().log(LogStatus.INFO, " " + " Category Options are:-");
            selectdropdownOption=new Select(homepageobjects.opportunity_category);
            opstions=selectdropdownOption.getOptions();

            System.out.println("OptionSize:-"+opstions.size());

            for (int i=0; i < opstions.size()-1;i++)
            {
                String actualCategoryOption = opstions.get(i+1).getAttribute("value");

                /*System.out.println("Actualcategory:-"+actualCategoryOption.trim());

                System.out.println("category:-"+expectedCategories[i].trim());*/

                Assert.assertTrue(actualCategoryOption.trim().equals(expectedCategories[i].trim()));

                ExtentTestManager.getTest().log(LogStatus.PASS, " " + "<b>" +  actualCategoryOption  + "</b>" + "");
            }
        }

        catch (Throwable e)
        {
            Assert.fail(" \"Opportunity Category Options\"  are not Displayed "+ "&"+e.getMessage());
        }
    }

    /**
     * Verify Opportunity Title
     * 26-05-2020
     * Author:- Gandharva
     */
    public void verifyDisplayOfTitleField(String... strings)
    {
        ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " ::  Opportunity  Title field is Displayed or Not");
        try
        {
            genericfunctions.waitTillTheElementIsVisible(homepageobjects.opportunity_title);
            Assert.assertTrue(homepageobjects.opportunity_title.isDisplayed());
            ExtentTestManager.getTest().log(LogStatus.PASS, " " + "  \"Opportunity Title\" field is Displayed ");
        }
        catch (Throwable e)
        {
            Assert.fail("  \"Opportunity Title \" field is not Displayed "+ "&"+e.getMessage());
        }

    }


    /**
     * Verify Opportunity Description
     * 26-05-2020
     * Author:- Gandharva
     */
    public void verifyDisplayOfDescriptionField(String... strings)
    {
        ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " :: Opportunity Description field is Displayed or Not");
        try
        {
            genericfunctions.waitTillTheElementIsVisible(homepageobjects.opportunity_description);
            Assert.assertTrue(homepageobjects.opportunity_description.isDisplayed());
            ExtentTestManager.getTest().log(LogStatus.PASS, " " + "  \"Opportunity Description\" field is Displayed ");
        }
        catch (Throwable e)
        {
            Assert.fail("  \"Opportunity Description\" field not is Displayed "+ "&"+e.getMessage());
        }

    }

    /**
     * Verify Opportunity Location
     * 26-05-2020
     * Author:- Gandharva
     */
    public void verifyDisplayOfLocationField(String... strings)
    {
        ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " ::  Opportunity Location field is Displayed or Not");
        try
        {
            genericfunctions.waitTillTheElementIsVisible(homepageobjects.opportunity_location);
            Assert.assertTrue(homepageobjects.opportunity_location.isDisplayed());
            ExtentTestManager.getTest().log(LogStatus.PASS, " " + "  \"Opportunity Location\" field is Displayed ");
        }
        catch (Throwable e)
        {
            Assert.fail("  \"Opportunity Location\" field not is Displayed "+ "&"+e.getMessage());
        }
    }

    /**
     * Verify Opportunity Close Icon
     * 26-05-2020
     * Author:- Gandharva
     */
    public void verifyDisplayOfOpportunityPopUpCloseIcon(String... strings)
    {
        ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " ::  Opportunity PopUp Close Icon is Displayed or Not");
        try
        {
            genericfunctions.waitTillTheElementIsVisible(postwithhashtagobjects.opportunity_close_icon);
            Assert.assertTrue(postwithhashtagobjects.opportunity_close_icon.isDisplayed());
            ExtentTestManager.getTest().log(LogStatus.PASS, " " + "  \"Opportunity PopUp Close\" Icon is Displayed ");
        }
        catch (Throwable e)
        {
            Assert.fail("  \"Opportunity PopUp Close\" Icon not is Displayed "+ "&"+e.getMessage());
        }

    }

    /**
     * Verify Opportunity Cover Image Add Thumbnail
     * 26-05-2020
     * Author:- Gandharva
     */
    public void verifyDisplayOfOpportunityUploadCoverImageAddThumbnail(String... strings)
    {
        ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " ::  Opportunity Upload Cover Image Add Thumbnail field is Displayed or Not");
        try
        {
            genericfunctions.waitTillTheElementIsVisible(postwithhashtagobjects.file_Upload);
            Assert.assertTrue(postwithhashtagobjects.file_Upload.isDisplayed());
            ExtentTestManager.getTest().log(LogStatus.PASS, " " + "  \"Opportunity Upload Cover Image Add Thumbnail\" field is Displayed ");
        }
        catch (Throwable e)
        {
            Assert.fail("  \"Opportunity Upload Cover Image Add Thumbnail\" field not is Displayed "+ "&"+e.getMessage());
        }
    }

    /**
     * Verify Opportunity Post Button
     * 26-05-2020
     * Author:- Gandharva
     */
    public void verifyDisplayOfOpportunitySubmitButton(String... strings)
    {
        ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " ::  Opportunity Submit Button is Displayed or Not");
        try
        {
            genericfunctions.waitTillTheElementIsVisible(homepageobjects.opportunity_submit);
            Assert.assertTrue(homepageobjects.opportunity_submit.isDisplayed());
            ExtentTestManager.getTest().log(LogStatus.PASS, " " + "  \"Opportunity Submit Button\" is Displayed ");
        }
        catch (Throwable e)
        {
            Assert.fail("  \"Opportunity Submit Button \" not is Displayed "+ "&"+e.getMessage());
        }
    }

    /**
     * Verify_Uploaded_Thumbnail_On_Portfolio
     * Author:- Gandharva
     * Date:- 27-05-20202
     */
    public void verifyDisplayOfPortfolioThumbnail(String... strings)
    {
        genericfunctions.waitWebDriver(2000);
        ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " ::  Elements has Uploaded or not");

        try
        {
            genericfunctions.waitTillTheElementIsVisible(postwithhashtagobjects.portfolio_upload_thumbnil);
            Assert.assertTrue(postwithhashtagobjects.portfolio_upload_thumbnil.isDisplayed());
            ExtentTestManager.getTest().log(LogStatus.PASS, " \"Media Thumbnail\" has displayed");
        }
        catch (Throwable e)
        {
            Assert.fail("Could not found \"Media Thumbnail\" " + "&" + e.getMessage() + "");
        }
    }

    /**
     * Verify Portfolio Post
     * Author:- Gandharva
     * Date:- 27-05-2020
     */
    public void verifyDisplayOfPortfolioPostOnFeed(String... strings)
    {

        ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " ::  Portfolio Post is Displayed or Not on TimeLine");
        String exceptedtext =strings[1];
        genericfunctions.waitWebDriver(2000);
        try
        {
            genericfunctions.waitForPageToLoad(postwithhashtagobjects.feed_media_image.get(0));
            Assert.assertTrue(postwithhashtagobjects.feed_media_image.get(0).isDisplayed());
            ExtentTestManager.getTest().log(LogStatus.PASS, "  \"Portfolio Post \" is Displayed on TimeLine");
        }
        catch(Throwable e)
        {
            Assert.fail("Expected :: \"Portfolio Post \" should be displayed on TimeLine;" +
                    " Actual :: \"Portfolio Post \" is not displayed on  TimeLine"+"&"+e.getMessage()+"");
        }

        try
        {
            genericfunctions.waitTillTheElementIsVisible(homepageobjects.activity_text.get(0));
            String actualText = homepageobjects.activity_text.get(0).getText();
            Assert.assertTrue(actualText.equals(exceptedtext));

            ExtentTestManager.getTest().log(LogStatus.PASS, " Expected :: \"PortfolioPost Text Content\" should be displayed as :: "
                    + " \"<b>" + exceptedtext +"\"   </b>  ; Actual :: \"PortfolioPost Text Content\" is displayed as" + " \"<b>" + actualText +"\"   </b>");

        }

        catch(Throwable e)
        {
            String actualException=e.getClass().getName();

            switch (actualException)
            {
                case "java.lang.NoSuchElementException":
                    Assert.fail("Expected :: \"PortfolioPost Text Content \" should be displayed on  TimeLine;" +
                            " Actual :: \"Portfolio Post Text Content \" is not displayed on  TimeLine"+"&"+e.getMessage()+"");
                    break;
                case "java.lang.AssertionError":
                    Assert.fail(actualException+"error message  is  displaying "+"&"+e.getMessage()+"");
                    break;
                default:
                    Assert.fail(actualException + "&"  + e.getMessage()+ "");
            }
        }
    }


    /**
     * Verify HashTag Post Header
     * Author:- Gandharva
     * Date:- 27-05-2020
     */
    public void verifyDisplayOfHashTagPostHeaderOnFeed(String... strings)
    {
        String exceptedHeader = strings[1].trim();
        String actualHeader = null;

        ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " :: "  + " \"<b>" + exceptedHeader +"\"  </b>"  + " Post Header is Displayed or Not on TimeLine");

        try
        {
            genericfunctions.waitTillTheElementIsVisible(postwithhashtagobjects.hashTag_header.get(0));
            actualHeader = postwithhashtagobjects.hashTag_header.get(0).getText().trim();
            Assert.assertTrue(actualHeader.equals(exceptedHeader));
            ExtentTestManager.getTest().log(LogStatus.PASS,  " \"<b>" + exceptedHeader +"\"  </b>" + " Post Header is Displayed on TimeLine"+
                    " Actual :: " +" \"<b>" + actualHeader +"\"  </b>" + " Post Header is  displayed on TimeLine");
        }
        catch(Throwable e)
        {
            String actualException=e.getClass().getName();

            switch (actualException)
            {
                case "java.lang.NoSuchElementException":
                    Assert.fail("Expected :: " + " \"<b>" + exceptedHeader +"\"  </b>"  + " Post Header should be displayed on TimeLine;" +
                            " Actual :: " + " \"<b>" + actualHeader +"\"  </b>"  + " Post Header is displayed on TimeLine"+"&"+e.getMessage()+"");
                    break;
                case "java.lang.AssertionError":
                    Assert.fail("error message  is  displaying "+"&"+e.getMessage()+"");
                    break;
                default:
                    Assert.fail(actualException  + "&"  + e.getMessage()+ "");
            }
        }
    }

    /**
     * Verify MyJourney Post Header
     * Author:- Gandharva
     * Date:- 27-05-2020
     */
    public void verifyDisplayOfPortfolioPostHeaderOnFeed(String... strings)
    {
        ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " ::  Portfolio Post Header is Displayed or Not on TimeLine");

        try
        {
            genericfunctions.waitTillTheElementIsVisible(postwithhashtagobjects.hashTag_header.get(0));
            Assert.assertTrue(postwithhashtagobjects.hashTag_header.get(0).isDisplayed());
            ExtentTestManager.getTest().log(LogStatus.PASS,  "  \"Portfolio Header \" is Displayed on TimeLine");
        }
        catch(Throwable e)
        {
            String actualException=e.getClass().getName();

            switch (actualException)
            {
                case "java.lang.NoSuchElementException":
                    Assert.fail("Expected :: \"Portfolio Header \" should be displayed on TimeLine;" +
                            " Actual :: \"Portfolio Header \" is not displayed on TimeLine"+"&"+e.getMessage()+"");
                    break;
                case "java.lang.AssertionError":
                    Assert.fail("error message  is  displaying "+"&"+e.getMessage()+"");
                    break;
                default:
                    Assert.fail(actualException + "&"  + e.getMessage()+ "");
            }
        }
    }

    /**
     * Verify MyJourney Post Header
     * Author:- Gandharva
     * Date:- 27-05-2020
     */
    public void verifyDisplayOfPortfolioPostOnUserportfolio(String... strings)
    {
        ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " ::  Portfolio Post On User Portfolio is Displayed or Not on TimeLine");

        try
        {
            genericfunctions.waitTillTheElementIsVisible(postwithhashtagobjects.media_images.get(0));
            Assert.assertTrue(postwithhashtagobjects.media_images.get(0).isDisplayed());
            ExtentTestManager.getTest().log(LogStatus.PASS,  "  \"Portfolio Post \" is Displayed on User Portfolio");
        }
        catch(Throwable e)
        {
            Assert.fail("Expected :: \"Portfolio Post \" should be displayed on User Portfolio;" +
                    " Actual :: \"Portfolio Post \" is not displayed on User Portfolio"+"&"+e.getMessage()+"");
        }
    }

    /**
     * Verify NSFW_Restricted_Content_Is_Enabeld
     * Author:- Gandharva
     * Date:- 27-05-2020
     */
    public void verifyPortfolioRestrictedContentToggleIsEnabled(String... strings)
    {
        ExtentTestManager.getTest().log(LogStatus.INFO, "" + strings[0] + "  \" Portfolio Restricted Content Toggle Button\" is Enabled or Not");
        try
        {
            genericfunctions.waitForPageToLoad(postwithhashtagobjects.portfolio_nsfw_toggle_Button);
            Assert.assertTrue(postwithhashtagobjects.portfolio_nsfw_toggle_Button.isEnabled());
            ExtentTestManager.getTest().log(LogStatus.PASS, "" + "  \"Portfolio Restricted Content Toggle Button\" is Enabled");
        }
        catch (Throwable e)
        {
            Assert.fail("Expected :: \"Portfolio Restricted_Content Toggle Button \" should be Enabled ; " +
                    "Actual :: \"Portfolio Restricted_Content Toggle Button\" is not Enabled"+"&"+e.getMessage()+"");
        }
    }

    /**
     *  Verify Dispaly Of View Profile Activity Details
     * Author:- Gandharva
     * Date:- 27-05-2020
     * */
    public void verifyDispalyOfViewProfileActivityDetails(String... strings)
    {
        ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + ":: Profile Activity Details are displayed or not ");
        try
        {
            genericfunctions.waitForPageToLoad(postwithhashtagobjects.view_profile_activity_details);
            String details= postwithhashtagobjects.view_profile_activity_details.getText();

            Assert.assertTrue(postwithhashtagobjects.view_profile_activity_details.isDisplayed());

            ExtentTestManager.getTest().log(LogStatus.PASS, " "+ " Profile \" Activity \" Details are  "+ "<b>"+ details+ "</b>");
        }
        catch (Throwable e)
        {
            Assert.fail("Could not perform action on \"Profile Activity Details\""+"&"+e.getMessage()+"" );
        }
    }


}
