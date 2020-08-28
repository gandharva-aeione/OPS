package com.aeione.ops.pageactions;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.aeione.ops.generic.DriverManager;
import com.aeione.ops.generic.ExtentTestManager;
import com.aeione.ops.generic.GenericFunctions;
import com.aeione.ops.pageobjects.CommunityPageObjects;
import com.aeione.ops.pageobjects.HomePageObjects;
import com.aeione.ops.pageobjects.LoginPageObjects;
import com.relevantcodes.extentreports.LogStatus;

public class CommunityPageActions {

	GenericFunctions genericfunctions;
	LoginPageObjects loginpageobjects = new LoginPageObjects();
	HomePageObjects homepageobjects = new HomePageObjects();
	CommunityPageObjects communityPageObjects = new CommunityPageObjects();
	Actions actions = null;
	Select selectdropdownOption=null;


	public CommunityPageActions() throws IOException {
		genericfunctions = new GenericFunctions(DriverManager.getDriver());
		PageFactory.initElements(DriverManager.getDriver(), this);
		PageFactory.initElements(DriverManager.getDriver(), loginpageobjects);
		PageFactory.initElements(DriverManager.getDriver(), homepageobjects);
		PageFactory.initElements(DriverManager.getDriver(), communityPageObjects);

		actions = new Actions(DriverManager.getDriver());
	}

	///////////////////////////////////////////// Page actions //////////////////////////////////////////////////////

	/*
	 * @author: Aishwarya
	 * Description: Click on Create Community from Group link
	 * Created on : 29-05-2020
	 */

	public void clickOnCreateCommunityFromGroupLink(String... strings) {
		try 
		{
			genericfunctions.waitForPageToLoad(communityPageObjects.createCommunity_Link);
			genericfunctions.waitTillTheElementIsVisible(communityPageObjects.createCommunity_Link);
			communityPageObjects.createCommunity_Link.click();
		}
		catch(Throwable e)
		{
			Assert.fail("Could not perform action on \"Create Community \"link" +"&"+ e.getMessage());
		}
	}

	/*
	 * @author: Aishwarya
	 * Description: Click on Create Community from Group link
	 * Created on : 29-05-2020
	 */

	public void clickOnPrivateCommunityType(String... strings) {
		ExtentTestManager.getTest().log(LogStatus.INFO, strings[0]+":: Select Private Community Type");
		try 
		{
			genericfunctions.waitForPageToLoad(communityPageObjects.create_PrivateCommunity);
			genericfunctions.waitTillTheElementIsVisible(communityPageObjects.create_PrivateCommunity);
			communityPageObjects.create_PrivateCommunity.click();
		}
		catch(Throwable e)
		{
			Assert.fail("Could not perform action on \"Private - Community Type \"" +"&"+ e.getMessage());
		}
	}

	/*
	 * @author: Aishwarya
	 * Description: Enter community title
	 * Created on : 29-05-2020
	 */
	public void enterCommunityName(String...strings)
	{
		String communityName=strings[1];
		ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " :: Enter Community name as : "+communityName);
		try
		{
			genericfunctions.waitTillTheElementIsVisible(communityPageObjects.communityName_TextField);
			communityPageObjects.communityName_TextField.sendKeys(communityName);
		}
		catch (Throwable e)
		{
			Assert.fail("Could not able to enter community name"+"&"+e.getMessage()+"" );
		}
	}

	/*
	 * @author: Aishwarya
	 * Description: Enter community title
	 * Created on : 29-05-2020
	 */
	public void enterCommunityDescription(String...strings)
	{
		String description=strings[1];
		ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " :: Enter Community description as : " +description);
		try
		{
			genericfunctions.waitTillTheElementIsVisible(communityPageObjects.communityDescription_TextArea);
			communityPageObjects.communityDescription_TextArea.sendKeys(description);
		}
		catch (Throwable e)
		{
			Assert.fail("Could not able to enter community description"+"&"+e.getMessage()+"" );
		}
	}

	/*
	 * @author: Aishwarya
	 * Description: Enter community hashtag
	 * Created on : 29-05-2020
	 */
	public void enterCommunityHashtag(String...strings)
	{
		String hashtag=strings[1];
		ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " :: Enter Hashtag as : "+hashtag);
		try
		{
			genericfunctions.scrollToElement(communityPageObjects.hashtag_Field);
			genericfunctions.waitTillTheElementIsVisible(communityPageObjects.hashtag_Field);
			//communityPageObjects.hashtag_Field.sendKeys(hashtag);
			//communityPageObjects.hashtag_Field.click();
			//selectdropdownOption.selectByValue(hashtag);
		}
		catch (Throwable e)
		{
			Assert.fail("Could not able to enter Hashtags"+"&"+e.getMessage()+"" );
		}
	}

	/*
	 * @author: Aishwarya
	 * Description: Click on Create button 
	 * Created on : 29-05-2020
	 */

	public void clickOnCreatebutton(String... strings) {
		ExtentTestManager.getTest().log(LogStatus.INFO, strings[0]+":: Creating Community with following assertions : ");
		try 
		{
			genericfunctions.waitTillTheElementIsVisible(communityPageObjects.community_CreateButton);
			communityPageObjects.community_CreateButton.click();
			ExtentTestManager.getTest().log(LogStatus.PASS, "Community is created successfully");

		}
		catch(Throwable e)
		{
			Assert.fail("Could not perform action on \"Create \"button" +"&"+ e.getMessage());
		}
	}

	/*
	 * @author: Aishwarya
	 * Description: Click on Create button 
	 * Created on : 29-05-2020
	 */

	public void clickOnPlusIconToInviteMembers(String... strings) {
		ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " :: Click on Plus icon to Invite");
		try 
		{
			genericfunctions.waitForPageToLoad(communityPageObjects.invite_plusIcon);
			genericfunctions.waitTillTheElementIsVisible(communityPageObjects.invite_plusIcon);
			communityPageObjects.invite_plusIcon.click();

		}
		catch(Throwable e)
		{
			Assert.fail("Could not perform action on \"Invite- Plus icon\"" +"&"+ e.getMessage());
		}
	}

	/*
	 * @author: Aishwarya
	 * Description: Click on Search Members Text field
	 * Created on : 29-05-2020
	 */

	public void clickOnSearchMembersTextField(String... strings) {

		try 
		{
			genericfunctions.waitForPageToLoad(communityPageObjects.searchMembers_TextField);
			genericfunctions.waitTillTheElementIsVisible(communityPageObjects.searchMembers_TextField);
			communityPageObjects.searchMembers_TextField.click();
		}
		catch(Throwable e)
		{
			Assert.fail("Could not perform action on \"Search members \" text field" +"&"+ e.getMessage());
		}
	}

	/*
	 * @author: Aishwarya
	 * Description: enter user name in search field
	 * Created on : 29-05-2020
	 */

	public void enterUsernameInSearchField(String... strings) {
		String userName= strings[1];
		ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " ::To invite, search the user : "+userName);
		try 
		{
			genericfunctions.waitForPageToLoad(communityPageObjects.searchMembers_TextField);
			genericfunctions.waitTillTheElementIsVisible(communityPageObjects.searchMembers_TextField);
			communityPageObjects.searchMembers_TextField.sendKeys(userName);
		}
		catch(Throwable e)
		{
			Assert.fail("Could not perform action on \"Search members \" text field" +"&"+ e.getMessage());
		}
	}

	/*
	 * @author: Aishwarya
	 * Description: Click on Invite button
	 * Created on : 29-05-2020
	 */

	public void clickOnInvitebutton(String... strings) {
		ExtentTestManager.getTest().log(LogStatus.INFO," " + strings[0] + " :: By click on Invite button, whether Admin has authority to"
				+ " invite members to his community with following assertions : ");
		try 
		{
			genericfunctions.waitForPageToLoad(communityPageObjects.inviteButton);
			genericfunctions.waitTillTheElementIsVisible(communityPageObjects.inviteButton);
			communityPageObjects.inviteButton.click();
			ExtentTestManager.getTest().log(LogStatus.PASS," Admin has authority to invite members to his Community");
		}
		catch(Throwable e)
		{
			Assert.fail("Could not perform action on \"Invite \" button" +"&"+ e.getMessage());
		}
	}

	/*
	 * @author: Aishwarya
	 * Description: Click on Settings action button
	 * Created on : 29-05-2020
	 */

	public void clickOnSettingsActionButton(String... strings) {
		ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " :: Click on Settings button"); 
		try 
		{
			genericfunctions.waitWebDriver(3000);
			genericfunctions.waitForPageToLoad(communityPageObjects.settings_ActionButton);
			genericfunctions.waitTillTheElementIsVisible(communityPageObjects.settings_ActionButton);
			communityPageObjects.settings_ActionButton.click();
		}
		catch(Throwable e)
		{
			Assert.fail("Could not perform action on \"settings\" button" +"&"+ e.getMessage());
		}
	}
	/*
	 * @author: Aishwarya
	 * Description: Click on Make Closed option
	 * Created on : 29-05-2020
	 */

	public void clickOnMakeClosedOption(String... strings) {
		ExtentTestManager.getTest().log(LogStatus.INFO, "" + strings[0] + ":: Click on <b>\"Make CLosed\" </b> button");
		try 
		{
			genericfunctions.waitForPageToLoad(communityPageObjects.makePrivate_Option);
			genericfunctions.waitTillTheElementIsVisible(communityPageObjects.makePrivate_Option);
			communityPageObjects.makePrivate_Option.click();
		}
		catch(Throwable e)
		{
			Assert.fail("Could not perform action on \"settings\" button" +"&"+ e.getMessage());
		}
	}

	/*
	 * @author: Aishwarya
	 * Description: Click on Community tab from home page
	 * Created on : 29-05-2020
	 */

	public void clickOnCommunityTabFromHomePage(String... strings) {
		ExtentTestManager.getTest().log(LogStatus.INFO," " + strings[0] + " ::Click on Community tab from Home page");
		try 
		{
			genericfunctions.waitForPageToLoad(communityPageObjects.communityTab_HomePage);
			genericfunctions.waitTillTheElementIsVisible(communityPageObjects.communityTab_HomePage);
			communityPageObjects.communityTab_HomePage.click();
		}
		catch(Throwable e)
		{
			Assert.fail("Could not perform action on \"Community tab\" " +"&"+ e.getMessage());
		}
	}
	/*
	 * @author: Aishwarya
	 * Description: Click on Community from the communities you manage list
	 * Created on : 29-05-2020
	 */

	public void clickOnCommunityFromCommunitiesYouManageList(String... strings) {
		ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " ::Click on created community");
		try 
		{
			genericfunctions.waitForPageToLoad(communityPageObjects.community_CommunityYouManage);
			genericfunctions.waitTillTheElementIsVisible(communityPageObjects.community_CommunityYouManage);
			communityPageObjects.community_CommunityYouManage.click();
		}
		catch(Throwable e)
		{
			Assert.fail("Could not perform action on \"community \"from Communities You Manage list" +"&"+ e.getMessage());
		}
	}

	/*
	 * @author: Aishwarya
	 * Description: Get community name
	 * Created on : 01-06-2020
	 */

	public String getCommunityName(String... strings) {
		String Community=null;
		try 
		{
			genericfunctions.waitWebDriver(6000);
			genericfunctions.waitForPageToLoad(communityPageObjects.communityTitle_InnerPage);
			genericfunctions.waitTillTheElementIsVisible(communityPageObjects.communityTitle_InnerPage);
			Community=communityPageObjects.communityTitle_InnerPage.getText().trim();
		}
		catch(Throwable e)
		{
			Assert.fail("Could not get the \" Community Name \"" +"&"+ e.getMessage());
		}
		return Community;
	}
	
	

	/*
	 * @author: Aishwarya
	 * Description: Click on Delete Community as admin
	 * Created on : 01-06-2020
	 */

	public void verifyDeleteCommunityOption(String... strings) {
		ExtentTestManager.getTest().log(LogStatus.INFO," " + strings[0] + " :: Display of Delete Community option as admin with following assertions : ");
		try 
		{
			genericfunctions.waitForPageToLoad(communityPageObjects.deleteCommunity);
			genericfunctions.waitTillTheElementIsVisible(communityPageObjects.deleteCommunity);
			Assert.assertTrue(communityPageObjects.deleteCommunity.isDisplayed());
			ExtentTestManager.getTest().log(LogStatus.PASS, " \"Delete Community\" option is displaying successfully "
					+ "to the Community Admin");
			
		}
		catch(Throwable e)
		{
			Assert.fail("Failed to verify display of \"Delete Community \" as admin" +"&"+ e.getMessage());
		}
	}	
			

	/*
	 * @author: Aishwarya
	 * Description: Click on Delete Community as admin
	 * Created on : 01-06-2020
	 */

	public void clickOnDeleteCommunity(String... strings) {
		ExtentTestManager.getTest().log(LogStatus.INFO," " + strings[0] + " :: Click on Delete Community");
		try 
		{	
			genericfunctions.waitTillTheElementIsVisible(communityPageObjects.deleteCommunity);
			communityPageObjects.deleteCommunity.click();

		}
		catch(Throwable e)
		{
			Assert.fail("Could not perform action on \"Delete Community \" as admin" +"&"+ e.getMessage());
		}
	}
	/*
	 * @author: Aishwarya
	 * Description: Click on Confirm Delete Community as admin
	 * Created on : 01-06-2020
	 */

	public void clickOnConfirmDeleteCommunity(String... strings) {
		ExtentTestManager.getTest().log(LogStatus.INFO, "" + strings[0] + ":: Admin is able to Delete the Community");
		try 
		{
			genericfunctions.waitForPageToLoad(communityPageObjects.confirm_DeleteCommunity);
			genericfunctions.waitTillTheElementIsVisible(communityPageObjects.confirm_DeleteCommunity);
			communityPageObjects.confirm_DeleteCommunity.click();
			ExtentTestManager.getTest().log(LogStatus.PASS, " Admin has successfully \"Deleted the Community\" ");

		}
		catch(Throwable e)
		{
			Assert.fail("Could not perform action on \"Confirm Delete Community \" as admin" +"&"+ e.getMessage());
		}
	}

	/*
	 * @author: Aishwarya
	 * Description: Click on Join button of recommended Community 
	 * Created on : 02-06-2020
	 */

	public void clickOnJoinButtonOfRecommendedCommunity(String... strings) {
		ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " ::Click on JOIN button of the recommended community");
		try 
		{
			genericfunctions.waitForPageToLoad(communityPageObjects.joinButton_CommunitiesPage);
			genericfunctions.scrollToElement(communityPageObjects.joinButton_CommunitiesPage);
			genericfunctions.waitTillTheElementIsVisible(communityPageObjects.joinButton_CommunitiesPage);
			communityPageObjects.joinButton_CommunitiesPage.click();
		}
		catch(Throwable e)
		{
			Assert.fail("Could not perform action on \"Join button \" of recommended communities" +"&"+ e.getMessage());
		}
	}

	/*
	 * @author: Aishwarya
	 * Description: Click on Join button of Private Community 
	 * Created on : 02-06-2020
	 */

	public void clickOnJoinButtonOfPrivateCommunity(String... strings) {
		ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " ::Click on Join Private community"); 
		try 
		{
			genericfunctions.waitForPageToLoad(communityPageObjects.joinButton_PrivateCommunity);
			genericfunctions.waitTillTheElementIsVisible(communityPageObjects.joinButton_PrivateCommunity);
			communityPageObjects.joinButton_PrivateCommunity.click();
		}
		catch(Throwable e)
		{
			Assert.fail("Could not perform action on \"Join button \" of private communities" +"&"+ e.getMessage());
		}
	}


	/*
	 * @author: Aishwarya
	 * Description: Click on 
	 * Created on : 02-06-2020
	 */

	public void clickOnEditButton(String... strings) {
		ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " ::Click on Edit COmmunity button");
		try 
		{
			genericfunctions.waitForPageToLoad(communityPageObjects.editCommunity);
			genericfunctions.waitTillTheElementIsVisible(communityPageObjects.editCommunity);
			communityPageObjects.joinButton_PrivateCommunity.click();
		}
		catch(Throwable e)
		{
			Assert.fail("Could not perform action on \"Join button \" of private communities" +"&"+ e.getMessage());
		}
	}


	/**
	 * Attach_File_Image_Audio_Video
	 * Author:- Gandahrva
	 */
	public void attachFile(String...strings)
	{
		ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " :: Click on Upload Media File");
		String file=strings[1];
		try
		{
			genericfunctions.waitWebDriver(2000);
			DriverManager.getDriver().findElement(By.id("create-community-profile-file")).sendKeys(file);
			ExtentTestManager.getTest().log(LogStatus.INFO, " Media File Uploaded Successfully");
		}
		catch (Throwable e)
		{
			Assert.fail("Could not perform action on \"Uploading Media File\" "+"&"+e.getMessage()+"" );
		}
	}


	/*
	 * @author: Aishwarya
	 * Description: Click on Disable gathering
	 * Created on : 02-06-2020
	 */

	public void clickOnDisableGathering(String... strings) {
		ExtentTestManager.getTest().log(LogStatus.INFO, "" + strings[0] + "::Admin is able to change the "
				+ " Setting - Disable Gathering with following assertions :");
		String disableGathering=null; 
		try 
		{
			genericfunctions.waitForPageToLoad(communityPageObjects.disableGathering);
			genericfunctions.waitTillTheElementIsVisibleAndClickable(communityPageObjects.disableGathering);
			disableGathering= communityPageObjects.disableGathering.getText().trim();
			communityPageObjects.disableGathering.click();
			ExtentTestManager.getTest().log(LogStatus.PASS, "Admin is able to change the "
					+ " following Settings - "+disableGathering);
		}
		catch(Throwable e)
		{
			Assert.fail("Could not perform action on \"Disable gathering \" of a community" +"&"+ e.getMessage());
		}
	}

	/*
	 * @author: Aishwarya
	 * Description: Click on Disable Notification
	 * Created on : 02-06-2020
	 */

	public void clickOnDisableNotifications(String... strings) {
		ExtentTestManager.getTest().log(LogStatus.PASS, "" + strings[0] + ":: Admin is able to change the "
				+ " following Settings - Disable Notification");
		String disableNotifications=null; 
		try 
		{
			genericfunctions.waitForPageToLoad(communityPageObjects.disableNotification);
			genericfunctions.waitTillTheElementIsVisibleAndClickable(communityPageObjects.disableNotification);
			disableNotifications=communityPageObjects.disableNotification.getText().trim();
			communityPageObjects.disableNotification.click();
			ExtentTestManager.getTest().log(LogStatus.PASS, "Admin has successfully changed the "
					+ " following Setting - "+disableNotifications);
		}
		catch(Throwable e)
		{
			Assert.fail("Could not perform action on \"Disable Notifications \" of a community" +"&"+ e.getMessage());
		}
	}




	/*
	 * @author: Aishwarya
	 * Description: Click on Special Hashtag Tab in Profile page
	 * Created on : 20-05-2020
	 */
	/*public void ClickOnJoinCommunity(String...strings)
	{ 
		try {
		//String tab_name= "channel-"+strings[1]+"-tab";
		genericfunctions.scrollToStartOfPage();
		DriverManager.getDriver().findElement(By.xpath()).click();
	}catch(Throwable e)
	{
		Assert.fail("Failed to click on the \"Special Hashtag \" Tab" +"&"+ e.getMessage());
	}
}*/



	///////////////////////////////////   Page Verifications   //////////////////////////////////////////////////

	/*
	 * @author: Aishwarya
	 * Description: Verify Creation of event and default navigation to event inner page
	 * Created on : 29-05-2020
	 */
	public void verifyCommunityInnerPage(String... strings)
	{
		ExtentTestManager.getTest().log(LogStatus.INFO, " "+ strings[0]  +" :: Navigation to the"
				+ " community inner page by creating a community with following assertions :");
		String ExpectedComm_Name= strings[1];
		String actualComm_Name=null;
		try
		{
			genericfunctions.waitWebDriver(6000);
			genericfunctions.waitForPageToLoad(communityPageObjects.communityTitle_InnerPage);
			genericfunctions.waitTillTheElementIsVisible(communityPageObjects.communityTitle_InnerPage);
			actualComm_Name= communityPageObjects.communityTitle_InnerPage.getText().trim();
			Assert.assertEquals(actualComm_Name,ExpectedComm_Name);
			ExtentTestManager.getTest().log(LogStatus.PASS, " Successfully navigated to inner page of created community -"
					+ " <b>\""+actualComm_Name+ "\"</b>");

		} catch (Throwable e)
		{
			Assert.fail("Expected :: Once the community is created, by default the  user should be navigate to inner page of community ; " +
					"Actual :: Failed to navigate to \" Community ::\" inner page after creating the community \"" + "&" + e.getMessage() + "");
		}
	}

	/*
	 * @author: Aishwarya
	 * Description: Verify converting the public community to private community
	 * Created on : 29-05-2020
	 */
	public void verifyConvertingCommunityFromPublicToPrivate(String... strings)
	{
		ExtentTestManager.getTest().log(LogStatus.INFO, " "+ strings[0]  +" :: Converting a community"
				+ " from Public to Private with following assertions :");
		String option=null;
		try
		{
			genericfunctions.waitTillTheElementIsVisible(communityPageObjects.makePublic_Option);
			Assert.assertTrue(communityPageObjects.makePublic_Option.isDisplayed());
			option= communityPageObjects.makePublic_Option.getText().trim();
			ExtentTestManager.getTest().log(LogStatus.PASS, " \"Public Community\" has been converted to a  \"Private community\" "
					+ "by clicking on following settings option - <b>\"" +option+ "\"</b>");

		} catch (Throwable e)
		{
			Assert.fail("Expected :: The public community should be converted to a private community ; Actual :: Failed to convert the Public community to Private community " + "&" + e.getMessage() + "");
		}
	}

	/*
	 * @author: Aishwarya
	 * Description: Verify converting the public community to private community
	 * Created on : 29-05-2020
	 */
	public void verifyDeletedCommunityInCommunityList(String... strings)
	{
		ExtentTestManager.getTest().log(LogStatus.INFO, " "+ strings[0]  +" :: Whether Deleted community is removed or not from  <b>\"Communities you manage list\"</b> with following assertions : ");
		String deleted_Community=strings[1];
		String actual_Community=null;
		try
		{
			genericfunctions.waitTillTheElementIsVisible(communityPageObjects.community_CommunityYouManage);
			actual_Community= communityPageObjects.community_CommunityYouManage.getText().trim();
			Assert.assertNotEquals(actual_Community, deleted_Community);
			ExtentTestManager.getTest().log(LogStatus.PASS, " Deleted Community <b> \""+deleted_Community+"\" </b> is successfully removed from the <b>\"Communities you manage list\"<b> ");

		} catch (Throwable e)
		{
			Assert.fail("Expected :: Deleted community should be removed from the <b>\"Communities you manage list\"<b> ; Actual :: Failed to remove the deleted community from the <b>\"Communities you manage list\"<b> " + "&" + e.getMessage() + "");
		}
	}

	/*
	 * @author: Aishwarya
	 * Description: Verify joining a public community
	 * Created on : 02-06-2020
	 */
	public void verifyJoiningPublicCommunity(String... strings)
	{
		ExtentTestManager.getTest().log(LogStatus.INFO, " "+ strings[0]  +" :: Joining a"
				+ " public Community");
		String status=null;
		try
		{
			genericfunctions.waitTillTheElementIsVisible(communityPageObjects.openButton_PublicCommunity);
			status= communityPageObjects.openButton_PublicCommunity.getText().trim();
			Assert.assertTrue(communityPageObjects.openButton_PublicCommunity.isDisplayed());
			ExtentTestManager.getTest().log(LogStatus.PASS, "" + strings[0] + ":: User joined a \"Public Community\" successfully. "
					+ "And the\" Join button\" turned into - "+status+ " button");

		} catch (Throwable e)
		{
			Assert.fail("Expected :: User should be able to join a public community ; " +
					"Actual :: Failed to verify joining a public community \"" + "&" + e.getMessage() + "");
		}
	}

	/*
	 * @author: Aishwarya
	 * Description: Verify joining a Private community
	 * Created on : 02-06-2020
	 */
	public void verifyJoiningPrivateCommunity(String... strings)
	{
		ExtentTestManager.getTest().log(LogStatus.INFO, " "+ strings[0]  +" :: Join a"
				+ " Private Community");
		String status=null;
		try
		{
			genericfunctions.waitTillTheElementIsVisible(communityPageObjects.cancelbutton_PrivateCommunity);
			status= communityPageObjects.cancelbutton_PrivateCommunity.getText().trim();
			Assert.assertTrue(communityPageObjects.cancelbutton_PrivateCommunity.isDisplayed());
			ExtentTestManager.getTest().log(LogStatus.PASS, "" + strings[0] + ":: User joined a \"Private Community\" successfully. "
					+ "And the\" Join button\" turned into - "+status+ " button");

		} catch (Throwable e)
		{
			Assert.fail("Expected :: User should be able to join a Private community ; " +
					"Actual :: Failed to verify joining a Private community \"" + "&" + e.getMessage() + "");
		}
	}

	/*
	 * @author: Aishwarya
	 * Description: Verify joining a community (Public and/or Private community)
	 * Created on : 02-06-2020
	 */
	public void verifyJoiningCommunity(String... strings)
	{
		try
		{
			clickOnJoinButtonOfRecommendedCommunity("Action Step");
			if(communityPageObjects.joinButton_PrivateCommunity.isDisplayed())
			{
				clickOnJoinButtonOfPrivateCommunity("Action Step");
				verifyJoiningPrivateCommunity("Verify Step");
			}
			else if (communityPageObjects.openButton_PublicCommunity.isDisplayed()) 
			{
				verifyJoiningPublicCommunity("Verify Step");
			}
			else
			{
				ExtentTestManager.getTest().log(LogStatus.FAIL, " "+ strings[0]  +" :: Failed to verify"
						+ " joining Community");
			}

		} catch (Throwable e)
		{
			Assert.fail("Expected :: User should be able to join community ; " +
					"Actual :: Failed to verify joining a community \"" + "&" + e.getMessage() + "");
		}
	}


	/*
	 * @author: Aishwarya
	 * Description: Verify display of Enable Notifications option
	 * Created on : 02-06-2020
	 */
	public void verifyDisplayOfEnableNotificationOption(String... strings)
	{
		ExtentTestManager.getTest().log(LogStatus.INFO, " "+ strings[0]  +" :: Verify converting "
				+ " from Public to Private ");
		String option=null;
		try
		{
			genericfunctions.waitTillTheElementIsVisible(communityPageObjects.makePrivate_Option);
			Assert.assertTrue(communityPageObjects.makePrivate_Option.isDisplayed());
			option= communityPageObjects.makePrivate_Option.getText().trim();
			ExtentTestManager.getTest().log(LogStatus.PASS, "" + strings[0] + ":: \"Public Community \"has been converted to a Private community "
					+ "with the following settings option - "+option);

		} catch (Throwable e)
		{
			Assert.fail("Expected :: The public community should be converted to a private community ; " +
					"Actual :: Failed to convert the Public community to Private community \"" + "&" + e.getMessage() + "");
		}
	}
















}
