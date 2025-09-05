package net.trycloud.pages;


import net.trycloud.utilities.BrowserUtils;
import net.trycloud.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class DashboardPage {

    public DashboardPage() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(xpath = "//ul[@id='appmenu']/li//span")
    public List<WebElement> modules1;

    @FindBy(xpath = "//div[@class='avatardiv avatardiv-shown']")
    public WebElement userIcon;

    @FindBy(xpath = "//span[@class='user-status-menu-item__header']")
    public WebElement userName;

    @FindBy(xpath = "//a[.='Customize']")
    public WebElement customizeBtn;

    @FindBy(xpath = "//input[@type='checkbox']")
    public List<WebElement> widgetList;

    @FindBy(xpath = "//a[@class='user-status-menu-item__toggle']")
    public WebElement setStatusBtn;

    @FindBy(xpath = "//input[@type='radio']")
    public List<WebElement> statusList;




    public void clickModulesWithText(String moduleName) {


        for (int i = 0; i < modules1.size() - 1; i++) {

            BrowserUtils.hover(modules1.get(i));
            BrowserUtils.waitFor(1);
            if (modules1.get(i).getText().equals(moduleName)) {
              //  BrowserUtils.clickElement(modules1.get(i));
                break;
            }

        }


    }

}
