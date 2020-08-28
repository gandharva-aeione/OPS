package com.aeione.ops.pageactions;

import com.aeione.ops.generic.DriverManager;
import com.aeione.ops.generic.ExtentTestManager;
import com.aeione.ops.generic.GenericFunctions;
import com.aeione.ops.pageobjects.HomePageObjects;
import com.aeione.ops.pageobjects.LoginPageObjects;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import java.io.IOException;

import static com.aeione.ops.generic.IAutoConst.HOMEURL;


public class HomePageActions
{

    GenericFunctions genericfunctions;
    LoginPageObjects loginpageobjects = new LoginPageObjects();
    HomePageObjects homepageobjects = new HomePageObjects();
    GenericPageActions genericPageActions=new GenericPageActions();
    Actions actions = null;
    Select selectdropdownOption=null;


    public HomePageActions() throws IOException {
        genericfunctions = new GenericFunctions(DriverManager.getDriver());
        PageFactory.initElements(DriverManager.getDriver(), this);
        PageFactory.initElements(DriverManager.getDriver(), loginpageobjects);
        PageFactory.initElements(DriverManager.getDriver(), homepageobjects);
        PageFactory.initElements(DriverManager.getDriver(), genericPageActions);
        actions = new Actions(DriverManager.getDriver());
    }

    /////////////////////////// Page Actions //////////////////////////////////


    public void navigateHomePage()
    {
        genericfunctions.waitWebDriver(2000);
        DriverManager.getDriver().get(HOMEURL);
    }

    public void clickOnTopBarDropdown(String... strings)
    {
        ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " :: Click on topBar Dropdown ");

        try
        {
            genericfunctions.waitTillTheElementIsVisible(homepageobjects.topbar_dropdown);
            genericfunctions.waitForPageToLoad(homepageobjects.topbar_dropdown);

            homepageobjects.topbar_dropdown.click();
        }
        catch (Throwable e)
        {
            Assert.fail("Could not perform action on \"topBar Dropdown\""+"&"+e.getMessage()+"" );
        }
    }

    public void clickOnSignOut(String... strings)
    {
        ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " :: Click on SignOut");
        try
        {
            genericfunctions.waitTillTheElementIsVisible(homepageobjects.topbar_dropdown_signout);
            homepageobjects.topbar_dropdown_signout.click();
        }
        catch (Throwable e)
        {
            Assert.fail("Could not perform action on \"Signout button\""+"&"+e.getMessage()+"" );

        }
    }

    /**
     * Attach_File_Image_Audio_Video
     * Author:- Gandahrva
     */
    public void attachFile(String...strings)
    {
        ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " :: Click on Upload Media File");
        String file=strings[1];
        try
        {
            genericfunctions.waitWebDriver(2000);
            DriverManager.getDriver().findElement(By.id("file")).sendKeys(file);
            ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " :: Media File Uploaded Successfully");
        }
        catch (Throwable e)
        {
            Assert.fail("Could not perform action on \"Uploading Media File\" "+"&"+e.getMessage()+"" );
        }
    }

    /**
     * Blog Creation: Click on Blog Icon
     * Author:- Gandahrva
     *
     */
    public void clickOnBlogIcon(String... strings)
    {
        ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " :: Click on Blog Icon ");
        try
        {
            genericfunctions.waitTillTheElementIsVisible(homepageobjects.topbar_blog);
            homepageobjects.topbar_blog.click();
            actions.moveToElement(homepageobjects.topbar_blog).doubleClick(homepageobjects.topbar_blog).build().perform();
        }
        catch (Throwable e)
        {
            Assert.fail("Could not perform action on \"Blog Icon\" "+"&"+e.getMessage()+"" );
        }
    }

    /**
     * Enter Title
     * Author:- Gandahrva
     */
    public  void enterBlogTitle(String ...strings)
    {
        String title = strings[1];
        ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] +  ":: Enter the Blog Title as " + "\"<b>" + title +"\"   </b>");

        try
        {
            genericfunctions.waitTillTheElementIsVisible(homepageobjects.blog_title);
            genericfunctions.waitWebDriver(1000);
            homepageobjects.blog_title.sendKeys(title);
        }
        catch (Throwable e)
        {
            Assert.fail("Could not found the Blog Title Element "+"&"+e.getMessage()+"");
        }
    }

    /**
     * Preview_Publish_Button
     * Author:-Gandahrva
     */
    public  void clickOnPreviewPublishButton(String ...strings)
    {
        ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " :: Click on Preview Publish Button ");
        try
        {
            genericfunctions.waitForPageToLoad(homepageobjects.blog_preview_publish_button);
            genericfunctions.waitTillTheElementIsVisible(homepageobjects.blog_preview_publish_button);
            homepageobjects.blog_preview_publish_button.click();

                try
                {
                    genericfunctions.waitTillTheElementIsVisible(homepageobjects.blog_title_error);
                    Assert.fail("Create Blog Failed Due to <b><font color=red>\"" +homepageobjects.blog_title_error.getText() + "\"</font></b>");
                }
                catch(Exception e)
                {
                }
        }
        catch (Exception e)
        {
            Assert.fail("Could not perform action on Preview Publish Button"+"&"+e.getMessage()+"" );
        }
    }

    /**
     * Publish_Blog_Button
     * Author:- Gandahrva
     */
    public void clickOnPublishNowButton(String... strings)
    {
        ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " ::  Click On Publish Now Button");

        try
        {
            genericfunctions.waitTillTheElementIsVisible(homepageobjects.blog_publish_button);
            genericfunctions.waitWebDriver(2000);
            homepageobjects.blog_publish_button.click();
        }
        catch (Throwable e)
        {
            Assert.fail("Could not perform action on Publish Now Button"+"&"+e.getMessage()+"" );
        }
    }

    /**
     * Click On Home Top Bar
     * Author:- Gandahrva
     */
    public void clickOnHomeTopBar(String... strings)
    {
        ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " ::  Click On Home TopBar");

        try
        {
            genericfunctions.waitTillTheElementIsVisible(homepageobjects.topbar_home);
            genericfunctions.waitWebDriver(2000);
            homepageobjects.topbar_home.click();
        }
        catch (Throwable e)
        {
            Assert.fail(""+"&"+e.getMessage()+"" );
        }
    }

    /**
     * Enter Text
     * Gandahrva
     */
    public void enterTextOnMessageTextArea(String... strings)
    {
        String message = strings[1].trim();
        String entered_text=null;
        try
        {
            ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " :: Enter text on Message Text Area as :: "+ " \"<b>" + message +"\"   </b>");
            genericfunctions.waitTillTheElementIsVisible(homepageobjects.message_textarea);
            homepageobjects.message_textarea.sendKeys(message);
            //Need to clarify with DEv
//            genericfunctions.waitTillTheElementIsVisible(homepageobjects.message_textarea);
//            entered_text=homepageobjects.message_textarea.getText().trim();
//            Assert.assertTrue(entered_text.equals(message));
        }
        catch (Throwable e)
        {
            String actualException=e.getClass().getName();

            switch (actualException)
            {
                case "java.lang.NoSuchElementException":
                    Assert.fail("Could not perform action on \"Message Text Area\""+"&"+e.getMessage()+"" );
                    break;
                case "java.lang.AssertionError":
                    Assert.fail("Expected :: Post text should be entered as   <b>\"" + message+ "\"</b> ; Actual :: Post text is entered as <b>\"" + entered_text + "\"</b> " + "&" + genericPageActions.defectId("1696"));
                    break;
                default:
                    Assert.fail(""+"&"+e.getMessage()+"");
            }
        }
    }

    /**
     * Click on Publish Post Button
     * Gandahrva
     */
    public void clickOnPostButton(String... strings) {
        ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " :: Click on Post Button");
        try
        {
            genericfunctions.waitWebDriver(3000);
            genericfunctions.waitForPageToLoad(homepageobjects.post_button);
            genericfunctions.waitTillTheElementIsVisible(homepageobjects.post_button);
            homepageobjects.post_button.click();
        }
        catch (Exception e)
        {
            Assert.fail("Could not perform action on \"Post Button\""+"&"+e.getMessage()+"" );
        }
    }

    /**
     * Click on Messenger Pop Up
     * Author:- Gandahrva
     */
    public void clickOnMessengerPopUp(String... strings)
    {
        ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " ::Click on Messenger PopUp");
        try
        {
            genericfunctions.waitTillTheElementIsVisible(homepageobjects.messenger_pop_up);
            homepageobjects.messenger_pop_up.click();
            ExtentTestManager.getTest().log(LogStatus.INFO, "" + strings[0]  + "::Clicked On Messenger PopUp");

        }
        catch (Throwable e)
        {
            Assert.fail("Could not perform an action"+"&"+e.getMessage());
        }
    }





    //////////////////////////////////////// Page Verification //////////////////////////////////

    /**
     * Verify Home Page Contents
     * Author:- Gandahrva
     */
    public void verifyContentsOfHomePageTests(String... strings)
    {

        ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " :: Contents of Home Page with following assertion :");

        verifyDisplayOfHomeTopbar(strings[0]);
        verifyDisplayOfExporeTopbar(strings[0]);
        verifyDisplayOfWalletTopbar(strings[0]);
        verifyDisplayOfSearchTopbar(strings[0]);
        verifyDisplayOfBlogTopbar(strings[0]);
        verifyDisplayOfNetworkTopbar(strings[0]);
        verifyDisplayOfNotificationTopbar(strings[0]);
        verifyDisplayOfGroupTopbar(strings[0]);
        verifyDisplayOfProfileIconTopbar(strings[0]);
        verifyDisplayOfHomeProfileWidget(strings[0]);
        verifyDisplayOfTextAreaWidget(strings[0]);
    }

    /**
     * Verify Home Top Bar
     * Author:- Gandahrva
     */
    public void verifyDisplayOfHomeTopbar(String... strings)
    {
        try
        {
            genericfunctions.waitTillTheElementIsVisible(homepageobjects.topbar_home);
            Assert.assertTrue(homepageobjects.topbar_home.isDisplayed());
            ExtentTestManager.getTest().log(LogStatus.PASS, "" +strings[0]+ "::  \"topbar home\" is displayed");

        } catch (Throwable e)
        {
            Assert.fail("Expected :: \"topbar home \" should be displayed ; Actual :: \"topbar home\" is not displayed"+"&"+e.getMessage()+"");
        }
    }

    /**
     * Verify Explore Top Bar
     * Author:- Gandahrva
     */
    public void verifyDisplayOfExporeTopbar(String... strings)
    {
        try
        {
            genericfunctions.waitTillTheElementIsVisible(homepageobjects.topbar_explore);
            Assert.assertTrue(homepageobjects.topbar_explore.isDisplayed());
            ExtentTestManager.getTest().log(LogStatus.PASS, ""+strings[0]+ ":: \"topbar explore\" is displayed");
        }
        catch (Exception e)
        {
            Assert.fail("Expected :: \"topbar explore \"  should be displayed ; Actual :: \"topbar explore\"  is not displayed"+"&"+e.getMessage()+"");
        }
    }

    /**
     * Verify Wallet Top Bar
     * Author:- Gandahrva
     */
    public void verifyDisplayOfWalletTopbar(String... strings)
    {
        try
        {
            genericfunctions.waitTillTheElementIsVisible(homepageobjects.topbar_wallet);
            Assert.assertTrue(homepageobjects.topbar_wallet.isDisplayed());
            ExtentTestManager.getTest().log(LogStatus.PASS, ""+strings[0]+ ":: \"topbar wallet\"  is displayed");
        }
        catch (Throwable e)
        {
            Assert.fail("Expected :: \"topbar wallet \"   should be displayed ;" +
                    " Actual :: \"topbar wallet\"  is not displayed"+"&"+e.getMessage()+"");
        }
    }

    /**
     * Verify Search Top Bar
     * Author:- Gandahrva
     */
    public void verifyDisplayOfSearchTopbar(String... strings)
    {
        try
        {
            genericfunctions.waitTillTheElementIsVisible(homepageobjects.topbar_search);
            Assert.assertTrue(homepageobjects.topbar_search.isDisplayed());
            ExtentTestManager.getTest().log(LogStatus.PASS, ""+strings[0]+ "::\"topbar search\"  is displayed");
        }
        catch (Throwable e)
        {
            Assert.fail("Expected :: \"topbar search \"   should be displayed ;" +
                    " Actual :: \"topbar search\"  is not displayed"+"&"+e.getMessage()+"");
        }
    }

    /**
     * Verify Blog Top Bar
     * Author:- Gandahrva
     */
    public void verifyDisplayOfBlogTopbar(String... strings)
    {
        try
        {
            genericfunctions.waitTillTheElementIsVisible(homepageobjects.topbar_blog);
            Assert.assertTrue(homepageobjects.topbar_blog.isDisplayed());
            ExtentTestManager.getTest().log(LogStatus.PASS, ""+strings[0]+ "::\"Blog Icon\" is displayed");
        } catch (Exception e)
        {
            Assert.fail("Expected :: \"topbar blog \"   should be displayed ;" +
                    " Actual :: \"topbar blog\"  is not displayed"+"&"+e.getMessage()+"");
        }
    }

    /**
     * Verify NetWork Top Bar
     * Author:- Gandahrva
     */
    public void verifyDisplayOfNetworkTopbar(String... strings)
    {
        try
        {
            genericfunctions.waitTillTheElementIsVisible(homepageobjects.topbar_network);
            Assert.assertTrue(homepageobjects.topbar_network.isDisplayed());
            ExtentTestManager.getTest().log(LogStatus.PASS, ""+strings[0]+ ":: \"topbar network\" is displayed");
        } catch (Exception e)
        {
            Assert.fail("Expected :: \"topbar network \"  should be displayed  ;" +
                    " Actual :: \"topbar network\"   is not displayed"+"&"+e.getMessage()+"");
        }
    }

    /**
     * Verify Notification Top Bar
     * Author:- Gandahrva
     */
    public void verifyDisplayOfNotificationTopbar(String... strings)
    {
        try
        {
            genericfunctions.waitTillTheElementIsVisible(homepageobjects.topbar_bell);
            Assert.assertTrue(homepageobjects.topbar_bell.isDisplayed());
            ExtentTestManager.getTest().log(LogStatus.PASS, ""+strings[0]+ ":: \"topbar notification\" is displayed");
        }
        catch (Throwable e)
        {
            Assert.fail("Expected :: \"topbar notification \" should be displayed  ; " +
                    "Actual :: \"topbar notification\" is not displayed"+"&"+e.getMessage()+"");
        }

    }

    /**
     * Verify Group Top Bar
     * Author:- Gandahrva
     */
    public void verifyDisplayOfGroupTopbar(String... strings)
    {
        try
        {
            genericfunctions.waitTillTheElementIsVisible(homepageobjects.topbar_group);
            Assert.assertTrue(homepageobjects.topbar_group.isDisplayed());
            ExtentTestManager.getTest().log(LogStatus.PASS, ""+strings[0]+ ":: \"topbar group\" is displayed");
        }
        catch (Throwable e)
        {
            Assert.fail("Expected :: \"topbar group \"   should be displayed  ; " +
                    "Actual :: \"topbar group\"  is not displayed"+"&"+e.getMessage()+"");
        }
    }

    /**
     * Verify Profile_Icon_Image Top Bar
     * Author:- Gandahrva
     */
    public void verifyDisplayOfProfileIconTopbar(String... strings)
    {
        try
        {
            genericfunctions.waitTillTheElementIsVisible(homepageobjects.topbar_dropdown);
            Assert.assertTrue(homepageobjects.topbar_dropdown.isDisplayed());
            ExtentTestManager.getTest().log(LogStatus.PASS, ""+strings[0]+ ":: \"topbar ProfileIcon\"  is displayed");
        }
        catch (Throwable e)
        {
            Assert.fail("Expected :: \"topbar ProfileIcon \"  should be displayed  ;" +
                    " Actual :: \"topbar ProfileIcon\"  is not displayed" +"&"+e.getMessage()+"");
        }

    }

    /**
     * Verify Home_Page_Profile_Widget
     * Author:- Gandahrva
     */
    public void verifyDisplayOfHomeProfileWidget(String... strings)
    {
        try
        {
            genericfunctions.waitTillTheElementIsVisible(homepageobjects.home_profile_widget);
            Assert.assertTrue(homepageobjects.home_profile_widget.isDisplayed());
            ExtentTestManager.getTest().log(LogStatus.PASS, ""+strings[0]+ ":: \" ProfileWidget\" is displayed");
        }
        catch (Throwable e)
        {
            Assert.fail("Expected :: \"ProfileWidget \" should be displayed  ;" +
                    " Actual :: \" ProfileWidget\" is not displayed"+"&"+e.getMessage()+"");
        }
    }

    /**
     * Verify Home_Page_Text_Area_Widget
     * Author:- Gandahrva
     */
    public void verifyDisplayOfTextAreaWidget(String... strings)
    {
        try
        {
            genericfunctions.waitTillTheElementIsVisible(homepageobjects.poster_textarea);
            Assert.assertTrue(homepageobjects.poster_textarea.isDisplayed());
            ExtentTestManager.getTest().log(LogStatus.PASS, ""+strings[0]+ ":: \"  text area poster\"   is displayed");
        }
        catch (Throwable e)
        {
            Assert.fail("Expected :: \" TextArea Poster \" widget should be displayed  ;" +
                    " Actual :: \" text area poster\" widget is not displayed"+"&"+e.getMessage()+"");
        }

    }
//-----------------Home_Page_Contents_Of_Profile_Card---------------------

    /**
     * Verify Contents_Of_Home_Page_Profile_Card
     * Author:- Gandahrva
     */
    public void verifyContentsOfProfileCardInHomePage(String... strings)
    {
        ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " :: Contents of Home Page Profile card with following assertion :");

        verifyDispalyOfProfileImage(strings[0]);
        verifyDisplayOfProfileName(strings[0]);
        verifyDisplayOfAccountName(strings[0]);
        verifyDisplayOfFollowersCount(strings[0]);
        verifyDisplayOfFollowingCount(strings[0]);
        verifyDisplayOfPostCount(strings[0]);
        verifyDisplayOfCommunityLink(strings[0]);
        verifyDisplayOfBookmarkLink(strings[0]);

    }

    /**
     * Verify Contents_Of_Home_Page_Profile_Card_Profile_Image
     * Author:- Gandahrva
     */
    public void verifyDispalyOfProfileImage(String... strings)
    {
        try
        {
            genericfunctions.waitTillTheElementIsVisible(homepageobjects.user_profile_image);
            Assert.assertTrue(homepageobjects.user_profile_image.isDisplayed());
            ExtentTestManager.getTest().log(LogStatus.PASS, " " + strings[0] + " :: \" Profile Image\" is displayed");

        }
        catch (Throwable e)
        {
            Assert.fail("Expected :: \" Profile Image\" should be displayed  ; Actual ::  \" Profile Image\" is not displayed"+"&"+e.getMessage()+"");
            return ;
        }

    }
    /**
     * Verify Contents_Of_Home_Page_Profile_Card_ProfileName
     * Author:- Gandahrva
     */
    public void verifyDisplayOfProfileName(String... strings)
    {
        try
        {
            genericfunctions.waitTillTheElementIsVisible(homepageobjects.user_profile_fullname);
            Assert.assertTrue(homepageobjects.user_profile_fullname.isDisplayed());
            ExtentTestManager.getTest().log(LogStatus.PASS, " " + strings[0] + " :: \"Profile Full Name \" is displayed");

        } catch (Throwable e)
        {
            Assert.fail("Expected :: \"Profile Full Name \" should be displayed  ; Actual :: \"Profile Full Name \" is not displayed"+"&"+e.getMessage()+"");
        }
    }
    /**
     * Verify Contents_Of_Home_Page_Profile_Card_AccountName
     * Author:- Gandahrva
     */
    public void verifyDisplayOfAccountName(String... strings)
    {
        try
        {
            genericfunctions.waitTillTheElementIsVisible(homepageobjects.user_profile_account);
            Assert.assertTrue(homepageobjects.user_profile_account.isDisplayed());
            ExtentTestManager.getTest().log(LogStatus.PASS, " " + strings[0] + " :: \" Profile Account \" is displayed");

        } catch (Exception e)
        {
            Assert.fail("Expected :: \" Profile Account \" should be displayed  ; Actual :: \" Profile Account \" is not displayed"+"&"+e.getMessage()+"");
        }

    }

    /**
     * Verify Contents_Of_Home_Page_Profile_Card_Follower
     * Author:- Gandahrva
     */
    public void verifyDisplayOfFollowersCount(String... strings)
    {
        try
        {
            genericfunctions.waitTillTheElementIsVisible(homepageobjects.user_profile_follower_count);
            Assert.assertTrue(homepageobjects.user_profile_follower_count.isDisplayed());
            ExtentTestManager.getTest().log(LogStatus.PASS, " " + strings[0] + " :: \" Profile Follower \"   is displayed");

        } catch (Throwable e)
        {
            Assert.fail("Expected :: \" Profile Follower \"  should be displayed  ; Actual :: \" Profile Follower \" is not displayed"+"&"+e.getMessage()+"");
        }
    }

    /**
     * Verify Contents_Of_Home_Page_Profile_Card_Following
     * Author:- Gandahrva
     */
    public void verifyDisplayOfFollowingCount(String... strings)
    {
        try
        {
            genericfunctions.waitTillTheElementIsVisible(homepageobjects.user_profile_following_count);
            Assert.assertTrue(homepageobjects.user_profile_following_count.isDisplayed());
            ExtentTestManager.getTest().log(LogStatus.PASS, " " + strings[0] + " :: \"  Profile Following\"   is displayed");

        } catch (Throwable e)
        {
            Assert.fail("Expected :: \" Profile Following \"  should be displayed  ; Actual :: \" Profile Following \" is not displayed"+"&"+e.getMessage()+"");
        }

    }

    /**
     * Verify Contents_Of_Home_Page_Profile_Card_Post_Count
     * Author:- Gandahrva
     */
    public void verifyDisplayOfPostCount(String... strings)
    {
        try
        {
            genericfunctions.waitTillTheElementIsVisible(homepageobjects.user_profile_post_count);
            Assert.assertTrue(homepageobjects.user_profile_post_count.isDisplayed());
            ExtentTestManager.getTest().log(LogStatus.PASS, " " + strings[0] + " :: \" Profile Post Count \" is displayed");

        } catch (Throwable e)
        {
            Assert.fail("Expected :: \" Profile Post Count \" should be displayed  ; Actual :: \" Profile Post Count \" is not displayed"+"&"+e.getMessage()+"");
        }
    }
    /**
     * Verify Contents_Of_Home_Page_Community_Link
     * Author:- Gandahrva
     */
    public  void verifyDisplayOfCommunityLink(String... strings)
    {
        try
        {
            genericfunctions.waitTillTheElementIsVisible(homepageobjects.newsfeed_community_link);
            Assert.assertTrue(homepageobjects.newsfeed_community_link.isDisplayed());
            ExtentTestManager.getTest().log(LogStatus.PASS, " " + strings[0] + " :: \" Community Link\" is displayed");

        } catch (Exception e)
        {
            Assert.fail("Expected :: \" Community Link \" should be displayed  ; Actual :: \" Community link\" is not displayed"+"&"+e.getMessage()+"");
        }
    }

    /**
     * Verify Contents_Of_Home_Page_Bookmark_Link
     * Author:- Gandahrva
     */
    public void verifyDisplayOfBookmarkLink(String... strings)
    {
        try
        {
            genericfunctions.waitTillTheElementIsVisible(homepageobjects.newsfeed_bookmark_link);
            Assert.assertTrue(homepageobjects.newsfeed_bookmark_link.isDisplayed());
            ExtentTestManager.getTest().log(LogStatus.PASS, " " + strings[0] + " :: \" Bookmark Link\" is displayed");

        } catch (Throwable e)
        {
            Assert.fail("Expected :: \" Bookmark Link \" should be displayed  ; Actual :: \" Bookmark link\" is not displayed"+"&"+e.getMessage()+"");
        }
    }

    /**
     * Publish Blog Inner Page
     * Author:- Gandahrva
     */
    public void verifyPublishedBlogInnerPage(String... strings)
    {
        ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " ::  Published Blog Under Blog Inner Page");
        String exceptedBlogName= strings[1];
        String actualBlogName=null;
        try
        {
            genericfunctions.waitWebDriver(1000);
            actualBlogName =homepageobjects.blog_title_name.getText().trim();
            genericfunctions.waitTillTheElementIsVisible(homepageobjects.blog_title_name);
            Assert.assertTrue(actualBlogName.equals(exceptedBlogName));
            ExtentTestManager.getTest().log(LogStatus.PASS, "Expected :: \"Published Blog Name\" should be displayed as :: "
                    + " " + "<b>"  + exceptedBlogName + "</b>" + " ; Actual :: \"Published Blog Name\" is displayed as :: " + " " + "<b>" +actualBlogName+ "</b>" + "");
        }
        catch(Throwable e)
        {
            String actualException=e.getClass().getName();

            switch (actualException)
            {
                case "java.lang.NoSuchElementException":
                    Assert.fail("Expected :: \"Published Blog \" should be displayed ; Actual :: \"Published Blog \" is not displayed"+"&"+e.getMessage()+"" );
                    break;
                case "java.lang.AssertionError":
                    Assert.fail("Expected :: \"Published Blog \" should be displayed as " + " " + "<b>" + exceptedBlogName + "</b>"
                            + " ; Actual :: \"Published Blog \" is displayed as" + " " + "<b>" +actualBlogName+ " " + "<b>" +"");
                    break;
                default:
                    Assert.fail(""+"&"+e.getMessage()+"");
            }
        }
    }

    //---------------------------Verify_Published Blog On TimeLine-----------------------------
    /**
     * Verify_Contents_Of_Published_Blog
     * Author:- Gandahrva
     */
    public void verifyDisplayOfPublishedBlogOnHomeNewsfeed(String... strings)
    {
        ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] +
                " :: Published Blog Post is displaying or not in HomePage with following assertion:");
        String expectedBlogName = strings[1].trim();

        String actualBlogName= null;

        try
        {
            genericfunctions.waitTillTheElementIsVisible(homepageobjects.blog_name.get(0));
            actualBlogName=homepageobjects.blog_name.get(0).getText().trim();
            System.out.println("ActualName:="+actualBlogName);

            Assert.assertTrue(actualBlogName.equals(expectedBlogName));
            ExtentTestManager.getTest().log(LogStatus.PASS, "Expected :: \"Published Blog Name\" should be displayed as :: "
                    + " " + "<b>"  + expectedBlogName + "</b>" + " ; Actual :: \"Published Blog Name\" is displayed as :: " + " " + "<b>" +actualBlogName+ "</b>" + "");

        }
        catch(Throwable e)
        {
            String actualException=e.getClass().getName();

            switch (actualException)
            {
                case "java.lang.NoSuchElementException":
                    Assert.fail("Expected :: \"Published Blog Name\" should be displayed ; Actual ::\"Published Blog Name\" is not displayed"+"&"+e.getMessage()+"" );
                    break;
                case "java.lang.AssertionError":
                    Assert.fail("Expected :: \"Published Blog Name\" should be displayed as :: " + " " + "<b>" + expectedBlogName + " " + "</b>" +
                            " ; Actual :: \"Published Blog Name\" is displayed as :: " + " " + "<b>" +actualBlogName+ " " + "</b>" + "");
                    break;
                default:
                    Assert.fail(""+"&"+e.getMessage()+"");
            }
        }

    }


    //----------Verify_Contents_Of_Suggestion_List--------------------------------

    /**
     * Verify_Contents_Of_Suggestion_List
     * Author:- Gandahrva
     */
    public void verifySuggestedWidget(String... strings)
    {
        ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " :: Suggested Widget is Displaying or Not with following assertion :");
        try
        {
            genericfunctions.waitForPageToLoad(homepageobjects.suggested_widget);
            Assert.assertTrue(homepageobjects.suggested_widget.isDisplayed());
            ExtentTestManager.getTest().log(LogStatus.PASS, ""+strings[0]+ ":: \"Suggestion Widget\" is displayed");
        }
        catch (Throwable e)
        {
            Assert.fail("Could not found \"Suggestion Widget\"" + "&" + e.getMessage() + "");
        }
    }

    /**
     * Verify_Contents_Of_Suggestion_List
     * Author:- Gandahrva
     */
    public void verifyContentsOfSuggestionSection(String... strings)
    {
        ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " :: Contents of Suggested List card with following assertion :");

        verifyDispalyOfSuggestedProfileImage(strings[0]);
        verifyDispalyOfSuggestedProfileName(strings[0]);
        verifyDispalyOfSuggestedProfileAccountName(strings[0]);
        verifyDispalyOfSuggestedProfileFollowButton(strings[0]);
    }

    /**
     * Verify_Contents_Of_Suggestion_List_Profile_Image
     * Author:- Gandahrva
     */
    public void verifyDispalyOfSuggestedProfileImage(String... strings)
    {
        try
        {
            genericfunctions.waitTillTheElementIsVisible(homepageobjects.suggested_user_profile_image);
            Assert.assertTrue(homepageobjects.suggested_user_profile_image.isDisplayed());
            ExtentTestManager.getTest().log(LogStatus.PASS, " " + strings[0] + ":: \"  Suggested User Profile Image \" is displayed");

        } catch (Throwable e)
        {
            Assert.fail("Expected ::\"  Suggested User Profile Image \" should be displayed  ; " +
                    "Actual :: \"  Suggested User Profile Image \" is not displayed"+"&"+e.getMessage()+"");
        }
    }

    /**
     * Verify_Contents_Of_Suggestion_List_Profile_Name
     * Author:- Gandahrva
     */
    public void verifyDispalyOfSuggestedProfileName(String... strings)
    {
        try
        {
            genericfunctions.waitTillTheElementIsVisible(homepageobjects.suggested_user_profile_name);
            Assert.assertTrue(homepageobjects.suggested_user_profile_name.isDisplayed());
            ExtentTestManager.getTest().log(LogStatus.PASS, " " + strings[0] + ":: \" Suggested User Profile Name \" is displayed");

        } catch (Exception e)
        {
            Assert.fail("Expected :: \" Suggested User Profile Name \" should be displayed  ;" +
                    " Actual :: \" Suggested User Profile Name \" is not displayed"+"&"+e.getMessage()+"");
        }
    }

    /**
     * Verify_Contents_Of_Suggestion_List_Account_Name
     * Author:- Gandahrva
     */
    public void verifyDispalyOfSuggestedProfileAccountName(String... strings)
    {
        try
        {
            genericfunctions.waitTillTheElementIsVisible(homepageobjects.suggested_user_username);
            Assert.assertTrue(homepageobjects.suggested_user_username.isDisplayed());
            ExtentTestManager.getTest().log(LogStatus.PASS, " " + strings[0] + ":: \" Suggested User Profile Account Name \" is displayed");

        } catch (Throwable e)
        {
            Assert.fail("Expected :: \" Suggested User Profile Account Name \" should be displayed  ; " +
                    "Actual :: \" Suggested User Profile Account Name \" is not displayed"+"&"+e.getMessage()+"");
        }
    }

    /**
     * Verify_Contents_Of_Suggestion_List_Follow_Button
     * Author:- Gandahrva
     */
    public void verifyDispalyOfSuggestedProfileFollowButton(String... strings)
    {
        try
        {
            genericfunctions.waitTillTheElementIsVisible(homepageobjects.suggested_user_follow_Button);
            Assert.assertTrue(homepageobjects.suggested_user_follow_Button.isDisplayed());
            ExtentTestManager.getTest().log(LogStatus.PASS,  " " + strings[0] + ":: \" Suggested User Profile Follow Button \" is displayed");

        } catch (Throwable e)
        {
            Assert.fail("Expected :: \" Suggested User Profile Follow Button \" should be displayed  ;" +
                    " Actual :: \" Suggested User Profile Follow Button \" is not displayed" +"&"+e.getMessage()+"");
        }
    }

    /**
     * Follow User Functionality
     * Gandahrva
     */
    public String clickOnFollowButton(String... strings)
    {
        ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " :: Click on Follow Button");
        String exceptedFollowedUser= null;
        try
        {
            genericfunctions.waitTillTheElementIsVisible(homepageobjects.suggested_user_follow_Button);
            exceptedFollowedUser=homepageobjects.suggested_user_profile_name.getText().trim();
            homepageobjects.suggested_user_follow_Button.click();
            ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " :: Followed User Name ::" + " " + "<b>"+ exceptedFollowedUser+"<b>");
            // verifyFollowedUser("Verify Step",exceptedFollowedUser);
        }
        catch (Throwable e)
        {
            Assert.fail("Could not perform action on"+"&"+e.getMessage()+"" );
        }
        return exceptedFollowedUser;
    }

    //---------------Verify_Followed_User-----------------------------------

    /**
     * Verify_Contents_Of_Follow_User_Funtionality
     * Author:- Gandahrva
     */
    public void verifyFollowedUser(String... strings)
    {
        String exceptedFollowedUser = strings[1];
        String actualFollowedUser= null;
        genericfunctions.waitWebDriver(2000);


        try
        {
            ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " ::  Followed User Name has displayed or not");
            actualFollowedUser = homepageobjects.suggested_user_profile_name.getText().trim();
            genericfunctions.waitTillTheElementIsVisible(homepageobjects.suggested_user_profile_name);
            ExtentTestManager.getTest().log(LogStatus.PASS, "New Suggested User Name :: "  + " " + "<b>" + actualFollowedUser +  " " + "</b>" + "");
            Assert.assertTrue(actualFollowedUser.equals(exceptedFollowedUser));
            ExtentTestManager.getTest().log(LogStatus.PASS, "Expected :: \" Followed User Name \" should be displayed as "
                    + " :: " + "<b>" + exceptedFollowedUser + " " + "</b>" + " ; Actual :: \"Follow User Name\" is displayed as" +
                    ":: " + "<b>" + actualFollowedUser + " " + "<b>" + "");
        }
        catch(Throwable e)
        {
            String actualException=e.getClass().getName();
            switch (actualException)
            {
                case "java.lang.NoSuchElementException":
                    Assert.fail("Expected :: \"Followed User Name \"  should be displayed ; Actual :: \"Follow User Name\" is not displayed"+"&"+e.getMessage()+"" );
                    break;
                case "java.lang.AssertionError":
                    Assert.fail("Expected :: \"Followed User Name \" should be displayed as" + " " + "<b>" + exceptedFollowedUser + " " + "</b>" +
                            " ; Actual :: \"Follow User Name\" is not displayed" + " " + "<b>" +actualFollowedUser+ " " + "</b>" + "" +"&"+e.getMessage()+"");
                    break;
                default:
                    Assert.fail(""+"&"+e.getMessage()+"");
            }
        }

    }

    /**
     * Verify_Contents_Of_UnFollow_User_Funtionality
     * Author:- Gandahrva
     */
    public void verifyDisplayOfUnfolloButton(String... strings)
    {
        ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " :: User has Followed or not");
        try
        {
            genericfunctions.waitForPageToLoad(homepageobjects.suggested_user_unfollow_button);
            Assert.assertTrue(homepageobjects.suggested_user_unfollow_button.isDisplayed());
            ExtentTestManager.getTest().log(LogStatus.PASS, ""+strings[0]+ ":: \"UnFollow\" Button has displayed");
        }
        catch (Throwable e)
        {
            Assert.fail("Could not found \"Unfollow Button\"" + "&" + e.getMessage() + "");
        }
    }

    public void clickOnPosterTextArea(String... strings)
    {
        ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " :: Click on PosterText Area");
        try
        {
            genericfunctions.waitTillTheElementIsVisible(homepageobjects.poster_textarea);
            homepageobjects.poster_textarea.click();
        }
        catch (Throwable e)
        {
            Assert.fail("Could not perform action on \"Poster Text Area\""+"&"+e.getMessage()+"" );
        }
    }



    /**
     * Verify_Uploaded_Thumbnail_On_TextArea
     * Author:- Gandahrva
     */
    public void verifyDisplayOfUploadedThumbnail(String... strings)
    {
        genericfunctions.waitWebDriver(2000);
        ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " :: Elements is Uploaded or not");

        try
        {
            genericfunctions.waitTillTheElementIsVisible(homepageobjects.upload_thumbnail);
            Assert.assertTrue(homepageobjects.upload_thumbnail.isDisplayed());
            ExtentTestManager.getTest().log(LogStatus.PASS, " \"Media Thumbnail\" is displayed");
        }
        catch (Throwable e)
        {
            Assert.fail("Could not found \"Media Thumbnail\" " + "&" + e.getMessage() + "");
        }
    }

    /**
     * Verify_Created Image Post
     * Author:- Gandahrva
     */
    public void verifyDispayOfCreatedImagePost(String... strings)
    {
        ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " :: Created Image Post is Displayed or not");
        genericfunctions.waitWebDriver(2000);
        genericfunctions.waitForPageToLoad(homepageobjects.activity_text.get(0));
        try
        {
            genericfunctions.waitTillTheElementIsVisible(homepageobjects.posted_image.get(0));
            Assert.assertTrue(homepageobjects.posted_image.get(0).isDisplayed());
            ExtentTestManager.getTest().log(LogStatus.PASS,  "\"Posted Image\" is displayed");
        }
        catch (Throwable e)
        {
            Assert.fail("Expected :: \"Posted Image \" should be displayed ; Actual ::\"Posted Image\" is not displayed"+"&"+e.getMessage()+"");
        }
    }



    /**
     * Verify_Created Text Post
     * Author:- Gandahrva
     */
    public void verifyDisplayOfCreatedTextPost(String... strings)
    {
        ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " ::  Created Text Post is Displayed or not");
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


    public void selectCategory(String... strings)
    {

        String category=strings[1];
        ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " :: Select Category from the Opportunity Categories");
        try
        {
            selectdropdownOption=new Select(homepageobjects.opportunity_category);
            selectdropdownOption.selectByValue(category);
        }
        catch (Throwable e)
        {
            Assert.fail("Could not perform an action on \"Category\" "+"&"+e.getMessage()+"" );
        }
    }

//------------------Verify_Follow_User_Post---------

    /**
     * Verify_Contents_Of_Followed_User_Post
     * Author:- Gandahrva
     */
    public void verifyDisplayOfFollowedUserPost(String... strings)
    {
        ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " :: Followed User Created Post is displaying or not in HomePage with following assertion :");

        String expectedTextPost = strings[1].trim();
        String actualTextPost=null;

        try
        {
            genericfunctions.waitWebDriver(2000);
            genericfunctions.waitForPageToLoad(homepageobjects.activity_text.get(0));
            actualTextPost=homepageobjects.activity_text.get(0).getText().trim();
            Assert.assertTrue(actualTextPost.equals(expectedTextPost));
            ExtentTestManager.getTest().log(LogStatus.PASS, "Expected :: \" Created Post\" should be displayed as" + " " + "<b>"
                    + expectedTextPost + " " + "</b>" + " ;"
                    + " Actual :: \"Created Post \" is displayed as" + " " + "<b>" +actualTextPost+ " " + "</b>" + "");
        }
        catch(Throwable e)
        {
            String actualException=e.getClass().getName();

            switch (actualException)
            {
                case "java.lang.NoSuchElementException":
                    Assert.fail("Expected :: \"Created Post \" should be displayed ; " +
                            "Actual :: \"Created Post \" is not displayed"+"&"+e.getMessage()+"" );
                    break;
                case "java.lang.AssertionError":
                    Assert.fail("Expected :: \"Created Post \" should be displayed as " + " " + "<b>" + expectedTextPost + "</b>"
                            + " ; Actual :: \"Created Post \" is displayed as" + " " + "<b>" +actualTextPost+ " " + "<b>" +"");
                    break;
                default:
                    Assert.fail(""+"&"+e.getMessage()+"");
            }
        }

    }

    /**
     * Click on_Post_Menu_Dropdown
     * Gandahrva
     */
    public void clickOnPostMenuDropdown(String... strings)
    {
        try
        {
            ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " :: Click on Post menu dropdown");
            genericfunctions.waitTillTheElementIsVisible(homepageobjects.post_menu_dropdown);
            homepageobjects.post_menu_dropdown.click();
        }
        catch (Throwable e)
        {
            Assert.fail("Could not perform action on \" Post menu dropdown\""+"&"+e.getMessage()+"" );
        }
    }

    /**
     * Click on Post Menu Dropdown_Opportunity
     * Gandahrva
     */
    public void clickOnOpportunityHashTag(String... strings)
    {
        try
        {
            ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " :: Click on Opportunity HashTag");
            genericfunctions.waitTillTheElementIsVisible(homepageobjects.post_menu_opportunity);
            homepageobjects.post_menu_opportunity.click();
        }
        catch (Throwable e)
        {
            Assert.fail("Could not perform an action on \"Opportunity HashTag\" "+"&"+e.getMessage()+"" );
        }
    }



    /**
     * Enter Opportunity Title
     * Gandahrva
     */
    public void enterOpportunityTitle(String...strings)
    {
        String title=strings[1];
        ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " :: Enter Opportunity Title as "+ "\"<b>" + title +"\"   </b>");
        try
        {
            genericfunctions.waitTillTheElementIsVisible(homepageobjects.opportunity_title);
            homepageobjects.opportunity_title.sendKeys(title);
        }
        catch (Throwable e)
        {
            Assert.fail("Could not able to enter Opportunity Title"+"&"+e.getMessage()+"" );
        }
    }

    /**
     * Enter Opportunity Description
     * Gandahrva
     */
    public void enterOpportunityDescription(String...strings)
    {
        String description=strings[1];
        ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " :: Enter Opportunity description as "+  "\"<b>" + description +"\"   </b>");
        try
        {
            genericfunctions.waitTillTheElementIsVisible(homepageobjects.opportunity_description);
            homepageobjects.opportunity_description.sendKeys(description);
        }
        catch (Throwable e)
        {
            Assert.fail("Could not able to enter Opportunity Decription"+"&"+e.getMessage()+"" );
        }
    }

    /**
     * Enter Opportunity Location
     * Gandahrva
     */
    public void enterOpportunityLocation(String...strings)
    {
        String location=strings[1];
        ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " ::  Enter Opportunity Location as " + "\"<b>" + location +"\"   </b>");
        try
        {
            genericfunctions.waitTillTheElementIsVisible(homepageobjects.opportunity_location);
            homepageobjects.opportunity_location.sendKeys(location);
        }
        catch (Throwable e)
        {
            Assert.fail("Could not able to enter Opportunity Location"+"&"+e.getMessage()+"" );
        }
    }

    /**
     * Post Opportunity Button
     * Gandahrva
     */
    public void clickOnPostOpportunityButton(String... strings)
    {
        ExtentTestManager.getTest().log(LogStatus.INFO, " "+ strings[0]  + " :: Click on Post Opportunity Buttons");
        try
        {
            genericfunctions.waitWebDriver(2000);
            genericfunctions.waitForPageToLoad(homepageobjects.opportunity_submit);
            homepageobjects.opportunity_submit.click();
        }
        catch (Throwable e)
        {
            Assert.fail("Could not perform an action on Create/Post Opportunity"+"&"+e.getMessage()+"" );
        }
    }

    /**
     * Verify_Uploaded_Thumbnail_Text_On_TextArea
     * Author:- Gandahrva
     */
    public void verifyDisplayOfOpportunityThumbnail(String... strings)
    {
        genericfunctions.waitWebDriver(2000);
        ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " :: Opportunity Thumbnail has Uploaded or not");
        try
        {
            genericfunctions.waitForPageToLoad(homepageobjects.opportunity_title);
            Assert.assertTrue(homepageobjects.opportunity_thumbnail.isDisplayed());
            ExtentTestManager.getTest().log(LogStatus.PASS, ""+strings[0]+ ":: \"Opportunity Image Thumbnail\" has displayed");
        }
        catch (Throwable e)
        {
            Assert.fail("Could not found \"Opportunity Image Thumbnail\"" + "&" + e.getMessage() + "");
        }
    }

    /**
     * Verify_Opportunity_Widget
     * Author:- Gandahrva
     */
    public void verifyDisplayOfCreatedOpportunityOnWidget(String... strings)
    {
        ExtentTestManager.getTest().log(LogStatus.INFO, " "+ strings[0]  +" ::  Opportunity is displayed or not On Opportunity widget");
        try
        {
            genericfunctions.waitTillTheElementIsVisible(homepageobjects.oppotunity_widget_opportunity_name);
            Assert.assertTrue(homepageobjects.oppotunity_widget_opportunity_name.isDisplayed());
            ExtentTestManager.getTest().log(LogStatus.PASS, " \"Opportunity Widget :: \"  User Created Opportunity is displayed under Opportunity Widget");

        } catch (Throwable e)
        {
            Assert.fail("Expected :: \" Opportunity Widget :: \" User Created Opportunity should be displayed  ; " +
                    "Actual :: \" Opportunity Widget::\" User Created Opportunity is not displayed\"" + "&" + e.getMessage() + "");
        }
    }


    /**
     * Verify_Messenger_Pop_Up
     * Author:- Gandahrva
     */
    public void verifyDisplayOfMessengerPopUp(String...strings)
    {
        ExtentTestManager.getTest().log(LogStatus.INFO, " "+ strings[0]  + " ::  MessengerPopUp is Displaying or not");
        try
        {
            genericfunctions.waitTillTheElementIsVisible(homepageobjects.messenger_pop_up);
            Assert.assertTrue(homepageobjects.messenger_pop_up.isDisplayed());
            ExtentTestManager.getTest().log(LogStatus.PASS,  "\" MessengerPopUp\" is displayed");

        } catch (Throwable e)
        {
            Assert.fail("Expected :: \"  MessengerPopUp \"  should be displayed  ; " +
                    "Actual :: \" MessengerPopUp\" is not displayed" + "&" + e.getMessage() + "");
        }
    }

    /**
     * Verify_Messenger_PopUp_Search
     * Author:- Gandahrva
     */
    public void verifyDispalyOfMessengerPopUpContents(String... strings)
    {
        ExtentTestManager.getTest().log(LogStatus.INFO, " "+ strings[0]  + " ::  Search Bar of Messenger Pop Up is displayed or not");
        try
        {
            genericfunctions.waitTillTheElementIsVisible(homepageobjects.messenger_popup_search);
            Assert.assertTrue(homepageobjects.messenger_popup_search.isDisplayed());
            ExtentTestManager.getTest().log(LogStatus.PASS,  " " + strings[0] +" :: \"Messenger PopUp Search Bar\" is displayed");
        }
        catch (Throwable e)
        {
            Assert.fail("Could not found the Search Bar" + "&" + e.getMessage() + "");
        }

    }
}