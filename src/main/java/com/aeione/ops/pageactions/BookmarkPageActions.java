package com.aeione.ops.pageactions;

import com.aeione.ops.generic.DriverManager;
import com.aeione.ops.generic.ExtentTestManager;
import com.aeione.ops.generic.GenericFunctions;
import com.aeione.ops.pageobjects.BookmarkPageObjects;
import com.aeione.ops.pageobjects.HomePageObjects;
import com.aeione.ops.pageobjects.LoginPageObjects;
import com.aeione.ops.pageobjects.PostCardObjects;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.io.IOException;

public class BookmarkPageActions {
    GenericFunctions genericfunctions;
    LoginPageObjects loginpageobjects = new LoginPageObjects();
    HomePageObjects homepageobjects = new HomePageObjects();
    PostCardObjects postcardobjects = new PostCardObjects();
    BookmarkPageObjects bookmarkpageobjects = new BookmarkPageObjects();
    Actions actions = null;


    public BookmarkPageActions() throws IOException {
        genericfunctions = new GenericFunctions(DriverManager.getDriver());
        PageFactory.initElements(DriverManager.getDriver(), this);
        PageFactory.initElements(DriverManager.getDriver(), loginpageobjects);
        PageFactory.initElements(DriverManager.getDriver(), homepageobjects);
        PageFactory.initElements(DriverManager.getDriver(), postcardobjects);
        PageFactory.initElements(DriverManager.getDriver(), bookmarkpageobjects);
        actions = new Actions(DriverManager.getDriver());
    }

    /////////////////////////// Page Actions ////////////////////////////////

    public void clickOnBookmarkIcon(String... strings) {
        ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " :: click On Bookmark icon");
        try {
            Thread.sleep(2000);
            genericfunctions.waitTillTheElementIsVisible(bookmarkpageobjects.bookmark_icon.get(0));
            genericfunctions.clickOnElementUsingJavascript(bookmarkpageobjects.bookmark_icon.get(0));

        } catch (Exception e) {
            Assert.fail("Could not perform action on \"Bookmark icon\"" + "&" + e.getMessage() + "");

        }

    }

    public void clickOnFollowButton(String... strings) {
        ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " :: click On follow botton");
        try {
            Thread.sleep(2000);
            genericfunctions.waitTillTheElementIsVisible(bookmarkpageobjects.follow_button);
            bookmarkpageobjects.follow_button.click();
        } catch (Exception e) {
            Assert.fail("Could not perform action on \"Bookmark icon\"" + "&" + e.getMessage() + "");

        }

    }

    public void moveCursorToBookmarkIcon(String... strings) {
        ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " :: move cursor On Bookmark icon");
        try {

            genericfunctions.waitTillTheElementIsVisible(bookmarkpageobjects.bookmark_icon.get(0));
            actions.moveToElement(bookmarkpageobjects.bookmark_icon.get(0)).build().perform();

        } catch (Exception e) {
            Assert.fail("Could not perform action on \"Move to Bookmark icon\"" + "&" + e.getMessage() + "");

        }

    }

    public void clickOnBookmarksModule(String... strings) {
        ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " :: click On Bookmarks Module");
        try {
            Thread.sleep(2000);
            genericfunctions.waitTillTheElementIsVisible(bookmarkpageobjects.bookmarks_module);
            bookmarkpageobjects.bookmarks_module.click();
        } catch (Exception e) {
            Assert.fail("Could not perform action on \"Bookmark Module\"" + "&" + e.getMessage() + "");

        }

    }


    public void clickOnBlogFilterRadioButton(String... strings) {
        ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " :: click On Bookmarks-Blog Filter radio button ");
        try {
            Thread.sleep(2000);
            genericfunctions.waitTillTheElementIsVisible(bookmarkpageobjects.blog_radiobutton);
            bookmarkpageobjects.blog_radiobutton.click();
        } catch (Exception e) {
            Assert.fail("Could not perform action on \"Blog Filter RadioButton\"" + "&" + e.getMessage() + "");

        }

    }

    public void clickOnOpportunitiesFilterRadioButton(String... strings) {
        ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " :: click On Bookmarks -Opportunities Filter radio button");
        try {
            Thread.sleep(2000);
            genericfunctions.waitTillTheElementIsVisible(bookmarkpageobjects.opportunities_radiobutton);
            bookmarkpageobjects.opportunities_radiobutton.click();
        } catch (Exception e) {
            Assert.fail("Could not perform action on \"Opportunities Filter RadioButton\"" + "&" + e.getMessage() + "");

        }

    }

    public void clickOnEventsFilterRadioButton(String... strings) {
        ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " :: click On Bookmarks-Events Filter radio button");
        try {
            Thread.sleep(2000);
            genericfunctions.waitTillTheElementIsVisible(bookmarkpageobjects.event_radiobutton);
            bookmarkpageobjects.event_radiobutton.click();
        } catch (Exception e) {
            Assert.fail("Could not perform action on \"Events Filter RadioButton\"" + "&" + e.getMessage() + "");

        }

    }

    public void clickOnBlueStoresFilterRadioButton(String... strings) {
        ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " :: click On Bookmarks-BlueStores Filter radio button");
        try {
            Thread.sleep(2000);
            genericfunctions.waitTillTheElementIsVisible(bookmarkpageobjects.blueStore_radiobutton);
            bookmarkpageobjects.blueStore_radiobutton.click();
        } catch (Exception e) {
            Assert.fail("Could not perform action on \"BlueStores Filter RadioButton\"" + "&" + e.getMessage() + "");

        }

    }

    public void clickOnPostsFilterRadioButton(String... strings) {
        ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " :: click On Bookmarks-Posts Filter radio button");
        try {
            Thread.sleep(2000);
            genericfunctions.waitTillTheElementIsVisible(bookmarkpageobjects.posts_radiobutton);
            bookmarkpageobjects.posts_radiobutton.click();
        } catch (Exception e) {
            Assert.fail("Could not perform action on \"Posts Filter RadioButton\"" + "&" + e.getMessage() + "");

        }

    }

    public void clickOnProfileFilterRadioButton(String... strings) {
        ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " :: click On Bookmarks-Profile Filter radio button");
        try {
            Thread.sleep(2000);
            genericfunctions.waitTillTheElementIsVisible(bookmarkpageobjects.profile_radiobutton);
            bookmarkpageobjects.profile_radiobutton.click();
        } catch (Exception e) {
            Assert.fail("Could not perform action on \"Profile Filter RadioButton\"" + "&" + e.getMessage() + "");

        }

    }

    public void clickOnAllFilterRadioButton(String... strings) {
        ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " :: click On Bookmarks-All Filter radio button");
        try {
            Thread.sleep(2000);
            genericfunctions.waitTillTheElementIsVisible(bookmarkpageobjects.all_radiobutton);
            bookmarkpageobjects.all_radiobutton.click();
        } catch (Exception e) {
            Assert.fail("Could not perform action on \"All Filter RadioButton\"" + "&" + e.getMessage() + "");

        }

    }


    //////////////////////////// Page Verifications /////////////////////////////////////

    public void verifyDisplayOfBookMarkedToolTip(String... strings) {
        ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " ::  Bookmarked ToolTip is displaying or not :");

        try {
            String exp_tooltip = "Bookmarked";
            genericfunctions.waitTillTheElementIsVisible(bookmarkpageobjects.bookmarked_tooltip);
            Assert.assertEquals(exp_tooltip, (bookmarkpageobjects.bookmarked_tooltip.getText()));
            Assert.assertTrue(bookmarkpageobjects.bookmarked_tooltip.isDisplayed());
            ExtentTestManager.getTest().log(LogStatus.PASS, "\" Bookmarked ToolTip\" is displaying");
        } catch (Throwable e) {
            Assert.fail("Expected :: \"Bookmarked ToolTip\"  should be displayed ; Actual :: \"Bookmarked ToolTip\"  is not displaying" + "&" + e.getMessage() + "");
        }
    }

    public void verifyBlogFilterRadiobuttonIsEnable(String... strings) {

        try {
            genericfunctions.waitTillTheElementIsVisible(bookmarkpageobjects.blog_radiobutton);
            Assert.assertTrue(bookmarkpageobjects.blog_radiobutton.isEnabled());
            ExtentTestManager.getTest().log(LogStatus.PASS, " " + " \" Blog Filter Radiobutton\" is enabled");

        } catch (Exception e) {
            Assert.fail("Expected :: \" Blog Filter Radiobutton\" should be enabled  ; Actual ::  \" Blog Filter Radiobutton\" is not enabled" + "&" + e.getMessage() + "");
        }

    }

    public void verifyOpportunitiesFilterRadiobuttonIsEnable(String... strings) {

        try {
            genericfunctions.waitTillTheElementIsVisible(bookmarkpageobjects.opportunities_radiobutton);
            Assert.assertTrue(bookmarkpageobjects.opportunities_radiobutton.isEnabled());
            ExtentTestManager.getTest().log(LogStatus.PASS, " " + " \" Opportunities Filter Radiobutton\" is enabled");

        } catch (Exception e) {
            Assert.fail("Expected :: \" Opportunities Filter Radiobutton\" should be enabled   ; Actual ::  \" Opportunities Filter Radiobutton\" is not enabled" + "&" + e.getMessage() + "");
        }

    }

    public void verifyEventsFilterRadiobuttonIsEnable(String... strings) {

        try {
            genericfunctions.waitTillTheElementIsVisible(bookmarkpageobjects.event_radiobutton);
            Assert.assertTrue(bookmarkpageobjects.event_radiobutton.isEnabled());
            ExtentTestManager.getTest().log(LogStatus.PASS, " " + " \" Events Filter Radiobutton\"is enabled");

        } catch (Exception e) {
            Assert.fail("Expected :: \" Events Filter Radiobutton\" should be enabled  ; Actual ::  \" Events Filter Radiobutton\" is not enabled" + "&" + e.getMessage() + "");
        }

    }

    public void verifyBlueStoresFilterRadiobuttonIsEnable(String... strings) {

        try {
            genericfunctions.waitTillTheElementIsVisible(bookmarkpageobjects.blueStore_radiobutton);
            Assert.assertTrue(bookmarkpageobjects.blueStore_radiobutton.isEnabled());
            ExtentTestManager.getTest().log(LogStatus.PASS, " " + " \" BlueStores Filter Radiobutton\" is enabled");

        } catch (Exception e) {
            Assert.fail("Expected :: \" BlueStores Filter Radiobutton\" should be enabled   ; Actual ::  \" BlueStores Filter Radiobutton\" is not enabled" + "&" + e.getMessage() + "");
        }

    }

    public void verifyPostsFilterRadiobuttonIsEnable(String... strings) {

        try {
            genericfunctions.waitTillTheElementIsVisible(bookmarkpageobjects.posts_radiobutton);
            Assert.assertTrue(bookmarkpageobjects.posts_radiobutton.isEnabled());
            ExtentTestManager.getTest().log(LogStatus.PASS, " " + " \" Posts Filter Radiobutton\"is enabled");

        } catch (Exception e) {
            Assert.fail("Expected :: \" Posts Filter Radiobutton\" should be enabled  ; Actual ::  \" Posts Filter Radiobutton\" is not enabled" + "&" + e.getMessage() + "");
        }

    }

    public void verifyProfileFilterRadiobuttonIsEnable(String... strings) {

        try {
            genericfunctions.waitTillTheElementIsVisible(bookmarkpageobjects.profile_radiobutton);
            Assert.assertTrue(bookmarkpageobjects.profile_radiobutton.isEnabled());
            ExtentTestManager.getTest().log(LogStatus.PASS, " " + " \" Profile Filter Radiobutton\" is enabled");

        } catch (Exception e) {
            Assert.fail("Expected :: \" Profile Filter Radiobutton\" should be enabled   ; Actual ::  \" Profile Filter Radiobutton\" is not enabled" + "&" + e.getMessage() + "");
        }

    }

    public void verifyAllFilterRadiobuttonIsEnable(String... strings) {

        try {
            genericfunctions.waitTillTheElementIsVisible(bookmarkpageobjects.all_radiobutton);
            Assert.assertTrue(bookmarkpageobjects.all_radiobutton.isEnabled());
            ExtentTestManager.getTest().log(LogStatus.PASS, " " + " \" All Filter Radiobutton\" is enabled");

        } catch (Exception e) {
            Assert.fail("Expected :: \" All Filter Radiobutton\" should be enabled   ; Actual ::  \" All Filter Radiobutton\" is not enabled" + "&" + e.getMessage() + "");
        }

    }

    public void verifyContentsOfBookmarkedPost(String... strings) {
        ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " :: All the  contents in Bookmarked post section with following assertion :");

        verifyDispalyOfUserProfileImage();
        verifyDisplayOfUserProfileName();
        verifyDisplayOfBookmarkLink();
        verifyDisplayOfMeatballMenu();
        verifyDisplayOfPostedContent();
        verifyDisplayOfPostTags();


    }

    public void verifyDisplayOfUserProfileName(String... strings) {

        try {
            genericfunctions.waitTillTheElementIsVisible(bookmarkpageobjects.profile_name);
            Assert.assertTrue(bookmarkpageobjects.profile_name.isDisplayed());
            ExtentTestManager.getTest().log(LogStatus.PASS, " " + " \" User profile Name\" is displaying");

        } catch (Exception e) {
            Assert.fail("Expected :: \" User profile Name\" should be displayed  ; Actual ::  \" User profile Name\" is not displayed" + "&" + e.getMessage() + "");
        }

    }
    public void verifyDispalyOfUserProfileImage(String... strings) {

        try {
            genericfunctions.waitTillTheElementIsVisible(bookmarkpageobjects.profile_image);
            Assert.assertTrue(bookmarkpageobjects.profile_image.isDisplayed());
            ExtentTestManager.getTest().log(LogStatus.PASS, " " + " \" User profile Image\" is displaying");

        } catch (Exception e) {
            Assert.fail("Expected :: \" User profile Image\" should be displayed  ; Actual ::  \" User profile Image\" is not displayed" + "&" + e.getMessage() + "");
        }

    }
    public void verifyDisplayOfPostedContent(String... strings) {

        try {
            genericfunctions.waitTillTheElementIsVisible(postcardobjects.posted_content.get(0));
            Assert.assertTrue(postcardobjects.posted_content.get(0).isDisplayed());
            ExtentTestManager.getTest().log(LogStatus.PASS, " "  + "  \" Posted Content\" is displaying");

        } catch (Exception e) {
            Assert.fail("Expected :: \" Posted Content\" should be displayed  ; Actual ::  \"Posted Content\" is not displayed" + "&" + e.getMessage() + "");
        }


    }
    public void verifyDisplayOfBookmarkLink(String... strings) {

        try {
            genericfunctions.waitTillTheElementIsVisible(bookmarkpageobjects.bookmark_icon.get(0));
            Assert.assertTrue(bookmarkpageobjects.bookmark_icon.get(0).isDisplayed());
            ExtentTestManager.getTest().log(LogStatus.PASS, " "  + " \" Bookmark link \" is displaying");

        } catch (Exception e) {
            Assert.fail("Expected :: \" Bookmark link \" should be displayed  ; Actual ::  \"Bookmark link \" is not displayed" + "&" + e.getMessage() + "");
        }

    }

    public void verifyDisplayOfMeatballMenu(String... strings) {

        try {
            genericfunctions.waitTillTheElementIsVisible(postcardobjects.meatball_menu);
            Assert.assertTrue(postcardobjects.meatball_menu.isDisplayed());
            ExtentTestManager.getTest().log(LogStatus.PASS, " "  + "  \" MeatballMenu \" is displaying");

        } catch (Exception e) {
            Assert.fail("Expected :: \" MeatballMenu \" should be displayed  ; Actual ::  \"meatball menu\" is not displayed" + "&" + e.getMessage() + "");
        }

    }
    public void verifyDisplayOfPostTags(String... strings) {

        try {
            genericfunctions.waitTillTheElementIsVisible(bookmarkpageobjects.post_tags.get(0));
            Assert.assertTrue(bookmarkpageobjects.post_tags.get(0).isDisplayed());
            ExtentTestManager.getTest().log(LogStatus.PASS, " " + " \" Post tag\" is displaying");

        } catch (Exception e) {
            Assert.fail("Expected :: \" Post tag\" should be displayed  ; Actual ::  \" Post tag\" is not displayed" + "&" + e.getMessage() + "");
        }

    }


}
