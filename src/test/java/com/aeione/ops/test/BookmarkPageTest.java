package com.aeione.ops.test;
import com.aeione.ops.generic.GoogleDriveAPI;
import com.aeione.ops.generic.GoogleSheetAPI;
import com.aeione.ops.generic.TestSetUp;
import com.aeione.ops.pageactions.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class BookmarkPageTest extends TestSetUp {
    public LoginPageActions getLoginPage() throws IOException {
        return new LoginPageActions();
    }
    public HomePageActions getHomePageActions() throws IOException {
        return new HomePageActions();
    }
    public PostCardActions getPostCardActions() throws IOException {
        return new PostCardActions();
    }
    public BookmarkPageActions getBookmarkPageActions() throws IOException {
        return new BookmarkPageActions();
    }
    public RegistrationPageActions getRegistrationPage() throws IOException {
        return new RegistrationPageActions();
    }
    public SearchActions getSearchActions() throws IOException {
        return new SearchActions();
    }
    public GoogleSheetAPI sheetAPI() throws Exception {
        return new GoogleSheetAPI();
    }
    public GoogleDriveAPI dsriveAPI() throws IOException {
        return new GoogleDriveAPI();
    }

    /**
     * Test_Cases_For_"BOOKMARK" functionality  for users posts
     * Author:- Smita Sahoo
     */
    @Test(priority = 98, enabled = true, alwaysRun = true, description = "Verify BOOKMARK icon  for own posts")
    public void tc_BM_01_P1_verifyBookmarkIconInCreatedPostTest() throws Exception {
        String range = "Login!A9:C9";
        String range1 = "Home page!A2:B2";

        Map<String, String> val = sheetAPI().getSpreadSheetRowValueByColumnName(TEST_DATA_GOOGLESHEET, range);
        String mobile_number = val.get("UserName / Email / PhoneNumber");
        String password = val.get("Password");
        String fullname = val.get("FullName");
        val = sheetAPI().getSpreadSheetRowValueByColumnName(TEST_DATA_GOOGLESHEET, range1);
        String textPostVal = val.get("Post_Text");

        getLoginPage().logIn("Action Step", fullname, "mobile_number, password", mobile_number, password);
        getHomePageActions().clickOnPosterTextArea("Action Step");
        getHomePageActions().enterTextOnMessageTextArea("Action Step", textPostVal);
        getHomePageActions().clickOnPostButton("Action Step");
        getHomePageActions().verifyDisplayOfCreatedTextPost("Verify Step", textPostVal);
        getPostCardActions().verifyDisplayOfBookmarkLink("Verify Step");
    }

    /**
     * Test_Cases_For_"BOOKMARK" icon is displayed  for  "FOLLOWED USER" posts
     * Author:- Smita Sahoo
     */
    @Test(priority = 99, enabled = true, alwaysRun = true, description = "Verify BOOKMARK icon  for followed users  posts")
    public void tc_BM_02_P1_verifyBookmarkIconInfollowedUserPostTest() throws Exception {

        String range = "Login!A7:C7";
        String range1 = "Login!A9:C9";
        String range2 = "Home page!A2:B1";

        Map<String, String> val = sheetAPI().getSpreadSheetRowValueByColumnName(TEST_DATA_GOOGLESHEET, range);
        String username_A = val.get("UserName / Email / PhoneNumber");
        String password_A = val.get("Password");
        String fullname = val.get("FullName");
        val = sheetAPI().getSpreadSheetRowValueByColumnName(TEST_DATA_GOOGLESHEET, range2);
        String textPostVal = val.get("Post_Text");

        getLoginPage().logIn("Action Step", fullname, "valid mobile_no, password", username_A, password_A);
        getHomePageActions().clickOnPosterTextArea("Action Step");
        getHomePageActions().enterTextOnMessageTextArea("Action Step", textPostVal);
        getHomePageActions().clickOnPostButton("Action step");
        getHomePageActions().clickOnTopBarDropdown("Action Step");
        getHomePageActions().clickOnSignOut("Action Step");

        val = sheetAPI().getSpreadSheetRowValueByColumnName(TEST_DATA_GOOGLESHEET, range1);
        String mobile_number = val.get("UserName / Email / PhoneNumber");
        String password = val.get("Password");
        fullname = val.get("FullName");

        getLoginPage().logIn("Action Step", fullname, "mobile_number, password", mobile_number, password);
        getHomePageActions().verifyDisplayOfFollowedUserPost("Verify Step", textPostVal);
        getPostCardActions().verifyDisplayOfBookmarkLink("Verify Step");
    }

    /**
     * Test_Cases_For_"BOOKMARK" functionality  for "FOLLOWING USER" posts
     * Author:- Smita Sahoo
     */
    @Test(priority = 100, enabled = true, alwaysRun = true, description = "Verify BOOKMARK functionality for Following users  posts")
    public void tc_BM_03_P1_verifyBookmarkInfollowingUserPostTest() throws Exception {
        String range = "Login!A9:C9";
        String range1 = "Home page!A5:B5";
        Map<String, String> val = sheetAPI().getSpreadSheetRowValueByColumnName(TEST_DATA_GOOGLESHEET, range);
        String mobile_number = val.get("UserName / Email / PhoneNumber");
        String password = val.get("Password");
        String fullname = val.get("FullName");
        val = sheetAPI().getSpreadSheetRowValueByColumnName(TEST_DATA_GOOGLESHEET, range1);
        String textPostVal = val.get("Post_Text");

        getLoginPage().logIn("Action Step", fullname, "mobile_number, password", mobile_number, password);

        getHomePageActions().clickOnPosterTextArea("Action Step");
        getHomePageActions().enterTextOnMessageTextArea("Action Step", textPostVal);
        getHomePageActions().clickOnPostButton("Action Step");
        getHomePageActions().verifyDisplayOfCreatedTextPost("Verify Step", textPostVal);
        getHomePageActions().clickOnTopBarDropdown("Action Step");
        getHomePageActions().clickOnSignOut("Action Step");


        String RegistrationRange = "Registration!A4:H";

        String LogInRange = "Login!A19:C19";
        String range2 = "Login!A9:C9";
        String fullName = null;
        String username_B = null;
        String password_B = null;
        ArrayList<String> responseinfo = null;
        String response = null;

        ArrayList<String> val1 = sheetAPI().getSpreadSheetValuesOfSpecificRow(TEST_DATA_GOOGLESHEET, RegistrationRange);
        fullName = getRegistrationPage().getFullName();
        String userName = getRegistrationPage().getUserName(val1.get(1));
        String emailAddress = getRegistrationPage().getEmail(val1.get(2));
        String countryCode = val1.get(3);
        String dateOfBirth = val1.get(5);
        String createPassword = getRegistrationPage().getRandomValidPassword(val1.get(6));
        String skipOtp = val1.get(7);
        String phoneNumber = getRegistrationPage().getPhoneNumber(val1.get(4));

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

        val1 = sheetAPI().getSpreadSheetValuesOfSpecificRow(TEST_DATA_GOOGLESHEET, LogInRange);
        username_B = val1.get(0);
        password_B = val1.get(1);
        fullName = val1.get(2);
        Map<String, String> val2 = sheetAPI().getSpreadSheetRowValueByColumnName(TEST_DATA_GOOGLESHEET, range2);
        String username_to_search = val2.get("FullName");
        val2 = sheetAPI().getSpreadSheetRowValueByColumnName(TEST_DATA_GOOGLESHEET, range1);
        String PostVal = val2.get("Post_Text");
        getLoginPage().logIn("Action Step", fullName, "valid username, password", username_B, password_B);
        getLoginPage().clickOnTopicSkipButton("Action Step");
        getSearchActions().enterUsernameOnSearchTextFieldAndSelectUserName("Action Step", username_to_search);
        getBookmarkPageActions().clickOnFollowButton("Action Step");
        getHomePageActions().clickOnHomeTopBar("Action Step");
        getHomePageActions().verifyDisplayOfFollowedUserPost("Verify Step", PostVal);
        getPostCardActions().verifyDisplayOfBookmarkLink("Verify Step");
        getBookmarkPageActions().clickOnBookmarkIcon("Action Step");
        getBookmarkPageActions().moveCursorToBookmarkIcon("Action Step");
        getBookmarkPageActions().verifyDisplayOfBookMarkedToolTip("Verify Step");

    }

    /**
     * Test_Cases_to_Verify user is able to select any filters in bookmark page.
     * Author:- Smita Sahoo
     */
    @Test(priority = 101, enabled = true, alwaysRun = true, description = "Verify user  is able to select any filters in bookmark page")
    public void tc_BM_04_P1_verifyBookmarkIconInfollowedUserPostTest() throws Exception {

        String range = "Login!A19:C19";
        String range1 = "Login!A9:C9";
        String range2 = "Home page!A3:B3";
        Map<String, String> val = sheetAPI().getSpreadSheetRowValueByColumnName(TEST_DATA_GOOGLESHEET, range1);
        String mobile_number = val.get("UserName / Email / PhoneNumber");
        String password = val.get("Password");
        String fullname = val.get("FullName");
        val = sheetAPI().getSpreadSheetRowValueByColumnName(TEST_DATA_GOOGLESHEET, range2);
        String textPostVal = val.get("Post_Text");

        getLoginPage().logIn("Action Step", fullname, "valid mobile_no, password", mobile_number, password);
        getHomePageActions().clickOnPosterTextArea("Action Step");
        getHomePageActions().enterTextOnMessageTextArea("Action Step", textPostVal);
        getHomePageActions().clickOnPostButton("Action step");
        getHomePageActions().clickOnTopBarDropdown("Action Step");
        getHomePageActions().clickOnSignOut("Action Step");

        val = sheetAPI().getSpreadSheetRowValueByColumnName(TEST_DATA_GOOGLESHEET, range);
        String username_B = val.get("UserName / Email / PhoneNumber");
        String password_B = val.get("Password");
        fullname = val.get("FullName");
        Map<String, String> val2 = sheetAPI().getSpreadSheetRowValueByColumnName(TEST_DATA_GOOGLESHEET, range2);
        String PostVal = val2.get("Post_Text");

        getLoginPage().logIn("Action Step", fullname, "username, password", username_B, password_B);
        getHomePageActions().verifyDisplayOfFollowedUserPost("Verify Step", PostVal);
        getBookmarkPageActions().clickOnBookmarkIcon("Action Step");
        getBookmarkPageActions().clickOnBookmarksModule("Action Steps");

        getBookmarkPageActions().clickOnBlogFilterRadioButton("Action Step");
        getBookmarkPageActions().verifyBlogFilterRadiobuttonIsEnable("Verify Step");

        getBookmarkPageActions().clickOnOpportunitiesFilterRadioButton("Action Step");
        getBookmarkPageActions().verifyOpportunitiesFilterRadiobuttonIsEnable("Verify Step");

        getBookmarkPageActions().clickOnEventsFilterRadioButton("Action Step");
        getBookmarkPageActions().verifyEventsFilterRadiobuttonIsEnable("Verify Step");

        getBookmarkPageActions().clickOnBlueStoresFilterRadioButton("Action Step");
        getBookmarkPageActions().verifyBlueStoresFilterRadiobuttonIsEnable("Verify Step");

        getBookmarkPageActions().clickOnPostsFilterRadioButton("Action Step");
        getBookmarkPageActions().verifyPostsFilterRadiobuttonIsEnable("Verify Step");

        getBookmarkPageActions().clickOnProfileFilterRadioButton("Action Step");
        getBookmarkPageActions().verifyProfileFilterRadiobuttonIsEnable("Verify Step");

        getBookmarkPageActions().clickOnAllFilterRadioButton("Action Step");
        getBookmarkPageActions().verifyAllFilterRadiobuttonIsEnable("Verify Step");
    }

    /**
     * Test_Cases_to_Verify contents in bookmarked post
     * Author:- Smita Sahoo
     */
    @Test(priority = 102, enabled = true, alwaysRun = true, description = "Verify contents in bookmarked post")
    public void tc_BM_05_P1_verifyBookmarkInfollowingUserPostTest() throws Exception {
        String range = "Login!A9:C9";
        String range1 = "Home page!A5:B5";
        Map<String, String> val = sheetAPI().getSpreadSheetRowValueByColumnName(TEST_DATA_GOOGLESHEET, range);
        String mobile_number = val.get("UserName / Email / PhoneNumber");
        String password = val.get("Password");
        String fullname = val.get("FullName");
        val = sheetAPI().getSpreadSheetRowValueByColumnName(TEST_DATA_GOOGLESHEET, range1);
        String textPostVal = val.get("Post_Text");
        getLoginPage().logIn("Action Step", fullname, "mobile_number, password", mobile_number, password);
        getHomePageActions().clickOnPosterTextArea("Action Step");
        getHomePageActions().enterTextOnMessageTextArea("Action Step", textPostVal);
        getHomePageActions().clickOnPostButton("Action Step");
        getHomePageActions().verifyDisplayOfCreatedTextPost("Verify Step", textPostVal);
        getHomePageActions().clickOnTopBarDropdown("Action Step");
        getHomePageActions().clickOnSignOut("Action Step");
        String RegistrationRange = "Registration!A4:H";
        String LogInRange = "Login!A19:C19";
        String range2 = "Login!A9:C9";
        String fullName = null;
        String username_B = null;
        String password_B = null;
        ArrayList<String> responseinfo = null;
        String response = null;

        ArrayList<String> val1 = sheetAPI().getSpreadSheetValuesOfSpecificRow(TEST_DATA_GOOGLESHEET, RegistrationRange);
        fullName = getRegistrationPage().getFullName();
        String userName = getRegistrationPage().getUserName(val1.get(1));
        String emailAddress = getRegistrationPage().getEmail(val1.get(2));
        String countryCode = val1.get(3);
        String dateOfBirth = val1.get(5);
        String createPassword = getRegistrationPage().getRandomValidPassword(val1.get(6));
        String skipOtp = val1.get(7);
        String phoneNumber = getRegistrationPage().getPhoneNumber(val1.get(4));

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

        val1 = sheetAPI().getSpreadSheetValuesOfSpecificRow(TEST_DATA_GOOGLESHEET, LogInRange);
        username_B = val1.get(0);
        password_B = val1.get(1);
        fullName = val1.get(2);
        Map<String, String> val2 = sheetAPI().getSpreadSheetRowValueByColumnName(TEST_DATA_GOOGLESHEET, range2);
        String username_to_search = val2.get("FullName");
        val2 = sheetAPI().getSpreadSheetRowValueByColumnName(TEST_DATA_GOOGLESHEET, range1);
        String PostVal = val2.get("Post_Text");
        getLoginPage().logIn("Action Step", fullName, "valid username, password", username_B, password_B);
        getLoginPage().clickOnTopicSkipButton("Action Step");
        getSearchActions().enterUsernameOnSearchTextFieldAndSelectUserName("Action Step", username_to_search);
        getBookmarkPageActions().clickOnFollowButton("Action Step");
        getHomePageActions().clickOnHomeTopBar("Action Step");
        getHomePageActions().verifyDisplayOfFollowedUserPost("Verify Step", PostVal);
        getPostCardActions().verifyDisplayOfBookmarkLink("Verify Step");
        getBookmarkPageActions().clickOnBookmarkIcon("Action Step");
        getBookmarkPageActions().clickOnBookmarksModule("Action Steps");
        getBookmarkPageActions().verifyContentsOfBookmarkedPost("Verify Step");
    }

    @AfterMethod(dependsOnMethods = {"com.aeione.ops.generic.TestSetUp.afterMethod"})
    public void after() throws IOException {
        getHomePageActions().navigateHomePage();
        getHomePageActions().clickOnTopBarDropdown("Action Step");
        getHomePageActions().clickOnSignOut("Action Step");
    }
}
