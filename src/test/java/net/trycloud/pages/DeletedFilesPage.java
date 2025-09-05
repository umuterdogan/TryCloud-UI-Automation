package net.trycloud.pages;

import net.trycloud.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class DeletedFilesPage extends BasePage{

    @FindBy(xpath = "//li[@data-id='trashbin']/a")
    public WebElement deletedFilesTab;

    @FindBy(xpath = "(//tbody/tr[1]/td[2]//span[@class='icon icon-more'])[2]")
    public WebElement firstLine3Dots;

    @FindBy(xpath = "(//li//span[contains(text(),'Delete ')])[2]")
    public WebElement deleteFileLink;

    @FindBy(xpath = "//tbody/tr[1]/td[2]//span[@class='innernametext']")
    public WebElement firstLineName;

    @FindBy(xpath = "//div[@id=\"app-content-trashbin\"]/table/tbody/tr[1]/td[2]//span[@class='nametext extra-data']//span[@class='innernametext']")
    public WebElement deletedFirstLineName;

    @FindBy(xpath = "//tbody/tr[1]/td[2]//span[@class='fileactions']//span[.=' Restore']")
    public WebElement deletedFirstLineRestore;

    @FindBy(xpath = "//span[.='Deleted']")
    public WebElement deletedLink;

    @FindBy(xpath = "//div[@id='app-content-trashbin']/table/tbody/tr")
    public List<WebElement> allDeletedFiles;

    @FindBy(xpath = "//span[.='Deleted']/../../..//span[.='Name']")
    public WebElement nameLink;

    @FindBy(xpath = "//a[.='Deleted']/../../../..//tbody/tr[1]/td[2]//span[@class='icon icon-more']")
    public WebElement first3DotsDeletedFile;

    @FindBy(xpath = "//a[.='Deleted']/../../../..//tbody//span[.='Delete permanently']")
    public WebElement deletePermanently;

    @FindBy(xpath = "//a[.='All files']")
    public WebElement allFiles;


    @FindBy(xpath = "//li[@data-id='trashbin']")
    public WebElement deletedFiles;
    public String getLastDeletedFileName(){
        WebElement lf = Driver.get().findElement(By.xpath(
                "//tbody/tr["+allDeletedFiles.size()+"]/td[2]//span[@class='nametext extra-data']//span[@class='innernametext']"));
        String ldfn = lf.getText();
        return ldfn;
    }

    public List<String> getAllFileName(){
        List<String> allFilesName = new ArrayList<>();
        List<WebElement> allFiles = Driver.get().findElements(By.xpath("//tbody/tr//span[@class='innernametext']"));
        for (WebElement element:allFiles) {
            allFilesName.add(element.getText());
        }
        return allFilesName;
    }


}
