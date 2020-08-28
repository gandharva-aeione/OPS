package com.aeione.ops.pageactions;

import com.aeione.ops.generic.DriverManager;
import com.aeione.ops.generic.ExtentTestManager;
import com.aeione.ops.generic.GenericFunctions;
import com.aeione.ops.pageobjects.ProfileCompletionPageObjects;
import com.aeione.ops.pageobjects.GenericPageObjects;
import com.aeione.ops.pageobjects.ProfilePageObjects;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.io.IOException;
import java.util.List;

public class ProfileCompletionPageActions {
    GenericFunctions genericfunctions;
    ProfileCompletionPageObjects profileCompletionPageObjects = new ProfileCompletionPageObjects();
    ProfilePageObjects profilePageObjects=new ProfilePageObjects();
    GenericPageObjects genericpageObjects=new GenericPageObjects();
    Actions action;
    Select dropdownOption = null;
    public static String newline = "";


    public ProfileCompletionPageActions() throws IOException {

        genericfunctions = new GenericFunctions(DriverManager.getDriver());
        PageFactory.initElements(DriverManager.getDriver(), this);
        PageFactory.initElements(DriverManager.getDriver(), profileCompletionPageObjects);
        PageFactory.initElements(DriverManager.getDriver(), genericpageObjects);
        PageFactory.initElements(DriverManager.getDriver(), profilePageObjects);
        action = new Actions(DriverManager.getDriver());
        newline = System.getProperty("line.separator");
    }

    /////////////////////////// Page Actions////////////////////////////////////////////////////////////////////////////

    /**
     * @autor click on edit icon of about section
     * @param strings
     */
    public void clickOnEditIconOfAboutSection(String ...strings)
    {
        ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " :: Click on \"Edit\" icon of About section");
        try
        {
            genericfunctions.waitTillTheElementIsVisible(profilePageObjects.editIcon_AboutSection);
            profilePageObjects.editIcon_AboutSection.click();
        }
        catch(Exception e)
        {
            Assert.fail("Could not perform action on \"Edit\" icon of about section " +"&"+ e.getMessage());
        }
    }

    /**
     * @autor click on follow button
     * @param strings
     */
    public void clickOnFollowButton(String ...strings)
    {
        ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " :: Click on follow button");
        try
        {
            genericfunctions.waitForPageToLoad(profileCompletionPageObjects.follow_button);
            genericfunctions.waitTillTheElementIsVisible(profileCompletionPageObjects.follow_button);
            profileCompletionPageObjects.follow_button.click();
        }
        catch(Exception e)
        {
            Assert.fail("Could not perform action on \"Follow \" button " +"&"+ e.getMessage());
        }
    }


    /**
     * @autor click on delete icon
     * @param strings
     */
    public void clickOnCoverImageDeleteIcon(String ...strings)
    {
        ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " :: Click on cover image \"delete\" icon");
        try
        {
            genericfunctions.waitTillTheElementIsVisible(profileCompletionPageObjects.delete_cover_image_icon);
            profileCompletionPageObjects.delete_cover_image_icon.click();
        }
        catch(Exception e)
        {
            Assert.fail("Could not perform action on \"Cover Image Delete \" icon " +"&"+ e.getMessage());
        }
    }




    /**
     * @autor click on edit icon
     * @param strings
     */
    public void clickOnCoverImageEditIcon(String ...strings)
    {
        ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " :: Click on cover image \"edit\" icon");
        try
        {
            genericfunctions.waitForPageToLoad(profileCompletionPageObjects.cover_image_edit_icon);
            genericfunctions.waitTillTheElementIsVisible(profileCompletionPageObjects.cover_image_edit_icon);
            profileCompletionPageObjects.cover_image_edit_icon.click();
        }
        catch(Exception e)
        {
            Assert.fail("Could not perform action on \"Cover Image Edit \" icon " +"&"+ e.getMessage());
        }
    }

    /**
     * @autor click on save icon
     * @param strings
     */
    public void clickOnCoverImageSaveIcon(String ...strings)
    {
        ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " :: Click on cover image \"save\" icon");
        try
        {
            genericfunctions.waitTillTheElementIsVisible(profileCompletionPageObjects.cover_image_save_icon);
            profileCompletionPageObjects.cover_image_save_icon.click();
        }
        catch(Exception e)
        {
            Assert.fail("Could not perform action on \"Cover Image Save \" icon " +"&"+ e.getMessage());
        }
    }



    /**
     * get profile completion range
     *
     * @param strings
     * @autor Kirthana SS
     */
    public String getProfileCompletionRange(String... strings) {

        String profileCopmpletionRange=null;
        try {
            genericfunctions.waitWebDriver(1000);
            genericfunctions.waitForPageToLoad(profileCompletionPageObjects.profile_completion_range_percentage);
            genericfunctions.waitTillTheElementIsVisible(profileCompletionPageObjects.profile_completion_range_percentage);
            profileCopmpletionRange= profileCompletionPageObjects.profile_completion_range_percentage.getText();
            ExtentTestManager.getTest().log(LogStatus.PASS, "Profile Completion Percentage is <b>\""+profileCopmpletionRange+"\" </b> ");

        } catch (Exception e) {
            Assert.fail("Could not perform action on \"Contact \"tab" + "&" + e.getMessage());
        }

         return profileCopmpletionRange;
    }




    /**
     * click on contact tab
     *
     * @param strings
     * @autor Kirthana SS
     */
    public void clickOnContactTab(String... strings) {
        ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " :: Click on contact tab");
        try {
            genericfunctions.waitTillTheElementIsVisible(profileCompletionPageObjects.profile_edit_contact_tab);
            profileCompletionPageObjects.profile_edit_contact_tab.click();
        } catch (Exception e) {
            Assert.fail("Could not perform action on \"Contact \"tab" + "&" + e.getMessage());
        }
    }


    /**
     * enter  location on contact textfield
     *
     * @param strings
     * @autor Kirthana SS
     */
    public void enterContactLocation(String... strings) {
        String contactLocation=strings[1].trim();
        ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " :: Enter contact location as  <b>\""+contactLocation+"\" </b> ");
        try {
            genericfunctions.waitTillTheElementIsVisible(profileCompletionPageObjects.profile_edit_contact_location_textfield);
            profileCompletionPageObjects.profile_edit_contact_location_textfield.clear();
            genericfunctions.waitTillTheElementIsVisible(profileCompletionPageObjects.profile_edit_contact_location_textfield);
            profileCompletionPageObjects.profile_edit_contact_location_textfield.sendKeys(contactLocation);
            genericfunctions.waitTillTheElementIsVisible(profileCompletionPageObjects.profile_edit_contact_location_textfield);
        } catch (Exception e) {
            Assert.fail("Could not perform action on \"Contact location \" textfield" + "&" + e.getMessage());
        }
    }

    /**
     * click on contact updation save button
     *
     * @param strings
     * @autor Kirthana SS
     */
    public void clickContactUpdationSaveChangesButton(String... strings) {

        ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " :: Click on contact updation save button ");
        try {
            genericfunctions.waitTillTheElementIsVisible(profileCompletionPageObjects.contact_save_chnages_button);
            profileCompletionPageObjects.contact_save_chnages_button.click();
        } catch (Exception e) {
            Assert.fail("Could not perform action on \"Save \" button in contact info " + "&" + e.getMessage());
        }
    }


    /**
     * click on contact location visible button
     *
     * @param strings
     * @autor Kirthana SS
     */
    public void clickContactLocationVisibleButton(String... strings) {

        ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " :: Click on contact location visible button ");
        try {
            genericfunctions.waitTillTheElementIsVisible(profileCompletionPageObjects.profile_edit_contact_location_visible_privacy_button);
            profileCompletionPageObjects.profile_edit_contact_location_visible_privacy_button.click();
        } catch (Exception e) {
            Assert.fail("Could not perform action on \"Contact location visible \" button  " + "&" + e.getMessage());
        }
    }

    /**
     * Select  contact location visible option
     *
     * @param strings
     * @autor Kirthana SS
     */
    public void selectContactLocationVisibleOption(String... strings) {
        String contactLocationvisibleOption=strings[1];
        List<WebElement> listOptions=null;

        ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " :: Select on contact location visible option as <b>\""+contactLocationvisibleOption+"\" </b>");
        try {

            genericfunctions.waitTillTheElementIsVisible(profileCompletionPageObjects.contact_location_visible_options.get(0));
            listOptions= profileCompletionPageObjects.contact_location_visible_options;
            for(int i=0 ; i <= listOptions.size()-1;i++)
            {
                if(listOptions.get(i).getText().trim().equals(contactLocationvisibleOption))
                {
                    listOptions.get(i).click();
                }
            }

        } catch (Exception e) {
            Assert.fail("Could not perform action on \""+contactLocationvisibleOption+" \" option " + "&" + e.getMessage() + "");
        }
    }





    /**
     * click on award tab
     *
     * @param strings
     * @autor Kirthana SS
     */
    public void clickOnAwardTab(String... strings) {
        ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " :: Click on award tab");
        try {
            genericfunctions.waitTillTheElementIsVisible(profileCompletionPageObjects.profile_edit_awards_tab);
            profileCompletionPageObjects.profile_edit_awards_tab.click();
        } catch (Exception e) {
            Assert.fail("Could not perform action on \"Award \"tab" + "&" + e.getMessage());
        }
    }

    /**
     * Click on Add Award button
     *
     * @param strings
     * @autor Kirthana SS
     */
    public void clickAddAwardButton(String... strings) {

        ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " :: Click on add award button");
        try {
            genericfunctions.waitTillTheElementIsVisible(profileCompletionPageObjects.awards_add_awards_button);
            profileCompletionPageObjects.awards_add_awards_button.click();
        } catch (Exception e) {
            Assert.fail("Could not perform action on \"Add Awards \" button " + "&" + e.getMessage());
        }
    }


    /**
     * Enter Award Ttile
     *
     * @param strings
     * @autor Kirthana SS
     */
    public void enterAwardTitle(String... strings) {
        String awardtitle = strings[1];
        ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " :: Enter Award Title as <b>\"" + awardtitle + "\"</b>");
        try {
            genericfunctions.waitTillTheElementIsVisible(profileCompletionPageObjects.award_titile_textfield);
            profileCompletionPageObjects.award_titile_textfield.clear();
            profileCompletionPageObjects.award_titile_textfield.sendKeys(awardtitle);
        } catch (Exception e) {
            Assert.fail("Could not perform action on \"Award Ttile \" textfield " + "&" + e.getMessage());
        }
    }


    /**
     * Enter Award issuer
     *
     * @param strings
     * @autor Kirthana SS
     */
    public void enterAwardIssuer(String... strings) {
        String awardissuer = strings[1];
        ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " :: Enter Award Issuer as <b>\"" + awardissuer + "\"</b>");
        try {
            genericfunctions.waitTillTheElementIsVisible(profileCompletionPageObjects.awards_issuer_textfield);
            profileCompletionPageObjects.awards_issuer_textfield.clear();
            profileCompletionPageObjects.awards_issuer_textfield.sendKeys(awardissuer);
        } catch (Exception e) {
            Assert.fail("Could not perform action on \"Award Issuer \" textfield " + "&" + e.getMessage());
        }
    }


    /**
     * Enter Award issued location
     *
     * @param strings
     * @autor Kirthana SS
     */
    public void enterAwardIssuedLocation(String... strings) {
        String awardissuedlocation = strings[1];
        ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " :: Enter Award Issued location as <b>\"" + awardissuedlocation + "\"</b>");
        try {
            genericfunctions.waitTillTheElementIsVisible(profileCompletionPageObjects.awards_location_textfield);
            profileCompletionPageObjects.awards_location_textfield.clear();
            profileCompletionPageObjects.awards_location_textfield.sendKeys(awardissuedlocation);
        } catch (Exception e) {
            Assert.fail("Could not perform action on \"Award location \" textfield " + "&" + e.getMessage());
        }
    }


    /**
     * Select Award issued month
     *
     * @param strings
     * @autor Kirthana SS
     */
    public void selectAwardIssuedMonth(String... strings) {
        String awardissuedmonth = GenericFunctions.getShortMonthFromNumber(Integer.valueOf(strings[1].trim())).toUpperCase();
        ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " :: Enter Award Issued month as <b>\"" + awardissuedmonth + "\"</b>");
        try {
            genericfunctions.waitTillTheElementIsVisible(profileCompletionPageObjects.awards_issued_month_selector_dropdown);
            dropdownOption = new Select(profileCompletionPageObjects.awards_issued_month_selector_dropdown);
            dropdownOption.selectByValue(awardissuedmonth);
        } catch (Exception e) {
            Assert.fail("Could not perform action on \"Award issued month \" dropdown " + "&" + e.getMessage());
        }
    }


    /**
     * Select Award issued year
     *
     * @param strings
     * @autor Kirthana SS
     */
    public void selectAwardIssuedYear(String... strings) {
        String awardissuedyear = strings[1];
        ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " :: Enter Award Issued year as <b>\"" + awardissuedyear + "\"</b>");
        try {
            genericfunctions.waitTillTheElementIsVisible(profileCompletionPageObjects.awards_issued_year_selector_dropdown);
            dropdownOption = new Select(profileCompletionPageObjects.awards_issued_year_selector_dropdown);
            dropdownOption.selectByValue(awardissuedyear);
        } catch (Exception e) {
            Assert.fail("Could not perform action on \"Award issued year \" dropdown " + "&" + e.getMessage());
        }
    }

    /**
     * Click show award on profile
     *
     * @param strings
     * @autor Kirthana SS
     */
    public void clickOnShowAwardOnProfileRadioButton(String... strings) {
        boolean isShowAwardOnProfile = Boolean.valueOf(strings[1].toLowerCase());
        if (isShowAwardOnProfile == true) {
            ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " :: Click on show award on profile radio button");
            try {
                genericfunctions.waitTillTheElementIsVisible(profileCompletionPageObjects.awards_show_on_profile_radiobutton);
                profileCompletionPageObjects.awards_show_on_profile_radiobutton.click();

            } catch (Exception e) {
                Assert.fail("Could not perform action on \"Show award on profile \" radio button " + "&" + e.getMessage());
            }
        }
    }

    /**
     * Click on award updation save button
     *
     * @param strings
     * @autor Kirthana SS
     */
    public void clickOnAwardUpdationSaveButton(String... strings) {
        String awardissuedtartmontherrormessage = strings[1];

        ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " ::  Click on award updation  save button");
        try {
            genericfunctions.waitTillTheElementIsVisible(profileCompletionPageObjects.awards_update_button);
            profileCompletionPageObjects.awards_update_button.click();

            Assert.fail("<b>\"" + awardissuedtartmontherrormessage + "\"</b> error message should be displayed " + "&" + " Defect Link - <a href='https://taiga.vnaad.com/project/admin-one-page-spotlight/issue/1034' target='_blank'>https://taiga.vnaad.com/project/admin-one-page-spotlight/issue/1034</a>  ");


        } catch (Exception e) {
            Assert.fail("Could not perform action on \"Save Changes \"  button in award section " + "&" + e.getMessage());
        }

    }


    /**
     * Click on  Work section save button
     *
     * @param strings
     * @autor Kirthana SS
     */
    public void clickOnWorkSectionSaveButton(String... strings) {
        String workstartmontherrormessage = strings[1];

        ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " :: Click on Work section save button");
        try {
            genericfunctions.waitTillTheElementIsVisible(profileCompletionPageObjects.work_save_button);
            profileCompletionPageObjects.work_save_button.click();

//            try
//            {
//                actualError = homepageobjects.blog_title_error.getText();
//                Assert.assertTrue(actualError.equals(exceptedError));
//                Assert.fail("Expected ::  \""+exceptedError+"\" should not be displayed ; Actual:: \""+actualError+"\" is displayed ");
//            }
//            catch(Throwable e)
//            {
//                String actualException=e.getClass().getName();
//
//                switch (actualException)
//                {
//                    case "NoSuchElementException":
//
//                        break;
//                    case "AssertionError":
//                        Assert.fail(actualError+ "error message  is  displaying "+"&"+e.getMessage()+"");
//                        break;
//                    default:
//                        Assert.fail("" + e.getMessage()+ "");
//                }
//            }

            Assert.fail("<b>\"" + workstartmontherrormessage + "\"</b> error message should be displayed " + "&" + " Defect Link - <a href='https://taiga.vnaad.com/project/admin-one-page-spotlight/issue/1034' target='_blank'>https://taiga.vnaad.com/project/admin-one-page-spotlight/issue/1034</a>  ");


        } catch (Exception e) {
            Assert.fail("Could not perform action on \"Save Changes \" button  on Work section " + "&" + e.getMessage());
        }
    }


    /**
     * Select Work Start Month dropdown
     *
     * @param strings
     * @autor Kirthana SS
     */
    public void selectWorkStartMonth(String... strings) {
        String workstartMonth = GenericFunctions.getShortMonthFromNumber(Integer.valueOf(strings[1].trim())).toUpperCase();

        ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " :: Select work start month  as <b>\"" + workstartMonth + "\"</b>");
        try {
            genericfunctions.waitTillTheElementIsVisible(profileCompletionPageObjects.work_start_month_selector_dropdown);
            dropdownOption = new Select(profileCompletionPageObjects.work_start_month_selector_dropdown);
            dropdownOption.selectByValue(workstartMonth);
        } catch (Exception e) {
            Assert.fail("Could not perform action on \"Work Start Month  \" dropdown " + "&" + e.getMessage());
        }
    }


    /**
     * Select Work Start Year dropdown
     *
     * @param strings
     * @autor Kirthana SS
     */
    public void selectWorkStartYear(String... strings) {
        String workstartYear = strings[1].trim();
        ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " :: Select work start year  as <b> \"" + workstartYear + "\"</b>");
        try {
            genericfunctions.waitTillTheElementIsVisible(profileCompletionPageObjects.work_start_year_selector_dropdown);
            dropdownOption = new Select(profileCompletionPageObjects.work_start_year_selector_dropdown);
            dropdownOption.selectByValue(workstartYear);
        } catch (Exception e) {
            Assert.fail("Could not perform action on \"Work Start Year  \" dropdown " + "&" + e.getMessage());
        }
    }


    /**
     * Enter companyName
     *
     * @param strings
     * @autor Kirthana SS
     */
    public void enterCompanyName(String... strings) {
        String companyname = strings[1];
        ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " :: Enter company Name  as <b>\"" + companyname + "\"</b>");
        try {
            genericfunctions.waitTillTheElementIsVisible(profileCompletionPageObjects.work_company_textfield);
            profileCompletionPageObjects.work_company_textfield.clear();
            profileCompletionPageObjects.work_company_textfield.sendKeys(companyname);
        } catch (Exception e) {
            Assert.fail("Could not perform action on \"Company Name\" textfield " + "&" + e.getMessage());
        }
    }


    /**
     * Click on show work experience on profile radio button
     *
     * @param strings
     * @autor Kirthana SS
     */
    public void clickOnShowWorkExperienceOnProfileRadioButton(String... strings) {
        boolean isshowWorkExpeerinceHere = Boolean.valueOf(strings[1].toLowerCase());
        if (isshowWorkExpeerinceHere == true) {
            ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " :: Click on show work experience  radio button ");
            try {

                genericfunctions.waitTillTheElementIsVisible(profileCompletionPageObjects.work_show_on_profile_radioprofile);
                profileCompletionPageObjects.work_show_on_profile_radioprofile.click();
            } catch (Exception e) {
                Assert.fail("Could not perform action on \"Show work experience on profile \" radio button " + "&" + e.getMessage());
            }
        }
    }


    /**
     * Click on working here radio button
     *
     * @param strings
     * @autor Kirthana SS
     */
    public void clickOnCurrentlyWorkingHereRadioButton(String... strings) {
        boolean isCurrentlyWorkingHere = Boolean.valueOf(strings[1].toLowerCase());
        if (isCurrentlyWorkingHere == true) {
            ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " :: Click on Currently working here radio button ");
            try {

                genericfunctions.waitTillTheElementIsVisible(profileCompletionPageObjects.work_currently_working_here_radiobutton);
                profileCompletionPageObjects.work_currently_working_here_radiobutton.click();
            } catch (Exception e) {
                Assert.fail("Could not perform action on \"Currently working here \" radio button " + "&" + e.getMessage());
            }
        }
    }


    /**
     * Enter Work Location
     *
     * @param strings
     * @autor Kirthana SS
     */
    public void enterWorkLocation(String... strings) {
        String workLocation = strings[1];
        ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " :: Enter work location as </b>\"" + workLocation + "\"</b>");
        try {
            genericfunctions.waitTillTheElementIsVisible(profileCompletionPageObjects.work_location_textfield);
            profileCompletionPageObjects.work_location_textfield.clear();
            profileCompletionPageObjects.work_location_textfield.sendKeys(workLocation);
        } catch (Exception e) {
            Assert.fail("Could not perform action on \"Work Location \" textfield " + "&" + e.getMessage());
        }
    }


    /**
     * Enter Work Designation
     *
     * @param strings
     * @autor Kirthana SS
     */
    public void enterDesignation(String... strings) {
        String designation = strings[1];
        ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " :: Enter designation as </b>\"" + designation + "\"</b>");
        try {
            genericfunctions.waitTillTheElementIsVisible(profileCompletionPageObjects.work_designation_textfield);
            profileCompletionPageObjects.work_designation_textfield.clear();
            profileCompletionPageObjects.work_designation_textfield.sendKeys(designation);
        } catch (Exception e) {
            Assert.fail("Could not perform action on \"Designation \" textfield " + "&" + e.getMessage());
        }
    }

    /**
     * Click on added work experience block edit icon
     *
     * @param strings
     * @autor Kirthana SS
     */
    public void clickOnAddedWorkExperienceEditIcon(String... strings) {

        ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " :: Click on added work experience edit icon");
        try
        {

            action = new Actions(DriverManager.getDriver());
            action.moveToElement(profileCompletionPageObjects.created_work_block).moveToElement(profileCompletionPageObjects.work_update_edit_icon).click().build().perform();
        } catch (Exception e) {
            Assert.fail("Could not perform action on \"Added Work experience edit\" icon in About section " + "&" + e.getMessage());
        }
    }


    /**
     * Click on added work experience block delete icon
     *
     * @param strings
     * @autor Kirthana SS
     */
    public void clickOnAddedWorkDetailsBlockDeleteIcon(String... strings) {

        ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " :: Click on added work experience delete icon");
        try {

            action = new Actions(DriverManager.getDriver());
            action.moveToElement(profileCompletionPageObjects.created_work_block).moveToElement(profileCompletionPageObjects.work_remove_image).click().build().perform();
        } catch (Exception e) {
            Assert.fail("Could not perform action on \"Added Work experience delete  \" icon in About section " + "&" + e.getMessage());
        }
    }


    /**
     * Click on added work experience block
     *
     * @param strings
     * @autor Kirthana SS
     */
    public void clickOnAddedWorkExperinceBlock(String... strings) {

        ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " :: Click on added work experience block");
        try {
            genericfunctions.waitTillTheElementIsVisible(profileCompletionPageObjects.created_work_block);
            action = new Actions(DriverManager.getDriver());
            action.moveToElement(profileCompletionPageObjects.created_work_block).click().build().perform();

        } catch (Exception e) {
            Assert.fail("Could not perform action on \"Added Work experience  \" block in About section " + "&" + e.getMessage());
        }
    }


    /**
     * Click on  about section save button
     *
     * @param strings
     * @autor Kirthana SS
     */
    public void clickOnAboutSectionSaveButton(String... strings) {

        ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " :: Click on About section save button");
        try {
            genericfunctions.waitTillTheElementIsVisible(profileCompletionPageObjects.about_component_save_button);
            profileCompletionPageObjects.about_component_save_button.click();
        } catch (Exception e) {
            Assert.fail("Could not perform action on \"Save Changes \" button in About section " + "&" + e.getMessage());
        }
    }


    /**
     * Enter Weight in kg
     *
     * @param strings
     * @autor Kirthana SS
     */
    public void enterWeightInKG(String... strings) {
        String wightInKg = strings[1].trim();
        ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " :: Enter Weight in kg  as <b>\"" + wightInKg + "\"</b>");
        try {
            genericfunctions.waitTillTheElementIsVisible(profileCompletionPageObjects.about_component_weight);
            profileCompletionPageObjects.about_component_weight.clear();
            profileCompletionPageObjects.about_component_weight.sendKeys(wightInKg);
        } catch (Exception e) {
            Assert.fail("Could not perform action on \"Weight \" textfield " + "&" + e.getMessage());
        }
    }


    /**
     * Enter Height in cm
     *
     * @param strings
     * @autor Kirthana SS
     */
    public void enterHeightInCM(String... strings) {
        String heightInCM = strings[1].trim();
        ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " :: Enter Height in cm  as <b>\"" + heightInCM + "\"</b>");
        try {
            genericfunctions.waitTillTheElementIsVisible(profileCompletionPageObjects.about_component_height);
            profileCompletionPageObjects.about_component_height.clear();
            profileCompletionPageObjects.about_component_height.sendKeys(heightInCM);
        } catch (Exception e) {
            Assert.fail("Could not perform action on \"Height \" textfield " + "&" + e.getMessage());
        }
    }


    /**
     * Enter languages known
     *
     * @param strings
     * @autor Kirthana SS
     */
    public void enterLanguagesKnown(String... strings) {
        String languagesKnown = strings[1].trim();
        ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " :: Enter language know  as <b>\"" + languagesKnown + "\"</b>");
        try {
            genericfunctions.waitTillTheElementIsVisible(profileCompletionPageObjects.languages_known_textfield);
            profileCompletionPageObjects.languages_known_textfield.sendKeys(languagesKnown);
            action = new Actions(DriverManager.getDriver());
            action.sendKeys(Keys.ENTER).build().perform();
        } catch (Exception e) {
            Assert.fail("Could not perform action on \"Languages known \" textfield " + "&" + e.getMessage());
        }

    }


    /**
     * Handle Date picker
     * <p>
     * Enter DOB
     *
     * @param strings
     * @autor Kirthana SS
     */
    public void enterDOB(String... strings) {
        String DOB = strings[1].trim();
        ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " :: Enter DOB  as <b>\"" + DOB + "\"</b>");
        try {
            genericfunctions.waitTillTheElementIsVisible(profileCompletionPageObjects.dob_textfield);
            profileCompletionPageObjects.dob_textfield.clear();
            profileCompletionPageObjects.dob_textfield.sendKeys(DOB);

        } catch (Exception e) {
            Assert.fail("Could not perform action on \"Date of birth \" textfield " + "&" + e.getMessage());
        }
    }


    /**
     * Select Gender dropdown
     *
     * @param strings
     * @autor Kirthana SS
     */
    public void selectGender(String... strings) {
        String gender = strings[1].trim();
        ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " :: Select gender as <b>\"" + gender + "\"</b>");
        try {
            genericfunctions.waitTillTheElementIsVisible(profileCompletionPageObjects.about_component_gender_dropdown);
            dropdownOption = new Select(profileCompletionPageObjects.about_component_gender_dropdown);
            dropdownOption.selectByValue(gender);
        } catch (Exception e) {
            Assert.fail("Could not perform action on \"Gender \" dropdown " + "&" + e.getMessage());
        }
    }


    /**
     * Enter description
     *
     * @param strings
     * @autor Kirthana SS
     */
    public void enterValueOfDescription(String... strings) {
        String description = strings[1];
        ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " :: Enter value of Description as <b>\"" + description + "\"</b>");
        try {
            genericfunctions.waitTillTheElementIsVisible(profileCompletionPageObjects.about_description_textfield);
            profileCompletionPageObjects.about_description_textfield.clear();
            profileCompletionPageObjects.about_description_textfield.sendKeys(description);
        } catch (Exception e) {
            Assert.fail("Could not perform action on \"Description \" textfield " + "&" + e.getMessage());
        }
    }

    /**
     * Enter value on full name
     *
     * @param strings
     * @autor Kirthana SS
     */
    public void enterValueOfFullName(String... strings) {
        String fullName = strings[1];


        ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " :: Enter value of full name as <b>\n" + fullName + "\n</b>");
        try {
            genericfunctions.waitTillTheElementIsVisible(profileCompletionPageObjects.general_fullname_textfield);
            profileCompletionPageObjects.general_fullname_textfield.sendKeys(fullName);
        } catch (Exception e) {
            Assert.fail("Could not perform action on \"Full name \" textfield " + "&" + e.getMessage());
        }
    }


    /**
     * click on  skills  tag
     *
     * @param strings
     * @autor Kirthana SS
     */
    public void enterSkillsTag(String... strings) {

        String enterSkills = strings[1].toUpperCase();
        ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " :: Enter skills tag");
        try {
            genericfunctions.waitTillTheElementIsVisible(profileCompletionPageObjects.add_skill_textfield);

            profileCompletionPageObjects.add_skill_textfield.sendKeys(enterSkills);
            action.sendKeys(Keys.ENTER).build().perform();

        } catch (Exception e) {
            Assert.fail("Could not perform action on \"add skills tag\" textfield " + "&" + e.getMessage());
        }
    }


    /**
     * enter skills  tag
     *
     * @param strings
     * @autor Kirthana SS
     */
    public void selectSkillsFromSuggestion(String... strings) {
        String enterSkills = strings[1].toUpperCase();
        ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " :: Select <b>\n" + enterSkills + "\n</b> skill from suggestion list ");

        try {
            genericfunctions.waitTillTheElementIsVisible(profileCompletionPageObjects.skills_tag_suggestion.get(0));
            List<WebElement> suggestionlistoptions = profileCompletionPageObjects.skills_tag_suggestion;

            for (int k = 0; k <= (suggestionlistoptions).size() - 1; k++) {
                String actualSuggestionoptions = suggestionlistoptions.get(k).getText().trim();

                if (actualSuggestionoptions.equals(enterSkills.trim())) {
                    suggestionlistoptions.get(k).click();

                    break;
                }

            }
        } catch (Exception e) {
            Assert.fail("Could not perform action on \"Skills tag\" suggestion box  " + "&" + e.getMessage());
        }
    }


    /**
     * click on general info tab
     *
     * @param strings
     * @autor Kirthana SS
     */
    public void clickOnGenralInfoTab(String... strings) {
        ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " :: Click on general info tab");
        try {
            genericfunctions.waitTillTheElementIsVisible(profileCompletionPageObjects.general_info_tab);
            profileCompletionPageObjects.general_info_tab.click();
        } catch (Exception e) {
            Assert.fail("Could not perform action on \"General Info \"tab" + "&" + e.getMessage());
        }
    }


    /**
     * click on save general info
     *
     * @param strings
     * @autor Kirthana SS
     */
    public void clickOnGeneralInfoSaveChangesButton(String... strings) {
        ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " :: Click on general info save changes button");
        try {
            genericfunctions.waitTillTheElementIsVisible(profileCompletionPageObjects.general_savechanges_button);
            genericfunctions.scrollToElement(profileCompletionPageObjects.general_savechanges_button);
            action.moveToElement(profileCompletionPageObjects.general_savechanges_button).doubleClick(profileCompletionPageObjects.general_savechanges_button).build().perform();

        } catch (Exception e) {
            Assert.fail("Could not perform action on \"General Info save changes  \" button" + "&" + e.getMessage());
        }
    }


    /**
     * click on contact info tab
     *
     * @param strings
     * @autor Kirthana SS
     */
    public void clickOnCantactTab(String... strings) {
        ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " :: Click on contact info tab");
        try {
            genericfunctions.waitTillTheElementIsVisible(profileCompletionPageObjects.profile_edit_contact_tab);
            profileCompletionPageObjects.profile_edit_contact_tab.click();
        } catch (Exception e) {
            Assert.fail("Could not perform action on \"Contact Info \"tab" + "&" + e.getMessage());
        }
    }

    /**
     * click on Work info tab
     *
     * @param strings
     * @autor Kirthana SS
     */
    public void clickOnWorkTab(String... strings) {
        ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " :: Click on Work info tab");
        try {
            genericfunctions.waitTillTheElementIsVisible(profileCompletionPageObjects.profile_edit_work_tab);
            profileCompletionPageObjects.profile_edit_work_tab.click();
        } catch (Exception e) {
            Assert.fail("Could not perform action on \"Work Info \"tab" + "&" + e.getMessage());
        }
    }


    /**
     * click on add Work experience button
     *
     * @param strings
     * @autor Kirthana SS
     */
    public void clickOnAddWorkExperienceButton(String... strings) {
        ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " :: Click on Add Work experience button");
        try {
            genericfunctions.waitTillTheElementIsVisible(profileCompletionPageObjects.work_add_work_experience_button);
            profileCompletionPageObjects.work_add_work_experience_button.click();
        } catch (Exception e) {
            Assert.fail("Could not perform action on \"Add Work Experience \" button" + "&" + e.getMessage());
        }
    }


    /**
     * click on add education button
     *
     * @param strings
     * @autor Kirthana SS
     */
    public void clickOnAddEducationButton(String... strings) {
        ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " :: Click on Add education button");
        try {
            genericfunctions.waitTillTheElementIsVisible(profileCompletionPageObjects.add_education_button);
            profileCompletionPageObjects.add_education_button.click();
        } catch (Exception e) {
            Assert.fail("Could not perform action on \"Add Education \" button" + "&" + e.getMessage());
        }
    }


    /**
     * click on education tab
     *
     * @param strings
     * @autor Kirthana SS
     */
    public void clickOnEducationTab(String... strings) {
        ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " :: Click on education tab");
        try {
            genericfunctions.waitTillTheElementIsVisible(profileCompletionPageObjects.profile_edit_education_tab);
            profileCompletionPageObjects.profile_edit_education_tab.click();
        } catch (Exception e) {
            Assert.fail("Could not perform action on \"Education \" tab" + "&" + e.getMessage());
        }
    }


    /**
     * Click on added Award experience block delete icon
     *
     * @param strings
     * @autor Kirthana SS
     */
    public void clickOnAddedAwardDetailsBlockDeleteIcon(String... strings) {

        ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " :: Click on added award experience delete icon");
        try {
            genericfunctions.waitTillTheElementIsVisible(profileCompletionPageObjects.created_award_title);
            action = new Actions(DriverManager.getDriver());
            action.clickAndHold(profileCompletionPageObjects.created_award_title).moveToElement(profileCompletionPageObjects.awards_remove_image).click().build().perform();
        } catch (Throwable e) {
            Assert.fail("Could not perform action on \"Added Award details delete  \" icon in About section " + "&" + e.getMessage());
        }
    }



    /**
     * Click on added Award experience block delete icon
     *
     * @param strings
     * @autor Kirthana SS
     */
    public void clickOnAddededucationDetailsBlockDeleteIcon(String... strings) {

        ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " :: Click on added education experience delete icon");
        try {
            genericfunctions.waitTillTheElementIsVisible(profileCompletionPageObjects.created_education_details);
            action = new Actions(DriverManager.getDriver());
            action.clickAndHold(profileCompletionPageObjects.created_education_details).moveToElement(profileCompletionPageObjects.education_remove_image).doubleClick(profileCompletionPageObjects.education_remove_image).build().perform();
        } catch (Throwable e) {
            Assert.fail("Could not perform action on Education \"remove\" icon " + "&" + e.getMessage());
        }
    }

    /**
     *  enter  of study
     *
     * @param
     * @autor Kirthana
     */

    public void enterStudy(String ...strings) {
        String study=strings[1];
        ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " :: Enter study");
        try {
            genericfunctions.waitTillTheElementIsVisible(profileCompletionPageObjects.eduaction_field_of_study_textfield);
            profileCompletionPageObjects.eduaction_field_of_study_textfield.sendKeys(study);

        } catch (Exception e) {
            Assert.fail("Could not perform action on \"field of Study\" textField in add education section" + "&" + e.getMessage());
                 }
    }


    /**
     *  enter University
     *
     * @param
     * @autor Kirthana
     */

    public void enterEducationUniversity(String ...strings) {
        String university=strings[1];
        ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " :: Enter education university");
        try {
            genericfunctions.waitTillTheElementIsVisible(profileCompletionPageObjects.eduaction_university_name_textfield);
            profileCompletionPageObjects.eduaction_university_name_textfield.sendKeys(university);

        } catch (Exception e) {
            Assert.fail("Could not perform action on Education \"University\" textField in add education section" + "&" + e.getMessage());
        }
    }

    /**
     *  enter Location
     *
     * @param
     * @autor Kirthana
     */

    public void enterEducationLocation(String ...strings) {
        String location=strings[1];
        ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " :: Enter education location");
        try {
            genericfunctions.waitTillTheElementIsVisible(profileCompletionPageObjects.education_location_textfield);
            profileCompletionPageObjects.education_location_textfield.sendKeys(location);

        } catch (Exception e) {
            Assert.fail("Could not perform action on Education\"location\" textField in add education section" + "&" + e.getMessage());
        }
    }


    /**
     * Click on  Currently studying here radio button
     *
     * @param
     * @autor Kirthana
     */

    public void clickOnCurrentStudyHereRadioButton(String ...strings) {
        boolean isCurrentlyStudingHere = Boolean.valueOf(strings[1].toLowerCase());
        if (isCurrentlyStudingHere == true)
        {
            ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " :: Click on  Currently studying here radio button");
            try {
                genericfunctions.waitTillTheElementIsVisible(profileCompletionPageObjects.education_currently_studing_radio_button);
                profileCompletionPageObjects.education_currently_studing_radio_button.click();

            } catch (Exception e) {
                Assert.fail("Could not perform action on \"Currently studying here\" radio button in add education section" + "&" + e.getMessage());
            }
        }
    }


    /**
     * Select education start month dropdown
     *
     * @param strings
     * @autor Kirthana SS
     */
    public void selectEducationStartMonthDropdown(String... strings) {
        String educationStartMonth = GenericFunctions.getShortMonthFromNumber(Integer.valueOf(strings[1].trim())).toUpperCase();
        ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " :: Select education start month as <b>\"" + educationStartMonth + "\"</b>");
        try {
            genericfunctions.waitTillTheElementIsVisible(profileCompletionPageObjects.education_start_month_selector_dropdown);
            dropdownOption = new Select(profileCompletionPageObjects.education_start_month_selector_dropdown);
            dropdownOption.selectByValue(educationStartMonth);
        } catch (Exception e) {
            Assert.fail("Could not perform action on Education \"Start Month \" dropdown " + "&" + e.getMessage());
        }
    }


    /**
     * Select education end month dropdown
     *
     * @param strings
     * @autor Kirthana SS
     */
    public void selectEducationEndMonthDropdown(String... strings) {
        String educationEndMonth = GenericFunctions.getShortMonthFromNumber(Integer.valueOf(strings[1].trim())).toUpperCase();
        ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " :: Select education end month as <b>\"" + educationEndMonth + "\"</b>");
        try {
            genericfunctions.waitTillTheElementIsVisible(profileCompletionPageObjects.education_end_month_selector_dropdown);
            dropdownOption = new Select(profileCompletionPageObjects.education_end_month_selector_dropdown);
            dropdownOption.selectByValue(educationEndMonth);
        } catch (Exception e) {
            Assert.fail("Could not perform action on Education \"End Month \" dropdown " + "&" + e.getMessage());
        }
    }



    /**
     * Select education start year dropdown
     *
     * @param strings
     * @autor Kirthana SS
     */
    public void selectEducationStartYearDropdown(String... strings) {
        String educationStartYear = strings[1].trim();
        ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " :: Select education start year as <b>\"" + educationStartYear + "\"</b>");
        try {
            genericfunctions.waitTillTheElementIsVisible(profileCompletionPageObjects.education_start_year_selector_dropdown);
            dropdownOption = new Select(profileCompletionPageObjects.education_start_year_selector_dropdown);
            dropdownOption.selectByValue(educationStartYear);
        } catch (Exception e) {
            Assert.fail("Could not perform action on Education \"Start Year \" dropdown " + "&" + e.getMessage());
        }
    }


    /**
     * Select education end year dropdown
     *
     * @param strings
     * @autor Kirthana SS
     */
    public void selectEducationEndYearDropdown(String... strings) {
        String educationEndYear = strings[1].trim();
        ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " :: Select education end year as <b>\"" + educationEndYear + "\"</b>");
        try {
            genericfunctions.waitTillTheElementIsVisible(profileCompletionPageObjects.education_end_year_selector_dropdown);
            dropdownOption = new Select(profileCompletionPageObjects.education_end_year_selector_dropdown);
            dropdownOption.selectByValue(educationEndYear);
        } catch (Exception e) {
            Assert.fail("Could not perform action on Education \"End Year \" dropdown " + "&" + e.getMessage());
        }
    }

    /**
     * Click on  show education  on profile radio button
     *
     * @param strings
     * @autor Kirthana SS
     */
    public void clickOnShowEducationOnProfileRadioButton(String... strings) {
        boolean isShowEducationOnProfile = Boolean.valueOf(strings[1].toLowerCase());
        if (isShowEducationOnProfile == true) {
            ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " :: Click on show education on profile radio button");
            try {
                genericfunctions.waitTillTheElementIsVisible(profileCompletionPageObjects.education_show_on_profile_radiobutton);
                profileCompletionPageObjects.education_show_on_profile_radiobutton.click();

            } catch (Exception e) {
                Assert.fail("Could not perform action on \"Show education on profile \" radio button " + "&" + e.getMessage());
            }
        }
    }


    /**
     * Click on education updation save  button
     *
     * @param strings
     * @autor Kirthana SS
     */
    public void clickOnEducationUpdationSaveButton(String... strings) {
        String workstartmontherrormessage = strings[1];

            ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " :: Click on education updation save button");
            try {
                genericfunctions.waitTillTheElementIsVisible(profileCompletionPageObjects.education_update_button);
                profileCompletionPageObjects.education_update_button.click();

                Assert.fail("<b>\"" + workstartmontherrormessage + "\"</b> error message should be displayed " + "&" + " Defect Link - <a href='https://taiga.vnaad.com/project/admin-one-page-spotlight/issue/1034' target='_blank'>https://taiga.vnaad.com/project/admin-one-page-spotlight/issue/1034</a>  ");


            } catch (Exception e) {
                Assert.fail("Could not perform action on Education\"updation save \" button " + "&" + e.getMessage());
            }

    }



    /////////////////////////// Page Verifications ////////////////////////////////////////////////////////

    /**
     * Verify contents of general info tab
     *
     * @param strings
     * @autor Kirthana
     */
    public void verifyContentsOfGeneralInfoTab(String... strings) {

        ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " :: User navigates to General info tab or not on clicking \"General Info\" tab with following assertions :");

        verifyDisplayOfFullNameTextField();
        verifyDisplayOfSkillsTagContainer();
        verifyDisplayOfSaveChangesButton();
        verifyDisplayOfCancelButton();
    }


    /**
     * Verify contents of About info tab
     *
     * @param strings
     * @autor Kirthana
     */
    public void verifyContentsOfAboutTab(String... strings) {

        ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " :: User navigates to About info tab or not on clicking \"Edit\" icon of about section  with following assertions :");

        verifyDisplayOfDescriptionTextField();
        verifyDisplayOfGenderDropdown();
        verifyDisplayOfDOBTextField();
        verifyDisplayOfLanguagesKnownTextField();
        verifyDisplayOfHeightTextField();
        verifyDisplayOfWeightTextField();
        verifyDisplayOfHeightWeightVisiblePrivacyButton();
        verifyDisplayOfAboutInfoEditSaveChangesButton();
        verifyDisplayOfAboutInfoEditCancelButton();
    }


    /**
     * Verify contents of Contact info tab
     *
     * @param strings
     * @autor Kirthana
     */
    public void verifyContentsOfContactTab(String... strings) {

        ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " :: User navigates to Contact info page or not on clicking \"Contact\" tab of   with following assertions :");

        verifyDisplayOfContactLocationTextField();
        verifyDisplayOfLocationVisiblePrivacyButton();
        verifyDisplayOfEmailTextField();
        verifyDisplayOfEmailVisiblePrivacyButton();
        verifyDisplayOfPhoneNumberTextField();
        verifyDisplayOfPhoneNumbervisiblePrivacyButton();
        verifyDisplayOfWebsiteTextField();
        verifyDisplayOfWebsitevisiblePrivacyButton();
        verifyDisplayOfCantactSaveButton();
        verifyDisplayOfContactEditCancelButton();

    }

    /**
     * Verify contents of Add work experience page
     *
     * @param strings
     * @autor Kirthana
     */
    public void verifyContentsOfAddWorkExeperienceSection(String... strings) {

        ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " :: User navigates to Add work experience page or not on clicking \"Add Work Experience\" button  with following assertions :");

        verifyDisplayOfDesignationTextfield();
        verifyDisplayOfCompanyNameTextfield();
        verifyDisplayOfWorkLocationTextfield();
        verifyDisplayOfCurrentWorkRadioButton();
        verifyDisplayOfWorkStartMonthDropDown();
        verifyDisplayOfWorkStartYearDropDown();
        verifyDisplayOfWorkEndMonthDropDown();
        verifyDisplayOfWorkEndYearDropDown();
        verifyDisplayOfShowWorkExperienceRadioButton();
        verifyDisplayOfWorkEditSaveButton();
        verifyDisplayOfWorkEditCancelButton();


    }

    /**
     * Verify contents of Add work education page
     *
     * @param strings
     * @autor Kirthana
     */
    public void verifyContentsOfAddEducationSection(String... strings) {

        ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " :: User navigates to Add education page or not on clicking \"Add Education\" button  with following assertions :");

        verifyDisplayOfStudyTextfield();
        verifyDisplayOfUniversityTextfield();
        verifyDisplayOfEducationLocationTextfield();
        verifyDisplayOfCurrentStudyRadioButton();
        verifyDisplayOfEducationStartMonthDropDown();
        verifyDisplayOfEducationStartYearDropDown();
        verifyDisplayOfEducationEndMonthDropDown();
        verifyDisplayOfEducationEndYearDropDown();
        verifyDisplayOfShowEducationOnProfileRadioButton();
        verifyDisplayOfEducationSaveChangesButton();
        verifyDisplayOfEducationCancelButton();

    }


    /**
     * @param
     * @autor Kirthana
     * Verify  contents of Add Award section
     *
     */
    public void verifyContentsOfAddAwardSection(String ...strings)
    {

        ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " :: User navigates to Add Award section or not on clicking \"Add Award\" button  with following assertions :");

        verifyDisplayOfAwardTitleTextField();
        verifyDisplayOfAwardIssuerTextField();
        verifyDisplayOfAwardLocationTextField();
        verifyDisplayOfAwardIssuerMonthDropdown();
        verifyDisplayOfAwardIssuerYearDropdown();
        verifyDisplayOfAwardShowOnProfileRadioButton();
        verifyDisplayOfAwardUpdationSaveButton();


    }


    /**
     * Verify display of  Award title textfield
     *
     * @param
     * @autor Kirthana
     */

    public void verifyDisplayOfAwardTitleTextField() {
        try {
            genericfunctions.waitTillTheElementIsVisible(profileCompletionPageObjects.award_titile_textfield);
            Assert.assertTrue(profileCompletionPageObjects.award_titile_textfield.isDisplayed());
            ExtentTestManager.getTest().log(LogStatus.PASS, " \"Award title\" textfield is displaying");
        } catch (Exception e) {
            Assert.fail("Expected :: Education \"Award title\" textfield should be displayed ; Actual :: Education \"Award title\" textfield is not displayed" + "&" + e.getMessage() + "");
        }
    }

    /**
     * Verify display of  Award issuer textfield
     *
     * @param
     * @autor Kirthana
     */

    public void verifyDisplayOfAwardIssuerTextField() {
        try {
            genericfunctions.waitTillTheElementIsVisible(profileCompletionPageObjects.awards_issuer_textfield);
            Assert.assertTrue(profileCompletionPageObjects.awards_issuer_textfield.isDisplayed());
            ExtentTestManager.getTest().log(LogStatus.PASS, " \"Award issuer\" textfield is displaying");
        } catch (Exception e) {
            Assert.fail("Expected :: Education \"Award issuer\" textfield should be displayed ; Actual :: Education \"Award issuer\" textfield is not displayed" + "&" + e.getMessage() + "");
        }
    }


    /**
     * Verify display of  Award location textfield
     *
     * @param
     * @autor Kirthana
     */

    public void verifyDisplayOfAwardLocationTextField() {
        try {
            genericfunctions.waitTillTheElementIsVisible(profileCompletionPageObjects.awards_location_textfield);
            Assert.assertTrue(profileCompletionPageObjects.awards_location_textfield.isDisplayed());
            ExtentTestManager.getTest().log(LogStatus.PASS, " \"Award location\" textfield is displaying");
        } catch (Exception e) {
            Assert.fail("Expected :: Education \"Award location\" textfield should be displayed ; Actual :: Education \"Award location\" textfield is not displayed" + "&" + e.getMessage() + "");
        }
    }


    /**
     * Verify display of  Award issuer month dropdown
     *
     * @param
     * @autor Kirthana
     */

    public void verifyDisplayOfAwardIssuerMonthDropdown() {
        try {
            genericfunctions.waitTillTheElementIsVisible(profileCompletionPageObjects.awards_issued_month_selector_dropdown);
            Assert.assertTrue(profileCompletionPageObjects.awards_issued_month_selector_dropdown.isDisplayed());
            ExtentTestManager.getTest().log(LogStatus.PASS, " \"Award issuer month\" dropdown is displaying");
        } catch (Exception e) {
            Assert.fail("Expected :: Education \"Award issuer month\" dropdown should be displayed ; Actual :: Education \"Award issuer month \" dropdown is not displayed" + "&" + e.getMessage() + "");
        }
    }


    /**
     * Verify display of  Award issuer year dropdown
     *
     * @param
     * @autor Kirthana
     */

    public void verifyDisplayOfAwardIssuerYearDropdown() {
        try {
            genericfunctions.waitTillTheElementIsVisible(profileCompletionPageObjects.awards_issued_year_selector_dropdown);
            Assert.assertTrue(profileCompletionPageObjects.awards_issued_year_selector_dropdown.isDisplayed());
            ExtentTestManager.getTest().log(LogStatus.PASS, " \"Award issuer year\" dropdown is displaying");
        } catch (Exception e) {
            Assert.fail("Expected :: Education \"Award issuer year\" dropdown should be displayed ; Actual :: Education \"Award issuer  year\" dropdown is not displayed" + "&" + e.getMessage() + "");
        }
    }


    /**
     * Verify display of  Award show on profile radio button
     *
     * @param
     * @autor Kirthana
     */

    public void verifyDisplayOfAwardShowOnProfileRadioButton() {
        try {
            genericfunctions.waitTillTheElementIsVisible(profileCompletionPageObjects.awards_show_on_profile_radiobutton);
            Assert.assertTrue(profileCompletionPageObjects.awards_show_on_profile_radiobutton.isDisplayed());
            ExtentTestManager.getTest().log(LogStatus.PASS, " \"Award show on profile\" radiobutton is displaying");
        } catch (Exception e) {
            Assert.fail("Expected :: Education \"Award show on profile\" radiobutton should be displayed ; Actual :: Education \"Award show on profile\" radiobutton is not displayed" + "&" + e.getMessage() + "");
        }
    }

    /**
     * Verify display of  Award updation save button
     *
     * @param
     * @autor Kirthana
     */

    public void verifyDisplayOfAwardUpdationSaveButton() {
        try {
            genericfunctions.waitTillTheElementIsVisible(profileCompletionPageObjects.awards_update_button);
            Assert.assertTrue(profileCompletionPageObjects.awards_update_button.isDisplayed());
            ExtentTestManager.getTest().log(LogStatus.PASS, " \"Award Updation Save\" button is displaying");
        } catch (Exception e) {
            Assert.fail("Expected :: Education \"Award Updation Save\" button should be displayed ; Actual :: Education \"Award Updation Save\" button is not displayed" + "&" + e.getMessage() + "");
        }
    }


    /**
     * Verify display of  education cancel button
     *
     * @param
     * @autor Kirthana
     */

    public void verifyDisplayOfEducationCancelButton() {
        try {
            genericfunctions.waitTillTheElementIsVisible(profileCompletionPageObjects.eduaction_cancel_button);
            Assert.assertTrue(profileCompletionPageObjects.eduaction_cancel_button.isDisplayed());
            ExtentTestManager.getTest().log(LogStatus.PASS, " Education \"Cancel\" button is displaying");
        } catch (Exception e) {
            Assert.fail("Expected :: Education \"Cancel\" button should be displayed ; Actual :: Education \"Cancel\" button is not displayed" + "&" + e.getMessage() + "");
        }
    }

    /**
     * Verify display of  education update button
     *
     * @param
     * @autor Kirthana
     */

    public void verifyDisplayOfEducationSaveChangesButton() {
        try {
            genericfunctions.waitTillTheElementIsVisible(profileCompletionPageObjects.education_update_button);
            Assert.assertTrue(profileCompletionPageObjects.education_update_button.isDisplayed());
            ExtentTestManager.getTest().log(LogStatus.PASS, " Education \"Save changes\" button is displaying");
        } catch (Exception e) {
            Assert.fail("Expected :: Education \"Save changes\" button should be displayed ; Actual :: Education \"Save changes\" button is not displayed" + "&" + e.getMessage() + "");
        }
    }


    /**
     * Verify display of show education on profile radio button
     *
     * @param
     * @autor Kirthana
     */

    public void verifyDisplayOfShowEducationOnProfileRadioButton() {
        try {
            genericfunctions.waitTillTheElementIsVisible(profileCompletionPageObjects.education_show_on_profile_radiobutton);
            Assert.assertTrue(profileCompletionPageObjects.education_show_on_profile_radiobutton.isDisplayed());
            ExtentTestManager.getTest().log(LogStatus.PASS, " \"Show Education On Profile\" radiobutton is displaying");
        } catch (Exception e) {
            Assert.fail("Expected :: \"Show Education On Profile\" radiobutton should be displayed ; Actual :: \"Show Education On Profile\" radiobutton is not displayed" + "&" + e.getMessage() + "");
        }
    }


    /**
     * Verify display of education End year dropdown
     *
     * @param
     * @autor Kirthana
     */

    public void verifyDisplayOfEducationEndYearDropDown() {
        try {
            genericfunctions.waitTillTheElementIsVisible(profileCompletionPageObjects.education_end_year_selector_dropdown);
            Assert.assertTrue(profileCompletionPageObjects.education_end_year_selector_dropdown.isDisplayed());
            ExtentTestManager.getTest().log(LogStatus.PASS, "Education \"End Year\" dropdown is displaying");
        } catch (Exception e) {
            Assert.fail("Expected :: Education \"End Year\" dropdown should be displayed ; Actual :: Education \"End Year\" dropdown is not displayed" + "&" + e.getMessage() + "");
        }
    }


    /**
     * Verify display of education End month dropdown
     *
     * @param
     * @autor Kirthana
     */

    public void verifyDisplayOfEducationEndMonthDropDown() {
        try {
            genericfunctions.waitTillTheElementIsVisible(profileCompletionPageObjects.education_end_month_selector_dropdown);
            Assert.assertTrue(profileCompletionPageObjects.education_end_month_selector_dropdown.isDisplayed());
            ExtentTestManager.getTest().log(LogStatus.PASS, "Education \"End Month\" dropdown is displaying");
        } catch (Exception e) {
            Assert.fail("Expected :: Education \"End Month\" dropdown should be displayed ; Actual :: Education \"End Month\" dropdown is not displayed" + "&" + e.getMessage() + "");
        }
    }


    /**
     * Verify display of education start year dropdown
     *
     * @param
     * @autor Kirthana
     */

    public void verifyDisplayOfEducationStartYearDropDown() {
        try {
            genericfunctions.waitTillTheElementIsVisible(profileCompletionPageObjects.education_start_year_selector_dropdown);
            Assert.assertTrue(profileCompletionPageObjects.education_start_year_selector_dropdown.isDisplayed());
            ExtentTestManager.getTest().log(LogStatus.PASS, "Education \"Start Year\" dropdown is displaying");
        } catch (Exception e) {
            Assert.fail("Expected :: Education \"Start Year\" dropdown should be displayed ; Actual :: Education \"Start Year\" dropdown is not displayed" + "&" + e.getMessage() + "");
        }
    }

    /**
     * Verify display of education start month dropdown
     *
     * @param
     * @autor Kirthana
     */

    public void verifyDisplayOfEducationStartMonthDropDown() {
        try {
            genericfunctions.waitTillTheElementIsVisible(profileCompletionPageObjects.education_start_month_selector_dropdown);
            Assert.assertTrue(profileCompletionPageObjects.education_start_month_selector_dropdown.isDisplayed());
            ExtentTestManager.getTest().log(LogStatus.PASS, "Education \"Start Month\" dropdown is displaying");
        } catch (Exception e) {
            Assert.fail("Expected :: Education \"Start Month\" dropdown should be displayed ; Actual :: Education \"Start Month\" dropdown is not displayed" + "&" + e.getMessage() + "");
        }
    }

    /**
     * Verify display of current study radio button
     *
     * @param
     * @autor Kirthana
     */

    public void verifyDisplayOfCurrentStudyRadioButton() {
        try {
            genericfunctions.waitTillTheElementIsVisible(profileCompletionPageObjects.education_currently_studing_radio_button);
            Assert.assertTrue(profileCompletionPageObjects.education_currently_studing_radio_button.isDisplayed());
            ExtentTestManager.getTest().log(LogStatus.PASS, "Education \"Current Studying\" Radio button is displaying");
        } catch (Exception e) {
            Assert.fail("Expected :: Education \"Current Studying\" Radio button should be displayed ; Actual :: Education \"Current Studying\" Radio button is not displayed" + "&" + e.getMessage() + "");
        }
    }


    /**
     * Verify display of education location textfield
     *
     * @param
     * @autor Kirthana
     */

    public void verifyDisplayOfEducationLocationTextfield() {
        try {
            genericfunctions.waitTillTheElementIsVisible(profileCompletionPageObjects.education_location_textfield);
            Assert.assertTrue(profileCompletionPageObjects.education_location_textfield.isDisplayed());
            ExtentTestManager.getTest().log(LogStatus.PASS, "Education \"Location\" textField is displaying");
        } catch (Exception e) {
            Assert.fail("Expected :: Education \"Location\" textField should be displayed ; Actual :: Education \"Location\" textField is not displayed" + "&" + e.getMessage() + "");
        }
    }


    /**
     * Verify display of university textfield
     *
     * @param
     * @autor Kirthana
     */

    public void verifyDisplayOfUniversityTextfield() {
        try {
            genericfunctions.waitTillTheElementIsVisible(profileCompletionPageObjects.eduaction_university_name_textfield);
            Assert.assertTrue(profileCompletionPageObjects.eduaction_university_name_textfield.isDisplayed());
            ExtentTestManager.getTest().log(LogStatus.PASS, "\"University\" textField is displaying");
        } catch (Exception e) {
            Assert.fail("Expected ::\"University\" textField should be displayed ; Actual :: \"University\" textField is not displayed" + "&" + e.getMessage() + "");
        }
    }


    /**
     * Verify display of study textfield
     *
     * @param
     * @autor Kirthana
     */

    public void verifyDisplayOfStudyTextfield() {
        try {
            genericfunctions.waitTillTheElementIsVisible(profileCompletionPageObjects.eduaction_field_of_study_textfield);
            Assert.assertTrue(profileCompletionPageObjects.eduaction_field_of_study_textfield.isDisplayed());
            ExtentTestManager.getTest().log(LogStatus.PASS, "\"Study\" textField is displaying");
        } catch (Exception e) {
            Assert.fail("Expected ::\"Study\" textField should be displayed ; Actual :: \"Study\" textField is not displayed" + "&" + e.getMessage() + "");
        }
    }


    /**
     * Verify display of Designation textfield
     *
     * @param
     * @autor Kirthana
     */

    public void verifyDisplayOfDesignationTextfield() {
        try {
            genericfunctions.waitTillTheElementIsVisible(profileCompletionPageObjects.work_designation_textfield);
            Assert.assertTrue(profileCompletionPageObjects.work_designation_textfield.isDisplayed());
            ExtentTestManager.getTest().log(LogStatus.PASS, "Work \"Designation\" textField is displaying");
        } catch (Exception e) {
            Assert.fail("Expected :: Work \"Designation\" textField should be displayed ; Actual :: Work \"Designation\" textField is not displayed" + "&" + e.getMessage() + "");
        }
    }

    /**
     * Verify display of company's name textfield
     *
     * @param
     * @autor Kirthana
     */

    public void verifyDisplayOfCompanyNameTextfield() {
        try {
            genericfunctions.waitTillTheElementIsVisible(profileCompletionPageObjects.work_company_textfield);
            Assert.assertTrue(profileCompletionPageObjects.work_company_textfield.isDisplayed());
            ExtentTestManager.getTest().log(LogStatus.PASS, "Work \"Company name\" textField is displaying");
        } catch (Exception e) {
            Assert.fail("Expected :: Work \"Company name\" textField textField should be displayed ; Actual :: Work \"Company name\" textField textField is not displayed" + "&" + e.getMessage() + "");
        }
    }


    /**
     * Verify display of work location textfield
     *
     * @param
     * @autor Kirthana
     */

    public void verifyDisplayOfWorkLocationTextfield() {
        try {
            genericfunctions.waitTillTheElementIsVisible(profileCompletionPageObjects.work_location_textfield);
            Assert.assertTrue(profileCompletionPageObjects.work_location_textfield.isDisplayed());
            ExtentTestManager.getTest().log(LogStatus.PASS, "Work \"Location\" textField is displaying");
        } catch (Exception e) {
            Assert.fail("Expected :: Work \"Location\" textField should be displayed ; Actual :: Work \"Location\" textField is not displayed" + "&" + e.getMessage() + "");
        }
    }


    /**
     * Verify display of current work radioButton
     *
     * @param
     * @autor Kirthana
     */

    public void verifyDisplayOfCurrentWorkRadioButton() {
        try {
            genericfunctions.waitTillTheElementIsVisible(profileCompletionPageObjects.work_currently_working_here_radiobutton);
            Assert.assertTrue(profileCompletionPageObjects.work_currently_working_here_radiobutton.isDisplayed());
            ExtentTestManager.getTest().log(LogStatus.PASS, " \"Currently Working\" radio button is displaying");
        } catch (Exception e) {
            Assert.fail("Expected :: \"Currently Working\" radio button should be  displayed ; Actual ::  \"Currently Working\" radio button is displaying " + "&" + e.getMessage() + "");
        }
    }

    /**
     * Verify display of work start month dropdown
     *
     * @param
     * @autor Kirthana
     */

    public void verifyDisplayOfWorkStartMonthDropDown() {
        try {
            genericfunctions.waitTillTheElementIsVisible(profileCompletionPageObjects.work_start_month_selector_dropdown);
            Assert.assertTrue(profileCompletionPageObjects.work_start_month_selector_dropdown.isDisplayed());
            ExtentTestManager.getTest().log(LogStatus.PASS, " Work \"Start Month\" dropdown is displaying");
        } catch (Exception e) {
            Assert.fail("Expected :: Work \"Start Month\" dropdown should be  displayed ; Actual ::  Work \"Start Month\" dropdown is displaying " + "&" + e.getMessage() + "");
        }
    }

    /**
     * Verify display of work start year dropdown
     *
     * @param
     * @autor Kirthana
     */

    public void verifyDisplayOfWorkStartYearDropDown() {
        try {
            genericfunctions.waitTillTheElementIsVisible(profileCompletionPageObjects.work_start_year_selector_dropdown);
            Assert.assertTrue(profileCompletionPageObjects.work_start_year_selector_dropdown.isDisplayed());
            ExtentTestManager.getTest().log(LogStatus.PASS, " Work \"Start Year\" dropdown is displaying");
        } catch (Exception e) {
            Assert.fail("Expected :: Work \"Start Year\" dropdown should be  displayed ; Actual ::  Work \"Start Year\" dropdown is displaying " + "&" + e.getMessage() + "");
        }
    }

    /**
     * Verify display of work end month dropdown
     *
     * @param
     * @autor Kirthana
     */

    public void verifyDisplayOfWorkEndMonthDropDown() {
        try {
            genericfunctions.waitTillTheElementIsVisible(profileCompletionPageObjects.work_end_month_selector_dropdown);
            Assert.assertTrue(profileCompletionPageObjects.work_end_month_selector_dropdown.isDisplayed());
            ExtentTestManager.getTest().log(LogStatus.PASS, " Work \"End Month\" dropdown is displaying");
        } catch (Exception e) {
            Assert.fail("Expected :: Work \"End Month\" dropdown should be  displayed ; Actual ::  Work \"End Month\" dropdown is displaying " + "&" + e.getMessage() + "");
        }
    }

    /**
     * Verify display of work end year dropdown
     *
     * @param
     * @autor Kirthana
     */

    public void verifyDisplayOfWorkEndYearDropDown() {
        try {
            genericfunctions.waitTillTheElementIsVisible(profileCompletionPageObjects.work_end_year_selector_dropdown);
            Assert.assertTrue(profileCompletionPageObjects.work_end_year_selector_dropdown.isDisplayed());
            ExtentTestManager.getTest().log(LogStatus.PASS, " Work \"End Year\" dropdown is displaying");
        } catch (Exception e) {
            Assert.fail("Expected :: Work \"End Year\" dropdown should be  displayed ; Actual ::  Work \"End Year\" dropdown is displaying " + "&" + e.getMessage() + "");
        }
    }

    /**
     * Verify display of show work experience radioButton
     *
     * @param
     * @autor Kirthana
     */

    public void verifyDisplayOfShowWorkExperienceRadioButton() {
        try {
            genericfunctions.waitTillTheElementIsVisible(profileCompletionPageObjects.work_show_on_profile_radioprofile);
            Assert.assertTrue(profileCompletionPageObjects.work_show_on_profile_radioprofile.isDisplayed());
            ExtentTestManager.getTest().log(LogStatus.PASS, " \"Show Work experience\" radio button is displaying");
        } catch (Exception e) {
            Assert.fail("Expected :: \"Show Work experience\" radio button should be  displayed ; Actual ::  \"Show Work experience\" radio button is displaying " + "&" + e.getMessage() + "");
        }
    }


    /**
     * Verify display of  work  edit save changes button
     *
     * @param
     * @autor Kirthana
     */

    public void verifyDisplayOfWorkEditSaveButton() {
        try {
            genericfunctions.waitTillTheElementIsVisible(profileCompletionPageObjects.work_save_button);
            Assert.assertTrue(profileCompletionPageObjects.work_save_button.isDisplayed());
            ExtentTestManager.getTest().log(LogStatus.PASS, " Work \"Save Changes\" button is displaying");
        } catch (Exception e) {
            Assert.fail("Expected :: Work \"Save Changes\"  button should be  displayed ; Actual :: Work \"Save Changes\"  button is displaying " + "&" + e.getMessage() + "");
        }
    }

    /**
     * Verify display of  work  edit cancel  button
     *
     * @param
     * @autor Kirthana
     */

    public void verifyDisplayOfWorkEditCancelButton() {
        try {
            genericfunctions.waitTillTheElementIsVisible(profileCompletionPageObjects.work_cancel_button);
            Assert.assertTrue(profileCompletionPageObjects.work_cancel_button.isDisplayed());
            ExtentTestManager.getTest().log(LogStatus.PASS, " Work \"Cancel\" button is displaying");
        } catch (Exception e) {
            Assert.fail("Expected :: Work \"Cancel\"  button should be  displayed ; Actual :: Work \"Cancel\"  button is displaying " + "&" + e.getMessage() + "");
        }
    }


    /**
     * Verify display of Location textfield
     *
     * @param
     * @autor Kirthana
     */

    public void verifyDisplayOfContactEditCancelButton() {
        try {
            genericfunctions.waitTillTheElementIsVisible(profileCompletionPageObjects.contact_edit_cancel_button);
            Assert.assertTrue(profileCompletionPageObjects.contact_edit_cancel_button.isDisplayed());
            ExtentTestManager.getTest().log(LogStatus.PASS, "Contact edit \"Cancel\" button is displaying");
        } catch (Exception e) {
            Assert.fail("Expected :: Contact edit \"Cancel\" button should be displayed ; Actual :: Contact edit \"Cancel\" button is not displayed" + "&" + e.getMessage() + "");
        }
    }


    /**
     * Verify display of Contact Location textfield
     *
     * @param
     * @autor Kirthana
     */

    public void verifyDisplayOfContactLocationTextField() {
        try {
            genericfunctions.waitTillTheElementIsVisible(profileCompletionPageObjects.profile_edit_contact_location_textfield);
            Assert.assertTrue(profileCompletionPageObjects.profile_edit_contact_location_textfield.isDisplayed());
            ExtentTestManager.getTest().log(LogStatus.PASS, " Contact \"Location\" textField is displaying");
        } catch (Exception e) {
            Assert.fail("Expected ::Contact \"Location\" textField should be displayed ; Actual :: Contact Location\" textField is not displayed" + "&" + e.getMessage() + "");
        }
    }


    /**
     * Verify display of Location visible privacy button
     *
     * @param
     * @autor Kirthana
     */

    public void verifyDisplayOfLocationVisiblePrivacyButton() {
        try {
            genericfunctions.waitTillTheElementIsVisible(profileCompletionPageObjects.profile_edit_contact_location_visible_privacy_button);
            Assert.assertTrue(profileCompletionPageObjects.profile_edit_contact_location_visible_privacy_button.isDisplayed());
            ExtentTestManager.getTest().log(LogStatus.PASS, "Contact \"Location visible privacy\" button is displaying");
        } catch (Exception e) {
            Assert.fail("Expected :: Contact \"Location visible privacy\" button should be displayed ; Actual :: Contact \"Location visible privacy\" button is not displayed" + "&" + e.getMessage() + "");
        }
    }


    /**
     * Verify display of Email textfield
     *
     * @param
     * @autor Kirthana
     */

    public void verifyDisplayOfEmailTextField() {
        try {
            genericfunctions.waitTillTheElementIsVisible(profileCompletionPageObjects.profile_edit_contact_email_textfield);
            Assert.assertTrue(profileCompletionPageObjects.profile_edit_contact_email_textfield.isDisplayed());
            ExtentTestManager.getTest().log(LogStatus.PASS, "\"Email\" textfield is displaying");
        } catch (Exception e) {
            Assert.fail("Expected :: \"Email\" textfield should be displayed ; Actual :: \"Email\" textfield is not displayed" + "&" + e.getMessage() + "");
        }
    }

    /**
     * Verify display of Email visible privacy button
     *
     * @param
     * @autor Kirthana
     */

    public void verifyDisplayOfEmailVisiblePrivacyButton() {
        try {
            genericfunctions.waitTillTheElementIsVisible(profileCompletionPageObjects.profile_edit_contact_email_privacy_button);
            Assert.assertTrue(profileCompletionPageObjects.profile_edit_contact_email_privacy_button.isDisplayed());
            ExtentTestManager.getTest().log(LogStatus.PASS, "\"Email visible privacy\" button is displaying");
        } catch (Exception e) {
            Assert.fail("Expected :: \"Email visible privacy\" button should be displayed ; Actual :: \"Email visible privacy\" button is not displayed" + "&" + e.getMessage() + "");
        }
    }

    /**
     * Verify display of Phone Number textfield
     *
     * @param
     * @autor Kirthana
     */

    public void verifyDisplayOfPhoneNumberTextField() {
        try {
            genericfunctions.waitTillTheElementIsVisible(profileCompletionPageObjects.profile_edit_contact_phone_textfield);
            Assert.assertTrue(profileCompletionPageObjects.profile_edit_contact_phone_textfield.isDisplayed());
            ExtentTestManager.getTest().log(LogStatus.PASS, "\"Phone Number\" textfield is displaying");
        } catch (Exception e) {
            Assert.fail("Expected :: \"Phone Number\" textfield should be displayed ; Actual :: \"Phone Number\" textfield is not displayed" + "&" + e.getMessage() + "");
        }
    }

    /**
     * Verify display of Phone Number visible privacy button
     *
     * @param
     * @autor Kirthana
     */

    public void verifyDisplayOfPhoneNumbervisiblePrivacyButton() {
        try {
            genericfunctions.waitTillTheElementIsVisible(profileCompletionPageObjects.profile_edit_contact_phone_privacy_button);
            Assert.assertTrue(profileCompletionPageObjects.profile_edit_contact_phone_privacy_button.isDisplayed());
            ExtentTestManager.getTest().log(LogStatus.PASS, "\"Phone Number visible privacy\" button is displaying");
        } catch (Exception e) {
            Assert.fail("Expected :: \"Phone Number visible privacy\" button should be displayed ; Actual :: \"Phone Number visible privacy\" button is not displayed" + "&" + e.getMessage() + "");
        }
    }

    /**
     * Verify display of website textfield
     *
     * @param
     * @autor Kirthana
     */

    public void verifyDisplayOfWebsiteTextField() {
        try {
            genericfunctions.waitTillTheElementIsVisible(profileCompletionPageObjects.profile_edit_contact_website_textfield);
            Assert.assertTrue(profileCompletionPageObjects.profile_edit_contact_website_textfield.isDisplayed());
            ExtentTestManager.getTest().log(LogStatus.PASS, "\"Website\" textfield is displaying");
        } catch (Exception e) {
            Assert.fail("Expected :: \"Website\" textfield should be displayed ; Actual :: \"Website\" textfield is not displayed" + "&" + e.getMessage() + "");
        }
    }

    /**
     * Verify display of Phone Number visible privacy button
     *
     * @param
     * @autor Kirthana
     */

    public void verifyDisplayOfWebsitevisiblePrivacyButton() {
        try {
            genericfunctions.waitTillTheElementIsVisible(profileCompletionPageObjects.profile_edit_contact_website_visible_privacy_button);
            Assert.assertTrue(profileCompletionPageObjects.profile_edit_contact_website_visible_privacy_button.isDisplayed());
            ExtentTestManager.getTest().log(LogStatus.PASS, "\"Website visible privacy\" button is displaying");
        } catch (Exception e) {
            Assert.fail("Expected :: \"Website visible privacy\" button should be displayed ; Actual :: \"Website visible privacy\" button is not displayed" + "&" + e.getMessage() + "");
        }
    }


    /**
     * Verify display of description textfield
     *
     * @param
     * @autor Kirthana
     */

    public void verifyDisplayOfDescriptionTextField() {
        try {
            genericfunctions.waitTillTheElementIsVisible(profileCompletionPageObjects.about_description_textfield);
            Assert.assertTrue(profileCompletionPageObjects.about_description_textfield.isDisplayed());
            ExtentTestManager.getTest().log(LogStatus.PASS, "\"Description\" textfield is displaying");
        } catch (Exception e) {
            Assert.fail("Expected :: \"Description\" textfield should be displayed ; Actual :: \"Description\" textfield is not displayed" + "&" + e.getMessage() + "");
        }
    }

    /**
     * Verify display of contact save button
     *
     * @param
     * @autor Kirthana
     */

    public void verifyDisplayOfCantactSaveButton() {
        try {
            genericfunctions.waitTillTheElementIsVisible(profileCompletionPageObjects.contact_save_chnages_button);
            Assert.assertTrue(profileCompletionPageObjects.contact_save_chnages_button.isDisplayed());
            ExtentTestManager.getTest().log(LogStatus.PASS, "Contact \" Save \" button is displaying");
        } catch (Exception e) {
            Assert.fail("Expected :: Contact \"Save\" button should be displayed ; Actual :: Contact \"Save\" button is not displayed" + "&" + e.getMessage() + "");
        }
    }

    /**
     * Verify display of gender dropdown
     *
     * @param
     * @autor Kirthana
     */

    public void verifyDisplayOfGenderDropdown() {
        try {
            genericfunctions.waitTillTheElementIsVisible(profileCompletionPageObjects.about_component_gender_dropdown);
            Assert.assertTrue(profileCompletionPageObjects.about_component_gender_dropdown.isDisplayed());
            ExtentTestManager.getTest().log(LogStatus.PASS, "\"Gender\" dropdown is displaying");
        } catch (Exception e) {
            Assert.fail("Expected :: \"Gender\" dropdown should be displayed ; Actual :: \"Gender\" dropdown is not displayed" + "&" + e.getMessage() + "");
        }
    }


    /**
     * Verify display of DOB textfield
     *
     * @param
     * @autor Kirthana
     */

    public void verifyDisplayOfDOBTextField() {
        try {
            genericfunctions.waitTillTheElementIsVisible(profileCompletionPageObjects.dob_textfield);
            Assert.assertTrue(profileCompletionPageObjects.dob_textfield.isDisplayed());
            ExtentTestManager.getTest().log(LogStatus.PASS, "\"DOB\" textfield is displaying");
        } catch (Exception e) {
            Assert.fail("Expected :: \"DOB\" textfield should be displayed ; Actual :: \"DOB\" textfield is not displayed" + "&" + e.getMessage() + "");
        }
    }

    /**
     * Verify display of Languages textfield
     *
     * @param
     * @autor Kirthana
     */

    public void verifyDisplayOfLanguagesKnownTextField() {
        try {
            genericfunctions.waitTillTheElementIsVisible(profileCompletionPageObjects.languages_known_textfield);
            Assert.assertTrue(profileCompletionPageObjects.languages_known_textfield.isDisplayed());
            ExtentTestManager.getTest().log(LogStatus.PASS, "\"Languages known\" textfield is displaying");
        } catch (Exception e) {
            Assert.fail("Expected :: \"Languages known\" textfield should be displayed ; Actual :: \"Languages known\" textfield is not displayed" + "&" + e.getMessage() + "");
        }
    }

    /**
     * Verify display of height textfield
     *
     * @param
     * @autor Kirthana
     */

    public void verifyDisplayOfHeightTextField() {
        try {
            genericfunctions.waitTillTheElementIsVisible(profileCompletionPageObjects.about_component_height);
            Assert.assertTrue(profileCompletionPageObjects.about_component_height.isDisplayed());
            ExtentTestManager.getTest().log(LogStatus.PASS, "\"Height\" textfield is displaying");
        } catch (Throwable e) {
            Assert.fail("Expected :: \"Height\" textfield should be displayed ; Actual :: \"Height\" textfield is not displayed" + "&" + e.getMessage() + "");
        }
    }

    /**
     * Verify display of weight textfield
     *
     * @param
     * @autor Kirthana
     */

    public void verifyDisplayOfWeightTextField() {
        try {
            genericfunctions.waitTillTheElementIsVisible(profileCompletionPageObjects.about_component_weight);
            Assert.assertTrue(profileCompletionPageObjects.about_component_weight.isDisplayed());
            ExtentTestManager.getTest().log(LogStatus.PASS, "\"Weight\" textfield is displaying");
        } catch (Throwable e) {
            Assert.fail("Expected :: \"Weight\" textfield should be displayed ; Actual :: \"Weight\" textfield is not displayed" + "&" + e.getMessage() + "");
        }
    }


    /**
     * Verify display of height-weight visible privacy button
     *
     * @param
     * @autor Kirthana
     */

    public void verifyDisplayOfHeightWeightVisiblePrivacyButton() {
        try {
            genericfunctions.waitTillTheElementIsVisible(profileCompletionPageObjects.height_weight_privacy_edit_button);
            Assert.assertTrue(profileCompletionPageObjects.height_weight_privacy_edit_button.isDisplayed());
            ExtentTestManager.getTest().log(LogStatus.PASS, "\"Height-Weight Visible Privacy\" button is displaying");
        } catch (Throwable e) {
            Assert.fail("Expected :: \"Height-Weight Visible Privacy\" button should be displayed ; Actual :: \"Height-Weight Visible Privacy\" button is not displayed" + "&" + e.getMessage() + "");
        }
    }


    /**
     * Verify display of save changes button
     *
     * @param
     * @autor Kirthana
     */

    public void verifyDisplayOfAboutInfoEditSaveChangesButton() {
        try {
            genericfunctions.waitTillTheElementIsVisible(profileCompletionPageObjects.about_component_save_button);
            Assert.assertTrue(profileCompletionPageObjects.about_component_save_button.isDisplayed());
            ExtentTestManager.getTest().log(LogStatus.PASS, " About tab \"Save Changes\" button is displaying");
        } catch (Throwable e) {
            Assert.fail("Expected :: About tab \"Save Changes\" button should be displayed ; Actual :: About tab \"Save Changes\" is not displayed" + "&" + e.getMessage() + "");
        }
    }

    /**
     * Verify display of about tab cancel button
     *
     * @param
     * @autor Kirthana
     */

    public void verifyDisplayOfAboutInfoEditCancelButton() {
        try {
            genericfunctions.waitTillTheElementIsVisible(profileCompletionPageObjects.about_component_cancel_button);
            Assert.assertTrue(profileCompletionPageObjects.about_component_cancel_button.isDisplayed());
            ExtentTestManager.getTest().log(LogStatus.PASS, " About tab \"Cancel\" button is displaying");
        } catch (Throwable e) {
            Assert.fail("Expected :: About tab \"Cancel\" button should be displayed ; Actual :: About tab \"Cancel\" is not displayed" + "&" + e.getMessage() + "");
        }
    }


    /**
     * @param
     * @autor Kirthana
     */

    public void verifyDisplayOfFullNameTextField() {
        try {
            genericfunctions.waitTillTheElementIsVisible(profileCompletionPageObjects.general_fullname_textfield);
            Assert.assertTrue(profileCompletionPageObjects.general_fullname_textfield.isDisplayed());
            ExtentTestManager.getTest().log(LogStatus.PASS, "\"FullName\" textfield is displaying");
        } catch (Throwable e) {
            Assert.fail("Expected :: \"FullName\" textfield should be displayed ; Actual :: \"FullName\" textfield is not displayed" + "&" + e.getMessage() + "");
        }
    }

    /**
     * @param
     * @autor Kirthana
     */
    public void verifyDisplayOfSkillsTagContainer() {
        try {
            genericfunctions.waitTillTheElementIsVisible(profileCompletionPageObjects.skills_tag_container);
            Assert.assertTrue(profileCompletionPageObjects.skills_tag_container.isDisplayed());
            ExtentTestManager.getTest().log(LogStatus.PASS, "\"Skills Tag\" container is displaying");
        } catch (Throwable e) {
            Assert.fail("Expected :: \"Skills Tag\" container should be displayed ; Actual :: \"Skills Tag\" container is not displayed" + "&" + e.getMessage() + "");
        }
    }

    /**
     * @param
     * @autor Kirthana
     */
    public void verifyDisplayOfSaveChangesButton() {
        try {
            genericfunctions.waitTillTheElementIsVisible(profileCompletionPageObjects.general_savechanges_button);
            Assert.assertTrue(profileCompletionPageObjects.general_savechanges_button.isDisplayed());
            ExtentTestManager.getTest().log(LogStatus.PASS, "\"Save Changes\" button is displaying");
        } catch (Throwable e) {
            Assert.fail("Expected :: \"Save Changes\" button should be displayed ; Actual :: \"Save Changes\" button is not displayed" + "&" + e.getMessage() + "");
        }
    }

    /**
     * @param
     * @autor Kirthana
     */
    public void verifyDisplayOfCancelButton() {
        try {
            genericfunctions.waitTillTheElementIsVisible(profileCompletionPageObjects.general_cancel_button);
            Assert.assertTrue(profileCompletionPageObjects.general_cancel_button.isDisplayed());
            ExtentTestManager.getTest().log(LogStatus.PASS, "\"Cancel\" button is displaying");
        } catch (Throwable e) {
            Assert.fail("Expected :: \"Cancel\" button should be displayed ; Actual :: \"Cancel\" button is not displayed" + "&" + e.getMessage() + "");
        }
    }


    /**
     * @param
     * @autor Kirthana
     * Verify  25% default profile completion percentage (25%) added for Registration
     */
    public void verifyDefaultPercentageOfProfileCompletion(String ...strings) {

        ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " :: Default Profile completion  <b>\""+strings[1]+"\"</b> gets added or not  on registration with following assertion:");
        String expectedProfileCompletionPercentage=strings[1];
        String actualProfileCompletionPercentage=strings[2];

        try {
            Assert.assertTrue(actualProfileCompletionPercentage.equals(expectedProfileCompletionPercentage));
            ExtentTestManager.getTest().log(LogStatus.PASS, "Default Profile completion percentage added is <b>\""+actualProfileCompletionPercentage+"\"</b>");
        } catch (Throwable e) {
            Assert.fail("Expected :: Default Profile completion percentage should be <b>\""+expectedProfileCompletionPercentage+"\" </b> ; Actual :: Default Profile completion percentage is <b>\""+actualProfileCompletionPercentage+"\" </b>"+ "&" + e.getMessage() + "");
        }
    }


    /**
     * @param
     * @autor Kirthana
     */
    public void verifyPercentageIncrementedOnAddingDescription(String ...strings) {

        ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " :: Profile completion  <b>\""+strings[1]+"\"</b> gets incremented or not  by <b>\"5%\"</b> after adding description with following assertion:");
        Integer beforeUpdatingprofile=Integer.valueOf(strings[1].split("\\%")[0]);

        String  expectedProfileCompletionPercentage= (beforeUpdatingprofile + 5) +"%";
        String actualProfileCompletionPercentage=strings[2];

        try {
            Assert.assertTrue(actualProfileCompletionPercentage.equals(expectedProfileCompletionPercentage));
            ExtentTestManager.getTest().log(LogStatus.PASS, "Profile completion percentage incremented by  <b>\"5%\"</b>");
        } catch (Throwable e) {
            Assert.fail("Expected :: Profile completion percentage should be <b>\""+expectedProfileCompletionPercentage+"\" </b> ; Actual :: Profile completion percentage is <b>\""+actualProfileCompletionPercentage+"\" </b>"+ "&" + e.getMessage() + "");
        }
    }


    /**
     * @param
     * @autor Kirthana
     *  Verify profile completion percentage incremented by 5% on adding language known
     */
    public void verifyPercentageIncrementedOnAddingLanguage(String ...strings) {

        ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " :: Profile completion  <b>\""+strings[1]+"\"</b> gets incremented or not by <b>\"5%\"</b> after adding language known with following assertion:");
        Integer beforeUpdatingprofile=Integer.valueOf(strings[1].split("\\%")[0]);

        String  expectedProfileCompletionPercentage= (beforeUpdatingprofile + 5) +"%";
        String actualProfileCompletionPercentage=strings[2];

        try {
            Assert.assertTrue(actualProfileCompletionPercentage.equals(expectedProfileCompletionPercentage));
            ExtentTestManager.getTest().log(LogStatus.PASS, "Profile completion percentage incremented by  <b>\"5%\"</b>");
        } catch (Throwable e) {
            Assert.fail("Expected :: Profile completion percentage should be  <b>\""+expectedProfileCompletionPercentage+"\" </b> ; Actual :: Profile completion percentage is  <b>\""+actualProfileCompletionPercentage+"\" </b>"+ "&" + e.getMessage() + "");
        }
    }


    /**
     * @param
     * @autor Kirthana
     * Verify profile completion percentage incremented by 5% on adding contact location
     *
     */
    public void verifyPercentageIncrementedOnAddingContactLocation(String ...strings) {

        ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " :: Profile completion  <b>\""+strings[1]+"\"</b> gets incremented or not  by <b>\"5%\"</b> after adding contact location with following assertion:");
        Integer beforeUpdatingprofile=Integer.valueOf(strings[1].split("\\%")[0]);

        String  expectedProfileCompletionPercentage= (beforeUpdatingprofile + 5) +"%";
        String actualProfileCompletionPercentage=strings[2];

        try {
            Assert.assertTrue(actualProfileCompletionPercentage.equals(expectedProfileCompletionPercentage));
            ExtentTestManager.getTest().log(LogStatus.PASS, "Profile completion percentage incremented by  <b>\"5%\"</b>");
        } catch (Throwable e) {
            Assert.fail("Expected :: Profile completion percentage should be <b>\""+expectedProfileCompletionPercentage+"\" </b> ; Actual :: Profile completion percentage is <b>\""+actualProfileCompletionPercentage+"\" </b>"+ "&" + e.getMessage() + "");
        }
    }


    /**
     * @param
     * @autor Kirthana
     * Verify  profile completion percentage incremented by 15% on adding Work experience
     *
     */
    public void verifyPercentageIncrementedOnAddingWorkExperierince(String ...strings) {

        ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " :: Profile completion  <b>\""+strings[1]+"\"</b> gets incremented or not by <b>\"15%\"</b> after adding work experience with following assertion:");
        Integer beforeUpdatingprofile=Integer.valueOf(strings[1].split("\\%")[0]);

        String  expectedProfileCompletionPercentage= (beforeUpdatingprofile + 15) +"%";
        String actualProfileCompletionPercentage=strings[2];

        try {
            Assert.assertTrue(actualProfileCompletionPercentage.equals(expectedProfileCompletionPercentage));
            ExtentTestManager.getTest().log(LogStatus.PASS, "Profile completion percentage incremented by  <b>\"15%\"</b>");
        } catch (Throwable e) {
            Assert.fail("Expected :: Profile completion percentage should be <b>\""+expectedProfileCompletionPercentage+"\" </b> ; Actual :: Profile completion percentage is <b>\""+actualProfileCompletionPercentage+"\" </b>"+ "&" + e.getMessage() + "");
        }
    }



    /**
     * @param
     * @autor Kirthana
     * Verify  profile completion percentage incremented by 15% on adding Skills in General info
     *
     */
    public void verifyPercentageIncrementedOnAddingSkills(String ...strings) {

        ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " :: Profile completion  <b>\""+strings[1]+"\"</b> gets incremented or not by <b>\"15%\"</b> after adding skills in general info section with following assertion:");
        Integer beforeUpdatingprofile=Integer.valueOf(strings[1].split("\\%")[0]);

        String  expectedProfileCompletionPercentage= (beforeUpdatingprofile + 15) +"%";
        String actualProfileCompletionPercentage=strings[2];

        try {
            Assert.assertTrue(actualProfileCompletionPercentage.equals(expectedProfileCompletionPercentage));
            ExtentTestManager.getTest().log(LogStatus.PASS, "Profile completion percentage incremented by  <b>\"15%\"</b>");
        } catch (Throwable e) {
            Assert.fail("Expected :: Profile completion percentage should be <b>\""+expectedProfileCompletionPercentage+"\" </b> ; Actual :: Profile completion percentage is <b>\""+actualProfileCompletionPercentage+"\" </b>"+ "&" + e.getMessage() + "");
        }
    }



    /**
     * @param
     * @autor Kirthana
     * Verify  profile completion percentage decremented by 15% on adding Work experience
     *
     */
    public void verifyPercentageDecrementedOnDeletingWorkExperierince(String ...strings) {

        ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " :: Profile completion  <b>\""+strings[1]+"\"</b> gets decremented or not by <b>\"15%\"</b> after deleting contact location with following assertion:");
        Integer beforeUpdatingprofile=Integer.valueOf(strings[1].split("\\%")[0]);

        String  expectedProfileCompletionPercentage= (beforeUpdatingprofile - 15) +"%";
        String actualProfileCompletionPercentage=strings[2];

        try {
            Assert.assertTrue(actualProfileCompletionPercentage.equals(expectedProfileCompletionPercentage));
            ExtentTestManager.getTest().log(LogStatus.PASS, "Profile completion percentage decremented by  <b>\"15%\"</b>");
        } catch (Throwable e) {
            Assert.fail("Expected :: Profile completion percentage should be <b>\""+expectedProfileCompletionPercentage+"\" </b> ; Actual :: Profile completion percentage is <b>\""+actualProfileCompletionPercentage+"\" </b>"+ "&" + e.getMessage() + "");
        }
    }


    /**
     * @param
     * @autor Kirthana
     */

    public void verifyDisplayOfConfirmationToastMessagePopup(String ...strings) {
        try {
            Assert.assertTrue(genericpageObjects.toast_message_popup.isDisplayed());
            ExtentTestManager.getTest().log(LogStatus.PASS, "Profile edited  \"Confirmation toast message\" popup is displaying");
        } catch (Throwable e) {
            Assert.fail("Expected :: Profile edited  \"Confirmation Toast Message\" popup should be displayed  ; Actual :: Profile edited  \"Confirmation toast message\" popup is not displaying"+ "&" + e.getMessage() + "");
        }
    }



    /**
     * @param
     * @autor Kirthana
     * Verify  profile completion percentage incremented by 5% on adding Award details
     *
     */
    public void verifyPercentageIncrementedOnAddingAwardDetails(String ...strings) {

        ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " :: Profile completion  <b>\""+strings[1]+"\"</b> gets incremented or not by <b>\"5%\"</b> after adding award details with following assertion:");
        Integer beforeUpdatingprofile=Integer.valueOf(strings[1].split("\\%")[0]);

        String  expectedProfileCompletionPercentage= (beforeUpdatingprofile + 5) +"%";
        String actualProfileCompletionPercentage=strings[2];

        try {
            Assert.assertTrue(actualProfileCompletionPercentage.equals(expectedProfileCompletionPercentage));
            ExtentTestManager.getTest().log(LogStatus.PASS, "Profile completion percentage incremented by  <b>\"5%\"</b>");
        } catch (Throwable e) {
            Assert.fail("Expected :: Profile completion percentage should be <b>\""+expectedProfileCompletionPercentage+"\" </b> ; Actual :: Profile completion percentage is <b>\""+actualProfileCompletionPercentage+"\" </b>"+ "&" + e.getMessage() + "");
        }
    }


    /**
     * @param
     * @autor Kirthana
     * Verify  profile completion percentage decremented by 5% on adding Award details
     *
     */
    public void verifyPercentageDecrementedOnRemovingAwardDetails(String ...strings) {

        ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " :: Profile completion  <b>\""+strings[1]+"\"</b> gets decremented or not by <b>\"5%\"</b> after deleting award details with following assertion:");
        Integer beforeUpdatingprofile=Integer.valueOf(strings[1].split("\\%")[0]);

        String  expectedProfileCompletionPercentage= (beforeUpdatingprofile - 5) +"%";
        String actualProfileCompletionPercentage=strings[2];

        try {
            Assert.assertTrue(actualProfileCompletionPercentage.equals(expectedProfileCompletionPercentage));
            ExtentTestManager.getTest().log(LogStatus.PASS, "Profile completion percentage decremented by  <b>\"5%\"</b>");
        } catch (Throwable e) {
            Assert.fail("Expected :: Profile completion percentage should be <b>\""+expectedProfileCompletionPercentage+"\" </b> ; Actual :: Profile completion percentage is <b>\""+actualProfileCompletionPercentage+"\" </b>"+ "&" + e.getMessage() + "");
        }
    }


    /**
     * @param
     * @autor Kirthana
     * Verify  profile completion percentage incremented by 15% on adding Education details
     *
     */
    public void verifyPercentageIncrementedOnAddingEducationDetails(String ...strings) {

        ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " :: Profile completion  <b>\""+strings[1]+"\"</b> gets incremented or not by <b>\"15%\"</b> after adding education details with following assertion:");
        Integer beforeUpdatingprofile=Integer.valueOf(strings[1].split("\\%")[0]);

        String  expectedProfileCompletionPercentage= (beforeUpdatingprofile + 15) +"%";
        String actualProfileCompletionPercentage=strings[2];

        try {
            Assert.assertTrue(actualProfileCompletionPercentage.equals(expectedProfileCompletionPercentage));
            ExtentTestManager.getTest().log(LogStatus.PASS, "Profile completion percentage incremented by  <b>\"15%\"</b>");
        } catch (Throwable e) {
            Assert.fail("Expected :: Profile completion percentage should be <b>\""+expectedProfileCompletionPercentage+"\" </b> ; Actual :: Profile completion percentage is <b>\""+actualProfileCompletionPercentage+"\" </b>"+ "&" + e.getMessage() + "");
        }
    }

    /**
     * @param
     * @autor Kirthana
     * Verify  profile completion percentage decremented by 15% on adding Education details
     *
     */
    public void verifyPercentageDecrementedOnEducationDetails(String ...strings) {

        ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " :: Profile completion  <b>\""+strings[1]+"\"</b> gets decremented or not by <b>\"15%\"</b> after deleting education details with following assertion:");
        Integer beforeUpdatingprofile=Integer.valueOf(strings[1].split("\\%")[0]);

        String  expectedProfileCompletionPercentage= (beforeUpdatingprofile - 15) +"%";
        String actualProfileCompletionPercentage=strings[2];

        try {
            Assert.assertTrue(actualProfileCompletionPercentage.equals(expectedProfileCompletionPercentage));
            ExtentTestManager.getTest().log(LogStatus.PASS, "Profile completion percentage decremented by  <b>\"15%\"</b>");
        } catch (Throwable e) {
            Assert.fail("Expected :: Profile completion percentage should be <b>\""+expectedProfileCompletionPercentage+"\" </b> ; Actual :: Profile completion percentage is <b>\""+actualProfileCompletionPercentage+"\" </b>"+ "&" + e.getMessage() + "");
        }
    }


    /**
     *  Verify Banner Image
     *
     * @autor Kirthana SS
     * @param strings
     */
    public void verifyDisplayOfCoverImage(String ...strings)
    {
        ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " ::  Display of cover image or not after uploading with following assertions :");

        try {
            genericfunctions.waitTillTheElementIsVisible(profileCompletionPageObjects.cover_img);
            Assert.assertTrue(profileCompletionPageObjects.cover_img.isDisplayed());
            ExtentTestManager.getTest().log(LogStatus.PASS,  " Cover image is uploaded successfully");
        } catch (Exception e)
        {
            Assert.fail("Expected :: \"Cover \" image  should be displayed ; Actual :: \"Cover\" image is not displayed");
        }
    }



    /**
     *  Verify Display of following Cover icons on clicking edit cover image icon
     *
     * @autor Kirthana SS
     * @param strings
     */
    public void verifyDisplayOfCoverIcons(String ...strings)
    {
        ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " ::  Display of Cover icons or not on clicking \"edit cover image icon\"  with following assertions :");

        verifyDisplayOfDeleteCoverImageIcon();
        verifyDisplayOfSaveCoverImageIcon();
        verifyDisplayOfCoverImageRightArrowIcon();
        verifyDisplayOfCoverImageLeftArrowIcon();
        //verifyDisplayOfCoverAddImageIcon();
    }


    /**
     *  Verify display of delete banner image icon
     *
     * @autor Kirthana SS
     * @param strings
     */
    public void verifyDisplayOfDeleteCoverImageIcon(String ...strings)
    {
        try {
            genericfunctions.waitTillTheElementIsVisible(profileCompletionPageObjects.delete_cover_image_icon);
            Assert.assertTrue(profileCompletionPageObjects.delete_cover_image_icon.isDisplayed());
            ExtentTestManager.getTest().log(LogStatus.PASS,  " Cover image \"Delete\" icon is displayed");
        } catch (Exception e)
        {
            Assert.fail("Expected :: \"Delete \" cover image icon should be  displayed ; Actual :: \"Delete\" cover image icon is not displayed");
        }
    }


    /**
     *  Verify display of Save cover image icon
     *
     * @autor Kirthana SS
     * @param strings
     */
    public void verifyDisplayOfSaveCoverImageIcon(String ...strings)
    {
        try {
            genericfunctions.waitTillTheElementIsVisible(profileCompletionPageObjects.cover_image_save_icon);
            Assert.assertTrue(profileCompletionPageObjects.cover_image_save_icon.isDisplayed());
            ExtentTestManager.getTest().log(LogStatus.PASS,  " Cover image \"Save\" icon is displayed");
        } catch (Exception e)
        {
            Assert.fail("Expected :: \"Save \" cover image icon should be  displayed ; Actual :: \"Save\" cover image icon is not displayed");
        }
    }

    /**
     *  Verify display of  cover image right arrow  icon
     *
     * @autor Kirthana SS
     * @param strings
     */
    public void verifyDisplayOfCoverImageRightArrowIcon(String ...strings)
    {
        try {
            genericfunctions.waitTillTheElementIsVisible(profileCompletionPageObjects.cover_image_right_arrow_icon);
            Assert.assertTrue(profileCompletionPageObjects.cover_image_right_arrow_icon.isDisplayed());
            ExtentTestManager.getTest().log(LogStatus.PASS,  " Cover image \"Right Arrow\" icon is displayed");
        } catch (Exception e)
        {
            Assert.fail("Expected :: Cover image \"Right Arrow\" icon should be displayed ; Actual :: Cover image \"Right Arrow\" icon is not  displayed");
        }
    }


    /**
     *  Verify display of  banner image left arrow  icon
     *
     * @autor Kirthana SS
     * @param strings
     */
    public void verifyDisplayOfCoverImageLeftArrowIcon(String ...strings)
    {
        try {
            genericfunctions.waitTillTheElementIsVisible(profileCompletionPageObjects.cover_image_left_arrow_icon);
            Assert.assertTrue(profileCompletionPageObjects.cover_image_left_arrow_icon.isDisplayed());
            ExtentTestManager.getTest().log(LogStatus.PASS,  " Cover image \"Left Arrow\" icon is displayed");
        } catch (Exception e)
        {
            Assert.fail("Expected :: Cover image \"Left Arrow\" icon should be displayed ; Actual :: Cover image \"Left Arrow\" icon is not  displayed");
        }
    }


    /**
     *  Verify display of  banner add image icon
     *
     * @autor Kirthana SS
     * @param strings
     */
    public void verifyDisplayOfCoverAddImageIcon(String ...strings)
    {
        try {

            genericfunctions.waitWebDriver(5000);
            Assert.assertTrue(genericpageObjects.attachFile_button.isDisplayed());
            ExtentTestManager.getTest().log(LogStatus.PASS,  " Cover  \"Add\" image icon is displayed");
        } catch (Throwable e)
        {
            Assert.fail("Expected :: Cover  \"Add\" image icon should be displayed ; Actual :: Cover \"Add\" image icon is not  displayed" +"&"+ e.getMessage());
        }
    }


    /**
     * @autor click on right arrow button
     * @param strings
     */
    public void clickOnCoverImageRightArrowButton(String ...strings)
    {
        ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " :: Click on cover image \"Right Arrow\" button");
        try
        {
            genericfunctions.waitTillTheElementIsVisible(profileCompletionPageObjects.cover_image_right_arrow_icon);
            profileCompletionPageObjects.cover_image_right_arrow_icon.click();
        }
        catch(Exception e)
        {
            Assert.fail("Could not perform action on \"Cover Image Right Arrow \" button " +"&"+ e.getMessage());
        }
    }



    /**
     *  Verify cover Image is not displayed
     *
     * @autor Kirthana SS
     * @param strings
     */
    public void verifyNotDisplayOfCoverImage(String ...strings)
    {
        ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " :: Cover image is deleted or not with following assertions :");

        try {
            genericfunctions.waitTillElementToBeDisappearByLocator(By.xpath("//*[@class='opspot-banner-img m-banner--img-cover']"));
            genericfunctions.waitTillTheElementIsVisible(profileCompletionPageObjects.cover_img);
            Assert.assertTrue(profileCompletionPageObjects.cover_img.isDisplayed());
            Assert.fail("Expected :: \"Cover \" image  should not be displayed ; Actual :: \"Cover\" image is  displayed");
        } catch (Exception e)
        {
            ExtentTestManager.getTest().log(LogStatus.PASS,  " Cover image is deleted successfully");

        }
    }




}
   