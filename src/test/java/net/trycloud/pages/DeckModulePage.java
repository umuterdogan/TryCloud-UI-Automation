package net.trycloud.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class DeckModulePage extends BasePage {


    @FindBy(xpath = "//span[contains(.,'Add board')]")
    public WebElement addBoardButton;

    @FindBy(css = "[placeholder='Board name']")
    public WebElement boardNameInputbox;

    @FindBy(xpath = "//input[@class='icon-confirm']")
    public WebElement confirmIcon;

    @FindBy(xpath = "//li//a[@class='app-navigation-entry-link']")
    public List<WebElement> allBoardsList;

    @FindBy(xpath = "//a[@class='app-navigation-toggle']")
    public WebElement hamburgerButton;

    @FindBy(id = "stack-add")
    public WebElement addListButton;

    @FindBy(xpath = "//div[@id='stack-add']//input[@id='new-stack-input-main']")
    public WebElement listNameInputbox;

    @FindBy(xpath = "//div[@id='stack-add']//input[@type='submit']")
    public WebElement submittanceArrow;

    @FindBy(xpath = "//div[@class='stack__header']")
    public List<WebElement> listOfLists;

    @FindBy(xpath = "//input[@placeholder='Card name']")
    public WebElement cardNameInputbox;

    @FindBy(xpath = "//input[@class='icon-confirm']")
    public WebElement confirmArrowButton;

    @FindBy(xpath = "//span[.='Assign to me']")
    public WebElement assignToMeOption;




// This method collects the texts of the Board names
    public List<String> listOfAllBoardsTexts() {

        List<String> textOfAllBoardsList = new ArrayList<>();

        for (WebElement contact : allBoardsList) {
            textOfAllBoardsList.add(contact.getText());
        }
        return textOfAllBoardsList;

    }


    // This method collects the texts of the List names under any Board.
    public List<String> listOfAllListsTexts() {

        List<String> textOfAllLists = new ArrayList<>();

        for (WebElement singleList : listOfLists) {

            textOfAllLists.add(singleList.getText());

        }
        return textOfAllLists;
    }


}
