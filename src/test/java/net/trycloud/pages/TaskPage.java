package net.trycloud.pages;

import net.trycloud.utilities.BrowserUtils;
import net.trycloud.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TaskPage extends BasePage{
@FindBy(xpath = "//span[contains(.,'Add List…')]")
public WebElement AddListIcon;

@FindBy(xpath = "//input[@id='newListInput']")
    public WebElement NewListEnter;

@FindBy(xpath = "(//input[@title='Save'])[4]")
    public WebElement SaveIcon;

@FindBy(xpath = "//span[contains(.,'School')]")
    public WebElement LeftDropdownResult;

@FindBy(xpath = "//input[@id='target']")
    public WebElement  AddtoTask;

@FindBy(xpath = "//li/div/div/div/span")
    public WebElement TaskResult;

@FindBy(xpath = "//span[@title='Completed']")
    public WebElement CompletedIcon;

@FindBy(xpath = "//li/div/div/div[@class='title']/span[1]")
    public WebElement CompletedResult;

@FindBy(xpath = "//label[@class='reactive no-nav']")
    public WebElement checkBoxOfTask;
@FindBy(xpath = "//li[@id='list_school']//button[@class='icon action-item__menutoggle action-item__menutoggle--default-icon']")
    public WebElement ImportantStar;
@FindBy(xpath = "//span[@title='Important']")
    public WebElement ImportantIcon;
@FindBy(xpath = "//li/div/div/div/span")
    public WebElement ImportantResult;
@FindBy(xpath = "//span[@title='Current']")
    public WebElement CurrentIcon;
@FindBy(xpath = "//span[.='Homeworks']")
    public WebElement CurrentResult;
@FindBy(xpath = "//li[@class='app-navigation-entry list reactive router-link-exact-active active']//button[@class='icon action-item__menutoggle action-item__menutoggle--default-icon']")
public WebElement Optiondots;
@FindBy(xpath = "//button[contains(.,'Delete')]")
    public WebElement DeleteIcon;






public void deleteList(String input){
    String locator="//span[contains(.,'"+input+"')]";
    Driver.get ().findElement ( By.xpath ( locator ) ).click ();
        BrowserUtils.waitFor ( 3 );
    Optiondots.sendKeys ( Keys.ENTER );
    BrowserUtils.waitFor ( 5 );
    DeleteIcon.click ();
    BrowserUtils.waitFor ( 10 );
        



}

}
