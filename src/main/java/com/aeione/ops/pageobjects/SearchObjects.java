package com.aeione.ops.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchObjects
{

    @FindBy(id = "search")
    public WebElement search_textfield;

    @FindBy(xpath = "//*[@class='m-search-bar-suggestions-list']//span")
    public List<WebElement> user_serch_suggestion_list_options;

    @FindBy(xpath = "//*[@class='m-search-bar-suggestions-list']")
    public WebElement user_serch_suggestion;

    @FindBy(xpath = "//*[text()='Profile']")
    public WebElement profile_tab;




}
