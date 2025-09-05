package net.trycloud.pages;

import net.trycloud.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FilesPage extends BasePage{
    @FindBy (xpath ="(//*[.='please do not edit or delete'])[2]/../../*[3]/*[2]")
    public WebElement filesThreeDotMenu;

    @FindBy(css = ".menuitem.action.action-favorite.permanent")
    public WebElement addToFavorites;

    @FindBy(xpath = "//a[.='Favorites']")
    public WebElement favoritesTab;


    @FindBy(xpath = "//td[@class='filename']/*[1]/*[2]")
    public WebElement favoritedFile;

    @FindBy(css = ".menuitem.action.action-rename.permanent")
    public WebElement rename;

    @FindBy(xpath = "(//*[.='please do not edit or delete'])[4]")
    public WebElement fileName;

    @FindBy(xpath = "(//*[.='new name'])[4]")
    public WebElement reNamedFile;

    @FindBy(xpath = "(//span[@class='icon icon-more'])[3]")
    public WebElement newName3dot;

    @FindBy(xpath = "//span[@class='icon icon-details']")
    public WebElement datails;

    @FindBy(id = "commentsTabView")
    public WebElement commentsTab;

    @FindBy(xpath = "//div[@class='message']")
    public WebElement commentsTextBox;

    @FindBy(xpath = "//div[.='some comments']")
    public WebElement addedComment;

    @FindBy(xpath = "//a[@class='action more icon icon-more has-tooltip']")
    public WebElement comments3Dot;

    @FindBy(xpath = "//div[@class='commentsModifyMenu popovermenu bubble menu menu-left']//span[@class='icon icon-delete']")
    public WebElement deleteComment;

    public WebElement fileActionMenu(String fileName){
        return Driver.get().findElement(By.xpath("//tr[@data-file='"+fileName+"']//a[@data-action='menu']"));
    }

    public WebElement getFile(String name){
        return Driver.get().findElement(By.xpath("//*[@id='app-content-files']//tbody//*[contains(text(),'"+name+"')]"));
    }
}
