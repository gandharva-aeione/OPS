package com.aeione.ops.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ExplorePageObjects {
	
    @FindBy(id = "explore-search")
    public WebElement search_TextField;
    
    @FindBy(id = "explore-media-type")
    public WebElement mediaType_Dropdown;
    
    @FindBy(id = "explore-skill-type")
    public WebElement suggested_Hashtags;
    
    @FindBy(id= "explore-skill-type")
    public List<WebElement> suggested_HashtagsList;

    

}
