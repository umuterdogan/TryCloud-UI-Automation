package net.trycloud.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ActivityPage extends BasePage{

    @FindBy(xpath = "//*[@id='app-navigation']/ul/li")
    public List<WebElement> allActivityCategories;

    @FindBy(css = ".activitytime.has-tooltip.live-relative-timestamp")
    public List<WebElement> activityDateObjects;

    @FindBy(css = "#no_more_activities")
    public WebElement noMoreElement;
}
