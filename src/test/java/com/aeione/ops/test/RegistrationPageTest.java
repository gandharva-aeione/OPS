package com.aeione.ops.test;

import com.aeione.ops.generic.GoogleSheetAPI;
import com.aeione.ops.generic.TestSetUp;
import com.aeione.ops.pageactions.RegistrationPageActions;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author :  Kirthana
 * @date   :  05-05-2020
 *
 * Tests on  Regsitartion Functionalities
 *
 */
public class RegistrationPageTest  extends TestSetUp
{

    public RegistrationPageActions getRegistrationPage() throws IOException {
        return new RegistrationPageActions();
    }

    public GoogleSheetAPI sheetAPI() throws IOException
    {
        return new GoogleSheetAPI();
    }


    @Test(priority = 01, enabled = true, alwaysRun = true, description = "Verify Registration API with valid password ")
    public void tc_RG_01_P1_RegistrationAPITest() throws Exception
    {

        String range = "Registration!A2:H";

        ArrayList<String> responseinfo=null;
        String response=null;

        ArrayList<String> val = sheetAPI().getSpreadSheetValuesOfSpecificRow(TEST_DATA_GOOGLESHEET, range);
        String fullName=val.get(0);
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


        //Update created account in Registration sheet
        List<List<Object>> values = Arrays.asList(Arrays.asList(fullName,userName,emailAddress, countryCode,phoneNumber,dateOfBirth,createPassword,skipOtp));
        sheetAPI().appendRowData(TEST_DATA_GOOGLESHEET,constantRow,  "USER_ENTERED", values);

        //Update values in sheet
        List<List<Object>> SetEmailLoginvalues = Arrays.asList(Arrays.asList(emailAddress, createPassword, fullName));
        String  loginRange = "Login!A3:C3";
        sheetAPI().updateMultipleCellValues(TEST_DATA_GOOGLESHEET, loginRange, "USER_ENTERED", SetEmailLoginvalues);

        List<List<Object>> setUserNameLoginvalues = Arrays.asList(Arrays.asList(userName, createPassword, fullName));
         loginRange = "Login!A4:C4";
        sheetAPI().updateMultipleCellValues(TEST_DATA_GOOGLESHEET, loginRange, "USER_ENTERED", setUserNameLoginvalues);

        List<List<Object>> setPhoneNumberLoginvalues = Arrays.asList(Arrays.asList(countryCode+phoneNumber, createPassword, fullName));
        loginRange = "Login!A5:C5";
        sheetAPI().updateMultipleCellValues(TEST_DATA_GOOGLESHEET, loginRange, "USER_ENTERED", setPhoneNumberLoginvalues);


    }


    @Test(priority = 02, enabled = true, alwaysRun = true, description = "Verify that user is able to register by giving Invalid OTP or not with  Registration API ")
    public void tc_RG_02_P1_RegistrationWithInvalidOTPAPITest() throws Exception
    {
        String range = "Registration!A2:H";

        ArrayList<String> responseinfo=null;
        String response=null;

        ArrayList<String> val = sheetAPI().getSpreadSheetValuesOfSpecificRow(TEST_DATA_GOOGLESHEET, range);
        String fullName=val.get(0);
        String userName=getRegistrationPage().getUserName(val.get(1));
        String emailAddress=getRegistrationPage().getEmail(val.get(2));
        String countryCode=val.get(3);
        String dateOfBirth=val.get(5);
        String createPassword=getRegistrationPage().getRandomValidPassword(val.get(6));
        String skipOtp=val.get(7);
        String invalidOTP=getRegistrationPage().getRandomOTP();
        String phoneNumber= getRegistrationPage().getPhoneNumber(val.get(4));

        responseinfo=getRegistrationPage().mobileVerifyApi("Action Step",phoneNumber, countryCode, skipOtp);
        response=responseinfo.get(0);
        String secret=responseinfo.get(1);

        getRegistrationPage().verifyMobileApi("Verify Step", response);
        response=getRegistrationPage().mobileConfirmApi("Action Step",phoneNumber, secret,skipOtp , countryCode );
        getRegistrationPage().verifyMobileConfirmApi("Verify Step", response);
        response= getRegistrationPage().registerApi("Action & verify", fullName,userName,phoneNumber,countryCode,secret, emailAddress,dateOfBirth,createPassword,skipOtp, invalidOTP);
        getRegistrationPage().verifyRegisterApiWithInvalidOTP("Verify Step", response);
    }



    @Test(priority = 03, enabled = true, alwaysRun = true, description = "Verify that user is able to register by giving Invalid Password  or not with  Registration API ")
    public void tc_RG_03_P1_RegistrationWithInvalidPasswordAPITest() throws Exception
    {
        String range = "Registration!A2:I";

        ArrayList<String> responseinfo=null;
        String response=null;

        ArrayList<String> val = sheetAPI().getSpreadSheetValuesOfSpecificRow(TEST_DATA_GOOGLESHEET, range);
        String fullName=val.get(0);
        String userName=getRegistrationPage().getUserName(val.get(1));
        String emailAddress=getRegistrationPage().getEmail(val.get(2));
        String countryCode=val.get(3);
        String dateOfBirth=val.get(5);
        String skipOtp=val.get(7);
        String invalidPassword=getRegistrationPage().getRandomInvalidPassword();
        String phoneNumber= getRegistrationPage().getPhoneNumber(val.get(4));
        String expectedINvalidPasswordErrorMessage=val.get(8);

        responseinfo=getRegistrationPage().mobileVerifyApi("Action Step",phoneNumber, countryCode, skipOtp);
        response=responseinfo.get(0);
        String secret=responseinfo.get(1);

        getRegistrationPage().verifyMobileApi("Verify Step", response);
        response=getRegistrationPage().mobileConfirmApi("Action Step",phoneNumber, secret,skipOtp , countryCode );
        getRegistrationPage().verifyMobileConfirmApi("Verify Step", response);
        response= getRegistrationPage().registerApi("Action & verify", fullName,userName,phoneNumber,countryCode,secret, emailAddress,dateOfBirth,invalidPassword,skipOtp);
        getRegistrationPage().verifyRegisterApiWithInvalidPassword("Verify Step", response, expectedINvalidPasswordErrorMessage);
    }


    @Test(priority = 04, enabled = true, alwaysRun = true, description = "Verify DOB with less than age limit during Registration API Test ")
    public void tc_RG_04_P1_RegistrationOnDOBWithAgeLimitAPITest() throws Exception
    {
        String validDataRange = "Registration!A2:J";
        String invalidDataRange="Registration!A3:K";

        ArrayList<String> responseinfo=null;
        String response=null;

        ArrayList<String> validData = sheetAPI().getSpreadSheetValuesOfSpecificRow(TEST_DATA_GOOGLESHEET, validDataRange);
        String fullName= validData.get(0);
        String userName=getRegistrationPage().getUserName(validData.get(1));
        String emailAddress=getRegistrationPage().getEmail(validData.get(2));
        String countryCode= validData.get(3);
        String skipOtp= validData.get(7);
        String createPassword=getRegistrationPage().getRandomValidPassword(validData.get(6));
        String phoneNumber= getRegistrationPage().getPhoneNumber(validData.get(4));
        ArrayList<String> inValidData = sheetAPI().getSpreadSheetValuesOfSpecificRow(TEST_DATA_GOOGLESHEET, invalidDataRange);
        String dateOfBirth= inValidData.get(5);
        String expectedINvalidDOBErrorMessage= inValidData.get(10);

        responseinfo=getRegistrationPage().mobileVerifyApi("Action Step",phoneNumber, countryCode, skipOtp);
        response=responseinfo.get(0);
        String secret=responseinfo.get(1);

        getRegistrationPage().verifyMobileApi("Verify Step", response);
        response=getRegistrationPage().mobileConfirmApi("Action Step",phoneNumber, secret,skipOtp , countryCode );
        getRegistrationPage().verifyMobileConfirmApi("Verify Step", response);
        response= getRegistrationPage().registerApi("Action & verify", fullName,userName,phoneNumber,countryCode,secret, emailAddress,dateOfBirth,createPassword,skipOtp);
        getRegistrationPage().verifyRegisterApiWithInvalidDOB("Verify Step", response, expectedINvalidDOBErrorMessage);
    }

    @Test(priority = 05, enabled = true, alwaysRun = true, description = "Verify the functionality of selecting a country code")
    public void tc_RG_05_P1_SelectCountryCodeTest() throws Exception
    {
        getRegistrationPage().clickOnCountryDropDown("Action Step");
        getRegistrationPage().verifyDisplayOfCountryDropdown("Verify Step");
        String selectCountry=getRegistrationPage().selectCoutry("Action Step");
        getRegistrationPage().verifyDisplayOfSelectedCoutryFlag("Verify Step", selectCountry);
    }
}
