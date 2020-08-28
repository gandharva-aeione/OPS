package com.aeione.ops.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class OrganizationPageObjects {

	@FindBy(id="topbar-dropdown-organizationname")
	public WebElement organizationLink;

	@FindBy(id="list-create-community")
	public WebElement createOrganization_Button;

	@FindBy(id="create-organization")
	public WebElement createOrganization_Header;

	@FindBy(id="create-organization-name")
	public WebElement createOrganization_Name;

	@FindBy(id="create-organization-type")
	public WebElement createOrganization_Type;

	@FindBy(xpath="//*[@class='ng2-tag-input minimal']")
	public WebElement createOrganization_AddSkills;

	@FindBy(xpath="//input[@class='ng2-tag-input__text-input ng-pristine ng-valid ng-touched']")
	public WebElement addSkills_Input;

	@FindBy(id="create-organization-loaction")
	public WebElement createOrganization_Location;

	@FindBy(id="create-organization-create-button")
	public WebElement createButton;

	@FindBy(xpath="//*[@class='o-community-name']")
	public WebElement innerPage_OrganizationName;

	@FindBy(id="organization-setting-button")
	public WebElement settingButton;

	@FindBy(id="list-community-manage-list")
	public WebElement createdOrganization;

	@FindBy (xpath = "//*[@class='text-md f500 word-br elipse elipse--w-130']")
	public List<WebElement> createdOgnanizationName;

	@FindBy(id="organization-setting-delete-organizatopn")
	public WebElement deleteOrganization_Button;

	@FindBy(id="organization-setting-delete-action")
	public WebElement deleteOrganization_ConfirmButton;

	@FindBy(id="profile-organization-invite-icon")
	public WebElement inviteIcon;

	@FindBy(id="post-menu")
	public WebElement postCard_ActionButton;

	@FindBy(id="post-menu-delete")
	public WebElement postCardAction_DeleteButton;

	@FindBy ( id = "organization-setting-button")
	public WebElement organization_setting_button;

	@FindBy(xpath="//button[contains(.,' Yes ')]")
	public WebElement confirm_DeleteButton;

	@FindBy(xpath="//label[contains(.,'Add Skills')]")
	public WebElement addSkills_Title;

	@FindBy(id="post-form-nsfw")
	public WebElement createPost_RestrictedContent;

	@FindBy(id="activity-uncover")
	public WebElement restrictedContent_UncoverButton;

	@FindBy(id="comment")
	public WebElement postCard_CommentIcon;

	@FindBy(id="textarea-comment")
	public WebElement postCard_CommentTextArea;

	@FindBy(id="list-comment-enter")
	public WebElement postCard_CommentSend;

	@FindBy(id="comment-count")
	public WebElement postCard_CommentCount;

}
