package com.aeione.ops.test;

import com.aeione.ops.generic.*;
import com.aeione.ops.pageactions.*;
import com.aeione.ops.pageobjects.HomePageObjects;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Map;

public class OrganizationPageTest extends TestSetUp
{
	GenericFunctions genericfunctions;
	HomePageObjects homepageobjects = new HomePageObjects();
	HomePageObjects organizationpageobjects = new HomePageObjects();
	Actions actions = null;


	public void ProfilePageActions() throws IOException {
		genericfunctions = new GenericFunctions(DriverManager.getDriver());
		PageFactory.initElements(DriverManager.getDriver(), this);
		PageFactory.initElements(DriverManager.getDriver(), homepageobjects);
		PageFactory.initElements(DriverManager.getDriver(), organizationpageobjects);
		actions = new Actions(DriverManager.getDriver());
	}

	public LoginPageActions getLoginPage() throws IOException {
		return new LoginPageActions();
	}

	public HomePageActions getHomePageActions() throws IOException {
		return new HomePageActions();
	}

	public ProfilePageActions getProfilePageActions() throws IOException {
		return new ProfilePageActions();
	}
	public ProfileCompletionPageActions getProfileCompletionPageActions() throws IOException {
		return new ProfileCompletionPageActions();
	}

	public OrganizationPageActions getOrganizationPageActions() throws IOException {
		return new OrganizationPageActions();
	}

	public GoogleSheetAPI sheetAPI() throws IOException {
		return new GoogleSheetAPI();
	}

	public GoogleDriveAPI dsriveAPI() throws IOException {
		return new GoogleDriveAPI();
	}

	/*
	 * @author:Aishwarya
	 * Description: Verify functionality of Create organization button
	 * Created on : 05-05-2020
	 */

	@Test(priority = 105, enabled = true, alwaysRun = true, description = "Verify functionality of Create organization button")
	public void tc_ORG_01_P1_VerifyFunctionalityOfCreateOrganizationButtonTest() throws Exception
	{
		String range = "Login!A14:C14";
		String username = null;
		String password = null;
		String fullname = null;

		Map<String, String> loginvalues = sheetAPI().getSpreadSheetRowValueByColumnName(TEST_DATA_GOOGLESHEET, range);
		username=loginvalues.get("UserName / Email / PhoneNumber");
		password=loginvalues.get("Password");
		fullname=loginvalues.get("FullName");

		getLoginPage().logIn("Action Step", fullname, "valid username, password", username, password);
		getHomePageActions().clickOnTopBarDropdown("Action Step");        
		getOrganizationPageActions().clickOnOrganizationLink("Action Step");
		getOrganizationPageActions().verifyCreateOrganizationButton("Verify Step");
		getOrganizationPageActions().clickOnCreateOrganizationButton("Action Step");
		getOrganizationPageActions().verifyNavigationToCreateOrganizationPage("Verify Step");
	}

	/*
	 * @author:Aishwarya
	 * Description: Verify functionality of Create organization button
	 * Created on : 05-05-2020
	*/
	@Test(priority = 106, enabled = false, alwaysRun = true, description = "Verify functionality of Create organization button")
	public void tc_ORG_02_P1_CreateAndVerifyOrganizationTest() throws Exception
	{

		String range = "Organization!A2:D2";
		String name = null;
		String type = null;
		String addSkills = null;
		String location = null;

		Map<String, String> values= sheetAPI().getSpreadSheetRowValueByColumnName(TEST_DATA_GOOGLESHEET, range);
		name = values.get("Name");
		type = values.get("Type");
		addSkills = values.get("Add_Skills");
		location = values.get("Location");

		dsriveAPI().downloadFileFromGoogleDrive(TEST_IMAGE_ID1);
		String imageFile = userDirPath + IMAGE_TEST_FILE1;

		getHomePageActions().clickOnTopBarDropdown("Action Step");        
		getOrganizationPageActions().clickOnOrganizationLink("Action Step");
		getOrganizationPageActions().clickOnCreateOrganizationButton("Action Step");
		getOrganizationPageActions().enterOrganizationName("Action Step", name );
		getOrganizationPageActions().selectOrganizationType("Action Step", type);
		//getOrganizationPageActions().addSkillsToOrganization("Action Step", addSkills);
		//getOrganizationPageActions().enterSkillsTag("Action Step", addSkills.split(",")[1]);
		getOrganizationPageActions().enterOrganizationLocation("Action Step", location);
		getOrganizationPageActions().attachFile("Action Step", imageFile);
		getProfilePageActions().clickOnApplyButtonOfEditPicturePopUp("Action Step");
		getOrganizationPageActions().clickOnCreateButton("Verify Step");
		getOrganizationPageActions().verifyNavigationToOrganizationInnerPage("Verify Step", name);
	}

/*

	 * @author:Aishwarya
	 * Description: Verify deleting the organization
	 * Created on : 05-05-2020
	 *
*/

	@Test(priority = 107, enabled = false, alwaysRun = true, description = "Verify functionality of Invite members icon")
	public void tc_ORG_03_P1_VerifyInviteMembersIconAsOwnerTest() throws Exception
	{
		getHomePageActions().clickOnTopBarDropdown("Action Step");        
		getOrganizationPageActions().clickOnOrganizationLink("Action Step");
		getOrganizationPageActions().clickOnCreatedOrganization("Action Step");
		getOrganizationPageActions().verifyDisplayOfInviteMembersOptionToTheOwner("Verify Step");
		getOrganizationPageActions().verifyWhetherInviteMembersIconIsClickable("Verify Step");
	}

	/*
	 * @author:Aishwarya
	 * Description: Verify creating Text post as owner
	 * Created on : 05-05-2020
	 */

	@Test(priority = 108, enabled = false, alwaysRun = true, description = "Verify creating Text post as owner")
	public void tc_ORG_04_P1_VerifyCreatingTextPostAsOwnerTest() throws Exception
	{
		String range = "Organization!E2:F2";
		String textPostVal = null;
		Map<String, String> values= sheetAPI().getSpreadSheetRowValueByColumnName(TEST_DATA_GOOGLESHEET, range);
		textPostVal = values.get("TextPost");

		getHomePageActions().clickOnTopBarDropdown("Action Step");        
		getOrganizationPageActions().clickOnOrganizationLink("Action Step");
		getOrganizationPageActions().clickOnCreatedOrganization("Action Step");
		getHomePageActions().clickOnPosterTextArea("Action Step");
		getHomePageActions().enterTextOnMessageTextArea("Action Step", textPostVal);
		getHomePageActions().clickOnPostButton("Action step");
		getProfilePageActions().verifyDisplayOfPostedText("Verify Step" , textPostVal);
	}

	/*
	 * @author:Aishwarya
	 * Description: Verify Deleting the uploaded post as owner
	 * Created on : 05-05-2020
	 */

	@Test(priority = 109, enabled = false, alwaysRun = true, description = "Verify Deleting the uploaded post as owner")
	public void tc_ORG_05_P1_VerifyDeletingPostAsOwnerTest() throws Exception
	{
		String range = "Organization!E2:F2";
		String textPostVal = null;
		Map<String, String> values= sheetAPI().getSpreadSheetRowValueByColumnName(TEST_DATA_GOOGLESHEET, range);
		textPostVal = values.get("TextPost");

		getHomePageActions().clickOnTopBarDropdown("Action Step");        
		getOrganizationPageActions().clickOnOrganizationLink("Action Step");
		getOrganizationPageActions().clickOnCreatedOrganization("Action Step");
		getOrganizationPageActions().clickOnPostMenuActionButton("Action Step");
		getOrganizationPageActions().clickOnDeletePostButton("Action Step");
		getOrganizationPageActions().clickOnConfirmDeletePost("Verify Step");
	}

	/*
	 * @author:Aishwarya
	 * Description: Verify Creating Restricted post as owner
	 * Created on : 09-06-2020
	 */

	@Test(priority = 110, enabled = false, alwaysRun = true, description = "Verify Creating Restricted post as owner")
	public void tc_ORG_06_P1_VerifyCreatingRestrictedPostTest() throws Exception
	{
		String range = "Organization!E2:F2";
		String textPostVal = null;
		Map<String, String> values= sheetAPI().getSpreadSheetRowValueByColumnName(TEST_DATA_GOOGLESHEET, range);
		textPostVal = values.get("TextPost");

		getHomePageActions().clickOnTopBarDropdown("Action Step");        
		getOrganizationPageActions().clickOnOrganizationLink("Action Step");
		getOrganizationPageActions().clickOnCreatedOrganization("Action Step");
		getHomePageActions().clickOnPosterTextArea("Action Step");
		getHomePageActions().enterTextOnMessageTextArea("Action Step", textPostVal);
		getOrganizationPageActions().enableRestrictedContent("Verify Step");
		getHomePageActions().clickOnPostButton("Action step");
		getOrganizationPageActions().verifyUncoverButtonForRestrictedContentPost("Verify Step");

	}

	/*
	 * @author:Aishwarya
	 * Description: Verify Create Post functionality for Owner
	 * Created on : 09-06-2020
	 */

	@Test(priority = 111, enabled = false, alwaysRun = true, description = "Verify Creating a post as owner")
	public void tc_ORG_07_P1_VerifyCreatePostFunctionalityForOwnerTest() throws Exception
	{
		String range = "Organization!E2:F2";
		String textPostVal = null;
		Map<String, String> values= sheetAPI().getSpreadSheetRowValueByColumnName(TEST_DATA_GOOGLESHEET, range);
		textPostVal = values.get("TextPost");

		getHomePageActions().clickOnTopBarDropdown("Action Step");        
		getOrganizationPageActions().clickOnOrganizationLink("Action Step");
		getOrganizationPageActions().clickOnCreatedOrganization("Action Step");
		getOrganizationPageActions().verifyCreatePostOptionForOwner("verify Step");
		getHomePageActions().clickOnPosterTextArea("Action Step");
		getHomePageActions().enterTextOnMessageTextArea("Action Step", textPostVal);
		getHomePageActions().clickOnPostButton("Action step");
		getProfilePageActions().verifyDisplayOfPostedText("Verify Step" , textPostVal);

	}

	/*
	 * @author:Aishwarya
	 * Description: Verify comment functionality for Created Post functionality as Owner
	 * Created on : 09-06-2020
	 */

	@Test(priority = 112, enabled = false, alwaysRun = true, description = "Verify \"Comment functionality\" for Created Post functionality as Owner")
	public void tc_ORG_08_P1_VerifyCommentFunctionalityForPostAsOwnerTest() throws Exception
	{
		String range = "Organization!F2:G2";
		String commentVal = null;
		Map<String, String> values= sheetAPI().getSpreadSheetRowValueByColumnName(TEST_DATA_GOOGLESHEET, range);
		commentVal = values.get("Comment");
		String defaultCommentCount=null;
		
		getHomePageActions().clickOnTopBarDropdown("Action Step");        
		getOrganizationPageActions().clickOnOrganizationLink("Action Step");
		getOrganizationPageActions().clickOnCreatedOrganization("Action Step");
		defaultCommentCount=getOrganizationPageActions().getDefaultCommentCount("Action Step");
		getOrganizationPageActions().clickOnCommentIcon("Action Step");
		getOrganizationPageActions().enterComment("Action Step", commentVal);
		getOrganizationPageActions().clickOnSendCommentIcon("Verify Step");
		getOrganizationPageActions().verifyCommentCount("Verify Step", defaultCommentCount);
		
	}
	

	/*
	 * @author:Aishwarya
	 * Description: Verify Create #Showtimes Post functionality as Owner
	 * Created on : 11-06-2020
	 */

	@Test(priority = 113, enabled = false, alwaysRun = true, description = "Verify Create #Showtimes Post functionality as Owner")
	public void tc_ORG_13_P1_VerifyCreateShowtimezPostAsOwnerTest() throws Exception
	{
		String hashtagType = null;
		String title = null;
		String description = null;
		String location = null;
		String date = null;
		String time = null;

		String range = "ShowTimez!A2:F2";
		Map<String, String> values= sheetAPI().getSpreadSheetRowValueByColumnName(TEST_DATA_GOOGLESHEET, range);

		hashtagType = values.get("Action");
		title = values.get("Title");
		description = values.get("Description");
		location = values.get("Location");
		date  = values.get("Date");
		time = values.get("Time");

		getHomePageActions().clickOnTopBarDropdown("Action Step");
		getOrganizationPageActions().clickOnOrganizationLink("Action Step");
		getOrganizationPageActions().clickOnCreatedOrganization("Action Step");
		getOrganizationPageActions().verifyCreatePostOptionForOwner("verify Step");
		getProfilePageActions().clickOnSpecialHashtagDropdown("Action Step");
		getProfilePageActions().selectHashtag("Action Step", hashtagType);
	}

	/*
	 * @author:Aishwarya
	 * Description: Verify deleting the organization
	 * Created on : 05-05-2020
	 */

	@Test(priority = 113, enabled = false, alwaysRun = true, description = "Verify deleting the organization")
	public void tc_ORG_09_P1_VerifyDeleteOrganizationTest() throws Exception
	{
		String range = "Organization!A2:D2";
		String name = null;
		Map<String, String> values= sheetAPI().getSpreadSheetRowValueByColumnName(TEST_DATA_GOOGLESHEET, range);
		name = values.get("Name");

		getHomePageActions().clickOnTopBarDropdown("Action Step");        
		getOrganizationPageActions().clickOnOrganizationLink("Action Step");
		getOrganizationPageActions().clickOnCreatedOrganization("Action Step");
		getOrganizationPageActions().clickOnOrganizationSettingMenu("Action Step");
		getOrganizationPageActions().clickOnDeleteOrganizationLink("Action Step");
		getOrganizationPageActions().clickOnConfirmDeleteOrganization("Action Step");
		getHomePageActions().clickOnTopBarDropdown("Action Step");        
		getOrganizationPageActions().clickOnOrganizationLink("Action Step");
		getOrganizationPageActions().verifyDeletedOrganizationInOrganizationPage("Verify Step", name);
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
