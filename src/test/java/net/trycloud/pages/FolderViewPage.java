package net.trycloud.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class FolderViewPage extends BasePage {

    @FindBy(xpath="/html/body/header/div[1]/ul/li[1]")
    public WebElement files;

    @FindBy(id="headerName")
    public WebElement name;

    @FindBy(xpath="//th[@class='column-size']")
    public WebElement size;


    @FindBy(xpath="//th[@class='column-mtime']//span[.='Modified']")
    public WebElement modified;

    @FindBy(id="view-toggle")
    public WebElement toggle;


    @FindBy(xpath="//span[@class='nametext']/span")
    public List<WebElement> listoffiles;

    @FindBy(xpath="//th[@class='column-size']//span[.='Size']")
    public List<WebElement> listofsize;

    @FindBy(xpath="th[@class='column-mtime']//span[.='Modified']")
    public List<WebElement> listofmodels;

    @FindBy(id ="view-toggle")
    public WebElement toggleview;


}
