package com.aeione.ops.test;

import com.aeione.ops.generic.GoogleDriveAPI;
import com.aeione.ops.generic.GoogleSheetAPI;
import com.aeione.ops.generic.TestSetUp;
import com.aeione.ops.pageactions.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Map;

public class EventPageTest extends TestSetUp
{

	public LoginPageActions getLoginPage() throws IOException {
		return new LoginPageActions();
	}

	public EventPageActions getEventPageActions() throws IOException {
		return new EventPageActions();
	}

	public HomePageActions getHomePageActions() throws IOException {
		return new HomePageActions();
	}

	public PostCardActions gePostCardActions() throws IOException {
		return new PostCardActions();
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
	 * @author: Aishwarya
	 * Description: Verify navigation to Explore Page
	 * Created on : 21-05-2020
	 */

	@Test(priority = 140, enabled = true, alwaysRun = true, description = "Verify \"Create Event\" option by clicking on the Group "
			+ "link from Header")
	public void tc_EV_01_P1_VerifyCreateEventOptionByClickingOnGroupLinkTest() throws Exception
	{
		String range = "Login!A14:B14";
		String username = null;
		String password = null;
		String fullname = null;

		Map<String, String> values= sheetAPI().getSpreadSheetRowValueByColumnName(TEST_DATA_GOOGLESHEET, range);
		username=values.get("UserName / Email / PhoneNumber");
		password=values.get("Password");
		fullname=values.get("FullName");

		getLoginPage().logIn("Action Step" ,fullname , "valid registered Username & password",username, password);
		getEventPageActions().clickOnGroupIconFromHeader("Action Step");
		getEventPageActions().verifyCreateEventOptionInGroupIcon("Verify Step");

	}

	/*
	 * @author: Aishwarya
	 * Description: Verify navigation to Create Event Page
	 * Created on : 22-05-2020
	 */

	@Test(priority = 141, enabled = true, alwaysRun = true, description = "Verify \" Create Event\" option by clicking on the Group "
			+ "link from Header")
	public void tc_EV_02_P1_VerifyNavigationToCreateEventPageTest() throws Exception
	{
		getEventPageActions().clickOnGroupIconFromHeader("Action Step");
		getEventPageActions().clickOnCreateEventLinkFromGroupIcon("Action Step[");
		getEventPageActions().verifyNavigationToCreateEventPage("Verify Step");

	}

	/*
	 * @author: Aishwarya
	 * Description: Verify navigation to Create Event Page
	 * Created on : 22-05-2020
	 */

	@Test(priority = 142, enabled = true, alwaysRun = true, description = "Verify \" Create Event\" functionality ")
	public void tc_EV_03_P1_VerifyCreateEventTest() throws Exception
	{
		String range = "Event!A2:I2";
		String title=null;
		String description=null;
		String event_type=null;
		String event_Category=null;
		String location=null;
		String startDate=null;
		String startTime=null;
		String EndDate=null;
		String EndTime=null;

		Map<String, String> val = sheetAPI().getSpreadSheetRowValueByColumnName(TEST_DATA_GOOGLESHEET, range);
		title=val.get("Event_Title");
		description=val.get("Event_Description");
		event_type=val.get("Event_Type");
		event_Category=val.get("Event_Category");
		location= val.get("Event_Location");
		startDate= val.get("Start_Date");
		startTime= val.get("Start_Time");
		EndDate= val.get("End_Date");
		EndTime= val.get("End_Time");

		dsriveAPI().downloadFileFromGoogleDrive(TEST_IMAGE_ID1);
		String imageFile = userDirPath + IMAGE_TEST_FILE1;

		getEventPageActions().clickOnGroupIconFromHeader("Action Step");
		getEventPageActions().clickOnCreateEventLinkFromGroupIcon("Action Step[");
		getEventPageActions().enterEventTitle("Action Step",title);
		getEventPageActions().enterEventDescription("Action Step", description);
		getEventPageActions().selectEventType("Action Step",event_type);
		getEventPageActions().selectEventCategory("Action Step",event_Category);
		getEventPageActions().enterEventLocation("Action Step",location);
		getEventPageActions().enterEventStartDate("Action Step",startDate);
		getEventPageActions().enterEventStartTime("Action Step",startTime);
		getEventPageActions().enterEventEndDate("Action Step",EndDate);
		getEventPageActions().enterEventEndTime("Action Step",EndTime);
		getHomePageActions().attachFile("Action Step",imageFile);
		//getHomePageActions().verifyDisplayOfOpportunityThumbnail("Verify Step");
		getEventPageActions().clickOnCreatEventButton("Verify Step");
		getEventPageActions().verifyCreationofEventAndEventInnerPage("Verify Step");

	}

	/*
	 * @author: Aishwarya
	 * Description: Verify navigation to Create Event Page
	 * Created on : 22-05-2020
	 */

	@Test(priority = 143, enabled = true, alwaysRun = true, description = "Verify \" Create Event\" functionality ")
	public void tc_EV_04_P1_VerifyCreatedEventInHomePageTest() throws Exception
	{
		String range = "Event!A2:B2";
		String title=null;
		String page=null;
		String tab=null;

		Map<String, String> val = sheetAPI().getSpreadSheetRowValueByColumnName(TEST_DATA_GOOGLESHEET, range);
		title=val.get("Event_Title");
		page= "TimeLine";
		tab="Event Tab";
		
		
		getEventPageActions().verifyDisplayOfCreatedEventOnWidget("Verify Step", title);
		getEventPageActions().verifyDisplayOfCreatedEventInHomePage("Verify Step", title);
		getHomePageActions().clickOnTopBarDropdown("Action Step");
		getProfilePageActions().clickOnViewProfileLink("Action Step");
		getEventPageActions().verifyDisplayOfCreatedEventInProfilePage("Verify Step", title, page); 
		getProfilePageActions().clickOnEventTab("Action Step");
		getEventPageActions().verifyDisplayOfCreatedEventInProfilePage("Verify Step", title, tab); 
	}


	/*
	 * @author: Aishwarya
	 * Description: Verify navigation to Create Event Page
	 * Created on : 27-05-2020
	 */

	@Test(priority = 144, enabled = true, alwaysRun = true, description = "Verify \" Create Event\" functionality ")
	public void tc_EV_05_P1_VerifyDeletingEventTest() throws Exception
	{
		String range = "Event!A2:B2";
		String title=null;

		Map<String, String> val = sheetAPI().getSpreadSheetRowValueByColumnName(TEST_DATA_GOOGLESHEET, range);
		title=val.get("Event_Title");

		gePostCardActions().clickOnMeatBallMenu("Action Step");
		gePostCardActions().clickOnDeleteOption("Action Step");
		gePostCardActions().clickOnYesButton("Action Step");
		getEventPageActions().verifyDisplayofDeletedEventInHomePage("Verify Step", title);

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
