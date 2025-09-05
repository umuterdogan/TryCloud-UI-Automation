package net.trycloud.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

// page_url = https://www.google.com/
public class GoogleSearchPage {
    @FindBy(xpath = "//input[@name=\"q\"]")
    public WebElement searcText;

    @FindBy(xpath = "//input[@data-ved=\"0ahUKEwj70KnF1rX6AhX2SPEDHauPD8kQ4dUDCAw\"]")
    public WebElement serachButton;



 


    public GoogleSearchPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}