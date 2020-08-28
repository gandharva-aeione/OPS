package com.aeione.ops.test;

import com.aeione.ops.generic.DriverManager;
import com.aeione.ops.generic.GoogleDriveAPI;
import com.aeione.ops.generic.GoogleSheetAPI;
import com.aeione.ops.generic.TestSetUp;
import com.aeione.ops.pageactions.*;
import com.google.api.services.sheets.v4.model.CellFormat;
import com.google.api.services.sheets.v4.model.Color;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SettingsPageTest extends TestSetUp
{

    public LoginPageActions getLoginPage() throws IOException {
        return new LoginPageActions();
    }

    public HomePageActions getHomePageActions() throws IOException {
        return new HomePageActions();
    }

    public SettingsPageActions getSettingsActions() throws IOException {
        return new SettingsPageActions();
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

    public GoogleDriveAPI dsriveAPI() throws IOException
    {
        return new GoogleDriveAPI();
    }

    public GoogleSheetAPI sheetAPI() throws IOException {
        return new GoogleSheetAPI();
    }

    @Test(priority = 114, enabled= true, alwaysRun = true, description = "Verify Settings option")
    public void TC_STG_01_P1_settingsOptionTest() throws Exception
    {

        String LoginRange = "Login!A6:C6";

        String username = null;
        String password = null;
        String fullname = null;

        ArrayList<String> val = sheetAPI().getSpreadSheetValuesOfSpecificRow(TEST_DATA_GOOGLESHEET, LoginRange);
        username = val.get(0);
        password = val.get(1);
        fullname = val.get(2);

        getLoginPage().logIn("Action Step", fullname, "valid username, password", username, password);

        getHomePageActions().clickOnTopBarDropdown("Action Step");
        getSettingsActions().verifyDisplayOfSettingsOption("Verify Step");
    }

    /**
     * Test_Cases_For_Contents Of Settings Page
     * Author:- Gandahrva
     * Date:- 29-05-2020
     */
    @Test(priority = 115, enabled= true, alwaysRun = true, description = "Verify Settings Page Contents")
    public void TC_STG_02_P1_verifyContentsOfSettingsPageTest() throws Exception
    {
        String LoginRange = "Login!A6:C6";
        String TopBarDropDownRange = "TopBarDropDownActions!A6:B6";
        String SettingsRange ="Settings!A7:B7";
        String username = null;
        String password = null;
        String fullname = null;

        ArrayList<String> val = sheetAPI().getSpreadSheetValuesOfSpecificRow(TEST_DATA_GOOGLESHEET, LoginRange);
        username = val.get(0);
        password = val.get(1);
        fullname = val.get(2);

        getLoginPage().logIn("Action Step", fullname,"valid username, password",username, password);

        val = sheetAPI().getSpreadSheetValuesOfSpecificRow(TEST_DATA_GOOGLESHEET, TopBarDropDownRange);
        String action = val.get(1);

        getHomePageActions().clickOnTopBarDropdown("Action Step");
        getSettingsActions().clickOnDropDownActions("Action Step",action);

        val = sheetAPI().getSpreadSheetValuesOfSpecificRow(TEST_DATA_GOOGLESHEET, SettingsRange);
        String tabs = val.get(0);
        getSettingsActions().verifyDisplayOfTabsListOfSettingsPage(tabs,"Verify Step");
    }

    /**
     * Test_Cases_For_Contents Of Change Password
     * Author:- Gandahrva
     * Date:- 29-05-2020
     */
    @Test(priority = 116, enabled= true, alwaysRun = true, description = "Verify Change Password Contents")
    public void TC_STG_05_P1_verifyContentsOfChangePasswordPageTest() throws Exception
    {
        String LoginRange = "Login!A6:C6";
        String TopBarDropDownRange = "TopBarDropDownActions!A6:B6";
        String SettingsRange ="Settings!A3:B3";
        String username = null;
        String password = null;
        String fullname = null;
        String action = null;
        ArrayList<String> val = sheetAPI().getSpreadSheetValuesOfSpecificRow(TEST_DATA_GOOGLESHEET, LoginRange);
        username = val.get(0);
        password = val.get(1);
        fullname = val.get(2);

        getLoginPage().logIn("Action Step", fullname,"valid username, password",username, password);

        val = sheetAPI().getSpreadSheetValuesOfSpecificRow(TEST_DATA_GOOGLESHEET, TopBarDropDownRange);
        action = val.get(1);

        getHomePageActions().clickOnTopBarDropdown("Action Step");
        getSettingsActions().clickOnDropDownActions("Action Step",action);

        val = sheetAPI().getSpreadSheetValuesOfSpecificRow(TEST_DATA_GOOGLESHEET, SettingsRange);
        action = val.get(1);

        getSettingsActions().clickOnTabs("Action Step",action);
        getSettingsActions().verifyDisplayOfPrivacySecurityPasswordTitle("Verify Step");
        getSettingsActions().clickOnChangePassword("Action Step");
        getSettingsActions().verifyDisplayOfCurrentPasswordInputBox("Verify Step");
        getSettingsActions().verifyDisplayOfNewPasswordInputBox("Verify Step");
        getSettingsActions().verifyDisplayOfConfirmPasswordInputBox("Verify Step");
        getSettingsActions().verifyDisplayOfUpdatePasswordButton("Verify Step");
        getSettingsActions().verifyDisplayOfCancelButton("Verify Step");
    }

    /**
     * Test_Cases_For_Update Password
     * Author:- Gandahrva
     * Date:- 29-05-2020
     */
    @Test(priority = 117, enabled= true, alwaysRun = true, description = "Verify Update Password")
    public void TC_STG_06_P1_verifyUpdatePasswordPageTest() throws Exception
    {
        String LoginRange = "Login!A16:C16";
        String TopBarDropDownRange = "TopBarDropDownActions!A6:B6";
        String SettingsRange ="Settings!A3:L3";
        String SettingRangeForUpdatePassword = "Settings!A3:C3";

        String username = null;
        String password = null;
        String fullname = null;
        String action = null;

        ArrayList<String> val = sheetAPI().getSpreadSheetValuesOfSpecificRow(TEST_DATA_GOOGLESHEET, LoginRange);
        username = val.get(0);
        password = val.get(1);
        fullname = val.get(2);

        getLoginPage().logIn("Action Step",fullname,"valid username, password",username, password);

        val = sheetAPI().getSpreadSheetValuesOfSpecificRow(TEST_DATA_GOOGLESHEET, TopBarDropDownRange);
        action = val.get(1);

        getHomePageActions().clickOnTopBarDropdown("Action Step");
        getSettingsActions().clickOnDropDownActions("Action Step",action);

        val = sheetAPI().getSpreadSheetValuesOfSpecificRow(TEST_DATA_GOOGLESHEET, SettingsRange);
        String tab= val.get(0);
        action = val.get(1);
        String activity = val.get(11);

        List<List<Object>> values = Arrays.asList(Arrays.asList( tab, action , password ));
        sheetAPI().updateMultipleCellValues(TEST_DATA_GOOGLESHEET, SettingRangeForUpdatePassword, "USER_ENTERED", values);

        String newPassword = val.get(3);
        String confirmPassword = val.get(4);

        getSettingsActions().clickOnTabs("Action Step",action);
        getSettingsActions().verifyDisplayOfPrivacySecurityPasswordTitle("Verify Step");
        getSettingsActions().clickOnChangePassword("Action Step");

        val = sheetAPI().getSpreadSheetValuesOfSpecificRow(TEST_DATA_GOOGLESHEET,SettingRangeForUpdatePassword);
        String currentPassword = val.get(2);

        getSettingsActions().enterCurrentPassword("Action Step",currentPassword);
        getSettingsActions().enterNewPassword("Action Step",newPassword);
        getSettingsActions().enterConfirmPassword("Action Step",confirmPassword);

        values = Arrays.asList(Arrays.asList( username, newPassword , fullname ));
        sheetAPI().updateMultipleCellValues(TEST_DATA_GOOGLESHEET, LoginRange, "USER_ENTERED", values);

        getSettingsActions().clickOnUpdatePasswordButton("Action Step");

        values = Arrays.asList(Arrays.asList( tab, action , newPassword ));
        sheetAPI().updateMultipleCellValues(TEST_DATA_GOOGLESHEET, SettingRangeForUpdatePassword, "USER_ENTERED", values);

        getSettingsActions().verifyDisplayOfToastContainer("Verify Step",activity);

    }

    /**
     * Test_Cases_For_Update Password
     * Author:- Gandahrva
     * Date:- 29-05-2020
     */
    @Test(priority = 118, enabled= true, alwaysRun = true, description = "Verify Close All Session")
    public void TC_STG_07_P1_verifyCloseAllSessionButtonTest() throws Exception
    {
        String LogInRange = "Login!A6:C6";
        String TopBarDropDownRange = "TopBarDropDownActions!A6:B6";
        String SettingsRange ="Settings!A3:M3";

        String title = LOGIN_PAGE_TITLE;
        String username = null;
        String password = null;
        String action = null;
        String fullname = null;

        ArrayList<String> val = sheetAPI().getSpreadSheetValuesOfSpecificRow(TEST_DATA_GOOGLESHEET, LogInRange);
        username = val.get(0);
        password = val.get(1);
        fullname = val.get(2);

        getLoginPage().logIn("Action Step", fullname,"valid username, password",username, password);

        val = sheetAPI().getSpreadSheetValuesOfSpecificRow(TEST_DATA_GOOGLESHEET, TopBarDropDownRange);
        action = val.get(1);

        getHomePageActions().clickOnTopBarDropdown("Action Step");
        getSettingsActions().clickOnDropDownActions("Action Step",action);

        val = sheetAPI().getSpreadSheetValuesOfSpecificRow(TEST_DATA_GOOGLESHEET, SettingsRange);
        action = val.get(1);
        String activity = val.get(12);

        getSettingsActions().clickOnTabs("Action Step",action);
        getSettingsActions().verifyDisplayOfCloseAllSessionButton("Verify Step");
        getSettingsActions().clickOnCloseAllSessionButton("Action Step");
        getSettingsActions().verifyDisplayOfToastContainer("Verify Step",activity);
        getSettingsActions().verifyDisplayOfPageTitle("Verify Step",title,activity);


        val = sheetAPI().getSpreadSheetValuesOfSpecificRow(TEST_DATA_GOOGLESHEET, LogInRange);
        username = val.get(0);
        password = val.get(1);
        fullname = val.get(2);

        getLoginPage().logIn("Action Step", fullname,"valid username, password",username, password);
    }

    /**
     * Test_Cases_For Delete Account
     * Author:- Gandahrva
     * Date:- 09-06-2020
     */
    @Test(priority = 119, enabled = true, alwaysRun = true, description = "Verify Delete Account")
    public void TC_STG_08_P1_verifyDeleteAccountTest() throws Exception
    {
        String RegistrationRange = "Registration!A4:H";
        String LogInRange = "Login!A18:C18";
        String TopBarDropDownRange = "TopBarDropDownActions!A6:B6";
        String SettingsRange ="Settings!A2:R2";
        String ErrorMessageRange = "ErrorMessages!A2:B2";

        String title = LOGIN_PAGE_TITLE;
        String fullName = null;
        String username = null;
        String password = null;
        String action = null;
        String errorMessage = null;

        ArrayList<String> responseinfo=null;
        String response=null;

        ArrayList<String> val = sheetAPI().getSpreadSheetValuesOfSpecificRow(TEST_DATA_GOOGLESHEET, RegistrationRange);
        fullName=val.get(0);
        String userName=getRegistrationPage().getUserName(val.get(1));
        String emailAddress=getRegistrationPage().getEmail(val.get(2));
        String countryCode=val.get(3);
        String dateOfBirth=val.get(5);
        String createPassword=getRegistrationPage().getRandomValidPassword(val.get(6));
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


        //Update values LogIn sheet
        List<List<Object>> values = Arrays.asList(Arrays.asList(userName, createPassword , fullName));
        sheetAPI().updateMultipleCellValues(TEST_DATA_GOOGLESHEET, LogInRange, "USER_ENTERED", values);

        //Update values Delete sheet
        List<List<Object>> values2 = Arrays.asList(Arrays.asList(fullName,userName,emailAddress, countryCode,phoneNumber,dateOfBirth,createPassword,skipOtp));
        sheetAPI().appendRowData(TEST_DATA_GOOGLESHEET, constantDeletedRow, "USER_ENTERED", values2);

        val = sheetAPI().getSpreadSheetValuesOfSpecificRow(TEST_DATA_GOOGLESHEET, LogInRange);
        username = val.get(0);
        password = val.get(1);
        fullName = val.get(2);

        getLoginPage().logIn("Action Step",fullName,  "valid username, password",username, password);
        getLoginPage().clickOnTopicSkipButton("Action Step");

        val = sheetAPI().getSpreadSheetValuesOfSpecificRow(TEST_DATA_GOOGLESHEET, TopBarDropDownRange);
        action = val.get(1);

        getHomePageActions().clickOnTopBarDropdown("Action Step");
        getSettingsActions().clickOnDropDownActions("Action Step",action);

        val = sheetAPI().getSpreadSheetValuesOfSpecificRow(TEST_DATA_GOOGLESHEET, SettingsRange);
        action = val.get(1);
        String activity = val.get(17);

        getSettingsActions().clickOnTabs("Action Step",action);
        getSettingsActions().verifyDisplayOfDeleteAccountCheckBox("Verify Step");
        getSettingsActions().clickOnDeleteAccountCheckBox("Action Step");
        getSettingsActions().verifyDisplayOfGeneralPasswordDeleteAccountInputBox("Verify Step");
        getSettingsActions().enterPasswordForDeleteAccount("Action Step",password);
        getSettingsActions().clickOnConfirmDeleteButton("Action Step");

        val = sheetAPI().getSpreadSheetValuesOfSpecificRow(TEST_DATA_GOOGLESHEET, ErrorMessageRange);
        errorMessage = val.get(1);

        getSettingsActions().verifyDisplayOfAlertPopUp("Verify Step",errorMessage);
        getSettingsActions().verifyDisplayOfToastContainer("Action Step",activity);
        getSettingsActions().verifyDisplayOfPageTitle("Verify Step",title,activity);
    }

    /**
     * Test_Cases_For DeActivate Account
     * Author:- Gandahrva
     * Date:- 09-06-2020
     */
    @Test(priority = 120, enabled= true, alwaysRun = true, description = "Verify DeActivate Account")
    public void TC_STG_09_P1_verifyDeActivateAccountTest() throws Exception
    {
        String LogInRange = "Login!A16:C16";
        String TopBarDropDownRange = "TopBarDropDownActions!A6:B6";
        String SettingsRange ="Settings!A2:Q2";

        String title = LOGIN_PAGE_TITLE;
        String fullname = null;
        String username = null;
        String password = null;
        String action = null;

        ArrayList<String> val = sheetAPI().getSpreadSheetValuesOfSpecificRow(TEST_DATA_GOOGLESHEET, LogInRange);
        username = val.get(0);
        password = val.get(1);
        fullname = val.get(2);

        getLoginPage().logIn("Action Step",fullname, "valid username, password",username, password);

        val = sheetAPI().getSpreadSheetValuesOfSpecificRow(TEST_DATA_GOOGLESHEET, TopBarDropDownRange);
        action = val.get(1);

        getHomePageActions().clickOnTopBarDropdown("Action Step");
        getSettingsActions().clickOnDropDownActions("Action Step",action);

        val = sheetAPI().getSpreadSheetValuesOfSpecificRow(TEST_DATA_GOOGLESHEET, SettingsRange);
        action = val.get(1);
        String activity = val.get(13);
        String reason = val.get(16);

        getSettingsActions().clickOnTabs("Action Step",action);
        getSettingsActions().verifyDisplayOfDeActivateAccountCheckBox("Verify Step");
        getSettingsActions().clickOnDeActivateAccountCheckBox("Action Step");
        getSettingsActions().clickOnDeactivateAccountCheckBoxList("Action Step",reason);
        getSettingsActions().clickOnDeactivateConfirmButton("Action Step");

        getSettingsActions().verifyDisplayOfToastContainer("Verify Step",activity);

        getSettingsActions().verifyDisplayOfPageTitle("Verify Step",title,activity);

        val = sheetAPI().getSpreadSheetValuesOfSpecificRow(TEST_DATA_GOOGLESHEET, LogInRange);
        username = val.get(0);
        password = val.get(1);
        fullname = val.get(2);

        getLoginPage().logIn("Action Step", fullname, "valid username, password",username, password);
    }


    /**
     * Test_Cases_For_Save Pay Per Post Background Image
     * Author:- Gandahrva
     * Date:- 29-05-2020
     */
    @Test(priority = 121, enabled= true, alwaysRun = true, description = "Save PayPerPost Background Image")
    public void TC_STG_13_P1_verifySavePayPerPostBackgroundImageTest() throws Exception
    {
        String LogInRange = "Login!A8:C8";
        String TopBarDropDownRange = "TopBarDropDownActions!A6:B6";
        String SettingsRange ="Settings!A5:L5";
        String PostWIthHashTagRange = "PostWIthHashTag!A15:F15";

        dsriveAPI().downloadFileFromGoogleDrive(TEST_IMAGE_ID1);
        String imageFile = userDirPath + IMAGE_TEST_FILE1;
        String username = null;
        String password = null;
        String fullname = null;
        String action = null;
        ArrayList<String> val = sheetAPI().getSpreadSheetValuesOfSpecificRow(TEST_DATA_GOOGLESHEET, LogInRange);
        username = val.get(0);
        password = val.get(1);
        fullname = val.get(2);

        getLoginPage().logIn("Action Step", fullname, "valid username, password",username, password);

        val = sheetAPI().getSpreadSheetValuesOfSpecificRow(TEST_DATA_GOOGLESHEET, TopBarDropDownRange);
        action = val.get(1);

        getHomePageActions().clickOnTopBarDropdown("Action Step");
        getSettingsActions().clickOnDropDownActions("Action Step",action);

        val = sheetAPI().getSpreadSheetValuesOfSpecificRow(TEST_DATA_GOOGLESHEET, SettingsRange);
        action = val.get(1);
        String activity = val.get(11);

        getSettingsActions().clickOnTabs("Action Step",action);
        getHomePageActions().attachFile("Action Step",imageFile);
        // String imageURL=getSettingsActions().getImageURL("Action Step");

        //System.out.println("Image UrL="+imageURL);

        getSettingsActions().clickOnSavePayPerPostBackgroundImageButton("Action Step");
        getSettingsActions().verifyDisplayOfToastContainer("Verify Step",activity);

        getHomePageActions().clickOnHomeTopBar("Action Step");

        ArrayList<String> val1 = sheetAPI().getSpreadSheetValuesOfSpecificRow(TEST_DATA_GOOGLESHEET, PostWIthHashTagRange);
        String textPostVal= val1.get(0);
        String coinsVal= val1.get(4);
        String messageVal = val1.get(5);

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

        getSettingsActions().verifyDisplayOfPayPerPostBackgroundImage("Verify Step");

        // getSettingsActions().verifyDisplayOfImage("Verify Step",imageURL);
    }

    /**
     * Test_Cases_For_Contents of Gereral Tab
     * Author:- Gandahrva
     * Date:- 10-06-2020
     */
    @Test(priority = 122, enabled= true, alwaysRun = true, description = "Verify General Tab Contents")
    public void TC_STG_14_P1_verifyContentsOfGeneralTabTest() throws Exception
    {
        String LogInRange = "Login!A6:C6";
        String TopBarDropDownRange = "TopBarDropDownActions!A6:B6";
        String SettingsRange ="Settings!A2:B2";
        String username = null;
        String password = null;
        String fullname = null;
        String action = null;
        ArrayList<String> val = sheetAPI().getSpreadSheetValuesOfSpecificRow(TEST_DATA_GOOGLESHEET, LogInRange);
        username = val.get(0);
        password = val.get(1);
        fullname = val.get(2);

        getLoginPage().logIn("Action Step", fullname, "valid username, password",username, password);

        val = sheetAPI().getSpreadSheetValuesOfSpecificRow(TEST_DATA_GOOGLESHEET, TopBarDropDownRange);
        action = val.get(1);

        getHomePageActions().clickOnTopBarDropdown("Action Step");
        getSettingsActions().clickOnDropDownActions("Action Step",action);

        val = sheetAPI().getSpreadSheetValuesOfSpecificRow(TEST_DATA_GOOGLESHEET, SettingsRange);
        action = val.get(1);
        getSettingsActions().clickOnTabs("Action Step",action);

        getSettingsActions().verifyDisplayOfUserNameInputBox("Verify Step");
        getSettingsActions().verifyDisplayOfPrimaryEmailAddressInputBox("Verify Step");
        getSettingsActions().verifyDisplayOfPhoneNumberInputBox("Verify Step");
        getSettingsActions().verifyDisplayOfLanguageDropdown("Verif Step");
        getSettingsActions().verifyDisplayOfMatureToggleFlag("Verify Step");
        getSettingsActions().verifyDisplayOfPortfolioToggleFlag("Verify Step");
        getSettingsActions().verifyDisplayOfSaveButton("Verify Step");
        getSettingsActions().verifyDisplayOfDeleteAccountCheckBox("Verify Step");
        getSettingsActions().verifyDisplayOfDeActivateAccountCheckBox("Verify Step");
    }

    /**
     * Test_Cases_For Mature Flag Enable
     * Author:- Gandahrva
     * Date:- 10-06-2020
     */
    @Test(priority = 123, enabled= true, alwaysRun = true, description = "Verify Mature Falg is Enabled")
    public void TC_STG_15_P1_verifyMatureFlagToggleIsEnabledTest() throws Exception
    {
        String LogInRange = "Login!A6:C6";
        String TopBarDropDownRange = "TopBarDropDownActions!A6:B6";
        String SettingsRange ="Settings!A2:L2";
        String PostWithHashTagRange = "PostWithHashTag!A14:B14";

        dsriveAPI().downloadFileFromGoogleDrive(TEST_IMAGE_ID1);
        String imageFile = userDirPath + IMAGE_TEST_FILE1;

        String username = null;
        String password = null;
        String fullname = null;
        String action = null;
        ArrayList<String> val = sheetAPI().getSpreadSheetValuesOfSpecificRow(TEST_DATA_GOOGLESHEET, LogInRange);
        username = val.get(0);
        password = val.get(1);
        fullname = val.get(2);

        getLoginPage().logIn("Action Step", fullname, "valid username, password",username, password);

        val = sheetAPI().getSpreadSheetValuesOfSpecificRow(TEST_DATA_GOOGLESHEET, TopBarDropDownRange);
        action = val.get(1);

        getHomePageActions().clickOnTopBarDropdown("Action Step");
        getSettingsActions().clickOnDropDownActions("Action Step",action);

        val = sheetAPI().getSpreadSheetValuesOfSpecificRow(TEST_DATA_GOOGLESHEET, SettingsRange);
        action = val.get(1);
        String enableFlag = val.get(5);
        String activity = val.get(11);

        getSettingsActions().clickOnTabs("Action Step",action);
        getSettingsActions().clickOnMatureFlagToggle("Action Step",enableFlag);
        getSettingsActions().clickOnSaveButton("Action Step");
        getSettingsActions().verifyDisplayOfToastContainer("Verify Step",activity);
        getHomePageActions().clickOnHomeTopBar("Action Step");

        val = sheetAPI().getSpreadSheetValuesOfSpecificRow(TEST_DATA_GOOGLESHEET, PostWithHashTagRange);
        String textPostVal= val.get(0);

        getHomePageActions().clickOnPosterTextArea("Action Step");
        getHomePageActions().enterTextOnMessageTextArea("Action Step", textPostVal);
        getHomePageActions().attachFile("Action Step",imageFile);
        getHomePageActions().verifyDisplayOfUploadedThumbnail("Verify Step");
        getPostWithHashTagActions().clickOnRestrictedContentToggleButton("Action Step");
        getPostWithHashTagActions().verifyRestrictedContentToggleIsEnabled("Verify Step");
        getHomePageActions().clickOnPostButton("Action step");

        getHomePageActions().verifyDisplayOfCreatedTextPost("Verify Step", textPostVal);
        getHomePageActions().verifyDispayOfCreatedImagePost("Verify Step");

        getPostWithHashTagActions().verifyDisplayOfCoverButtonOnFeed("Verify Step");
        getPostWithHashTagActions().clickOnCoverButton("Verify Step");
        getPostWithHashTagActions().verifyDisplayOfRestrictedContentCoveredPost("Verify Step");
    }

    /**
     * Test_Cases_For Mature Flag Disable
     * Author:- Gandahrva
     * Date:- 10-06-2020
     */
    @Test(priority = 124, enabled= true, alwaysRun = true, description = "Verify Mature Flag is Disabled")
    public void TC_STG_16_P1_verifyMatureFlagToggleIsDisabledTest() throws Exception
    {
        String LogInRange = "Login!A6:C6";
        String TopBarDropDownRange = "TopBarDropDownActions!A6:B6";
        String SettingsRange ="Settings!A2:M2";

        String username = null;
        String password = null;
        String fullname = null;
        String action = null;

        ArrayList<String> val = sheetAPI().getSpreadSheetValuesOfSpecificRow(TEST_DATA_GOOGLESHEET, LogInRange);
        username = val.get(0);
        password = val.get(1);
        fullname = val.get(2);

        getLoginPage().logIn("Action Step", fullname, "valid username, password",username, password);

        val = sheetAPI().getSpreadSheetValuesOfSpecificRow(TEST_DATA_GOOGLESHEET, TopBarDropDownRange);
        action = val.get(1);

        getHomePageActions().clickOnTopBarDropdown("Action Step");
        getSettingsActions().clickOnDropDownActions("Action Step",action);

        val = sheetAPI().getSpreadSheetValuesOfSpecificRow(TEST_DATA_GOOGLESHEET, SettingsRange);
        action = val.get(1);
        String disableFlag = val.get(6);
        String activity = val.get(12);

        getSettingsActions().clickOnTabs("Action Step",action);
        getSettingsActions().clickOnMatureFlagToggle("Action Step",disableFlag);
        getSettingsActions().clickOnSaveButton("Action Step");
        getSettingsActions().verifyDisplayOfToastContainer("Verify Step",activity);
        getHomePageActions().clickOnHomeTopBar("Action Step");

        getPostWithHashTagActions().verifyDisplayOfUnCoverButtonOnFeed("Verify Step");
        getPostWithHashTagActions().clickOnUnCoverButton("Verify Step");
        getPostWithHashTagActions().verifyDisplayOfRestrictedContentUnCoveredPost("Verify Step");
    }

    /**
     * Test_Cases_For Portfolio Flag Enable
     * Author:- Gandahrva
     * Date:- 11-06-2020
     */
    @Test(priority = 125, enabled= true, alwaysRun = true, description = "Verify Portfolio Flag Toggle is Enable")
    public void TC_STG_17_P1_verifyPortfolioToggleFlagIsEnableTest() throws Exception
    {
        String LogInRange = "Login!A6:C6";
        String TopBarDropDownRange = "TopBarDropDownActions!A6:B6";
        String SettingsRange ="Settings!A2:O2";

        String title = LOGIN_PAGE_TITLE;
        String username = null;
        String password = null;
        String fullname = null;
        String action = null;

        ArrayList<String> val = sheetAPI().getSpreadSheetValuesOfSpecificRow(TEST_DATA_GOOGLESHEET, LogInRange);
        username = val.get(0);
        password = val.get(1);
        fullname = val.get(2);

        getLoginPage().logIn("Action Step", fullname, "valid username, password",username, password);

        val = sheetAPI().getSpreadSheetValuesOfSpecificRow(TEST_DATA_GOOGLESHEET, TopBarDropDownRange);
        action = val.get(1);

        getHomePageActions().clickOnTopBarDropdown("Action Step");
        getSettingsActions().clickOnDropDownActions("Action Step",action);

        val = sheetAPI().getSpreadSheetValuesOfSpecificRow(TEST_DATA_GOOGLESHEET, SettingsRange);
        action = val.get(1);
        String disableFlag = val.get(7);
        String activity = val.get(14);

        getSettingsActions().clickOnTabs("Action Step",action);
        getSettingsActions().clickOnPortfolioFlagToggle("Action Step",disableFlag);
        getSettingsActions().clickOnSaveButton("Action Step");
        getSettingsActions().verifyDisplayOfToastContainer("Verify Step",activity);
        getHomePageActions().clickOnHomeTopBar("Action Step");

        String TopBarDropDownRangeForSignOut = "TopBarDropDownActions!A8:B8";
        val = sheetAPI().getSpreadSheetValuesOfSpecificRow(TEST_DATA_GOOGLESHEET, TopBarDropDownRangeForSignOut);
        action = val.get(1);

        getHomePageActions().clickOnTopBarDropdown("Action Step");
        getSettingsActions().clickOnDropDownActions("Action Step",action);

        LogInRange = "Login!A7:C7";
        val = sheetAPI().getSpreadSheetValuesOfSpecificRow(TEST_DATA_GOOGLESHEET, LogInRange);
        username = val.get(0);
        password = val.get(1);
        fullname = val.get(2);

        getLoginPage().logIn("Action Step", fullname, "valid username, password",username, password);

        String SearchUserRange = "Login!A6:B6";
        val = sheetAPI().getSpreadSheetValuesOfSpecificRow(TEST_DATA_GOOGLESHEET, SearchUserRange);
        String searchUserName = val.get(0);
        
        getSearchActions().enterUsernameOnSearchTextFieldAndSelectUserName("Action Step", searchUserName);
        getSearchActions().clickOnProfileTab("Action Step");
        getSettingsActions().clickOnUserFullName("Action Step");
        getSettingsActions().verifyPortfolioButtonIsNotDisplayedOnProfileCard("Verify Step");
    }


    /**
     * Test_Cases_For Portfolio Flag Diable
     * Author:- Gandahrva
     * Date:- 11-06-2020
     */
    @Test(priority = 126, enabled= true, alwaysRun = true, description = "Verify Portfolio Flag Toggle is Disable")
    public void TC_STG_18_P1_verifyPortfolioToggleFlagIsDisableTest() throws Exception
    {
        String LogInRange = "Login!A6:C6";
        String TopBarDropDownRange = "TopBarDropDownActions!A6:B6";
        String SettingsRange ="Settings!A2:P2";

        String title = LOGIN_PAGE_TITLE;
        String username = null;
        String password = null;
        String fullname = null;
        String action = null;

        ArrayList<String> val = sheetAPI().getSpreadSheetValuesOfSpecificRow(TEST_DATA_GOOGLESHEET, LogInRange);
        username = val.get(0);
        password = val.get(1);
        fullname = val.get(2);

        getLoginPage().logIn("Action Step", fullname, "valid username, password",username, password);

        val = sheetAPI().getSpreadSheetValuesOfSpecificRow(TEST_DATA_GOOGLESHEET, TopBarDropDownRange);
        action = val.get(1);

        getHomePageActions().clickOnTopBarDropdown("Action Step");
        getSettingsActions().clickOnDropDownActions("Action Step",action);

        val = sheetAPI().getSpreadSheetValuesOfSpecificRow(TEST_DATA_GOOGLESHEET, SettingsRange);
        action = val.get(1);
        String disableFlag = val.get(8);
        String activity = val.get(15);

        getSettingsActions().clickOnTabs("Action Step",action);
        getSettingsActions().clickOnPortfolioFlagToggle("Action Step",disableFlag);
        getSettingsActions().clickOnSaveButton("Action Step");
        getSettingsActions().verifyDisplayOfToastContainer("Verify Step",activity);
        getHomePageActions().clickOnHomeTopBar("Action Step");

        String TopBarDropDownRangeForSignOut = "TopBarDropDownActions!A8:B8";
        val = sheetAPI().getSpreadSheetValuesOfSpecificRow(TEST_DATA_GOOGLESHEET, TopBarDropDownRangeForSignOut);
        action = val.get(1);


        getHomePageActions().clickOnTopBarDropdown("Action Step");
        getSettingsActions().clickOnDropDownActions("Action Step",action);

        LogInRange = "Login!A7:C7";
        val = sheetAPI().getSpreadSheetValuesOfSpecificRow(TEST_DATA_GOOGLESHEET, LogInRange);
        username = val.get(0);
        password = val.get(1);
        fullname = val.get(2);

        getLoginPage().logIn("Action Step", fullname, "valid username, password",username, password);

        String SearchUserRange = "Login!A6:B6";
        val = sheetAPI().getSpreadSheetValuesOfSpecificRow(TEST_DATA_GOOGLESHEET, SearchUserRange);
        String searchUserName = val.get(0);

        getSearchActions().enterUsernameOnSearchTextFieldAndSelectUserName("Action Step", searchUserName);
        getSearchActions().clickOnProfileTab("Action Step");

        getSettingsActions().clickOnUserFullName("Action Step");
        getSettingsActions().verifyDisplayOfPortfolioButtonOnProfileCard("Verify Step");


    }

    /**
     * Test_Cases_For Contents Of Delete Account And Deactivate Account
     * Author:- Gandahrva
     * Date:- 11-06-2020
     */
    @Test(priority = 127, enabled= true, alwaysRun = true, description = "Verify Contents Of Delete Account And Deactivate Account")
    public void TC_STG_19_P1_verifyContentsOfDeleteAccountAndDeactivateAccountTest() throws Exception
    {

        String LogInRange = "Login!A6:C6";
        String TopBarDropDownRange = "TopBarDropDownActions!A6:B6";
        String SettingsRange ="Settings!A7:J7";

        String fullName = null;
        String username = null;
        String password = null;
        String action = null;

        ArrayList<String> val = sheetAPI().getSpreadSheetValuesOfSpecificRow(TEST_DATA_GOOGLESHEET, LogInRange);
        username = val.get(0);
        password = val.get(1);
        fullName = val.get(2);

        getLoginPage().logIn("Action Step",fullName,  "valid username, password",username, password);

        val = sheetAPI().getSpreadSheetValuesOfSpecificRow(TEST_DATA_GOOGLESHEET, TopBarDropDownRange);
        action = val.get(1);

        getHomePageActions().clickOnTopBarDropdown("Action Step");
        getSettingsActions().clickOnDropDownActions("Action Step",action);

        val = sheetAPI().getSpreadSheetValuesOfSpecificRow(TEST_DATA_GOOGLESHEET, SettingsRange);
        action = val.get(1);
        String reasons = val.get(9);

        getSettingsActions().clickOnTabs("Action Step",action);
        getSettingsActions().verifyDisplayOfDeleteAccountCheckBox("Verify Step");
        getSettingsActions().clickOnDeleteAccountCheckBox("Action Step");
        getSettingsActions().verifyDisplayOfGeneralPasswordDeleteAccountInputBox("Verify Step");
        getSettingsActions().verifyDisaplayOfConfirmDeleteAccountButton("Verify Step");
        getSettingsActions().verifyDisplayOfCancelDeleteAccountButton("Verify Step");
        //getSettingsActions().clickOnCancelDeleteAccountButton("Action Step");
        getSettingsActions().verifyDisplayOfDeActivateAccountCheckBox("Verify Step");
        getSettingsActions().clickOnDeActivateAccountCheckBox("Action Step");
        getSettingsActions().verifyDisplayOfDeactivateAccountReasons(reasons,"verify Step");
        getSettingsActions().clickOnDeactivateAccountOthersOthersCheckBox("Action Step");
        getSettingsActions().verifyDisplayOfDeactivateAccountOthersTextArea("Verify Step");
        getSettingsActions().verifyDisplayOfDeactivateAccountCancelButton("VerifyStep");
    }


    /**
     * Test_Cases_For Report DropDown
     * Author:- Gandahrva
     * Date:- 11-06-2020
     */
    @Test(priority = 128, enabled= true, alwaysRun = true, description = "Verify Contents Of Report DropDown")
    public void TC_STG_20_P1_verifyContentsOfReportDropDownTest() throws Exception
    {
        String LogInRange = "Login!A6:C6";
        String TopBarDropDownRange = "TopBarDropDownActions!A6:B6";
        String SettingsRange ="Settings!A6:K6";

        String fullName = null;
        String username = null;
        String password = null;
        String action = null;

        ArrayList<String> val = sheetAPI().getSpreadSheetValuesOfSpecificRow(TEST_DATA_GOOGLESHEET, LogInRange);
        username = val.get(0);
        password = val.get(1);
        fullName = val.get(2);

        getLoginPage().logIn("Action Step",fullName,  "valid username, password",username, password);

        val = sheetAPI().getSpreadSheetValuesOfSpecificRow(TEST_DATA_GOOGLESHEET, TopBarDropDownRange);
        action = val.get(1);

        getHomePageActions().clickOnTopBarDropdown("Action Step");
        getSettingsActions().clickOnDropDownActions("Action Step",action);

        val = sheetAPI().getSpreadSheetValuesOfSpecificRow(TEST_DATA_GOOGLESHEET, SettingsRange);
        action = val.get(1);
        String options= val.get(10);

        getSettingsActions().clickOnTabs("Action Step",action);
        getSettingsActions().verifyDisplayOfReportDropDown("Verify Step");
        getSettingsActions().verifyDisplayOfReportDropDownOptions(options,"Verify Step");
    }


    
    @AfterMethod(dependsOnMethods = {"com.aeione.ops.generic.TestSetUp.afterMethod"})
    public void after() throws IOException
    {
        getHomePageActions().navigateHomePage();
        getHomePageActions().clickOnTopBarDropdown("Action Step");
        getHomePageActions().clickOnSignOut("Action Step");

    }
}
