/**
 * Created by Qualitrix Technologies Pvt Ltd.
 * <p>
 * Purpose: Contains all the methods which will help extent reporting.
 */


package com.aeione.ops.generic;

import com.relevantcodes.extentreports.ExtentReports;

import java.io.File;
import java.time.LocalDate;
import java.time.LocalTime;

//OB: ExtentReports extent instance created here. That instance can be reachable by getReporter() method.

public class ExtentManager extends TestSetUp {

    public static ExtentReports extent;
    public static String reportName;
    public static String localDirectoryPath;



    public static ExtentReports getReporter() {

        LocalDate localDate = LocalDate.now();
        DriverManager.setlocalTime(LocalTime.now());

        //Set HTML reporting file location
        String workingDir = System.getProperty("user.dir");
        localDirectoryPath = workingDir + "/reports/" + localDate;

        System.out.println(localDirectoryPath);

        //create Directory
        File file = new File(localDirectoryPath);
        if (!file.exists()) {
            //Creating the directory
            file.mkdir();
        }

        reportName = DriverManager.getReportName();
        reportPath = localDirectoryPath + "//" + DriverManager.getReportName() + ".html";

        extent = new ExtentReports(localDirectoryPath + "//" + DriverManager.getReportName() + ".html", DriverManager.getReplaceExistingReport());
        extent.loadConfig(new File(workingDir + "//" + "src/main/resources/" + "/extent-config.xml"));

        //Optional
       // extent.addSystemInfo("Selenium Version", "3.4");

        return extent;

    }
}
