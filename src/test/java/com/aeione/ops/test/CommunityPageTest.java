package com.aeione.ops.test;

import com.aeione.ops.generic.GoogleDriveAPI;
import com.aeione.ops.generic.GoogleSheetAPI;
import com.aeione.ops.generic.TestSetUp;
import com.aeione.ops.pageactions.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Map;

public class CommunityPageTest extends TestSetUp
{
	public LoginPageActions getLoginPage() throws IOException {
		return new LoginPageActions();
	}

	public HomePageActions getHomePageActions() throws IOException {
		return new HomePageActions();
	}

	public EventPageActions getEventPageActions() throws IOException {
		return new EventPageActions();
	}

	public CommunityPageActions getCommunityPageActions() throws IOException {
		return new CommunityPageActions();
	}

	public ProfilePageActions getProfilePageActions() throws IOException {
		return new ProfilePageActions();
	}

	public GoogleSheetAPI sheetAPI() throws IOException {
		return new GoogleSheetAPI();
	}

	public GoogleDriveAPI dsriveAPI() throws IOException {
		return new GoogleDriveAPI();
	}

	/*
	 * @author:Aishwarya
	 * Description: Verify creating a public community
	 * Created on : 05-05-2020
	 */
	@Test(priority =129, enabled = true, alwaysRun = true, description = "Verify Create Public Community")
	public void tc_CM_02_and_CM_12_P1_VerifyCreatingPublicCommunityTest() throws Exception
	{

		String range = "Login!A14:C14";
		String username = null;
		String password = null;
		String fullname = null;

		Map<String, String> values= sheetAPI().getSpreadSheetRowValueByColumnName(TEST_DATA_GOOGLESHEET, range);
		username=values.get("UserName / Email / PhoneNumber");
		password=values.get("Password");
		fullname=values.get("FullName");

		String range1 = "Community!A2:C2";
		String communityName=null;
		String description=null;
		String hashtag=null;

		Map<String, String> val1 = sheetAPI().getSpreadSheetRowValueByColumnName(TEST_DATA_GOOGLESHEET, range1);
		communityName=val1.get("Community_Name");
		description=val1.get("Description");
		hashtag=val1.get("Hashtag");

		dsriveAPI().downloadFileFromGoogleDrive(TEST_IMAGE_ID1);
		String imageFile = userDirPath + IMAGE_TEST_FILE1;

		getLoginPage().logIn("Action Step" ,fullname , "valid registered Username & password",username, password);
		getEventPageActions().clickOnGroupIconFromHeader("Action Step");
		getCommunityPageActions().clickOnCreateCommunityFromGroupLink("Action Step");
		getCommunityPageActions().enterCommunityName("Action Step", communityName);
		getCommunityPageActions().enterCommunityDescription("Action Step", description);
		getCommunityPageActions().enterCommunityHashtag("Action Step", hashtag);
		getCommunityPageActions().attachFile("Action Step",imageFile);
		getProfilePageActions().clickOnApplyButtonOfEditPicturePopUp("Action Step");
		getCommunityPageActions().clickOnCreatebutton("Verify Step");
		getCommunityPageActions().verifyCommunityInnerPage("Verify Step", communityName );
	}


	/*
	 * @author:Aishwarya
	 * Description: Verify converting a public community to private community 
	 * Created on : 05-05-2020
	 */

	@Test(priority = 130, enabled = true, alwaysRun = true, description = "Verify converting a public community to private community")
	public void tc_CM_04_P1_VerifyConvertingPublicCommunityToPrivateTest() throws Exception
	{
		getCommunityPageActions().clickOnCommunityTabFromHomePage("Action Step");
		getCommunityPageActions().clickOnCommunityFromCommunitiesYouManageList("Action Step");
		getCommunityPageActions().clickOnSettingsActionButton("Action Step");
		getCommunityPageActions().clickOnMakeClosedOption("Action Step");
		getCommunityPageActions().verifyConvertingCommunityFromPublicToPrivate("verify Step");
	}


	/*
	 * @author:Aishwarya
	 * Description: Verify Invite members by creating private community
	 * Created on : 05-05-2020
	 */

	@Test(priority = 131, enabled = true, alwaysRun = true, description = "Verify Invite members by creating private community")
	public void tc_CM_03_and_CM_12_P1_InviteMembersInPrivateCommunityTest() throws Exception
	{		
		String range1 = "Community!A3:E3";
		String communityName=null;
		String description=null;
		String hashtag=null;
		String userName_Invite=null;

		Map<String, String> val1 = sheetAPI().getSpreadSheetRowValueByColumnName(TEST_DATA_GOOGLESHEET, range1);
		communityName=val1.get("Community_Name");
		description=val1.get("Description");
		hashtag=val1.get("Hashtag");
		userName_Invite=val1.get("Invite_Member");

		dsriveAPI().downloadFileFromGoogleDrive(TEST_IMAGE_ID1);
		String imageFile = userDirPath + IMAGE_TEST_FILE1;

		getEventPageActions().clickOnGroupIconFromHeader("Action Step");
		getCommunityPageActions().clickOnCreateCommunityFromGroupLink("Action Step");
		getCommunityPageActions().clickOnPrivateCommunityType("Action Type");
		getCommunityPageActions().enterCommunityName("Action Step", communityName);
		getCommunityPageActions().enterCommunityDescription("Action Step", description);
		//getCommunityPageActions().enterCommunityHashtag("Action Step", hashtag);
		getCommunityPageActions().attachFile("Action Step",imageFile);
		getProfilePageActions().clickOnApplyButtonOfEditPicturePopUp("Action Step");
		getCommunityPageActions().clickOnCreatebutton("Verify Step");
		getCommunityPageActions().verifyCommunityInnerPage("Verify Step", communityName );
		getCommunityPageActions().clickOnPlusIconToInviteMembers("Action Step");
		getCommunityPageActions().clickOnSearchMembersTextField("Action Step");
		getCommunityPageActions().enterUsernameInSearchField("Action Step", userName_Invite);
		getCommunityPageActions().clickOnInvitebutton("Verify Step"); 
	}

	/*
	 * @author:Aishwarya
	 * Description: Verify deleting a community
	 * Created on : 01-06-2020
	 */

	@Test(priority = 132, enabled = true, alwaysRun = true, description = "Verify \"Deleting\" the community as Admin")
	public void tc_CM_05_P1_VerifyDeletingCommunityAsAdminTest() throws Exception
	{
		getCommunityPageActions().clickOnCommunityTabFromHomePage("Action Step");
		getCommunityPageActions().clickOnCommunityFromCommunitiesYouManageList("Action Step");
		String community=getCommunityPageActions().getCommunityName("Action Step");
		getCommunityPageActions().clickOnSettingsActionButton("Action Step");
		getCommunityPageActions().verifyDeleteCommunityOption("Verify Step");
		getCommunityPageActions().clickOnDeleteCommunity("Action Step");
		getCommunityPageActions().clickOnConfirmDeleteCommunity("Verify step");
		getCommunityPageActions().verifyDeletedCommunityInCommunityList("Verify Step", community);
	}

	/*
	 * @author:Aishwarya
	 * Description: Verify creating a post in community as admin
	 * Created on : 01-06-2020
	 */

	@Test(priority = 133, enabled = true, alwaysRun = true, description = "Verify \"Create Post\" in community as admin")
	public void tc_CM_06_P1_VerifyCreatingPostInCommunityAsAdminTest() throws Exception
	{
		String textPostVal = null;
		String range = "Community!D2:E1";
		Map<String, String> val = sheetAPI().getSpreadSheetRowValueByColumnName(TEST_DATA_GOOGLESHEET, range);
		textPostVal= val.get("Text_Post");

		getCommunityPageActions().clickOnCommunityTabFromHomePage("Action Step");
		getCommunityPageActions().clickOnCommunityFromCommunitiesYouManageList("Action Step");
		getHomePageActions().clickOnPosterTextArea("Action Step");
		getHomePageActions().enterTextOnMessageTextArea("Action Step", textPostVal);
		getHomePageActions().clickOnPostButton("Action step");
		getProfilePageActions().verifyDisplayOfPostedText("Verify Step" , textPostVal);

	}
	/*
	 * @author:Aishwarya
	 * Description: Verify joining a community
	 * Created on : 02-06-2020
		*/
	@Test(priority = 134, enabled = true, alwaysRun = true, description = "Verify \"Join community\" in community ")
	public void tc_CM_09_P1_VerifyJoiningCommunityTest() throws Exception
	{
		getCommunityPageActions().clickOnCommunityTabFromHomePage("Action Step");
		getCommunityPageActions().verifyJoiningCommunity("Verify Step");
	}


	/*
	 * @author:Aishwarya
	 * Description: Verify changing community Settings
	 * Created on : 02-06-2020
	 */
	@Test(priority = 135, enabled = true, alwaysRun = true, description = "Verify changing \"Community Settings \" as admin")
	public void tc_CM_07_P1_VerifyChangingCommunitySettingsTest() throws Exception
	{
		getCommunityPageActions().clickOnCommunityTabFromHomePage("Action Step");
		getCommunityPageActions().clickOnCommunityFromCommunitiesYouManageList("Action Step");
		getCommunityPageActions().clickOnSettingsActionButton("Action Step");
		getCommunityPageActions().clickOnDisableGathering("Verify Step");
		getCommunityPageActions().clickOnMakeClosedOption("Action Step");
		getCommunityPageActions().clickOnDisableNotifications("Verify Step");
	}

	/*
	 * @author:Aishwarya
	 * Description: Verify Updated Settings of community as admin
	 * Created on : 02-06-2020
	 */
	@Test(priority = 136, enabled = true, alwaysRun = true, description = "Verify \"Updated Settings \" of community as admin")
	public void tc_CM_08_P1_VerifyUpdatedSettingsOfCommunityTest() throws Exception
	{
		getCommunityPageActions().clickOnCommunityTabFromHomePage("Action Step");
		getCommunityPageActions().clickOnCommunityFromCommunitiesYouManageList("Action Step");
		getCommunityPageActions().clickOnSettingsActionButton("Action Step");
		getCommunityPageActions().verifyConvertingCommunityFromPublicToPrivate("Verify Step");

	}

	/*
	 * @author:Aishwarya
	 * Description: After method which works as pre-condition to the next test script execution
	 * Created on : 29-05-2020
	 */
	@AfterMethod(dependsOnMethods={"com.aeione.ops.generic.TestSetUp.afterMethod"})
	public void after() throws IOException
	{
		getHomePageActions().navigateHomePage();
		System.out.println("After method got executed ");
	}


}
