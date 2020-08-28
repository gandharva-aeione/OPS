package com.aeione.ops.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NotificationObjects
{
    @FindBy(id = "topbar-notification-bell")
    public WebElement topbar_notification_bell_icon;

    @FindBy(id = "dropdown")
    public WebElement notification_dropdown;




}
