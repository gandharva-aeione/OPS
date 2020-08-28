package com.aeione.ops.test;


import com.aeione.ops.generic.GoogleSheetAPI;
import com.aeione.ops.generic.TestSetUp;
import com.aeione.ops.pageactions.HomePageActions;
import com.aeione.ops.pageactions.LoginPageActions;
import org.testng.annotations.Test;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;


/**
 * @author Kirthana SS
 *
 * Tests on Login functionalities
 */
public class LoginPageTest extends TestSetUp
{

   public LoginPageActions getLoginPage() throws IOException {
      return new LoginPageActions();
   }

   public HomePageActions getHomePageActions() throws IOException {
      return new HomePageActions();
   }
   public GoogleSheetAPI sheetAPI() throws IOException

   {
      return new GoogleSheetAPI();
   }


   @Test(priority = 06, enabled = true, alwaysRun = true, description = "Verify all the contents under the login page")
   public void tc_LG_01_P1_ContentsOfLoginPageTest() throws Exception
   {
      getLoginPage().verifyContentsOfLoginPage("Verify Step");
   }


   @Test(priority = 07, enabled = true, alwaysRun = true, description = "Verify if user will be able to login with a valid registered Username with valid password")
   public void tc_LG_02_P1_LoginViaValidUsernameAndPasswordTest() throws Exception
   {
      String  loginRange = "Login!A4:C4";
      Map<String, String> loginvalues = sheetAPI().getSpreadSheetRowValueByColumnName(TEST_DATA_GOOGLESHEET, loginRange);
      String username=loginvalues.get("UserName / Email / PhoneNumber");
      String password=loginvalues.get("Password");
      String fullname=loginvalues.get("FullName");

      getLoginPage().logIn("Action Step" ,fullname , "valid registered Username & password",username, password);
      getLoginPage().clickOnTopicSkipButton("Action Step");
      getHomePageActions().verifyDisplayOfHomeTopbar("Verify Step");
      getHomePageActions().clickOnTopBarDropdown("Action Step");
      getHomePageActions().clickOnSignOut("Action Step");
      getLoginPage().verifyDisplayOfLoginSubmitButton();

   }

   @Test(priority = 8, enabled = true, alwaysRun = true, description = "Verify if user will be able to login with a valid registered email with valid password")
   public void tc_LG_03_LoginViaValidEmailAndPassword() throws Exception
   {
      String  loginRange = "Login!A3:C3";
      Map<String, String> loginvalues = sheetAPI().getSpreadSheetRowValueByColumnName(TEST_DATA_GOOGLESHEET, loginRange);
      String email=loginvalues.get("UserName / Email / PhoneNumber");
      String password=loginvalues.get("Password");
      String fullname=loginvalues.get("FullName");


      getLoginPage().logIn("Action Step",fullname, "valid registered Email & password",email, password);
      getHomePageActions().verifyDisplayOfHomeTopbar("Verify Step");
      getHomePageActions().clickOnTopBarDropdown("Action Step");
      getHomePageActions().clickOnSignOut("Action Step");
      getLoginPage().verifyDisplayOfLoginSubmitButton();

   }

   @Test(priority = 9, enabled = true, alwaysRun = true, description = "Verify if user will be able to login with a valid registered mobile number & password")
   public void tc_LG_04_LoginWithValidMobileNumberAndPasswordTest() throws Exception
   {
      String  loginRange = "Login!A5:C5";
      Map<String, String> loginvalues = sheetAPI().getSpreadSheetRowValueByColumnName(TEST_DATA_GOOGLESHEET, loginRange);
      String mobileNumber=loginvalues.get("UserName / Email / PhoneNumber");
      String password=loginvalues.get("Password");
      String fullname=loginvalues.get("FullName");

      getLoginPage().logIn("Action Step",fullname,"valid registered MobileNumber & password",mobileNumber, password);
      getHomePageActions().verifyDisplayOfHomeTopbar("Verify Step");
      getHomePageActions().clickOnTopBarDropdown("Action Step");
      getHomePageActions().clickOnSignOut("Action Step");
      getLoginPage().verifyDisplayOfLoginSubmitButton();

   }

   @Test(priority = 10, enabled = true, alwaysRun = true, description = "Verify that user is getting error message with  Invalid mobile number on reset password")
   public void tc_LG_07_ResetPasswordWithInvalidMobileNumberTest() throws Exception
   {
      String  loginRange = "Login!A10:D10";
      Map<String, String> loginvalues = sheetAPI().getSpreadSheetRowValueByColumnName(TEST_DATA_GOOGLESHEET, loginRange);
      String errorMessage=loginvalues.get("Forgot Password ErrorMessage");

      getLoginPage().clickOnForgotPasswordLink("Action Step");
      getLoginPage().verifyDisplayOfPhoneNumberTextfield("Verify Step");
      String inValidMobileNumber= getLoginPage().getInvalidMobileNumber("Action Step");
      getLoginPage().enterMobileNumber("Action Step", "invalid", inValidMobileNumber);
      getLoginPage().clickOnResetPasswordButton("Action Step");
      getLoginPage().verifyDisplayOfInvalidPhoneNumberErrorMessage("Verify Step", errorMessage);
   }

}
