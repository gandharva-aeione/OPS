package com.aeione.ops.pageactions;


import com.aeione.ops.generic.DriverManager;
import com.aeione.ops.generic.ExtentTestManager;
import com.aeione.ops.generic.GenericFunctions;
import com.aeione.ops.pageobjects.GenericPageObjects;
import com.relevantcodes.extentreports.LogStatus;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;


public class GenericPageActions {

    GenericFunctions genericfunctions;
    GenericPageObjects genericpageobjects = new GenericPageObjects();

    Actions actions = null;
    // one instance, reuse
    private CloseableHttpClient httpClient = null;


    public GenericPageActions() throws IOException {
        genericfunctions = new GenericFunctions(DriverManager.getDriver());
        PageFactory.initElements(DriverManager.getDriver(), this);
        PageFactory.initElements(DriverManager.getDriver(), genericpageobjects);
        actions = new Actions(DriverManager.getDriver());
        httpClient = HttpClients.createDefault();
    }


    /////////////////////////////// Page Actions ///////////////////////////////////////////

    public void image() throws Exception {
        WebElement logo = DriverManager.getDriver().findElement(By.xpath("//*[@class='o-avatar-xl o-avatar-xl--prof']"));
        String logoSRC = logo.getAttribute("src");
        URL imageURL = new URL(logoSRC);
        BufferedImage saveImage = ImageIO.read(imageURL);
        ImageIO.write(saveImage, "png", new File("logo-forum.png"));
    }

   public String defectId(String defectId)
   {
     String defectID= "Defect Link - <a href='https://taiga.vnaad.com/project/admin-one-page-spotlight/issue/"+defectId+"' target='_blank'>https://taiga.vnaad.com/project/admin-one-page-spotlight/issue/"+defectId+"</a> ";
     return defectID;
   }

    /**
     * Attach_File_Image_Audio_Video
     * Author:- Gandahrva
     */
    public void attachFile(String...strings)
    {
        ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " :: Click on Upload Media File");
        String file=strings[1];
        try
        {
            genericfunctions.waitWebDriver(2000);
            genericpageobjects.attachFile_button.sendKeys(file);
            ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " :: Media File Uploaded Successfully");
        }
        catch (Exception e)
        {
            Assert.fail("Could not perform action on \"Uploading Media File\" "+"&"+e.getMessage()+"" );
        }
    }

    public void launchNewTabAndAccessURL(String... strings) throws Exception {
        String url= strings[0];


        String mainWindow = DriverManager.getDriver().getWindowHandle();
        ((JavascriptExecutor) DriverManager.getDriver()).executeScript("window.open(arguments[0])", url);
        genericfunctions.switchToNewWindow();

        Thread.sleep(10000);
    }

}
