package com.aeione.ops.pageactions;

import com.aeione.ops.generic.DriverManager;
import com.aeione.ops.generic.ExtentTestManager;
import com.aeione.ops.generic.GenericFunctions;
import com.aeione.ops.pageobjects.EventPageObjects;
import com.aeione.ops.pageobjects.HomePageObjects;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.io.IOException;

public class EventPageActions {

	GenericFunctions genericfunctions;
	EventPageObjects eventPageObjects = new EventPageObjects();
	HomePageObjects homePageObjects = new HomePageObjects();
	Actions action;
	Select selectdropdownOption=null;

	public EventPageActions() throws IOException
	{

		genericfunctions = new GenericFunctions(DriverManager.getDriver());
		PageFactory.initElements(DriverManager.getDriver(), this);
		PageFactory.initElements(DriverManager.getDriver(), eventPageObjects);
		PageFactory.initElements(DriverManager.getDriver(), homePageObjects);
		action=new Actions(DriverManager.getDriver());
	}
	///////////////////////////////////////////// Page actions //////////////////////////////////////////////////////

	/*
	 * @author: Aishwarya
	 * Description: Click on Explore link from the Home page header
	 * Created on : 22-05-2020
	 */

	public void clickOnGroupIconFromHeader(String... strings) {
		ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " :: Click on Group Icon");
		try 
		{
			genericfunctions.waitTillTheElementIsVisible(homePageObjects.topbar_group);
			homePageObjects.topbar_group.click();
		}
		catch(Throwable e)
		{
			Assert.fail("Could not perform action on \"Group \"icon" +"&"+ e.getMessage());
		}
	}
	
	/*
	 * @author: Aishwarya
	 * Description: Click on Create Event link from Group icon
	 * Created on : 03-06-2020
	 */

	public void clickOnCreateEventLinkFromGroupIcon(String... strings) {
		ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " :: Click on Create Event link");
		try 
		{
			genericfunctions.waitTillTheElementIsVisible(eventPageObjects.createEvent_link);
			eventPageObjects.createEvent_link.click();
		}
		catch(Throwable e)
		{
			Assert.fail("Could not perform action on \"Create Event \"link" +"&"+ e.getMessage());
		}
	}
	
	/*
	 * @author: Aishwarya
	 * Description: Enter event title
	 * Created on : 23-05-2020
	 */
	public void enterEventTitle(String...strings)
	{
		String title=strings[1];
		ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " :: Enter Event Title as : "+title);
		try
		{
			genericfunctions.waitTillTheElementIsVisible(eventPageObjects.eventTitle_TextField);
			eventPageObjects.eventTitle_TextField.sendKeys(title);
		}
		catch (Throwable e)
		{
			Assert.fail("Could not able to enter Event Title"+"&"+e.getMessage()+"" );
		}
	}

	/*
	 * @author: Aishwarya
	 * Description: Enter event description
	 * Created on : 23-05-2020
	 */
	public void enterEventDescription(String...strings)
	{
		String description=strings[1];
		ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " :: Enter Event Description as : <b>\""+description+ "\"</b>");
		try
		{
			genericfunctions.waitTillTheElementIsVisible(eventPageObjects.eventDescription_TextField);
			eventPageObjects.eventDescription_TextField.sendKeys(description);
		}
		catch (Throwable e)
		{
			Assert.fail("Could not able to enter Event Description"+"&"+e.getMessage()+"" );
		}
	}

	/*
	 * @author: Aishwarya
	 * Description: Enter event description
	 * Created on : 23-05-2020
	 */
	public void selectEventType(String...strings)
	{
		String eventType=strings[1];
		ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " :: Select Event type as : <b>\""+eventType+ "\"</b>");
		try
		{
			genericfunctions.waitTillTheElementIsVisible(eventPageObjects.eventType_Dropdown);
			eventPageObjects.eventType_Dropdown.click();
			selectdropdownOption=new Select(eventPageObjects.eventType_Dropdown);
			selectdropdownOption.selectByValue(eventType);
		}
		catch (Throwable e)
		{
			Assert.fail("Could not able to enter Event Type"+"&"+e.getMessage()+"" );
		}
	}

	/*
	 * @author: Aishwarya
	 * Description: Select Event Category
	 * Created on : 23-05-2020
	 */

	public void selectEventCategory(String...strings)
	{
		String eventCategory=strings[1];
		ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " :: Select Event category as : <b>\""+eventCategory+ "\"</b>");
		try
		{
			genericfunctions.waitTillTheElementIsVisible(eventPageObjects.eventCategory_Dropdown);
			selectdropdownOption=new Select(eventPageObjects.eventCategory_Dropdown);
			selectdropdownOption.selectByValue(eventCategory);
		}
		catch (Throwable e)
		{
			Assert.fail("Could not able to enter Event Category"+"&"+e.getMessage()+"" );
		}
	}

	/*
	 * @author: Aishwarya
	 * Description: Enter event description
	 * Created on : 23-05-2020
	 */
	public void enterEventLocation(String...strings)
	{
		String location=strings[1];
		ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " :: Enter Event Location as : <b>\"" +location+ "\"</b>");
		try
		{
			genericfunctions.waitTillTheElementIsVisible(eventPageObjects.eventLocation_TextField);
			eventPageObjects.eventLocation_TextField.sendKeys(location);
		}
		catch (Throwable e)
		{
			Assert.fail("Could not able to enter Event Location"+"&"+e.getMessage()+"" );
		}
	}

	/*
	 * @author: Aishwarya
	 * Description: Enter event start date
	 * Created on : 23-05-2020
	 */
	public void enterEventStartDate(String...strings)
	{
		String startDate=strings[1];
		ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " :: Enter start date of the Event as : <b>\"" +startDate+ "\"</b>");
		try
		{
			genericfunctions.waitTillTheElementIsVisible(eventPageObjects.event_StartDate);
			eventPageObjects.event_StartDate.sendKeys(startDate);
		}
		catch (Throwable e)
		{
			Assert.fail("Could not able to enter Event Start Date"+"&"+e.getMessage()+"" );
		}
	}
	/*
	 * @author: Aishwarya
	 * Description: Enter event start time
	 * Created on : 23-05-2020
	 */
	public void enterEventStartTime(String...strings)
	{
		String startTime=strings[1];
		ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " :: Enter Event Start time as : <b>\"" +startTime+ "\"</b>");
		try
		{
			genericfunctions.waitTillTheElementIsVisible(eventPageObjects.event_StartTime);
			eventPageObjects.event_StartTime.sendKeys(startTime);
		}
		catch (Throwable e)
		{
			Assert.fail("Could not able to enter Event Start time"+"&"+e.getMessage()+"" );
		}
	}
	/*
	 * @author: Aishwarya
	 * Description: Enter event End date
	 * Created on : 23-05-2020
	 */
	public void enterEventEndDate(String...strings)
	{
		String endDate=strings[1];
		ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " :: Enter Event End date as : <b>\"" +endDate+ "\"</b>");
		try
		{
			genericfunctions.waitTillTheElementIsVisible(eventPageObjects.event_EndDate);
			eventPageObjects.event_EndDate.sendKeys(endDate);
		}
		catch (Throwable e)
		{
			Assert.fail("Could not able to enter Event End date"+"&"+e.getMessage()+"" );
		}
	}
	/*
	 * @author: Aishwarya
	 * Description: Enter event description
	 * Created on : 23-05-2020
	 */
	public void enterEventEndTime(String...strings)
	{
		String endTime=strings[1];
		ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " :: Enter Event End time as : <b>\"" +endTime+ "\"</b>");
		try
		{
			genericfunctions.waitTillTheElementIsVisible(eventPageObjects.event_EndTime);
			eventPageObjects.event_EndTime.sendKeys(endTime);
		}
		catch (Throwable e)
		{
			Assert.fail("Could not able to enter Event End time"+"&"+e.getMessage()+"" );
		}
	}

	/*
	 * @author: Aishwarya
	 * Description: Click on create event button
	 * Created on : 27-05-2020
	 */
	public void clickOnCreatEventButton(String... strings)
	{
		ExtentTestManager.getTest().log(LogStatus.INFO, " "+ strings[0]  + " :: Click on Create Event Button");
		String createbutton=null;
		try
		{
			genericfunctions.waitForPageToLoad(eventPageObjects.create_Button);
			Assert.assertTrue(eventPageObjects.create_Button.isEnabled());
			createbutton=eventPageObjects.create_Button.getText();
			eventPageObjects.create_Button.click();
			ExtentTestManager.getTest().log(LogStatus.PASS, createbutton+ " button is clickable ");
		}
		catch (Throwable e)
		{
			Assert.fail("Could not perform an action on /Create / button"+"&"+e.getMessage()+"" );
		}
	}

	/*
	 * @author: Aishwarya
	 * Description: Click on Post menu action button
	 * Created on : 27-05-2020
	 */
	public void clickOnPostMenuActionButton(String... strings)
	{
		ExtentTestManager.getTest().log(LogStatus.INFO, " "+ strings[0]  + " :: Click on Create Event Button");
		String createbutton=null;
		try
		{
			genericfunctions.waitForPageToLoad(eventPageObjects.create_Button);
			Assert.assertTrue(eventPageObjects.create_Button.isEnabled());
			createbutton=eventPageObjects.create_Button.getText();
			eventPageObjects.create_Button.click();
			ExtentTestManager.getTest().log(LogStatus.PASS, createbutton+ " button is clickable ");
		}
		catch (Throwable e)
		{
			Assert.fail("Could not perform an action on /Create / button"+"&"+e.getMessage()+"" );
		}
	}
	
	/*
	 * @author: Aishwarya
	 * Description: Click on delete button
	 * Created on : 27-05-2020
	 */
	public void clickOnDeleteButton(String... strings)
	{
		ExtentTestManager.getTest().log(LogStatus.INFO, " "+ strings[0]  + " :: Click on Create Event Button");
		String createbutton=null;
		try
		{
			genericfunctions.waitForPageToLoad(eventPageObjects.create_Button);
			Assert.assertTrue(eventPageObjects.create_Button.isEnabled());
			createbutton=eventPageObjects.create_Button.getText();
			eventPageObjects.create_Button.click();
			ExtentTestManager.getTest().log(LogStatus.PASS, createbutton+ " button is clickable ");
		}
		catch (Throwable e)
		{
			Assert.fail("Could not perform an action on /Create / button"+"&"+e.getMessage()+"" );
		}
	}
	
	/////////////////////////////////////////// Page Verification ///////////////////////////////////////////////////////////	

	/*
	 * @author: Aishwarya
	 * Description: Verify Create Event option in Group link
	 * Created on : 22-05-2020
	 */
	public void verifyCreateEventOptionInGroupIcon(String ...strings)
	{
		ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " :: Display of Create Event option on clicking Group icon"
				+ "from Home page header with following assertions :");
		String link=null;
		try {
			genericfunctions.waitTillTheElementIsVisible(eventPageObjects.createEvent_link);
			Assert.assertTrue(eventPageObjects.createEvent_link.isDisplayed());
			link=eventPageObjects.createEvent_link.getText();
			ExtentTestManager.getTest().log(LogStatus.PASS, link+ " link is displaying successfully ");
		} catch (Throwable e)
		{
			Assert.fail("Expected :: \"Create Event\" link should be displayed successfully ; Actual ::  \"Create Event \" link is not displayed");
		}
	}


	/*
	 * @author: Aishwarya
	 * Description: Verify Create Event option in Group link
	 * Created on : 22-05-2020
	 */
	public void verifyNavigationToCreateEventPage(String ...strings)
	{
		ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " ::  Navigation to the Create Event page on clicking "
				+ "\"Create Event link \" with following assertions :");
		String pageHeader=null;
		try {
			Assert.assertTrue(eventPageObjects.createEvent_Header.isDisplayed());
			pageHeader=eventPageObjects.createEvent_Header.getText();
			ExtentTestManager.getTest().log(LogStatus.PASS, "User succesfully navigated to <b>\""+ pageHeader+ " \"</b> page");
		} catch (Throwable e)
		{
			Assert.fail("Expected :: \"Create event\" header should be displayed  ; Actual :: \"Create event \" header is not  displayed  ");
		}
	}
	
	 /*
	 * Verify_Uploaded_Thumbnail_Text_On_TextArea
	 * Author:- Gandahrva
	 */
	public void verifyDisplayOfOpportunityThumbnail(String... strings)
	{
		genericfunctions.waitWebDriver(2000);
		ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " :: Opportunity Thumbnail has Uploaded or not");
		try
		{
			genericfunctions.waitForPageToLoad(eventPageObjects.eventTitle_TextField);
			Assert.assertTrue(eventPageObjects.event_thumbnail.isDisplayed());
			ExtentTestManager.getTest().log(LogStatus.PASS, " \"Event Image Thumbnail\" has displayed");
		}
		catch (Throwable e)
		{
			Assert.fail("Could not found \"Opportunity Image Thumbnail\"" + "&" + e.getMessage() + "");
		}
	}

	/*
	 * @author: Aishwarya
	 * Description: Verify Creation of event and default navigation to event inner page
	 * Created on : 26-05-2020
	 */
	public void verifyCreationofEventAndEventInnerPage(String... strings)
	{
		ExtentTestManager.getTest().log(LogStatus.INFO, " "+ strings[0]  +" :: Creating an event and navigation to the"
				+ " Event inner page");
		try
		{
			genericfunctions.waitTillTheElementIsVisible(eventPageObjects.eventInnerPage_Info);
			Assert.assertTrue(eventPageObjects.eventInnerPage_Info.isDisplayed());
			ExtentTestManager.getTest().log(LogStatus.PASS, " \"Created Event : \" Successfully navigated to "
					+ "inner page of created event");

		} catch (Throwable e)
		{
			Assert.fail("Expected :: \" Event :: \" should be Created and user should navigate to inner page of created event ; " +
					"Actual :: Failed to navigate to \" Event ::\" inner page after creating the event \"" + "&" + e.getMessage() + "");
		}
	}

	/*
	 * @author: Aishwarya
	 * Description: Verify Created event in Home page Event Widget
	 * Created on : 26-05-2020
	 */
	public void verifyDisplayOfCreatedEventOnWidget(String... strings)
	{
		ExtentTestManager.getTest().log(LogStatus.INFO, " "+ strings[0]  +" :: Created Event is displayed or"
				+ " not On Events widget");
		String actualEvent = null;
		String expectedEvent=  strings[1];
		try
		{
			genericfunctions.waitForPageToLoad(eventPageObjects.eventWidget_EventTitle);
			genericfunctions.waitTillTheElementIsVisible(eventPageObjects.eventWidget_EventTitle);
			actualEvent=eventPageObjects.eventWidget_EventTitle.getText().trim();
			Assert.assertEquals(actualEvent, expectedEvent);
			ExtentTestManager.getTest().log(LogStatus.PASS, " \"Event Widget :\"  User Created "
					+ "Event is displayed under Events Widget as : <b>\"" +actualEvent+ "\"</b>");

		} catch (Throwable e)
		{
			Assert.fail("Expected :: \" Event Widget - \" User Created Event should be displayed  ; " +
					"Actual :: \" Event Widget -\" User Created Event is not displayed\"" + "&" + e.getMessage() + "");
		}
	}

	/*
	 * @author: Aishwarya
	 * Description: Verify Created event in Home page
	 * Created on : 26-05-2020
	 */
	public void verifyDisplayOfCreatedEventInHomePage(String... strings)
	{
		ExtentTestManager.getTest().log(LogStatus.INFO, " "+ strings[0]  +" ::  Created Event is displayed or"
				+ " not in Home Page Feeds");
		String actualEvent=null;
		String expectedEvent=strings[1];
		try
		{
			genericfunctions.scrollToElement(eventPageObjects.eventTitle_HomePageFeeds);
			genericfunctions.waitTillTheElementIsVisible(eventPageObjects.eventTitle_HomePageFeeds);
			actualEvent=eventPageObjects.eventTitle_HomePageFeeds.getText().trim();
			Assert.assertEquals(actualEvent, expectedEvent);
			ExtentTestManager.getTest().log(LogStatus.PASS, " \"Home page Feeds : \"  User Created "
					+ "Event is displaying successfully :  <b>\"" +actualEvent+ "\"</b>");
		} 
		catch (Throwable e)
		{
			String actualException=e.getClass().getName();
			switch (actualException)
			{
			case "NoSuchElementException":
				Assert.fail("Expected ::\"Home page Feeds - \" User Created Event should be displayed in Home page feed "
						+ "; Actual ::  \" Home page Feeds - \" User Created Event is not displayed in Home page feed "
						+ "is not displayed"+"&"+e.getMessage()+"" );
				break;
			case "AssertionError":
				Assert.fail("Expected ::\"Home page Feeds :: \" User Created Event should be displayed in Home page feed ;  <b>\"" 
						+ expectedEvent + "\"</b> ;\"Actual ::  \" Home page Feeds ::\" User Created Event is not "
								+ "displayed in Home page feed" + actualEvent + "\"</b>");
				break;
			default:
				Assert.fail(""+"&"+e.getMessage()+"");
			}
		}    
	}

	/*
	 * @author: Aishwarya
	 * Description: Verify Created event in Home page
	 * Created on : 26-05-2020
	 */
	public void verifyDisplayOfCreatedEventInProfilePage(String... strings)

	{
		String page=strings[2];
		ExtentTestManager.getTest().log(LogStatus.INFO, " "+ strings[0]  +" :: Created Event is displayed or"
				+ " not in Profile Page "+ page  +" Feeds");
		String actualEvent=null;
		String expectedEvent=strings[1];
		try
		{
			genericfunctions.waitForPageToLoad(eventPageObjects.eventTitle_HomePageFeeds);
			genericfunctions.scrollToElement(eventPageObjects.eventTitle_HomePageFeeds);
			genericfunctions.waitTillTheElementIsVisible(eventPageObjects.eventTitle_HomePageFeeds);
			actualEvent=eventPageObjects.eventTitle_HomePageFeeds.getText().trim();
			Assert.assertEquals(actualEvent, expectedEvent);
			ExtentTestManager.getTest().log(LogStatus.PASS, " \"Profile page Feeds : \"  User Created "
					+ "Event is displaying successfully in "+ page + " feeds :<b>\"" +actualEvent+"\"</b>");
		} catch (Throwable e)
		{
			String actualException=e.getClass().getName();
			switch (actualException)
			{
			case "NoSuchElementException":				
				Assert.fail("Expected ::\"Profile page Feeds - \" User Created Event should be displayed in Profile Page Events tab "
						+ "; Actual ::  \" Profile page Feeds -\" User Created Event is not displayed in Profile page Events tab "
						+"&"+" Defect Link - <a href='https://taiga.vnaad.com/project/admin-one-page-spotlight/issue/1680' target='_blank'>https://taiga.vnaad.com/project/admin-one-page-spotlight/issue/1680</a> " );
				break;
			case "AssertionError":
				Assert.fail("Expected ::\"Profile page Feeds - \" User Created Event should be displayed in Profile page Events tab :  <b>\"" 
						+ expectedEvent + "\"</b> ;\"Actual - \" Profile page Feeds ::\" User Created Event is not "
								+ "displayed in Profile page Events tab :" + actualEvent + "\"</b>");
				break;
			default:
				Assert.fail(""+"&"+e.getMessage()+"");
			}
		}  
	}
	
	/*
	 * @author: Aishwarya
	 * Description: Verify Created event in Home page
	 * Created on : 26-05-2020
	 */
	public void verifyDisplayofDeletedEventInHomePage(String... strings)
	{
		ExtentTestManager.getTest().log(LogStatus.INFO, " "+ strings[0]  +" ::  Deleted Event is removed from the"
				+ "  Home Page Feeds or not with following assertions : ");
		String actualEvent=null;
		String expectedEvent=strings[1];
		try
		{
			genericfunctions.scrollToElement(eventPageObjects.eventTitle_HomePageFeeds);
			genericfunctions.waitTillTheElementIsVisible(eventPageObjects.eventTitle_HomePageFeeds);
			actualEvent=eventPageObjects.eventTitle_HomePageFeeds.getText().trim();
			Assert.assertEquals(actualEvent, expectedEvent);
			ExtentTestManager.getTest().log(LogStatus.PASS, " \"Home page Feeds : \" Deleted "
					+ "Event  : <b>\"" +actualEvent+ "\"</b>" + " is successfully removed from the Home page feeds");
		} 
		catch (Throwable e)
		{
			String actualException=e.getClass().getName();
			switch (actualException)
			{
			case "NoSuchElementException":
				Assert.fail("Expected ::\"Home page Feeds - \" User Deleted Event should be removed from Home page feed "
						+ "; Actual ::  \" Home page Feeds - \" User Deleted Event is not removed from Home page feed "
						+ "is not displayed"+"&"+e.getMessage()+"" );
				break;
			case "AssertionError":
				Assert.fail("Expected ::\"Home page Feeds :: \" User Deleted Event should be removed from Home page feed ;  <b>\"" 
						+ expectedEvent + "\"</b> ;\"Actual ::  \" Home page Feeds ::\" User Deleted Event is not "
								+ "removed from Home page feed" + actualEvent + "\"</b>");
				break;
			default:
				Assert.fail(""+"&"+e.getMessage()+"");
			}
		}    
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
