package com.aeione.ops.generic;

import java.text.DateFormatSymbols;
import java.time.LocalDate;
import java.time.Period;
import java.util.Iterator;

import org.apache.commons.lang3.RandomStringUtils;
import org.json.JSONException;
import org.json.JSONObject;

import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.AssertJUnit;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.relevantcodes.extentreports.LogStatus;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.comparison.ImageDiff;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.Date;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.comparator.LastModifiedFileComparator;
import org.apache.commons.io.filefilter.WildcardFileFilter;
import org.apache.log4j.Logger;

import java.util.Random;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;

import javax.imageio.ImageIO;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Qualitrix Technologies Pvt Ltd. Purpose: To have all set of
 * generic methods which are used across the project
 */

public class GenericFunctions // implements IAutoConst//
{
	 public WebDriver driver;
	 WebDriverWait wait = null;
	    

	    public GenericFunctions(WebDriver driver) {
	        this.driver = driver;
	    }

	public Select select;
	public Action action;
	String sStackTrace;

	 Logger log = Logger.getLogger(GenericFunctions.class.getName());

	private  final int BUFFER_SIZE = 4096;
	 List<String> dialCodeName = new ArrayList<>();
	 List<String> filterDialCode = new ArrayList<>();
	 List<String> oddPosition = new ArrayList<>();

	/**
	 * Purpose: selectValueFromDropdown method selects the value from the dropdown
	 * list
	 */
	public  void selectValueFromDropdown(WebDriver driver, String locator, String text) {

		WebElement lang = driver.findElement(By.xpath(locator));
		List<WebElement> list = lang.findElements(By.xpath(locator));
		for (WebElement opt : list) {
			String value = opt.getText();
			if (value.equalsIgnoreCase(text)) {
				System.out.println("Value clicked =" + value);
				opt.click();
			}
		}
	}

	/**
	 * Purpose: setClipboardData method is used to select and set data to clipboard
	 */
	public  void setClipboardData(String string) {
		// StringSelection is a class that can be used for copy and paste operations.
		StringSelection stringSelection = new StringSelection(string);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
	}

	/**
	 * Purpose: uploadFile method is used to upload file from the system to the
	 * application
	 */
	public  void uploadFile(String fileLocation) {
		try {
			// Setting clipboard with file location
			setClipboardData(fileLocation);
			// native key strokes for CTRL, V and ENTER keys
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
		} catch (Exception exp) {
			System.out.println("Failed uploading document");
			exp.printStackTrace();
		}
	}

	/**
	 * Purpose: writeNotepad method is used to write the content into file
	 */
	public  void writeNotepad(String processID, String fileName) {
		try {
			BufferedWriter bWriter = new BufferedWriter(new FileWriter(fileName));
			bWriter.write(processID);
			System.out.println("Write ID: " + processID);
			bWriter.newLine();
			bWriter.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	/**
	 * Purpose: readFromNotepad method is used to read the content into file
	 */
	@SuppressWarnings("resource")
	public  String readFromNotepad(String fileName) {
		String path = "";
		try {
			BufferedReader bReader = new BufferedReader(new FileReader(fileName));
			while ((path = bReader.readLine()) != null) {
				System.out.println("Read ID: " + path);
				String str = bReader.readLine();
				// System.out.println(str);
				return path;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return path;
	}

	/**
	 * Purpose: waitTillTheElementIsVisibleAndClickable method is used to
	 * synchronize element appearance
	 */
	public  void waitTillTheElementIsVisibleAndClickable(WebElement element) {

		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(element));

		wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	/**
	 * Purpose: waitTillTheElementInVisible method is used to synchronize single
	 * element to disappear
	 */
	public void waitTillTheElementInVisible(WebElement element) {

		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.invisibilityOf(element));
	}
	

	/**
	 * Purpose: waitTillTheElementIsVisible method is used to synchronize single
	 * element to disappear
	 */
	public void waitTillTheElementIsVisible(WebElement element) {

		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(element));
		
	}

	/**
	 * Purpose: waitForPageToLoad method is used to synchronize with whole page to
	 * load with clickable action
	 */
	public  void waitForPageToLoad(WebElement id) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(id));
	}



	/**
	 * Purpose: waitForElementState method is used to synchronize with element
	 * staleness
	 */
	public  void waitForElementState(WebElement id) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.stalenessOf(id));

		wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(id));
	}

	/**
	 * Purpose: waitForPageToLoad method is used to synchronize with whole page to
	 * load with visibility action
	 */
	public  void waitForPageToLoad(List<WebElement> id) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfAllElements(id));
	}

	/**
	 * Purpose: waitForPageToLoad method is used to synchronize with whole page to
	 * load with visibility action
	 */
	public  void waitForElementToDisAppear(List<WebElement> id) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.invisibilityOfAllElements(id));
	}

	/**
	 * Purpose: waitForElementToDisAppear method is used to synchronize all elements
	 * to disappear
	 */
	public  void waitForElementToDisAppear(List<WebElement> id, int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		wait.until(ExpectedConditions.invisibilityOfAllElements(id));
	}

	/**
	 * Purpose: waitForElementToAppear method is used to synchronize for an element
	 * to be visible
	 */
	public  WebElement waitForElementToAppear(WebElement id) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(id));
		return id;
	}

	/**
	 * Purpose: waitForElementToAppear method is used to synchronize for an element
	 * to be visible with parameterised time
	 */
	public WebElement waitForElementToAppear(WebElement id, int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		wait.until(ExpectedConditions.visibilityOf(id));
		return id;
	}

	/**
	 * Purpose: waitForElement method is used to synchronize for an element to be
	 * visible with parameterised time
	 */
	public WebElement waitForElement(WebElement arg) {
		waitForPageToLoad(arg);
		WebElement el = arg;
		return el;
	}

	/**
	 * Purpose: WaitForFrameAndSwitchToIt method is used to synchronize and shift
	 * between the frames
	 */
	public  void WaitForFrameAndSwitchToIt(WebElement frame) {
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frame));
	}

	/**
	 * Purpose: WaitForFrameAndSwitchToIt method is used to synchronize and shift
	 * between the frames using id
	 */
	public  void WaitForFrameAndSwitchToIt(int id) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(id));
	}

	public void waitTillElementAttributeToBeNotEmpty(WebElement element, String attribute)
	{
		WebDriverWait wait = new WebDriverWait(driver, 8);
		wait.until(ExpectedConditions.visibilityOf(element));

		wait.until(ExpectedConditions.attributeToBeNotEmpty(element, attribute));
	}


	public void waitTillElementToBeDisappearByLocator( By locator)
	{
		WebDriverWait wait = new WebDriverWait(driver,3);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
	}

	/**
	 * wait till element to be visible by locator
	 * @autor Kirthana
	 * @param locator
	 */
	public void waitTillElementToBeVisibleByLocator( By locator)
	{
		WebDriverWait wait = new WebDriverWait(driver,3);
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	/**
	 * Purpose: scrollToElement method is used to scroll across the application with
	 * respect to element specified
	 */
	public  void scrollToElement(WebElement element) {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
	}

	/**
	 * Purpose: waitForElements method is used to synchronize with page to load with
	 * elements
	 */
	public  void waitForElements(List<WebElement> arg) {
		waitForPageToLoad(arg);
	}

	/**
	 * Purpose: waitForElementToAppearOnScreen method is used to synchronize with
	 * element to appear
	 */
	public  WebElement waitForElementToAppearOnScreen(WebElement arg) {
		waitForElementToAppear(arg);
		WebElement el = arg;
		return el;
	}

	/**
	 * Purpose: clickUntilElementExists method is used to click on multiple
	 * occurence of prompt window
	 */
	public  void clickUntilElementExists(WebElement clickLocator, By by) {
		boolean elementOnScreen;
		int i = 0;
		do {
			if (i == 25) {
				break;
			}
			try {
				driver.findElement(by);
				break;
			} catch (NoSuchElementException e) {
				clickLocator.click();
				elementOnScreen = false;
				System.out.println(i);
			}
			i++;
		} while (!elementOnScreen);
	}

	/**
	 * Purpose: isElementPresent method return whether the element is present on web
	 * page or not
	 */
	public boolean isElementPresent(WebElement locator) {
		try {
			if (locator.isDisplayed())
				System.out.println("Element present on screen ***********" + locator);
			return true;
		} catch (NoSuchElementException e) {
			System.out.println("Element not present on screen **************" + locator);
			return false;
		}
	}

	/**
	 * Purpose: refreshWebPage method refreshes the web page
	 */
	public  void refreshWebPage() {
		waitWebDriver(2000);
		driver.navigate().refresh();
		waitWebDriver(2500);
		// createUserPageObj.handlePopupOnLogin();

	}

	/**
	 * Purpose: waitWebDriver method used parameterised time input for
	 * synchronization
	 */
	public  void waitWebDriver(long time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			System.out.println("Method: waitWebDriver :: exception =  " + e.getMessage());

		}
	}

	public  void scrollDownByPixel() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,350)", "");
	}

	/**
	 * Purpose: switchToNewWindow method is used to switch the control between
	 * multiple windows
	 */
	public  void switchToNewWindow() {
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}
	}

	/**
	 * Purpose: switchToNewWindow method is used to switch the control between
	 * multiple windows
	 */
	public  void switchToFrame(WebDriver mDriver, WebElement frame) {
		try {
			mDriver.switchTo().frame(frame);
		} catch (Exception e) {
			log.error("Method: switchToFrame :: Exception is = " + e.getMessage());
		}
	}

	/**
	 * Purpose: keyTab method is used to switch to next field using TAB
	 */
	public  void keyTab(WebDriver mDriver, String locator) {

		try {
			log.info("MethodName: keyTab :: element found = " + locator);

			mDriver.findElement(By.cssSelector(locator)).sendKeys(Keys.TAB);
		} catch (Exception e) {
			log.error("MethodName: TabKeys :: Exception occured for locator = " + locator + "exception = "
					+ e.getMessage());
		}
	}

	/**
	 * Purpose: getValue method is used to read values from the webelement
	 */
	public  String getValue(WebDriver mDriver, String identifyBy, String locator) {
		boolean assertElementExists = false;
		String value = "";

		try {
			assertElementExists = assertIfElementExists(mDriver, identifyBy, locator);
			log.info("Method: getValue :: assertElementExists = " + assertElementExists + " for xpath = " + locator);
			if (assertElementExists == true) {
				if (identifyBy.equalsIgnoreCase("xpath"))
					value = mDriver.findElement(By.xpath(locator)).getText();
				else if (identifyBy.equalsIgnoreCase("id"))
					value = mDriver.findElement(By.id(locator)).getText();
				else if (identifyBy.equalsIgnoreCase("name"))
					value = mDriver.findElement(By.name(locator)).getText();
				else if (identifyBy.equalsIgnoreCase("css"))
					value = mDriver.findElement(By.cssSelector(locator)).getText();
			}
		} catch (Exception e) {
			log.error(
					"Method: getValue :: Exception occured for locator = " + locator + "exception = " + e.getMessage());
		}
		log.info("Method: getValue :: value of element = " + value);
		return value.trim();
	}

	/**
	 * Purpose: assertIfElementExists method is used to whether the element exists
	 * on web page
	 */
	public  boolean assertIfElementExists(WebDriver mDriver, String identifyBy, String locator) throws Exception {
		boolean bElementFound = false;
		try {
			if (identifyBy.equalsIgnoreCase("xpath")) {
				bElementFound = mDriver.findElement(By.xpath(locator)).isDisplayed();
			} else if (identifyBy.equalsIgnoreCase("id")) {
				bElementFound = mDriver.findElement(By.id(locator)).isDisplayed();
			} else if (identifyBy.equalsIgnoreCase("name")) {
				bElementFound = mDriver.findElement(By.name(locator)).isDisplayed();
			} else if (identifyBy.equalsIgnoreCase("css")) {
				bElementFound = mDriver.findElement(By.cssSelector(locator)).isDisplayed();
			} else if (identifyBy.equalsIgnoreCase("linktext")) {
				bElementFound = mDriver.findElement(By.linkText(locator)).isDisplayed();
			} else if (identifyBy.equalsIgnoreCase("partialtext")) {
				bElementFound = mDriver.findElement(By.partialLinkText(locator)).isDisplayed();
			} else {
				log.info("None of the Element Selected Please check the Element Once: ");
			}
		} catch (Exception e) {
			log.error("Method: assertIfElementExists :: Exception occured for locator = " + locator + " exception is = "
					+ e.getMessage());
			AssertJUnit.assertTrue(false);

		}
		log.info("Method: assertIfElementExists for locator = " + locator + " status = " + bElementFound);
		return bElementFound;
	}

	/**
	 * Purpose: assertElementValue method is used to verify with actual and expected
	 * webelement value
	 */
	public  boolean assertElementValue(WebDriver mDriver, String identifyBy, String locator,
			String expectedValue) {
		String actualElementValue = "";
		actualElementValue = getValue(mDriver, identifyBy, locator);
		expectedValue = expectedValue.trim();

		log.info("Method: assertElementValue :: actualElementValue = " + actualElementValue + " expectedValue = "
				+ expectedValue);

        return expectedValue.equals(actualElementValue) == true;
	}

	/**
	 * Purpose: randomCourseName method is used to generate random string input for
	 * course name
	 */
	public  String randomCourseName() {

		char[] chars = "abcdefghijklmnopqrstuvwxyz0123456789".toCharArray();
		StringBuilder sb = new StringBuilder();
		Random random = new Random();
		for (int i = 0; i < 8; i++) {
			char c = chars[random.nextInt(chars.length)];
			sb.append(c);
		}
		String output = sb.toString();
		return output;
	}

	/**
	 * Purpose: testDataIncrementer method is used to increment the values
	 */
	@Test
	public  String testDataIncrementer(String filePath) {

		String courseNum = readFromNotepad(filePath);
		Pattern compile = Pattern.compile("^(.*?)([9Z]*)$");
		Matcher matcher = compile.matcher(courseNum);
		String left = "";
		String right = "";
		if (matcher.matches()) {
			left = matcher.group(1);
			right = matcher.group(2);
		}
		courseNum = !left.isEmpty() ? Long.toString(Long.parseLong(left, 36) + 1, 36) : "";
		courseNum += right.replace("Z", "A").replace("9", "0");
		writeNotepad(courseNum, filePath);
		return courseNum.toUpperCase();
	}

	/**
	 * Purpose: isFileDownloaded_Ext method is used to check if file is downloaded
	 */
	public  boolean isFileDownloaded_Ext(String dirPath, String ext) {
		boolean flag = false;
		File dir = new File(dirPath);
		File[] files = dir.listFiles();
		if (files == null || files.length == 0) {
			flag = false;
		}

		for (int i = 1; i < files.length; i++) {
			if (files[i].getName().contains(ext)) {
				flag = true;
			}
		}
		return flag;
		// ExtentTestManager.getTest().log(LogStatus.INFO, "file exist in the
		// location");
	}

	/**
	 * Purpose: captureScreenshotOnValidation method is used to capture screenshot
	 * of web page
	 */
	public  void captureScreenshotOnValidation()
	{
		try {
			waitWebDriver(1500);
			String base64Screenshot = "data:image/png;base64,"
					+ ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
			ExtentTestManager.getTest().log(LogStatus.INFO, "CONTENT VALIDATED",
					ExtentTestManager.getTest().addBase64ScreenShot(base64Screenshot));
		} catch (Exception e) {
			System.out.println("Method: waitWebDriver :: exception =  " + e.getMessage());
		}
	}

	/**
	 * Purpose: assertIfAllElementsExists method is check if list of all elements
	 * exist on web page
	 */
	public  boolean assertIfAllElementsExists(WebDriver mDriver, List<WebElement> locator) throws Exception {
		boolean bElementFound = false;
		try {

			for (WebElement opt : locator) {
				boolean value = opt.isDisplayed();
				if (value == true) {
					AssertJUnit.assertTrue(true);
					log.info(value + " found as related to Dial Code searched");
				}
			}

		} catch (Exception e) {
			log.error("Method: assertIfElementExists :: Exception occured for locator = " + locator + " exception is = "
					+ e.getMessage());
			Assert.assertTrue(false,
					"***Method: assertIfElementExists: Exception occured for locator= " + e.getMessage());
		}
		log.info("Method: assertIfElementExists for locator = " + locator + " status = " + bElementFound);
		return bElementFound;
	}

	/**
	 * Purpose: assertElementValue method is used to check for element value
	 */
	public  boolean assertElementValue(WebDriver mDriver, String identifyBy, WebElement locator,
			String expectedValue) {
		String actualElementValue = "";
		actualElementValue = getValue(mDriver, identifyBy, locator);
		expectedValue = expectedValue.trim();

		log.info("Method: assertElementValue :: actualElementValue = " + actualElementValue + " expectedValue = "
				+ expectedValue);

        return expectedValue.equals(actualElementValue) == true;
	}

	/**
	 * Purpose: assertElementValueByWebElement method is used to check for web
	 * element value
	 */
	public  boolean assertElementValueByWebElement(WebDriver mDriver, String identifyBy, WebElement locator,
			String expectedValue) {
		String actualElementValue = "";
		actualElementValue = getValueFromWebElement(mDriver, identifyBy, locator);
		expectedValue = expectedValue.trim();

		log.info("Method: assertElementValue :: actualElementValue = " + actualElementValue + " expectedValue = "
				+ expectedValue);

        return expectedValue.equals(actualElementValue) == true;
	}

	/**
	 * Purpose: getValue method is used to fetch value from webelement
	 */
	public  String getValue(WebDriver mDriver, String identifyBy, WebElement locator) {
		boolean assertElementExists = false;
		String value = "";

		try {
			// assertElementExists = assertIfElementExists(mDriver, identifyBy, locator);
			log.info("Method: getValue :: assertElementExists = " + assertElementExists + " for xpath = " + locator);
			if (assertElementExists == true) {
				if (identifyBy.equalsIgnoreCase("xpath"))
					value = locator.getText();
				else if (identifyBy.equalsIgnoreCase("id"))
					value = locator.getText();
				else if (identifyBy.equalsIgnoreCase("name"))
					value = locator.getText();
				else if (identifyBy.equalsIgnoreCase("css"))
					value = locator.getText();
			}
		} catch (Exception e) {
			log.error(
					"Method: getValue :: Exception occured for locator = " + locator + "exception = " + e.getMessage());
			// e.printStackTrace();
		}
		log.info("Method: getValue :: value of element = " + value);
		// System.out.println("Method: getValue :: value of element = " + value);
		return value.trim();
	}

	/**
	 * Purpose: getValue method is used to fetch value from webelement
	 */
	public  String getValueFromWebElement(WebDriver mDriver, String identifyBy, WebElement locator) {
		boolean assertElementExists = false;
		String value = "";

		try {

			log.info("Method: getValue :: assertElementExists = " + assertElementExists + " for xpath = " + locator);
			if (assertElementExists == true) {
				if (identifyBy.equalsIgnoreCase("xpath"))
					value = locator.getText();
				else if (identifyBy.equalsIgnoreCase("id"))
					value = locator.getText();
				else if (identifyBy.equalsIgnoreCase("name"))
					value = locator.getText();
				else if (identifyBy.equalsIgnoreCase("css"))
					value = locator.getText();
			}
		} catch (Exception e) {
			log.error(
					"Method: getValue :: Exception occured for locator = " + locator + "exception = " + e.getMessage());
			// e.printStackTrace();
		}
		log.info("Method: getValue :: value of element = " + value);

		return value.trim();
	}

	// Nov 27
	/**
	 * Purpose: assertIfElementExists1 method is used to check if the element exist
	 * on the page or not.
	 */
	public  boolean assertIfElementExists1(WebDriver mDriver, String identifyBy, WebElement locator)
			throws Exception {
		boolean bElementFound = false;
		try {
			if (identifyBy.equalsIgnoreCase("xpath")) {
				bElementFound = locator.isDisplayed();
			} else if (identifyBy.equalsIgnoreCase("id")) {
				bElementFound = locator.isDisplayed();
			} else if (identifyBy.equalsIgnoreCase("name")) {
				bElementFound = locator.isDisplayed();
			} else if (identifyBy.equalsIgnoreCase("css")) {
				bElementFound = locator.isDisplayed();
			} else if (identifyBy.equalsIgnoreCase("linktext")) {
				bElementFound = locator.isDisplayed();
			} else if (identifyBy.equalsIgnoreCase("partialtext")) {
				bElementFound = locator.isDisplayed();
			} else {
				log.info("None of the Element Selected Please check the Element Once: ");
			}
		} catch (Exception e) {
			log.error("Method: assertIfElementExists :: Exception occured for locator = " + locator + " exception is = "
					+ e.getMessage());
			Assert.assertTrue(false,
					"***Method: assertIfElementExists: Exception occured for locator= " + e.getMessage());
		}
		log.info("Method: assertIfElementExists for locator = " + locator + " status = " + bElementFound);
		return bElementFound;
	}

	/**
	 * Purpose: FetchFieldsAndAssert method is used to validate the expected field
	 * is available or not.
	 */
	public  void FetchFieldsAndAssert(WebElement ele, String ExpValue) {
		try {
			waitWebDriver(2000);
			String Actual = ele.getText();

			Assert.assertEquals(Actual, ExpValue);
			ExtentTestManager.getTest().log(LogStatus.PASS, ExpValue + "    Field Verified Succesfully");
		} catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed on Fetching & Asserting Fields");
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Exception Message: " + e.getLocalizedMessage());

			Assert.fail("Failed on Fetching & Asserting Fields");

		}
	}

	/**
	 * Purpose: clickOnElementUsingJavascript method is used to click on the element
	 * using javascript.
	 */
	public  void clickOnElementUsingJavascript(WebElement element) throws Exception {
		try {
			if (element.isEnabled() && element.isDisplayed()) {
				// GenericFunctions.waitForElementToAppear(element);
				waitWebDriver(2000);
				((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
			} else {
				log.info("Unable to click on element");
			}
		} catch (StaleElementReferenceException e) {
			log.info("Element is not attached to the page document " + e.getStackTrace());
		} catch (NoSuchElementException e) {
			log.info("Element was not found in DOM " + e.getStackTrace());
		} catch (Exception e) {
			log.info("Unable to click on element " + e.getStackTrace());
		}
	}

	/**
	 * Purpose: scrollTillEndOfPage method is used to navigate til the end of the
	 * page.
	 */

	public  void scrollTillEndOfPage() {

		// ((JavascriptExecutor)
		// driver).executeScript("window.scrollTo(0,document.body.scrollHeight )");
		((JavascriptExecutor) driver).executeScript("scroll(0, 250);");

	}

	/**
	 * Purpose: compareTwoImages method is used to compare the screenshot taken on
	 * runtime with a stored expected one.
	 */
	public  void compareTwoImages() {
		try {
			waitWebDriver(1500);
			BufferedImage expectedImage = ImageIO.read(new File("./screenshot/ + img1.png"));
			Screenshot myScreenshot = new AShot().takeScreenshot(driver);
			BufferedImage actualImage = myScreenshot.getImage();
			ImageDiffer imgDiff = new ImageDiffer();
			ImageDiff diff = imgDiff.makeDiff(expectedImage, actualImage);
			// int status = diff.hashCode();
			// System.out.println(status);

			Assert.assertTrue(diff.hasDiff());
			// BufferedImage DiffImage = diff.getDiffImage();

			// String base64Screenshot =
			// imgToBase64String(DiffImage,"png");//"data:image/png;base64,"+((TakesScreenshot)driver).getScreenshotAs(OutputType.BASE64);
			// ExtentTestManager.getTest().log(LogStatus.INFO,"CONTENT
			// VALIDATED",ExtentTestManager.getTest().addBase64ScreenShot(base64Screenshot));

			System.out.println("Images are Same");

		} catch (Exception e) {
			System.out.println("Method: waitWebDriver :: exception =  " + e.getMessage());
		}

	}

	/**
	 * Purpose: isElementClickable method return whether the element is clickable on
	 * web page or not
	 */
	public  boolean isElementClickable(WebElement locator) {
		try {
			if (locator.isEnabled())
				System.out.println("Element clickable on screen ***********" + locator);
			return true;
		} catch (NoSuchElementException e) {
			System.out.println("Element not clickable on screen **************" + locator);
			return false;
		}
	}

	public  void scrollToStartOfPage() {
		try {// ((JavascriptExecutor)
				// driver).executeScript("window.scrollTo(0,document.body.scrollHeight )");
			((JavascriptExecutor) driver).executeScript("scroll(0,-450);");
		} catch (Exception e) {
			System.out.println("Could not scroll to the Start of the page " + e.getLocalizedMessage());
		}
	}

	/**
	 * Purpose: scrollTillEndOfPage method is used to navigate til the end of the
	 * page.
	 */

	public  void scrollBy850pixel() {

		((JavascriptExecutor) driver).executeScript("window.scrollTo(0,document.body.scrollHeight )");
		// ((JavascriptExecutor) driver).executeScript("scroll(0, 1250);");

	}

	public void analyzeLog() {
		LogEntries logEntries = driver.manage().logs().get(LogType.BROWSER);
		for (LogEntry entry : logEntries) {
			log.info(new Date(entry.getTimestamp()) + " " + entry.getLevel() + " " + "BROWSER LOG ::"
					+ entry.getMessage());
			// do something useful with the data

		}

	}

	public void analyzeLogTemp() {
		LogEntries logEntries = driver.manage().logs().get(LogType.BROWSER);
		for (LogEntry entry : logEntries) {
			log.info(new Date(entry.getTimestamp()) + " " + entry.getLevel() + " " + "BROWSER LOG ::"
					+ entry.getMessage());
			// do something useful with the data

		}

		String scriptToExecute = "var performance = window.performance|| window.mozPerformance || window.msPerformance || window.webkitPerformance || {}; var network = performance.getEntries() || {}; return network;";
		// String scriptToExecute = "var network = performance.getEntries() || {};
		// return network;";|| window.mozPerformance || window.msPerformance ||
		// window.webkitPerformance || {}; var network = performance.getEntries() || {};
		// return network
		Object netData = ((JavascriptExecutor) driver).executeScript(scriptToExecute);
		// log.info(netData);
		ArrayList<Map<String, String>> alist = (ArrayList<Map<String, String>>) netData;
		// System.out.println(netData);
		// JSONArray json = new JSONArray(netData);JSONArray*/
		for (Map ent : alist) {
//           log.info(new Date(((LogEntry) ent).getTimestamp()) + " " +((LogEntry) ent).getLevel() + " "+"NETWORK LOG ::" + ((LogEntry) ent).getMessage());
			// do something useful with the data
			log.info("NETWORK LOG :: " + ent.toString());

		}

		// log.info(netData);

	}

	public void performanceLog() {

		// and capture the last recorded url (it may be a redirect, or the
		// original url)
		// String currentURL = driver.getCurrentUrl();

		// then ask for all the performance logs from this request
		// one of them will contain the Network.responseReceived method
		// and we shall find the "last recorded url" response
		LogEntries logs = driver.manage().logs().get("performance");

		int status = -1;

		System.out.println("\nList of log entries:\n");

		for (Iterator<LogEntry> it = logs.iterator(); it.hasNext();) {
			LogEntry entry = it.next();

			try {
				JSONObject json = new JSONObject(entry.getMessage());

				System.out.println(json.toString());

				JSONObject message = json.getJSONObject("message");
				String method = message.getString("method");

				if (method != null && "Network.responseReceived".equals(method)) {
					JSONObject params = message.getJSONObject("params");

					JSONObject response = params.getJSONObject("response");

					status = response.getInt("status");

					System.out.println("Returned response for "

							+ ": " + status);

					System.out.println("Headers: " + response.get("headers"));

				}
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			finally {
				System.out.println("\nstatus code: " + status);

			}

		}

	}

	public File renameFile(String Rename, String fileExtension) {
		String home = System.getProperty("user.home");
		File file = new File(home + "/Downloads/");
		String filepath = file.toString();

		FileRename fr = new FileRename();
		File newfile = fr.getTheNewestFile(filepath, fileExtension);
		System.out.println("New File Downloaded" + newfile);

		newfile.renameTo(new File(filepath + "/" + Rename + "." + fileExtension));
		String filename = newfile.getName();

		System.out.println("latest file is=" + filename);

		FileRename fr1 = new FileRename();
		File updated = fr1.getTheNewestFile(filepath, fileExtension);
		System.out.println("Changed file name is =" + updated);

		// return newfile;
		return updated;
	}

	public File getTheNewestFile(String filePath, String ext) {
		File theNewestFile = null;
		File dir = new File(filePath);
		FileFilter fileFilter = new WildcardFileFilter("*." + ext);
		File[] files = dir.listFiles(fileFilter);

		if (files.length > 0) {
			/** The newest file comes first **/
			Arrays.sort(files, LastModifiedFileComparator.LASTMODIFIED_REVERSE);
			theNewestFile = files[0];
		}
		return theNewestFile;
	}

	public String convertStackTraceToString(Throwable es) {
		try {
			StringWriter sw = new StringWriter();
			PrintWriter pw = new PrintWriter(sw);
			es.printStackTrace(pw);
			sStackTrace = sw.toString(); // stack trace as a string
			System.out.println(sStackTrace);
		} catch (Exception ex) {
			log.info("Could not scroll to the Start of the page " + ex.getLocalizedMessage());
		}
		return sStackTrace;
	}

	public void updateCSVColumn(String fileToUpdate, String replace, int row, int col) throws Exception {
		File inputFile = new File(fileToUpdate);

		// Read existing file
		CSVReader reader = new CSVReader(new FileReader(inputFile), ',');
		List<String[]> csvBody = reader.readAll();
		// get CSV row column and replace with by using row and column
		csvBody.get(row)[col] = replace;
		reader.close();

		// Write to CSV file which is open
		CSVWriter writer = new CSVWriter(new FileWriter(inputFile), ',');
		writer.writeAll(csvBody);
		writer.flush();
		writer.close();
	}

	public void removeAllDataFromCSV(String fileToUpdate) throws Exception {
		CSVReader reader2 = new CSVReader(new FileReader(fileToUpdate));
		List<String[]> allElements = reader2.readAll();
		allElements.removeAll(allElements);
		FileWriter sw = new FileWriter(fileToUpdate);
		CSVWriter writer = new CSVWriter(sw);
		writer.writeAll(allElements);
		writer.close();
	}

	public void removeParticularRowFromCSV(String fileToUpdate, int row) throws Exception {
		CSVReader reader2 = new CSVReader(new FileReader(fileToUpdate));
		List<String[]> allElements = reader2.readAll();
		allElements.remove(row);
		FileWriter sw = new FileWriter(fileToUpdate);
		CSVWriter writer = new CSVWriter(sw);
		writer.writeAll(allElements);
		writer.close();
	}

	public void addDataInCSV(String fileToUpdate, int row, String[] value) throws Exception {
		CSVReader reader2 = new CSVReader(new FileReader(fileToUpdate));
		List<String[]> allElements = reader2.readAll();
		allElements.add(row, value);
		FileWriter sw = new FileWriter(fileToUpdate);
		CSVWriter writer = new CSVWriter(sw);
		writer.writeAll(allElements);
		writer.close();
	}

	public void handleAlert() throws Exception {
		try {
			Alert alert = driver.switchTo().alert();
			alert.accept();
			waitWebDriver(2000);
		} catch (Exception e) {
			Assert.fail("unable to handle alert");
		}
	}

	public String fetchDataFromCSV(String fileToUpdate, int row) throws Exception {
		CSVReader reader2 = new CSVReader(new FileReader(fileToUpdate));
		List<String[]> allElements = reader2.readAll();

		String[] arrayData = allElements.get(row);
		String SingleData = arrayData[6];
		System.out.println(SingleData);
		return SingleData;
	}

	public void unzip(String zipFilePath, String destDirectory) throws IOException {

		File destDir = new File(destDirectory);
		if (!destDir.exists()) {
			destDir.mkdir();
		}
		ZipInputStream zipIn = new ZipInputStream(new FileInputStream(zipFilePath));
		ZipEntry entry = zipIn.getNextEntry();
		// iterates over entries in the zip file
		while (entry != null) {
			String filePath = destDirectory + File.separator + entry.getName();
			if (!entry.isDirectory()) {
				// if the entry is a file, extracts it
				extractFile(zipIn, filePath);
			} else {
				// if the entry is a directory, make the directory
				File dir = new File(filePath);
				dir.mkdir();
			}
			zipIn.closeEntry();
			entry = zipIn.getNextEntry();
		}
		zipIn.close();
	}

	/**
	 * Extracts a zip entry (file entry)
	 * 
	 * @param zipIn
	 * @param filePath
	 * @throws IOException
	 */
	private void extractFile(ZipInputStream zipIn, String filePath) throws IOException {

		BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(filePath));
		byte[] bytesIn = new byte[BUFFER_SIZE];
		int read = 0;
		while ((read = zipIn.read(bytesIn)) != -1) {
			bos.write(bytesIn, 0, read);
		}
		bos.close();
	}

	public  void readZipFile(String zipFilePath) {
		try {

			ZipFile zipFile = new ZipFile(zipFilePath);

			Enumeration<? extends ZipEntry> entries = zipFile.entries();

			while (entries.hasMoreElements()) {
				ZipEntry entry = entries.nextElement();
				String name2 = entry.getName();
				// System.out.println(name);
				long compressedSize = entry.getCompressedSize();
				long normalSize = entry.getSize();
				String type = entry.isDirectory() ? "DIR" : "FILE";

				System.out.println(name2);

				// System.out.format("\t %s - %d - %d\n", type, compressedSize, normalSize);
			}

			zipFile.close();
		} catch (IOException ex) {
			System.err.println(ex);
		}

	}

	public  List<String> readDialCodeValue(String zipFilePath) {
		try {
			ZipFile zipFile = new ZipFile(zipFilePath);

			Enumeration<? extends ZipEntry> entries = zipFile.entries();
			while (entries.hasMoreElements()) {
				ZipEntry entry = entries.nextElement();
				String name = entry.getName();
				long compressedSize = entry.getCompressedSize();
				long normalSize = entry.getSize();
				String type = entry.isDirectory() ? "DIR" : "FILE";
				dialCodeName.add(name);
			}

			zipFile.close();
		} catch (IOException ex) {
			System.err.println(ex);
		}

		String[] item = dialCodeName.toArray(new String[dialCodeName.size()]);

		for (int i = 0; i < dialCodeName.size(); i++) {
			String dialcode = item[i].substring(2, 8);
			filterDialCode.add(dialcode);

		}

		return filterDialCode;
	}

	public  boolean IsAlphaNumeric(String value) {

		boolean isAlphaNumeric = value != null && value.chars().allMatch(Character::isLetterOrDigit);
		log.info("IsAlphaNumeric: " + isAlphaNumeric);
		return isAlphaNumeric;
	}

	public  void pressEnter() {
		try {

			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);

		} catch (Exception exp) {
			log.info("Failed uploading document");
			exp.printStackTrace();
		}
	}

	public  void sortAlphabetically(String[] resource) {

		try {
			int siz = resource.length;

			ArrayList<String> list = new ArrayList<String>();
			for (int i = 0; i < siz; i++) {
				list.add(resource[i]);
			}

			Collections.sort(list);
			System.out.println(list);

		} catch (Exception e) {
			log.info("Sorting the resource card alphabetically");
			e.printStackTrace();
		}
	}

	public  List<String> ExtractOddPositionNumber(String value) {
		String firstodd = value.substring(1, 2);
		String secondodd = value.substring(3, 4);
		String thirdodd = value.substring(5, 6);
		oddPosition.add(firstodd);
		oddPosition.add(secondodd);
		oddPosition.add(thirdodd);

		return oddPosition;
	}

	public  void IsNumeric(String value)
	{

		String string = value;
		boolean numeric = true;
		try {
			Double num = Double.parseDouble(string);
		} catch (NumberFormatException e) {
			numeric = false;
		}
		if (numeric) {
			ExtentTestManager.getTest().log(LogStatus.INFO, value + " is Number");

			System.out.println(string + " is a number");
		} else

			System.out.println(string + " is not a number");
	}






	public static String generateRandomEmail(int length, String emailExtention)
	{
		// log.info("Generating a Random email String");
		String allowedChars = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String email = "";
		String temp = RandomStringUtils.random(length, allowedChars);
		email = temp + emailExtention.trim();
		return email;
	}

	public  String generateRandomPhoneNumber(int length)
	{
		// log.info("Generating a Random email String");
		String allowedChars = "976" + "1234567890";
		String phonenumber = "";
		String temp = RandomStringUtils.random(length, allowedChars);
		phonenumber = ("9") + temp;
		return phonenumber;
	}




	public static String generateRandomName(int length)
	{
		// log.info("Generating a Random email String");
		String allowedChars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String email = "";
		String temp = RandomStringUtils.random(length, allowedChars);
		email = temp;
		return email;
	}

	public static String generateRandomSpecialCharecter(int length)
	{
		// log.info("Generating a Random email String");
		String allowedChars = "@#$%&*";
		String specialchar = "";
		String temp = RandomStringUtils.random(length, allowedChars);
		specialchar = temp;
		return specialchar;
	}

	public  String generateRandomNumber(int length)
	{
		// log.info("Generating a Random email String");
		String allowedChars = "976" + "1234567890";
		String phonenumber = "";
		String temp = RandomStringUtils.random(length, allowedChars);
		phonenumber = ("9") + temp;
		return phonenumber;
	}



	public  String randomBirthday()
	{
		LocalDate date=LocalDate.now().minus(Period.ofDays((new Random().nextInt(365 * 70))));

		return  date.toString();


	}


	public static String getShortMonthFromNumber(int month)
	{
		if(month<0 || month>11)
		{
			return "";
		}
		return new DateFormatSymbols().getShortMonths()[month];
	}

}
