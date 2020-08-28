package com.aeione.ops.pageactions;



import com.aeione.ops.generic.DriverManager;
import com.aeione.ops.generic.ExtentTestManager;
import com.aeione.ops.generic.GenericFunctions;
import com.aeione.ops.pageobjects.HomePageObjects;
import com.aeione.ops.pageobjects.LoginPageObjects;
import com.aeione.ops.pageobjects.PostCardObjects;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.io.IOException;

public class PostCardActions {
    GenericFunctions genericfunctions;
    LoginPageObjects loginpageobjects = new LoginPageObjects();
    HomePageObjects homepageobjects = new HomePageObjects();
    PostCardObjects postcardobjects = new PostCardObjects();
    Actions actions = null;


    public PostCardActions() throws IOException {
        genericfunctions = new GenericFunctions(DriverManager.getDriver());
        PageFactory.initElements(DriverManager.getDriver(), this);
        PageFactory.initElements(DriverManager.getDriver(), loginpageobjects);
        PageFactory.initElements(DriverManager.getDriver(), homepageobjects);
        PageFactory.initElements(DriverManager.getDriver(), postcardobjects);
        actions = new Actions(DriverManager.getDriver());
    }

    /////////////////////////// Page Actions ////////////////////////////////
    public void clickOnContributeIcon(String... strings) {
        ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " :: click On Contribute_Icon in postcard ");
        try {Thread.sleep(2000);

            genericfunctions.waitTillTheElementIsVisible(postcardobjects.contribution_icon.get(0));
            genericfunctions.clickOnElementUsingJavascript(postcardobjects.contribution_icon.get(0));
        } catch (Exception e) {
            Assert.fail("Could not perform action on \" Contribute Icon\"" + "&" + e.getMessage() + "");

        }

    }

    public void clickOnBuyCoinsButtonInContributePopup(String... strings) {
        ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " :: click On Buy coins Button in Contribute Pop-Up ");
        try {
            genericfunctions.waitTillTheElementIsVisible(postcardobjects.contribution_popup_buy_coins_button);
            postcardobjects.contribution_popup_buy_coins_button.click();

        } catch (Exception e) {
            Assert.fail("Could not perform action on \"Buy coins button\"" + "&" + e.getMessage() + "");

        }
    }

    public void clickOnCancelButtonInBuyCoinsPopup(String... strings) {
        ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " :: click On Cancel button present in BuyCoins Pop-up");
        try {
            genericfunctions.waitTillTheElementIsVisible(postcardobjects.buycoins_popup_cancel_button);
            postcardobjects.buycoins_popup_cancel_button.click();

        } catch (Exception e) {
            Assert.fail("Could not perform action on \" Cancel button in Buycoins popup\"" + "&" + e.getMessage() + "");

        }
    }

    public void clickOnCancelButtonInBoostPostPopup(String... strings) {
        ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " :: click On Cancel button in BoostPost-Popup");
        try {
            genericfunctions.waitTillTheElementIsVisible(postcardobjects.boost_popup_cancel_button);
            postcardobjects.boost_popup_cancel_button.click();
        } catch (Exception e) {
            Assert.fail("Could not perform action on \"Cancel button in BoostPost-Popup\"" + "&" + e.getMessage() + "");

        }

    }

    public void clickOnMeatBallMenu(String... strings) {
        ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " :: click On MeatBall Menu");
        try {
            genericfunctions.waitTillTheElementIsVisible(postcardobjects.meatball_menu);
            postcardobjects.meatball_menu.click();
        } catch (Exception e) {
            Assert.fail("Could not perform action on \"MeatBall Menu\"" + "&" + e.getMessage() + "");

        }

    }

    public void clickOnDeleteOption(String... strings) {
        ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " :: click On Delete Option");
        try {
            genericfunctions.waitTillTheElementIsVisible(postcardobjects.post_delete_option);
            postcardobjects.post_delete_option.click();
        } catch (Exception e) {
            Assert.fail("Could not perform action on \"Delete option\"" + "&" + e.getMessage() + "");

        }

    }

    public void clickOnYesButton(String... strings) {
        ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " :: click On Yes button in Delete this post popup");
        try {
            genericfunctions.waitTillTheElementIsVisible(postcardobjects.yes_button);
            postcardobjects.yes_button.click();
        } catch (Exception e) {
            Assert.fail("Could not perform action on \"Yes Button in Delete this post popup\"" + "&" + e.getMessage() + "");

        }

    }

    public void clickOnBoostButton(String... strings) {
        ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " :: click On Boost Button");
        try {
            genericfunctions.waitTillTheElementIsVisible(postcardobjects.boost_button);
            postcardobjects.boost_button.click();
        } catch (Exception e) {
            Assert.fail("Could not perform action on \"Boost Button\"" + "&" + e.getMessage() + "");

        }

    }

    public String getPostActivityTime(String... strings) {
        ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " :: get post activity time");
        try {
            genericfunctions.waitTillTheElementIsVisible(postcardobjects.post_activity_time);
            return postcardobjects.post_activity_time.getText();
        } catch (Exception e) {
            Assert.fail("Could not perform action on \"activity time\"" + "&" + e.getMessage() + "");

        }

        return null;
    }

    public void clickOnShareButton(String... strings) {
        ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " :: click On Share Button");
        try {
            genericfunctions.waitTillTheElementIsVisible(postcardobjects.share_button);
            postcardobjects.share_button.click();
        } catch (Exception e) {
            Assert.fail("Could not perform action on \"Share Button\"" + "&" + e.getMessage() + "");

        }

    }

    public void clickOnRepostButton(String... strings) {
        ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " :: click On Repost Button in 'Share this post' pop-up");
        try {
            genericfunctions.waitTillTheElementIsVisible(postcardobjects.share_popup_Repost_button);
            postcardobjects.share_popup_Repost_button.click();
        } catch (Exception e) {
            Assert.fail("Could not perform action on \"Repost Button in 'Share this post' pop-up\"" + "&" + e.getMessage() + "");

        }

    }

    public void clickOnCancelButtonInRepostPopup(String... strings) {
        ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " :: click On Cancel button In Repost Popup");
        try {
            genericfunctions.waitTillTheElementIsVisible(postcardobjects.repost_popup_cancel_button);
            postcardobjects.repost_popup_cancel_button.click();
        } catch (Exception e) {
            Assert.fail("Could not perform action on \"Cancel button In Repost Popup\"" + "&" + e.getMessage() + "");

        }

    }

    public void clickOnShareButtonInRepostPopup(String... strings) {
        ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " :: click On Share button In Repost Popup");
        try {
            genericfunctions.waitTillTheElementIsVisible(postcardobjects.repost_popup_Share_button);
            postcardobjects.repost_popup_Share_button.click();
        } catch (Exception e) {
            Assert.fail("Could not perform action on \"Share button In Repost Popup\"" + "&" + e.getMessage() + "");

        }

    }



    public void clickOnLikeButton(String... strings) {
        ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " :: click On Like button");
        try {
            genericfunctions.waitTillTheElementIsVisible(postcardobjects.like_button.get(0));
            genericfunctions.clickOnElementUsingJavascript(postcardobjects.like_button.get(0));

        } catch (Exception e) {
            Assert.fail("Could not perform action on \"like button\"" + "&" + e.getMessage() + "");

        }

    }



    public void clickOnCommentButton(String... strings) {
        ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " :: click On comment button");
        try {
            genericfunctions.waitTillTheElementIsVisible(postcardobjects.postcard_comment_button.get(0));
            genericfunctions.clickOnElementUsingJavascript(postcardobjects.postcard_comment_button.get(0));

        } catch (Exception e) {
            Assert.fail("Could not perform action on \"comment button\"" + "&" + e.getMessage() + "");

        }

    }

    public void enterTextOnCommentTextArea(String... strings) {
        String message = strings[1];
        ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " :: enter text in comment section"+ " \"<b>" + message + "\"   </b>");
        try {
            genericfunctions.waitTillTheElementIsVisible(postcardobjects.postcard_comment_text_section.get(0));
            postcardobjects.postcard_comment_text_section.get(0).sendKeys(message);

        } catch (Exception e) {
            Assert.fail("Could not perform action on \"comment text section\"" + "&" + e.getMessage() + "");

        }

    }

    public void clickOnCommentSectionPostButton(String... strings) {
        ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " :: Click on Comment Section Post Button");
        try {
            genericfunctions.waitWebDriver(3000);
            genericfunctions.waitForPageToLoad(postcardobjects.comment_section_post_button);
            genericfunctions.waitTillTheElementIsVisible(postcardobjects.comment_section_post_button);
            postcardobjects.comment_section_post_button.click();
        } catch (Exception e) {
            Assert.fail("Could not perform action on \"Comment Section Post Button\"" + "&" + e.getMessage() + "");
        }


    }
    public void enterTextOnRepostTextArea(String... strings)
    {
        String message = strings[1];
        try
        {
            ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " :: Enter text on Repost Text Area as :: "+ " \"<b>" + message +"\"   </b>");
            genericfunctions.waitTillTheElementIsVisible(postcardobjects.repost_textarea);
            postcardobjects.repost_textarea.sendKeys(message);
        }
        catch (Exception e)
        {
            Assert.fail("Could not perform action on \"Repost Text Area\""+"&"+e.getMessage()+"" );
        }
    }
    public String getAvailableCoins(String... strings) {
        ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " :: get post activity time");
        try {
            genericfunctions.waitTillTheElementIsVisible(postcardobjects.boost_available_coins);
            String available_coins= postcardobjects.boost_available_coins.getText();
            System.out.println("available coins" + available_coins );
            return available_coins;

        } catch (Exception e) {
            Assert.fail("Could not perform action on \"activity time\"" + "&" + e.getMessage() + "");

        }

        return null;
    }

    public void clickOnBoostImpressionTextArea(String... strings)
    {
        ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " :: Click on Boost Impression TextArea");
        try
        {
            genericfunctions.waitTillTheElementIsVisible(postcardobjects.boost_impression_text_section);
            postcardobjects.boost_impression_text_section.click();
        }
        catch (Exception  e)
        {
            Assert.fail("Could not perform action on \"Boost Impression TextArea\""+"&"+e.getMessage()+"" );
        }
    }

    public void enterImpressionOnBoostImpressionTextArea(String... strings)
    {
        String impression = strings[1];
        try
        {
            ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " :: Enter Impression on Boost Impression TextArea as :: "+ " \"<b>" + impression +"\"   </b>");
            genericfunctions.waitTillTheElementIsVisible(postcardobjects.boost_impression_text_section);
            postcardobjects.boost_impression_text_section.sendKeys(impression);
        }
        catch (Exception e)
        {
            Assert.fail("Could not perform action on \"Text of Boost Impression\""+"&"+e.getMessage()+"" );
        }
    }
    public void clickOnBoostConsole(String... strings)
    {
        ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " :: Click on Boost Console");
        try
        {
            genericfunctions.waitTillTheElementIsVisible(postcardobjects.topbar_boostconsole);
            postcardobjects.topbar_boostconsole.click();
        }
        catch (Exception  e)
        {
            Assert.fail("Could not perform action on \" Boost Console\""+"&"+e.getMessage()+"" );
        }
    }





    //////////////////////////// Page Verifications /////////////////////////////////////

    public void verifyDisplayOfBuyCoinsPopup(String... strings) {
        ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " ::  BuyCoins popup is displaying or not :");

        try {
            genericfunctions.waitTillTheElementIsVisible(postcardobjects.buy_coins_popup);
            Assert.assertTrue(postcardobjects.buy_coins_popup.isDisplayed());
            ExtentTestManager.getTest().log(LogStatus.PASS, "\"BuyCoins popup\" is displaying");
        } catch (Exception e) {
            Assert.fail("Expected :: \"BuyCoins popup\"  should be displayed ; Actual :: \"BuyCoins popup\"  is not displaying" + "&" + e.getMessage() + "");
        }
    }

    public void verifyDisplayOfContributePopup(String... strings) {
        ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " ::   Contribute popup is displaying or not :");

        try {
            genericfunctions.waitTillTheElementIsVisible(postcardobjects.contribute_popup);
            Assert.assertTrue(postcardobjects.contribute_popup.isDisplayed());
            ExtentTestManager.getTest().log(LogStatus.PASS, " \"Contribute popup\" is displaying");
        } catch (Exception e) {
            Assert.fail("Expected :: \"Contribute popup\"  should be displayed ; Actual :: \"Contribute popup\"  is not displaying" + "&" + e.getMessage() + "");
        }
    }

    public void verifyDisplayOfBoostPopup(String... strings) {
        ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " ::  Boost Popup is displaying or not:");

        try {
            genericfunctions.waitTillTheElementIsVisible(postcardobjects.boost_popup);
            Assert.assertTrue(postcardobjects.boost_popup.isDisplayed());
            ExtentTestManager.getTest().log(LogStatus.PASS, "\"Boost popup\" is displaying");
        } catch (Exception e) {
            Assert.fail("Expected :: \"Boost popup \"  should be displayed ; Actual :: \"Boost popup\" is not displaying" + "&" + e.getMessage() + "");
        }
    }


    public void verifyPostCardIsDeleted(String... strings) {
        ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " :: Postcard is deleted or not with following assertion :");
        genericfunctions.refreshWebPage();
        try {
            for (WebElement webElement : postcardobjects.all_post_activity_time) {
                System.out.println(strings[1]);
                System.out.println(webElement.getText());
                if (strings[1].equals(webElement.getText())) {
                    Assert.assertFalse(webElement.isDisplayed());
                }

            }
            ExtentTestManager.getTest().log(LogStatus.PASS, "\"post card\" is deleted");


        } catch (Exception e) {
            Assert.fail("Expected :: \"Post card\"  should be deleted ; Actual :: \"Post card\" is not deleting" + "&" + e.getMessage() + "");
        }
    }

    public void verifyDisplayOfRepostPopup(String... strings) {
        ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " :: Repost popup is displaying or not:");

        try {
            genericfunctions.waitTillTheElementIsVisible(postcardobjects.repost_share_popup);
            Assert.assertTrue(postcardobjects.repost_share_popup.isDisplayed());
            ExtentTestManager.getTest().log(LogStatus.PASS, "\"Repost  popup \"  with share option  is displaying");
        } catch (Exception e) {
            Assert.fail("Expected :: \"Repost popup \"  should be displayed ; Actual :: \"Repost popup\"  is not displaying" + "&" + e.getMessage() + "");
        }
    }

    public void verifyContentsOfPostCard(String... strings) {
        ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " :: All the  contents in post card section with following assertion :");

        verifyDispalyOfUserProfileImage();
        verifyDisplayOfUserProfileName();
        verifyDisplayOfPostActivityTime();
        verifyDisplayOfBookmarkLink();
        verifyDisplayOfMeatballMenu();
        verifyDisplayOfLikeButton();
        verifyDisplayOfLikeCountIcon();
        verifyDisplayOfCommentButton();
        verifyDisplayOfViewCountIcon();
        verifyDisplayOfShareButton();
        verifyDisplayOfBoostButton();
        verifyDisplayOfPostedContent();


    }

    public void verifyDispalyOfUserProfileImage(String... strings) {

        try {
            genericfunctions.waitTillTheElementIsVisible(postcardobjects.postcard_user_profile_image);
            Assert.assertTrue(postcardobjects.postcard_user_profile_image.isDisplayed());
            ExtentTestManager.getTest().log(LogStatus.PASS, " " + " \" User profile Image\" is displaying");

        } catch (Exception e) {
            Assert.fail("Expected :: \" User profile Image\" should be displayed  ; Actual ::  \" User profile Image\" is not displayed" + "&" + e.getMessage() + "");
        }

    }

    public void verifyDisplayOfUserProfileName(String... strings) {

        try {
            genericfunctions.waitTillTheElementIsVisible(postcardobjects.postcard_user_profile_name);
            Assert.assertTrue(postcardobjects.postcard_user_profile_name.isDisplayed());
            ExtentTestManager.getTest().log(LogStatus.PASS, " "  + "  \" User profile name\" is displaying");

        } catch (Exception e) {
            Assert.fail("Expected :: \" User profile name\" should be displayed  ; Actual ::  \" User profile name\" is not displayed" + "&" + e.getMessage() + "");
        }

    }

    public void verifyDisplayOfPostActivityTime(String... strings) {

        try {
            genericfunctions.waitTillTheElementIsVisible(postcardobjects.postcard_user_profile_name);
            Assert.assertTrue(postcardobjects.postcard_user_profile_name.isDisplayed());
            ExtentTestManager.getTest().log(LogStatus.PASS, " " + "\" post Activity time\" is displaying");

        } catch (Exception e) {
            Assert.fail("Expected :: \" post Activity time\" should be displayed  ; Actual ::  \"post Activity time\" is not displayed" + "&" + e.getMessage() + "");
        }

    }

    public void verifyDisplayOfBookmarkLink(String... strings) {

        try {
            genericfunctions.waitTillTheElementIsVisible(postcardobjects.postcard_bookmark_link.get(0));
            Assert.assertTrue(postcardobjects.postcard_bookmark_link.get(0).isDisplayed());
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

    public void verifyDisplayOfLikeButton(String... strings) {

        try {
            genericfunctions.waitTillTheElementIsVisible(postcardobjects.like_button.get(0));
            Assert.assertTrue(postcardobjects.like_button.get(0).isDisplayed());
            ExtentTestManager.getTest().log(LogStatus.PASS, " "+ " \" like button \" is displaying");

        } catch (Exception e) {
            Assert.fail("Expected :: \" like button\" should be displayed  ; Actual ::  \"like button \" is not displayed" + "&" + e.getMessage() + "");
        }

    }

    public void verifyDisplayOfLikeCountIcon(String... strings) {

        try {
            genericfunctions.waitTillTheElementIsVisible(postcardobjects.like_count_icon.get(0));
            Assert.assertTrue(postcardobjects.like_count_icon.get(0).isDisplayed());
            ExtentTestManager.getTest().log(LogStatus.PASS, " "  + " \" like count icon \" is displaying");

        } catch (Exception e) {
            Assert.fail("Expected :: \" like count icon\" should be displayed  ; Actual ::  \"like count icon \" is not displayed" + "&" + e.getMessage() + "");
        }

    }


    public void verifyDisplayOfCommentButton(String... strings) {

        try {
            genericfunctions.waitTillTheElementIsVisible(postcardobjects.postcard_comment_button.get(0));
            Assert.assertTrue(postcardobjects.postcard_comment_button.get(0).isDisplayed());
            ExtentTestManager.getTest().log(LogStatus.PASS, " "  + "  \" comment button \" is displaying");

        } catch (Exception e) {
            Assert.fail("Expected :: \" comment button\" should be displayed  ; Actual ::  \"comment button \" is not displayed" + "&" + e.getMessage() + "");
        }

    }

    public void verifyDisplayOfViewCountIcon(String... strings) {

        try {
            genericfunctions.waitTillTheElementIsVisible(postcardobjects.postcard_view_count_icon);
            Assert.assertTrue(postcardobjects.postcard_view_count_icon.isDisplayed());
            ExtentTestManager.getTest().log(LogStatus.PASS, " " + "  \" view count icon \" is displaying");

        } catch (Exception e) {
            Assert.fail("Expected :: \" view count icon\" should be displayed  ; Actual ::  \"view count icon\" is not displayed" + "&" + e.getMessage() + "");
        }

    }

    public void verifyDisplayOfShareButton(String... strings) {

        try {
            genericfunctions.waitTillTheElementIsVisible(postcardobjects.share_button);
            Assert.assertTrue(postcardobjects.share_button.isDisplayed());
            ExtentTestManager.getTest().log(LogStatus.PASS, " "  + "  \" share button \" is displaying");

        } catch (Exception e) {
            Assert.fail("Expected :: \" share button\" should be displayed  ; Actual ::  \"share button \" is not displayed" + "&" + e.getMessage() + "");
        }

    }

    public void verifyDisplayOfBoostButton(String... strings) {

        try {
            genericfunctions.waitTillTheElementIsVisible(postcardobjects.boost_button);
            Assert.assertTrue(postcardobjects.boost_button.isDisplayed());
            ExtentTestManager.getTest().log(LogStatus.PASS, " "  + " \" boost button\" is displaying");

        } catch (Exception e) {
            Assert.fail("Expected :: \" boost button\" should be displayed  ; Actual ::  \"boost button\" is not displayed" + "&" + e.getMessage() + "");
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




    public void verifyDisplayOfPostCardCommentSection(String... strings) {
        ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " ::  comment section is displaying or not:");
        try {
            genericfunctions.waitTillTheElementIsVisible(postcardobjects.postcard_comment_text_section.get(0));
            Assert.assertTrue(postcardobjects.postcard_comment_text_section.get(0).isDisplayed());
            ExtentTestManager.getTest().log(LogStatus.PASS, " " +  "  \" comment section\" is displaying");

        } catch (Exception e) {
            Assert.fail("Expected :: \" comment section\" should be displayed  ; Actual ::  \"comment section\" is not displayed" + "&" + e.getMessage() + "");
        }


    }

    public void verifyDisplayOfAddedCommentToPost(String... strings) {
        ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " :: Added Comment To Text Post");
        String expectedTextPost = strings[1].trim();
        genericfunctions.waitWebDriver(2000);
        genericfunctions.waitForPageToLoad(postcardobjects.postcard_comment_text_section.get(0));
        String actualTextPost = postcardobjects.postcard_comment_text_section.get(0).getText().trim();
        try {
            genericfunctions.waitTillTheElementIsVisible(postcardobjects.postcard_comment_text_section.get(0));
            Assert.assertTrue(actualTextPost.equals(expectedTextPost));
            ExtentTestManager.getTest().log(LogStatus.PASS, "" + "Expected :: \"added comment\" should be displayed as "
                    + " " + "<b>" + expectedTextPost + " " + "</b> " + " ; Actual :: \"added comment\" is displayed as" + " " + "<b>" + actualTextPost + " " + "</b>" + "");
        } catch (Exception e) {
            Assert.fail("Expected :: \"added comment \" should be displayed ; Actual :: \"added comment \" is not displayed" + "&" + e.getMessage() + "");
        }
    }
    public String verifyBeforePostShareCount(String... strings) {
        ExtentTestManager.getTest().log(LogStatus.PASS, " " + strings[0] + " :: get post share count");
        try {

            genericfunctions.waitTillTheElementIsVisible(postcardobjects.share_count_icon.get(0));
            String postsharecounts = postcardobjects.share_count_icon.get(0).getText();
            ExtentTestManager.getTest().log(LogStatus.INFO, " " + " \"share Counts are \" " + "<b>" + postsharecounts + "</b>");
            return postsharecounts;
        } catch (Exception e) {
            Assert.fail("Could not perform action on \"share count\"" + "&" + e.getMessage() + "");

        }


        return null;
    }
    public String verifyBeforePostLikeCount(String... strings) {
        ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " :: get post like count");
        try {

            genericfunctions.waitTillTheElementIsVisible(postcardobjects.like_count_icon.get(0));
            String postlikecounts = postcardobjects.like_count_icon.get(0).getText();
            ExtentTestManager.getTest().log(LogStatus.PASS, " " + " \"Post Like Counts are \" " + "<b>" + postlikecounts + "</b>");
            //return postcardobjects.like_count_icon.get(0).getText();
            return postlikecounts;
        } catch (Exception e) {
            Assert.fail("Could not perform action on \"Post like count\"" + "&" + e.getMessage() + "");

        }


        return null;
    }
    public void verifyAfterPostLikeCount(String... strings) {
        ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " ::  post likecount is  increasing or not");

        try {
            int likecount = Integer.parseInt(strings[1]) + 1;
            System.out.println("the like count is" + likecount);
            genericfunctions.waitTillTheElementIsVisible(postcardobjects.like_count_icon.get(0));

            Assert.assertEquals(likecount, Integer.parseInt(postcardobjects.like_count_icon.get(0).getText()));


            ExtentTestManager.getTest().log(LogStatus.PASS, " "  + " \" Post like count number \" is increasing by  " + "<b>" + likecount + "</b>");

        } catch (Exception e) {
            Assert.fail("Expected :: \" like count number\" should be increased  ; Actual ::  \"like count number \" is not increased" + "&" + e.getMessage() + "");
        }


    }


    public void verifyContentsOfFollowedUserPostCard(String... strings) {
        ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " ::  All the  contents in followed user post card section with following assertion :");

        verifyDispalyOfUserProfileImage();
        verifyDisplayOfUserProfileName();
        verifyDisplayOfPostActivityTime();
        verifyDisplayOfBookmarkLink();
        verifyDisplayOfMeatballMenu();
        verifyDisplayOfLikeButton();
        verifyDisplayOfLikeCountIcon();
        verifyDisplayOfCommentButton();
        verifyDisplayOfViewCountIcon();
        verifyDisplayOfShareButton();
        verifyDisplayOfPostedContent();
    }

    public void verifyAfterPostShareCount(String... strings) {
        ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " :: post share count is  increasing or not");

        try {
            int sharecount = Integer.parseInt(strings[1] + 1);
            System.out.println("the share count is" + sharecount);
            genericfunctions.waitTillTheElementIsVisible(postcardobjects.share_count_icon.get(0));
            Assert.assertEquals(sharecount, Integer.parseInt(postcardobjects.share_count_icon.get(0).getText()));


            ExtentTestManager.getTest().log(LogStatus.PASS, " "  + "  \" share count number \" is increasing by "+ "<b>" + sharecount + "</b>");

        } catch (Exception e) {
            Assert.fail("Expected :: \" share count number\" should  increased  ; Actual ::  \"share count number \" is not increased" + "&" + e.getMessage() + "");
        }


    }
    public void verifyDisplayOfRepostedTextPost(String... strings)
    {
        genericfunctions.refreshWebPage();
        ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " ::  Created RePost is Displayed or not");
        String expectedTextPost = strings[1].trim();
        String actualTextPost = null;
        genericfunctions.waitWebDriver(2000);

        try
        {
            genericfunctions.waitForPageToLoad(homepageobjects.activity_text.get(0));
            actualTextPost=homepageobjects.activity_text.get(0).getText().trim();
            genericfunctions.waitTillTheElementIsVisible(homepageobjects.activity_text.get(0));
            Assert.assertTrue(actualTextPost.equals(expectedTextPost));
            ExtentTestManager.getTest().log(LogStatus.PASS,  " Expected :: \" RePost\" should be displayed as :: "
                    + " \"<b>" + expectedTextPost +"\"   </b> ; Actual :: \" RePost\" is displayed as :: " + " \"<b>" + actualTextPost +"\"   </b>");
        }
        catch(Throwable e)
        {
            String actualException=e.getClass().getName();

            switch (actualException)
            {
                case "java.lang.NoSuchElementException":
                    Assert.fail(actualException +"Expected :: \"Created Post \" should be displayed ; Actual :: \"Created Post \" is not displayed" + "&" + e.getMessage() + "");
                    break;
                case "java.lang.AssertionError":
                    Assert.fail(actualException + " " + " Expected :: \" Created Text Post\" should be displayed as :: "
                            + " \"<b>" + expectedTextPost +"\"   </b> ; Actual :: \" Created Text Post\" is displayed as :: " + " \"<b>" + actualTextPost +"\"   </b>"  + "&" + e.getMessage() + "");
                    break;
                default:
                    Assert.fail(actualException+ "&"  + e.getMessage() + "");
            }
        }
    }

    public void verifyDisplayOfBoostedTextPost(String... strings)
    {
        ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " ::  Boosted Post is Displayed or not");
        String expectedTextPost = strings[1].trim();
        String actualTextPost = null;
        genericfunctions.waitWebDriver(2000);

        try
        {
            genericfunctions.waitForPageToLoad(homepageobjects.activity_text.get(0));
            actualTextPost=homepageobjects.activity_text.get(0).getText().trim();
            genericfunctions.waitTillTheElementIsVisible(homepageobjects.activity_text.get(0));
            Assert.assertTrue(actualTextPost.equals(expectedTextPost));
            ExtentTestManager.getTest().log(LogStatus.PASS,  " Expected :: \" Created Text Post\" should be displayed as :: "
                    + " \"<b>" + expectedTextPost +"\"   </b> ; Actual :: \" Created Text Post\" is displayed as :: " + " \"<b>" + actualTextPost +"\"   </b>");
        }
        catch(Throwable e)
        {
            String actualException=e.getClass().getName();

            switch (actualException)
            {
                case "java.lang.NoSuchElementException":
                    Assert.fail(actualException +"Expected :: \"Created Post \" should be displayed ; Actual :: \"Created Post \" is not displayed" + "&" + e.getMessage() + "");
                    break;
                case "java.lang.AssertionError":
                    Assert.fail(actualException + " " + " Expected :: \" Created Text Post\" should be displayed as :: "
                            + " \"<b>" + expectedTextPost +"\"   </b> ; Actual :: \" Created Text Post\" is displayed as :: " + " \"<b>" + actualTextPost +"\"   </b>"  + "&" + e.getMessage() + "");
                    break;
                default:
                    Assert.fail(actualException+ "&"  + e.getMessage() + "");
            }
        }
    }
    public void verifyContentsOfBoostedPost(String... strings) {
        ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " :: All the  contents in Bookmarked post section with following assertion :");

        verifyDisplayOfBoostedUserProfileName();
        verifyDispalyOfBoostedUserProfileName();
        verifyDisplayOfBoostedButton();


    }

    public void verifyDisplayOfBoostedUserProfileName(String... strings) {

        try {
            genericfunctions.waitTillTheElementIsVisible(postcardobjects.boosted_post_profile_img.get(0));
            Assert.assertTrue(postcardobjects.boosted_post_profile_img.get(0).isDisplayed());
            ExtentTestManager.getTest().log(LogStatus.PASS, " " + " \" User profile Name\" is displaying");

        } catch (Exception e) {
            Assert.fail("Expected :: \" User profile Name\" should be displayed  ; Actual ::  \" User profile Name\" is not displayed" + "&" + e.getMessage() + "");
        }

    }
    public void verifyDispalyOfBoostedUserProfileName(String... strings) {

        try {
            genericfunctions.waitTillTheElementIsVisible(postcardobjects.boosted_post_profile_name.get(0));
            Assert.assertTrue(postcardobjects.boosted_post_profile_name.get(0).isDisplayed());
            ExtentTestManager.getTest().log(LogStatus.PASS, " " + " \" User profile Image\" is displaying");

        } catch (Exception e) {
            Assert.fail("Expected :: \" User profile Image\" should be displayed  ; Actual ::  \" User profile Image\" is not displayed" + "&" + e.getMessage() + "");
        }

    }
    public void verifyDisplayOfBoostedButton(String... strings) {

        try {
            genericfunctions.waitTillTheElementIsVisible(postcardobjects.boosted_post_boosted_button.get(0));
            Assert.assertTrue(postcardobjects.boosted_post_boosted_button.get(0).isDisplayed());
            ExtentTestManager.getTest().log(LogStatus.PASS, " " + " \" User profile Name\" is displaying");

        } catch (Exception e) {
            Assert.fail("Expected :: \" User profile Name\" should be displayed  ; Actual ::  \" User profile Name\" is not displayed" + "&" + e.getMessage() + "");
        }

    }


}
