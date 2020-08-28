package com.aeione.ops.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class GenericPageObjects
{

    //Mailinator objects
    @FindBy(id = "addOverlay")
    public WebElement registerId;

    @FindBy(id = "go-to-public")
    public WebElement go_button;


    @FindAll({
            @FindBy(id = "file"),
            @FindBy(id = "onfile")

    })
    public WebElement attachFile_button;

    @FindBy(xpath = "//*[@id='toast-container']/*/*")
    public WebElement toast_message_popup;

}
