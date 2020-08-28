package com.aeione.ops.test;

import com.aeione.ops.generic.GenericFunctions;
import com.aeione.ops.generic.GoogleDriveAPI;
import com.aeione.ops.generic.GoogleSheetAPI;
import com.aeione.ops.generic.TestSetUp;
import com.aeione.ops.pageactions.HomePageActions;
import com.aeione.ops.pageactions.LoginPageActions;
import com.aeione.ops.pageactions.ProfilePageActions;
import com.aeione.ops.pageobjects.HomePageObjects;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Map;

public class ProfilePageTest extends TestSetUp
{
	GenericFunctions genericfunctions;
	HomePageObjects homepageobjects = new HomePageObjects();
	Actions actions = null;


	public LoginPageActions getLoginPage() throws IOException {
		return new LoginPageActions();

	}

	public HomePageActions getHomePageActions() throws IOException {
		return new HomePageActions();
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
	 * Description: Verify View profile Link 
	 * Created on : 05-05-2020
	 */

	@Test(priority = 57, enabled = true, alwaysRun = true, description = "Verify View-Profile Link")
	public void tc_PP_01_P1_VerifyViewProfileLinkTest() throws Exception
	{

		String range = "Login!A14:C14";
		String username = null;
		String password = null;
		String fullname = null;

		Map<String, String> values= sheetAPI().getSpreadSheetRowValueByColumnName(TEST_DATA_GOOGLESHEET, range);
		username=values.get("UserName / Email / PhoneNumber");
		password=values.get("Password");
		fullname=values.get("FullName");

		getLoginPage().logIn("Action Step" ,fullname , "valid registered Username & password",username, password);
		getHomePageActions().clickOnTopBarDropdown("Action Step");        
		getProfilePageActions().verifyDisplayOfViewProfileLink("Verify Step");

	}

	/* @author:Aishwarya
	 * Description: Verify View profile functionality
	 * Created on : 05-05-2020
	 */

	@Test(priority = 58, enabled = true, alwaysRun = true, description = "Verify View-Profile link functionality")
	public void tc_PP_02_P1_VerifyViewProfileLinkFunctionalityTest() throws Exception
	{  
		getHomePageActions().clickOnTopBarDropdown("Action Step");
		String Full_Name=getProfilePageActions().getUserFullNameFromeProfileDropdown();
		getProfilePageActions().verifyViewProfileLink("Verify Step");
		getProfilePageActions().clickOnViewProfileLink("Action Step");
		getProfilePageActions().verifyTheNavigationToProfilePage("Verify Step", Full_Name);
	}

	/* @author:Aishwarya
	 * Description: Verify the functionality of edit profile picture
	 * Created on : 08-05-2020
	 */

	@Test(priority = 59, enabled = true, alwaysRun = true, description = "Verify Edit Profile picture")
	public void tc_PP_03_P1_VerifyEditProfilePictureTest() throws Exception{


		dsriveAPI().downloadFileFromGoogleDrive(TEST_IMAGE_ID1);
		String imageFile = userDirPath + IMAGE_TEST_FILE1;

		getHomePageActions().clickOnTopBarDropdown("Action Step");
		getProfilePageActions().clickOnViewProfileLink("Action Step");
		getProfilePageActions().verifyDisplayOfEditProfilePictureIcon("Verify Step");
		getProfilePageActions().attachFile("Action Step", imageFile);
		getProfilePageActions().clickOnApplyButtonOfEditPicturePopUp("Action Step");
	}


	/* @author:Aishwarya
	 * Description: Verify the Portfolio button & navigation to the Portfolio page
	 * Created on : 08-05-2020
	 */  
	@Test(priority = 60, enabled = true, alwaysRun = true, description = "Verify Portfolio Page on clicking Portfolio "
			+ "button from the Profile page")
	public void tc_PP_04_P1_VerifyNavigationToPortfolioPageTest() throws Exception
	{
		getHomePageActions().clickOnTopBarDropdown("Action Step");
		getProfilePageActions().clickOnViewProfileLink("Action Step");
		getProfilePageActions().verifyDisplayOfPortfolioButton("Verify Step");
		getProfilePageActions().clickOnPortfolioButton("Action Step");
		getProfilePageActions().verifyNavigationToPortfolioPage("Verify Step");
	}


	/* @author:Aishwarya
	 * Description: Verify the details under the About section
	 * Created on : 12-05-2020
	 */   
	@Test(priority = 61, enabled = true, alwaysRun = true, description = "Verify the About section details in Profile page")
	public void tc_PP_05_P1_VerifyUserDetailsUnderAboutSectionTest() throws Exception{

		String rangeOfUserDetails = "Profile Page!A2:I2";
		Map<String, String> userDetails= sheetAPI().getSpreadSheetRowValueByColumnName(TEST_DATA_GOOGLESHEET, rangeOfUserDetails);

		getHomePageActions().clickOnTopBarDropdown("Action Step");
		getProfilePageActions().clickOnViewProfileLink("Action Step");
		getProfilePageActions().verifyDetailsInAboutSection( userDetails, "Verify Step");
	} 

	/*
	 * @author:Aishwarya
	 * Description: Verify creating a post from Profile Page
	 *Created on : 12-05-2020
	 */
	@Test(priority = 62, enabled = true, alwaysRun = true, description = "Verify creating the post from Profile page")
	public void tc_PP_06_P1_VerifyCreatingPostFromProfilePageTest() throws Exception {

		String textPostVal = null;
		String range = "Profile Page!A2:B2";

		Map<String, String> values= sheetAPI().getSpreadSheetRowValueByColumnName(TEST_DATA_GOOGLESHEET, range);
		textPostVal= values.get("Post_Text");

		getHomePageActions().clickOnTopBarDropdown("Action Step");
		getProfilePageActions().clickOnViewProfileLink("Action Step");
		getHomePageActions().clickOnPosterTextArea("Action Step");
		getHomePageActions().enterTextOnMessageTextArea("Action Step", textPostVal);
		getHomePageActions().clickOnPostButton("Action step");
		getProfilePageActions().verifyDisplayOfPostedText("Verify Step" , textPostVal);

	}



	/*
	 * @author:Aishwarya
	 * Description: Verify creating a post from Profile Page
	 * Created on : 12-05-2020
	 */

	@Test(priority = 63, enabled = true, alwaysRun = true, description = "Verify the About section details")
	public void tc_PP_07_P1_VerifyCreatingSpecialHashtagPostTest() throws Exception
	{
		String hashtagType = null;
		String range = "Opportunity!A2:E2";
		String title=null;
		String description=null;
		String location=null;
		String category=null;
		dsriveAPI().downloadFileFromGoogleDrive(TEST_IMAGE_ID1);
		String imageFile = userDirPath + IMAGE_TEST_FILE1;

		Map<String, String> values= sheetAPI().getSpreadSheetRowValueByColumnName(TEST_DATA_GOOGLESHEET, range);
		title=values.get("Opportunity Title");
		description=values.get("Description");
		location=values.get("Location");
		category= values.get("category");
		hashtagType= values.get("Hashtag_Type");

		getHomePageActions().clickOnTopBarDropdown("Action Step");
		getProfilePageActions().clickOnViewProfileLink("Action Step");
		getHomePageActions().clickOnPosterTextArea("Action Step");
		getProfilePageActions().clickOnSpecialHashtagDropdown("Action Step");
		getProfilePageActions().selectHashtag("Action Step", hashtagType);
		getHomePageActions().selectCategory("Action Step",category);
		getHomePageActions().enterOpportunityTitle("Action Step",title);
		getHomePageActions().enterOpportunityDescription("Action Step", description);
		getHomePageActions().enterOpportunityLocation("Action Step",location);
		getHomePageActions().attachFile("Action Step",imageFile);
		getHomePageActions().verifyDisplayOfOpportunityThumbnail("Verify Step");
		getHomePageActions().clickOnPostOpportunityButton("Action Step");
		getProfilePageActions().selectTab("Action Step", hashtagType);
		getProfilePageActions().verifyDisplayOfCreatedOpportunity("Verify Step", title);
	} 

	/*
	 * @author:Aishwarya
	 * Description: After method which works as pre-condition to the next test script execution
	 * Created on : 12-05-2020
	 */
	@AfterMethod(dependsOnMethods={"com.aeione.ops.generic.TestSetUp.afterMethod"})
	public void after() throws IOException
	{
		getHomePageActions().navigateHomePage();
		System.out.println("After method got executed ");
	}

}
