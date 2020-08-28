package com.aeione.ops.test;

import com.aeione.ops.generic.GoogleDriveAPI;
import com.aeione.ops.generic.GoogleSheetAPI;
import com.aeione.ops.generic.TestSetUp;
import com.aeione.ops.pageactions.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

public class PostWIthHashTagTest extends TestSetUp {
    public LoginPageActions getLoginPage() throws IOException {
        return new LoginPageActions();
    }

    public HomePageActions getHomePageActions() throws IOException {
        return new HomePageActions();
    }

    public PostWithHashTagActions getPostWithHashTagActions() throws IOException {
        return new PostWithHashTagActions();
    }

    public PostCardActions getPostCardActions() throws IOException {
        return new PostCardActions();
    }

    public RegistrationPageActions getRegistrationPage() throws IOException {
        return new RegistrationPageActions();
    }

    public SearchActions getSearchActions() throws IOException {
        return new SearchActions();

    }
    public ProfilePageActions getProfilePageActions() throws IOException {
        return new ProfilePageActions();
    }

    public ProfileCompletionPageActions getProfileCompletionPageActions() throws IOException {
        return new ProfileCompletionPageActions();
    }

    public GoogleSheetAPI sheetAPI() throws IOException
    {
        return new GoogleSheetAPI();
    }

    public GoogleDriveAPI dsriveAPI() throws IOException {
        return new GoogleDriveAPI();
    }

    /**
     * Test_Caeses_For_Verify_Contents_Of_Post
     * Author:- Gandahrva
     */
    @Test(priority = 20, enabled = true, alwaysRun = true, description = "Verify all the contents of Poster")
    public void tc_PWH_01_P1_verifyContentsOfPostTest() throws Exception {
        String LoginRange = "Login!A6:C6";
        String username = null;
        String password = null;
        String fullname =null;

        Map<String, String> val = sheetAPI().getSpreadSheetRowValueByColumnName(TEST_DATA_GOOGLESHEET, LoginRange);
        username = val.get("UserName / Email / PhoneNumber");
        password = val.get("Password");
        fullname = val.get("FullName");

        getLoginPage().logIn("Action Step", fullname, "valid username, password", username, password);

        getHomePageActions().clickOnPosterTextArea("Action Step");
        getPostWithHashTagActions().verifyContentsOfCreatePostWidget("Verify Step");
    }

    /**
     * Test_Cases_For_Audio_Post_Functionality
     * Author:- Gandahrva
     */
    @Test(priority = 21, enabled = true, alwaysRun = true, description = "Verify Audio File Functionality")
    public void tc_PWH_02_P1_verifyAudioPostTest() throws Exception
    {
        String LoginRange = "Login!A6:C6";
        String PostWithHashTagRange = "PostWithHashTag!A16:A16";
        String username = null;
        String password = null;
        String fullname =null;
        String textPostVal = null;

        dsriveAPI().downloadFileFromGoogleDrive(TEST_AUDIO_ID);
        String audioFile = userDirPath + AUDIO_TEST_FILE;

        Map<String, String> val = sheetAPI().getSpreadSheetRowValueByColumnName(TEST_DATA_GOOGLESHEET, LoginRange);
        username = val.get("UserName / Email / PhoneNumber");
        password = val.get("Password");
        fullname = val.get("FullName");

        getLoginPage().logIn("Action Step",fullname,  "valid username, password", username, password);

        val = sheetAPI().getSpreadSheetRowValueByColumnName(TEST_DATA_GOOGLESHEET, PostWithHashTagRange);
        textPostVal = val.get("Post_Text_Message");

        getHomePageActions().clickOnPosterTextArea("Action Step");
        getHomePageActions().enterTextOnMessageTextArea("Action Step", textPostVal);
        getHomePageActions().attachFile("Action Step", audioFile);
        getHomePageActions().verifyDisplayOfUploadedThumbnail("Verify Step");
        getHomePageActions().clickOnPostButton("Action step");
        getPostWithHashTagActions().verifyDisplayOfAudioPost("Verify Step");
        getHomePageActions().verifyDisplayOfCreatedTextPost("Verify Step", textPostVal);
    }

    /**
     * Test_Caeses_For_Video_Post_Functionality
     * Author:- Gandahrva
     */
    @Test(priority = 22, enabled = true, alwaysRun = true, description = "Verify Video Post Fuctionality")
    public void tc_PWH_03_P1_verifyVideoPostTest() throws Exception {
        String LoginRange = "Login!A6:C6";
        String PostWithHashTagRange = "PostWithHashTag!A17:A17";
        String username = null;
        String password = null;
        String fullname =null;
        String textPostVal = null;
        dsriveAPI().downloadFileFromGoogleDrive(TEST_VIDEO_ID1);
        String videoFile = userDirPath + VIDEO_TEST_FILE1;

        Map<String, String> val = sheetAPI().getSpreadSheetRowValueByColumnName(TEST_DATA_GOOGLESHEET, LoginRange);
        username = val.get("UserName / Email / PhoneNumber");
        password = val.get("Password");
        fullname = val.get("FullName");

        getLoginPage().logIn("Action Step",fullname,  "valid username, password", username, password);

        val = sheetAPI().getSpreadSheetRowValueByColumnName(TEST_DATA_GOOGLESHEET, PostWithHashTagRange);
        textPostVal = val.get("Post_Text_Message");

        getHomePageActions().clickOnPosterTextArea("Action Step");
        getHomePageActions().enterTextOnMessageTextArea("Action Step", textPostVal);
        getHomePageActions().attachFile("Action Step", videoFile);
        getHomePageActions().verifyDisplayOfUploadedThumbnail("Verify Step");
        getHomePageActions().clickOnPostButton("Action step");
        getPostWithHashTagActions().verifyDisplayOfCreatedVideoPost("Verify Step");
        getHomePageActions().verifyDisplayOfCreatedTextPost("Verify Step", textPostVal);
    }

    /**
     * Test_Cases_For_Verify_Contents_Of_Post
     * Author:- Gandahrva
     */
    @Test(priority = 23, enabled = true, alwaysRun = true, description = "Verify all the contents of HashTags")
    public void TC_PWH_04_P1_verifyHashTagDropDownTest() throws Exception
    {
        String LoginRange = "Login!A6:C6";
        String PostWithHashTagRange= "PostWithHashTag!A2:D2";
        String username = null;
        String password = null;
        String fullName = null;

        Map<String, String> val = sheetAPI().getSpreadSheetRowValueByColumnName(TEST_DATA_GOOGLESHEET, LoginRange);
        username = val.get("UserName / Email / PhoneNumber");
        password = val.get("Password");
        fullName = val.get("FullName");

        getLoginPage().logIn("Action Step", fullName,"valid username, password",username, password);

        val = sheetAPI().getSpreadSheetRowValueByColumnName(TEST_DATA_GOOGLESHEET, PostWithHashTagRange);
        String tags= val.get("HashTags");

        getHomePageActions().clickOnPosterTextArea("Action Step");
        getPostWithHashTagActions().clickOnHashTagDropDown("Action Step");
        getPostWithHashTagActions().verifyDisplayOfHashTagList(tags,"Verify Step");
    }

    /**
     * Test_Cases_For_Verify_NSFW_Functionality
     * Author:- Gandahrva
     */
    @Test(priority = 24, enabled = true, alwaysRun = true, description = "Verify Restricted Content Toggle Button")
    public void TC_PWH_05_P1_verifyRestrictedContentToggleButtonTest() throws Exception
    {
        String LoginRange = "Login!A6:C6";
        String PostWithHashTagRange = "PostWithHashTag!A14:A14";
        String username = null;
        String password = null;
        String textPostVal = null;
        dsriveAPI().downloadFileFromGoogleDrive(TEST_IMAGE_ID1);
        String imageFile = userDirPath + IMAGE_TEST_FILE1;

        Map<String, String> val = sheetAPI().getSpreadSheetRowValueByColumnName(TEST_DATA_GOOGLESHEET, LoginRange);
        username = val.get("UserName / Email / PhoneNumber");
        password = val.get("Password");
        String fullName = val.get("FullName");

        getLoginPage().logIn("Action Step", fullName,"valid username, password",username, password);

        val = sheetAPI().getSpreadSheetRowValueByColumnName(TEST_DATA_GOOGLESHEET, PostWithHashTagRange);
        textPostVal= val.get("Post_Text_Message");

        getHomePageActions().clickOnPosterTextArea("Action Step");
        getHomePageActions().enterTextOnMessageTextArea("Action Step", textPostVal);
        getHomePageActions().attachFile("Action Step",imageFile);
        getHomePageActions().verifyDisplayOfUploadedThumbnail("Verify Step");
        getPostWithHashTagActions().clickOnRestrictedContentToggleButton("Action Step");
        getPostWithHashTagActions().verifyRestrictedContentToggleIsEnabled("Verify Step");
        getHomePageActions().clickOnPostButton("Action step");
        getHomePageActions().verifyDisplayOfCreatedTextPost("Verify Step", textPostVal);
        getHomePageActions().verifyDispayOfCreatedImagePost("Verify Step");
        getPostWithHashTagActions().verifyDisplayOfUnCoverButtonOnFeed("Verify Step");
        getPostWithHashTagActions().clickOnUnCoverButton("Action Step");
        getPostWithHashTagActions().verifyDisplayOfCoverButtonOnFeed("Verify Step");


        /*getHomePageActions().clickOnTopBarDropdown("Action Step");
        getHomePageActions().clickOnSignOut("Action Step");

        ArrayList<String> val2 = sheetAPI().getSpreadSheetValues(TEST_DATA_GOOGLESHEET, range2, 7);
        username = val2.get(0);
        password = val2.get(1);
        getLoginPage().logIn("Action Step", "valid username, password of User B",username, password);
        getPostWithHashTagActions().verifyDisplayOfRestrictedContentCoveredPost("Verify Step");
        getPostWithHashTagActions().clickOnUnCoverButton("Action Step");
        getPostWithHashTagActions().verifyDisplayOfRestrictedContentUnCoveredPost("Verify Step");
        getPostWithHashTagActions().clickOnCoverButton("Action Step");*/
    }

    /**
     * Test_Cases_For_Verify_NSFW_Functionality
     * Author:- Gandahrva
     */
    @Test(priority = 25, enabled = true, alwaysRun = true, description = "Verify Restritected Content Post")
    public void TC_PWH_06_P1_verifyRestrictedContentPost() throws Exception
    {
        //User A
        String LoginRange = "Login!A6:C6";
        String PostWithHashTagRange = "PostWithHashTag!A14:A14";

        String username = null;
        String password = null;
        String textPostVal = null;
        String fullName = null;
        dsriveAPI().downloadFileFromGoogleDrive(TEST_IMAGE_ID1);
        String imageFile = userDirPath + IMAGE_TEST_FILE1;

        Map<String, String> val = sheetAPI().getSpreadSheetRowValueByColumnName(TEST_DATA_GOOGLESHEET, LoginRange);
        username = val.get("UserName / Email / PhoneNumber");
        password = val.get("Password");
        fullName = val.get("FullName");

        getLoginPage().logIn("Action Step", fullName,"valid username, password",username, password);

        val = sheetAPI().getSpreadSheetRowValueByColumnName(TEST_DATA_GOOGLESHEET, PostWithHashTagRange);
        textPostVal= val.get("Post_Text_Message");

        getHomePageActions().clickOnPosterTextArea("Action Step");
        getHomePageActions().enterTextOnMessageTextArea("Action Step", textPostVal);
        getHomePageActions().attachFile("Action Step",imageFile);
        getHomePageActions().verifyDisplayOfUploadedThumbnail("Verify Step");
        getPostWithHashTagActions().clickOnRestrictedContentToggleButton("Action Step");
        getPostWithHashTagActions().verifyRestrictedContentToggleIsEnabled("Verify Step");
        getHomePageActions().clickOnPostButton("Action step");
        getHomePageActions().verifyDisplayOfCreatedTextPost("Verify Step", textPostVal);
        getHomePageActions().verifyDispayOfCreatedImagePost("Verify Step");

        getPostWithHashTagActions().verifyDisplayOfRestrictedContentCoveredPost("Verify Step");
        getPostWithHashTagActions().clickOnUnCoverButton("Action Step");

        getPostWithHashTagActions().verifyDisplayOfRestrictedContentUnCoveredPost("Verify Step");

        getPostWithHashTagActions().clickOnCoverButton("Action Step");

        /*getHomePageActions().clickOnTopBarDropdown("Action Step");
        getHomePageActions().clickOnSignOut("Action Step");

        //User B
        LoginRange = "Login!A7:C7";
        val = sheetAPI().getSpreadSheetValuesOfSpecificRow(TEST_DATA_GOOGLESHEET, LoginRange);
        username = val.get(0);
        password = val.get(1);
        fullName = val.get(2);

        getLoginPage().logIn("Action Step", fullName,"valid username, password",username, password);
        getHomePageActions().verifyDisplayOfCreatedTextPost("Verify Step", textPostVal);
        getHomePageActions().verifyDispayOfCreatedImagePost("Verify Step");
        getPostWithHashTagActions().verifyDisplayOfRestrictedContentCoveredPost("Verify Step");
        getPostWithHashTagActions().clickOnUnCoverButton("Action Step");
        getPostWithHashTagActions().verifyDisplayOfRestrictedContentUnCoveredPost("Verify Step");
        getPostWithHashTagActions().clickOnCoverButton("Action Step");*/
    }

    /**
     * Test_Cases_For_Verify_Pay_Per_Post
     * Author:- Gandahrva
     */
    @Test(priority = 26, enabled = true, alwaysRun = true, description = "Verify Pay Per Post")
    public void TC_PWH_07_P1_verifyPayPerPostTest() throws Exception
    {
        String RegistrationRange = "Registration!A4:H";
        String PostwithHashTagRange = "PostWithHashTag!A15:F15";
        String LogInRange = "Login!A16:C16";

        String fullName = null;
        String username = null;
        String password = null;

        String textPostVal = null;
        String coinsVal = null;
        String messageVal = null;
        String coins = null;

        dsriveAPI().downloadFileFromGoogleDrive(TEST_IMAGE_ID1);
        String imageFile = userDirPath + IMAGE_TEST_FILE1;

        ArrayList<String> responseinfo=null;
        String response=null;

        ArrayList<String> val = sheetAPI().getSpreadSheetValuesOfSpecificRow(TEST_DATA_GOOGLESHEET, RegistrationRange);
        fullName=val.get(0);
        String userName=getRegistrationPage().getUserName(val.get(1));
        String emailAddress=getRegistrationPage().getEmail(val.get(2));
        String countryCode=val.get(3);
        String dateOfBirth=val.get(5);
        /*String createPassword=getRegistrationPage().getRandomValidPassword(val.get(6));*/
        String createPassword=val.get(6);
        String skipOtp=val.get(7);
        String phoneNumber= getRegistrationPage().getPhoneNumber(val.get(4));

        responseinfo=getRegistrationPage().mobileVerifyApi("Action Step",phoneNumber, countryCode, skipOtp);
        response=responseinfo.get(0);
        String secret=responseinfo.get(1);

        getRegistrationPage().verifyMobileApi("Verify Step", response);
        response=getRegistrationPage().mobileConfirmApi("Action Step",phoneNumber, secret,skipOtp , countryCode );
        getRegistrationPage().verifyMobileConfirmApi("Verify Step", response);
        response= getRegistrationPage().registerApi("Action & verify", fullName,userName,phoneNumber,countryCode,secret, emailAddress,dateOfBirth,createPassword,skipOtp);
        getRegistrationPage().verifyRegisterApi("Verify Step", response);

        //Update values in Registration Page
        List<List<Object>> values1 = Arrays.asList(Arrays.asList(fullName,userName,emailAddress, countryCode,phoneNumber,dateOfBirth,createPassword,skipOtp));
        sheetAPI().appendRowData(TEST_DATA_GOOGLESHEET,constantRow,  "USER_ENTERED", values1);

        //Update values in sheet
        List<List<Object>> values = Arrays.asList(Arrays.asList(userName, createPassword , fullName));
        sheetAPI().updateMultipleCellValues(TEST_DATA_GOOGLESHEET, LogInRange, "USER_ENTERED", values);

        //Login
        Map<String, String> value = sheetAPI().getSpreadSheetRowValueByColumnName(TEST_DATA_GOOGLESHEET, LogInRange);
        username = value.get("UserName / Email / PhoneNumber");
        password = value.get("Password");
        fullName = value.get("FullName");

        getLoginPage().logIn("Action Step",fullName,  "valid username, password",username, password);
        getLoginPage().clickOnTopicSkipButton("Action Step");

        value = sheetAPI().getSpreadSheetRowValueByColumnName(TEST_DATA_GOOGLESHEET, PostwithHashTagRange);
        textPostVal= value.get("Post_Text_Message");
        coinsVal= value.get("Coins");
        messageVal = value.get("Pay_Per_Post_Description");

        getHomePageActions().clickOnPosterTextArea("Action Step");
        getHomePageActions().enterTextOnMessageTextArea("Action Step", textPostVal);
        getHomePageActions().attachFile("Action Step",imageFile);
        getHomePageActions().verifyDisplayOfUploadedThumbnail("Verify Step");
        getPostWithHashTagActions().setPaidPostPopUp("Action Step");
        getPostWithHashTagActions().verifySetPaywllContents("Verify Step");
        getPostWithHashTagActions().setCoinsForPaidPost("Action Step",coinsVal);
        getPostWithHashTagActions().setMessageForPaidPost("Action Step",messageVal);
        getPostWithHashTagActions().verifyDisplayOfAddButton("Verify Step");
        getPostWithHashTagActions().clickOnAddCoinsButtonForPaidPost("Action Step");
        getHomePageActions().clickOnPostButton("Action Step");

        getPostWithHashTagActions().verifyHeaderPaywall("Verify Step");

        coins=getPostWithHashTagActions().payperpostValue();

        getPostWithHashTagActions().verifyDisplayOfHeaderPaywallValue("Verify Step",coinsVal,coins);
        getPostWithHashTagActions().verifyDisplayOfPaywallUnlockButton("Verify Step");

    }

    /**
     * Test_Cases_For_Verify_Pay_Per_Post
     * Author:- Gandahrva
     */
    @Test(priority = 27, enabled = true, alwaysRun = true, description = "Verify Unlock Pay Per Post")
    public void TC_PWH_08_P1_verifyUnlockPayPerPostTest() throws Exception
    {
        String LogInRange = "Login!A17:C17";
        String PayPerPostRange = "PayPerPost!A2:B2";
        String username = null;
        String password = null;
        String fullName = null;

        Map<String, String> val = sheetAPI().getSpreadSheetRowValueByColumnName(TEST_DATA_GOOGLESHEET, LogInRange);
        username = val.get("UserName / Email / PhoneNumber");
        password = val.get("Password");
        fullName = val.get("FullName");

        getLoginPage().logIn("Action Step", fullName,"valid username, password",username, password);
        String SearchUserRange = "Login!A16:B16";
        val = sheetAPI().getSpreadSheetRowValueByColumnName(TEST_DATA_GOOGLESHEET, SearchUserRange);
        String searchUserName = val.get("UserName / Email / PhoneNumber");

        //getLoginPage().clickOnTopicSkipButton("Action Step");
        getSearchActions().enterUsernameOnSearchTextFieldAndSelectUserName("Action Step", searchUserName);
        getSearchActions().clickOnProfileTab("Action Step");
        getProfileCompletionPageActions().clickOnFollowButton("Action Step");
        getHomePageActions().clickOnHomeTopBar("Action Step");

        val = sheetAPI().getSpreadSheetRowValueByColumnName(TEST_DATA_GOOGLESHEET, PayPerPostRange);
        String payperpostMsg = val.get("Pay-Per_Post");
        String coinsValue = val.get("Coins");
        String coin = null;

        getPostWithHashTagActions().verifyHeaderPaywall("Verify Step");

        coin=getPostWithHashTagActions().payperpostValue();

        getPostWithHashTagActions().verifyDisplayOfHeaderPaywallValue("Verify Step",coinsValue,coin);

        getPostWithHashTagActions().verifyDisplayOfPaywallUnlockButton("Verify Step");

        getPostWithHashTagActions().clickOnUnlockThisPostButton("Action Step");
        getPostWithHashTagActions().verifyDisplayOfPaywallWindow("Verify Step");
        getPostWithHashTagActions().verifyDisplayOfPaywallWindowHeader("Verify Step");
        getPostWithHashTagActions().verifyUnlockThisPostButtonIsEnabled("Verify Step");
        getPostWithHashTagActions().clickOnUnlockThisPostButtonOnPaywallWindow("Action Step");
        getPostWithHashTagActions().closePaywallWindow("Action Step");

        getPostWithHashTagActions().verifyPayPerPostConfirmationMessage("Verify Step", payperpostMsg,coin);
        getPostWithHashTagActions().clickOnUnlockThisPostButton("Action Step");
    }


    /**
     * Test_Cases_For_Verify_Edit_Post
     * Author:- Gandahrva
     */
    @Test(priority = 28, enabled = true, alwaysRun = true, description = "Verify Edit Post")
    public void TC_PWH_09_P1_verifyEditActonPostTest() throws Exception
    {
        String LogInRange = "Login!A6:C6";
        String PostWithHashTagRange = "PostWithHashTag!A2:C2";
        String username = null;
        String password = null;
        String fullName = null;
        String textPostVal = null;
        String action = null;
        String editedText = null ;

        Map<String, String> val = sheetAPI().getSpreadSheetRowValueByColumnName(TEST_DATA_GOOGLESHEET, LogInRange);
        username = val.get("UserName / Email / PhoneNumber");
        password = val.get("Password");
        fullName = val.get("FullName");

        getLoginPage().logIn("Action Step", fullName,"valid username, password",username, password);


        val = sheetAPI().getSpreadSheetRowValueByColumnName(TEST_DATA_GOOGLESHEET, PostWithHashTagRange);
        textPostVal= val.get("Post_Text_Message");
        action = val.get("Action");
        editedText = val.get("Post_Action_Message");


        getHomePageActions().clickOnPosterTextArea("Action Step");
        getHomePageActions().enterTextOnMessageTextArea("Action Step", textPostVal);
        getHomePageActions().clickOnPostButton("Action step");
        getHomePageActions().verifyDisplayOfCreatedTextPost("Verify Step",textPostVal);

        getPostWithHashTagActions().clickOnMoreMenuInPostCard("Action Step");
        getPostWithHashTagActions().postMenuDropDownActions("Action Step",action);
        getPostWithHashTagActions().postEditAction("Action Step",editedText);
        getPostWithHashTagActions().saveEditedPostAction("Action Step");

        getPostWithHashTagActions().verifyDisplayOfEditedPost("Verify Step",editedText);
    }

    /**
     * Test_Cases_For_Delete_Post
     * Author:- Gandahrva
     */
    @Test(priority = 29, enabled = true, alwaysRun = true, description = "Verify Delete Post")
    public void TC_PWH_10_P1_verifyDeletePostTest() throws Exception
    {

        String LogInRange = "Login!A6:C6";
        String PostWithHashTagRange = "PostWithHashTag!A3:C3";
        String username = null;
        String password = null;
        String fullName = null;
        String textPostVal = null;
        String action = null;

        Map<String, String> val = sheetAPI().getSpreadSheetRowValueByColumnName(TEST_DATA_GOOGLESHEET, LogInRange);
        username = val.get("UserName / Email / PhoneNumber");
        password = val.get("Password");
        fullName = val.get("FullName");

        getLoginPage().logIn("Action Step", fullName,"valid username, password",username, password);

        val = sheetAPI().getSpreadSheetRowValueByColumnName(TEST_DATA_GOOGLESHEET, PostWithHashTagRange);
        textPostVal= val.get("Post_Text_Message");
        action = val.get("Action");

        getHomePageActions().clickOnPosterTextArea("Action Step");
        getHomePageActions().enterTextOnMessageTextArea("Action Step", textPostVal);
        getHomePageActions().clickOnPostButton("Action step");
        getHomePageActions().verifyDisplayOfCreatedTextPost("Verify Step",textPostVal);
        getPostWithHashTagActions().clickOnMoreMenuInPostCard("Action Step");
        getPostWithHashTagActions().postMenuDropDownActions("Action Step",action);
        getPostCardActions().clickOnYesButton("Action Step");
        getPostWithHashTagActions().verifyDisplayOfDeletedPost("Verify Step",textPostVal);
    }

    /**
     * Test_Cases_For_Share_Post
     * Author:- Gandahrva
     */
    @Test(priority = 30, enabled = true, alwaysRun = true, description = "Verify Share Post")
    public void TC_PWH_11_P1_verifySharePostTest() throws Exception
    {
        String LogInRange = "Login!A6:C6";
        String BlueStoreRange = "BlueStore!A2:F2";
        String username = null;
        String password = null;
        String fullName = null;
        String action = null;
        dsriveAPI().downloadFileFromGoogleDrive(TEST_IMAGE_ID1);
        String imageFile = userDirPath + IMAGE_TEST_FILE1;

        Map<String, String> val = sheetAPI().getSpreadSheetRowValueByColumnName(TEST_DATA_GOOGLESHEET, LogInRange);
        username = val.get("UserName / Email / PhoneNumber");
        password = val.get("Password");
        fullName = val.get("FullName");

        getLoginPage().logIn("Action Step",fullName, "Valid username,password",username, password);

        val = sheetAPI().getSpreadSheetRowValueByColumnName(TEST_DATA_GOOGLESHEET, BlueStoreRange);

        action = val.get("Action");
        String title = val.get("Title");
        String description = val.get("Description_Values");
        String units = val.get("No. Units");
        String price = val.get("Price");


        getHomePageActions().clickOnPosterTextArea("Action Step");
        getHomePageActions().clickOnPostMenuDropdown("Action Step");
        getPostWithHashTagActions().selectHashTagFromDropdownList("Action Step",action);
        getHomePageActions().attachFile("Action Step",imageFile);
        getPostWithHashTagActions().verifyDisplayOfUploadedBlueStoreThumbnail("Verify Step");
        getPostWithHashTagActions().enterBlueStoreTitle("Action Step",title);
        getPostWithHashTagActions().enterBlueStoreDescription("Action Step",description);
        getPostWithHashTagActions().enterBlueStoreUnits("Action Step",units);
        getPostWithHashTagActions().enterBlueStorePrice("Action Step",price);
        getPostWithHashTagActions().clickOnBluestoreSubmitButton("Action Step");
        getPostWithHashTagActions().verifyDisplayOfCreatedBluestorePostOnFeed("Verify Step",title);
        getPostWithHashTagActions().clickOnShareButton("Action Step");
        getPostWithHashTagActions().clickOnShareMenuRepost("Action Step");
        getPostWithHashTagActions().verifyDisplayOfRepostPopUp("Verify Step");

        getPostWithHashTagActions().enterRepostMessage("Action Step",title);
        getPostWithHashTagActions().clickOnRePostShareButton("Action Step");
        getPostWithHashTagActions().verifyDisplayOfRepostHeaderOnTimeLine("Verify Step");
    }

    /**
     * Test_Cases_For_#MyJourney_Post
     * Author:- Gandahrva
     */
    @Test(priority = 31, enabled = true, alwaysRun = true, description = "Create MyJourney Post")
    public void TC_PWH_12_P1_VerifyCreateMyJourneyHashTagPostTest() throws Exception
    {
        String LogInRange = "Login!A6:C6";
        String PostWithHashTagRange = "PostWithHashTag!A10:C10";
        String username = null;
        String password = null;
        String fullName = null;
        String textPostVal = null;
        String action = null;
        dsriveAPI().downloadFileFromGoogleDrive(TEST_VIDEO_ID1);
        String videoFile = userDirPath + VIDEO_TEST_FILE1;

        Map<String, String> val = sheetAPI().getSpreadSheetRowValueByColumnName(TEST_DATA_GOOGLESHEET, LogInRange);
        username = val.get("UserName / Email / PhoneNumber");
        password = val.get("Password");
        fullName = val.get("FullName");

        getLoginPage().logIn("Action Step",fullName, "Valid username,password",username, password);

        val = sheetAPI().getSpreadSheetRowValueByColumnName(TEST_DATA_GOOGLESHEET, PostWithHashTagRange);
        textPostVal= val.get("Post_Text_Message");
        action = val.get("Action");
        String header = val.get("Post_Action_Message");

        getHomePageActions().clickOnPosterTextArea("Action Step");
        getHomePageActions().clickOnPostMenuDropdown("Action Step");
        getPostWithHashTagActions().selectHashTagFromDropdownList("Action Step",action);
        getHomePageActions().attachFile("Action Step",videoFile);
        getPostWithHashTagActions().verifyDisplayOfMyJourneyThumbnail("Verify Step");
        getHomePageActions().enterTextOnMessageTextArea("Action Step", textPostVal);
        getPostWithHashTagActions().clickOnMyJourneySubmitButton("Action step");

        getPostWithHashTagActions().verifyDisplayOfMyJourneyPostOnFeed("Verify Step",textPostVal);
        getPostWithHashTagActions().verifyDisplayOfMyJourneyPostHeaderOnFeed("Verify Step");
        getPostWithHashTagActions().clickOnProfileDetails("Action Step");
        getPostWithHashTagActions().verifyDisplayOfMyJourneyPostOnFeed("Verify Step",textPostVal);
        getPostWithHashTagActions().verifyDisplayOfHashTagPostHeaderOnFeed("Verify Step",header);
        getPostWithHashTagActions().verifyDisplayOfMyJouneyPostOnWidget("Verify Step");
    }

    /**
     * Test_Cases_For_#MyJourney_Edit_Delete_Post
     * Author:- Gandahrva
     */
    @Test(priority = 32, enabled = true, alwaysRun = true, description = "Verify MyJourney Post Functionality")
    public void TC_PWH_13_P1_VerifyMyJourneyPostEditAndDeleteActionTest() throws Exception
    {
        String LogInRange = "Login!A6:C6";
        String PostWithHashTagRangeForEdit = "PostWithHashTag!A11:C11";
        String PostWithHashTagRangeForDelete = "PostWIthHashTag!A12:C12";
        String username = null;
        String password = null;
        String fullName = null;
        String editedText = null;
        String action = null;

        Map<String, String> val = sheetAPI().getSpreadSheetRowValueByColumnName(TEST_DATA_GOOGLESHEET, LogInRange);
        username = val.get("UserName / Email / PhoneNumber");
        password = val.get("Password");
        fullName = val.get("FullName");

        getLoginPage().logIn("Action Step",fullName, "Valid username,password",username, password);

        val = sheetAPI().getSpreadSheetRowValueByColumnName(TEST_DATA_GOOGLESHEET, PostWithHashTagRangeForEdit);
        action = val.get("Action");
        editedText= val.get("Post_Action_Message");

        getPostWithHashTagActions().clickOnMoreMenuInPostCard("Action Step");
        getPostWithHashTagActions().postMenuDropDownActions("Action Step",action);
        getPostWithHashTagActions().postEditAction("Action Step",editedText);
        getPostWithHashTagActions().saveEditedPostAction("Action Step");
        getPostWithHashTagActions().verifyDisplayOfMyJourneyEditedPostOnFeed("Verify Step",editedText);

        val = sheetAPI().getSpreadSheetRowValueByColumnName(TEST_DATA_GOOGLESHEET, PostWithHashTagRangeForDelete);
        action= val.get("Action");

        getPostWithHashTagActions().clickOnMoreMenuInPostCard("Action Step");
        getPostWithHashTagActions().postMenuDropDownActions("Action Step",action);
        getPostCardActions().clickOnYesButton("Action Step");
        getPostWithHashTagActions().verifyDisplayOfDeletedPost("Verify Step",editedText);
    }

    /**
     * Test_Cases_For_#ShowTimez_Post
     * Author:- Gandahrva
     */
    @Test(priority = 33, enabled = true, alwaysRun = true, description = "Create ShowTimez Post")
    public void TC_PWH_14_P1_verifyCreateShowtimezPostTest() throws Exception
    {
        String LogInRange = "Login!A6:C6";
        String ShowTimezRange = "ShowTimez!A2:F2";
        String username = null;
        String password = null;
        String fullName = null;
        String action = null;
        dsriveAPI().downloadFileFromGoogleDrive(TEST_IMAGE_ID1);
        String imageFile = userDirPath + IMAGE_TEST_FILE1;

        Map<String, String> val = sheetAPI().getSpreadSheetRowValueByColumnName(TEST_DATA_GOOGLESHEET, LogInRange);
        username = val.get("UserName / Email / PhoneNumber");
        password = val.get("Password");
        fullName = val.get("FullName");

        getLoginPage().logIn("Action Step",fullName, "Valid username,password",username, password);

        val = sheetAPI().getSpreadSheetRowValueByColumnName(TEST_DATA_GOOGLESHEET, ShowTimezRange);
        action = val.get("Action");
        String title = val.get("Title");
        String description = val.get("Description");
        String location = val.get("Location");

        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_YEAR, 15);
        Date upcomingDate = calendar.getTime();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        String strDate = formatter.format(upcomingDate);

        String time = val.get("Time");

        getHomePageActions().clickOnPosterTextArea("Action Step");
        getHomePageActions().clickOnPostMenuDropdown("Action Step");
        getPostWithHashTagActions().selectHashTagFromDropdownList("Action Step",action);
        getHomePageActions().attachFile("Action Step",imageFile);
        getPostWithHashTagActions().verifyDisplayOfUploadedShowtimezThumbnail("Verify Step");
        getPostWithHashTagActions().enterShowTimezTitle("Action Step",title);
        getPostWithHashTagActions().enterShowTimezDescription("Action Step",description);
        getPostWithHashTagActions().enterShowTimezLocation("Action Step",location);
        getPostWithHashTagActions().enterShowTimezDate("Action Step",strDate);
        getPostWithHashTagActions().enterShowTimezTime("Action Step",time);
        getPostWithHashTagActions().clickOnShowTimezSubmitButton("Action Step");
        getPostWithHashTagActions().verifyDisplayOfCreatedShowTimezPostTitleOnFeed("Verify Step",title);
    }

    /**
     * Test_Cases_For_#ShowTimez_Edit_Post
     * Author:- Gandahrva
     */
    @Test(priority = 34, enabled = true, alwaysRun = true, description = "Edit ShowTimez Post")
    public void TC_PWH_15_P1_VerifyEditShowtimezPostTest() throws Exception
    {
        String LogInRange = "Login!A6:C6";
        String ShowTimezRange = "ShowTimez!A3:F3";
        String username = null;
        String password = null;
        String fullName = null;
        String action = null;

        Map<String, String> val = sheetAPI().getSpreadSheetRowValueByColumnName(TEST_DATA_GOOGLESHEET, LogInRange);
        username = val.get("UserName / Email / PhoneNumber");
        password = val.get("Password");
        fullName = val.get("FullName");

        getLoginPage().logIn("Action Step",fullName, "Valid username,password",username, password);

        val = sheetAPI().getSpreadSheetRowValueByColumnName(TEST_DATA_GOOGLESHEET, ShowTimezRange);
        action = val.get("Action");
        String title = val.get("Title");
        String description = val.get("Description");
        String location = val.get("Location");

        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_YEAR, 20);
        Date upcomingDate = calendar.getTime();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        String strDate = formatter.format(upcomingDate);

        String time = val.get("Time");

        getPostWithHashTagActions().clickOnMoreMenuInPostCard("Action Step");
        getPostWithHashTagActions().postMenuDropDownActions("Action Step",action);
        getPostWithHashTagActions().verifyDisplayOfEditShowTimezPopUp("Verify Step");
        getPostWithHashTagActions().enterShowTimezTitle("Action Step",title);
        getPostWithHashTagActions().enterShowTimezDescription("Action Step",description);
        getPostWithHashTagActions().enterShowTimezLocation("Action Step",location);
        getPostWithHashTagActions().enterShowTimezDate("Action Step",strDate);
        getPostWithHashTagActions().enterShowTimezTime("Action Step",time);
        getPostWithHashTagActions().clickOnShowTimezSubmitButton("Action Step");
        getHomePageActions().clickOnHomeTopBar("Action Step");
        getPostWithHashTagActions().verifyDisplayOfEditedShowTimezPostTitleOnFeed("Verify Step",title);
    }

    /**
     * Test_Cases_For_#ShowTimez_ReachOut_Post
     * Author:- Gandahrva
     */
    @Test(priority = 35, enabled = true, alwaysRun = true, description = "ReachOut ShowTimez Post")
    public void TC_PWH_16_P1_VerifyReachOutShowtimezPostTest() throws Exception
    {
        String LogInRange = "Login!A7:C7";
        String username = null;
        String password = null;
        String fullName = null;

        Map<String, String> val = sheetAPI().getSpreadSheetRowValueByColumnName(TEST_DATA_GOOGLESHEET, LogInRange);
        username = val.get("UserName / Email / PhoneNumber");
        password = val.get("Password");
        fullName = val.get("FullName");

        getLoginPage().logIn("Action Step", fullName,"Valid username,password",username, password);

        getPostWithHashTagActions().verifyDisplayOfCreatedShowTimezPostCardOnFeed("Verify Step");
        getPostWithHashTagActions().clickOnReachOutButton("Action Step");
        getPostWithHashTagActions().verifyDispalyOfReachOutLinkOnMessangerTextAreaPopUp("Verify Step");
        getPostWithHashTagActions().clickOnSendButton("Action Step");
    }

    /**
     * Test_Cases_For_#ShowTimez_Delete_Post
     * Author:- Gandahrva
     */
    @Test(priority = 36, enabled = true, alwaysRun = true, description = "Delete ShowTimez Post")
    public void TC_PWH_17_P1_VerifyDeleteShowtimezPostTest() throws Exception
    {
        String LogInRange = "Login!A6:C6";
        String ShowTimezCreateRange = "ShowTimez!A5:F5";
        String ShowTimezDeleteRange = "ShowTimez!A4:B4";
        String username = null;
        String password = null;
        String fullName = null;
        String action = null;
        dsriveAPI().downloadFileFromGoogleDrive(TEST_IMAGE_ID1);
        String imageFile = userDirPath + IMAGE_TEST_FILE1;

        Map<String, String> val = sheetAPI().getSpreadSheetRowValueByColumnName(TEST_DATA_GOOGLESHEET, LogInRange);
        username = val.get("UserName / Email / PhoneNumber");
        password = val.get("Password");
        fullName = val.get("FullName");

        getLoginPage().logIn("Action Step",fullName, "Valid username,password",username, password);

        val = sheetAPI().getSpreadSheetRowValueByColumnName(TEST_DATA_GOOGLESHEET, ShowTimezCreateRange);
        action = val.get("Action");
        String title = val.get("Title");
        String description = val.get("Description");
        String location = val.get("Location");

        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_YEAR, 15);
        Date upcomingDate = calendar.getTime();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        String strDate = formatter.format(upcomingDate);

        String time = val.get("Time");

        getHomePageActions().clickOnPosterTextArea("Action Step");
        getHomePageActions().clickOnPostMenuDropdown("Action Step");
        getPostWithHashTagActions().selectHashTagFromDropdownList("Action Step",action);
        getHomePageActions().attachFile("Action Step",imageFile);
        getPostWithHashTagActions().verifyDisplayOfUploadedShowtimezThumbnail("Verify Step");
        getPostWithHashTagActions().enterShowTimezTitle("Action Step",title);
        getPostWithHashTagActions().enterShowTimezDescription("Action Step",description);
        getPostWithHashTagActions().enterShowTimezLocation("Action Step",location);
        getPostWithHashTagActions().enterShowTimezDate("Action Step",strDate);
        getPostWithHashTagActions().enterShowTimezTime("Action Step",time);
        getPostWithHashTagActions().clickOnShowTimezSubmitButton("Action Step");
        getPostWithHashTagActions().verifyDisplayOfCreatedShowTimezPostTitleOnFeed("Verify Step",title);

        val = sheetAPI().getSpreadSheetRowValueByColumnName(TEST_DATA_GOOGLESHEET, ShowTimezDeleteRange);
        action = val.get("Action");
        String text = val.get("Title");

        getPostWithHashTagActions().clickOnMoreMenuInPostCard("Action Step");
        getPostWithHashTagActions().postMenuDropDownActions("Action Step",action);
        getPostCardActions().clickOnYesButton("Action Step");
        getPostWithHashTagActions().verifyDisplayOfDeletedShowtimezPost("Verify Step",text);
    }

    /**
     * Test_Cases_For_Create_#BlueStore_Post
     * Author:- Gandahrva
     * Date:- 21-05-2020
     */
    @Test(priority = 37, enabled = true, alwaysRun = true, description = "Create BlueStore Post")
    public void TC_PWH_18_P1_VerifyCreateBlueStoreHashTagPost() throws Exception
    {
        String LogInRange = "Login!A6:C6";
        String BlueStoreRange = "BlueStore!A2:F2";
        String username = null;
        String password = null;
        String fullName = null;
        String action = null;
        dsriveAPI().downloadFileFromGoogleDrive(TEST_IMAGE_ID1);
        String imageFile = userDirPath + IMAGE_TEST_FILE1;

        Map<String, String> val = sheetAPI().getSpreadSheetRowValueByColumnName(TEST_DATA_GOOGLESHEET, LogInRange);
        username = val.get("UserName / Email / PhoneNumber");
        password = val.get("Password");
        fullName = val.get("FullName");

        getLoginPage().logIn("Action Step",fullName, "Valid username,password",username, password);

        val = sheetAPI().getSpreadSheetRowValueByColumnName(TEST_DATA_GOOGLESHEET, BlueStoreRange);
        action = val.get("Action");
        String title = val.get("Title");
        String description = val.get("Description_Values");
        String units = val.get("No. Units");
        String price = val.get("Price");


        getHomePageActions().clickOnPosterTextArea("Action Step");
        getHomePageActions().clickOnPostMenuDropdown("Action Step");
        getPostWithHashTagActions().selectHashTagFromDropdownList("Action Step",action);
        getHomePageActions().attachFile("Action Step",imageFile);
        getPostWithHashTagActions().verifyDisplayOfUploadedBlueStoreThumbnail("Verify Step");
        getPostWithHashTagActions().enterBlueStoreTitle("Action Step",title);
        getPostWithHashTagActions().enterBlueStoreDescription("Action Step",description);
        getPostWithHashTagActions().enterBlueStoreUnits("Action Step",units);
        getPostWithHashTagActions().enterBlueStorePrice("Action Step",price);
        getPostWithHashTagActions().clickOnBluestoreSubmitButton("Action Step");
        getPostWithHashTagActions().verifyDisplayOfCreatedBluestorePostOnFeed("Verify Step",title);
    }

    /**
     * Test_Cases_For_Edit_#BlueStore_Post
     * Author:- Gandahrva
     * Date:- 22-05-2020
     */
    @Test(priority = 38, enabled = true, alwaysRun = true, description = "Edit BlueStore Post")
    public void TC_PWH_19_P1_VerifyEditBlueStoreHashTagPost() throws Exception
    {
        String LogInRange = "Login!A6:C6";
        String BlueStoreRange = "BlueStore!A4:F4";
        String username = null;
        String password = null;
        String fullName = null;
        String action = null;
        dsriveAPI().downloadFileFromGoogleDrive(TEST_IMAGE_ID);
        String imageFile = userDirPath + IMAGE_TEST_FILE;

        Map<String, String> val = sheetAPI().getSpreadSheetRowValueByColumnName(TEST_DATA_GOOGLESHEET, LogInRange);
        username = val.get("UserName / Email / PhoneNumber");
        password = val.get("Password");
        fullName = val.get("FullName");

        getLoginPage().logIn("Action Step",fullName, "Valid username,password",username, password);

        val= sheetAPI().getSpreadSheetRowValueByColumnName(TEST_DATA_GOOGLESHEET, BlueStoreRange);
        action = val.get("Action");
        String title = val.get("Title");
        String description = val.get("Description_Values");
        String units = val.get("No. Units");
        String currency = val.get("Currency");
        String price = val.get("Price");

        getPostWithHashTagActions().clickOnMoreMenuInPostCard("Action Step");
        getPostWithHashTagActions().postMenuDropDownActions("Action Step",action);
        getHomePageActions().attachFile("Action Step",imageFile);
        getPostWithHashTagActions().verifyDisplayOfUploadedBlueStoreThumbnail("Verify Step");
        getPostWithHashTagActions().enterBlueStoreTitle("Action Step",title);
        getPostWithHashTagActions().enterBlueStoreDescription("Action Step",description);
        getPostWithHashTagActions().enterBlueStoreUnits("Action Step",units);
        getPostWithHashTagActions().selectCurrencyType("Action Step", currency);
        getPostWithHashTagActions().enterBlueStorePrice("Action Step",price);
        getPostWithHashTagActions().clickOnBluestoreSubmitButton("Action Step");
        getHomePageActions().clickOnHomeTopBar("Action Step");
        getPostWithHashTagActions().verifyDisplayOfCreatedBluestorePostOnFeed("Verify Step",title);
    }

    /**
     * Test_Cases_For_Share_#BlueStore_Post
     * Author:- Gandahrva
     * Date:- 22-05-2020
     */
    @Test(priority = 39, enabled = true, alwaysRun = true, description = "Share BlueStore Post")
    public void TC_PWH_20_P1_VerifyShareBlueStoreHashTagPost() throws Exception
    {
        String LogInRange = "Login!A6:C6";
        String BlueStoreRange = "BlueStore!B5:C5";

        String username = null;
        String password = null;
        String fullName = null;

        Map<String, String> val = sheetAPI().getSpreadSheetRowValueByColumnName(TEST_DATA_GOOGLESHEET, LogInRange);
        username = val.get("UserName / Email / PhoneNumber");
        password = val.get("Password");
        fullName = val.get("FullName");

        getLoginPage().logIn("Action Step", fullName,"Valid username,password",username, password);

        val = sheetAPI().getSpreadSheetRowValueByColumnName(TEST_DATA_GOOGLESHEET, BlueStoreRange);
        String message = val.get("Title");
        String title = val.get("Description_Values");

        getPostWithHashTagActions().clickOnShareButton("Action Step");
        getPostWithHashTagActions().clickOnShareMenuRepost("Action Step");
        getPostWithHashTagActions().verifyDisplayOfRepostPopUp("Verify Step");
        getPostWithHashTagActions().enterRepostMessage("Action Step",message);
        getPostWithHashTagActions().clickOnRePostShareButton("Action Step");
        getPostWithHashTagActions().verifyDisplayOfRepostHeaderOnTimeLine("Verify Step");
        getPostWithHashTagActions().verifyDisplayOfRepostedBluestorePostOnFeed("Verify Step",message);
        getPostWithHashTagActions().verifyDisplayOfCreatedBluestorePostOnFeed("Verify Step",title);
    }

    /**
     * Test_Cases_For_Delete_#BlueStore_Post
     * Author:- Gandahrva
     * Date:- 22-05-2020
     */
    @Test(priority = 40, enabled = true, alwaysRun = true, description = "Delete BlueStore Post")
    public void TC_PWH_2_P1_VerifyDeleteBlueStoreHashTagPost() throws Exception
    {
        String LogInRange = "Login!A6:C6";
        String BlueStoreCreateRange = "BlueStore!A7:F7";
        String BlueStoreDeleteRange = "BlueStore!A6:C6";
        String username = null;
        String password = null;
        String fullName = null;
        String action = null;
        dsriveAPI().downloadFileFromGoogleDrive(TEST_VIDEO_ID1);
        String videoFile = userDirPath + VIDEO_TEST_FILE1;

        Map<String, String> val = sheetAPI().getSpreadSheetRowValueByColumnName(TEST_DATA_GOOGLESHEET, LogInRange);
        username = val.get("UserName / Email / PhoneNumber");
        password = val.get("Password");
        fullName = val.get("FullName");

        getLoginPage().logIn("Action Step",fullName, "Valid username,password",username, password);

        val = sheetAPI().getSpreadSheetRowValueByColumnName(TEST_DATA_GOOGLESHEET, BlueStoreCreateRange);
        action = val.get("Action");
        String title = val.get("Title");
        String description = val.get("Description_Values");
        String units = val.get("No. Units");
        String price = val.get("Price");

        getHomePageActions().clickOnPosterTextArea("Action Step");
        getHomePageActions().clickOnPostMenuDropdown("Action Step");
        getPostWithHashTagActions().selectHashTagFromDropdownList("Action Step",action);
        getHomePageActions().attachFile("Action Step",videoFile);
        getPostWithHashTagActions().verifyDisplayOfUploadedBlueStoreThumbnail("Verify Step");
        getPostWithHashTagActions().enterBlueStoreTitle("Action Step",title);
        getPostWithHashTagActions().enterBlueStoreDescription("Action Step",description);
        getPostWithHashTagActions().enterBlueStoreUnits("Action Step",units);
        getPostWithHashTagActions().enterBlueStorePrice("Action Step",price);
        getPostWithHashTagActions().clickOnBluestoreSubmitButton("Action Step");
        getPostWithHashTagActions().verifyDisplayOfCreatedBluestorePostOnFeed("Verify Step",title);

        val = sheetAPI().getSpreadSheetRowValueByColumnName(TEST_DATA_GOOGLESHEET, BlueStoreDeleteRange);
        action = val.get("Action");
        String deleteTitle = val.get("Title");
        String header_value= val.get("Description_Values");

        getPostWithHashTagActions().deleteHashTagPost("Action Step",deleteTitle,header_value);
        getPostWithHashTagActions().clickOnMoreMenuInPostCard("Action Step");
        getPostWithHashTagActions().postMenuDropDownActions("Action Step",action);
        getPostCardActions().clickOnYesButton("Action Step");
        getPostWithHashTagActions().verifyDisplayOfDeletedBlueStorePost("Verify Step",deleteTitle);
    }

    /**
     * Test_Cases_For_Create_Opportunity_HashTag_Post
     * Author:- Gandahrva
     * Date:- 26-05-2020
     */
    @Test(priority = 41, enabled = true, alwaysRun = true, description = "Create an Opportunity Post")
    public void TC_PWH_22_P1_VerifyCreateOpportunityHashTagPostTest() throws Exception
    {
        String LogInRange = "Login!A6:C6";
        String OpportunityRange = "Opportunity!A3:D3";
        String username = null;
        String password = null;
        String fullName = null;
        String title=null;
        String description=null;
        String location=null;
        String category=null;

        dsriveAPI().downloadFileFromGoogleDrive(TEST_IMAGE_ID1);
        String imageFile = userDirPath + IMAGE_TEST_FILE1;

        Map<String, String> val = sheetAPI().getSpreadSheetRowValueByColumnName(TEST_DATA_GOOGLESHEET, LogInRange);
        username = val.get("UserName / Email / PhoneNumber");
        password = val.get("Password");
        fullName = val.get("FullName");

        getLoginPage().logIn("Action Step", fullName,"valid username, password",username, password);

        val= sheetAPI().getSpreadSheetRowValueByColumnName(TEST_DATA_GOOGLESHEET, OpportunityRange);
        title=val.get("Opportunity Title");
        description=val.get("Description");
        location=val.get("Location");
        category= val.get("category");

        getHomePageActions().clickOnPosterTextArea("Action Step");
        getHomePageActions().clickOnPostMenuDropdown("Action Step");
        getHomePageActions().clickOnOpportunityHashTag("Action Step");
        getHomePageActions().selectCategory("Action Step",category);
        getHomePageActions().enterOpportunityTitle("Action Step",title);
        getHomePageActions().enterOpportunityDescription("Action Step", description);
        getHomePageActions().enterOpportunityLocation("Action Step",location);
        getHomePageActions().attachFile("Action Step",imageFile);
        getHomePageActions().verifyDisplayOfOpportunityThumbnail("Verify Step");
        getHomePageActions().clickOnPostOpportunityButton("Action Step");
        getPostWithHashTagActions().verifyDisplayOfOpportunityPostCardOnFeed("Verify Step");
        getPostWithHashTagActions().verifyDisplayOfCreatedOpportunityPostOnFeed("Verify Step",title);
    }

    /**
     * Test_Cases_For_Contents_of_Opportunity_#Tag
     * Author:- Gandahrva
     * Date:- 26-05-2020
     */
    @Test(priority = 42, enabled = true, alwaysRun = true, description = "Contents of Opportunity Create PopUp")
    public void TC_PWH_23_P1_VerifyContentsOfCreateOpportunityHashTagPopUpTest() throws Exception
    {
        String LogInRange = "Login!A6:C6";
        String OpportunityRange = "Opportunity!A4:D4";
        String username = null;
        String password = null;
        String fullName = null;

        Map<String, String> val = sheetAPI().getSpreadSheetRowValueByColumnName(TEST_DATA_GOOGLESHEET, LogInRange);
        username = val.get("UserName / Email / PhoneNumber");
        password = val.get("Password");
        fullName = val.get("FullName");

        getLoginPage().logIn("Action Step", fullName,"valid username, password",username, password);

        val= sheetAPI().getSpreadSheetRowValueByColumnName(TEST_DATA_GOOGLESHEET, OpportunityRange);
        String tags= val.get("category");

        getHomePageActions().clickOnPosterTextArea("Action Step");
        getHomePageActions().clickOnPostMenuDropdown("Action Step");
        getHomePageActions().clickOnOpportunityHashTag("Action Step");
        getPostWithHashTagActions().verifyDisplayOfCategoryField("Verify Step");
        getPostWithHashTagActions().verifyDisplayOfCategoryOptionsList(tags,"Verify Step");
        getPostWithHashTagActions().verifyDisplayOfTitleField("Verify Step");
        getPostWithHashTagActions().verifyDisplayOfDescriptionField("Verify Step");
        getPostWithHashTagActions().verifyDisplayOfLocationField("Verify Step");
        getPostWithHashTagActions().verifyDisplayOfOpportunityPopUpCloseIcon("Verify Step");

    }

    /**
     * Test_Cases_For_Create_Portfolio_#Tag
     * Author:- Gandahrva
     * Date:- 27-05-2020
     */
    @Test(priority = 43, enabled = true, alwaysRun = true, description = "Create Portfolio Post")
    public void TC_PWH_24_P1_VerifyCreatePortfolioHashTagPostTest() throws Exception
    {
        String LogInRange = "Login!A6:C6";
        String PortfolioRange = "Portfolio!A2:C2";

        String username = null;
        String password = null;
        String fullName = null;
        String portfolioMessage=null;
        String action = null;
        dsriveAPI().downloadFileFromGoogleDrive(TEST_IMAGE_ID1);
        String imageFile = userDirPath + IMAGE_TEST_FILE1;

        Map<String, String> val = sheetAPI().getSpreadSheetRowValueByColumnName(TEST_DATA_GOOGLESHEET, LogInRange);
        username = val.get("UserName / Email / PhoneNumber");
        password = val.get("Password");
        fullName = val.get("FullName");

        getLoginPage().logIn("Action Step", fullName,"valid username, password",username, password);

        val = sheetAPI().getSpreadSheetRowValueByColumnName(TEST_DATA_GOOGLESHEET, PortfolioRange);
        action=val.get("Action");
        portfolioMessage= val.get("Title");
        String header = val.get("Description_Header_Values");

        getHomePageActions().clickOnPosterTextArea("Action Step");
        getHomePageActions().clickOnPostMenuDropdown("Action Step");
        getPostWithHashTagActions().selectHashTagFromDropdownList("Action Step",action);
        getHomePageActions().attachFile("Action Step",imageFile);
        getPostWithHashTagActions().verifyDisplayOfPortfolioThumbnail("Verify Step");
        getHomePageActions().enterTextOnMessageTextArea("Action Step", portfolioMessage);
        getPostWithHashTagActions().clickOnPortfolioSubmitButton("Action Step");

        getPostWithHashTagActions().verifyDisplayOfPortfolioPostOnFeed("Verify Step",portfolioMessage);
        getPostWithHashTagActions().verifyDisplayOfHashTagPostHeaderOnFeed("Verify Step",header);
        getPostWithHashTagActions().clickOnProfileDetails("Action Step");
        getPostWithHashTagActions().verifyDisplayOfPortfolioPostOnFeed("Verify Step",portfolioMessage);
        getPostWithHashTagActions().verifyDisplayOfHashTagPostHeaderOnFeed("Verify Step",header);
        getPostWithHashTagActions().clickOnPortfolioButtonOnProfilePage("Action Step");
        getPostWithHashTagActions().verifyDisplayOfPortfolioPostOnUserportfolio("Verify Step");
    }

    /**
     * Test_Cases_For_Create_Restricted_Content_Portfolio_#Tag
     * Author:- Gandahrva
     * Date:- 27-05-2020
     */
    @Test(priority = 44, enabled = true, alwaysRun = true, description = "Create Portfolio Restricted Post")
    public void TC_PWH_25_P1_VerifyCreatePortfolioHashTagRestrictedPostTest() throws Exception
    {
        String LogInRange = "Login!A6:C6";
        String PortfolioRange = "Portfolio!A3:B3";
        String username = null;
        String password = null;
        String fullName = null;
        String portfolioMessage=null;
        String action = null;
        dsriveAPI().downloadFileFromGoogleDrive(TEST_IMAGE_ID1);
        String imageFile = userDirPath + IMAGE_TEST_FILE1;

        Map<String, String> val = sheetAPI().getSpreadSheetRowValueByColumnName(TEST_DATA_GOOGLESHEET, LogInRange);
        username = val.get("UserName / Email / PhoneNumber");
        password = val.get("Password");
        fullName = val.get("FullName");

        getLoginPage().logIn("Action Step", fullName,"valid username, password",username, password);

        val = sheetAPI().getSpreadSheetRowValueByColumnName(TEST_DATA_GOOGLESHEET, PortfolioRange);
        action=val.get("Action");
        portfolioMessage= val.get("Title");

        getHomePageActions().clickOnPosterTextArea("Action Step");
        getHomePageActions().clickOnPostMenuDropdown("Action Step");
        getPostWithHashTagActions().selectHashTagFromDropdownList("Action Step",action);
        getHomePageActions().attachFile("Action Step",imageFile);
        getPostWithHashTagActions().verifyDisplayOfPortfolioThumbnail("Verify Step");
        getHomePageActions().enterTextOnMessageTextArea("Action Step", portfolioMessage);
        getPostWithHashTagActions().clickOnPortfolioRestrictedContentToggleButton("Action Step");
        getPostWithHashTagActions().verifyPortfolioRestrictedContentToggleIsEnabled("Verify Step");
        getPostWithHashTagActions().clickOnPortfolioSubmitButton("Action Step");

        getPostWithHashTagActions().verifyDisplayOfRestrictedContentCoveredPost("Verify Step");
        getPostWithHashTagActions().clickOnUnCoverButton("Action Step");
        getPostWithHashTagActions().verifyDisplayOfRestrictedContentUnCoveredPost("Verify Step");
        getPostWithHashTagActions().clickOnCoverButton("Action Step");

        getPostWithHashTagActions().clickOnProfileDetails("Action Step");

        getPostWithHashTagActions().verifyDisplayOfRestrictedContentCoveredPost("Verify Step");
        getPostWithHashTagActions().clickOnUnCoverButton("Action Step");
        getPostWithHashTagActions().verifyDisplayOfRestrictedContentUnCoveredPost("Verify Step");
        getPostWithHashTagActions().clickOnCoverButton("Action Step");
    }

    /**
     * Test_Cases_For_Portfolio_Post_Actions
     * Author:- Gandahrva
     * Date:- 27-05-2020
     */
    @Test(priority = 45, enabled = true, alwaysRun = true, description = "Portfolio Post Actions")
    public void TC_PWH_26_P1_VerifyActionsOfPortfolioPostInPortfolioInnerPageTest() throws Exception
    {
        //User_A
        String LogInRange = "Login!A6:C6";
        String PortfolioRange = "Portfolio!A4:G4";
        //String LoginRange = "Login!A6:C6";
        String username = null;
        String password = null;
        String fullName = null;

        dsriveAPI().downloadFileFromGoogleDrive(TEST_IMAGE_ID1);
        String imageFile = userDirPath + IMAGE_TEST_FILE1;

        Map<String, String> val = sheetAPI().getSpreadSheetRowValueByColumnName(TEST_DATA_GOOGLESHEET, LogInRange);
        username = val.get("UserName / Email / PhoneNumber");
        password = val.get("Password");
        fullName = val.get("FullName");

        getLoginPage().logIn("Action Step", fullName,"valid username, password",username, password);

        val = sheetAPI().getSpreadSheetRowValueByColumnName(TEST_DATA_GOOGLESHEET, PortfolioRange);
        String action=val.get("Action");
        String portfolioMessage= val.get("Title");
        String headerValue=val.get("Description_Header_Values");
        String activity1= val.get("Activity1");
        String activity2=val.get("Activity2");

        getHomePageActions().clickOnPosterTextArea("Action Step");
        getHomePageActions().clickOnPostMenuDropdown("Action Step");
        getPostWithHashTagActions().selectHashTagFromDropdownList("Action Step",action);
        getHomePageActions().attachFile("Action Step",imageFile);
        getPostWithHashTagActions().verifyDisplayOfPortfolioThumbnail("Verify Step");
        getHomePageActions().enterTextOnMessageTextArea("Action Step", portfolioMessage);
        getPostWithHashTagActions().clickOnPortfolioSubmitButton("Action Step");

        getPostWithHashTagActions().verifyDisplayOfPortfolioPostOnFeed("Verify Step",portfolioMessage);

        getHomePageActions().clickOnTopBarDropdown("Action Step");
        getHomePageActions().clickOnSignOut("Action Step");

        //User_B
        LogInRange = "Login!A7:C7";
        val = sheetAPI().getSpreadSheetRowValueByColumnName(TEST_DATA_GOOGLESHEET, LogInRange);
        username = val.get("UserName / Email / PhoneNumber");
        password = val.get("Password");
        fullName = val.get("FullName");

        getLoginPage().logIn("Action Step", fullName,"valid username, password ",username, password);

        getPostWithHashTagActions().clickOnCreatedHashTagPostOnFollowersFeed("Action Step",headerValue);
        String actualCount=getPostWithHashTagActions().getProfileActivityDetails("Action Step",activity1);
        getPostWithHashTagActions().clickOnLikeInPostInnerPage("Action Step");
        getPostWithHashTagActions().verifLikeAndShareCount("Verify Step",activity1,actualCount);
        getPostWithHashTagActions().getProfileActivityDetails("Action Step",activity1);

        actualCount=getPostWithHashTagActions().getProfileActivityDetails("Action Step",activity2);
        getPostWithHashTagActions().clickOnShareInPostInnerPage("Action Step");
        getPostWithHashTagActions().clickOnShareMenuRepost("Action Step");
        getPostWithHashTagActions().verifyDisplayOfRepostPopUp("Verify Step");
        getPostWithHashTagActions().clickOnRePostShareButton("Action Step");
        getPostWithHashTagActions().verifLikeAndShareCount("Verify Step",activity2,actualCount);
        getPostWithHashTagActions().getProfileActivityDetails("Action Step",activity2);

        getPostWithHashTagActions().clickOnBookmarkIconInPostInnerPage("Action Step");

        getPostWithHashTagActions().verifyDispalyOfViewProfileActivityDetails("Verify Step");
    }

    /**
     * Test_Cases_For_Edit_Portfolio_Post_Actions
     * Author:- Gandahrva
     * Date:- 28-05-2020
     */
    @Test(priority = 46, enabled = true, alwaysRun = true, description = "Portfolio Edit Post Actions")
    public void TC_PWH_27_P1_VerifyEditPortfolioPostTest() throws Exception
    {
        String LogInRange = "Login!A6:C6";
        String PortfolioRange = "Portfolio!A5:D5";
        String username = null;
        String password = null;
        String fullName = null;

        dsriveAPI().downloadFileFromGoogleDrive(TEST_IMAGE_ID1);
        String imageFile = userDirPath + IMAGE_TEST_FILE1;

        Map<String, String> val = sheetAPI().getSpreadSheetRowValueByColumnName(TEST_DATA_GOOGLESHEET, LogInRange);
        username = val.get("UserName / Email / PhoneNumber");
        password = val.get("Password");
        fullName = val.get("FullName");

        getLoginPage().logIn("Action Step", fullName,"valid username, password",username, password);

        val = sheetAPI().getSpreadSheetRowValueByColumnName(TEST_DATA_GOOGLESHEET, PortfolioRange);
        String action=val.get("Action");
        String portfolioMessage= val.get("Title");
        String  portfolioEditedMessage= val.get("Description_Header_Values");
        String activity = val.get("Activity1");

        getHomePageActions().clickOnPosterTextArea("Action Step");
        getHomePageActions().clickOnPostMenuDropdown("Action Step");
        getPostWithHashTagActions().selectHashTagFromDropdownList("Action Step",action);
        getHomePageActions().attachFile("Action Step",imageFile);
        getPostWithHashTagActions().verifyDisplayOfPortfolioThumbnail("Verify Step");
        getHomePageActions().enterTextOnMessageTextArea("Action Step", portfolioMessage);
        getPostWithHashTagActions().clickOnPortfolioSubmitButton("Action Step");

        getPostWithHashTagActions().verifyDisplayOfPortfolioPostOnFeed("Verify Step",portfolioMessage);

        getPostWithHashTagActions().clickOnMoreMenuInPostCard("Action Step");
        getPostWithHashTagActions().postMenuDropDownActions("Action Step",activity);
        getPostWithHashTagActions().postEditAction("Action Step",portfolioEditedMessage);
        getPostWithHashTagActions().saveEditedPostAction("Action Step");
        getPostWithHashTagActions().verifyDisplayOfEditedPost("Verify Step",portfolioEditedMessage);
    }

    /**
     * Test_Cases_For_Detele_Portfolio_Post
     * Author:- Gandahrva
     * Date:- 28-05-2020
     */
    @Test(priority = 47, enabled = true, alwaysRun = true, description = "Portfolio Delete Post Actions")
    public void TC_PWH_28_P1_VerifyDeletePortfolioPostTest() throws Exception
    {
        String LogInRange = "Login!A6:C6";
        String PortfolioRange = "Portfolio!A6:B6";
        String PortfolioRangeForDelete = "Portfolio!A7:C7";

        String username = null;
        String password = null;
        String fullName = null;

        dsriveAPI().downloadFileFromGoogleDrive(TEST_IMAGE_ID1);
        String imageFile = userDirPath + IMAGE_TEST_FILE1;

        Map<String, String> val = sheetAPI().getSpreadSheetRowValueByColumnName(TEST_DATA_GOOGLESHEET, LogInRange);
        username = val.get("UserName / Email / PhoneNumber");
        password = val.get("Password");
        fullName = val.get("FullName");

        getLoginPage().logIn("Action Step", fullName,"valid username, password",username, password);

        val = sheetAPI().getSpreadSheetRowValueByColumnName(TEST_DATA_GOOGLESHEET, PortfolioRange);
        String action=val.get("Action");
        String portfolioDeleteMessage= val.get("Title");

        getHomePageActions().clickOnPosterTextArea("Action Step");
        getHomePageActions().clickOnPostMenuDropdown("Action Step");
        getPostWithHashTagActions().selectHashTagFromDropdownList("Action Step",action);
        getHomePageActions().attachFile("Action Step",imageFile);
        getPostWithHashTagActions().verifyDisplayOfPortfolioThumbnail("Verify Step");
        getHomePageActions().enterTextOnMessageTextArea("Action Step", portfolioDeleteMessage);
        getPostWithHashTagActions().clickOnPortfolioSubmitButton("Action Step");

        getPostWithHashTagActions().verifyDisplayOfPortfolioPostOnFeed("Verify Step",portfolioDeleteMessage);

        val = sheetAPI().getSpreadSheetRowValueByColumnName(TEST_DATA_GOOGLESHEET, PortfolioRangeForDelete);
        action = val.get("Action");
        String deleteTitle = val.get("Title");
        String header_value= val.get("Description_Header_Values");

        getPostWithHashTagActions().deleteHashTagPost("Action Step",deleteTitle,header_value);
        getPostWithHashTagActions().clickOnMoreMenuInPostCard("Action Step");
        getPostWithHashTagActions().postMenuDropDownActions("Action Step",action);
        getPostCardActions().clickOnYesButton("Action Step");
        getPostWithHashTagActions().verifyDisplayOfDeletedPost("Verify Step",portfolioDeleteMessage);
    }

    @AfterMethod(dependsOnMethods = {"com.aeione.ops.generic.TestSetUp.afterMethod"})
    public void after() throws IOException
    {
        getHomePageActions().navigateHomePage();
        getHomePageActions().clickOnTopBarDropdown("Action Step");
        getHomePageActions().clickOnSignOut("Action Step");

    }
}
