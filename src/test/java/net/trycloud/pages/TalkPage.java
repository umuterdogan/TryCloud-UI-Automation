package net.trycloud.pages;

import net.trycloud.utilities.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class TalkPage extends BasePage {

    public TalkPage() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(xpath = "//button[@class='toggle has-tooltip']")
    public WebElement createNewConversationBtn;

    @FindBy(xpath = "//input[@class='conversation-name']")
    public WebElement conversationNameInput;

    @FindBy(xpath = "//button[@class='navigation__button navigation__button-right primary']")
    public WebElement addParticipantsBtn;

    @FindBy(xpath = "//li[@class='participant-row isSearched']")
    public List<WebElement> participantList;

    @FindBy(xpath = "//button[@class='navigation__button navigation__button-right primary']")
    public WebElement createBtn;

    @FindBy(xpath = "//div[.='You created the conversation']")
    public WebElement createSuccessMsg;

    @FindBy(xpath = "//span[.='Delete conversation']")
    public WebElement deleteConversationBtn;

    @FindBy(xpath = "//button[.='Yes']")
    public WebElement yesBtn;

    @FindBy(xpath = "//span[normalize-space(text())='Test']")
    public WebElement testConversation;


}
