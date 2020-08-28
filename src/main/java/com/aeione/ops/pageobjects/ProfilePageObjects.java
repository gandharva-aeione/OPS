package com.aeione.ops.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProfilePageObjects {

    @FindBy(id = "topbar-dropdown-view-Profile")
    public WebElement viewProfile_Link;

    @FindBy(id = "sidebar-avatar-name")
    public WebElement fullName_sidebar;
    
    @FindBy(xpath="//div[contains(@class,'text-lg f500')]")
    public WebElement fullName_ProfileDropdown;
    
    @FindBy(id = "sidebar-portfolio")
    public WebElement portfolio_Button;
  
    @FindBy(id = "portfolio-owner-portfolio")
    public WebElement portfolioPage_Header;
    
    @FindBy(id = "avatar-image-edit")
    public WebElement editProfilePicture_Icon;
    
    @FindBy(id = "image-croper-apply-button")
    public WebElement editPicture_ApplyButton;
    
    @FindBy(id = "image-croper-title")
    public WebElement editProfilePicture_Header;
    
    @FindBy(id = "sidebar-about-user")
    public WebElement aboutSection_Header;
    
    @FindBy(id = "sidebar-user-description")
    public WebElement aboutDescription_ProfileCard;
    
    @FindBy(id="sidebar-icon-edit-profile")
    public WebElement editIcon_AboutSection;
  
    @FindBy(id = "sidebar-location")
    public WebElement location_ProfileCard;
    
    @FindBy(id = "sidebar-email")
    public WebElement email_ProfileCard;
    
    @FindBy(id = "sidebar-phone-number")
    public WebElement phoneNumber_ProfileCard;
    
    @FindBy(id = "sidebar-website")
    public WebElement website_ProfileCard;

    @FindBy(id = "sidebar-user-height")
    public WebElement height_ProfileCard;
    
    @FindBy(id = "sidebar-user-weight")
    public WebElement weight_ProfileCard;
    
    @FindBy(id = "sidebar-languages-known")
    public WebElement languagesKnown_ProfileCard;
    
    @FindBy(id = "post-menu-dropdown")
    public WebElement hashtag_Dropdown;
    
    @FindBy(id = "channel-event-showtimez-tab")
    public WebElement eventTab_ProfilePage;
    
    @FindBy(id = "activity-opportunity-title")
    public WebElement opportunityTitle_OpportunityTab;
    
}

