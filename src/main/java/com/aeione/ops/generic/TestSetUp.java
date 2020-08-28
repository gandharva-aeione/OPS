package com.aeione.ops.generic;


import com.relevantcodes.extentreports.ExtentReports;
import io.github.bonigarcia.wdm.WebDriverManager;
import net.lightbody.bmp.BrowserMobProxy;
import net.lightbody.bmp.BrowserMobProxyServer;
import net.lightbody.bmp.client.ClientUtil;
import net.lightbody.bmp.core.har.Har;
import net.lightbody.bmp.proxy.CaptureType;
import org.apache.log4j.Logger;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.concurrent.TimeUnit;

import static com.aeione.ops.generic.HandleCommandsBatchFile.runBatchFile;


public abstract class TestSetUp implements IAutoConst {

    public static WebDriver driver;
    static Logger log = Logger.getLogger(GenericFunctions.class.getName());
    public BrowserMobProxy proxy;
    protected Har har = new Har();
    ReadJSONExample readJson = new ReadJSONExample();
    public static String userDirPath = null;
    public static ConfigurationManager prop;
    public static String OSName = null;
    public static String broswerversion;
    public static String broswerName;
    Capabilities browserCap = null;
    static GoogleDriveAPI dsriveapi = null;
    static String reportPath;
    static LocalDate localDate = null;


    static {

        userDirPath = System.getProperty("user.dir");
        OSName = System.getProperty("os.name").trim();
        dsriveapi = new GoogleDriveAPI();
        localDate = LocalDate.now();
        try {
            runBatchFile(DRIVER_UPDATION_BATCHFILE, OSName);
        } catch (IOException e) {
            e.printStackTrace();
        }
//        try {
//            prop = ConfigurationManager.getInstance("testData.properties");
//
//        } catch (IOException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
    }


    @Parameters({"reportName", "replaceExistingReport"})
    @BeforeTest
    public static void beforeTest(String reportName, boolean replaceExistingReport) {

        DriverManager.setReportName(reportName);
        DriverManager.setReplaceExistingReport(replaceExistingReport);

        ExtentReports extent = ExtentManager.getReporter();
        DriverManager.setExtentReport(extent);
    }


    @Parameters("testBrowserName")
    @BeforeClass(alwaysRun = true)
    public void launchApplication(String testBrowserName) throws Exception {
        // start the proxy
        proxy = new BrowserMobProxyServer();
        proxy.start(0);

        // get the Selenium proxy object
        Proxy seleniumProxy = ClientUtil.createSeleniumProxy(proxy);

        switch (testBrowserName) {

            case FIREFOX:

                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                DriverManager.setBrowserName(FIREFOX);
                break;

            case CHROME:

                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                DriverManager.setBrowserName(CHROME);
                break;

            case SAFARI:

                driver = new SafariDriver();
                DriverManager.setBrowserName(SAFARI);
                break;

            case INTERNET_EXPLORER:

                WebDriverManager.iedriver().setup();
                driver = new InternetExplorerDriver();
                DriverManager.setBrowserName(INTERNET_EXPLORER);
                break;

            case EDGE:

                WebDriverManager.edgedriver().forceDownload().setup();
                driver = new EdgeDriver();
                DriverManager.setBrowserName(EDGE);
                break;

            default:
                System.out.println("Browser is not specified ");
        }

        DriverManager.setDriver(driver);

        //Set browser version
        browserCap = ((RemoteWebDriver) DriverManager.getDriver()).getCapabilities();
        broswerversion = browserCap.getVersion();
        broswerName = DriverManager.getBrowserName();
        DriverManager.setBrowserVersion(broswerversion.trim());


        LoggingPreferences logPrefs = new LoggingPreferences();
        logPrefs.enable(LogType.BROWSER, java.util.logging.Level.ALL);
        DriverManager.getDriver().manage().window().maximize();
        DriverManager.getDriver().manage().deleteAllCookies();


        //Navigate to test url
        DriverManager.getDriver().get(TEST_APP_URL);

        //Set timeouts
        DriverManager.getDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        DriverManager.getDriver().manage().timeouts().setScriptTimeout(20, TimeUnit.SECONDS);
        DriverManager.getDriver().manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);

//      enable more detailed HAR capture, if desired (see CaptureType for the complete list)
        proxy.enableHarCaptureTypes(CaptureType.REQUEST_CONTENT, CaptureType.RESPONSE_CONTENT);
        // create a new HAR with the label "yahoo.com"
        proxy.newHar("ops");
        // get the HAR data
        har = proxy.getHar();

        // DOMConfigurator.configure(userDirPath+"/src/main/resources/log4j.xml");

    }

    @AfterMethod(alwaysRun = true)
    public void afterMethod(ITestResult iTestResult) throws Exception {
        FileOutputStream fos;

        String jsonLogFileName = "log" + "-" + DriverManager.getBrowserName().toLowerCase() + "-" + iTestResult.getTestClass().getName() + "-" + iTestResult.getMethod().getMethodName() + ".json";

        String file = userDirPath + "/json-file/" + jsonLogFileName + "";
        String newFile = userDirPath + "/json-formatted-file/" + jsonLogFileName + "";

        if (!iTestResult.isSuccess()) {
            try {

                String sFileName = userDirPath + "/HAR-Files/HAR-Information" + iTestResult.getTestClass().toString() + ".har";
                fos = new FileOutputStream(sFileName);

                har.writeTo(fos);

                File harFile = new File(sFileName);

                OutputStream out = new FileOutputStream(file);
                Writer w = new OutputStreamWriter(out, StandardCharsets.UTF_8);
                har.writeTo(harFile);
                har.writeTo(w);

                System.out.println("created json file");

                if (harFile.delete()) {
                    System.out.println("HAR File deleted from Project root directory");
                } else
                    System.out.println("HAR File  doesn't exist in the project root directory");

                ReadJSONExample.readHAR(file, newFile);

            } catch (Exception e) {
                // TODO Auto-generated catch block
                System.out.println(e.toString());
                System.out.println("Could not find file ");
                e.printStackTrace();
            }
        } else if (iTestResult.isSuccess()) {
            try {
                proxy.stop();

            } catch (Exception e) {
                System.out.println(e.toString());
                System.out.println("Couldn't stop the proxy");
                e.printStackTrace();
            }

        }

        try {
            System.out.println("Test Execution Completed : Closing the browser");
            ReadJSONExample.readHAR(file, newFile);
            proxy.stop();

        } catch (Exception e) {
            // TODO Auto-generated catch block
            System.out.println(e.toString());
            System.out.println("Couldn't close the browser");
            e.printStackTrace();
        }
    }


    @AfterClass
    public static void closeApplication() {
        DriverManager.getDriver().manage().deleteAllCookies();
        DriverManager.getDriver().quit();
    }


    @Parameters({"shareReportToGoogleDrive", "isParallel"})
    @AfterTest
    public static void afterTest(boolean shareReportToGoogleDrive, boolean isParallel) {

        ExtentTestManager.endTest();
        DriverManager.getExtentReport().flush();

        if (!isParallel == true) {
            String renamedReport = renameReport();

            if (shareReportToGoogleDrive == true) {

                //Need to update
             //  String currentDateReportFolder= dsriveapi.createSubFolder(AUTOMATION_REPORTS,String.valueOf(localDate));

                GoogleDriveAPI.getUploadFileIntoGoogleDrive(renamedReport, AUTOMATION_REPORTS);
            }
        }

    }


    @Parameters({"shareReportToGoogleDrive", "isParallel"})
    @AfterSuite
    public static void afterSuite(boolean shareReportToGoogleDrive, boolean isParallel) {

        if (isParallel == true) {
            String renamedReport = renameReport();
            if (shareReportToGoogleDrive == true) {
                GoogleDriveAPI.getUploadFileIntoGoogleDrive(renamedReport, AUTOMATION_REPORTS);
            }
        }
        removeTestFiles(IMAGE_TEST_FILE);
        removeTestFiles(VIDEO_TEST_FILE);
        removeTestFiles1("");
    }


    public static String renameReport() {
        LocalTime localTime = LocalTime.now();
        File directoryPath = new File(ExtentManager.localDirectoryPath);
        File currentFile = null;
        File newFile = null;
        String renameFileDirPath = ExtentManager.localDirectoryPath + "/";
        File[] listOfFiles = directoryPath.listFiles();

        for (int i = 0; i <= listOfFiles.length - 1; i++) {
            String currentFileName = renameFileDirPath + listOfFiles[i].getName().trim();
            String expectedReportName = renameFileDirPath + ExtentManager.reportName + ".html".trim();
            System.out.println(currentFileName);
            System.out.println(expectedReportName);

            if (currentFileName.equals(expectedReportName)) {
                currentFile = listOfFiles[i];
                newFile = new File(renameFileDirPath + "extentReport-" + OSName.toLowerCase() + "-" + broswerName.toLowerCase() + "[" + broswerversion + "]-" + localDate + "-" + localTime + ".html");
                currentFile.renameTo(newFile);
                break;
            }
        }
        return newFile.getAbsolutePath();
    }


    public static void removeTestFiles(String fileName)
    {
        String path = userDirPath + "/" + fileName;
        File file = new File(path);
        try {
            if (file.exists()) {
                file.delete();

                System.out.println("Removed test files ");
            } else {
                System.out.println("Could not remove test files");
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }


    public static void removeTestFiles1(String fileName)
    {
        String path = userDirPath + "/" + fileName;
        File file = new File(path);
        try {
            if (file.exists()) {
                file.delete();

                System.out.println("Removed test files ");
            } else {
                System.out.println("Could not remove test files");
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }
}
