package com.aeione.ops.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SettingsPageObject
{

    @FindBy (id = "suggested_user_profile_name")
    public WebElement suggested_user_profile_name;

    @FindBy(id = "topbar-dropdown-settings")
    public WebElement topbar_dropdown_settings_option;

    @FindBy (xpath = "//*[@class='tabs-list settings-tabs']//li")
    public List<WebElement> tabs_list_settings_tabs;

    @FindBy (xpath = "//*[@class='tabs-list settings-tabs']//li//a")
    public List<WebElement> list_name;

    @FindBy (id = "privacy-security-password-title")
    public WebElement privacy_security_password_title;

    @FindBy (id="privacy-security-chage-password")
    public WebElement privacy_security_change_password;

    @FindBy (id = "privacy-security-current-password")
    public WebElement privacy_security_current_password;

    @FindBy (id = "privacy-security-new-password")
    public WebElement privacy_security_new_password;

    @FindBy (id="privacy-security-confirm-password")
    public WebElement privacy_security_confirm_password;

    @FindBy (id = "privacy-security-update-password")
    public WebElement privacy_security_update_password;

    @FindBy (id = "privacy-security-cancel-button")
    public WebElement privacy_security_cancel_button;

    @FindBy (id = "toast-container")
    public  WebElement toast_container;

    @FindBy (id = "privacy-security-close-sessions")
    public WebElement privacy_security_close_sessions;

    @FindBy(xpath = "//*[contains(text(),'Delete Account')]")
    public WebElement delete_account;

    @FindBy (xpath = "//div[contains(text(),'Deactivate Account')]")
    public WebElement deactivate_account;

    @FindBy (id = "general-password-delete-account")
    public WebElement general_password_delete_account;

    @FindBy ( id = "general-confirm-delete-button")
    public  WebElement general_confirm_delete_button;

    @FindBy ( id = "general-delete-cancel-button")
    public WebElement general_delete_cancel_button;

    @FindBy ( id = "general-checkbox")
    public List<WebElement> general_checkox_reasons;

    @FindBy ( xpath = "//label[ @class='c-checkbox' or @class='c-checkbox ng-star-inserted']")
    public List<WebElement> general_checkbox_reason_name;

    @FindBy (xpath = "//*[contains(text(),'I have a duplicate account')]")
    public WebElement general_checkbox;

    @FindBy (xpath = "//*[contains(text(),'others')]")
    public WebElement general_others;

    @FindBy ( id = "general-textarea")
    public WebElement general_textarea;

    @FindBy ( id = "general-confirm-deactivate-button")
    public WebElement general_confirm_deactivate_button;

    @FindBy ( id = "general-deactivate-cancel-button")
    public WebElement general_deactivate_cancel_button;

    @FindBy (xpath = "//*[@class='feed-paywall bg']")
    public List<WebElement> feed_paywall_background;

    @FindBy (id = "wire-save-backgroung-image")
    public WebElement wire_save_backgroung_image_button;

    @FindBy ( id = "general-user-name-readonly")
    public WebElement general_user_name_readonly;

    @FindBy (id="general-email-readonly")
    public WebElement general_email_readonly;

    @FindBy (id = "general-phone-readonly")
    public WebElement general_phone_readonly;

    @FindBy (xpath = "//*[contains(text(),'Select your language for One Page Spotlight account')]")
    public WebElement general_language_drop_down;

    @FindBy (id = "flag_mature")
    public WebElement general_flag_mature;

    @FindBy (id = "flag_portfolio")
    public WebElement general_portfoilo;

    @FindBy (id = "general-save-button")
    public WebElement general_save_button;

    @FindBy ( id = "support-dropdown")
    public WebElement support_dropdown;

}
