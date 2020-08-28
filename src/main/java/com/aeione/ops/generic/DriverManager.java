package com.aeione.ops.generic;




import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;

import java.time.LocalTime;

/**
 * Created by Qualitrix Technologies Pvt Ltd.
 *
 * Purpose:	To set the configuration for type of drivers
 */

public class DriverManager
{

    private static final ThreadLocal<WebDriver> webDriver = new ThreadLocal<>();

    public static WebDriver getDriver()
	{

    	return webDriver.get();
    }

    public static void setDriver(WebDriver driver)
	{
        webDriver.set(driver);
    }


    private static final ThreadLocal<String> browserName = new ThreadLocal<>();

    public static String getBrowserName()
    {

        return browserName.get();
    }

    public static void setBrowserName(String  browser)
    {

        browserName.set(browser);
    }


    private static final ThreadLocal<String> browserVersion = new ThreadLocal<>();

    public static String getBrowserVersion()
    {

        return browserVersion.get();
    }

    public static void setBrowserVersion(String  browser)
    {

        browserVersion.set(browser);
    }




    private static final ThreadLocal<ExtentReports> extentTest = new ThreadLocal<>();

    public static ExtentReports getExtentReport()
    {

        return extentTest.get();
    }

    public static void setExtentReport( ExtentReports  exntrpt)
    {

         extentTest.set(exntrpt);
    }

    private static final ThreadLocal<String> reportName = new ThreadLocal<>();

    public static String getReportName()
    {

        return reportName.get();
    }

    public static void setReportName( String  reportname)
    {

        reportName.set(reportname);
    }

    private static final ThreadLocal<Boolean> replaceExistingReport = new ThreadLocal<>();

    public static Boolean getReplaceExistingReport()
    {

        return replaceExistingReport.get();
    }

    public static void setReplaceExistingReport( Boolean  exntrpt)
    {

        replaceExistingReport.set(exntrpt);
    }

    private static final ThreadLocal<LocalTime> localTime = new ThreadLocal<>();

    public static LocalTime getlocalTime()
    {

        return localTime.get();
    }

    public static void setlocalTime( LocalTime  exntrpt)
    {

        localTime.set(exntrpt);
    }



}

