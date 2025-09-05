package net.trycloud.pages;

import net.trycloud.utilities.BrowserUtils;
import net.trycloud.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {

    @FindBy(xpath="//div[@class='avatardiv avatardiv-shown']")
    public WebElement avatarIcon;

    @FindBy(xpath="//span[@class='user-status-menu-item__header']")
    public WebElement userName;

    @FindBy(xpath="//li[@data-id='logout']")
    public WebElement logOutLink;

    @FindBy(xpath="//li[@data-id='settings']")
    public WebElement settings;

    @FindBy(xpath="//div[@class='logo logo-icon']/h1")
    public WebElement logoLabel;

    @FindBy(xpath = "(//li/a)[8]")
    public WebElement TaskIcon;

    @FindBy(xpath = "(//a[@aria-label='Calendar'])[1]")
    public WebElement Calendar;

    @FindBy(xpath = "//header/div/div")
    public WebElement magnifying_glass_icon;

    @FindBy(xpath = "//*[@id='nextcloud']/div")
    public WebElement seamlesly_icon;

    public BasePage() {
        PageFactory.initElements(Driver.get(),this);
    }

    public void clickLogOut(){
        BrowserUtils.waitFor(2);
        BrowserUtils.clickWithJS(avatarIcon);
        BrowserUtils.clickWithJS(logOutLink);
    }

    public String getUserName(){
        BrowserUtils.waitFor(2);
        BrowserUtils.clickWithJS(avatarIcon);
        BrowserUtils.waitForVisibility(userName, 5);
        return userName.getText();
    }

    public void clickSettings(){
        BrowserUtils.waitFor(2);
        BrowserUtils.clickWithJS(avatarIcon);
        BrowserUtils.clickWithJS(settings);
    }

    public void navigateTo(String module){
        module=module.toLowerCase();
        String locator="//ul[@id='appmenu']/li[@data-id='"+module+"']";
        WebElement moduleTab=Driver.get().findElement(By.xpath(locator));
        BrowserUtils.waitForClickablility(moduleTab,10);
        moduleTab.click();
    }

}
