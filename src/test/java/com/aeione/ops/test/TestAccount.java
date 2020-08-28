package com.aeione.ops.test;

import com.aeione.ops.generic.GoogleSheetAPI;
import com.aeione.ops.generic.TestSetUp;
import com.aeione.ops.pageactions.RegistrationPageActions;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class TestAccount extends TestSetUp
{
    public RegistrationPageActions getRegistrationPage() throws IOException {
        return new RegistrationPageActions();
    }

    public GoogleSheetAPI sheetAPI() throws IOException
    {
        return new GoogleSheetAPI();
    }

    @Test(invocationCount= 1, priority = 01, enabled = true, alwaysRun = true, description = "Verify Registration API with valid password ")
    public void tc_TA_01_P1_RegistrationAPITest() throws Exception
    {

        String range = "TestAccounts!A2:H";

        ArrayList<String> responseinfo=null;
        String response=null;

        //ArrayList<String> val = sheetAPI().getSpreadSheetValuesOfSpecificRow(TEST_DATA_GOOGLESHEET, range);
        Map<String, String> val = sheetAPI().getSpreadSheetRowValueByColumnName(TEST_DATA_GOOGLESHEET, range);
        String fullName=val.get("FullName");
        String userName=getRegistrationPage().getUserName(val.get("UserName"));
        //String emailAddress=getRegistrationPage().getEmail(val.get("Email Address"));
        String emailAddress=val.get("Email Address");
        String countryCode=val.get("Country Code");
        String dateOfBirth=val.get("Date of birth");
        String createPassword= val.get("Create Password");
        String skipOtp=val.get("Skip OTP");
        String phoneNumber= getRegistrationPage().getPhoneNumber(val.get("Phone Number"));

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
        sheetAPI().appendRowData(TEST_DATA_GOOGLESHEET,constantAccountRow,  "USER_ENTERED", values);

        //Update values in sheet
        List<List<Object>> SetEmailLoginvalues = Arrays.asList(Arrays.asList(emailAddress, createPassword, fullName));
        String  loginRange = "Login!A23:C23";
        sheetAPI().updateMultipleCellValues(TEST_DATA_GOOGLESHEET, loginRange, "USER_ENTERED", SetEmailLoginvalues);

        List<List<Object>> setUserNameLoginvalues = Arrays.asList(Arrays.asList(userName, createPassword, fullName));
        loginRange = "Login!A24:C24";
        sheetAPI().updateMultipleCellValues(TEST_DATA_GOOGLESHEET, loginRange, "USER_ENTERED", setUserNameLoginvalues);

        List<List<Object>> setPhoneNumberLoginvalues = Arrays.asList(Arrays.asList(countryCode+phoneNumber, createPassword, fullName));
        loginRange = "Login!A25:C25";
        sheetAPI().updateMultipleCellValues(TEST_DATA_GOOGLESHEET, loginRange, "USER_ENTERED", setPhoneNumberLoginvalues);


    }
}

