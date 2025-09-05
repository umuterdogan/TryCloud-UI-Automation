package net.trycloud.pages;

import net.trycloud.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class NewGroupContactsPage extends BasePage{

    @FindBy(xpath = "//button[@class='icon action-item__menutoggle icon-add']")
    public WebElement plusButton;

     @FindBy(xpath = "//span[contains(text(),'Cre')]")
    public WebElement newgroupText;

     @FindBy(css=".action-input__input")
    public WebElement newGroupTextBox;


     @FindBy(xpath = "//input[@placeholder='Add contact in group']")
    public WebElement groupDropdown;

     @FindBy(xpath = "(//div[@tabindex=-1])[11]")
     public List<WebElement> groupDropdownList;

     @FindBy(xpath = "//div[contains(text(),'Mike')]")
    public WebElement contact;

     @FindBy(xpath = "//input[@placeholder='Choose property type']")
    public WebElement propertyType;

     @FindBy(xpath = "//span[contains(.,'All contacts')]")
    public WebElement allContactsButton;

     @FindBy(css=".name-parts[title='STAR']")
     public  WebElement starOption;

     @FindBy(xpath = "//span[text()='Birthday']")
    public  WebElement birthday;

     @FindBy(xpath = "(//div[contains(text(),'Birthday')])[1]")
    public WebElement birthdayBox;

     @FindBy(xpath = "//span[@title='STAR']")
    public WebElement leftGroupTable;

     public WebElement setProperty(String prop){
         return Driver.get().findElement(By.xpath("//span[text()='"+prop+"']"));
     }

    public WebElement getProperty(String prop){
        return Driver.get().findElement(By.xpath("(//div[contains(text(),'"+prop+"')])[1]"));
    }

}
