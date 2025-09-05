package net.trycloud.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchDashboardPhotosPage extends BasePage {

    @FindBy(xpath = "(//form/input)[1]")
    public WebElement textbox;

    @FindBy(xpath = "(//ul/li[1]/a)[3]")
    public WebElement clickButton;

    @FindBy(xpath = "(//header)[2]//h2")
    public WebElement detail;

    @FindBy(css = "div#contactsmenu")
    public WebElement contacts;

    @FindBy(css="input#contactsmenu-search")
    public WebElement contactsTextBox;

    @FindBy(className = "full-name")
    public WebElement actualName;

    @FindBy(xpath = "//*[@id='appmenu']/li[2]")
    public WebElement photosIcon;

    @FindBy (xpath = "//*[@id='app-content-vue']/div/div[2]/a")
    public List<WebElement> extensions;


}
