package com.aeione.ops.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class PostWithHashTagObjects
{

    @FindBy(id = "poster-write-blog")
    public WebElement poster_write_blog_link;

    @FindBy(id = "file")
    public WebElement file_Upload;

    @FindBy(id = "poster-exit")
    public WebElement poster_exit;
    @FindBy(id = "post-form-profile-image")
    public WebElement post_form_profile_image;
    @FindBy (xpath = "//*[@class='fileUpload']")
    public WebElement upload_file;
    @FindBy (id = "post-form-nsfw")
    public WebElement post_form_nsfw_check_box;
    @FindBy (id = "post-form-set-paywall-icon")
    public WebElement post_form_set_paywall_icon;

    @FindBy (id = "post-set-coins")
    public WebElement post_set_coins;

    @FindBy( id = "post-set-coins-message")
    public WebElement post_coins_message;

    @FindBy(id = "post-coins-add")
    public WebElement post_coins_add_button;
    @FindBy(id = "overlay-dismiss")
    public WebElement overlay_dismiss;

    @FindBy(xpath = "//ul[@class='opspot-dropdown-menu center-dropdown']//li")
    public List<WebElement> hashtags_list_options;

    @FindBy(xpath = "//*[@class='audio-background-cover']")
    public List<WebElement> audio_post;

    @FindBy (xpath = "//*[@class='m-video--player']")
    public List<WebElement> video_post;

    @FindBy (xpath = "//*[@id='nsfw_media_post_blanket' or @calss='m-mature-content']")
    public List<WebElement> nsfw_media_post_blanket;

    @FindBy(xpath = "//*[@calss='m-mature-content-shown' or @class='m-mature-content-shown ng-star-inserted' or @id='nsfw_media_post_blanket' or @class='ng-star-inserted m-mature-content-shown']")
    public List<WebElement> nsfw_media_post_blanket_shown;


    @FindBy(id = "activity-cover")
    public List<WebElement> activity_cover_button;

    @FindBy(id = "activity-uncover")
    public List<WebElement> activity_uncover_button;

    @FindBy(id = "paywall-unlock")
    public List<WebElement> paywall_unlock_button;
    @FindBy ( xpath = "//*[@class='feed-media__img']")
    public List<WebElement> feed_media_image;
    @FindBy(id = "paywall")
    public List<WebElement> paywall_header;
    @FindBy(xpath = "//*[@class='o-contribute']")
    public WebElement paywall_contribute_window;
    @FindBy(id = "creator-paywall")
    public WebElement creator_paywall_pay_per_post;

    @FindBy ( id = "creator-paywall-submit")
    public WebElement creator_paywall_submit_button;

    @FindBy (id = "post-menu")
    public List<WebElement> more_menu_post;
    @FindBy (id = "activity-edit")
    public WebElement activity_edit_action;
    @FindBy(id = "activity-save")
    public WebElement activity_save_action;
    @FindBy (xpath = "//*[@class='o-create-blue-store-cover-image__avatar']")
    public WebElement bluestore_thumbnail;
    @FindBy(xpath = "//*[@class='o-create-myjourney-filled-avatar']")
    public WebElement myjourney_thumbnail;
    @FindBy (id = "bluestore-title")
    public WebElement bluestore_title;
    @FindBy (id = "bluestore-description")
    public WebElement bluestore_description;
    @FindBy (id = "bluestore-units")
    public WebElement bluestore_units;
    @FindBy (id = "bluestore-price")
    public WebElement bluestore_price;
    @FindBy (id = "bluestore-submit")
    public WebElement bluestore_submit;
    @FindBy (id = "activity-bluestore-title")
    public List<WebElement> activity_bluestore_title;
    @FindBy (id = "share-menu")
    public List<WebElement> share_menu;
    @FindBy ( id = "share-menu-repost")
    public List<WebElement> share_menu_repost;
    @FindBy (xpath = "//*[@class='o-repost']")
    public WebElement repost_popup;
    @FindBy (id = "repost-message")
    public WebElement repost_message;
    @FindBy (id = "repost-share")
    public WebElement repost_share_button;
    @FindBy (xpath = "//*[contains(text(),'post (Repost)')]")
    public WebElement repost_on_home_timeline;
    @FindBy (id="myjourney-submit")
    public WebElement myjourney_submit_button;
    @FindBy(xpath = "//*[contains(text(),'#Myjourney')]")
    public List<WebElement> myjourney_header;
    @FindBy (id = "user-profile-details")
    public WebElement user_profile_details;
    @FindBy (id = "myjourney-widget-myjourney-post")
    public List <WebElement> myjourney_widget_myjourney_post;
    @FindBy (xpath = "//*[@class='o-create-show-timez-cover-image__avatar']")
    public WebElement showtimez_thumbnail;
    @FindBy(id = "showtimez-title")
    public WebElement showtimez_title;
    @FindBy(id = "showtimez-description")
    public WebElement showtimez_description;
    @FindBy(id = "showtimez-location")
    public WebElement showtimez_location;
    @FindBy(id = "showtimez-date")
    public WebElement showtimez_date;
    @FindBy(id = "showtimez-time")
    public WebElement showtimez_time;
    @FindBy(id = "showtimez-submit")
    public WebElement showtimez_submit_button;
    @FindBy(id = "evntTitle")
    public List<WebElement> showtimez_event_title;
    @FindBy(xpath = "//*[@class='o-create-show-timez']")
    public WebElement showtimez_edit_popup;
    @FindBy(xpath = "//*[@name='message']")
    public WebElement reachout_message_area;
    @FindBy(id = "activity-showtimes-postcard")
    public List<WebElement> activity_showtimez_postcard;

    @FindBy( id = "reach-out-button")
    public List<WebElement> reach_out_button;

    @FindBy (xpath = "//*[contains(text(),'send_arrow')]")
    public WebElement send_button;

    @FindBy (xpath = "//*[@class='form-control form-control-lg ng-untouched ng-pristine ng-valid']")
    public WebElement bluestore_currency_type;

    @FindBy(id = "activity-opportunity-title")
    public List<WebElement> activity_opportunity_title;

    @FindBy (id= "activity-opportunity-postcard")
    public List<WebElement> activity_opportunity_postcard;

    @FindBy (id = "opportunity-close")
    public WebElement opportunity_close_icon;

    @FindBy (id = "upload_thumbnail")
    public WebElement portfolio_upload_thumbnil;

    @FindBy (id = "portfolio-submit")
    public WebElement portfolio_submit_button;

    @FindBy ( xpath = "//*[@class='o-avatar__name']/following-sibling::a")
    public List<WebElement> hashTag_header;

    @FindBy (id = "sidebar-portfolio")
    public WebElement sidebar_portfolio_button;

    @FindBy (xpath = "//*[@class='o-explore-media-img']")
    public List<WebElement> media_images;

    @FindBy(id = "portfolio-nsfw")
    public WebElement portfolio_nsfw_toggle_Button;

    @FindBy (xpath ="//*[contains(text(),'#Opportunity')]")
    public List<WebElement> opportunity_header;

    @FindBy (xpath ="//*[contains(text(),'#Showtimez')]")
    public List<WebElement> showtimez_header;

    @FindBy (xpath ="//*[contains(text(),'#TheBlueStore')]")
    public List<WebElement> bluestore_header;

    @FindBy(id = "like")
    public WebElement like_count;

    @FindBy (id = "share-menu-share")
    public WebElement share_menu_share;

    @FindBy (id = "view-profile-bookmark")
    public WebElement view_profile_bookmark_icon;

    @FindBy(xpath = "//*[@icon='turned_in_not']")
    public WebElement bookmark_turned_in_not;

    @FindBy (xpath = "//*[@icon='turned_in']")
    public WebElement bookmark_turned_in;

    @FindBy (id = "view-profile-activity-details")
    public WebElement view_profile_activity_details;

    @FindBy ( xpath = "//*[@class='m-wire--lock-screen--transaction-made-notice']")
    public List <WebElement> lock_screen_transaction_made_notice;
}
