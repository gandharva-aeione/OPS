package com.aeione.ops.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class RegistrationPageObjects {

    @FindBy(id = "registration-fullname")
    public WebElement registration_fullname_textfield;

    @FindBy(id = "registration-username")
    public WebElement registration_username_textfield;

    @FindBy(id = "registration-email")
    public WebElement registration_email_textfield;

    @FindBy(id = "phone")
    public WebElement phone_textfield;

    @FindBy(xpath="//*[@class='selected-flag dropdown-toggle']")
    public WebElement country_dropdown;

    @FindBy(id = "registration-date-dropdown")
    public WebElement registration_date_dropdown;

    @FindBy(id = "registration-month-dropdown")
    public WebElement registration_month_dropdown;

    @FindBy(id = "registration-year-dropdown")
    public WebElement registration_year_dropdown;

    @FindBy(id = "registration-password")
    public WebElement registration_password_textfield;

    @FindBy(id = "registration-confirm-password")
    public WebElement registration_confirm_password_textfield;

    @FindBy(id = "registration-checkbox")
    public WebElement registration_checkbox;

    @FindBy(id = "registration-submit")
    public WebElement registration_submit_button;

    @FindBy(xpath = "//*[@class='country']")
    public List<WebElement> country_option;

    @FindBy(xpath = "//*[@class='flag-box']")
    public List<WebElement> country_flag_box_option;

    @FindBy(xpath = "//*[@class='country-name']")
    public List<WebElement> country_name_option;

    @FindBy(xpath = "//*[@class='dial-code']")
    public List<WebElement> dial_code_option;

    @FindBy(xpath = "//*[contains(text(),'Confirmation failed')]")
    public WebElement confirmation_failed_error_msg;

    @FindBy(xpath = "//*[contains(@id,'otp_')]")
    public List<WebElement> otp_textfields;


    @FindBy(xpath = "//*[@class='selected-flag dropdown-toggle']/*[contains(@class,'iti-flag')]")
    public WebElement selected_coutry;


}
