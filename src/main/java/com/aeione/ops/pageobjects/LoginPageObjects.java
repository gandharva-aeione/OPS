package com.aeione.ops.pageobjects;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPageObjects 
{
	@FindBy(xpath = "//*[@id='login-username']")
	public WebElement login_username_textfield;

	@FindBy(xpath = "//*[@id='login-password']")
	public WebElement login_password_textfield;

	@FindBy(xpath = "//*[@id='login-submit']")
	public WebElement login_submit_button;

	@FindBy(xpath = "//*[@id='registration-fullname']")
	public WebElement registration_fullname_textfield;

	@FindBy(xpath = "//*[@id='registration-username']")
	public WebElement registration_username_textfield;

	@FindBy(xpath = "//*[@id='registration-email']")
	public WebElement registration_email_textfield;

	@FindBy(xpath = "//*[@id='phone']")
	public WebElement phone_textfield;

	@FindBy(xpath = "//*[@id='registration-date-dropdown']")
	public WebElement registration_date_dropdown;

	@FindBy(xpath = "//*[@id='registration-month-dropdown']")
	public WebElement registration_month_dropdown;

	@FindBy(xpath = "//*[@id='registration-year-dropdown']")
	public WebElement registration_year_dropdown;

	@FindBy(xpath = "//*[@id='registration-password']")
	public WebElement registration_password_textfield;

	@FindBy(xpath = "//*[@id='registration-confirm-password']")
	public WebElement registration_password_confirm_textfield;

	@FindBy(xpath = "//*[@class='c-checkbox']")
	public WebElement i_agree_checkbox;

	@FindBy(xpath = "//*[@id='forgotpass']")
	public WebElement forgot_password_link;

	@FindBy(xpath = "//*[@class='m-btn m-btn--slim']")
	public WebElement ok_button;

	@FindBy(id = "phone")
	public WebElement forgot_password_phone_number_textfield;

	@FindBy(id = "textEmail")
	public WebElement text_email_button;

	@FindBy(id = "textPhone")
	public WebElement text_phone_button;

	@FindBy(id = "phone_reset")
	public WebElement phone_reset_button;

	@FindBy(xpath = "//*[@class='line-err']")
	public WebElement error_message;

	@FindBy(id = "topics-skip")
	public WebElement topics_skip_button;

	@FindBy(id="invalid-user")
	public WebElement invalid_user_error_message;

}
