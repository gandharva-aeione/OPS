package com.aeione.ops.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WalletPageObjects
{
    @FindBy(id="topbar-wallet")
    public WebElement topbar_wallet;


    @FindBy(id="token-buy-coins")
    public WebElement token_buy_coins_button;

    @FindBy(id="coins")
    public WebElement coins;

    @FindBy(xpath="//*[@class='o-purchase-token-price__total']")
    public WebElement total_price_on_coins;

    @FindBy(xpath="//*[@class='o-purchase-count']/*")
    public WebElement total_buy_coins;

    @FindBy(id="spotcoins-buy-coins")
    public WebElement spotcoins_buy_coins_textfield;

    @FindBy(xpath="//*[@class='o-trans-history__title']")
    public WebElement transactions_history_titile;

    @FindBy(id="transactions-rewards-coins")
    public WebElement transactions_rewards_coins;

    @FindBy(id="transactions-rewards-type")
    public WebElement transactions_rewards_type;

    @FindBy(id="transactions-rewards-time")
    public WebElement transactions_rewards_time;

    @FindBy(id="token-transaction")
    public WebElement token_transaction_tab;

    @FindBy(xpath="//*[@class='o-token-purchase']/*")
    public WebElement coins_slider_BuyCoins_popup;

}
