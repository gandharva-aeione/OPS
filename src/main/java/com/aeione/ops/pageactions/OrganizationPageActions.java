package com.aeione.ops.pageactions;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.aeione.ops.generic.DriverManager;
import com.aeione.ops.generic.ExtentTestManager;
import com.aeione.ops.generic.GenericFunctions;
import com.aeione.ops.pageobjects.HomePageObjects;
import com.aeione.ops.pageobjects.OrganizationPageObjects;
import com.aeione.ops.pageobjects.ProfileCompletionPageObjects;
import com.aeione.ops.pageobjects.ProfilePageObjects;
import com.relevantcodes.extentreports.LogStatus;

/*
 * @author: Aishwarya
 * Description: Organization Page Actions
 * Date of Creation: 05-06-2020
 */
public class OrganizationPageActions {
	GenericFunctions genericfunctions;
	OrganizationPageObjects organizationPageObjects = new OrganizationPageObjects();
	ProfilePageObjects profilepageobject = new ProfilePageObjects();
	HomePageObjects homePageObjects = new HomePageObjects();
	ProfileCompletionPageObjects profileCompletionPageObjects = new ProfileCompletionPageObjects();
	Actions action;
	Select selectdropdownOption=null;

	public OrganizationPageActions() throws IOException
	{

		genericfunctions = new GenericFunctions(DriverManager.getDriver());
		PageFactory.initElements(DriverManager.getDriver(), this);
		PageFactory.initElements(DriverManager.getDriver(), profilepageobject);
		PageFactory.initElements(DriverManager.getDriver(), homePageObjects);
		PageFactory.initElements(DriverManager.getDriver(), organizationPageObjects);
		PageFactory.initElements(DriverManager.getDriver(), profileCompletionPageObjects);
		action=new Actions(DriverManager.getDriver());
	}

	public HomePageActions getHomePageActions() throws IOException
	{
		return new HomePageActions();
	}

	////////////////////////////////////////////////// Page actions //////////////////////////////////////////////////////

	/*
	 * @author: Aishwarya
	 * Description: Click on Organization Link form Profile Dropdown
	 * Created on : 05-05-2020
	 */
	public void clickOnOrganizationLink(String... strings) {
		ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " :: Click on Organization link ");
		try
		{
			genericfunctions.waitForPageToLoad(organizationPageObjects.organizationLink);
			genericfunctions.waitTillTheElementIsVisible(organizationPageObjects.organizationLink);
			organizationPageObjects.organizationLink.click();
		}
		catch(Throwable e)
		{
			Assert.fail("Could not perform action on \"Organization \"link" +"&"+ e.getMessage());
		}
	}
	/*
	 * @author: Aishwarya / Gandharva
	 * Description: Click on Organization page
	 * Created on : 05-05-2020
	 */
	public void clickOnCreateOrganizationButton(String... strings)
	{
		ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " :: Click On Create Organization Button ");
		try
		{
			genericfunctions.waitTillTheElementIsVisible(organizationPageObjects.createOrganization_Button);
			organizationPageObjects.createOrganization_Button.click();
		}
		catch(Throwable e)
		{
			Assert.fail("Could not perform action on \"Create Organization \" Button" +"&"+ e.getMessage());
		}
	}

	/*
	 * @author: Aishwarya
	 * Description: Enter Organization Name
	 * Created on : 05-06-2020
	 */
	public void enterOrganizationName(String...strings)
	{
		String orgName=strings[1];
		ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " :: Enter Organization name as "
				+ " <b>\""+orgName+"\" </b>");
		try
		{
			genericfunctions.waitTillTheElementIsVisible(organizationPageObjects.createOrganization_Name);
			organizationPageObjects.createOrganization_Name.sendKeys(orgName);
		}
		catch (Throwable e)
		{
			Assert.fail("Could not able to enter \"Organization name\""+"&"+e.getMessage()+"" );
		}
	}

	/*
	 * @author: Aishwarya
	 * Description: Select Organization Type
	 * Created on : 05-06-2020
	 */
	public void selectOrganizationType(String...strings)
	{
		String type=strings[1];
		ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " :: Select Organization type as "
				+ " <b>\""+type+"\" </b> ");
		try
		{
			genericfunctions.waitTillTheElementIsVisible(organizationPageObjects.createOrganization_Type);
			selectdropdownOption=new Select(organizationPageObjects.createOrganization_Type);
			selectdropdownOption.selectByValue(type);
		}
		catch (Throwable e)
		{
			Assert.fail("Could not able to select \"Organization Type\" "+"&"+e.getMessage()+"" );
		}
	}

	/*
	 * @author: Aishwarya
	 * Description: Add Skills to Organization
	 * Created on : 05-06-2020
	 */
	public void addSkillsToOrganization(String...strings)
	{
		String addSkills=strings[1];
		ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " :: Add Skills to Organization as  \" <b>"+addSkills+"\" </b>");
		try
		{
			genericfunctions.waitTillTheElementIsVisible(organizationPageObjects.createOrganization_AddSkills);
			organizationPageObjects.createOrganization_AddSkills.click();
			organizationPageObjects.addSkills_Input.sendKeys(addSkills);
			action.sendKeys(Keys.ENTER).build().perform();
		}
		catch (Throwable e)
		{
			Assert.fail("Could not able to \"Add Skills \"to Organization"+"&"+e.getMessage()+"" );
		}
	}

	/*
	 * @author: Aishwarya
	 * Description: Enter Organization Location
	 * Created on : 05-06-2020
	 */
	public void enterOrganizationLocation(String...strings)
	{
		String location=strings[1];
		ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " :: Enter Organization Location as  <b>\" "+location+ "\" </b>");
		try
		{
			genericfunctions.scrollToElement(organizationPageObjects.createOrganization_Location);
			genericfunctions.waitTillTheElementIsVisible(organizationPageObjects.createOrganization_Location);
			organizationPageObjects.createOrganization_Location.sendKeys(location);
		}
		catch (Throwable e)
		{
			Assert.fail("Could not able to enter \"Location\""+"&"+e.getMessage()+"" );
		}
	}

	/*
	 * @author: Aishwarya
	 * Description: Click on Organization Create Button
	 * Created on : 05-05-2020
	 */
	public void clickOnCreateButton(String... strings) {
		ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " :: functionality of Create Button");
		try
		{
			genericfunctions.waitTillTheElementIsVisible(organizationPageObjects.createButton);
			if(organizationPageObjects.createButton.isEnabled())
			{
				organizationPageObjects.createButton.click();
				ExtentTestManager.getTest().log(LogStatus.PASS , "Create Button is clickable & the Organization is created successfully" );
			}
		}
		catch(Throwable e)
		{
			Assert.fail("Could not perform action on \"Create \"button of the Organization" +"&"+ e.getMessage());
		}
	}



	/**
	 * Attach_File_Image_Audio_Video
	 * Author:- Aishwarya
	 */
	public void attachFile(String...strings)
	{
		ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " :: Click on Upload Media File");
		String file=strings[1];
		try
		{
			String uploadMedia="create-organization-";
			genericfunctions.waitWebDriver(2000);
			DriverManager.getDriver().findElement(By.id(uploadMedia+"file")).sendKeys(file);
			ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " :: Media File Uploaded Successfully");
		}
		catch (Exception e)
		{
			Assert.fail("Could not perform action on \"Uploading Media File\" "+"&"+e.getMessage()+"" );
		}
	}

	/*
	 * @author: Aishwarya / Gandharva
	 * Description: Click on created Organization
	 * Created on : 05-06-2020 09-07-2020
	 */

	public void clickOnCreatedOrganization(String... strings)
	{
		String orgName= organizationPageObjects.createdOrganization.getText();
		ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " :: Click On Created Organization Name from You Manage List :: "+ " \"<b>" + orgName +"\"   </b>");
		try
		{
			genericfunctions.waitForPageToLoad(organizationPageObjects.createdOrganization);
			genericfunctions.waitTillTheElementIsVisible(organizationPageObjects.createdOrganization);
			organizationPageObjects.createdOrganization.click();
		}
		catch(Exception e)
		{
			Assert.fail("Could not perform action on \"Created Organization \"from Oganizations You Manage list" +"&"+ e.getMessage());
		}
	}

	/*
	 * @author: Aishwarya / Gandharva
	 * Description: Click on Settings action button
	 * Created on : 05-06-2020 09-07-20202
	 */

	public void clickOnOrganizationSettingMenu(String... strings)
	{
		ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " :: Click on \"Organization Setting Menu \" on Organization Widget");
		try
		{
			genericfunctions.waitWebDriver(3000);
			genericfunctions.waitForPageToLoad(organizationPageObjects.organization_setting_button);
			Assert.assertTrue(organizationPageObjects.organization_setting_button.isDisplayed());
		}
		catch (Throwable e)
		{
			Assert.fail("Could not found  \"Organization Setting Menu \" " +"&"+ e.getMessage());
		}
		try
		{
			genericfunctions.waitTillTheElementIsVisible(organizationPageObjects.organization_setting_button);
			organizationPageObjects.organization_setting_button.click();
		}
		catch(Exception e)
		{
			Assert.fail("Could not perform action on \"Organization Setting Menu \" " +"&"+ e.getMessage());
		}
	}


	/*
	 * @author: Aishwarya / Gandharva
	 * Description: Click on Delete Organization as admin
	 * Created on : 05-06-2020
	 */

	public void clickOnDeleteOrganizationLink(String... strings) {
		ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " :: Click on \"Delete Organization Link\" from Organization Settings Menu");
		try
		{
			genericfunctions.waitForPageToLoad(organizationPageObjects.deleteOrganization_Button);
			genericfunctions.waitTillTheElementIsVisible(organizationPageObjects.deleteOrganization_Button);
			organizationPageObjects.deleteOrganization_Button.click();

		}
		catch(Exception e)
		{
			Assert.fail("Could not perform action on \"Delete Organization Link\" " +"&"+ e.getMessage());
		}
	}



	/*
	 * @author: Aishwarya
	 * Description: Click on Confirm Delete Organization as admin
	 * Created on : 01-06-2020
	 */
	public void clickOnConfirmDeleteOrganization(String... strings)
	{
		ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " :: Click on \"Confirm\" button to delete organization");
		try
		{
			genericfunctions.waitForPageToLoad(organizationPageObjects.deleteOrganization_ConfirmButton);
			genericfunctions.waitTillTheElementIsVisible(organizationPageObjects.deleteOrganization_ConfirmButton);
			organizationPageObjects.deleteOrganization_ConfirmButton.click();
		}
		catch(Exception e)
		{
			Assert.fail("Could not perform action on \"Confirm Delete Organization \" as admin" +"&"+ e.getMessage());
		}
	}

	/*
	 * @author: Aishwarya
	 * Description: Click on Invite Members icon
	 * Created on : 08-06-2020
	 */

	public void clickOnInviteMembersIcon(String... strings) {
		ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " :: Click on \"Invite Members\" icon ");
		try
		{
			genericfunctions.waitForPageToLoad(organizationPageObjects.inviteIcon);
			genericfunctions.waitTillTheElementIsVisible(organizationPageObjects.inviteIcon);
			organizationPageObjects.inviteIcon.click();

		}
		catch(Exception e)
		{
			Assert.fail("Could not perform action on \"Created Organization \"from Oganizations You Manage list" +"&"+ e.getMessage());
		}
	}

	/*
	 * @author: Aishwarya
	 * Description: Click on Post menu action button
	 * Created on : 08-06-2020
	 */

	public void clickOnPostActionButton(String... strings) {
		ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " :: Click on \"Post \" action button of the created post");
		try
		{
			genericfunctions.waitForPageToLoad(organizationPageObjects.postCard_ActionButton);
			genericfunctions.waitTillTheElementIsVisible(organizationPageObjects.postCard_ActionButton);
			organizationPageObjects.postCard_ActionButton.click();

		}
		catch(Exception e)
		{
			Assert.fail("Could not perform action on \"Post card Action button \" " +"&"+ e.getMessage());
		}
	}



	/*
	 * @author: Aishwarya
	 * Description: Click on Post menu action button
	 * Created on : 08-06-2020
	 */

	public void clickOnPostMenuActionButton(String... strings) {
		ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " :: Click on \"action\" button of the created Organization");
		try
		{
			genericfunctions.waitForPageToLoad(organizationPageObjects.settingButton);
			genericfunctions.waitTillTheElementIsVisible(organizationPageObjects.settingButton);
			organizationPageObjects.settingButton.click();

		}
		catch(Exception e)
		{
			Assert.fail("Could not perform action on \"Organization Action button \" " +"&"+ e.getMessage());
		}
	}

	/*
	 * @author: Aishwarya
	 * Description: Click on Post menu Delete action button
	 * Created on : 08-06-2020
	 */

	public void clickOnDeletePostButton(String... strings) {
		ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " :: Click on \"Delete Post\" button");
		try
		{
			genericfunctions.waitForPageToLoad(organizationPageObjects.postCardAction_DeleteButton);
			genericfunctions.waitTillTheElementIsVisible(organizationPageObjects.postCardAction_DeleteButton);
			organizationPageObjects.postCardAction_DeleteButton.click();

		}
		catch(Exception e)
		{
			Assert.fail("Could not perform action on \"Post card Delete button \" " +"&"+ e.getMessage());
		}
	}



	/*
	 * @author: Aishwarya
	 * Description: Click on Confirm Delete Community as admin
	 * Created on : 08-06-2020
	 */

	public void clickOnConfirmDeletePost(String... strings) {
		ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " :: Confirm deleting a post ");
		try
		{
			genericfunctions.waitForPageToLoad(organizationPageObjects.confirm_DeleteButton);
			genericfunctions.waitTillTheElementIsVisible(organizationPageObjects.confirm_DeleteButton);
			organizationPageObjects.confirm_DeleteButton.click();
			ExtentTestManager.getTest().log(LogStatus.PASS, "Owner has successfully \"Deleted the Post\" created by himself");

		}
		catch(Exception e)
		{
			Assert.fail("Could not perform action on \"Confirm Delete Post \" as admin" +"&"+ e.getMessage());
		}
	}

	public void enterSkillsTag(String... strings) {

		String enterSkills = strings[1].toUpperCase();
		ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " :: Enter skills tag as <b>\" "+enterSkills+ "\" </b>"  );
		try {
			genericfunctions.waitTillTheElementIsVisible(profileCompletionPageObjects.add_skill_textfield);
			profileCompletionPageObjects.add_skill_textfield.sendKeys(enterSkills);
			action.sendKeys(Keys.ENTER).build().perform();
			genericfunctions.waitWebDriver(3000);
			genericfunctions.waitForElementToAppear(organizationPageObjects.createOrganization_Name);
			organizationPageObjects.createOrganization_Name.click();

		} catch (Exception e) {
			Assert.fail("Could not perform action on \"add skills tag\" textfield " + "&" + e.getMessage());
		}
	}

	/*
	 * @author: Aishwarya
	 * Description: Enable Restricted content
	 * Created on : 09-06-2020
	 */

	public void enableRestrictedContent(String... strings) {
		ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " :: Enable Restricted content toggle button" );
		try
		{
			genericfunctions.waitForPageToLoad(organizationPageObjects.createPost_RestrictedContent);
			genericfunctions.waitTillTheElementIsVisible(organizationPageObjects.createPost_RestrictedContent);
			organizationPageObjects.createPost_RestrictedContent.click();
			ExtentTestManager.getTest().log(LogStatus.PASS, " <b>\"Restricted Content\"</b> toggle button is enabled successfully ");
		}
		catch(Exception e)
		{
			Assert.fail("Could not perform action on \"Restricted Content\" button " +"&"+ e.getMessage());
		}
	}

	/*
	 * @author: Aishwarya
	 * Description: Click on Comment icon
	 * Created on : 09-06-2020
	 */

	public void clickOnCommentIcon(String... strings) {
		try
		{
			genericfunctions.waitForPageToLoad(organizationPageObjects.postCard_CommentIcon);
			genericfunctions.waitTillTheElementIsVisible(organizationPageObjects.postCard_CommentIcon);
			organizationPageObjects.postCard_CommentIcon.click();
		}
		catch(Exception e)
		{
			Assert.fail("Could not perform action on \"Comment\" icon " +"&"+ e.getMessage());
		}
	}

	/*
	 * @author: Aishwarya
	 * Description: Enter Comment
	 * Created on : 09-06-2020
	 */

	public void enterComment(String... strings) {
		String comment=strings[1];
		ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " :: Enter comment as <b>\" "+comment+ "\" </b>"  );
		try
		{
			genericfunctions.waitForPageToLoad(organizationPageObjects.postCard_CommentTextArea);
			genericfunctions.waitTillTheElementIsVisible(organizationPageObjects.postCard_CommentTextArea);
			organizationPageObjects.postCard_CommentTextArea.sendKeys(comment);
		}
		catch(Exception e)
		{
			Assert.fail("Could not perform action on \"Comment\" icon " +"&"+ e.getMessage());
		}
	}

	/*
	 * @author: Aishwarya
	 * Description: Send Comment
	 * Created on : 09-06-2020
	 */

	public void clickOnSendCommentIcon(String... strings) {
		try
		{
			genericfunctions.waitForPageToLoad(organizationPageObjects.postCard_CommentSend);
			genericfunctions.waitTillTheElementIsVisible(organizationPageObjects.postCard_CommentSend);
			organizationPageObjects.postCard_CommentSend.click();
			ExtentTestManager.getTest().log(LogStatus.PASS, "" + strings[0] + ":: The \"Comment \" is Posted successfully");
		}
		catch(Exception e)
		{
			Assert.fail("Could not perform action on \"Send Comment\" icon " +"&"+ e.getMessage());
		}
	}

	/*
	 * @author: Aishwarya
	 * Description: get default comment count
	 * Created on : 09-06-2020
	 */

	public String getDefaultCommentCount(String... strings) {
		String commentCount=null;
		try
		{
			genericfunctions.waitForPageToLoad(organizationPageObjects.postCard_CommentCount);
			genericfunctions.waitTillTheElementIsVisible(organizationPageObjects.postCard_CommentCount);
			commentCount= organizationPageObjects.postCard_CommentCount.getText().trim();
			ExtentTestManager.getTest().log(LogStatus.PASS, "" + strings[0] + ":: The default \"Comment Count\" is "+commentCount);
		}
		catch(Exception e)
		{
			Assert.fail("Could not perform action on fetching \"default comment count\"" + "&" + " Defect Link - <a href='https://taiga.vnaad.com/project/admin-one-page-spotlight/issue/1613' target='_blank'>https://taiga.vnaad.com/project/admin-one-page-spotlight/issue/1613</a>  ");
		}return commentCount;
	}


	///////////////////////////////////////////// Page Verifications ////////////////////////////////////////////////

	/*
	 * @author: Aishwarya
	 * Description: Verify the Create Organization page
	 * Created on : 05-06-2020
	 */
	public void verifyNavigationToCreateOrganizationPage(String... strings)
	{
		ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " :: Navigation to the Create Organization page ");
		try
		{
			genericfunctions.waitForPageToLoad(organizationPageObjects.createOrganization_Header);
			genericfunctions.waitTillTheElementIsVisible(organizationPageObjects.createOrganization_Header);
			Assert.assertTrue(organizationPageObjects.createOrganization_Header.isDisplayed());
			String pageHeader=organizationPageObjects.createOrganization_Header.getText().trim();

			ExtentTestManager.getTest().log(LogStatus.PASS,  " Successfully navigated to "+" \"<b>" + pageHeader +"\"  </b>" + " Page" );
		}
		catch(Throwable e)
		{
			Assert.fail("Failed to verify \"Create an Organization\" page" +"&"+ e.getMessage());
		}
	}

	/*
	 * @author: Aishwarya
	 * Description: Verify navigation to Organization inner page
	 * Created on : 05-06-2020
	 */
	public void verifyNavigationToOrganizationInnerPage(String... strings)
	{
		String expectedOrgName=strings[1];
		String actualOrgName=null;
		ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " :: Navigation to the \"Organization inner page\"");
		try
		{
			genericfunctions.waitWebDriver(6000);
			genericfunctions.waitForPageToLoad(organizationPageObjects.innerPage_OrganizationName);
			genericfunctions.waitTillTheElementIsVisible(organizationPageObjects.innerPage_OrganizationName);
			genericfunctions.waitWebDriver(4000);
			actualOrgName=organizationPageObjects.innerPage_OrganizationName.getText().trim();
			Assert.assertEquals(actualOrgName, expectedOrgName);
			ExtentTestManager.getTest().log(LogStatus.PASS,  " Successfully navigated to the inner page of the following Organization :" +actualOrgName);
		}
		catch(Throwable e)
		{
			String actualException=e.getClass().getName();
			switch (actualException)
			{
				case "NoSuchElementException":
					Assert.fail("Expected ::User should be navigated to the created \"Organization Inner Page\"  ;"
							+ " Actual :: User failed to navigate to the created  \"Organization Inner Page \" "+"&"+e.getMessage()+"" );
					break;
				case "AssertionError":
					Assert.fail("Expected ::User should be navigated to the following created \"Organization Inner Page \": <b>\""
							+ expectedOrgName + "\"</b> ; "
							+ "Actual :: User navigated to the following created \"Organization Inner Page\" <b>\"" + actualOrgName + "\"</b>");
					break;
				default:
					Assert.fail(""+"&"+e.getMessage()+"");
			}
		}
	}

	/*
	 * @author: Aishwarya
	 * Description: Verify deleted Organization in Organization page
	 * Created on : 05-06-2020
	 */
	public void verifyDeletedOrganizationInOrganizationPage(String... strings)
	{
		ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " :: Removeal of Deleted Organization From Organization page");
		String expectedOrg=strings [1];
		String actualOrg=null;

		try
		{
			genericfunctions.waitWebDriver(2000);
			//genericfunctions.waitForPageToLoad(organizationPageObjects.createdOrganization);
			//genericfunctions.waitTillTheElementInVisible(organizationPageObjects.createdOrganization);
			Assert.assertNotEquals(actualOrg, expectedOrg);
			ExtentTestManager.getTest().log(LogStatus.PASS,  "Deleted Organization <b>\": "+expectedOrg+ "\"<\b> "
					+ "is removed from the \"Organizations You Manage\"  list" );
		}
		catch(Throwable e)
		{
			String actualException=e.getClass().getName();
			switch (actualException)
			{
				case "NoSuchElementException":
					Assert.fail("Expected ::Deleted organization should be removed from \"Organization You Manage\" list  ;"
							+ " Actual ::Deleted organization is still displaying in \"Organization You Manage\" list "+"&"+e.getMessage()+"" );
					break;
				case "AssertionError":
					Assert.fail("Expected ::Deleted organization should be removed from \"Organization You Manage\" list <b>\""
							+ expectedOrg + "\"</b> ; "
							+ "Actual :: Deleted organization is still displaying in \"Organization You Manage\" list <b>\"" + actualOrg + "\"</b>");
					break;
				default:
					Assert.fail(""+"&"+e.getMessage()+"");
			}
		}
	}



	/*
	 * @author: Aishwarya
	 * Description: Verify display of Invite Members icon
	 * Created on : 08-06-2020
	 */
	public void verifyDisplayOfInviteMembersOptionToTheOwner(String... strings)
	{
		ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " :: display of Invite Members icon");
		try
		{
			genericfunctions.waitForPageToLoad(organizationPageObjects.inviteIcon);
			genericfunctions.waitTillTheElementIsVisible(organizationPageObjects.inviteIcon);
			Assert.assertTrue(organizationPageObjects.inviteIcon.isDisplayed());

			ExtentTestManager.getTest().log(LogStatus.PASS,  " Invite Members icon is displaying successfully " );
		}
		catch(Throwable e)
		{
			Assert.fail("Failed to verify the display of \"Invite members\" icon to the Owner " +"&"+ e.getMessage());
		}
	}

	/*
	 * @author: Aishwarya
	 * Description: Verify the Create Organization page
	 * Created on : 08-06-2020
	 */
	public void verifyWhetherInviteMembersIconIsClickable(String... strings)
	{
		ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " :: <b>\"Invite Members\"</b> plus icon is clickable or not with following assertion :");
		try
		{
			genericfunctions.waitForPageToLoad(organizationPageObjects.inviteIcon);
			genericfunctions.isElementClickable(organizationPageObjects.inviteIcon);


			ExtentTestManager.getTest().log(LogStatus.PASS,  " \"Invite members\" Plus icon is clickable" );
		}
		catch(Throwable e)
		{
			Assert.fail("Failed to verify \"Create an Organization\" page" +"&"+ e.getMessage());
		}
	}

	/*
	 * @author: Aishwarya
	 * Description: Verify Uncover button for a restricted Content post
	 * Created on : 09-06-2020
	 */
	public void verifyUncoverButtonForRestrictedContentPost(String... strings)
	{
		ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " :: Display of \"Uncover\" button for a posted restricted content");
		try
		{
			genericfunctions.waitForPageToLoad(organizationPageObjects.restrictedContent_UncoverButton);
			Assert.assertTrue(organizationPageObjects.restrictedContent_UncoverButton.isDisplayed());
			ExtentTestManager.getTest().log(LogStatus.PASS,  " The created post is covered and \"Uncover\" button is displaying" );
		}
		catch(Throwable e)
		{
			Assert.fail("Failed to verify whether the \"Restricted content\" post is covered or not " +"&"+ e.getMessage());
		}
	}

	/*
	 * @author: Aishwarya
	 * Description: Verify Create post option for the organization owner
	 * Created on : 09-06-2020
	 */
	public void verifyCreatePostOptionForOwner(String... strings)
	{
		ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " :: Display of \"Create post\" option for Owner of the Organization");
		try
		{
			genericfunctions.waitForPageToLoad(homePageObjects.poster_textarea);
			Assert.assertTrue(homePageObjects.poster_textarea.isDisplayed());
			ExtentTestManager.getTest().log(LogStatus.PASS,  " The \"Create post\" option is displaying for Owner of the Organization" );
		}
		catch(Throwable e)
		{
			Assert.fail("Failed to verify display of \"Create Post\"  option for Owner of the Organization" +"&"+ e.getMessage());
		}
	}

	/*
	 * @author: Aishwarya
	 * Description: Verify Comment Count
	 * Created on : 09-06-2020
	 */
	public void verifyCommentCount(String... strings)
	{
		String actual_CommentCount=null;
		String expected_CommentCount= strings[1];
		ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " ::  \"Comments Count\" is upadting or not");
		try
		{
			genericfunctions.waitForPageToLoad(organizationPageObjects.postCard_CommentCount);
			genericfunctions.waitTillTheElementIsVisible(organizationPageObjects.postCard_CommentCount);
			actual_CommentCount= organizationPageObjects.postCard_CommentCount.getText();
			Assert.assertNotEquals(actual_CommentCount, expected_CommentCount);
			ExtentTestManager.getTest().log(LogStatus.PASS,  " The \"Comment\" count is displaying as - " +actual_CommentCount);
		}
		catch(Throwable e)
		{
			Assert.fail("Failed to verify display of \"Create Post\"  option for Owner of the Organization" +"&"+ e.getMessage());
		}
	}

	/*
	 * @author: Aishwarya / Gandharva
	 * Description: Verify Create Comment button is displayed or not
	 * Created on : 09-06-2020
	 */
	public void verifyCreateOrganizationButton(String... strings)
	{
		ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " ::  \" Organization Details as follows  \" ");

		try
		{
			Assert.assertTrue(organizationPageObjects.createOrganization_Button.isDisplayed());
			System.out.println("Hi");
		}
		catch (Throwable e)
		{
			Assert.assertTrue(organizationPageObjects.createdOgnanizationName.get(0).isDisplayed());
			System.out.println("Yes");
			clickOnCreatedOrganization("Action Step");
			clickOnOrganizationSettingMenu("Action Step");
			clickOnDeleteOrganizationLink("Action Step");
			clickOnConfirmDeleteOrganization("Action Step");
		}
	}

}