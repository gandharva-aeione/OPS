package com.aeione.ops.pageactions;

import com.aeione.ops.generic.DriverManager;
import com.aeione.ops.generic.ExtentTestManager;
import com.aeione.ops.generic.GenericFunctions;

import com.aeione.ops.pageobjects.RegistrationPageObjects;

import com.aventstack.extentreports.markuputils.CodeLanguage;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.cedarsoftware.util.io.JsonWriter;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.relevantcodes.extentreports.LogStatus;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.json.JSONWriter;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static com.aeione.ops.generic.GenericFunctions.getShortMonthFromNumber;
import static com.aeione.ops.generic.IAutoConst.*;


public class RegistrationPageActions {

    GenericFunctions genericfunctions;
    RegistrationPageObjects registrationpageobjects = new RegistrationPageObjects();
    Actions action;


    public RegistrationPageActions() throws IOException {


        genericfunctions = new GenericFunctions(DriverManager.getDriver());
        PageFactory.initElements(DriverManager.getDriver(), this);
        PageFactory.initElements(DriverManager.getDriver(), registrationpageobjects);
        action = new Actions(DriverManager.getDriver());
    }

    /////////////////////////// Page Actions////////////////////////////////////////////////////////////////////////////

    public String getFullName(String... strings) {
        String userName = null;
        try {

                userName = GenericFunctions.generateRandomName(8);
            }

         catch (Exception e) {
            Assert.fail("" + "&" + e.getMessage() + "");
        }
        return userName;
    }


    public String getUserName(String... strings) {
        String userName = null;
        try {
            userName = strings[0];
            if (userName.equals("")) {
                userName = GenericFunctions.generateRandomName(8);
            }

        } catch (Exception e) {
            Assert.fail("" + "&" + e.getMessage() + "");
        }
        return userName;
    }

    public String getEmail(String... strings) {
        String email = null;

        try {
         String[] b=strings[0].split("\\+");
         String[] c =  b[1].split("@");
           c[0]= c[0]+genericfunctions.generateRandomPhoneNumber(5);
        email=b[0]+"+"+c[0]+"@"+c[1];
        } catch (Exception e) {
            Assert.fail("" + "&" + e.getMessage() + "");
        }
        return email;
    }


    public String getPhoneNumber(String... strings) {
        String number = null;
        try {
            number = strings[0];
            if (number.equals("")) {
                number = genericfunctions.generateRandomPhoneNumber(9);
            }

        } catch (Exception e) {
            Assert.fail("" + "&" + e.getMessage() + "");
        }
        return number;
    }

    public String getRandomOTP(String... strings)
    {
        String number = null;
        try {
            number = genericfunctions.generateRandomNumber(5);
        } catch (Exception e) {
            Assert.fail("" + "&" + e.getMessage() + "");
        }
        return number;
    }

    public String getRandomInvalidPassword(String... strings)
    {
        String password = null;
        try {
            password = GenericFunctions.generateRandomName(8);
        } catch (Exception e) {
            Assert.fail("" + "&" + e.getMessage() + "");
        }
        return password;
    }

    public String getRandomValidPassword(String... strings)
    {
        String validPassword = null;
        try {

             validPassword = strings[0];
            if (validPassword.equals("")) {
                String a= GenericFunctions.generateRandomSpecialCharecter(1);
                String b= GenericFunctions.generateRandomName(1).toUpperCase();
                String c= GenericFunctions.generateRandomName(5);
                String d=genericfunctions.generateRandomPhoneNumber(1);
                validPassword = b+c+d+a;
            }

        } catch (Exception e) {
            Assert.fail("" + "&" + e.getMessage() + "");
        }
        return validPassword;
    }


    public ArrayList<String> mobileVerifyApi(String... strings) {
        ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " ::Execute  Mobile Number Verify API ");
        String number = null;
        String country_code = null;
        Boolean skip_otp = false;

        ArrayList<String> returnValues = new ArrayList<String>();
        try {

            number = strings[1].trim();
            if (number.equals("")) {
                number = genericfunctions.generateRandomPhoneNumber(9);
            }
            country_code = strings[2].trim();
            skip_otp = Boolean.valueOf(strings[3].toLowerCase());


            RestAssured.baseURI = MOBILE_VERIFY_URI;
            RequestSpecification request = RestAssured.given();

            JSONObject requestParams = new JSONObject();
            requestParams.put("number", country_code + number); // Cast
            requestParams.put("retry", false);
            requestParams.put("country_code", country_code);
            requestParams.put("h-otp-skip", skip_otp);

            request.body(requestParams.toJSONString());
            Response response = request.post("/verify");

            int statusCode = response.getStatusCode();
            ResponseBody body = response.getBody();

            JSONParser parser = new JSONParser();
            JSONObject json = (JSONObject) parser.parse(body.asString());
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            String jsonResponse = gson.toJson(json);


            returnValues.add(body.asString());
            System.out.println(jsonResponse);
            returnValues.add(response.jsonPath().get("secret"));

        } catch (Exception e) {
            Assert.fail("Could not verify Mobile number " + "&" + e.getMessage() + "");

        }

        return returnValues;
    }


    public String mobileConfirmApi(String... strings) throws Exception {
        ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " ::Execute  Mobile Number Confirm API ");
        String secret = strings[2];
        String number = null;
        Boolean skip_otp = false;
        String countryCode = strings[4];
        String jsonResponse = null;
        String returnVal = null;

        try {

            number = strings[1];
            if (number.equals("")) {
                number = genericfunctions.generateRandomPhoneNumber(9);
            }
            skip_otp = Boolean.valueOf(strings[3].toLowerCase());

            RestAssured.baseURI = MOBILE_CONFIRM_URI;
            RequestSpecification request = RestAssured.given();


            JSONObject requestParams = new JSONObject();
            requestParams.put("number", countryCode + number); // Cast
            requestParams.put("code", "121212");
            requestParams.put("secret", secret);
            requestParams.put("h-otp-skip", skip_otp);

            request.body(requestParams.toJSONString());
            Response response = request.post("/confirm");

            int statusCode = response.getStatusCode();
            ResponseBody body = response.getBody();

            JSONParser parser = new JSONParser();
            JSONObject json = (JSONObject) parser.parse(body.asString());
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            jsonResponse = gson.toJson(json);

            returnVal = body.asString();

            System.out.println(jsonResponse);
        } catch (Exception e) {
            Assert.fail("Could not confirm Mobile number " + "&" + e.getMessage() + "");

        }

        return returnVal;
    }

    public String registerApi(String... strings) throws Exception {
        ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " ::Execute  register  API ");

        String fullname = strings[1].trim();
        String username = strings[2].trim();
        String phonenumber = strings[3].trim();
        String countrycode = strings[4].trim();
        String secret = strings[5].trim();
        String email = strings[6].trim();
        String dateOfBirth = strings[7].trim();
        String password = strings[8].trim();
        Boolean skip_otp = false;
        String jsonResponse = null;
        String returnVal = null;
        String otp=null;

        try {
            String[] dateinfo = dateOfBirth.split("-");
            int monthinfo = Integer.valueOf(dateinfo[0].trim());
            String month = getShortMonthFromNumber(monthinfo).toUpperCase();
            String day = dateinfo[1].trim();
            String year = dateinfo[2].trim();
            skip_otp = Boolean.valueOf(strings[9].toLowerCase());

            try {
                if(!strings[10].isEmpty())
                {
                    otp=strings[10];
                }
            }catch (ArrayIndexOutOfBoundsException e)
            {

                    otp="121212";

            }


            RestAssured.baseURI = MOBILE_REGISTER_URI;
            RequestSpecification request = RestAssured.given();


            JSONObject requestParams = new JSONObject();
            JSONObject childJSON = new JSONObject();
            requestParams.put("name", fullname); // Cast
            requestParams.put("username", username);
            requestParams.put("number", countrycode + phonenumber);
            requestParams.put("code", otp);
            requestParams.put("country_code", countrycode);
            requestParams.put("secret", secret);
            requestParams.put("email", email);
            childJSON.put("year", year);
            childJSON.put("month", month);
            childJSON.put("day", day);
            requestParams.put("date_of_birth", childJSON);
            requestParams.put("password", password);
            requestParams.put("h-otp-skip", skip_otp);

            request.body(requestParams.toJSONString());
            Response response = request.post("/register");

            int statusCode = response.getStatusCode();
            ResponseBody body = response.getBody();

            JSONParser parser = new JSONParser();
            JSONObject json = (JSONObject) parser.parse(body.asString());
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            jsonResponse = gson.toJson(json);

            returnVal = body.asString();

            System.out.println(jsonResponse);
        } catch (Exception e) {
            Assert.fail("Could not register  " + "&" + e.getMessage() + "");

        }

        return returnVal;

    }


    public void enterRegisterDetails(String... strings) {

        try {
            ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " :: Enter register details ");

            String fullname = strings[1];
            String username = strings[2];
            String email = strings[3];
            String phoneNumber = strings[4];
            String otp = strings[5];

            genericfunctions.waitTillTheElementIsVisible(registrationpageobjects.registration_fullname_textfield);
            registrationpageobjects.registration_fullname_textfield.sendKeys();
        } catch (Exception e) {
            Assert.fail("Could not perform action on \"Registration fullname textfield\"" + "&" + e.getMessage() + "");

        }
    }


    public void enterPhoneNumber(String... strings) {
        try {
            ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " :: Enter valid phone number ");
            genericfunctions.waitTillTheElementIsVisible(registrationpageobjects.phone_textfield);
            registrationpageobjects.phone_textfield.sendKeys(strings[1]);
        } catch (Exception e) {
            Assert.fail("Could not perform action on \"phone textfield\"" + "&" + e.getMessage() + "");

        }
    }


    public void enterOTP(String... strings) {
        try {
            ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " :: Enter " + strings[1] + " ");
            genericfunctions.waitTillTheElementIsVisible(registrationpageobjects.otp_textfields.get(0));
            String[] opt = strings[2].split("");
            for (int i = 0; i <= opt.length - 1; i++) {
                registrationpageobjects.otp_textfields.get(i).sendKeys(opt[i]);
            }
        } catch (Exception e) {
            Assert.fail("Could not perform action on \"otp textfield\"" + "&" + e.getMessage() + "");
        }

    }


    public void clickOnCountryDropDown(String... strings) {
        try {
            ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " :: Click on Country Dropdown ");
            genericfunctions.waitTillTheElementIsVisible(registrationpageobjects.country_dropdown);
            registrationpageobjects.country_dropdown.click();
        } catch (Exception e) {
            Assert.fail("Could not perform action on \"Country Dropdown\"" + "&" + e.getMessage() + "");
        }
    }


    public String selectCoutry(String... strings) {
        String coutryId = null;
        try {
            ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " :: Select Country from dropdown  ");
            List<WebElement> countries = registrationpageobjects.country_option;


            Random r = new Random();
            // Getting a random value that is between 0 and (list's size)-1
            int randomValue = r.nextInt(countries.size());
            coutryId = countries.get(randomValue).getAttribute("id").trim();
            genericfunctions.scrollToElement(countries.get(randomValue));
            countries.get(randomValue).click();

        } catch (Exception e) {
            Assert.fail("Could not perform action on \"Country option\"" + "&" + e.getMessage() + "");
        }
        return coutryId;
    }


    ///////////////////////////////// Page Verifycations //////////////////

    public void verifyDisplayOfCountryDropdown(String... strings) {
        ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " :: Whether Country dropdown is displaying or not for each country option with  country flag , name , dial code ");
        List<WebElement> countries = null;
        String countryName = null;
        try {
            genericfunctions.waitTillTheElementIsVisible(registrationpageobjects.country_dropdown);
        } catch (Exception e) {
            Assert.fail("Could not find \"Country dropdown\"" + "&" + e.getMessage() + "");
        }

        try {
            countries = registrationpageobjects.country_option;
        } catch (Exception e) {
            Assert.fail("Could not find \"Country option\"" + "&" + e.getMessage() + "");
        }

        for (int i = 0; i <= countries.size() - 1; i++) {
            countryName = countries.get(i).getAttribute("id");

            genericfunctions.scrollToElement(countries.get(i));

            try {
                genericfunctions.waitTillTheElementIsVisible(registrationpageobjects.country_flag_box_option.get(i));
                Assert.assertTrue(registrationpageobjects.country_flag_box_option.get(i).isDisplayed());

            } catch (Exception e) {
                Assert.fail("Expected :: " + countryName + " country  flag should be displayed  ; Actual ::" + countryName + " country  flag is not displaying");
            }

            try {
                genericfunctions.waitTillTheElementIsVisible(registrationpageobjects.country_name_option.get(i));
                Assert.assertTrue(registrationpageobjects.country_name_option.get(i).isDisplayed());

            } catch (Exception e) {
                Assert.fail("Expected :: " + countryName + " country name  should be displayed  ; Actual ::" + countryName + " country  name  is not displaying");
            }

            try {
                genericfunctions.waitTillTheElementIsVisible(registrationpageobjects.dial_code_option.get(i));
                Assert.assertTrue(registrationpageobjects.dial_code_option.get(i).isDisplayed());

            } catch (Exception e) {
                Assert.fail("Expected :: " + countryName + " country dail code should be displayed  ; Actual ::" + countryName + " country  dail code is not displaying");
            }
        }

        ExtentTestManager.getTest().log(LogStatus.PASS, "country flag, country name, country dial code is displaying to country options");
    }


    public void verifyDisplayOfSelectedCoutryFlag(String... strings) {
        ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " :: Whether Selected country flag is displaying or not  ");

        String expectedCoutry = strings[1];
        String actualCoutry = null;

        try {
            genericfunctions.waitTillTheElementIsVisible(registrationpageobjects.selected_coutry);
            actualCoutry = registrationpageobjects.selected_coutry.getAttribute("class").trim();
            Assert.assertTrue(actualCoutry.contains(expectedCoutry));
            ExtentTestManager.getTest().log(LogStatus.PASS, "Selected country flag is displaying  for \"" + expectedCoutry + "\"");

        } catch (Exception e) {
            String actualException = e.getClass().getName();

            switch (actualException) {
                case "NoSuchElementException":
                    Assert.fail("Expected :: \"Selected Country \"   should be displayed ; Actual :: \"Selected Country \" is not displayed" + "&" + e.getMessage() + "");
                    break;
                case "AssertionError":
                    Assert.fail("Expected :: Selected country flag should be displayed for  \"" + expectedCoutry + "\"  ; Actual :: Selected country flag is displaying for  \"" + actualCoutry + "\"");

                    break;
                default:
                    Assert.fail("" + "&" + e.getMessage() + "");
            }
        }

    }


    public void verifyMobileApi(String... strings) throws Exception {
        ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " :: Mobile Verify Api with following assertions :  ");
        String response = strings[1];
        String actualstatus = null;
        try {
            JSONParser parser = new JSONParser();
            JSONObject json = (JSONObject) parser.parse(response);
            actualstatus = String.valueOf(json.get("status"));

            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            String jsonResponse = gson.toJson(json);

            Assert.assertTrue(actualstatus.equals("success"));
            Markup m = MarkupHelper.createCodeBlock(jsonResponse, CodeLanguage.JSON);
            ExtentTestManager.getTest().log(LogStatus.PASS, "<pre>" + "" + JsonWriter.formatJson(response) + "</pre>");
            ExtentTestManager.getTest().log(LogStatus.PASS, "Status is displaying as  \"success\"");
            System.out.println(jsonResponse);

        } catch (Exception e) {
            Assert.fail("Expected :: Mobile Verify Api status should be   \"success\"  ; Actual :: Mobile Verify Api status is  \"" + actualstatus + "\"");

        }
    }

    public void verifyMobileConfirmApi(String... strings) throws Exception {
        ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " :: Mobile Confirm Api with following assertions :  ");
        String response = strings[1];
        String actualstatus = null;
        try {
            JSONParser parser = new JSONParser();
            JSONObject json = (JSONObject) parser.parse(response);
            actualstatus = String.valueOf(json.get("status"));

            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            String jsonResponse = gson.toJson(json);

            Assert.assertTrue(actualstatus.equals("success"));
            Markup m = MarkupHelper.createCodeBlock(jsonResponse, CodeLanguage.JSON);
            ExtentTestManager.getTest().log(LogStatus.PASS, "<pre>" + "" + JsonWriter.formatJson(response) + "</pre>");
            ExtentTestManager.getTest().log(LogStatus.PASS, "Status is displaying as  \"success\"");
            System.out.println(jsonResponse);

        } catch (Exception e) {
            Assert.fail("Expected :: Mobile Confirm Api status should be   \"success\"  ; Actual :: Mobile Confirm Api status is  \"" + actualstatus + "\"");

        }
    }


    public void verifyRegisterApi(String... strings) throws Exception {
        ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " :: Register Api with following assertions :  ");
        String response = strings[1];
        String actualstatus = null;
        String expectedstatus="success";

        try {
            JSONParser parser = new JSONParser();
            JSONObject json = (JSONObject) parser.parse(response);
            actualstatus = String.valueOf(json.get("status"));

            Assert.assertTrue(actualstatus.equals(expectedstatus));

            ExtentTestManager.getTest().log(LogStatus.PASS, "<pre>" + "" + JsonWriter.formatJson(response) + "</pre>");
            ExtentTestManager.getTest().log(LogStatus.PASS, "Status is displaying as  \"" + actualstatus + "\"");
        } catch (Throwable e)
        {
            String actualException = e.getClass().getName();

            switch (actualException) {
                case "java.lang.AssertionError":
                    ExtentTestManager.getTest().log(LogStatus.FAIL, "<pre>" + "" + JsonWriter.formatJson(response) + "</pre>");
                    Assert.fail("Expected :: Response  \"Status\"  should be  \"success\" ; Actual :: Response  \"Status\" is \"" + actualstatus + "\"");

                    break;
                default:
                    Assert.fail("" + "&" + e.getMessage() + "");
            }

        }

    }

    public void verifyRegisterApiWithInvalidOTP(String... strings) throws Exception {
        ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " :: Register Api with Invalid OTP following assertions :  ");
        String response = strings[1];
        String actualstatus = null;
        String actualMessage = null;

        try {
            JSONParser parser = new JSONParser();
            JSONObject json = (JSONObject) parser.parse(response);
            actualstatus = String.valueOf(json.get("status"));
            actualMessage = String.valueOf(json.get("message"));

            try {
                Assert.assertTrue(actualstatus.equals("error"));
                ExtentTestManager.getTest().log(LogStatus.PASS, "<pre>" + "" + JsonWriter.formatJson(response) + "</pre>");
                ExtentTestManager.getTest().log(LogStatus.PASS, "Status is displaying as  \"" + actualstatus + "\"");
            } catch (AssertionError e) {
                ExtentTestManager.getTest().log(LogStatus.FAIL, "<pre>" + "" + JsonWriter.formatJson(response) + "</pre>");
                Assert.fail("Expected :: Response  \"Status\"  should be  \"error\" ; Actual :: Response  \"Status\" is \"" + actualstatus + "\"");
            }

            try {
                Assert.assertTrue(actualMessage.equals("Confirmation failed"));
                ExtentTestManager.getTest().log(LogStatus.PASS, "Message is displaying as  \"" + actualMessage + "\"");
            } catch (AssertionError e) {
                Assert.fail("Expected :: Response  \"Message\"  should be   \"Confirmation failed\" ; Actual :: Response  \"Message\" is \"" + actualMessage + "\"");
            }
        } catch (Exception e) {
            Assert.fail("" + "&" + e.getMessage() + "");
        }
    }


    public void verifyRegisterApiWithInvalidPassword(String... strings) throws Exception {
        ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " :: Register Api with Invalid Password following assertions :  ");
        String response = strings[1];
        String actualstatus = null;
        String actualMessage = null;
        String expectederrorMessage=strings[2];

        try {
            JSONParser parser = new JSONParser();
            JSONObject json = (JSONObject) parser.parse(response);
            actualstatus = String.valueOf(json.get("status"));
            actualMessage = String.valueOf(json.get("message"));

            try {
                Assert.assertTrue(actualstatus.equals("error"));
                ExtentTestManager.getTest().log(LogStatus.PASS, "<pre>" + "" + JsonWriter.formatJson(response) + "</pre>");
                ExtentTestManager.getTest().log(LogStatus.PASS, "Status is displaying as  \"" + actualstatus + "\"");
            } catch (AssertionError e) {
                ExtentTestManager.getTest().log(LogStatus.FAIL, "<pre>" + "" + JsonWriter.formatJson(response) + "</pre>");
                Assert.fail("Expected :: Response  \"Status\"  should be  \"error\" ; Actual :: Response  \"Status\" is \"" + actualstatus + "\"");
            }

            try {
                Assert.assertTrue(actualMessage.equals(expectederrorMessage));
                ExtentTestManager.getTest().log(LogStatus.PASS, "Message is displaying as  \"" + actualMessage + "\"");
            } catch (AssertionError e) {
                Assert.fail("Expected :: Response  \"Message\"  should be   \""+expectederrorMessage+"\" ; Actual :: Response  \"Message\" is \"" + actualMessage + "\"");
            }
        } catch (Exception e) {
            Assert.fail("" + "&" + e.getMessage() + "");
        }
    }


    public void verifyRegisterApiWithInvalidDOB(String... strings) throws Exception {
        ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " :: Register Api with Invalid DOB following assertions :  ");
        String response = strings[1];
        String actualstatus = null;
        String actualMessage = null;
        String expectederrorMessage=strings[2].trim();

        try {
            JSONParser parser = new JSONParser();
            JSONObject json = (JSONObject) parser.parse(response);
            actualstatus = String.valueOf(json.get("status")).trim();
            actualMessage = String.valueOf(json.get("message")).trim();

            try {
                Assert.assertTrue(actualstatus.equals("error"));
                ExtentTestManager.getTest().log(LogStatus.PASS, "<pre>" + "" + JsonWriter.formatJson(response) + "</pre>");
                ExtentTestManager.getTest().log(LogStatus.PASS, "Status is displaying as  \"" + actualstatus + "\"");
            } catch (AssertionError e) {
                ExtentTestManager.getTest().log(LogStatus.FAIL, "<pre>" + "" + JsonWriter.formatJson(response) + "</pre>");
                Assert.fail("Expected :: Response  \"Status\"  should be  \"error\" ; Actual :: Response  \"Status\" is \"" + actualstatus + "\"");
            }

            try {
                Assert.assertTrue(actualMessage.equals(expectederrorMessage));
                ExtentTestManager.getTest().log(LogStatus.PASS, "Message is displaying as  \"" + actualMessage + "\"");
            } catch (AssertionError e) {
                Assert.fail("Expected :: Response  \"Message\"  should be \""+expectederrorMessage+"\" ; Actual :: Response  \"Message\" is \"" + actualMessage + "\"");
            }
        } catch (Exception e) {
            Assert.fail("" + "&" + e.getMessage() + "");
        }
    }
}
