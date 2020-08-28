package com.aeione.ops.test;

import com.aeione.ops.generic.GoogleDriveAPI;
import com.aeione.ops.generic.GoogleSheetAPI;
import com.aeione.ops.generic.TestSetUp;
import com.aeione.ops.pageactions.ExplorePageActions;
import com.aeione.ops.pageactions.HomePageActions;
import com.aeione.ops.pageactions.LoginPageActions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Map;


public class ExplorePageTest extends TestSetUp
{

	public LoginPageActions getLoginPage() throws IOException {
		return new LoginPageActions();
	}

	public ExplorePageActions getExplorePageActionss() throws IOException {
		return new ExplorePageActions();
	}

	public HomePageActions getHomePageActions() throws IOException {
		return new HomePageActions();
	}

	public GoogleSheetAPI sheetAPI() throws IOException {
		return new GoogleSheetAPI();
	}

	public GoogleDriveAPI dsriveAPI() throws IOException {
		return new GoogleDriveAPI();
	}

	/*
	 * @author:Aishwarya
	 * Description: Verify navigation to Explore Page
	 * Created on : 21-05-2020
	 */

	@Test(priority =136, enabled = true, alwaysRun = true, description = "Verify navigation to the \" Explore page\" by clicking on the Home page Header >> Explore ")
	public void tc_EX_01_P1_VerifyNavigationToExplorePageTest() throws Exception
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
		getExplorePageActionss().clickOnExploreLink("Action Step");
		getExplorePageActionss().verifyNavigationToExplorePage("Verify Step");

	}

	/*
	 * @author:Aishwarya
	 * Description: Verify navigation to Explore Page
	 * Created on : 21-05-2020
	 */

	@Test(priority =138, enabled = true, alwaysRun = true, description = "Verify \" Suggested Hashtags\" in sub-header of Explore page")
	public void tc_EX_02_P1_VerifySuggestedHashtagsInSubHeaderOfExplorePageTest() throws Exception{

		String range = "Explore Page!A21:A1";
		Map<String, String> suggestedHashtags= sheetAPI().getSpreadSheetRowValueByColumnName(TEST_DATA_GOOGLESHEET, range);

		getExplorePageActionss().clickOnExploreLink("Action Step");
		getExplorePageActionss().verifySuggestedHashtagsInSubHeaderOfExplorePage(suggestedHashtags, "Verify Step");
	}


	/*
	 * @author:Aishwarya
	 * Description: After method which works as pre-condition to the next test script execution
	 * Created on : 22-05-2020
	 */
	@AfterMethod(dependsOnMethods={"com.aeione.ops.generic.TestSetUp.afterMethod"})
	public void after() throws IOException
	{
		getHomePageActions().navigateHomePage();
		System.out.println("After method got executed ");
	}


}
