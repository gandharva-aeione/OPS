package com.aeione.ops.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EventPageObjects {
	
    @FindBy(id = "topbar-create-event")
    public WebElement createEvent_link;
    
    @FindBy(id = "big-event-header")
    public WebElement createEvent_Header;
    
    @FindBy(id = "big-event-title")
    public WebElement eventTitle_TextField;
    
    @FindBy(id = "big-event-description")
    public WebElement eventDescription_TextField;
    
    @FindBy(id = "big-event-event-type")
    public WebElement eventType_Dropdown;
    
    @FindBy(id = "big-event-event-category")
    public WebElement eventCategory_Dropdown;
    
    @FindBy(id = "big-event-event-location")
    public WebElement eventLocation_TextField;
    
    @FindBy(id = "big-event-event-start-date")
    public WebElement event_StartDate;
    
    @FindBy(id = "big-event-event-start-time")
    public WebElement event_StartTime ;
    
    @FindBy(id = "big-event-event-end-date")
    public WebElement event_EndDate;
    
    @FindBy(id = "big-event-event-end-time")
    public WebElement event_EndTime ;
    
    @FindBy(xpath = "//*[@class='o-create-event-cover-image__avatar']")
    public WebElement event_thumbnail;
    
    @FindBy(id = "big-event-event-submit")
    public WebElement create_Button ;
    
    @FindBy(id = "big-event-event-cancel")
    public WebElement cancel_Button ;
    
    @FindBy(xpath = "//*[@class='o-big-events-inner-info__content']")
    public WebElement eventInnerPage_Info ;
    
    @FindBy(xpath = "//div[contains(@class,\"o-trending-post__info\")]//div[contains(@class,'text-md f500 elipse elipse--w-130')]")
    public WebElement eventWidget_EventTitle;
    
    @FindBy(id = "evntTitle")
    public WebElement eventTitle_HomePageFeeds ;
    
    @FindBy(id = "post-menu")
    public WebElement postMenu_ActionButton ;
    
    @FindBy(id = "post-menu-delete")
    public WebElement postMenu_DeleteButton ;
    
    
}
