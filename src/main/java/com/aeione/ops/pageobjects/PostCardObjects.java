package com.aeione.ops.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindAll;
import java.util.List;

public class PostCardObjects { @FindBy(id = "creator-contribute-buy-coins")
public WebElement contribution_popup_buy_coins_button;

    @FindBy(id = "spotcoins-buy-button")
    public WebElement buy_coins_button;

    @FindBy(id = "post-menu")
    public WebElement meatball_menu;

    @FindBy(id = "post-menu-delete")
    public WebElement post_delete_option;

    @FindBy(xpath = "//*[@class='btn btn-primary']")
    public WebElement yes_button;

    @FindBy(id = "boost-actions")
    public WebElement boost_button;

    @FindBy(id = "post-form-submit")
    public WebElement post_button;

    @FindBy(xpath = "//i[@id='contribute-icon']")
    public List<WebElement> contribution_icon;


    @FindBy(id = "creator-contribute")
    public WebElement contribute_popup;

    @FindBy(id = "spotcoins-title")
    public WebElement buy_coins_popup;

    @FindBy(xpath = "//*[@class='btn btn-outline-primary']")
    public WebElement repost_popup_cancel_button;


    @FindBy(id = "overlay-dismiss")
    public WebElement buycoins_popup_cancel_button;


    @FindBy(id = "creator-boost-post")
    public WebElement boost_popup;

    @FindBy(id = "overlay-dismiss")
    public WebElement boost_popup_cancel_button;

    @FindBy(xpath = "(//span[@id='activity-time'])[1]")
    public WebElement post_activity_time;

    @FindBy(xpath = "(//span[@id='activity-time'])")
    public List<WebElement> all_post_activity_time;

    @FindBy(id = "share-menu")
    public WebElement share_button;

    @FindBy(id = "share-menu-repost")
    public WebElement share_popup_Repost_button;

    @FindBy(id = "repost-timeline")
    public WebElement repost_share_popup;

    @FindBy(id = "repost-share")
    public WebElement repost_popup_Share_button;

    @FindBy(id = "like")
    public List<WebElement> like_button;

    @FindBy(xpath="//span[@id='like-count']")
    public List<WebElement> like_count_icon;

    @FindBy(xpath = "//*[@class='mdl-shadow--2dp']")
    public WebElement postcard_user_profile_image;

    @FindBy(xpath = "//*[@class='o-avatar__name']")
    public WebElement postcard_user_profile_name;

    @FindBy(xpath = "//*[@class='material-icons']")
    public List<WebElement> postcard_bookmark_link;

    @FindBy(xpath = "//*[@class='f-15 icon-message-square']")
    public List<WebElement> postcard_comment_button;

    @FindBy(xpath = "//*[@class='icon-eye f-15']")
    public WebElement postcard_view_count_icon;

    @FindAll({
            @FindBy(className = "wrapper"),
            @FindBy(className = "m-video--player"),
            @FindBy(className = "feed-media__img"),
            @FindBy(className = "m-mature-message-content"),
    })
    public List<WebElement> posted_content;


    @FindBy(xpath = "//div[@id='textarea-comment']")
    public List<WebElement> postcard_comment_text_section;


    @FindBy(id = "list-comment-enter")
    public WebElement comment_section_post_button;

    @FindBy(id="share-menu-count")
    public List<WebElement> share_count_icon;

    @FindBy(id="repost-message")
    public WebElement repost_textarea;

    @FindBy(id="creator-boost-impressions")
    public WebElement boost_impression_text_section;

    @FindBy(id="creator-boost-coins-available")
    public WebElement boost_available_coins;

    @FindBy(id="topbar-dropdown-boostConsole")
    public WebElement topbar_boostconsole;

    @FindBy(xpath = "//*[@class='o-avatar']")
    public List<WebElement> boosted_post_profile_img;

    @FindBy(id = "card-boost-owner-name")
    public List<WebElement> boosted_post_profile_name;

    @FindBy(xpath = "//*[@class='text-md']")
    public List<WebElement> boosted_post_boosted_button;

}

