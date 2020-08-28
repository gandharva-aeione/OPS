package com.aeione.ops.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ProfileCompletionPageObjects {
    //////General info tab objects ////////////////////

    @FindBy(id = "profile-edit-general-info")
    public WebElement general_info_tab;

    @FindBy(id = "general-fullname")
    public WebElement general_fullname_textfield;

    @FindBy(xpath = "//*[contains(@class,'tags-container')]")
    public WebElement skills_tag_container;


    @FindBy(xpath = "//*[@class='ng2-tags-container']//input")
    public WebElement add_skill_textfield;

    @FindBy(xpath = "//*[@class='tag__text inline']")
    public WebElement added_skill;

    @FindBy(xpath = "//span[@class='ng-star-inserted']")
    public List<WebElement> skills_tag_suggestion;

    @FindBy(id = "general-save-submit")
    public WebElement general_savechanges_button;

    @FindBy(id = "general-cancel-button")
    public WebElement general_cancel_button;

    @FindBy(id = "about-component-description")
    public WebElement about_description_textfield;

    @FindBy(id = "about-component-gender")
    public WebElement about_component_gender_dropdown;

    @FindBy(xpath = "//*[@class='o-prof-edit-dob']//input")
    public WebElement dob_textfield;

    @FindBy(xpath = "//*[@name='languages']//input")
    public WebElement languages_known_textfield;

    @FindBy(id = "about-component-height")
    public WebElement about_component_height;

    @FindBy(id = "about-component-weight")
    public WebElement about_component_weight;

    @FindBy(xpath = "//*[@class='o-prof-edit-privacy']")
    public WebElement height_weight_privacy_edit_button;

    @FindBy(id = "about-component-save-button")
    public WebElement about_component_save_button;

    @FindBy(id = "about-component-cancel-button")
    public WebElement about_component_cancel_button;

    @FindBy(id = "profile-edit-contact")
    public WebElement profile_edit_contact_tab;

    @FindBy(id = "contact-location")
    public WebElement profile_edit_contact_location_textfield;

    @FindBy(xpath = "//*[contains(@class,'o-prof-edit-privacy Eternity hidden-mob')]")
    public WebElement profile_edit_contact_location_visible_privacy_button;

    @FindBy(id = "contact-email-readonly")
    public WebElement profile_edit_contact_email_textfield;

    @FindBy(id = "contact-email-privacy")
    public WebElement profile_edit_contact_email_privacy_button;

    @FindBy(id = "contact-phone-readonly")
    public WebElement profile_edit_contact_phone_textfield;

    @FindBy(id = "contact-phone-privacy")
    public WebElement profile_edit_contact_phone_privacy_button;

    @FindBy(id = "contact-website")
    public WebElement profile_edit_contact_website_textfield;

    @FindBy(xpath = "//*[@id='contact-website']/../following-sibling::div/div")
    public WebElement profile_edit_contact_website_visible_privacy_button;

    @FindBy(id = "contact-save-button")
    public WebElement contact_save_chnages_button;

    @FindBy(id = "profile-edit-work")
    public WebElement profile_edit_work_tab;

    @FindBy(id = "work-add-work-experience")
    public WebElement work_add_work_experience_button;

    @FindBy(id = "contact-cancel-button")
    public WebElement contact_edit_cancel_button;

    @FindBy(xpath = "//*[@class='o-wea-block ng-star-inserted']")
    public WebElement created_work_block;

    @FindBy(id = "work-update-icon")
    public WebElement work_update_edit_icon;

    @FindBy(id = "work-remove-image")
    public WebElement work_remove_image;

    @FindBy(id = "work-designation")
    public WebElement work_designation_textfield;

    @FindBy(id = "work-company")
    public WebElement work_company_textfield;

    @FindBy(id = "work-location")
    public WebElement work_location_textfield;

    @FindBy(id = "work-currently-working-here")
    public WebElement work_currently_working_here_radiobutton;

    @FindBy(id = "work-start-month-selector")
    public WebElement work_start_month_selector_dropdown;

    @FindBy(id = "work-start-year-selector")
    public WebElement work_start_year_selector_dropdown;

    @FindBy(id = "work-end-month-selector")
    public WebElement work_end_month_selector_dropdown;

    @FindBy(xpath = "//*[@name='endYear']")
    public WebElement work_end_year_selector_dropdown;

    @FindBy(id = "work-show-on-profile")
    public WebElement work_show_on_profile_radioprofile;

    @FindBy(id = "work-update-button")
    public WebElement work_save_button;

    @FindBy(id = "work-cancel-button")
    public WebElement work_cancel_button;

    @FindBy(id = "profile-edit-education")
    public WebElement profile_edit_education_tab;

    @FindBy(id = "education-add-education")
    public WebElement add_education_button;

    @FindBy(id = "eduaction-field-of-study")
    public WebElement eduaction_field_of_study_textfield;

    @FindBy(id = "eduaction-university-name")
    public WebElement eduaction_university_name_textfield;

    @FindBy(id = "education-lacoation")
    public WebElement education_location_textfield;

    @FindBy(id = "education-currently-studing")
    public WebElement education_currently_studing_radio_button;

    @FindBy(id = "education-start-month-selector")
    public WebElement education_start_month_selector_dropdown;

    @FindBy(id = "education-start-year-selector")
    public WebElement education_start_year_selector_dropdown;

    @FindBy(id = "education-end-month-selector")
    public WebElement education_end_month_selector_dropdown;

    @FindBy(id = "education-end-year-selector")
    public WebElement education_end_year_selector_dropdown;

    @FindBy(id = "education-show-on-profile")
    public WebElement education_show_on_profile_radiobutton;

    @FindBy(id = "education-update-button")
    public WebElement education_update_button;

    @FindBy(id = "eduaction-cancel-button")
    public WebElement eduaction_cancel_button;

    @FindBy(id = "profile-edit-awards")
    public WebElement profile_edit_awards_tab;

    @FindBy(id = "awards-add-awards")
    public WebElement awards_add_awards_button;

    @FindBy(id = "awards-title")
    public WebElement award_titile_textfield;

    @FindBy(id = "awards-issuer")
    public WebElement awards_issuer_textfield;

    @FindBy(id = "awards-location")
    public WebElement awards_location_textfield;

    @FindBy(id = "awards-issued-month-selector")
    public WebElement awards_issued_month_selector_dropdown;

    @FindBy(id = "awards-issued-year-selector")
    public WebElement awards_issued_year_selector_dropdown;

    @FindBy(id = "awards-show-on-profile")
    public WebElement awards_show_on_profile_radiobutton;

    @FindBy(id = "awards-update-button")
    public WebElement awards_update_button;

    @FindBy(xpath = "//*[@id='contact-location']/../following-sibling::*/app-user-privacy//*[@class='text-sm grey w-label100']")
    public List<WebElement> contact_location_visible_options;

    @FindBy(xpath = "//*[contains(@id,'profile-completion-range')]")
    public WebElement profile_completion_range_percentage;

    @FindBy(id = "awards-award-title")
    public WebElement created_award_title;

    @FindBy(id = "awards-remove-image")
    public WebElement awards_remove_image;

    @FindBy(id = "eduaction-details")
    public WebElement created_education_details;

    @FindBy(xpath = "//*[@id='eduaction-details']/following-sibling::*//a[2]")
    public WebElement education_remove_image;

    @FindBy(id = "carousel-left-banner-image")
    public WebElement cover_image_left_arrow_icon;

    @FindBy(id = "channel-cover-image-edit")
    public WebElement cover_image_edit_icon;

    @FindBy(id = "channel-cover-image-save")
    public WebElement cover_image_save_icon;

    @FindBy(id = "carousel-delete-banner-image")
    public WebElement delete_cover_image_icon;

    @FindBy(xpath = "//*[@class='opspot-banner-img m-banner--img-cover']")
    public WebElement cover_img;

    @FindBy(id = "carousel-right-banner-image")
    public WebElement cover_image_right_arrow_icon;

    @FindBy(id = "follow")
    public WebElement follow_button;


}
