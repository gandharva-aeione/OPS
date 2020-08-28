/**
 * Created by Qualitrix Technologies Pvt Ltd.
 *
 * @author: Ajith Manjunath
 * <p>
 * Date: 09/14/2018
 * <p>
 * Purpose: Contains  methods related to start and end test report.
 */


package com.aeione.ops.generic;

import com.relevantcodes.extentreports.ExtentTest;

import java.util.HashMap;
import java.util.Map;


public class ExtentTestManager {


    static Map extentTestMap = new HashMap();


    public static synchronized ExtentTest getTest()
    {
        return (ExtentTest) extentTestMap.get((int) Thread.currentThread().getId());
    }

    public static synchronized void endTest() {
        DriverManager.getExtentReport().endTest((ExtentTest) extentTestMap.get((int) Thread.currentThread().getId()));
    }

    public static synchronized ExtentTest startTest(String testName, String desc) {

        ExtentTest test = DriverManager.getExtentReport().startTest(testName, desc);
        extentTestMap.put((int) Thread.currentThread().getId(), test);
        return test;
    }


}
