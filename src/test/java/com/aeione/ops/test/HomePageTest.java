package com.aeione.ops.test;

import com.aeione.ops.generic.GoogleDriveAPI;
import com.aeione.ops.generic.GoogleSheetAPI;
import com.aeione.ops.generic.TestSetUp;
import com.aeione.ops.pageactions.HomePageActions;
import com.aeione.ops.pageactions.LoginPageActions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

public class HomePageTest extends TestSetUp {

    public LoginPageActions getLoginPage() throws IOException {
        return new LoginPageActions();
    }

    public HomePageActions getHomePageActions() throws IOException {
        return new HomePageActions();
    }

    public GoogleSheetAPI sheetAPI() throws IOException {
        return new GoogleSheetAPI();
    }

    public GoogleDriveAPI dsriveAPI() throws IOException {
        return new GoogleDriveAPI();
    }

    /**
     * Test_Caeses_For_Verify_Contents_Of_Home_Page
     * Author:- Gandahrva
     */
    @Test(priority = 11, enabled = true, alwaysRun = true, description = "Verify all the contents in Home Page")
    public void TC_HM_01_P1_ContentsOfHomePageTest() throws Exception
    {

        String LogInRange = "Login!A6:C6";

        String username = null;
        String password = null;
        String fullname =null;

        Map<String, String> val = sheetAPI().getSpreadSheetRowValueByColumnName(TEST_DATA_GOOGLESHEET, LogInRange);
        username = val.get("UserName / Email / PhoneNumber");
        password = val.get("Password");
        fullname = val.get("FullName");

        getLoginPage().logIn("Action Step", fullname, "valid username, password",username, password);
        getHomePageActions().verifyContentsOfHomePageTests("Verify Step");
    }

    /**
     * Test_Caeses_For_Verify_Contents_Of_Home_Page_Profile_Card
     * Author:- Gandahrva
     */
    @Test(priority = 12, enabled = true, alwaysRun = true, description = "Verify for PROFILE CARD")
    public void TC_HM_02_P1_ContentsOfProfileCardInHomePageTest() throws Exception
    {
        String LogInRange = "Login!A6:C6";
        String username = null;
        String password = null;
        String fullname =null;

        Map<String, String> val = sheetAPI().getSpreadSheetRowValueByColumnName(TEST_DATA_GOOGLESHEET, LogInRange);
        username = val.get("UserName / Email / PhoneNumber");
        password = val.get("Password");
        fullname = val.get("FullName");

        getLoginPage().logIn("Action Step",fullname,  "valid username, password",username, password);
        getHomePageActions().verifyContentsOfProfileCardInHomePage("Verify Step");
    }

    /**
     * Test_Caeses_For_Verify_Contents_Of_Home_Page_Followed_User_Post
     * Author:- Gandahrva
     */
    @Test(priority = 13, enabled = true, alwaysRun = true, description = "Verify for Followed User Post")
    public void TC_HM_03_P1_VerifyFollowedUserPostTest() throws Exception
    {

        // User A
        String LogInRange = "Login!A7:C7";
        String HomePageRange = "Home page!A4:B4";
        String textPostVal = null;

        Map<String, String> val = sheetAPI().getSpreadSheetRowValueByColumnName(TEST_DATA_GOOGLESHEET, LogInRange);
        String username = val.get("UserName / Email / PhoneNumber");
        String password = val.get("Password");
        String fullname = val.get("FullName");

        getLoginPage().logIn("Action Step",fullname,  "valid username, password",username, password);

        val = sheetAPI().getSpreadSheetRowValueByColumnName(TEST_DATA_GOOGLESHEET, HomePageRange);
        textPostVal = val.get("Post_Text");

        getHomePageActions().clickOnPosterTextArea("Action Step");
        getHomePageActions().enterTextOnMessageTextArea("Action Step", textPostVal);
        getHomePageActions().clickOnPostButton("Action step");

        getHomePageActions().clickOnTopBarDropdown("Action Step");
        getHomePageActions().clickOnSignOut("Action Step");

        //User B
        LogInRange = "Login!A6:C6";
        val = sheetAPI().getSpreadSheetRowValueByColumnName(TEST_DATA_GOOGLESHEET, LogInRange);
        username = val.get("UserName / Email / PhoneNumber");
        password = val.get("Password");
        fullname = val.get("FullName");

        getLoginPage().logIn("Action Step",fullname,  "valid username, password ",username, password);
        getHomePageActions().verifyDisplayOfFollowedUserPost("Verify Step",textPostVal);

    }



    /**
     * Test_Caeses_For_Verify_Contents_Of_Home_Page_Published_Blog
     * Author:- Gandahrva
     */
    @Test(priority = 14, enabled = true, alwaysRun = true, description = "Verify for Published Blog")
    public void TC_HM_04_P1_VerifyPublishedBlogTest() throws Exception
    {
        String LogInRange = "Login!A6:C6";
        String BlogRange = "Blog!A2:B2";

        dsriveAPI().downloadFileFromGoogleDrive(TEST_IMAGE_ID1);
        String imageFile = userDirPath + IMAGE_TEST_FILE1;

        String username = null;
        String password = null;
        String fullname =null;

        String blogTitleVal = null;
        String blogName= null;

        Map<String, String> val = sheetAPI().getSpreadSheetRowValueByColumnName(TEST_DATA_GOOGLESHEET, LogInRange);
        username = val.get("UserName / Email / PhoneNumber");
        password = val.get("Password");
        fullname = val.get("FullName");

        getLoginPage().logIn("Action Step",fullname,  "valid username, password",username, password);

        val = sheetAPI().getSpreadSheetRowValueByColumnName(TEST_DATA_GOOGLESHEET, BlogRange);
        blogTitleVal = val.get("Post_Text");
        blogName = val.get("Post_Text");
        String blogError = val.get("Error");


        getHomePageActions().clickOnBlogIcon("Action Step");
        getHomePageActions().enterBlogTitle("Action Step",blogTitleVal);
        getHomePageActions().clickOnPreviewPublishButton("Action Step",blogError);
        getHomePageActions().attachFile("Action Step", imageFile);
        getHomePageActions().clickOnPublishNowButton("Action Step");
        getHomePageActions().verifyPublishedBlogInnerPage("Verify Step",blogTitleVal);
        getHomePageActions().clickOnHomeTopBar("Action Step");
        getHomePageActions().verifyDisplayOfPublishedBlogOnHomeNewsfeed("Verify Step",blogName);
    }


    /**
     * Test_Caeses_For_Verify_Contents_Of_Home_Page_Suggested_List
     * Author:- Gandahrva
     */
    @Test(priority = 15, enabled = true, alwaysRun = true, description = " Verify for Suggestion List")
    public void TC_HM_05_P1_ContentsOfSuggestedListTest() throws Exception
    {
        String LogInRange = "Login!A7:C7";
        String username = null;
        String password = null;
        String fullname =null;

        Map<String, String> val = sheetAPI().getSpreadSheetRowValueByColumnName(TEST_DATA_GOOGLESHEET, LogInRange);
        username = val.get("UserName / Email / PhoneNumber");
        password = val.get("Password");
        fullname = val.get("FullName");

        getLoginPage().logIn("Action Step",fullname,  "valid username, password",username, password);
        getHomePageActions().verifySuggestedWidget("Verify Step ");
        getHomePageActions().verifyContentsOfSuggestionSection("verify step");
    }

    /**
     * Test_Caeses_For_Verify_Contents_Of_Home_Page_Follow_User
     * Author:- Gandahrva
     */
    @Test(priority = 16, enabled = true, alwaysRun = true, description = "verify for Follow Button")
    public void TC_HM_06_P1_VerifyFollowUserButtonTest() throws Exception
    {
        String LogInRange = "Login!A7:C7";
        String username = null;
        String password = null;
        String fullname =null;

        Map<String, String> val = sheetAPI().getSpreadSheetRowValueByColumnName(TEST_DATA_GOOGLESHEET, LogInRange);
        username = val.get("UserName / Email / PhoneNumber");
        password = val.get("Password");
        fullname = val.get("FullName");

        getLoginPage().logIn("Action Step",fullname,  "valid username, password",username, password);

        getHomePageActions().verifySuggestedWidget("Verify Step ");
        String exceptedFollowedUser=getHomePageActions().clickOnFollowButton("Action Step");
        getHomePageActions().verifyFollowedUser("Verify Step",exceptedFollowedUser);
        getHomePageActions().verifyDisplayOfUnfolloButton("Verify Step");
    }

    /**
     * Test_Caeses_For_Create_Post_And_Verification
     * Author:- Gandahrva
     */
    @Test(priority = 17, enabled = true, alwaysRun = true, description = "create a post")
    public void TC_HM_07_P1_VerifyCreatePostAreaTest() throws Exception
    {
        String LogInRange = "Login!A6:C6";
        String HomePageRange = "Home page!A7:B7";
        String username = null;
        String password = null;
        String fullname =null;
        dsriveAPI().downloadFileFromGoogleDrive(TEST_IMAGE_ID1);
        String imageFile = userDirPath + IMAGE_TEST_FILE1;
        String textPostVal = null;

        Map<String, String> val = sheetAPI().getSpreadSheetRowValueByColumnName(TEST_DATA_GOOGLESHEET, LogInRange);
        username = val.get("UserName / Email / PhoneNumber");
        password = val.get("Password");
        fullname = val.get("FullName");

        getLoginPage().logIn("Action Step",fullname,  "valid username, password",username, password);

        val = sheetAPI().getSpreadSheetRowValueByColumnName(TEST_DATA_GOOGLESHEET, HomePageRange);
        textPostVal= val.get("Post_Text");

        getHomePageActions().clickOnPosterTextArea("Action Step");
        getHomePageActions().enterTextOnMessageTextArea("Action Step", textPostVal);
        getHomePageActions().attachFile("Action Step",imageFile);
        getHomePageActions().verifyDisplayOfUploadedThumbnail("Verify Step");
        getHomePageActions().clickOnPostButton("Action step");
        getHomePageActions().verifyDispayOfCreatedImagePost("Verify Step");
        getHomePageActions().verifyDisplayOfCreatedTextPost("Verify Step",textPostVal);
    }


    /**
     * Test_Caeses_For_Opportunity_Widget
     * Author:- Gandahrva
     */
    @Test(priority = 18, enabled = true, alwaysRun = true, description = "create a post")
    public void TC_HM_08_P1_VerifyOpportunityWidgetTest() throws Exception
    {
        String LogInRange = "Login!A6:C6";
        String OpportunityRange = "Opportunity!A2:D2";
        String username = null;
        String password = null;
        String fullname =null;
        String title=null;
        String description=null;
        String location=null;
        String category=null;
        dsriveAPI().downloadFileFromGoogleDrive(TEST_IMAGE_ID1);
        String imageFile = userDirPath + IMAGE_TEST_FILE1;

        Map<String, String> val = sheetAPI().getSpreadSheetRowValueByColumnName(TEST_DATA_GOOGLESHEET, LogInRange);
        username = val.get("UserName / Email / PhoneNumber");
        password = val.get("Password");
        fullname = val.get("FullName");

        getLoginPage().logIn("Action Step",fullname,  "valid username, password",username, password);

        val= sheetAPI().getSpreadSheetRowValueByColumnName(TEST_DATA_GOOGLESHEET, OpportunityRange);
        title=val.get("Opportunity Title");
        description=val.get("Description");
        location=val.get("Location");
        category= val.get("category");

        getHomePageActions().clickOnPosterTextArea("Action Step");
        getHomePageActions().clickOnPostMenuDropdown("Action Step");
        getHomePageActions().clickOnOpportunityHashTag("Action Step");
        //getHomePageActions().clickOnSelectCategoryDropdown("Action Step");
        getHomePageActions().selectCategory("Action Step",category);
        getHomePageActions().enterOpportunityTitle("Action Step",title);
        getHomePageActions().enterOpportunityDescription("Action Step", description);
        getHomePageActions().enterOpportunityLocation("Action Step",location);
        getHomePageActions().attachFile("Action Step",imageFile);
        getHomePageActions().verifyDisplayOfOpportunityThumbnail("Verify Step");
        getHomePageActions().clickOnPostOpportunityButton("Action Step");
        getHomePageActions().verifyDisplayOfCreatedOpportunityOnWidget("Verify Step");

    }

    /**
     * Test_Caeses_For_Messanger_PopUp_Verification
     * Author:- Gandahrva
     */
    @Test(priority = 19, enabled = true, alwaysRun = true, description = "create a post")
    public void TC_HM_09_P1_VerifyMessangerPopUpTest() throws Exception
    {
        String LogInRange = "Login!A6:C6";
        String username = null;
        String password = null;
        String fullname =null;

        Map<String, String> val = sheetAPI().getSpreadSheetRowValueByColumnName(TEST_DATA_GOOGLESHEET, LogInRange);
        username = val.get("UserName / Email / PhoneNumber");
        password = val.get("Password");
        fullname = val.get("FullName");

        getLoginPage().logIn("Action Step",fullname,  "valid username, password",username, password);
        getHomePageActions().verifyDisplayOfMessengerPopUp("Verify Step");
        getHomePageActions().clickOnMessengerPopUp("Action Step");
        getHomePageActions().verifyDispalyOfMessengerPopUpContents("Verify Step");
    }

    @AfterMethod(dependsOnMethods = {"com.aeione.ops.generic.TestSetUp.afterMethod"})
    public void after() throws IOException
    {
        getHomePageActions().navigateHomePage();
        getHomePageActions().clickOnTopBarDropdown("Action Step");
        getHomePageActions().clickOnSignOut("Action Step");
    }

}