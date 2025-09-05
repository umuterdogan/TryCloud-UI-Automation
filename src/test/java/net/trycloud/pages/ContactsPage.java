package net.trycloud.pages;

import net.trycloud.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class ContactsPage extends BasePage{


    @FindBy(id = "new-contact-button")
    public WebElement newContactBtn;

    @FindBy(id = "contact-fullname")
    public WebElement contactFullName;



    @FindBy(xpath = "//span[contains(@title, 'All contacts')]")
    public WebElement allContactsBtn;

    @FindBy(xpath = "//div//div[@class='app-content-list-item-line-one']")
    public WebElement contactName;

    @FindBy(xpath = "//div//div[@class='app-content-list-item-line-one']")
    public WebElement contactAvatar;

    @FindBy(xpath = "(//div//div[@class='app-navigation-entry__counter'])[1]")
    public WebElement contactTotalNum;

    @FindBy(xpath = "//div[contains(@class,'action-item contact-header-avatar__menu')]")
    public WebElement avatarMenuOptions;

    @FindBy(xpath = "//span[text()='Choose from Files']")
    public WebElement chooseFromFiles;

    @FindBy(xpath = "//tr[@data-entryname='testAvatar.jpeg']")
    public WebElement pictureFile;

    @FindBy(xpath = "(//div[@class='oc-dialog-buttonrow onebutton aside'])/button")
    public WebElement chooseButton;

    @FindBy (id = "contact-avatar-upload")
    public WebElement avatarPicUpload;

    @FindBy(xpath = "(//div[@class='contact-header-avatar__wrapper'])//div[@class='contact-header-avatar__photo']")
    public WebElement avatarPhoto;

    @FindBy(xpath = "//div[contains(@class,'action-item header-menu')]")
    public  WebElement threeDotMenu;

    @FindBy(xpath = "(//div[@class='popover__wrapper'])//span[text()='Delete']")
    public WebElement deleteOption;

    @FindBy(xpath = "//div[@class='contact-header__actions']//button[@aria-label='Actions']")
    public WebElement contactMenu;


    public ContactsPage() {
        PageFactory.initElements(Driver.get(),this);
    }


    public static List<WebElement> listOfAllContactsWebelements() {

        List<WebElement> allContactsWebElements = Driver.get().findElements(By.xpath("//div//div[@class='app-content-list-item-line-one']"));

        return allContactsWebElements;
    }

    public static List<String> listOfAllContacts() {


        List<String> textOfAllContactsList = new ArrayList<>();


        for (WebElement contact : listOfAllContactsWebelements()) {
            textOfAllContactsList.add(contact.getText());
        }

        return textOfAllContactsList;

    }

    public WebElement getContact(String name){
        return Driver.get().findElement(By.xpath("//*[contains(text(),'"+name+"')]"));
    }




}
