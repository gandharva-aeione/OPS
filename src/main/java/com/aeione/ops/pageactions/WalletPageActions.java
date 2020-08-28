package com.aeione.ops.pageactions;

import com.aeione.ops.generic.DriverManager;
import com.aeione.ops.generic.ExtentTestManager;
import com.aeione.ops.generic.GenericFunctions;
import com.aeione.ops.pageobjects.WalletPageObjects;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.io.IOException;

public class WalletPageActions
{
    GenericFunctions genericfunctions;
    WalletPageObjects walletPageObjects = new WalletPageObjects();
    Actions action;
    public static String newline="";


    public WalletPageActions() throws IOException {


        genericfunctions = new GenericFunctions(DriverManager.getDriver());
        PageFactory.initElements(DriverManager.getDriver(), this);
        PageFactory.initElements(DriverManager.getDriver(), walletPageObjects);
        action=new Actions(DriverManager.getDriver());
        newline = System.getProperty("line.separator");
    }

    /////////////////////////// Page Actions////////////////////////////////////////////////////////////////////////////

    public void clickOnTransactionTab(String ...strings)
    {
        ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " :: Click on <b>\"Transaction\"</b> tab");
        try
        {
            genericfunctions.waitWebDriver(1000);
            genericfunctions.waitForPageToLoad(walletPageObjects.token_transaction_tab);
            genericfunctions.waitTillTheElementIsVisible(walletPageObjects.token_transaction_tab);
            walletPageObjects.token_transaction_tab.click();
        }
        catch(Exception e)
        {
            Assert.fail("Could not perform action on \"Transaction\" tab" +"&"+ e.getMessage());
        }

    }



    public void clickOnWalletTopBar(String ...strings)
    {
        ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " :: Click on <b>\"Wallet\"</b> topBar");
        try
        {
            genericfunctions.waitWebDriver(1000);
            genericfunctions.waitForPageToLoad(walletPageObjects.topbar_wallet);
            genericfunctions.waitTillTheElementIsVisible(walletPageObjects.topbar_wallet);
            walletPageObjects.topbar_wallet.click();
        }
        catch(Exception e)
        {
            Assert.fail("Could not perform action on \"Wallet\" topBar" +"&"+ e.getMessage());
        }

    }

    public void clickOnBuyCoinsButtonInWallet(String ...strings)
    {
        ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " :: Click on <b>\"Buy Coins\"</b> button in wallet");
        try
        {
            genericfunctions.waitForPageToLoad(walletPageObjects.token_buy_coins_button);
            genericfunctions.waitTillTheElementIsVisible(walletPageObjects.token_buy_coins_button);
            walletPageObjects.token_buy_coins_button.click();
        }
        catch(Exception e)
        {
            Assert.fail("Could not perform action on \"Wallet\" topBar" +"&"+ e.getMessage());
        }

    }


    public void  dragAndDropCoinsSliderAtBuyCoinsPopup(String ...strings)
    {
        ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " :: Drag and drop  <b>\"Coins Slider\"</b> at buy coins popup");
        try
        {
            genericfunctions.waitForPageToLoad(walletPageObjects.coins_slider_BuyCoins_popup);
            genericfunctions.waitTillTheElementIsVisible(walletPageObjects.coins_slider_BuyCoins_popup);
            action.clickAndHold(walletPageObjects.coins_slider_BuyCoins_popup).dragAndDrop(walletPageObjects.coins_slider_BuyCoins_popup,walletPageObjects.spotcoins_buy_coins_textfield).build().perform();

        }
        catch(Exception e)
        {
            Assert.fail("Could not perform action on \"Coins Slider\" at buy coins popup" +"&"+ e.getMessage());
        }

    }

    public void enterCoinsInBuyCoinsPopup(String ...strings)
    {
        String coins=strings[1];
        ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " :: Enter coins as <b>\""+coins+"\"</b> in textField at buy coins popup");
        try
        {
            genericfunctions.waitForPageToLoad(walletPageObjects.spotcoins_buy_coins_textfield);
            genericfunctions.waitTillTheElementIsVisible(walletPageObjects.spotcoins_buy_coins_textfield);
            walletPageObjects.spotcoins_buy_coins_textfield.clear();
            walletPageObjects.spotcoins_buy_coins_textfield.sendKeys(coins);
        }
        catch(Exception e)
        {
            Assert.fail("Could not perform action on \"Coins\" textField at Buy coins popup" +"&"+ e.getMessage());
        }

    }




    public String getTotalCoinsToBuy(String ...strings)
    {
        String[] a=null;
        try
        {
            genericfunctions.waitForPageToLoad(walletPageObjects.total_buy_coins);
            genericfunctions.waitTillTheElementIsVisible(walletPageObjects.total_buy_coins);
            a= walletPageObjects.total_buy_coins.getText().split(" ");
        }
        catch(Exception e)
        {
            Assert.fail("Could not perform action on \"Coins to buy\" text" +"&"+ e.getMessage());
        }

        return a[0];
    }



    ////////////////////////// Page Verifications /////////////////////////////////////////////////////////////////////

    /**
     * @param
     * @autor Kirthana
     * Verify  navigation to wallet page
     *
     */
    public void verifyNavigationWalletPage(String ...strings)
    {

        ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " :: User navigates to Wallet page or not on clicking \"Wallet\" topBar  with following assertions :");

        verifyDisplayOfBuyCoinsButton();
    }


    /**
     * Verify display of  buy coins button
     *
     * @param
     * @autor Kirthana
     */

    public void verifyDisplayOfBuyCoinsButton() {
        try {
            genericfunctions.waitForPageToLoad(walletPageObjects.token_buy_coins_button);
            genericfunctions.waitTillTheElementIsVisible(walletPageObjects.token_buy_coins_button);
            Assert.assertTrue(walletPageObjects.token_buy_coins_button.isDisplayed());
            ExtentTestManager.getTest().log(LogStatus.PASS, " \"Buy Coins\" button is displaying");
        } catch (Exception e) {
            Assert.fail("Expected :: \"Buy Coins\" button should be displayed ; Actual ::\"Buy Coins\" button is not displayed" + "&" + e.getMessage() + "");
        }
    }



    /**
     * @param
     * @autor Kirthana
     * Verify  naviagation to transaction tab
     *
     */
    public void verifyNavigationToTransactionTab(String ...strings)
    {

        ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " :: User navigates to transaction tab  or not on clicking \"Transaction\" tab  with following assertions :");

        verifyDisplayOfTransactionHistoryTitle();
        verifyDisplayOfTransactionRewardsCoinsText();
        verifyDisplayOfTransactionRewardsTypeText();
        verifyDisplayOfTransactionRewardsTimeText();

    }


    /**
     * Verify display of transaction history titile text
     *
     * @param
     * @autor Kirthana
     */

    public void verifyDisplayOfTransactionHistoryTitle() {
        try {
            genericfunctions.waitForPageToLoad(walletPageObjects.transactions_history_titile);
            genericfunctions.waitTillTheElementIsVisible(walletPageObjects.transactions_history_titile);
            Assert.assertTrue(walletPageObjects.transactions_history_titile.isDisplayed());
            ExtentTestManager.getTest().log(LogStatus.PASS, " \"Transaction History\" titile text is displaying");
        } catch (Exception e) {
            Assert.fail("Expected :: \"Transaction History\" titile text should be displayed ; Actual ::\"Transaction History\" titile text is not displayed" + "&" + e.getMessage() + "");
        }
    }

    /**
     * Verify display of transaction rewards coins text
     *
     * @param
     * @autor Kirthana
     */

    public void verifyDisplayOfTransactionRewardsCoinsText() {
        try {
            genericfunctions.waitForPageToLoad(walletPageObjects.transactions_rewards_coins);
            genericfunctions.waitTillTheElementIsVisible(walletPageObjects.transactions_rewards_coins);
            Assert.assertTrue(walletPageObjects.transactions_rewards_coins.isDisplayed());
            ExtentTestManager.getTest().log(LogStatus.PASS, " \"Transaction Rewards Coins\" text is displaying as <b>\""+walletPageObjects.transactions_rewards_coins.getText()+"\"<b> ");
        } catch (Exception e) {
            Assert.fail("Expected :: \"Transaction Rewards Coins\" text should be displayed ; Actual ::\"Transaction Rewards Coins\" text is not displayed" + "&" + e.getMessage() + "");
        }
    }

    /**
     * Verify display of transaction rewards type text
     *
     * @param
     * @autor Kirthana
     */

    public void verifyDisplayOfTransactionRewardsTypeText() {
        try {
            genericfunctions.waitForPageToLoad(walletPageObjects.transactions_rewards_type);
            genericfunctions.waitTillTheElementIsVisible(walletPageObjects.transactions_rewards_type);
            Assert.assertTrue(walletPageObjects.transactions_rewards_type.isDisplayed());
            ExtentTestManager.getTest().log(LogStatus.PASS, " \"Transaction Rewards Type\" text is displaying as <b>\""+walletPageObjects.transactions_rewards_type.getText()+"\"<b>");
        } catch (Exception e) {
            Assert.fail("Expected :: \"Transaction Rewards Type\" text should be displayed ; Actual ::\"Transaction Rewards Type\" text is not displayed" + "&" + e.getMessage() + "");
        }
    }


    /**
     * Verify display of transaction rewards time text
     *
     * @param
     * @autor Kirthana
     */

    public void verifyDisplayOfTransactionRewardsTimeText() {
        try {
            genericfunctions.waitForPageToLoad(walletPageObjects.transactions_rewards_time);
            genericfunctions.waitTillTheElementIsVisible(walletPageObjects.transactions_rewards_time);
            Assert.assertTrue(walletPageObjects.transactions_rewards_time.isDisplayed());
            ExtentTestManager.getTest().log(LogStatus.PASS, " \"Transaction Rewards Time\" text is displaying as <b>\""+walletPageObjects.transactions_rewards_time.getText()+"\"<b>");
        } catch (Exception e) {
            Assert.fail("Expected :: \"Transaction Rewards Time\" text should be displayed ; Actual ::\"Transaction Rewards Time\" text is not displayed" + "&" + e.getMessage() + "");
        }
    }


    public void verifyCoinsAddedInWalletOnRegistration(String ...strings)
    {
        String expectedCoinsAdded=strings[1].trim();
        String actualCoinsAdded=null;
        ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " :: <b>\"0.25\"</b> coins added in Wallet or not on Registration with following assertions :  ");
        try
        {
            genericfunctions.waitForPageToLoad(walletPageObjects.coins);
            genericfunctions.waitTillTheElementIsVisible(walletPageObjects.coins);
            actualCoinsAdded=walletPageObjects.coins.getText().trim();
            System.out.println(actualCoinsAdded);
            Assert.assertTrue(actualCoinsAdded.equals(expectedCoinsAdded));
            ExtentTestManager.getTest().log(LogStatus.PASS, " <b>\"0.25\"</b> coins are added in wallet");
        }
        catch (Throwable e)
        {
            String actualException=e.getClass().getName();
            switch (actualException)
            {
                case "java.lang.NoSuchElementException":
                    Assert.fail("Expected :: \"Coins\" should be displayed ; Actual :: \"Coins\" is not displaying"+"&"+e.getMessage()+"" );
                    break;
                case "java.lang.AssertionError":
                    Assert.fail("Expected ::  <b>\""+expectedCoinsAdded+"\"</b> coins should be added in wallet on registration   ; Actual :: <b>\""+actualCoinsAdded+"\"</b> coins are added in wallet on registration  ");
                    break;
                default:
                    Assert.fail(""+"&"+e.getMessage()+"");
            }
        }

    }



    public void verifyCalculatingCostPerCoins(String ...strings)
    {
        String defaultCostPerCoin=strings[1].trim();
        String actualTotalCost=null;
        Double expectedCost=0.0;
        String expectedTotalCost=null;
        Double a=0.0;
        String actualCost=null;

        ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " :: Calculation of cost per coins in Buy Coins popup with following assertions :  ");
        try
        {
            genericfunctions.waitForPageToLoad(walletPageObjects.total_price_on_coins);
            genericfunctions.waitTillTheElementIsVisible(walletPageObjects.total_price_on_coins);
            for(int i=0; i<Integer.valueOf(getTotalCoinsToBuy()); i++)
            {
                expectedCost=expectedCost+Double.valueOf(defaultCostPerCoin);
            }
            expectedTotalCost="₹"+" "+expectedCost;
            actualTotalCost=walletPageObjects.total_price_on_coins.getText().split("₹")[1].trim();

            actualCost="₹"+" "+Double.valueOf(actualTotalCost);


            Assert.assertTrue(actualCost.equals(expectedTotalCost));
            ExtentTestManager.getTest().log(LogStatus.PASS, " Total cost for <b>\""+getTotalCoinsToBuy()+"\"</b> coins is <b>\""+actualCost+"\"</b> ");
        }
        catch (Throwable e)
        {
            String actualException=e.getClass().getName();
            switch (actualException)
            {
                case "NoSuchElementException":
                    Assert.fail("Expected :: \"Total Cost\" should be displayed ; Actual :: \"Total Cost\" is not displaying"+"&"+e.getMessage()+"" );
                    break;
                case "java.lang.AssertionError":
                    Assert.fail("Expected ::  Total cost for <b>\""+getTotalCoinsToBuy()+"\"</b> coins should be  <b>\""+expectedTotalCost+"\"</b>  ; Actual :: Total cost for <b>\""+getTotalCoinsToBuy()+"\"</b> coins is <b>\""+actualCost+"\"</b> ");
                    break;
                default:
                    Assert.fail(""+"&"+e.getMessage()+"");
            }
        }

    }


    /**
     * Verify coins incremented / decremented after drag and drop of coins slider
     *
     * @param
     * @autor Kirthana
     */

    public void verifyUpdatingCoinsAfterDragAndDropOfCoinsSlider(String ...strings)
    {
        String beforeDragAndDrop=strings[1];
        String afterDragAndDrop=strings[2];
        ExtentTestManager.getTest().log(LogStatus.INFO, " " + strings[0] + " :: Coins incremented / decremented after drag and drop of coins slider with following assertions :  ");

        try {

            Assert.assertFalse(beforeDragAndDrop.equals(afterDragAndDrop));
            ExtentTestManager.getTest().log(LogStatus.PASS, "Coins <b> \""+beforeDragAndDrop+"\"</b> incremented to  <b> \""+afterDragAndDrop+"\"</b> after drag and drop of coins slider");
        } catch (Exception e) {
            Assert.fail("Expected :: Coins before drag and drop of coins slider as <b> \""+beforeDragAndDrop+"\"</b>  ; Actual :: Coins before drag and drop of coins slider as <b> \""+beforeDragAndDrop+"\"</b> ");
        }
    }



}
