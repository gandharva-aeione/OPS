package com.aeione.ops.pageactions;

import com.aeione.ops.generic.DriverManager;
import com.aeione.ops.generic.ExtentTestManager;
import com.aeione.ops.generic.GenericFunctions;
import com.aeione.ops.pageobjects.HomePageObjects;
import com.aeione.ops.pageobjects.ProfilePageObjects;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.io.IOException;
import java.util.Map;


/*
 * @author: Aishwarya
 * Description: Profile Page Actions
 * Date of Creation: 05-05-2020
 */
public class ProfilePageActions 
{
	GenericFunctions genericfunctions;
	ProfilePageObjects profilepageobject = new ProfilePageObjects();
	HomePageObjects homePageObjects = new HomePageObjects();
	Actions action;

	public ProfilePageActions() throws IOException
	{

		genericfunctions = new GenericFunctions(DriverManager.getDriver());
		PageFactory.initElements(DriverManager.getDriver(), this);
		PageFactory.initElements(DriverManager.getDriver(), profilepageobject);
		PageFactory.initElements(DriverManager.getDriver(), homePageObjects);
		action=new Actions(DriverManager.getDriver());
	}


	///////////////////////////////////////////// Page actions //////////////////////////////////////////////////////

	/*
	 * @author: Aishwarya
	 * Description: Verify display of View Profile option in Profile dropdown
	 * Created on : 05-05-2020
	 */
	public void clickOnViewProfileLink(String... strings) {
		ExtentTestManager.getTest().log(LogStatus.INFO, strings[0]+" :: Click on View Profile link");
		try 
		{
			genericfunctions.waitTillTheElementIsVisible(profilepageobject.viewProfile_Link);
			profilepageobject.viewProfile_Link.click();
		}
		catch(Throwable e)
		{
			Assert.fail("Could not perform action on \"view profile \"link" +"&"+ e.getMessage());
		}
	} 

	/*
	 * @author: Aishwarya
	 * Description:  Profile dropdown
	 * Created on : 05-05-2020
	 */

	public String getUserFullNameFromeProfileDropdown(String ...strings)
	{
		String full_Name="";
		try 
		{
			genericfunctions.waitTillTheElementIsVisible(profilepageobject.fullName_ProfileDropdown);
			full_Name= profilepageobject.fullName_ProfileDropdown.getText().trim();
		} 
		catch (Throwable e)
		{
			Assert.fail("Expected :: \"Full Name\" should be displayed in the Profile dropdown ; Actual :: \"Full Name\" is not displaying in the Profile dropdown"+"&"+e.getMessage()+"" );
		}
		return  full_Name;
	}


	/*
	 * @author: Aishwarya
	 * Description: Verify that portfolio link is clickable 
	 * Created on : 08-05-2020
	 */
	public void clickOnPortfolioButton(String... strings) {
		ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " :: Click on Portfolio button");
		try 
		{
			genericfunctions.waitTillTheElementIsVisible(profilepageobject.portfolio_Button);
			profilepageobject.portfolio_Button.click();
			ExtentTestManager.getTest().log(LogStatus.PASS, "Portfolio button is clickable");
		}
		catch(Throwable e)
		{
			Assert.fail("Could not perform action on \"Portfolio\" button" +"&"+ e.getMessage());
		}
	} 

	/*
	 * @author: Aishwarya
	 * Description: Verify that Edit icon is clickable for the Profile picture
	 * Created on : 08-05-2020
	 */
	public void clickOnEditIconOnTheProfilePicture(String... strings) {
		ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " :: Click on Edit icon");
		try 
		{
			genericfunctions.waitTillTheElementIsVisible(profilepageobject.editProfilePicture_Icon);
			profilepageobject.editProfilePicture_Icon.click();
			ExtentTestManager.getTest().log(LogStatus.PASS, "The profile picture >> Edit icon is clickable");
		}
		catch(Throwable e)
		{
			Assert.fail("Could not perform action on \"Edit Icon\"" +"&"+ e.getMessage());
		}
	} 

	/**
	 * Attach_Media_File
	 * Author:- Aishwarya
	 */
	public void attachFile(String...strings)
	{
		ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " :: Click on Upload Media File");
		String file=strings[1];
		try
		{
			genericfunctions.waitWebDriver(2000);
			DriverManager.getDriver().findElement(By.id("onfile")).sendKeys(file);
			ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " :: Media File Uploaded Successfully");
		}
		catch (Throwable e)
		{
			Assert.fail("Could not perform action on \"Uploading Media File\" "+"&"+e.getMessage()+"" );
		}
	}

	/*
	 * @author: Aishwarya
	 * Description: Verify that Edit icon is clickable for the Profile picture
	 * Created on : 08-05-2020
	 */
	public void clickOnApplyButtonOfEditPicturePopUp(String... strings) {
		ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " :: Click on Apply button of Edit Picture pop up");
		try 
		{
			genericfunctions.waitTillTheElementIsVisible(profilepageobject.editPicture_ApplyButton);
			profilepageobject.editPicture_ApplyButton.click();
			ExtentTestManager.getTest().log(LogStatus.PASS, "The <b>\"Apply button\" </b> of Edit picture pop up is clickable");
		}
		catch(Throwable e)
		{
			Assert.fail("Could not perform action on \"Apply button\"" +"&"+ e.getMessage());
		}
	} 

	/*
	 * @author: Aishwarya
	 * Description: Click on Special Hashtag dropdown in Profile page
	 * Created on : 20-05-2020
	 */
	public void clickOnSpecialHashtagDropdown(String... strings) {
		try 
		{
			genericfunctions.waitForPageToLoad(profilepageobject.hashtag_Dropdown);
			genericfunctions.waitTillTheElementIsVisible(profilepageobject.hashtag_Dropdown);
			profilepageobject.hashtag_Dropdown.click();
		}
		catch(Throwable e)
		{
			Assert.fail("Could not perform action on \"Special Hashtag \"dropdown" +"&"+ e.getMessage());
		}
	}


	/*
	 * @author: Aishwarya
	 * Description: Select a Special Hashtag from dropdown in Profile page
	 * Created on : 20-05-2020
	 */

	public void selectHashtag(String... strings)
	{
		try {
			DriverManager.getDriver().findElement(By.id("post-menu-"+strings[1])).click();
		}catch(Throwable e)
		{
			Assert.fail("Failed to select \"Special Hashtag \" from the dropdown" +"&"+ e.getMessage());
		}
	}

	/*
	 * @author: Aishwarya
	 * Description: Click on Special Hashtag Tab in Profile page
	 * Created on : 20-05-2020
	 */
	public void selectTab(String...strings)
	{ 
		try {
			String tab_name= "channel-"+strings[1]+"-tab";
			genericfunctions.scrollToStartOfPage();
			DriverManager.getDriver().findElement(By.id(tab_name)).click();
		}catch(Throwable e)
		{
			Assert.fail("Failed to click on the \"Special Hashtag \" Tab" +"&"+ e.getMessage());
		}
	}

	/*
	 * @author: Aishwarya
	 * Description: Click on Event Tab in Profile page
	 * Created on : 20-05-2020
	 */
	public void clickOnEventTab(String...strings ){
		try 
		{
			genericfunctions.scrollToStartOfPage();
			genericfunctions.waitForPageToLoad(profilepageobject.eventTab_ProfilePage);
			genericfunctions.waitTillTheElementIsVisible(profilepageobject.eventTab_ProfilePage);
			profilepageobject.eventTab_ProfilePage.click();
		}catch(Throwable e)
		{
			Assert.fail("Failed to click on the \"Special Hashtag \" Tab" +"&"+ e.getMessage());
		}
	}

	/////////////////////////////////////////// Page Verification ///////////////////////////////////////////////////////////	

	/*
	 * @author: Aishwarya
	 * Description: Verify display of View Profile option in Profile dropdown
	 * Created on : 05-05-2020
	 */
	public void verifyViewProfileLink(String... strings) {
		ExtentTestManager.getTest().log(LogStatus.INFO, strings[0]+" :: View Profile link is clickable or not with following assertions");
		try 
		{
			genericfunctions.waitTillTheElementIsVisibleAndClickable(profilepageobject.viewProfile_Link);
			ExtentTestManager.getTest().log(LogStatus.PASS, "View Profile link is clickable ");
		}
		catch(Throwable e)
		{
			Assert.fail("Could not perform action on \"view profile \"link" +"&"+ e.getMessage());
		}
	} 
	
	
	/*
	 * @author: Aishwarya
	 * Description: Verify display of View Profile option in Profile dropdown
	 * Created on : 05-05-2020
	 */
	public void verifyDisplayOfViewProfileLink(String ...strings)
	{
		ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " :: Display of View Profile link or not on clicking"
				+ " top-nav dropdown  with following assertions :");

		try {
			genericfunctions.waitTillTheElementIsVisible(profilepageobject.viewProfile_Link);
			Assert.assertTrue(profilepageobject.viewProfile_Link.isDisplayed());
			String Option=profilepageobject.viewProfile_Link.getText();

			ExtentTestManager.getTest().log(LogStatus.PASS, Option+ " link is displaying successfully");
		} catch (Throwable e)
		{
			Assert.fail("Expected :: \"View Profile\" link should be displayed ; Actual :: \"View Profile\" link is not displayed");
		}
	}

	/*
	 * @author: Aishwarya
	 * Description: Verify navigation to the Profile page on clicking View Profile
	 * Created on : 05-05-2020
	 */  
	public void verifyTheNavigationToProfilePage(String ...strings)
	{
		ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " :: User Navigates to the Profile page or not by clicking on View Profile link"
				+ "  with following assertions :");
		String actualFullName=null;
		String expectedFullName=strings[1] ;
		try
		{
			genericfunctions.waitForPageToLoad(profilepageobject.fullName_sidebar);
			genericfunctions.waitTillTheElementIsVisible(profilepageobject.fullName_sidebar);
			actualFullName=profilepageobject.fullName_sidebar.getText().trim();

			Assert.assertEquals(actualFullName, expectedFullName);
			ExtentTestManager.getTest().log(LogStatus.PASS, "Successfully navigated to the profile page of the user <b>\"" + actualFullName + "\" </b> ");
		}
		catch (Throwable e)
		{
			String actualException=e.getClass().getName();
			switch (actualException)
			{
			case "NoSuchElementException":
				Assert.fail("Expected ::User \"Full Name \" should be displayed ; Actual :: User \"Full Name  \" is not displaying"+"&"+e.getMessage()+"" );
				break;
			case "AssertionError":
				Assert.fail("Expected ::User \"Full Name \" should be displayed as <b>\"" + expectedFullName + "\"</b> ; Actual :: User \"Full Name \" is  displaying as   <b>\"" + actualFullName + "\"</b>");
				break;
			default:
				Assert.fail(""+"&"+e.getMessage()+"");
			}
		}
	}

	/*
	 * @author: Aishwarya
	 * Description: Verify the presence of Portfolio button
	 * Created on : 08-05-2020
	 */
	public void verifyDisplayOfPortfolioButton(String ...strings)
	{
		ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " :: Display of portfolio button"
				+ " in Profile page with following assertions :");
		try {
			genericfunctions.waitTillTheElementIsVisible(profilepageobject.portfolio_Button);
			Assert.assertTrue(profilepageobject.portfolio_Button.isDisplayed());
			String portfolioButton=profilepageobject.portfolio_Button.getText();

			ExtentTestManager.getTest().log(LogStatus.PASS, portfolioButton+ " button is displaying successfully");
		} 
		catch (Throwable e)
		{
			Assert.fail("Expected :: \"Portfolio\" button should be displayed ; Actual :: \"Portfolio\" button is not displayed");
		}
	}


	/*
	 * @author: Aishwarya
	 * Description: Verify the portfolio landing page
	 * Created on : 08-05-2020
	 */   
	public void verifyNavigationToPortfolioPage(String... strings) 
	{
		ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " :: Navigation to the Portfolio page with following assertion : ");
		try 
		{
			genericfunctions.waitForPageToLoad(profilepageobject.portfolioPage_Header);
			genericfunctions.waitTillTheElementIsVisible(profilepageobject.portfolioPage_Header);
			Assert.assertTrue(profilepageobject.portfolioPage_Header.isDisplayed());
			String Header_UserFullName=profilepageobject.portfolioPage_Header.getText().trim();

			ExtentTestManager.getTest().log(LogStatus.PASS,  " Successfully navigated to the page of : <b>\""+Header_UserFullName+"\"</b>");
		}
		catch(Throwable e)
		{
			Assert.fail("Could not perform action on \"Portfolio Page\"" +"&"+ e.getMessage());
		}
	}


	/*
	 * @author: Aishwarya
	 * Description: Verify the Edit icon for the profile picture
	 * Created on : 08-05-2020
	 */   
	public void verifyDisplayOfEditProfilePictureIcon(String... strings) 
	{
		ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " :: Display of Edit icon of profile picture with following assertions : ");
		try 
		{
			genericfunctions.waitTillTheElementIsVisible(profilepageobject.editProfilePicture_Icon);
			Assert.assertTrue(profilepageobject.editProfilePicture_Icon.isDisplayed());

			ExtentTestManager.getTest().log(LogStatus.PASS, "Edit Profile picture icon is displaying");
		}
		catch(Throwable e)
		{
			Assert.fail("Could not perform action on \"Edit icon\" of profile picture" +"&"+ e.getMessage());
		}
	}



	/*
	 * @author: Aishwarya
	 * Description: Verify the details in the About section
	 * Created on : 19-05-2020
	 */   
	public void verifyDisplayOfUserDescription(String... strings) 
	{
		String expected_Description = strings[0];
		String actual_Description = null; 
		try 
		{
			genericfunctions.waitWebDriver(2000);
			genericfunctions.scrollToElement(profilepageobject.aboutSection_Header);
			genericfunctions.waitForPageToLoad(profilepageobject.aboutDescription_ProfileCard);

			genericfunctions.waitTillTheElementIsVisible(profilepageobject.aboutDescription_ProfileCard);
			actual_Description=profilepageobject.aboutDescription_ProfileCard.getText();
			Assert.assertEquals(actual_Description, expected_Description);

			ExtentTestManager.getTest().log(LogStatus.PASS, "User description is displaying as : <b>\""+actual_Description+"\"</b>");
		}
		catch (Throwable e)
		{
			String actualException=e.getClass().getName();
			switch (actualException)
			{
			case "NoSuchElementException":
				Assert.fail("Expected ::User \"Description\" should be displayed ; Actual :: User \"Description \" "
						+ "is not displayed"+"&"+e.getMessage()+"" );
				break;
			case "AssertionError":
				Assert.fail("Expected ::User \"Description \" should be matching with the given description: <b>\"" 
						+ expected_Description + "\"</b> ; Actual :: User \"Description\" is  displaying as <b>\"" + actual_Description + "\"</b>");
				break;
			default:
				Assert.fail(""+"&"+e.getMessage()+"");
			}
		}     
	}

	/*
	 * @author: Aishwarya
	 * Description: Verify the Location in the About section
	 * Created on : 19-05-2020
	 */   
	public void verifyDisplayOfUserLocation(String... strings) 
	{
		String expected_Location = strings[0];
		String actual_Location = null; 
		try 
		{
			genericfunctions.scrollToElement(profilepageobject.aboutSection_Header);
			genericfunctions.waitTillTheElementIsVisible(profilepageobject.location_ProfileCard);
			actual_Location=profilepageobject.location_ProfileCard.getText();
			Assert.assertEquals(actual_Location, expected_Location);

			ExtentTestManager.getTest().log(LogStatus.PASS, "User location is displaying as : <b>\""+actual_Location+"\"</b>");
		}
		catch (Throwable e)
		{
			String actualException=e.getClass().getName();
			switch (actualException)
			{
			case "NoSuchElementException":
				Assert.fail("Expected ::User \"Location\" should be displayed ; Actual :: User \"Location \" "
						+ "is not displayed"+"&"+e.getMessage()+"" );
				break;
			case "AssertionError":
				Assert.fail("Expected ::User \"Location \" should be matching with the given Location: <b>\"" 
						+ expected_Location + "\"</b> ; Actual :: User \"Location\" is  displaying as <b>\"" + actual_Location + "\"</b>");
				break;
			default:
				Assert.fail(""+"&"+e.getMessage()+"");
			}
		}     
	}
	/*
	 * @author: Aishwarya
	 * Description: Verify the Email Id in the About section
	 * Created on : 19-05-2020
	 */   
	public void verifyDisplayOfUserEmailID(String... strings) 
	{
		String expected_EmailId = strings[0];
		String actual_EmailId = null; 
		try 
		{
			genericfunctions.waitTillTheElementIsVisible(profilepageobject.email_ProfileCard);
			actual_EmailId=profilepageobject.email_ProfileCard.getText();
			Assert.assertEquals(actual_EmailId, expected_EmailId);

			ExtentTestManager.getTest().log(LogStatus.PASS, "User Email Id is displaying as : <b>\""+actual_EmailId+"\"</b>");
		}
		catch (Throwable e)
		{
			String actualException=e.getClass().getName();
			switch (actualException)
			{
			case "NoSuchElementException":
				Assert.fail("Expected ::User \"Email Id\" should be displayed ; Actual :: User \"Email Id \" "
						+ "is not displayed"+"&"+e.getMessage()+"" );
				break;
			case "AssertionError":
				Assert.fail("Expected ::User \"Email Id \" should be matching with the given Email Id: <b>\"" 
						+ expected_EmailId + "\"</b> ; Actual :: User \"Email Id\" is  displaying as <b>\"" + actual_EmailId + "\"</b>");
				break;
			default:
				Assert.fail(""+"&"+e.getMessage()+"");
			}
		}     
	}

	/*
	 * @author: Aishwarya
	 * Description: Verify the Phone Number in the About section
	 * Created on : 19-05-2020
	 */   
	public void verifyDisplayOfUserPhoneNumber(String... strings) 
	{
		String expected_PhoneNumber = strings[0];
		String actual_PhoneNumber = null; 
		try 
		{
			genericfunctions.waitTillTheElementIsVisible(profilepageobject.phoneNumber_ProfileCard);
			actual_PhoneNumber=profilepageobject.phoneNumber_ProfileCard.getText();
			Assert.assertEquals(actual_PhoneNumber, expected_PhoneNumber);

			ExtentTestManager.getTest().log(LogStatus.PASS, "User Phone Number is displaying as : <b>\""+actual_PhoneNumber+"\"</b>");
		}
		catch (Throwable e)
		{
			String actualException=e.getClass().getName();
			switch (actualException)
			{
			case "NoSuchElementException":
				Assert.fail("Expected ::User \"Phone Number\" should be displayed ; Actual :: User \"Phone Number \" "
						+ "is not displayed"+"&"+e.getMessage()+"" );
				break;
			case "AssertionError":
				Assert.fail("Expected ::User \" Phone Number \" should be matching with the given Phone Number: <b>\"" 
						+ expected_PhoneNumber + "\"</b> ; Actual :: User \"Phone Number\" is  displaying as <b>\"" + actual_PhoneNumber + "\"</b>");
				break;
			default:
				Assert.fail(""+"&"+e.getMessage()+"");
			}
		}     
	}

	/*
	 * @author: Aishwarya
	 * Description: Verify the Phone Number in the About section
	 * Created on : 19-05-2020
	 */   
	public void verifyDisplayOfUserWebsite(String... strings) 
	{
		String expected_Website = strings[0];
		String actual_Website = null; 
		try 
		{
			genericfunctions.waitTillTheElementIsVisible(profilepageobject.website_ProfileCard);
			actual_Website=profilepageobject.website_ProfileCard.getText();
			Assert.assertEquals(actual_Website, expected_Website);

			ExtentTestManager.getTest().log(LogStatus.PASS, "User Website is displaying as : <b>\""+actual_Website+"\"</b>");
		}
		catch (Throwable e)
		{
			String actualException=e.getClass().getName();
			switch (actualException)
			{
			case "NoSuchElementException":
				Assert.fail("Expected ::User \"Website\" should be displayed ; Actual :: User \"Website \" "
						+ "is not displayed"+"&"+e.getMessage()+"" );
				break;
			case "AssertionError":
				Assert.fail("Expected ::User \" Website\" should be matching with the given Website: <b>\"" 
						+ expected_Website + "\"</b> ; Actual :: User \"Website\" is  displaying as <b>\"" + actual_Website + "\"</b>");
				break;
			default:
				Assert.fail(""+"&"+e.getMessage()+"");
			}
		}     
	}

	/*
	 * @author: Aishwarya
	 * Description: Verify the Height in the About section
	 * Created on : 19-05-2020
	 */   
	public void verifyDisplayOfUserHeight(String... strings) 
	{
		String expected_Height = strings[0];
		String actual_Height = null; 
		try 
		{
			genericfunctions.waitTillTheElementIsVisible(profilepageobject.height_ProfileCard);
			actual_Height=profilepageobject.height_ProfileCard.getText();
			Assert.assertEquals(actual_Height, expected_Height);

			ExtentTestManager.getTest().log(LogStatus.PASS, "User Heightis displaying as : <b>\""+actual_Height+"\"</b>");
		}
		catch (Throwable e)
		{
			String actualException=e.getClass().getName();
			switch (actualException)
			{
			case "NoSuchElementException":
				Assert.fail("Expected ::User \"Height\" should be displayed ; Actual :: User \"Height \" "
						+ "is not displayed"+"&"+e.getMessage()+"" );
				break;
			case "AssertionError":
				Assert.fail("Expected ::User \" Height\" should be matching with the given Height: <b>\"" 
						+ expected_Height + "\"</b> ; Actual :: User \"Height\" is  displaying as <b>\"" + actual_Height + "\"</b>");
				break;
			default:
				Assert.fail(""+"&"+e.getMessage()+"");
			}
		}     
	}

	/*
	 * @author: Aishwarya
	 * Description: Verify the Weight in the About section
	 * Created on : 19-05-2020
	 */   
	public void verifyDisplayOfUserWeight(String... strings) 
	{
		String expected_Weight = strings[0];
		String actual_Weight= null; 
		try 
		{
			genericfunctions.waitTillTheElementIsVisible(profilepageobject.weight_ProfileCard);
			actual_Weight=profilepageobject.weight_ProfileCard.getText();
			Assert.assertEquals(actual_Weight, expected_Weight);

			ExtentTestManager.getTest().log(LogStatus.PASS, "User Weight is displaying as : <b>\""+actual_Weight+"\"</b>");
		}
		catch (Throwable e)
		{
			String actualException=e.getClass().getName();
			switch (actualException)
			{
			case "NoSuchElementException":
				Assert.fail("Expected ::User \"Weight\" should be displayed ; Actual :: User \"Weight \" "
						+ "is not displayed"+"&"+e.getMessage()+"" );
				break;
			case "AssertionError":
				Assert.fail("Expected ::User \" Weight\" should be matching with the given Height: <b>\"" 
						+ expected_Weight + "\"</b> ; Actual :: User \"Weight\" is  displaying as <b>\"" + actual_Weight + "\"</b>");
				break;
			default:
				Assert.fail(""+"&"+e.getMessage()+"");
			}
		}     
	}

	/*
	 * @author: Aishwarya
	 * Description: Verify the Languages Known in the About section
	 * Created on : 19-05-2020
	 */   
	public void verifyDisplayOfLanguagesKnown(String... strings) 
	{

		String expected_LanguagesKnown = strings[0];
		String actual_LanguagesKnown= null; 
		try 
		{
			genericfunctions.waitTillTheElementIsVisible(profilepageobject.languagesKnown_ProfileCard);
			actual_LanguagesKnown=profilepageobject.languagesKnown_ProfileCard.getText();
			Assert.assertEquals(actual_LanguagesKnown, expected_LanguagesKnown);

			ExtentTestManager.getTest().log(LogStatus.PASS, "Languages Known are displaying as : <b>\""+actual_LanguagesKnown+"\"</b>");
		}
		catch (Throwable e)
		{
			String actualException=e.getClass().getName();
			switch (actualException)
			{
			case "NoSuchElementException":
				Assert.fail("Expected ::\"Languages Known\" by the user should be displayed ; Actual :: \"Languages Known \" by the user"
						+ "are not displayed"+"&"+e.getMessage()+"" );
				break;
			case "AssertionError":
				Assert.fail("Expected ::User \" Languages Known\" should be matching with the given Languages Known: <b>\"" 
						+ expected_LanguagesKnown + "\"</b> ; Actual :: User \"Languages Known\" is  displaying as <b>\"" + actual_LanguagesKnown + "\"</b>");
				break;
			default:
				Assert.fail(""+"&"+e.getMessage()+"");
			}
		}     
	}


	/*
	 * @author: Aishwarya
	 * Description: Verify the details in the About section
	 * Created on : 12-05-2020
	 */   
	public void verifyDetailsInAboutSection( Map<String, String> userDetails, String string)
	{
		ExtentTestManager.getTest().log(LogStatus.INFO, string+"  :: Details in about section with following assertions :");
		try 
		{
			
			String description = userDetails.get("Description");
			String location = userDetails.get("Location");
			String emailID = userDetails.get("Email_Id");
			String phoneNumber = userDetails.get("Phone_Number");
			String website = userDetails.get("Website");
			String height = userDetails.get("Height");
			String weight = userDetails.get("Weight");
			String languagesKnown = userDetails.get("Languages_Known");

			genericfunctions.waitWebDriver(3000);
			verifyDisplayOfUserDescription( description );
			verifyDisplayOfUserLocation( location);
			verifyDisplayOfUserEmailID( emailID);
			verifyDisplayOfUserPhoneNumber( phoneNumber);
			verifyDisplayOfUserWebsite( website);
			verifyDisplayOfUserHeight(height);
			verifyDisplayOfUserWeight( weight);
			verifyDisplayOfLanguagesKnown(languagesKnown);
			ExtentTestManager.getTest().log(LogStatus.PASS, " Succeessfully verified all the About details of user");

		}
		catch(Throwable e)
		{
			Assert.fail("Failed to verify \"About details\" of the user" +"&"+ e.getMessage());
		}
	}

	/*
	 * @author: Aishwarya
	 * Description: Verify the details in the About section
	 * Created on : 12-05-2020
	 */     
	public void verifyDisplayOfPostedText(String... strings)
	{
		String expectedposted_text = strings[1].trim();
		String actualPosted_text=null;

		try{
			ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " :: Created Text Post is displaying or "
					+ "not in the Profile page  with following assertion :");

			genericfunctions.waitWebDriver(2000);
			genericfunctions.waitForPageToLoad(homePageObjects.activity_text.get(0));
			actualPosted_text=homePageObjects.activity_text.get(0).getText().trim();

			genericfunctions.waitTillTheElementIsVisible(homePageObjects.activity_text.get(0));
			Assert.assertTrue(actualPosted_text.equals(expectedposted_text));
			ExtentTestManager.getTest().log(LogStatus.PASS, "Created \"Text\" Post is displaying as : <b>\""+actualPosted_text+"\"</b>");
		}
		catch(Throwable e)
		{
			String actualException=e.getClass().getName();

			switch (actualException)
			{
			case "NoSuchElementException":
				Assert.fail("Expected :: Created \"Text \"  Post should be displayed ; Actual :: Created \"Text\""
						+ " post is not displayed"+"&"+e.getMessage()+"" );
				break;
			case "AssertionError":
				Assert.fail("Expected :: Created \"Text \" Post should be displayed as " + expectedposted_text + 
						" ; Actual :: Created \"Text\" post is displayed as " +actualPosted_text+ "");
				break;
			default:
				Assert.fail(""+"&"+e.getMessage()+"");
			}
		}   

	}
	/*
	 * @author: Aishwarya
	 * Description: Verify the details in the About section
	 * Created on : 12-05-2020
	 */     

	public void verifyDisplayOfCreatedOpportunity(String... strings)
	{
		String expectedposted_opportunity = strings[1].trim();
		String actualPosted_opportunity=null;
		try{
			ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " :: Created opportunity is displaying or not in "
					+ "the Profile page  with following assertion :");

			genericfunctions.waitWebDriver(2000);
			//genericfunctions.waitForPageToLoad(profilepageobject.opportunityTitle_OpportunityTab);
			genericfunctions.scrollToElement(profilepageobject.opportunityTitle_OpportunityTab);
			actualPosted_opportunity=profilepageobject.opportunityTitle_OpportunityTab.getText().trim();

			genericfunctions.waitTillTheElementIsVisible(profilepageobject.opportunityTitle_OpportunityTab);
			Assert.assertTrue(actualPosted_opportunity.equals(expectedposted_opportunity));
			ExtentTestManager.getTest().log(LogStatus.PASS, "Created \"Oppoprtunity\" is displaying as : <b>\""+actualPosted_opportunity+"\"</b>" +" in the respective tab");
			
			
		}
		catch(Throwable e)
		{
			String actualException=e.getClass().getName();

			switch (actualException)
			{

			case "NoSuchElementException":
				Assert.fail("Could not perform action on fetching Created content is not reflecting "+ "&" +
						" Defect Link - <a href='https://taiga.vnaad.com/project/admin-one-page-spotlight/issue/1681'"
						+ " target='_blank'>https://taiga.vnaad.com/project/admin-one-page-spotlight/issue/1681</a>  ");
				
			/*	Assert.fail("Expected :: Created \"Text \"  Post should be displayed ; Actual :: Created \"Text\" "
						+ "post is not displayed"+"&"+e.getMessage()+"" );
				*/
				break;
			case "AssertionError":
				Assert.fail("Expected :: Created \"Text \" Post should be displayed as " + expectedposted_opportunity + " "
						+ "; Actual :: Created \"Text\" post is displayed as " +actualPosted_opportunity+ "");
				break;
			default:
				Assert.fail(""+"&"+e.getMessage()+"");
			}
		}   

	}



}
