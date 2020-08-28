package com.aeione.ops.pageactions;

import com.aeione.ops.generic.DriverManager;
import com.aeione.ops.generic.ExtentTestManager;
import com.aeione.ops.generic.GenericFunctions;
import com.aeione.ops.pageobjects.RegistrationPageObjects;
import com.aeione.ops.pageobjects.SearchObjects;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.io.IOException;
import java.util.List;

public class SearchActions
{
    GenericFunctions genericfunctions;
    SearchObjects searchobjects = new SearchObjects();
    Actions action;


    public SearchActions() throws IOException {


        genericfunctions = new GenericFunctions(DriverManager.getDriver());
        PageFactory.initElements(DriverManager.getDriver(), this);
        PageFactory.initElements(DriverManager.getDriver(), searchobjects);
        action = new Actions(DriverManager.getDriver());
    }

    /////////////////////////// Page Actions////////////////////////////////////////////////////////////////////////////


    public void clickOnProfileTab(String ...strings)
    {
        ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " :: Click on <b>\"Profile\"</b> tab");
        try
        {
            genericfunctions.waitTillTheElementIsVisible(searchobjects.profile_tab);
            searchobjects.profile_tab.click();
        }
        catch(Exception e)
        {
            Assert.fail("Could not perform action on \"Profile\" tab" +"&"+ e.getMessage());
        }
    }

    /**
     * Enter username on search textField
     *
     * @param strings
     */
    public void enterUsernameOnSearchTextFieldAndSelectUserName(String ...strings)
    {
        String userName=strings[1].trim();
        try {
            ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " :: Enter <b> \""+userName+"\" </b> on search textField and select user");
            genericfunctions.waitForPageToLoad(searchobjects.search_textfield);
            genericfunctions.waitTillTheElementIsVisible(searchobjects.search_textfield);
            searchobjects.search_textfield.clear();
            genericfunctions.waitTillTheElementIsVisible(searchobjects.search_textfield);
            genericfunctions.waitWebDriver(1000);
            searchobjects.search_textfield.sendKeys(userName);
            action.sendKeys(Keys.ENTER).click().build().perform();

        } catch (Exception e) {
            Assert.fail("Could not perform action on \"Search\" textField" + "&" + e.getMessage() + "");
        }
    }

    /**
     *
     * Select username from user suggestion list options
     *
     * @param strings
     */
    public void selectUsernameFromUserSuggestionList(String ...strings)
    {
        String userName="@"+strings[1].trim();
        List<WebElement> listOptions=null;

        try {
            ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " :: Select  " + strings[1] + " ");

            genericfunctions.waitForPageToLoad(searchobjects.user_serch_suggestion_list_options.get(0));
            genericfunctions.waitTillTheElementIsVisible(searchobjects.user_serch_suggestion_list_options.get(0));
            listOptions=searchobjects.user_serch_suggestion_list_options;
            for(int i=0 ; i <= listOptions.size()-1;i++)
            {
                String a=listOptions.get(i).getText();

                if(a.trim().equals(userName))
                {
                    action.moveToElement(listOptions.get(i)).click().build().perform();
                    break;
                }
            }

        } catch (Exception e) {
            Assert.fail("Could not perform action on \"User suggestion \" list " + "&" + e.getMessage() + "");
        }

    }









}
