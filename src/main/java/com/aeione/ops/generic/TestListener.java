/**

* Created by Qualitrix Technologies Pvt Ltd.

* @author: Ajith Manjunath

* Date: 05/02/2018

* Purpose: Contains all the methods which will help reporting. 
*/

package com.aeione.ops.generic;
import com.relevantcodes.extentreports.LogStatus;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

public class TestListener extends TestSetUp implements ITestListener
{
	static Logger log = Logger.getLogger(GenericFunctions.class.getName());
	String  currentLocalDateAndTime;
	//ATUTestRecorder recorder;
	String screenRecordTestPath;
	 
    private static String getTestMethodName(ITestResult iTestResult) {
        return iTestResult.getMethod().getConstructorOrMethod().getName();
    }
    
    private static String getTestClassName(ITestResult iTestResult)
    {

    	return iTestResult.getMethod().getRealClass().getName();
    	
    }
    //Before starting all tests, below method runs.
    
	@Override
    public void onStart(ITestContext iTestContext)
	{
    	System.out.println("I am in onStart method " + iTestContext.getName());
    	log.info("I am in onStart method " + iTestContext.getName());
        iTestContext.setAttribute("WebDriver", driver );
        
    }
 
    //After ending all tests, below method runs.
    @Override
    public void onFinish(ITestContext iTestContext)
    {
        System.out.println("I am in onFinish method " + iTestContext.getName());
    	log.info("I am in onFinish method " + iTestContext.getName());

    }
 
    @Override
    public void onTestStart(ITestResult iTestResult) {
        System.out.println("I am in onTestStart method " +  getTestMethodName(iTestResult) + " start , I am in onTestStart class " +  getTestClassName(iTestResult) + " start");
        log.info("I am in onTestStart method " +  getTestMethodName(iTestResult) + " start , I am in onTestStart class " +  getTestClassName(iTestResult) + " start");
        
        //Start operation for extentreports.
        ExtentTestManager.startTest(iTestResult.getMethod().getMethodName(),iTestResult.getMethod().getDescription());
        //Get the class Name of the Test method

        System.out.println("Print on Test Start"+iTestResult.getTestClass().toString());

    }
 
    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        System.out.println("I am in onTestSuccess method " +  getTestMethodName(iTestResult) + " succeed , I am in onTestSuccess class " +  getTestClassName(iTestResult) + " succeed");
       log.info("I am in onTestSuccess method " +  getTestMethodName(iTestResult) + " succeed , I am in onTestSuccess class " +  getTestClassName(iTestResult) + " succeed");
        //Extentreports log operation for passed tests.
        
        ExtentTestManager.getTest().log(LogStatus.PASS, getTestClassName(iTestResult) +" Test passed");
    }
 
    @Override
    public void onTestFailure(ITestResult iTestResult)
    {
        System.out.println("I am in onTestFailure method " +  getTestMethodName(iTestResult) + " failed, I am in onTestFailure class " +  getTestClassName(iTestResult) + " failed");
        log.info("I am in onTestFailure method " +  getTestMethodName(iTestResult) + " failed, I am in onTestFailure class " +  getTestClassName(iTestResult) + " failed");

        //Get driver from BaseTest and assign to local webdriver variable.
        Object testClass = iTestResult.getInstance();

        //Take base64Screenshot screenshot.
        String base64Screenshot = "data:image/png;base64,"+((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.BASE64);

        String throwableAssertionMessage=null;
        try {
            String assertionMessage = iTestResult.getThrowable().getMessage();
            String[] a = assertionMessage.split("&");

            throwableAssertionMessage = "" + a[0] + "<br><b><font color=red>" + a[1] + "</font></b>";

        }catch(Exception e)
        {
            throwableAssertionMessage=iTestResult.getThrowable().getMessage();
        }
        ExtentTestManager.getTest().log(LogStatus.FAIL, throwableAssertionMessage);


        ExtentTestManager.getTest().log(LogStatus.FAIL,getTestClassName(iTestResult)+" Test Failed", ExtentTestManager.getTest().addBase64ScreenShot(base64Screenshot));

        String image = ExtentTestManager.getTest().addBase64ScreenShot(base64Screenshot);
        String screenPath = "<img height='42' width='42' src='" + ExtentTestManager.getTest().addBase64ScreenShot(base64Screenshot)+"'/></img>";
        Reporter.log(screenPath);


//       //   capturing browser console logs if failed
//        LogEntries logEntries = DriverManager.getDriver().manage().logs().get(LogType.BROWSER);
//		for (LogEntry entry : logEntries)
//		{
//			log.error(new Date(entry.getTimestamp()) + " " + entry.getLevel() + " " + "BROWSER LOG ::" + entry.getMessage());
//		}


    }
 
    @Override
    public void onTestSkipped(ITestResult iTestResult) 
    {
        System.out.println("I am in onTestSkipped method "+  getTestMethodName(iTestResult) + " skipped , I am in onTestSkipped class "+  getTestClassName(iTestResult) + " skipped");
        log.info("I am in onTestSkipped method "+  getTestMethodName(iTestResult) + " skipped , I am in onTestSkipped class "+  getTestClassName(iTestResult) + " skipped");
        
        //Extentreports log operation for skipped tests.
        ExtentTestManager.getTest().log(LogStatus.SKIP, getTestClassName(iTestResult)+" Test Skipped");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
        System.out.println("Test failed but it is in defined success ratio " + getTestMethodName(iTestResult));
        log.info("Test failed but it is in defined success ratio " + getTestMethodName(iTestResult));
    }
    
    
    
}