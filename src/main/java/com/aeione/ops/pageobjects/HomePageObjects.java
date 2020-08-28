package com.aeione.ops.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HomePageObjects
{
    //------Top-Bar-Web-Elements

    @FindBy(id = "topbar-home")
    public WebElement topbar_home;

    @FindBy(id="topbar-explore")
    public WebElement topbar_explore;

    @FindBy(id="topbar-wallet")
    public WebElement topbar_wallet;

    @FindBy(id = "search")
    public WebElement topbar_search;

    @FindBy(id = "topbar-post")
    public WebElement topbar_blog;

    @FindBy(id= "topbar-network")
    public  WebElement topbar_network;

    @FindBy(id= "topbar-notification-bell")
    public WebElement topbar_bell;

    @FindBy( id = "topbar-group")
    public WebElement topbar_group;

    //--------#Tags-------------
    @FindBy(id = "post-menu-dropdown")
    public WebElement post_menu_dropdown;
    @FindBy(id = "post-menu-opportunity")
    public WebElement post_menu_opportunity;

    //---------Opportunity#Tags----------
    @FindBy (id = "opportunity-category")
    public WebElement opportunity_category;
    @FindBy (id = "opportunity-audition")
    public WebElement opportunity_audition;
    @FindBy(id = "opportunity-title")
    public WebElement opportunity_title;
    @FindBy(id = "opportunity-description")
    public WebElement opportunity_description;
    @FindBy (id = "opportunity-location")
    public WebElement opportunity_location;
    @FindBy(xpath = "//*[@class='o-create-opportunity-cover-image__avatar']")
    public WebElement opportunity_thumbnail;
    @FindBy(id = "opportunity-submit")
    public WebElement opportunity_submit;

    //-----------Opportunity_Widget-----
    @FindBy(xpath = "//div[contains(@class,'text-md f500 elipse elipse--w-130')]")
    public WebElement oppotunity_widget_opportunity_name;

    //----------Messanger_PopUp------------
    @FindBy( xpath = "//div[@class='m-messenger--dockpane-tab']")
    public WebElement messenger_pop_up;

    @FindBy(xpath = "//div[@class='m-messenger--userlist-search']")
    public WebElement messenger_popup_search;

    //------Blog-TextArea----

    @FindBy (id = "textarea-comment")
    public WebElement blog_title;

    @FindBy ( id = "preview-publish")
    public WebElement blog_preview_publish_button;

    @FindBy (id = "blog-review-publish")
    public WebElement blog_publish_button;

    @FindBy (xpath = "//*[contains(text(),'Error: You must provide a title')]")
    public WebElement blog_title_error;

    @FindBy(xpath = "//*[@id='view-blog']")
    public WebElement blog_title_name;
    
    @FindBy(xpath = "//*[@class='m-rich-embed--title mdl-card__title-text mdl-typography--font-medium ng-star-inserted']")
    public List<WebElement> blog_name;

    //------TopBar--Dropdown

    @FindBy(id ="topbar-dropdown")
    public WebElement topbar_dropdown;

    @FindBy(id="topbar-dropdown-signout")
    public WebElement topbar_dropdown_signout;

    //-----Home-User-Details-Widget-------
    @FindBy(xpath = "//div[@class='o-prof-info']")
    public WebElement home_profile_widget;

    @FindBy( id = "user-profile-image")
    public WebElement user_profile_image;

    @FindBy( id = "user-profile-name")
    public  WebElement user_profile_fullname;

    @FindBy( id = "user-profile-account")
    public WebElement user_profile_account;

    @FindBy( id="user-profile-follower-count")
    public WebElement user_profile_follower_count;

    @FindBy ( id = "user-profile-following-count")
    public WebElement user_profile_following_count;

    @FindBy ( id = "user-profile-view-count")
    public WebElement user_profile_post_count;

    @FindBy ( id = "newsfeed-community")
    public WebElement newsfeed_community_link;

    @FindBy ( id = "newsfeed-bookmark")
    public WebElement newsfeed_bookmark_link;

    //-------Activity Post-Card-----

    @FindBy(id = "activity-text")
    public List<WebElement> activity_text;

    //------Upload-Post-Text-Area
    @FindBy(id = "poster-textarea")
    public WebElement poster_textarea;

    @FindBy(id = "message")
    public WebElement message_textarea;

    @FindBy(xpath = "//*[@class='o-create-post-filled-avatar']")
    public WebElement upload_thumbnail;

    @FindBy(id = "post-form-submit")
    public WebElement post_button;

    @FindBy(xpath = "//*[@class='feed-media__img']")
    public List<WebElement> posted_image;

    //-----Suggestion-List--------------
    @FindBy(xpath = "//*[@class='o-card o-card-suggestion']")
    public WebElement suggested_widget;

    @FindBy(xpath = "//div[@class='o-suggestion__avatar']")
    public WebElement suggested_user_profile_image;

    @FindBy(xpath = "//div[@class='o-suggestion__name caption-bold']")
    public WebElement suggested_user_profile_name;

    @FindBy(xpath = "//div[@class='text-md grey']")
    public WebElement suggested_user_username;

    @FindBy(id = "follow")
    public WebElement suggested_user_follow_Button;

    @FindBy(id = "unfollow")
    public WebElement suggested_user_unfollow_button;
}