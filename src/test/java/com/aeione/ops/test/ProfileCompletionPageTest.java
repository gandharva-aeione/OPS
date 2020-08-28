package com.aeione.ops.test;

import com.aeione.ops.generic.GoogleDriveAPI;
import com.aeione.ops.generic.GoogleSheetAPI;
import com.aeione.ops.generic.TestSetUp;
import com.aeione.ops.pageactions.*;
import com.google.api.services.sheets.v4.model.CellFormat;
import com.google.api.services.sheets.v4.model.Color;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @author Kirthana SS
 * Tests on Profile and profile completion functionalities
 */
public class ProfileCompletionPageTest extends TestSetUp {

    public LoginPageActions getLoginPage() throws IOException {
        return new LoginPageActions();
    }

    public HomePageActions getHomePageActions() throws IOException {
        return new HomePageActions();
    }

    public ProfilePageActions getProfilePageActions() throws IOException {
        return new ProfilePageActions();
    }

    public ProfileCompletionPageActions getProfileCompletionPageActions() throws IOException {
        return new ProfileCompletionPageActions();
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

    public SearchActions getSearchActions() throws IOException {
        return new SearchActions();
    }

    public GenericPageActions genericpageactions() throws IOException {
        return new GenericPageActions();}


    /**
     * Verify Upload Cover Image
     * @autor Kirthana
     * @throws Exception
     */
    @Test(priority = 64, enabled = true, alwaysRun = true, description = "Verify the functionality of uploading profile image")
    public void tc_PCM_01_P1_VerifyUploadProfileImageTest() throws Exception
    {

        dsriveAPI().downloadFileFromGoogleDrive(TEST_IMAGE_ID);
        String imageFile = userDirPath + IMAGE_TEST_FILE;

        //Registration
        String registrationRange = "Registration!A2:H2";

        ArrayList<String> responseinfo = null;
        String response = null;

        ArrayList<String> val = sheetAPI().getSpreadSheetValuesOfSpecificRow(TEST_DATA_GOOGLESHEET, registrationRange);
        String fullName = getRegistrationPage().getFullName();
        String userName = getRegistrationPage().getUserName(val.get(1));
        String emailAddress = getRegistrationPage().getEmail(val.get(2));
        String countryCode = val.get(3);
        String dateOfBirth = val.get(5);
        String createPassword = getRegistrationPage().getRandomValidPassword(val.get(6));
        String skipOtp = val.get(7);
        String phoneNumber = getRegistrationPage().getPhoneNumber(val.get(4));

        responseinfo = getRegistrationPage().mobileVerifyApi("Action Step", phoneNumber, countryCode, skipOtp);
        response = responseinfo.get(0);
        String secret = responseinfo.get(1);

        getRegistrationPage().verifyMobileApi("Verify Step", response);
        response = getRegistrationPage().mobileConfirmApi("Action Step", phoneNumber, secret, skipOtp, countryCode);
        getRegistrationPage().verifyMobileConfirmApi("Verify Step", response);
        response = getRegistrationPage().registerApi("Action & verify", fullName, userName, phoneNumber, countryCode, secret, emailAddress, dateOfBirth, createPassword, skipOtp);
        getRegistrationPage().verifyRegisterApi("Verify Step", response);

        List<List<Object>> values1 = Arrays.asList(Arrays.asList(fullName,userName,emailAddress, countryCode,phoneNumber,dateOfBirth,createPassword,skipOtp));
        sheetAPI().appendRowData(TEST_DATA_GOOGLESHEET,constantRow,  "USER_ENTERED", values1);

        //Update values in sheet
        List<List<Object>> values2 = Arrays.asList(Arrays.asList(userName, createPassword, fullName));
        String  loginRange = "Login!A12:C12";

        sheetAPI().updateMultipleCellValues(TEST_DATA_GOOGLESHEET, loginRange, "USER_ENTERED", values2);

        List<List<Object>> values3 = Arrays.asList(Arrays.asList(userName, fullName));
        String searchRange = "Search!A2:B2";
        sheetAPI().updateMultipleCellValues(TEST_DATA_GOOGLESHEET, searchRange, "USER_ENTERED", values3);

        //Login
        Map<String, String> loginvalues = sheetAPI().getSpreadSheetRowValueByColumnName(TEST_DATA_GOOGLESHEET, loginRange);
        String username=loginvalues.get("UserName / Email / PhoneNumber");
        String password=loginvalues.get("Password");
        String fullname=loginvalues.get("FullName");

        getLoginPage().logIn("Action Step", fullname, "valid username, password", username, password);
        getLoginPage().clickOnTopicSkipButton("Action Step");
        getHomePageActions().clickOnTopBarDropdown("Action Step");
        getProfilePageActions().clickOnViewProfileLink("Action Step");
        genericpageactions().attachFile("Action Step",imageFile);
        getProfilePageActions().clickOnApplyButtonOfEditPicturePopUp("Action Step");

    }

    /**
     * @autor Kirthana
     * @throws Exception
     * Verify Upload Cover Image
     */
    @Test(priority = 65, enabled =true, alwaysRun = true, description = "Verify the functionality of uploading cover image")
    public void tc_PCM_02_P1_VerifyUploadCoverImageTest() throws Exception
    {

        dsriveAPI().downloadFileFromGoogleDrive(TEST_IMAGE_ID1);
        String imageFile = userDirPath + IMAGE_TEST_FILE1;

        String  loginRange = "Login!A12:C12";
        Map<String, String> loginvalues = sheetAPI().getSpreadSheetRowValueByColumnName(TEST_DATA_GOOGLESHEET, loginRange);
        String username=loginvalues.get("UserName / Email / PhoneNumber");
        String password=loginvalues.get("Password");
        String fullname=loginvalues.get("FullName");

        getLoginPage().logIn("Action Step", fullname, "valid username, password", username, password);
        getHomePageActions().clickOnTopBarDropdown("Action Step");
        getProfilePageActions().clickOnViewProfileLink("Action Step");
        getProfileCompletionPageActions().clickOnCoverImageEditIcon("Action Step");
        genericpageactions().attachFile("Action Step",imageFile);
        getProfileCompletionPageActions().clickOnCoverImageSaveIcon("Actions");
        getProfileCompletionPageActions().verifyDisplayOfCoverImage("Verify Step");
    }


    /**
     * @autor Kirthana
     * @throws Exception
     * Verify Edit Cover Image
     */
    @Test(priority = 66, enabled = true, alwaysRun = true, description = "Verify Edit Cover Image")
    public void tc_PCM_03_P1_VerifyEditCoverImageTest() throws Exception
    {

        dsriveAPI().downloadFileFromGoogleDrive(TEST_IMAGE_ID2);
        String imageFile2 = userDirPath + IMAGE_TEST_FILE2;

        String  loginRange = "Login!A12:C12";
        Map<String, String> loginvalues = sheetAPI().getSpreadSheetRowValueByColumnName(TEST_DATA_GOOGLESHEET, loginRange);
        String username=loginvalues.get("UserName / Email / PhoneNumber");
        String password=loginvalues.get("Password");
        String fullname=loginvalues.get("FullName");

        getLoginPage().logIn("Action Step", fullname, "valid username, password", username, password);
        getHomePageActions().clickOnTopBarDropdown("Action Step");
        getProfilePageActions().clickOnViewProfileLink("Action Step");
        getProfileCompletionPageActions().clickOnCoverImageEditIcon("Action Step");
        genericpageactions().attachFile("Action Step",imageFile2);
        getProfileCompletionPageActions().clickOnCoverImageSaveIcon("Actions");
        getProfileCompletionPageActions().verifyDisplayOfCoverImage("Verify Step");

    }


    /**
     *
     * @autor Kirthana
     * @throws Exception
     * Verify Contents of cover icons
     */
    @Test(priority = 67, enabled = true, alwaysRun = true, description = "Verify contents of cover icons")
    public void tc_PCM_04_P1_VerifyContentsCoverIconsTest() throws Exception
    {
        dsriveAPI().downloadFileFromGoogleDrive(TEST_IMAGE_ID1);
        String imageFile = userDirPath + IMAGE_TEST_FILE1;

        String  loginRange = "Login!A12:C12";
        Map<String, String> loginvalues = sheetAPI().getSpreadSheetRowValueByColumnName(TEST_DATA_GOOGLESHEET, loginRange);
        String username=loginvalues.get("UserName / Email / PhoneNumber");
        String password=loginvalues.get("Password");
        String fullname=loginvalues.get("FullName");

        getLoginPage().logIn("Action Step", fullname, "valid username, password", username, password);
        getHomePageActions().clickOnTopBarDropdown("Action Step");
        getProfilePageActions().clickOnViewProfileLink("Action Step");
        getProfileCompletionPageActions().clickOnCoverImageEditIcon("Action Step");
        getProfileCompletionPageActions().verifyDisplayOfCoverIcons("Verify Step");

    }

    /**
     * @autor Kirthana
     * @throws Exception
     * Verify Contents of cover icons
     */
    @Test(priority = 68, enabled = true, alwaysRun = true, description = "Verify the funtonality of deleting an added cover image")
    public void tc_PCM_05_P1_VerifyDeleteCoverImageTest() throws Exception
    {
        String  loginRange = "Login!A12:C12";
        Map<String, String> loginvalues = sheetAPI().getSpreadSheetRowValueByColumnName(TEST_DATA_GOOGLESHEET, loginRange);
        String username=loginvalues.get("UserName / Email / PhoneNumber");
        String password=loginvalues.get("Password");
        String fullname=loginvalues.get("FullName");

        getLoginPage().logIn("Action Step", fullname, "valid username, password", username, password);
        getHomePageActions().clickOnTopBarDropdown("Action Step");
        getProfilePageActions().clickOnViewProfileLink("Action Step");
        getProfileCompletionPageActions().clickOnCoverImageEditIcon("Action Step");
        getProfileCompletionPageActions().clickOnCoverImageDeleteIcon("Action Step");
        getProfileCompletionPageActions().clickOnCoverImageSaveIcon("Action Step");
        getProfileCompletionPageActions().verifyNotDisplayOfCoverImage("Verify Step");

    }


    /**
     * @throws Exception
     * @autor Kirthana
     * Verify Contents of General Info Tab
     */
    @Test(priority = 69, enabled = true, alwaysRun = true, description = "Verify contents  \"General info\" tab ")
    public void tc_PCM_06_P1_VerifyContentsOfGeneralInfoTabTest() throws Exception {

        String  loginRange = "Login!A12:C12";
        Map<String, String> loginvalues = sheetAPI().getSpreadSheetRowValueByColumnName(TEST_DATA_GOOGLESHEET, loginRange);
        String username=loginvalues.get("UserName / Email / PhoneNumber");
        String password=loginvalues.get("Password");
        String fullname=loginvalues.get("FullName");

        getLoginPage().logIn("Action Step", fullname, "valid username, password", username, password);
        getHomePageActions().clickOnTopBarDropdown("Action Step");
        getProfilePageActions().clickOnViewProfileLink("Action Step");
        getProfileCompletionPageActions().clickOnEditIconOfAboutSection("Action Step");
        getProfileCompletionPageActions().clickOnGenralInfoTab("Action Step");
        getProfileCompletionPageActions().verifyContentsOfGeneralInfoTab("Verify Step");

    }

    /**
     * @throws Exception
     * @autor Kirthana
     * Verify Edit general info
     */
    @Test(priority = 70, enabled = true, alwaysRun = true, description = "Verify the functionality of \"Save changes\" button  in general info tab ")
    public void TC_PCM_07_P1_VerifyEditGeneralInfoSectionTest() throws Exception {

        String  loginRange = "Login!A12:C12";
        Map<String, String> loginvalues = sheetAPI().getSpreadSheetRowValueByColumnName(TEST_DATA_GOOGLESHEET, loginRange);
        String username=loginvalues.get("UserName / Email / PhoneNumber");
        String password=loginvalues.get("Password");
        String fullname=loginvalues.get("FullName");


        String range = "EditProfile!A2:C2";
        Map<String, String> ecditprofileval = sheetAPI().getSpreadSheetRowValueByColumnName(TEST_DATA_GOOGLESHEET, range);
        String newfullname =ecditprofileval.get("Full Name");
        String addSkills = ecditprofileval.get("Skills");

        getLoginPage().logIn("Action Step", fullname, "valid username, password", username, password);
        getHomePageActions().clickOnTopBarDropdown("Action Step");
        getProfilePageActions().clickOnViewProfileLink("Action Step");
        getProfileCompletionPageActions().clickOnEditIconOfAboutSection("Action Step");
        getProfileCompletionPageActions().clickOnGenralInfoTab("Action Step");
        getProfileCompletionPageActions().enterValueOfFullName("Action Step", newfullname);
        getProfileCompletionPageActions().enterSkillsTag("Action Step", addSkills.split(",")[1]);
        getProfileCompletionPageActions().clickOnGeneralInfoSaveChangesButton("Action Step");
    }


    /**
     * @throws Exception
     * @autor Kirthana
     * Verify contents of About Tab
     */
    @Test(priority = 71, enabled = true, alwaysRun = true, description = "Verify Contents of \"About\" Tab ")
    public void tc_PCM_08_P1_VerifyContentsOfAboutTabTest() throws Exception {

        String  loginRange = "Login!A12:C12";
        Map<String, String> loginvalues = sheetAPI().getSpreadSheetRowValueByColumnName(TEST_DATA_GOOGLESHEET, loginRange);
        String username=loginvalues.get("UserName / Email / PhoneNumber");
        String password=loginvalues.get("Password");
        String fullname=loginvalues.get("FullName");

        getLoginPage().logIn("Action Step", fullname, "valid username, password", username, password);
        getHomePageActions().clickOnTopBarDropdown("Action Step");
        getProfilePageActions().clickOnViewProfileLink("Action Step");
        getProfileCompletionPageActions().clickOnEditIconOfAboutSection("Action Step");
        getProfileCompletionPageActions().verifyContentsOfAboutTab("Verify Step");
    }

    /**
     * @throws Exception
     * @autor  Kirthana SS
     * Verify contents of About Tab
     */
    @Test(priority = 72, enabled = true , alwaysRun = true, description = "Verify Edit Info  ")
    public void tc_PCM_09_P1_VerifyEditAboutSectionTest() throws Exception {

        String  loginRange = "Login!A12:C12";
        Map<String, String> loginvalues = sheetAPI().getSpreadSheetRowValueByColumnName(TEST_DATA_GOOGLESHEET, loginRange);
        String username=loginvalues.get("UserName / Email / PhoneNumber");
        String password=loginvalues.get("Password");
        String fullname=loginvalues.get("FullName");

        String range = "EditProfile!A2:H1";

        ArrayList<String> val = sheetAPI().getSpreadSheetValues(TEST_DATA_GOOGLESHEET, range, 2);
        String description = val.get(2);
        String gender = val.get(3);
        String dob = val.get(4);
        String knownLanguage = val.get(5);
        String heightInCM = val.get(6);
        String weightInKg = val.get(7);

        getLoginPage().logIn("Action Step", fullname, "valid username, password", username, password);
        getHomePageActions().clickOnTopBarDropdown("Action Step");
        getProfilePageActions().clickOnViewProfileLink("Action Step");
        getProfileCompletionPageActions().clickOnEditIconOfAboutSection("Action Step");
        getProfileCompletionPageActions().enterValueOfDescription("Action Step", description);
        getProfileCompletionPageActions().selectGender("Action Step", gender);
        getProfileCompletionPageActions().enterDOB("Action Step", dob);
        getProfileCompletionPageActions().enterLanguagesKnown("Action Step", knownLanguage);
        getProfileCompletionPageActions().enterHeightInCM("Action Step", heightInCM);
        getProfileCompletionPageActions().enterWeightInKG("Action Step", weightInKg);
        getProfileCompletionPageActions().clickOnAboutSectionSaveButton("Action Step");

    }


    /**
     * @throws Exception
     * @autor Kirthana SS
     * Verify user location Visible to Everyone
     */
    @Test(priority = 73, enabled = true, alwaysRun = true, description = " Verify the functionality of Checkbox related to \"Visible to Everyone\"  ")
    public void tc_PCM_10_P1_VerifyUserLocationVisibleToEveryoneTest() throws Exception {
        String registerrange = "Registration!A2:H";

        ArrayList<String> responseinfo = null;
        String response = null;

        ArrayList<String> val = sheetAPI().getSpreadSheetValuesOfSpecificRow(TEST_DATA_GOOGLESHEET, registerrange);
        String fullName = getRegistrationPage().getFullName();
        String userName = getRegistrationPage().getUserName(val.get(1));
        String emailAddress = getRegistrationPage().getEmail(val.get(2));
        String countryCode = val.get(3);
        String dateOfBirth = val.get(5);
        String createPassword = getRegistrationPage().getRandomValidPassword(val.get(6));
        String skipOtp = val.get(7);
        String phoneNumber = getRegistrationPage().getPhoneNumber(val.get(4));

        responseinfo = getRegistrationPage().mobileVerifyApi("Action Step", phoneNumber, countryCode, skipOtp);
        response = responseinfo.get(0);
        String secret = responseinfo.get(1);

        getRegistrationPage().verifyMobileApi("Verify Step", response);
        response = getRegistrationPage().mobileConfirmApi("Action Step", phoneNumber, secret, skipOtp, countryCode);
        getRegistrationPage().verifyMobileConfirmApi("Verify Step", response);
        response = getRegistrationPage().registerApi("Action & verify", fullName, userName, phoneNumber, countryCode, secret, emailAddress, dateOfBirth, createPassword, skipOtp);
        getRegistrationPage().verifyRegisterApi("Verify Step", response);

        List<List<Object>> values = Arrays.asList(Arrays.asList(userName, createPassword, fullName));
        String loginrange = "Login!A13:C13";
        sheetAPI().updateMultipleCellValues(TEST_DATA_GOOGLESHEET, loginrange, "USER_ENTERED", values);


        String editprofilerange = "EditProfile!A2:AA1";

        val = sheetAPI().getSpreadSheetValues(TEST_DATA_GOOGLESHEET, editprofilerange, 2);
        String contactLocation = val.get(25);
        String contactLocationVisibleOption = val.get(26);


        String  userAloginRange = "Login!A12:C12";
        Map<String, String> loginvalues = sheetAPI().getSpreadSheetRowValueByColumnName(TEST_DATA_GOOGLESHEET, userAloginRange);
        String username=loginvalues.get("UserName / Email / PhoneNumber");
        String password=loginvalues.get("Password");
        String fullname=loginvalues.get("FullName");


        getLoginPage().logIn("Action Step", fullname, "valid username, password", username, password);
        getHomePageActions().clickOnTopBarDropdown("Action Step");
        getProfilePageActions().clickOnViewProfileLink("Action Step");
        getProfileCompletionPageActions().clickOnEditIconOfAboutSection("Action Step");
        getProfileCompletionPageActions().clickOnCantactTab("Action Step");
        getProfileCompletionPageActions().enterContactLocation("Action Step", contactLocation);
        getProfileCompletionPageActions().clickContactLocationVisibleButton("Action Step");
        getProfileCompletionPageActions().selectContactLocationVisibleOption("Action Step", contactLocationVisibleOption.split("\\,")[0].trim());
        getProfileCompletionPageActions().clickContactUpdationSaveChangesButton("Action Step");
        getHomePageActions().clickOnTopBarDropdown("Action Step");
        getHomePageActions().clickOnSignOut("Action Step");

        String userBloginrange = "Login!A13:C13";
        loginvalues = sheetAPI().getSpreadSheetRowValueByColumnName(TEST_DATA_GOOGLESHEET, userBloginrange);
         username=loginvalues.get("UserName / Email / PhoneNumber");
         password=loginvalues.get("Password");
         fullname=loginvalues.get("FullName");

        String searchrange = "Search!A2:B2";
        val = sheetAPI().getSpreadSheetValuesOfSpecificRow(TEST_DATA_GOOGLESHEET, searchrange);
        String searchUserName = val.get(0);

        getLoginPage().logIn("Action Step", fullname, "valid username, password", username, password);
        getLoginPage().clickOnTopicSkipButton("Action Step");
        getSearchActions().enterUsernameOnSearchTextFieldAndSelectUserName("Action Step", searchUserName);
        getSearchActions().clickOnProfileTab("Action Step");
        //Update script
        getProfileCompletionPageActions().clickOnFollowButton("Action Step");

        //Need to add verify display of location


    }


    /**
     * @throws Exception
     * @autor Kirthana SS
     * Verify user location Visible to people who follows you
     */
    @Test(priority = 74, enabled = true, alwaysRun = true, description = " Verify the functionality of Checkbox related to \"Visible to people who follows you\"  ")
    public void tc_PCM_11_P1_VerifyUserLocationVisibleToPeopleWhoFollowsYouTest() throws Exception {


        //User A
        String  userAloginRange = "Login!A12:C12";
        Map<String, String> loginvalues = sheetAPI().getSpreadSheetRowValueByColumnName(TEST_DATA_GOOGLESHEET, userAloginRange);
        String username=loginvalues.get("UserName / Email / PhoneNumber");
        String password=loginvalues.get("Password");
        String fullname=loginvalues.get("FullName");

        String editProfilerange = "EditProfile!A2:AA1";
        ArrayList<String> val = sheetAPI().getSpreadSheetValues(TEST_DATA_GOOGLESHEET, editProfilerange, 2);
        String contactLocation = val.get(25);
        String contactLocationVisibleOption = val.get(26);

        getLoginPage().logIn("Action Step", fullname, "valid username, password", username, password);
        getHomePageActions().clickOnTopBarDropdown("Action Step");
        getProfilePageActions().clickOnViewProfileLink("Action Step");
        getProfileCompletionPageActions().clickOnEditIconOfAboutSection("Action Step");
        getProfileCompletionPageActions().clickOnCantactTab("Action Step");
        getProfileCompletionPageActions().enterContactLocation("Action Step", contactLocation);
        getProfileCompletionPageActions().clickContactLocationVisibleButton("Action Step");
        getProfileCompletionPageActions().selectContactLocationVisibleOption("Action Step", contactLocationVisibleOption.split("\\,")[1].trim());
        getProfileCompletionPageActions().clickContactUpdationSaveChangesButton("Action Step");
        getHomePageActions().clickOnTopBarDropdown("Action Step");
        getHomePageActions().clickOnSignOut("Action Step");

        //User B
       String userBloginRange = "Login!A13:C13";
        val = sheetAPI().getSpreadSheetValuesOfSpecificRow(TEST_DATA_GOOGLESHEET, userBloginRange);
        username = val.get(0);
        password = val.get(1);
        fullname = val.get(2);

        String searchrange = "Search!A2:B2";
        val = sheetAPI().getSpreadSheetValuesOfSpecificRow(TEST_DATA_GOOGLESHEET, searchrange);
        String searchUserName = val.get(0);

        getLoginPage().logIn("Action Step", fullname, "valid username, password", username, password);
        getSearchActions().enterUsernameOnSearchTextFieldAndSelectUserName("Action Step", searchUserName);
        getSearchActions().clickOnProfileTab("Action Step");
        getProfileCompletionPageActions().clickOnFollowButton("Action Step");

        //Need to add verify display of location


    }


    /**
     * @throws Exception
     * @autor Kirthana SS
     * Verify user location Visible to people you follow
     */
    @Test(priority = 75, enabled = true, alwaysRun = true, description = " Verify that a following user can see the user location if Checkbox related to \"Visible to people you follow\" is selected")
    public void tc_PCM_12_P1_VerifyUserLocationVisibleToPeopleYouFollowTest() throws Exception {


        //User A
        String  userAloginRange = "Login!A12:C12";
        Map<String, String> loginvalues = sheetAPI().getSpreadSheetRowValueByColumnName(TEST_DATA_GOOGLESHEET, userAloginRange);
        String username=loginvalues.get("UserName / Email / PhoneNumber");
        String password=loginvalues.get("Password");
        String fullname=loginvalues.get("FullName");

        String editProfilerange = "EditProfile!A2:AA1";
        ArrayList<String> val = sheetAPI().getSpreadSheetValues(TEST_DATA_GOOGLESHEET, editProfilerange, 2);
        String contactLocation = val.get(25);
        String contactLocationVisibleOption = val.get(26);

        String followingUserSearchRange = "Search!A3:B3";
        val = sheetAPI().getSpreadSheetValuesOfSpecificRow(TEST_DATA_GOOGLESHEET, followingUserSearchRange);
        String searchFollowingUserName = val.get(0);

        getLoginPage().logIn("Action Step", fullname, "valid username, password", username, password);
        getHomePageActions().clickOnTopBarDropdown("Action Step");
        getProfilePageActions().clickOnViewProfileLink("Action Step");
        getProfileCompletionPageActions().clickOnEditIconOfAboutSection("Action Step");
        getProfileCompletionPageActions().clickOnCantactTab("Action Step");
        getProfileCompletionPageActions().enterContactLocation("Action Step", contactLocation);
        getProfileCompletionPageActions().clickContactLocationVisibleButton("Action Step");
        getProfileCompletionPageActions().selectContactLocationVisibleOption("Action Step", contactLocationVisibleOption.split("\\,")[2].trim());
        getProfileCompletionPageActions().clickContactUpdationSaveChangesButton("Action Step");
        getSearchActions().enterUsernameOnSearchTextFieldAndSelectUserName("Action Step", searchFollowingUserName);
        getSearchActions().clickOnProfileTab("Action Step");
        getProfileCompletionPageActions().clickOnFollowButton("Action Step");
        getHomePageActions().clickOnTopBarDropdown("Action Step");
        getHomePageActions().clickOnSignOut("Action Step");

        //User B
        String userBloginRange = "Login!A13:C13";
        val = sheetAPI().getSpreadSheetValuesOfSpecificRow(TEST_DATA_GOOGLESHEET, userBloginRange);
        username = val.get(0);
        password = val.get(1);
        fullname = val.get(2);

        String followedUserSearchRange = "Search!A2:B2";
        val = sheetAPI().getSpreadSheetValuesOfSpecificRow(TEST_DATA_GOOGLESHEET, followedUserSearchRange);
        String searchUserName = val.get(0);

        getLoginPage().logIn("Action Step", fullname, "valid username, password", username, password);
        getSearchActions().enterUsernameOnSearchTextFieldAndSelectUserName("Action Step", searchUserName);
        getSearchActions().clickOnProfileTab("Action Step");

        //Need to add verify display of location


    }


    /**
     * @throws Exception
     * @autor Kirthana SS
     * Verify user location Visible to only me
     */
    @Test(priority = 76, enabled = true, alwaysRun = true, description = " Verify the functionality of \"Only me\" option Related to 'Location' field")
    public void tc_PCM_13_P1_VerifyUserLocationVisibleToOnlyMeTest() throws Exception {


        //User A
        String  userAloginRange = "Login!A12:C12";
        Map<String, String> loginvalues = sheetAPI().getSpreadSheetRowValueByColumnName(TEST_DATA_GOOGLESHEET, userAloginRange);
        String username=loginvalues.get("UserName / Email / PhoneNumber");
        String password=loginvalues.get("Password");
        String fullname=loginvalues.get("FullName");

        String editProfilerange = "EditProfile!A2:AA1";
        ArrayList<String> val = sheetAPI().getSpreadSheetValues(TEST_DATA_GOOGLESHEET, editProfilerange, 2);
        String contactLocation = val.get(25);
        String contactLocationVisibleOption = val.get(26);


        getLoginPage().logIn("Action Step", fullname, "valid username, password", username, password);
        getHomePageActions().clickOnTopBarDropdown("Action Step");
        getProfilePageActions().clickOnViewProfileLink("Action Step");
        getProfileCompletionPageActions().clickOnEditIconOfAboutSection("Action Step");
        getProfileCompletionPageActions().clickOnCantactTab("Action Step");
        getProfileCompletionPageActions().enterContactLocation("Action Step", contactLocation);
        getProfileCompletionPageActions().clickContactLocationVisibleButton("Action Step");
        getProfileCompletionPageActions().selectContactLocationVisibleOption("Action Step", contactLocationVisibleOption.split("\\,")[3].trim());
        getProfileCompletionPageActions().clickContactUpdationSaveChangesButton("Action Step");
        getHomePageActions().clickOnTopBarDropdown("Action Step");
        getHomePageActions().clickOnSignOut("Action Step");

        //User B
        String userBloginRange = "Login!A13:C13";
        val = sheetAPI().getSpreadSheetValuesOfSpecificRow(TEST_DATA_GOOGLESHEET, userBloginRange);
        username = val.get(0);
        password = val.get(1);
        fullname = val.get(2);

        String followedUserSearchRange = "Search!A2:B2";
        val = sheetAPI().getSpreadSheetValuesOfSpecificRow(TEST_DATA_GOOGLESHEET, followedUserSearchRange);
        String searchUserName = val.get(0);

        getLoginPage().logIn("Action Step", fullname, "valid username, password", username, password);
        getSearchActions().enterUsernameOnSearchTextFieldAndSelectUserName("Action Step", searchUserName);
        getSearchActions().clickOnProfileTab("Action Step");

        //Update script as per search field
        Assert.fail("Should display user profile card");

        //Need to add verify display of location


    }

    /**
     * @throws Exception
     * @autor  Kirthana SS
     * Verify Add work experience
     */
    @Test(priority = 77, enabled = true, alwaysRun = true, description = "Verify \"Add Work experience\"  ")
    public void tc_PCM_14_P1_VerifyAddWorkExperienceTest() throws Exception {

        String  loginRange = "Login!A12:C12";
        Map<String, String> loginvalues = sheetAPI().getSpreadSheetRowValueByColumnName(TEST_DATA_GOOGLESHEET, loginRange);
        String username=loginvalues.get("UserName / Email / PhoneNumber");
        String password=loginvalues.get("Password");
        String fullname=loginvalues.get("FullName");

        String range = "EditProfile!A2:R1";

        ArrayList<String> val = sheetAPI().getSpreadSheetValues(TEST_DATA_GOOGLESHEET, range, 2);
        String designation = val.get(8);
        String companyname = val.get(9);
        String workLocation = val.get(10);
        String currentlyWorkingHere = val.get(11);
        String workStartMonth = val.get(12);
        String workStartYear = val.get(13);
        String showworkexperienceonprofile = val.get(16);
        String workstartmontherrormessage = val.get(17);


        getLoginPage().logIn("Action Step", fullname, "valid username, password", username, password);
        getHomePageActions().clickOnTopBarDropdown("Action Step");
        getProfilePageActions().clickOnViewProfileLink("Action Step");
        getProfileCompletionPageActions().clickOnEditIconOfAboutSection("Action Step");
        getProfileCompletionPageActions().clickOnWorkTab("Action Step");
        getProfileCompletionPageActions().clickOnAddWorkExperienceButton("Action Step");
        getProfileCompletionPageActions().enterDesignation("Action Step", designation);
        getProfileCompletionPageActions().enterCompanyName("Action Step", companyname);
        getProfileCompletionPageActions().enterWorkLocation("Action Step", workLocation);
        getProfileCompletionPageActions().clickOnCurrentlyWorkingHereRadioButton("Action Step", currentlyWorkingHere);
        getProfileCompletionPageActions().selectWorkStartMonth("Action Step", workStartMonth);
        getProfileCompletionPageActions().selectWorkStartYear("Action Step", workStartYear);
        getProfileCompletionPageActions().clickOnShowWorkExperienceOnProfileRadioButton("Action Step", showworkexperienceonprofile);
        getProfileCompletionPageActions().clickOnWorkSectionSaveButton("Action Step", workstartmontherrormessage);
    }

    /**
     * @throws Exception
     * @autor Kirthana SS
     * Verify edit work experience
     */
    @Test(priority = 78, enabled = true, alwaysRun = true, description = "Verify \"Edit Work experience\"  ")
    public void tc_PCM_15_P1_VerifyEditWorkExperienceTest() throws Exception {

        String  loginRange = "Login!A12:C12";
        Map<String, String> loginvalues = sheetAPI().getSpreadSheetRowValueByColumnName(TEST_DATA_GOOGLESHEET, loginRange);
        String username=loginvalues.get("UserName / Email / PhoneNumber");
        String password=loginvalues.get("Password");
        String fullname=loginvalues.get("FullName");

        String range = "EditProfile!A3:R1";

        ArrayList<String> val = sheetAPI().getSpreadSheetValues(TEST_DATA_GOOGLESHEET, range, 3);
        String designation = val.get(8);
        String companyname = val.get(9);
        String workLocation = val.get(10);
        String workStartMonth = val.get(12);
        String workStartYear = val.get(13);
        String workstartmontherrormessage = val.get(17);

        getLoginPage().logIn("Action Step", fullname, "valid username, password", username, password);
        getHomePageActions().clickOnTopBarDropdown("Action Step");
        getProfilePageActions().clickOnViewProfileLink("Action Step");
        getProfileCompletionPageActions().clickOnEditIconOfAboutSection("Action Step");
        getProfileCompletionPageActions().clickOnWorkTab("Action Step");
        getProfileCompletionPageActions().clickOnAddedWorkExperinceBlock("Action Step");
        getProfileCompletionPageActions().clickOnAddedWorkExperienceEditIcon("Action Step");
        getProfileCompletionPageActions().enterDesignation("Action Step", designation);
        getProfileCompletionPageActions().enterCompanyName("Action Step", companyname);
        getProfileCompletionPageActions().enterWorkLocation("Action Step", workLocation);
        getProfileCompletionPageActions().selectWorkStartMonth("Action Step", workStartMonth);
        getProfileCompletionPageActions().selectWorkStartYear("Action Step", workStartYear);
        getProfileCompletionPageActions().clickOnWorkSectionSaveButton("Action Step", workstartmontherrormessage);
    }


    /**
     * @throws Exception
     * @autor Kirthana
     * Verify  25% default profile completion percentage  added on Registration
     */
    @Test(priority = 79, enabled = true, alwaysRun = true, description = "Verify 25% default profile completion percentage added on Registration  ")
    public void tc_PCM_16_P1_VerifyDefaultProfileCompletionPercentageAddedOnRegistrationTest() throws Exception
    {


        String registrationRange = "Registration!A2:H2";

        ArrayList<String> responseinfo = null;
        String response = null;

        ArrayList<String> val = sheetAPI().getSpreadSheetValuesOfSpecificRow(TEST_DATA_GOOGLESHEET, registrationRange);
        String fullName = getRegistrationPage().getFullName();
        String userName = getRegistrationPage().getUserName(val.get(1));
        String emailAddress = getRegistrationPage().getEmail(val.get(2));
        String countryCode = val.get(3);
        String dateOfBirth = val.get(5);
        String createPassword = getRegistrationPage().getRandomValidPassword(val.get(6));
        String skipOtp = val.get(7);
        String phoneNumber = getRegistrationPage().getPhoneNumber(val.get(4));

        responseinfo = getRegistrationPage().mobileVerifyApi("Action Step", phoneNumber, countryCode, skipOtp);
        response = responseinfo.get(0);
        String secret = responseinfo.get(1);

        getRegistrationPage().verifyMobileApi("Verify Step", response);
        response = getRegistrationPage().mobileConfirmApi("Action Step", phoneNumber, secret, skipOtp, countryCode);
        getRegistrationPage().verifyMobileConfirmApi("Verify Step", response);
        response = getRegistrationPage().registerApi("Action & verify", fullName, userName, phoneNumber, countryCode, secret, emailAddress, dateOfBirth, createPassword, skipOtp);
        getRegistrationPage().verifyRegisterApi("Verify Step", response);

        //Update values in sheet
        List<List<Object>> values = Arrays.asList(Arrays.asList(userName, createPassword, fullName));
        String loginRange = "Login!A13:C13";

        sheetAPI().updateMultipleCellValues(TEST_DATA_GOOGLESHEET, loginRange, "USER_ENTERED", values);

        //Login
        val = sheetAPI().getSpreadSheetValuesOfSpecificRow(TEST_DATA_GOOGLESHEET, loginRange);
        String username = val.get(0);
        String password = val.get(1);
        String fullname = val.get(2);


        String range = "EditProfile!A2:AB2";
        ArrayList<String> ecditprofileval = sheetAPI().getSpreadSheetValuesOfSpecificRow(TEST_DATA_GOOGLESHEET, range);
        String expecteddefaultProfilePercentage = ecditprofileval.get(27);

        getLoginPage().logIn("Action Step", fullname, "valid username, password", username, password);
        getLoginPage().clickOnTopicSkipButton("Action Step");
        getHomePageActions().clickOnTopBarDropdown("Action Step");
        getProfilePageActions().clickOnViewProfileLink("Action Step");
        getProfileCompletionPageActions().clickOnEditIconOfAboutSection("Action Step");

        String ActualProfileCompletionPercentage = getProfileCompletionPageActions().getProfileCompletionRange();
        getProfileCompletionPageActions().verifyDefaultPercentageOfProfileCompletion("Verify Step", expecteddefaultProfilePercentage,ActualProfileCompletionPercentage );

    }

    /**
     * @throws Exception
     * @autor Kirthana SS
     * Verify profile completion percentage incremented by 15% on adding skills in General info section
     */
    @Test(priority = 80, enabled = true, alwaysRun = true, description = "Verify profile completion percentage incremented by 5% on adding skills in General info section")
    public void tc_PCM_17_P1_VerifyPercentageIncrementedOnAddingSkillsTest() throws Exception
    {
        //User B
        String loginrange = "Login!A13:C13";
        Map<String, String> loginvalues = sheetAPI().getSpreadSheetRowValueByColumnName(TEST_DATA_GOOGLESHEET, loginrange);
        String username=loginvalues.get("UserName / Email / PhoneNumber");
        String password=loginvalues.get("Password");
        String fullname=loginvalues.get("FullName");

        String range = "EditProfile!A2:C2";
        Map<String, String> ecditprofileval = sheetAPI().getSpreadSheetRowValueByColumnName(TEST_DATA_GOOGLESHEET, range);
        String skills = ecditprofileval.get("Skills");

        getLoginPage().logIn("Action Step", fullname, "valid username, password", username, password);
        getHomePageActions().clickOnTopBarDropdown("Action Step");
        getProfilePageActions().clickOnViewProfileLink("Action Step");
        getProfileCompletionPageActions().clickOnEditIconOfAboutSection("Action Step");

        String getProfileCompletionPercentageBeforeUpdate = getProfileCompletionPageActions().getProfileCompletionRange();
        getProfileCompletionPageActions().clickOnGenralInfoTab("Action Step");
        getProfileCompletionPageActions().enterSkillsTag("Action Step", skills.split(",")[0]);
        getProfileCompletionPageActions().clickOnGeneralInfoSaveChangesButton("Action Step");
        getProfileCompletionPageActions().verifyDisplayOfConfirmationToastMessagePopup();
        String getProfileCompletionPercentageAfterUpdate = getProfileCompletionPageActions().getProfileCompletionRange();
        getProfileCompletionPageActions().verifyPercentageIncrementedOnAddingSkills("Verify Step", getProfileCompletionPercentageBeforeUpdate, getProfileCompletionPercentageAfterUpdate);

    }





    /**
     * @throws Exception
     * @autor Kirthana SS
     * Verify profile completion percentage incremented by 5% on adding description in About section
     */
    @Test(priority = 81, enabled = true, alwaysRun = true, description = "Verify profile completion percentage incremented by 5% on adding language known ")
    public void tc_PCM_18_P1_VerifyPercentageIncrementedOnAddingDescriptionTest() throws Exception {


        //User B
        String loginrange = "Login!A13:C13";
        Map<String, String> loginvalues = sheetAPI().getSpreadSheetRowValueByColumnName(TEST_DATA_GOOGLESHEET, loginrange);
        String username=loginvalues.get("UserName / Email / PhoneNumber");
        String password=loginvalues.get("Password");
        String fullname=loginvalues.get("FullName");

        String range = "EditProfile!A2:C2";

        ArrayList<String> ecditprofileval = sheetAPI().getSpreadSheetValuesOfSpecificRow(TEST_DATA_GOOGLESHEET, range);
        String description = ecditprofileval.get(2);

        getLoginPage().logIn("Action Step", fullname, "valid username, password", username, password);
        getHomePageActions().clickOnTopBarDropdown("Action Step");
        getProfilePageActions().clickOnViewProfileLink("Action Step");
        getProfileCompletionPageActions().clickOnEditIconOfAboutSection("Action Step");

        String getProfileCompletionPercentageBeforeUpdate = getProfileCompletionPageActions().getProfileCompletionRange();
        getProfileCompletionPageActions().enterValueOfDescription("Action Step", description);
        getProfileCompletionPageActions().clickOnAboutSectionSaveButton("Action Step");
        getProfileCompletionPageActions().verifyDisplayOfConfirmationToastMessagePopup();
        String getProfileCompletionPercentageAfterUpdate = getProfileCompletionPageActions().getProfileCompletionRange();
        getProfileCompletionPageActions().verifyPercentageIncrementedOnAddingDescription("Verify Step", getProfileCompletionPercentageBeforeUpdate, getProfileCompletionPercentageAfterUpdate);

    }



    /**
     * @throws Exception
     * @autor Kirthana SS
     * Verify profile completion percentage   incremented by 5% on adding language known in about section
     */
    @Test(priority = 82, enabled = true, alwaysRun = true, description = "Verify profile completion percentage incremented by 5% on adding language known ")
    public void tc_PCM_19_P1_VerifyPercentageIncrementedOnAddingLanguageTest() throws Exception {



        //User B
        String loginrange = "Login!A13:C13";
        Map<String, String> loginvalues = sheetAPI().getSpreadSheetRowValueByColumnName(TEST_DATA_GOOGLESHEET, loginrange);
        String username=loginvalues.get("UserName / Email / PhoneNumber");
        String password=loginvalues.get("Password");
        String fullname=loginvalues.get("FullName");

        String range = "EditProfile!A2:F2";

        ArrayList<String> ecditprofileval = sheetAPI().getSpreadSheetValuesOfSpecificRow(TEST_DATA_GOOGLESHEET, range);
        String languageKnown = ecditprofileval.get(5);

        getLoginPage().logIn("Action Step", fullname, "valid username, password", username, password);
        getHomePageActions().clickOnTopBarDropdown("Action Step");
        getProfilePageActions().clickOnViewProfileLink("Action Step");
        getProfileCompletionPageActions().clickOnEditIconOfAboutSection("Action Step");

        String getProfileCompletionPercentageBeforeUpdate = getProfileCompletionPageActions().getProfileCompletionRange();
        getProfileCompletionPageActions().enterLanguagesKnown("Action Step", languageKnown);
        getProfileCompletionPageActions().clickOnAboutSectionSaveButton("Action Step");
        getProfileCompletionPageActions().verifyDisplayOfConfirmationToastMessagePopup();
        String getProfileCompletionPercentageAfterUpdate = getProfileCompletionPageActions().getProfileCompletionRange();
        getProfileCompletionPageActions().verifyPercentageIncrementedOnAddingLanguage("Verify Step", getProfileCompletionPercentageBeforeUpdate, getProfileCompletionPercentageAfterUpdate);
    }

    /**
     * @throws Exception
     * @autor Kirthana SS
     * Verify profile completion percentage incremented by 5% on adding contact location
     */
    @Test(priority = 83, enabled = true, alwaysRun = true, description = "Verify profile completion percentage incremented by 5% on adding Contact Location  ")
    public void tc_PCM_20_P1_VerifyPercentageIncrementedOnAddingContactLocationTest() throws Exception {

        //User B
        String loginrange = "Login!A13:C13";
        Map<String, String> loginvalues = sheetAPI().getSpreadSheetRowValueByColumnName(TEST_DATA_GOOGLESHEET, loginrange);
        String username=loginvalues.get("UserName / Email / PhoneNumber");
        String password=loginvalues.get("Password");
        String fullname=loginvalues.get("FullName");

        String range = "EditProfile!A2:K2";
        ArrayList<String> editProfileVal = sheetAPI().getSpreadSheetValuesOfSpecificRow(TEST_DATA_GOOGLESHEET, range);
        String contactLocation = editProfileVal.get(10);

        getLoginPage().logIn("Action Step", fullname, "valid username, password", username, password);
        getHomePageActions().clickOnTopBarDropdown("Action Step");
        getProfilePageActions().clickOnViewProfileLink("Action Step");
        getProfileCompletionPageActions().clickOnEditIconOfAboutSection("Action Step");
        getProfileCompletionPageActions().clickOnCantactTab("Action Step");
        String getProfileCompletionPercentageBeforeUpdate = getProfileCompletionPageActions().getProfileCompletionRange();
        getProfileCompletionPageActions().enterContactLocation("Action Step", contactLocation);
        getProfileCompletionPageActions().clickContactUpdationSaveChangesButton("Action Step");
        getProfileCompletionPageActions().verifyDisplayOfConfirmationToastMessagePopup();
        String getProfileCompletionPercentageAfterUpdate = getProfileCompletionPageActions().getProfileCompletionRange();
        getProfileCompletionPageActions().verifyPercentageIncrementedOnAddingContactLocation("Verify Step", getProfileCompletionPercentageBeforeUpdate, getProfileCompletionPercentageAfterUpdate);

    }


    /**
     * @throws Exception
     * @autor  Kirthana SS
     * Verify  profile completion percentage incremented by 15% on adding Work experience , and decremented by 15% on removing work experience
     */
    @Test(priority = 84, enabled = true, alwaysRun = true, description = "Verify profile completion percentage incremented by 15% on adding Work details , and decremented by 15% on removing work details  ")
    public void tc_PCM_21_P1_VerifyProfileCompletionPercentageOnAddingAndDeletingWorkExperienceTest() throws Exception {

        //User B
        String loginrange = "Login!A13:C13";
        Map<String, String> loginvalues = sheetAPI().getSpreadSheetRowValueByColumnName(TEST_DATA_GOOGLESHEET, loginrange);
        String username=loginvalues.get("UserName / Email / PhoneNumber");
        String password=loginvalues.get("Password");
        String fullname=loginvalues.get("FullName");

        String editProfileRange = "EditProfile!A2:R2";

        ArrayList<String> val = sheetAPI().getSpreadSheetValuesOfSpecificRow(TEST_DATA_GOOGLESHEET, editProfileRange);
        String designation = val.get(8);
        String companyname = val.get(9);
        String workLocation = val.get(10);
        String currentlyWorkingHere = val.get(11);
        String workStartMonth = val.get(12);
        String workStartYear = val.get(13);
        String showworkexperienceonprofile = val.get(16);
        String workstartmontherrormessage = val.get(17);

        getLoginPage().logIn("Action Step", fullname, "valid username, password", username, password);
        getHomePageActions().clickOnTopBarDropdown("Action Step");
        getProfilePageActions().clickOnViewProfileLink("Action Step");
        getProfileCompletionPageActions().clickOnEditIconOfAboutSection("Action Step");
        getProfileCompletionPageActions().clickOnWorkTab("Action Step");
        getProfileCompletionPageActions().clickOnAddWorkExperienceButton("Action Step");
        String getProfileCompletionPercentageBeforeUpdate = getProfileCompletionPageActions().getProfileCompletionRange();
        getProfileCompletionPageActions().enterDesignation("Action Step", designation);
        getProfileCompletionPageActions().enterCompanyName("Action Step", companyname);
        getProfileCompletionPageActions().enterWorkLocation("Action Step", workLocation);
        getProfileCompletionPageActions().clickOnCurrentlyWorkingHereRadioButton("Action Step", currentlyWorkingHere);
        getProfileCompletionPageActions().selectWorkStartMonth("Action Step", workStartMonth);
        getProfileCompletionPageActions().selectWorkStartYear("Action Step", workStartYear);
        getProfileCompletionPageActions().clickOnShowWorkExperienceOnProfileRadioButton("Action Step", showworkexperienceonprofile);
        getProfileCompletionPageActions().clickOnWorkSectionSaveButton("Action Step", workstartmontherrormessage);
        String getProfileCompletionPercentageAfterUpdate = getProfileCompletionPageActions().getProfileCompletionRange();
        getProfileCompletionPageActions().verifyPercentageIncrementedOnAddingWorkExperierince("Verify Step", getProfileCompletionPercentageBeforeUpdate, getProfileCompletionPercentageAfterUpdate);

        getProfileCompletionPercentageBeforeUpdate = getProfileCompletionPageActions().getProfileCompletionRange();
        getProfileCompletionPageActions().clickOnAddedWorkDetailsBlockDeleteIcon("Action Step");
        getProfileCompletionPercentageAfterUpdate = getProfileCompletionPageActions().getProfileCompletionRange();
        getProfileCompletionPageActions().verifyPercentageDecrementedOnDeletingWorkExperierince("Verify Step", getProfileCompletionPercentageBeforeUpdate, getProfileCompletionPercentageAfterUpdate);

    }


    /**
     * @throws Exception
     * @autor Kirthana SS
     * Verify Contents of Add Award Section
     */
    @Test(priority = 85, enabled = true, alwaysRun = true, description = "Verify contents \"Add Award Section\"  ")
    public void tc_PCM_22_P1_VerifyContentsOfAddAwardSection() throws Exception {

        String loginrange = "Login!A13:C13";
        Map<String, String> loginvalues = sheetAPI().getSpreadSheetRowValueByColumnName(TEST_DATA_GOOGLESHEET, loginrange);
        String username=loginvalues.get("UserName / Email / PhoneNumber");
        String password=loginvalues.get("Password");
        String fullname=loginvalues.get("FullName");

        getLoginPage().logIn("Action Step", fullname, "valid username, password", username, password);
        getHomePageActions().clickOnTopBarDropdown("Action Step");
        getProfilePageActions().clickOnViewProfileLink("Action Step");
        getProfileCompletionPageActions().clickOnEditIconOfAboutSection("Action Step");
        getProfileCompletionPageActions().clickOnAwardTab("Action Step");
        getProfileCompletionPageActions().clickAddAwardButton("Action Step");
        getProfileCompletionPageActions().verifyContentsOfAddAwardSection("Verify Step");
    }


    /**
     * @throws Exception
     * @autor Kirthana SS
     * Verify Profile completion percentage incremented by 5% on adding Award details , decremented by 5% on deleting Award details .
     */
    @Test(priority = 86, enabled = true, alwaysRun = true, description = "Verify Profile completion percentage incremented by 5% on adding Award details , decremented by 5% on deleting Award details ")
    public void tc_PCM_23_P1_VerifyProfileCompletionPercentageOnAddingAndDeletingAwardDetailsTest() throws Exception {
        String loginrange = "Login!A13:C13";
        Map<String, String> loginvalues = sheetAPI().getSpreadSheetRowValueByColumnName(TEST_DATA_GOOGLESHEET, loginrange);
        String username=loginvalues.get("UserName / Email / PhoneNumber");
        String password=loginvalues.get("Password");
        String fullname=loginvalues.get("FullName");

        String range = "EditProfile!A2:Y2";
        Map<String, String> ecditprofileval = sheetAPI().getSpreadSheetRowValueByColumnName(TEST_DATA_GOOGLESHEET, range);

        getLoginPage().logIn("Action Step", fullname, "valid username, password", username, password);
        getHomePageActions().clickOnTopBarDropdown("Action Step");
        getProfilePageActions().clickOnViewProfileLink("Action Step");
        getProfileCompletionPageActions().clickOnEditIconOfAboutSection("Action Step");
        getProfileCompletionPageActions().clickOnAwardTab("Action Step");
        String getProfileCompletionPercentageBeforeUpdate = getProfileCompletionPageActions().getProfileCompletionRange();
        getProfileCompletionPageActions().clickAddAwardButton("Action Step");
        getProfileCompletionPageActions().enterAwardTitle("Action Step", ecditprofileval.get("Award Title"));
        getProfileCompletionPageActions().enterAwardIssuer("Action Step", ecditprofileval.get("Award Issuer"));
        getProfileCompletionPageActions().enterAwardIssuedLocation("Action Step", ecditprofileval.get("Award Location"));
        getProfileCompletionPageActions().selectAwardIssuedMonth("Action Step", ecditprofileval.get("Issued Month"));
        getProfileCompletionPageActions().selectAwardIssuedYear("Action Step", ecditprofileval.get("Issued Year"));
        getProfileCompletionPageActions().clickOnShowAwardOnProfileRadioButton("Action Step",  ecditprofileval.get("Award show on profile"));
        getProfileCompletionPageActions().clickOnAwardUpdationSaveButton("Action Step", ecditprofileval.get("Award issued Month Error Message"));
        String getProfileCompletionPercentageAfterUpdate = getProfileCompletionPageActions().getProfileCompletionRange();
        getProfileCompletionPageActions().verifyPercentageIncrementedOnAddingAwardDetails("Verify Step", getProfileCompletionPercentageBeforeUpdate, getProfileCompletionPercentageAfterUpdate);

        getProfileCompletionPercentageBeforeUpdate = getProfileCompletionPageActions().getProfileCompletionRange();
        getProfileCompletionPageActions().clickOnAddedAwardDetailsBlockDeleteIcon("Action Step");
        getProfileCompletionPercentageAfterUpdate = getProfileCompletionPageActions().getProfileCompletionRange();
        getProfileCompletionPageActions().verifyPercentageDecrementedOnRemovingAwardDetails("Verify Step", getProfileCompletionPercentageBeforeUpdate, getProfileCompletionPercentageAfterUpdate);
        
    }



    /**
     * @throws Exception
     * @autor Kirthana SS
     * Verify Profile completion percentage incremented by 15% on adding Education details , decremented by 15% on deleting Education details .
     */
    @Test(priority = 87, enabled = true, alwaysRun = true, description = "Verify Profile completion percentage incremented by 15% on adding Education details , decremented by 15% on deleting Education details")
    public void tc_PCM_24_P1_VerifyProfileCompletionPercentageOnAddingAndDeletingEducationDetailsTest() throws Exception {
        String loginrange = "Login!A13:C13";
        Map<String, String> loginvalues = sheetAPI().getSpreadSheetRowValueByColumnName(TEST_DATA_GOOGLESHEET, loginrange);
        String username=loginvalues.get("UserName / Email / PhoneNumber");
        String password=loginvalues.get("Password");
        String fullname=loginvalues.get("FullName");

        String editProfileRange = "EditProfile!A2:AL2";
        Map<String, String> editProfileVal = sheetAPI().getSpreadSheetRowValueByColumnName(TEST_DATA_GOOGLESHEET, editProfileRange);

        getLoginPage().logIn("Action Step", fullname, "valid username, password", username, password);
        getHomePageActions().clickOnTopBarDropdown("Action Step");
        getProfilePageActions().clickOnViewProfileLink("Action Step");
        getProfileCompletionPageActions().clickOnEditIconOfAboutSection("Action Step");
        getProfileCompletionPageActions().clickOnEducationTab("Action Step");
        String getProfileCompletionPercentageBeforeUpdate = getProfileCompletionPageActions().getProfileCompletionRange();
        getProfileCompletionPageActions().clickOnAddEducationButton("Action Step");
        getProfileCompletionPageActions().enterStudy("Action Step", editProfileVal.get("Field of Study"));
        getProfileCompletionPageActions().enterEducationUniversity("Action Step", editProfileVal.get("University"));
        getProfileCompletionPageActions().enterEducationLocation("Action Step", editProfileVal.get("Location"));
        getProfileCompletionPageActions().clickOnCurrentStudyHereRadioButton("Action Step", editProfileVal.get("Currently studying here"));
        getProfileCompletionPageActions().selectEducationStartMonthDropdown("Action Step", editProfileVal.get("Education start month"));
        getProfileCompletionPageActions().selectEducationStartYearDropdown("Action Step",  editProfileVal.get("Education start year"));
        getProfileCompletionPageActions().clickOnShowEducationOnProfileRadioButton("Action Step", editProfileVal.get("Show education on my profile"));
        getProfileCompletionPageActions().clickOnEducationUpdationSaveButton("Action Step",  editProfileVal.get("Education Start Month Error Message"));

        String getProfileCompletionPercentageAfterUpdate = getProfileCompletionPageActions().getProfileCompletionRange();
        getProfileCompletionPageActions().verifyPercentageIncrementedOnAddingEducationDetails("Verify Step", getProfileCompletionPercentageBeforeUpdate, getProfileCompletionPercentageAfterUpdate);

        getProfileCompletionPercentageBeforeUpdate = getProfileCompletionPageActions().getProfileCompletionRange();
        getProfileCompletionPageActions().clickOnAddededucationDetailsBlockDeleteIcon("Action Step");
        getProfileCompletionPercentageAfterUpdate = getProfileCompletionPageActions().getProfileCompletionRange();
        getProfileCompletionPageActions().verifyPercentageDecrementedOnEducationDetails("Verify Step", getProfileCompletionPercentageBeforeUpdate, getProfileCompletionPercentageAfterUpdate);

    }



    /**
     * @throws Exception
     * @autor Kirthana SS
     * Verify Add Award
     */
    @Test(priority = 88, enabled = true, alwaysRun = true, description = "Verify \"Add Award\"  ")
    public void tc_PCM_25_P1_VerifyAddAwardTest() throws Exception {

        String loginrange = "Login!A13:C13";
        Map<String, String> loginvalues = sheetAPI().getSpreadSheetRowValueByColumnName(TEST_DATA_GOOGLESHEET, loginrange);
        String username=loginvalues.get("UserName / Email / PhoneNumber");
        String password=loginvalues.get("Password");
        String fullname=loginvalues.get("FullName");

        String range = "EditProfile!A2:Y1";

        ArrayList<String> val = sheetAPI().getSpreadSheetValues(TEST_DATA_GOOGLESHEET, range, 2);
        String awardtitle = val.get(18);
        String awardissuer = val.get(19);
        String awardissuedlocation = val.get(20);
        String awardissedmonth = val.get(21);
        String awardissuedyear = val.get(22);
        String showwardonprofile = val.get(23);
        String awardissuedmontherrormessage = val.get(24);

        getLoginPage().logIn("Action Step", fullname, "valid username, password", username, password);
        getHomePageActions().clickOnTopBarDropdown("Action Step");
        getProfilePageActions().clickOnViewProfileLink("Action Step");
        getProfileCompletionPageActions().clickOnEditIconOfAboutSection("Action Step");
        getProfileCompletionPageActions().clickOnAwardTab("Action Step");
        getProfileCompletionPageActions().clickAddAwardButton("Action Step");
        getProfileCompletionPageActions().enterAwardTitle("Action Step", awardtitle);
        getProfileCompletionPageActions().enterAwardIssuer("Action Step", awardissuer);
        getProfileCompletionPageActions().enterAwardIssuedLocation("Action Step", awardissuedlocation);
        getProfileCompletionPageActions().selectAwardIssuedMonth("Action Step", awardissedmonth);
        getProfileCompletionPageActions().selectAwardIssuedYear("Action Step", awardissuedyear);
        getProfileCompletionPageActions().clickOnShowAwardOnProfileRadioButton("Action Step", showwardonprofile);
        getProfileCompletionPageActions().clickOnAwardUpdationSaveButton("Action Step", awardissuedmontherrormessage);
    }


    /**
     * @throws Exception"Action Step", dob
     * @autor  Kirthana SS
     * Verify contents of Contact Tab
     */
    @Test(priority = 89, enabled = true, alwaysRun = true, description = "Verify Contents of \"Contact\" Tab ")
    public void tc_PCM_26_P1_VerifyContentsOfContactTabTest() throws Exception {

        String loginrange = "Login!A13:C13";
        Map<String, String> loginvalues = sheetAPI().getSpreadSheetRowValueByColumnName(TEST_DATA_GOOGLESHEET, loginrange);
        String username=loginvalues.get("UserName / Email / PhoneNumber");
        String password=loginvalues.get("Password");
        String fullname=loginvalues.get("FullName");

        getLoginPage().logIn("Action Step", fullname, "valid username, password", username, password);
        getHomePageActions().clickOnTopBarDropdown("Action Step");
        getProfilePageActions().clickOnViewProfileLink("Action Step");
        getProfileCompletionPageActions().clickOnEditIconOfAboutSection("Action Step");
        getProfileCompletionPageActions().clickOnCantactTab("Action Step");
        getProfileCompletionPageActions().verifyContentsOfContactTab("Verify Step");
    }

    /**
     * @throws Exception
     * @autor Kirthana SS
     * Verify contents of  Work Tab
     */
    @Test(priority = 90, enabled = true, alwaysRun = true, description = "Verify Contents of \"Add Work experience\" section ")
    public void tc_PCM_27_P1_VerifyContentsOfAddWorkExperiencePageTest() throws Exception {

        String loginrange = "Login!A13:C13";
        Map<String, String> loginvalues = sheetAPI().getSpreadSheetRowValueByColumnName(TEST_DATA_GOOGLESHEET, loginrange);
        String username=loginvalues.get("UserName / Email / PhoneNumber");
        String password=loginvalues.get("Password");
        String fullname=loginvalues.get("FullName");

        getLoginPage().logIn("Action Step", fullname, "valid username, password", username, password);
        getHomePageActions().clickOnTopBarDropdown("Action Step");
        getProfilePageActions().clickOnViewProfileLink("Action Step");
        getProfileCompletionPageActions().clickOnEditIconOfAboutSection("Action Step");
        getProfileCompletionPageActions().clickOnWorkTab("Action Step");
        getProfileCompletionPageActions().clickOnAddWorkExperienceButton("Action Step");
        getProfileCompletionPageActions().verifyContentsOfAddWorkExeperienceSection("Verify Step");
    }

    /**
     * @throws Exception
     * @autor Kirthana SS
     * Verify contents of  Education Tab
     */
    @Test(priority = 91, enabled = true, alwaysRun = true, description = "Verify Contents of \"Add Education\" section ")
    public void tc_PCM_28_P1_VerifyContentsOfAddEducationPageTest() throws Exception {

        String loginrange = "Login!A13:C13";
        Map<String, String> loginvalues = sheetAPI().getSpreadSheetRowValueByColumnName(TEST_DATA_GOOGLESHEET, loginrange);
        String username=loginvalues.get("UserName / Email / PhoneNumber");
        String password=loginvalues.get("Password");
        String fullname=loginvalues.get("FullName");

        getLoginPage().logIn("Action Step", fullname, "valid username, password", username, password);
        getHomePageActions().clickOnTopBarDropdown("Action Step");
        getProfilePageActions().clickOnViewProfileLink("Action Step");
        getProfileCompletionPageActions().clickOnEditIconOfAboutSection("Action Step");
        getProfileCompletionPageActions().clickOnEducationTab("Action Step");
        getProfileCompletionPageActions().clickOnAddEducationButton("Action Step");
        getProfileCompletionPageActions().verifyContentsOfAddEducationSection("Verify Step");
    }


    /**
     * @throws Exception
     * @autor Kirthana SS
     * Verify that user is able to create an Education by disabling  I’m currently studying here
     */
    @Test(priority = 91, enabled = true, alwaysRun = true, description = "Verify that user is able to create an Education by disabling  I’m currently studying here ")
    public void tc_PCM_29_P1_VerifyCurrentStudyingRadioButtonTest() throws Exception {

        String loginrange = "Login!A13:C13";
        Map<String, String> loginvalues = sheetAPI().getSpreadSheetRowValueByColumnName(TEST_DATA_GOOGLESHEET, loginrange);
        String username=loginvalues.get("UserName / Email / PhoneNumber");
        String password=loginvalues.get("Password");
        String fullname=loginvalues.get("FullName");

        String editProfileRange = "EditProfile!A2:AL2";
        Map<String, String> editProfileVal = sheetAPI().getSpreadSheetRowValueByColumnName(TEST_DATA_GOOGLESHEET, editProfileRange);

        getLoginPage().logIn("Action Step", fullname, "valid username, password", username, password);
        getHomePageActions().clickOnTopBarDropdown("Action Step");
        getProfilePageActions().clickOnViewProfileLink("Action Step");
        getProfileCompletionPageActions().clickOnEditIconOfAboutSection("Action Step");
        getProfileCompletionPageActions().clickOnEducationTab("Action Step");
        getProfileCompletionPageActions().clickOnAddEducationButton("Action Step");
        getProfileCompletionPageActions().enterStudy("Action Step", editProfileVal.get("Field of Study"));
        getProfileCompletionPageActions().enterEducationUniversity("Action Step", editProfileVal.get("University"));
        getProfileCompletionPageActions().enterEducationLocation("Action Step", editProfileVal.get("Location"));
        getProfileCompletionPageActions().selectEducationStartMonthDropdown("Action Step", editProfileVal.get("Education start month"));
        getProfileCompletionPageActions().selectEducationStartYearDropdown("Action Step",  editProfileVal.get("Education start year"));
        getProfileCompletionPageActions().selectEducationEndMonthDropdown("Action Step", editProfileVal.get("Education end month"));
        getProfileCompletionPageActions().selectEducationEndYearDropdown("Action Step", editProfileVal.get("Education end year"));
        getProfileCompletionPageActions().clickOnShowEducationOnProfileRadioButton("Action Step", editProfileVal.get("Show education on my profile"));
        getProfileCompletionPageActions().clickOnEducationUpdationSaveButton("Action Step",  editProfileVal.get("Education Start Month Error Message"));
    }


    @AfterMethod(dependsOnMethods = {"com.aeione.ops.generic.TestSetUp.afterMethod"})
    public void after() throws IOException {
        getHomePageActions().navigateHomePage();
        getHomePageActions().clickOnTopBarDropdown("Action Step");
        getHomePageActions().clickOnSignOut("Action Step");

    }


}
