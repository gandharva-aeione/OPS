package com.aeione.ops.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CommunityPageObjects {

	@FindBy(xpath = "//li[@class='m-dropdownList__item']/a[@id='topbar-create-Community']")
    public WebElement createCommunity_Link;
	
	@FindBy(xpath = "//div[@class='o-create-community-radio']/label")
    public WebElement create_PublicCommunity;
	
	@FindBy(xpath = "//div[@class='o-create-community-radio']/label[2]")
    public WebElement create_PrivateCommunity;
	
	@FindBy(id = "create-community-enable-post")
    public WebElement enablePost_Chekbox;
	
	@FindBy(id = "create-community-button")
    public WebElement community_CreateButton;
	
	@FindBy(id = "create-community-name")
    public WebElement communityName_TextField;
	
	@FindBy(id = "create-community-description")
    public WebElement communityDescription_TextArea;
	
	@FindBy(xpath = "//div[@class='ng2-tag-input minimal']")
    public WebElement hashtag_Field;
	
	@FindBy(xpath = "//input[@class='ng2-tag-input__text-input ng-valid ng-dirty ng-touched']")
	 public WebElement hashtag_TextField;
	
	@FindBy(id = "profile2-group-name")
    public WebElement communityTitle_InnerPage;
	
	@FindBy(id = "profile2-icon-plus-circle")
    public WebElement invite_plusIcon;
	
	@FindBy(id = "invite-search-members")
    public WebElement searchMembers_TextField;
	
	@FindBy(id = "invite-invite-member-button")
    public WebElement inviteButton;
	
	@FindBy(id = "group-settings-menu")
    public WebElement settings_ActionButton;
	
	@FindBy(id = "group-settings-make-closed")
    public WebElement makePrivate_Option;
	
	@FindBy(id = "group-settings-make-public")
    public WebElement makePublic_Option;
	
	@FindBy(id = "newsfeed-community")
    public WebElement communityTab_HomePage;
	
	@FindBy(id = "list-community-manage-list")
    public WebElement community_CommunityYouManage;
	
	@FindBy(id = "group-settings-delete-community")
    public WebElement deleteCommunity;
	
	@FindBy(id = "group-confirm-button")
    public WebElement confirm_DeleteCommunity;
	
	/////////////// Join community ///////////////////
	
	@FindBy(id = "tile-join-button")
    public WebElement joinButton_CommunitiesPage;
	
	@FindBy(id = "tile-open-button")
    public WebElement openButton_PublicCommunity;
	
	@FindBy(id = "group-join")
	public WebElement joinButton;
	
	@FindBy(id = "group-join")
    public WebElement joinButton_PrivateCommunity;
	
	@FindBy(id = "group-cancel")
    public WebElement cancelbutton_PrivateCommunity;
	
	/////////////// Community Actions //////////////////
	
	@FindBy(id ="group-settings-edit")
    public WebElement editCommunity;
	
	@FindBy(id ="group-settings-disable-gathering")
    public WebElement disableGathering;
	
	@FindBy(id ="group-settings-disable-notification")
    public WebElement disableNotification;
	
	@FindBy(id ="group-settings-enable-gathering")
    public WebElement enableGathering;
	
	@FindBy(id ="group-settings-enable-notification")
    public WebElement enableNotification;
	

	
	
	
	
	
	
}
