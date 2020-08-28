package com.aeione.ops.test;

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


/**
 * @author Kirthana
 * Tests on Wallet page functionalities
 */
public class WalletPageTest extends TestSetUp
{
    public RegistrationPageActions getRegistrationPage() throws IOException {
        return new RegistrationPageActions();
    }

    public LoginPageActions getLoginPage() throws IOException {
        return new LoginPageActions();
    }

    public WalletPageActions getWalletPageActions() throws IOException {
        return new WalletPageActions();
    }
    public GoogleSheetAPI sheetAPI() throws IOException

    {
        return new GoogleSheetAPI();
    }

    public HomePageActions getHomePageActions() throws IOException {
        return new HomePageActions();
    }


    @Test(priority = 93, enabled = true, alwaysRun = true, description = "Verify the functionality of wallet topBar ")
    public void tc_WLT_01_P1_VerifyWalletTopBarTest() throws Exception
    {
        String  loginRange = "Login!A13:C13";
        Map<String, String> loginvalues = sheetAPI().getSpreadSheetRowValueByColumnName(TEST_DATA_GOOGLESHEET, loginRange);
        String username=loginvalues.get("UserName / Email / PhoneNumber");
        String password=loginvalues.get("Password");
        String fullname=loginvalues.get("FullName");

        getLoginPage().logIn("Action Step", fullname, "valid username, password", username, password);
        getWalletPageActions().clickOnWalletTopBar("Action Step");
        getWalletPageActions().verifyNavigationWalletPage("Verify Step");
    }


    /**
     * @author Kirthana
     * @throws Exception
     *
     * Verify "0.25" Coins are getting added to wallet on registration
     *
     */
    @Test(priority = 94, enabled = true, alwaysRun = true, description = "Verify \"0.25\" coins are getting added to wallet on registration")
    public void tc_WLT_02_P1_VerifyCoinsAddedToWalletOnRegistrationTest() throws Exception
    {
        //Registration
        String registrationRange = "Registration!A2:H2";
        String  loginRange = "Login!A13:C13";
        String searchRange = "Search!A2:B2";
        String walletRange = "Wallet!A2:A2";

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
        List<List<Object>> updateLoginValues = Arrays.asList(Arrays.asList(userName, createPassword, fullName));
        sheetAPI().updateMultipleCellValues(TEST_DATA_GOOGLESHEET, loginRange, "USER_ENTERED", updateLoginValues);

        List<List<Object>> updateSearchValues = Arrays.asList(Arrays.asList(userName, fullName));
        sheetAPI().updateMultipleCellValues(TEST_DATA_GOOGLESHEET, searchRange, "USER_ENTERED", updateSearchValues);

        //Login
        Map<String, String> loginvalues = sheetAPI().getSpreadSheetRowValueByColumnName(TEST_DATA_GOOGLESHEET, loginRange);
        String username=loginvalues.get("UserName / Email / PhoneNumber");
        String password=loginvalues.get("Password");
        String fullname=loginvalues.get("FullName");

        //WALLET
        Map<String, String> walletValues = sheetAPI().getSpreadSheetRowValueByColumnName(TEST_DATA_GOOGLESHEET, walletRange);

        getLoginPage().logIn("Action Step", fullname, "valid username, password", username, password);
        getLoginPage().clickOnTopicSkipButton("Action Step");
        getWalletPageActions().clickOnWalletTopBar("Action Step");
        getWalletPageActions().verifyCoinsAddedInWalletOnRegistration("Verify Step", walletValues.get("Registration Reward Points").trim());
    }


    /**
     * @author Kirthana
     * @throws Exception
     *
     * Verify Contents of Transaction Tab
     *
     */
    @Test(priority = 95, enabled = true, alwaysRun = true, description = "Verify Contents of Transaction Tab")
    public void tc_WLT_04_P1_VerifyContentsOfTransactionTabTest() throws Exception
    {
        String  loginRange = "Login!A13:C13";

        Map<String, String> loginvalues = sheetAPI().getSpreadSheetRowValueByColumnName(TEST_DATA_GOOGLESHEET, loginRange);
        String username=loginvalues.get("UserName / Email / PhoneNumber");
        String password=loginvalues.get("Password");
        String fullname=loginvalues.get("FullName");

        getLoginPage().logIn("Action Step", fullname, "valid username, password", username, password);
        getWalletPageActions().clickOnWalletTopBar("Action Step");
        getWalletPageActions().verifyNavigationWalletPage("Verify Step");
        getWalletPageActions().clickOnTransactionTab("Action Step");
        getWalletPageActions().verifyNavigationToTransactionTab("Verify Step");

    }



    /**
     * @author Kirthana
     * @throws Exception
     *
     * Verify Calculating of cost per coins in Buy Coins popup
     *
     */
    @Test(priority = 96, enabled = true, alwaysRun = true, description = "Verify Calculating of cost per coins in Buy Coins popup")
    public void tc_WLT_07_P1_VerifyCalculationOfCostPerBuyCoinsTest() throws Exception
    {
        String  loginRange = "Login!A13:C13";
        String walletRange = "Wallet!A2:C2";
        Map<String, String> loginvalues = sheetAPI().getSpreadSheetRowValueByColumnName(TEST_DATA_GOOGLESHEET, loginRange);
        String username=loginvalues.get("UserName / Email / PhoneNumber");
        String password=loginvalues.get("Password");
        String fullname=loginvalues.get("FullName");

        //WALLET
        Map<String, String> walletValues = sheetAPI().getSpreadSheetRowValueByColumnName(TEST_DATA_GOOGLESHEET, walletRange);

        getLoginPage().logIn("Action Step", fullname, "valid username, password", username, password);
        getWalletPageActions().clickOnWalletTopBar("Action Step");
        getWalletPageActions().verifyNavigationWalletPage("Verify Step");
        getWalletPageActions().clickOnBuyCoinsButtonInWallet("Action Step");
        getWalletPageActions().enterCoinsInBuyCoinsPopup("Action Step", walletValues.get("Coins to Buy").trim());
        getWalletPageActions().verifyCalculatingCostPerCoins("Verify Step",  walletValues.get("Cost Per Coin").trim());

    }



    /**
     * @author Kirthana
     * @throws Exception
     *
     * Verify incrementing and decrementing Coins & Cost  via  coins slider at buy coins popup
     *
     */
    @Test(priority = 97, enabled = true, alwaysRun = true, description = "Verify incrementing and decrementing Coins & Cost  via  coins slider at buy coins popup")
    public void tc_WLT_18_P1_VerifyCoinsSliderAtBuyCoinsPopupTest() throws Exception
    {
        String  loginRange = "Login!A13:C13";
        String walletRange = "Wallet!A2:C2";
        Map<String, String> loginvalues = sheetAPI().getSpreadSheetRowValueByColumnName(TEST_DATA_GOOGLESHEET, loginRange);
        String username=loginvalues.get("UserName / Email / PhoneNumber");
        String password=loginvalues.get("Password");
        String fullname=loginvalues.get("FullName");

        //WALLET
        Map<String, String> walletValues = sheetAPI().getSpreadSheetRowValueByColumnName(TEST_DATA_GOOGLESHEET, walletRange);

        getLoginPage().logIn("Action Step", fullname, "valid username, password", username, password);
        getWalletPageActions().clickOnWalletTopBar("Action Step");
        getWalletPageActions().verifyNavigationWalletPage("Verify Step");
        getWalletPageActions().clickOnBuyCoinsButtonInWallet("Action Step");
        String beforeDragAndDropOfSlider=getWalletPageActions().getTotalCoinsToBuy();
        getWalletPageActions().verifyCalculatingCostPerCoins("Verify Step",  walletValues.get("Cost Per Coin").trim());
        getWalletPageActions().dragAndDropCoinsSliderAtBuyCoinsPopup("Action Step");
        getWalletPageActions().verifyCalculatingCostPerCoins("Verify Step" ,  walletValues.get("Cost Per Coin").trim());
        String afterDragAndDropOfSlider=getWalletPageActions().getTotalCoinsToBuy();
        getWalletPageActions().verifyUpdatingCoinsAfterDragAndDropOfCoinsSlider("Verify Step", beforeDragAndDropOfSlider, afterDragAndDropOfSlider);
    }



    @AfterMethod(dependsOnMethods = {"com.aeione.ops.generic.TestSetUp.afterMethod"})
    public void after() throws IOException {
        getHomePageActions().navigateHomePage();
        getHomePageActions().clickOnTopBarDropdown("Action Step");
        getHomePageActions().clickOnSignOut("Action Step");

    }

}
