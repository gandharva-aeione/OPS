package com.aeione.ops.pageobjects;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class InvitePageObjects {

    @FindBy(id = "topbar-dropdown-invitefriends")
    public WebElement invite_friends_option;


    @FindBy(xpath = "//*[@class='ng2-tags-container']")
    public WebElement email_address_textbox;


    @FindBy(id = "invite-friends-send-invite")
    public WebElement invite_friends_send_button;



    @FindBy(xpath = "//input[@formcontrolname='item']")
    public WebElement email_address_textarea;

    @FindBy(xpath = "//div[text()=' Invitations sent ']")
    public WebElement invitation_sent_popup;

    @FindBy(id = "identifierId")
    public WebElement gmail_id;

    @FindBy(id= "password")
    public WebElement gmail_password;

    @FindBy(xpath= "//span[text()='Next']")
    public WebElement gmail_id_next_button;

    @FindBy(xpath= "//div[@id='passwordNext']//div)[2]")
    public WebElement password_next;






}
