package com.aeione.ops.pageobjects;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.util.List;
public class BookmarkPageObjects {

    @FindBy(xpath = "//div[@class='m-tooltip']//i")
    public List<WebElement> bookmark_icon;

    @FindBy(id = "follow")
    public WebElement follow_button;
    @FindBy(xpath = "//div[text()=' Bookmarked ']")
    public WebElement bookmarked_tooltip;

    @FindBy(xpath = "//*[@class='material-icons']")
    public WebElement bookmarks_module;

    @FindBy(xpath = "//*[@name='blog']/following-sibling::span")
    public WebElement blog_radiobutton;

    @FindBy(xpath = "//*[@name='Opportunity']/following-sibling::span")
    public WebElement opportunities_radiobutton;

    @FindBy(xpath = "//*[@name='event']/following-sibling::span")
    public WebElement event_radiobutton;

    @FindBy(xpath = "//*[@name='blueStore']/following-sibling::span")
    public WebElement blueStore_radiobutton;

    @FindBy(xpath = "//*[@name='post']/following-sibling::span")
    public WebElement posts_radiobutton;

    @FindBy(xpath = "//*[@name='profile']/following-sibling::span")
    public WebElement profile_radiobutton;

    @FindBy(xpath = "//*[@name='all']/following-sibling::span")
    public WebElement all_radiobutton;

    @FindBy(xpath = "//a[@class='o-avatar__name']")
    public WebElement profile_name;

     @FindBy(xpath = "//img[@class='mdl-shadow--2dp']")
     public WebElement profile_image;

    @FindAll({
            @FindBy(xpath = "//*[text()=' #Myjourney ' ]"),
            @FindBy(xpath = "//*[text()=' #TheBlueStore ' ]"),
            @FindBy(xpath = "//*[text()=' #Opportunity ' ]"),
            @FindBy(xpath = "//*[text()=' #Portfolio ' ]"),
            @FindBy(xpath = "//*[text()=' #Event ' ]"),
            @FindBy(xpath = "//*[text()=' #Myjourney ' ]"),
            @FindBy(xpath = "//*[text()=' Post ' ]"),
    })
    public List<WebElement> post_tags;



}
