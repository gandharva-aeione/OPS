package com.aeione.ops.pageactions;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.aeione.ops.generic.DriverManager;
import com.aeione.ops.generic.ExtentTestManager;
import com.aeione.ops.generic.GenericFunctions;
import com.aeione.ops.pageobjects.ExplorePageObjects;
import com.aeione.ops.pageobjects.HomePageObjects;
import com.aeione.ops.pageobjects.ProfilePageObjects;
import com.relevantcodes.extentreports.LogStatus;

/*
 * @author: Aishwarya
 * Description: Explore Page Actions
 * Date of Creation: 21-05-2020
 */

public class ExplorePageActions {

	GenericFunctions genericfunctions;
	ExplorePageObjects explorePageObjects = new ExplorePageObjects();
	HomePageObjects homePageObjects = new HomePageObjects();
	Actions action;

	public ExplorePageActions() throws IOException
	{

		genericfunctions = new GenericFunctions(DriverManager.getDriver());
		PageFactory.initElements(DriverManager.getDriver(), this);
		PageFactory.initElements(DriverManager.getDriver(), explorePageObjects);
		PageFactory.initElements(DriverManager.getDriver(), homePageObjects);
		action=new Actions(DriverManager.getDriver());
	}

	///////////////////////////////////////////// Page actions //////////////////////////////////////////////////////

	/*
	 * @author: Aishwarya
	 * Description: Click on Explore link from the Home page header
	 * Created on : 21-05-2020
	 */

	public void clickOnExploreLink(String... strings) {
		try 
		{
			genericfunctions.waitTillTheElementIsVisible(homePageObjects.topbar_explore);
			homePageObjects.topbar_explore.click();
		}
		catch(Exception e)
		{
			Assert.fail("Could not perform action on \"Explore \"link" +"&"+ e.getMessage());
		}
	}

	


	/////////////////////////////////////////// Page Verification ///////////////////////////////////////////////////////////	

	/*
	 * @author: Aishwarya
	 * Description: Verify navigation to the Explore page
	 * Created on : 22-05-2020
	 */
	public void verifyNavigationToExplorePage(String ...strings)
	{
		ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " ::  Navigation to the Explore page on clicking"
				+ " Explore link from Home page header with following assertions :");

		try {
			genericfunctions.waitTillTheElementIsVisible(explorePageObjects.search_TextField);
			Assert.assertTrue(explorePageObjects.search_TextField.isDisplayed());

			ExtentTestManager.getTest().log(LogStatus.PASS,  "User successfully navigated to the \" Explore page\" ");
		} catch (Exception e)
		{
			Assert.fail("Expected :: Successfully navigated to \"Explore page\"  ; Actual :: Failed to navigate to the \"Explore page\" ");
		}
	}

	/*
	 * @author: Aishwarya
	 * Description: Verify navigation to the Explore page
	 * Created on : 22-05-2020
	 */
	public void verifySuggestedHashtagsInSubHeaderOfExplorePage(Map<String, String> suggestedHashtags, String string)
	{
		
		ExtentTestManager.getTest().log(LogStatus.INFO, " " + string+ " ::  Suggested Hashtags in sub-header of Explore page"
				+ " with following assertions :");
		Map<String, String> expectedHashtags= suggestedHashtags;
		int i=0;
		ArrayList<String> actualHashtagsName=null;
		
		try {
		 List<WebElement> actualHashtags1 = explorePageObjects.suggested_HashtagsList;
		   for(i=0 ; i<=actualHashtags1.size()-1; i++)
		   {
			   actualHashtagsName.add(actualHashtags1.get(i).getText());
			   
			   //Compares both the lists by removing matching contents
			   expectedHashtags.remove(actualHashtagsName); 
		   }
		   if(expectedHashtags.size()==0)
		   {
			  ExtentTestManager.getTest().log(LogStatus.PASS , "PASS");
		   }else
		   {
			   String missingHashtags = expectedHashtags.toString();
		   Assert.fail("Expected :: \"20 default suggestion Hashtags\" should be displayed ; Actual :: " +missingHashtags+ " suggestion hashtags are not displaying");
		   }
		
		}
		   catch(Throwable e)
					{
			   Assert.fail("Failed to verify the suggestion hashtags in Explore page");
					}  

		        }
		       
		
		
		
		
					
					
		
					
	












}
