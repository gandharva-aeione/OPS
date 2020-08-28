package com.aeione.ops.test;

import com.aeione.ops.generic.GoogleDriveAPI;
import com.aeione.ops.generic.GoogleSheetAPI;
import com.aeione.ops.generic.TestSetUp;
import com.aeione.ops.pageactions.HomePageActions;
import com.aeione.ops.pageactions.LoginPageActions;
import com.aeione.ops.pageactions.PostCardActions;
import com.aeione.ops.pageactions.RegistrationPageActions;
import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;

import java.io.IOException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class PostCardTest extends TestSetUp {
    public LoginPageActions getLoginPage() throws IOException {
        return new LoginPageActions();
    }
    public HomePageActions getHomePageActions() throws IOException {
        return new HomePageActions();
    }
    public PostCardActions getPostCardActions() throws IOException {
        return new PostCardActions();
    }
    public GoogleSheetAPI sheetAPI() throws IOException {
        return new GoogleSheetAPI();
    }
    public GoogleDriveAPI dsriveAPI() throws IOException {
        return new GoogleDriveAPI();
    }
    public RegistrationPageActions getRegistrationPage() throws IOException {
        return new RegistrationPageActions();
    }


    /**
     * Test_Cases_For_Contents_of_PostCard
     * Author:- Smita Sahoo
     */


  @Test(priority = 47, enabled = true, alwaysRun = true, description = "Verify content of Post Card")
    public void tc_PC_12_P1_VerifyContentsOfPostCardTest() throws Exception {

        String range = "Login!A7:C7";
        String range1 = "Home page!A2:B2";
        Map<String, String> val= sheetAPI().getSpreadSheetRowValueByColumnName(TEST_DATA_GOOGLESHEET, range);
        String username=val.get("UserName / Email / PhoneNumber");
        String password=val.get("Password");
        String fullname =val.get("FullName");
        val=sheetAPI().getSpreadSheetRowValueByColumnName(TEST_DATA_GOOGLESHEET, range1);
        String textPostVal = val.get("Post_Text");

        getLoginPage().logIn("Action Step", fullname, "valid username, password", username, password);
        getHomePageActions().clickOnPosterTextArea("Action Step");
        getHomePageActions().enterTextOnMessageTextArea("Action Step", textPostVal);
        getHomePageActions().clickOnPostButton("Action Step");
        getHomePageActions().verifyDisplayOfCreatedTextPost("Verify Step", textPostVal);
        getPostCardActions().verifyContentsOfPostCard("Verify Step");
    }

    /**
     * Test_Cases_For_Verification of the functionality of "Buy coins button" under Contribution popup
     * Author:- Smita Sahoo
     */

   @Test(priority = 48, enabled = true, alwaysRun = true, description = "Verify the functionality of Buy coins button under Contribution popup")
    public void tc_PC_02_P1_VerifyBuyCoinsButtonInContributionPopupTest() throws Exception {

        String range = "Login!A9:C9";
        Map<String, String> val= sheetAPI().getSpreadSheetRowValueByColumnName(TEST_DATA_GOOGLESHEET, range);
        String mobile_number = val.get("UserName / Email / PhoneNumber");
        String password = val.get("Password");
        String fullname = val.get("FullName");

        getLoginPage().logIn("Action Step", fullname, "mobile_number, password", mobile_number, password);
        getPostCardActions().clickOnContributeIcon("Action Step");
        getPostCardActions().verifyDisplayOfContributePopup("Verify Step");
        getPostCardActions().clickOnBuyCoinsButtonInContributePopup("Action Step");
        getPostCardActions().verifyDisplayOfBuyCoinsPopup("Verify Step");
        getPostCardActions().clickOnCancelButtonInBuyCoinsPopup("Action Step");

    }

    /**
     * Test_Cases_For_Verification of "yes button" is deleting the post or not in Delete page in own postcard.
     * Author:- Smita Sahoo
     */

  @Test(priority = 49, enabled = true, alwaysRun = true, description = "Verify that yes button is delete the post in Delete page")
    public void tc_PC_03_P1_VerifyDeletePostCardWithYesButtonTest() throws Exception {

        String range = "Login!A9:C9";
        String range1 = "Home page!A2:B2";

        Map<String, String> val= sheetAPI().getSpreadSheetRowValueByColumnName(TEST_DATA_GOOGLESHEET, range);
        String mobile_number=val.get("UserName / Email / PhoneNumber");
        String password=val.get("Password");
        String fullname=val.get("FullName");
        val = sheetAPI().getSpreadSheetRowValueByColumnName(TEST_DATA_GOOGLESHEET, range1);
        String textPostVal = val.get("Post_Text");

        getLoginPage().logIn("Action Step", fullname, "mobile_number, password", mobile_number, password);
        getHomePageActions().clickOnPosterTextArea("Action Step");
        getHomePageActions().enterTextOnMessageTextArea("Action Step", textPostVal);
        getHomePageActions().clickOnPostButton("Action Step");
        getHomePageActions().verifyDisplayOfCreatedTextPost("Verify Step", textPostVal);
        String time = getPostCardActions().getPostActivityTime("Action Step");
        getPostCardActions().clickOnMeatBallMenu("Action Step");
        getPostCardActions().clickOnDeleteOption("ActionStep");
        getPostCardActions().clickOnYesButton("Action Step");
        getPostCardActions().verifyPostCardIsDeleted("Verify Step", time);

    }

    /**
     * Test_Cases_For_Verification of "boost button" in own post card
     * Author:- Smita Sahoo
     */


    @Test(priority = 50, enabled = true, alwaysRun = true, description = "Verify the functionality of boost button in post card")
    public void tc_PC_04_P1_VerifyBoostButtonInPostCardTest() throws Exception {
        String range = "Login!A9:C9";
        String range1 = "Home page!A2:B2";
        Map<String, String> val= sheetAPI().getSpreadSheetRowValueByColumnName(TEST_DATA_GOOGLESHEET, range);
        String mobile_number=val.get("UserName / Email / PhoneNumber");
        String password=val.get("Password");
        String fullname =val.get("FullName");
        val = sheetAPI().getSpreadSheetRowValueByColumnName(TEST_DATA_GOOGLESHEET, range1);
        String textPostVal = val.get("Post_Text");

        getLoginPage().logIn("Action Step", fullname, "mobile_number, password", mobile_number, password);
        getHomePageActions().clickOnPosterTextArea("Action Step");
        getHomePageActions().enterTextOnMessageTextArea("Action Step", textPostVal);
        getHomePageActions().clickOnPostButton("Action Step");
        getHomePageActions().verifyDisplayOfCreatedTextPost("Verify Step", textPostVal);
        getPostCardActions().clickOnBoostButton("Action Step");
        getPostCardActions().verifyDisplayOfBoostPopup("Verify Step");
        getPostCardActions().clickOnCancelButtonInBoostPostPopup("Action Step");

    }

    /**
     * Test_Cases_For_Verification  of "share button" in own post card
     * Author:- Smita Sahoo
     */

    @Test(priority = 51, enabled = true, alwaysRun = true, description = "Verify that functionality of share button in post card")
    public void tc_PC_08_P2_VerifyShareButtonInPostCardTest() throws Exception {
        String range = "Login!A9:C9";
        String range1 = "Home page!A2:B2";

        Map<String, String> val= sheetAPI().getSpreadSheetRowValueByColumnName(TEST_DATA_GOOGLESHEET, range);
        String mobile_number=val.get("UserName / Email / PhoneNumber");
        String password=val.get("Password");
        String fullname =val.get("FullName");
        val = sheetAPI().getSpreadSheetRowValueByColumnName(TEST_DATA_GOOGLESHEET, range1);
        String textPostVal = val.get("Post_Text");

        getLoginPage().logIn("Action Step", fullname, "mobile_number, password", mobile_number, password);
        getHomePageActions().clickOnPosterTextArea("Action Step");
        getHomePageActions().enterTextOnMessageTextArea("Action Step", textPostVal);
        getHomePageActions().clickOnPostButton("Action Step");
        getHomePageActions().verifyDisplayOfCreatedTextPost("Verify Step", textPostVal);
        getPostCardActions().clickOnShareButton("Action Step");
        getPostCardActions().clickOnRepostButton("Action Step");
        getPostCardActions().verifyDisplayOfRepostPopup("Verify Step");
        getPostCardActions().clickOnCancelButtonInRepostPopup("Action Step");


    }

    /**
     * Test_Cases_For_Verification  of "like button" in own post card
     * Author:- Smita Sahoo
     */

   @Test(priority = 52, enabled = true, alwaysRun = true, description = "Verify the like button function in post card")
    public void tc_PC_09_P2_VerifyLikeButtonInPostcardTest() throws Exception {
        String range = "Login!A9:C9";
        String range1 = "Home page!A2:B2";

        Map<String, String> val= sheetAPI().getSpreadSheetRowValueByColumnName(TEST_DATA_GOOGLESHEET, range);
        String mobile_number=val.get("UserName / Email / PhoneNumber");
        String password=val.get("Password");
        String fullname =val.get("FullName");
        val = sheetAPI().getSpreadSheetRowValueByColumnName(TEST_DATA_GOOGLESHEET, range1);
        String textPostVal = val.get("Post_Text");

        getLoginPage().logIn("Action Step", fullname, "mobile_number, password", mobile_number, password);
        getHomePageActions().clickOnPosterTextArea("Action Step");
        getHomePageActions().enterTextOnMessageTextArea("Action Step", textPostVal);
        getHomePageActions().clickOnPostButton("Action Step");
        getHomePageActions().verifyDisplayOfCreatedTextPost("Verify Step", textPostVal);
        String before_like_count = getPostCardActions().verifyBeforePostLikeCount("Verify Step");
        getPostCardActions().clickOnLikeButton("Action Step");
        getPostCardActions().verifyAfterPostLikeCount("verify step" , before_like_count);


    }

    /**
     * Test_Cases_For_Verification  of "comment button" in own post card
     * Author:- Smita Sahoo
     */
    @Test(priority = 53, enabled = true, alwaysRun = true, description = "Verify commenting on post")
    public void tc_PC_10_P2_VerifyCommentOnPostTest() throws Exception {
        String range = "Login!A9:C9";
        String range1 = "Home page!A2:B2";

        Map<String, String> val= sheetAPI().getSpreadSheetRowValueByColumnName(TEST_DATA_GOOGLESHEET, range);
        String mobile_number=val.get("UserName / Email / PhoneNumber");
        String password=val.get("Password");
        String fullname =val.get("FullName");
        val = sheetAPI().getSpreadSheetRowValueByColumnName(TEST_DATA_GOOGLESHEET, range1);
        String textPostVal = val.get("Post_Text");

        getLoginPage().logIn("Action Step", fullname, "mobile_number, password", mobile_number, password);
        getHomePageActions().clickOnPosterTextArea("Action Step");
        getHomePageActions().enterTextOnMessageTextArea("Action Step", textPostVal);
        getHomePageActions().clickOnPostButton("Action Step");
        getHomePageActions().verifyDisplayOfCreatedTextPost("Verify Step", textPostVal);
        getPostCardActions().clickOnCommentButton("Action Step");
        getPostCardActions().verifyDisplayOfPostCardCommentSection("Verify Step");
        getPostCardActions().enterTextOnCommentTextArea("Action Step", textPostVal);
        getPostCardActions().clickOnCommentSectionPostButton("Action Step");
        getPostCardActions().verifyDisplayOfAddedCommentToPost("Verify Step", textPostVal);

    }


    /**
     * Test_Cases_For_Verification  of like, Comment, Share, view and contribute count on the post card of follower user
     * Author:- Smita Sahoo
     */
   @Test(priority = 54, enabled = true, alwaysRun = true, description = "Verify Contents Of Followed User Postcard ")
    public void tc_PC_11_P1_VerifyContentsOfFollowedUserPostcardTest() throws Exception {

        String range = "Login!A7:C7";
        String range1 = "Login!A9:C9";
        String range2 = "Home page!A2:B2";
        Map<String, String> val= sheetAPI().getSpreadSheetRowValueByColumnName(TEST_DATA_GOOGLESHEET, range);
        String username_A=val.get("UserName / Email / PhoneNumber");
        String password_A=val.get("Password");
        String fullname =val.get("FullName");
        val = sheetAPI().getSpreadSheetRowValueByColumnName(TEST_DATA_GOOGLESHEET, range2);
        String textPostVal = val.get("Post_Text");

        getLoginPage().logIn("Action Step", fullname, "valid mobile_no, password", username_A, password_A);
        getHomePageActions().clickOnPosterTextArea("Action Step");
        getHomePageActions().enterTextOnMessageTextArea("Action Step", textPostVal);
        getHomePageActions().clickOnPostButton("Action step");
        getHomePageActions().clickOnTopBarDropdown("Action Step");
        getHomePageActions().clickOnSignOut("Action Step");
        val = sheetAPI().getSpreadSheetRowValueByColumnName(TEST_DATA_GOOGLESHEET, range1);
        String mobile_number=val.get("UserName / Email / PhoneNumber");
        String password=val.get("Password");
        fullname =val.get("FullName");
        getLoginPage().logIn("Action Step", fullname, "mobile_number, password", mobile_number, password);
        getHomePageActions().verifyDisplayOfFollowedUserPost("Verify Step", textPostVal);
        getPostCardActions().verifyContentsOfFollowedUserPostCard("Verify Step");
        String before_like_count = getPostCardActions().verifyBeforePostLikeCount("Action Step");
        getPostCardActions().clickOnLikeButton("Action Step");
        getPostCardActions().verifyAfterPostLikeCount("verify step", before_like_count);
        getPostCardActions().clickOnCommentButton("Action Step");
        getPostCardActions().verifyDisplayOfPostCardCommentSection("Verify Step");
        getPostCardActions().enterTextOnCommentTextArea("Action Step", textPostVal);
        getPostCardActions().clickOnCommentSectionPostButton("Action Step");
        getPostCardActions().verifyDisplayOfAddedCommentToPost("Verify Step", textPostVal);
        String before_share_count = getPostCardActions().verifyBeforePostShareCount("verify Step");
        getPostCardActions().clickOnShareButton("Action Step");
        getPostCardActions().clickOnRepostButton("Action Step");
        getPostCardActions().verifyDisplayOfRepostPopup("Verify Step");
        getPostCardActions().clickOnShareButtonInRepostPopup("Action Step");
        getPostCardActions().verifyAfterPostShareCount("verify step", before_share_count);

    }

    /**
     * Test_Cases_For_Verification of the Repost- post functionality
     * Author:- Smita Sahoo
     */
    @Test(priority = 55, enabled = true, alwaysRun = true, description = "Verify the Repost- post functionality")
    public void tc_PC_14_P1_VerifyRepostPostTest() throws Exception {

        String range = "Login!A9:C9";
        String range1 = "Home page!A1:B1";
        String range2 = "Home page!A8:B8";

        Map<String, String> val= sheetAPI().getSpreadSheetRowValueByColumnName(TEST_DATA_GOOGLESHEET, range);
        String mobile_number=val.get("UserName / Email / PhoneNumber");
        String password=val.get("Password");
        String fullname =val.get("FullName");
        val = sheetAPI().getSpreadSheetRowValueByColumnName(TEST_DATA_GOOGLESHEET, range1);
        String textPostVal = val.get("Post_Text");
        val = sheetAPI().getSpreadSheetRowValueByColumnName(TEST_DATA_GOOGLESHEET, range2);
        String textRepostVal = val.get("Post_Text");

        getLoginPage().logIn("Action Step", fullname, "mobile_number, password", mobile_number, password);
        getHomePageActions().clickOnPosterTextArea("Action Step");
        getHomePageActions().enterTextOnMessageTextArea("Action Step", textPostVal);
        getHomePageActions().clickOnPostButton("Action Step");
        getHomePageActions().verifyDisplayOfCreatedTextPost("Verify Step", textPostVal);
        getPostCardActions().clickOnShareButton("Action Step");
        getPostCardActions().clickOnRepostButton("Action Step");
        getPostCardActions().verifyDisplayOfRepostPopup("Verify Step");
        getPostCardActions().enterTextOnRepostTextArea("Action Step", textRepostVal);
        getPostCardActions().clickOnShareButtonInRepostPopup("Action Step");
        getPostCardActions().verifyDisplayOfRepostedTextPost("Verify Step",textRepostVal);
    }

    /**
     * Test_Cases_For_Verification of "the functionality of boost from post card"
     * Author:- Smita Sahoo
     */
    @Test(priority = 56, enabled = true, alwaysRun = true, description = "Verify boost from post card")
    public void tc_PC_13_P1_VerifyBoostPostCardTest() throws Exception {

        String HomeRange = "Home page!A2:A2";
        String PostcardRange = "Postcard!A2:B2";
        String RegistrationRange = "Registration!A4:H";
        String LogInRange = "Login!A19:C19";
        String fullName = null;
        String username = null;
        String password = null;
        ArrayList<String> responseinfo = null;
        String response = null;

        Map<String, String> val1 = sheetAPI().getSpreadSheetRowValueByColumnName(TEST_DATA_GOOGLESHEET, RegistrationRange);
        fullName = getRegistrationPage().getFullName();
        String userName = getRegistrationPage().getUserName(val1.get("UserName"));
        String emailAddress = getRegistrationPage().getEmail(val1.get("Email Address"));
        String countryCode = val1.get("Country Code");
        String dateOfBirth = val1.get("Date of birth");
        String createPassword = getRegistrationPage().getRandomValidPassword(val1.get("Create Password"));
        String skipOtp = val1.get("Skip OTP");
        String phoneNumber = getRegistrationPage().getPhoneNumber(val1.get("Phone Number"));

        responseinfo = getRegistrationPage().mobileVerifyApi("Action Step", phoneNumber, countryCode, skipOtp);
        response = responseinfo.get(0);
        String secret = responseinfo.get(1);

        getRegistrationPage().verifyMobileApi("Verify Step", response);
        response = getRegistrationPage().mobileConfirmApi("Action Step", phoneNumber, secret, skipOtp, countryCode);
        getRegistrationPage().verifyMobileConfirmApi("Verify Step", response);
        response = getRegistrationPage().registerApi("Action & verify", fullName, userName, phoneNumber, countryCode, secret, emailAddress, dateOfBirth, createPassword, skipOtp);
        getRegistrationPage().verifyRegisterApi("Verify Step", response);

        List<List<Object>> values = Arrays.asList(Arrays.asList(userName, createPassword, fullName));
        sheetAPI().updateMultipleCellValues(TEST_DATA_GOOGLESHEET, LogInRange, "USER_ENTERED", values);

        val1 = sheetAPI().getSpreadSheetRowValueByColumnName(TEST_DATA_GOOGLESHEET, LogInRange);
        username = val1.get("UserName / Email / PhoneNumber");
        password = val1.get("Password");
        fullName = val1.get("FullName");


        Map<String, String> val=sheetAPI().getSpreadSheetRowValueByColumnName(TEST_DATA_GOOGLESHEET, HomeRange);
        String textPostVal = val.get("Post_Text");
        val=sheetAPI().getSpreadSheetRowValueByColumnName(TEST_DATA_GOOGLESHEET, PostcardRange);
        String impressiontextVal = val.get("Impressions");

        getLoginPage().logIn("Action Step", fullName, "valid username, password", username, password);
        getLoginPage().clickOnTopicSkipButton("Action Step");
        getHomePageActions().clickOnPosterTextArea("Action Step");
        getHomePageActions().enterTextOnMessageTextArea("Action Step", textPostVal);
        getHomePageActions().clickOnPostButton("Action Step");
        getHomePageActions().verifyDisplayOfCreatedTextPost("Verify Step", textPostVal);
        getPostCardActions().clickOnBoostButton("Action Step");
        getPostCardActions().clickOnBoostImpressionTextArea("Action Step");
        getPostCardActions().enterImpressionOnBoostImpressionTextArea("Action Step", impressiontextVal);
        getPostCardActions().clickOnBoostButton("Action Step");
        getHomePageActions().clickOnTopBarDropdown("Action Step");
        getPostCardActions().clickOnBoostConsole("Action Step");
        getPostCardActions().verifyDisplayOfBoostedTextPost("Verify Step", textPostVal);
        getPostCardActions().verifyContentsOfBoostedPost("Verify Step");

    }


    @AfterMethod(dependsOnMethods = {"com.aeione.ops.generic.TestSetUp.afterMethod"})
    public void after() throws IOException {
        getHomePageActions().navigateHomePage();
        getHomePageActions().clickOnTopBarDropdown("Action Step");
        getHomePageActions().clickOnSignOut("Action Step");

    }
}
