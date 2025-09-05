package net.trycloud.pages;


import net.trycloud.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ProfileSettingsPage extends BasePage {
    @FindBy(xpath="//h3/label[text()='Full name']")
    public WebElement fullNameLabel;

    @FindBy(xpath="//input[@id='displayname']")
    public WebElement fullNameTextbox;

    @FindBy(xpath="//h3/label[text()='Email']")
    public WebElement emailLabel;

    @FindBy(xpath=" //h3/label[text()='Phone number']")
    public WebElement phoneNumberLabel;

    @FindBy(xpath="//input[@id='phonescope']")
    public WebElement phoneNumberPrivacy;

    @FindBy(xpath=" //h3/label[text()='Address']")
    public WebElement addressLabel;

    @FindBy(xpath=" //h3/label[text()='Website']")
    public WebElement websiteLabel;

    @FindBy(xpath=" //h3/label[text()='Twitter']")
    public WebElement twitterLabel;

    @FindBy(xpath="//h3/label[text()='Language']")
    public WebElement languageLabel;

    @FindBy(xpath=" //h3/label[text()='Locale']")
    public WebElement localeLabel;

    @FindBy(xpath=" //h3/label")
    public List<WebElement> personelInfoLabels;

    @FindBy(xpath="(//span[@class='icon-triangle-s'])[4]")
    public WebElement phoneIconTriangle;

    @FindBy(xpath="//a[@data-action='private']")
    public WebElement privateLabel;

    @FindBy(xpath=" //div[@id='localeexample']")
    public WebElement localeTimeDiv;

    @FindBy(css = "#email")
    public WebElement emailBox;

    public WebElement getLanguageLabelValue(String expectedValue){
        return Driver.get().findElement(By.xpath("//h3/label[text()='"+expectedValue+"']"));
    }

}
