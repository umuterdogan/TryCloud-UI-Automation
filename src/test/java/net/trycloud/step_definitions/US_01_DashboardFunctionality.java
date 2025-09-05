package net.trycloud.step_definitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.trycloud.pages.*;
import net.trycloud.utilities.*;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class US_01_DashboardFunctionality {

    DashboardPage dashboardPage = new DashboardPage();
    TalkPage talkPage = new TalkPage();

    @Then("the user should be able to see the username")
    public void the_user_should_be_able_to_see_the_username() {
        dashboardPage.userIcon.click();
        BrowserUtils.waitFor(3);
        String actualUsername = dashboardPage.userName.getText();
        String expectedUsername = ConfigurationReader.getProperty("username");
        Assert.assertEquals(expectedUsername, actualUsername);
    }

    @Then("the user should be able to see below modules")
    public void the_user_should_be_able_to_see_below_modules(List<String> expectedResult) {
        List<String> actualResult = BrowserUtils.getElementsText(dashboardPage.modules1);
        Assert.assertEquals(expectedResult, actualResult);
    }

    @When("user click customize button")
    public void user_click_customize_button() {
        dashboardPage.customizeBtn.click();
    }

    @When("user click {string}")
    public void user_click(String option) {
        WebElement elementToClick = null;
        switch (option){
            case "user icon":
                elementToClick = dashboardPage.userIcon;;
                break;
            case "status":
                elementToClick = dashboardPage.setStatusBtn;
                break;
            case "customize button":
                elementToClick = dashboardPage.customizeBtn;
                break;
            case "Create a new group conversation":
                elementToClick = talkPage.createNewConversationBtn;
                break;
            case "Add participants":
                elementToClick = talkPage.addParticipantsBtn;
                break;
            case "Create conversation":
                elementToClick = talkPage.createBtn;
                break;
            default:
                System.out.println("element not found");
        }
        Objects.requireNonNull(elementToClick).click();

    }


    @Then("the {string} are clickable")
    public void the_are_clickable(String option) {
        List<WebElement> currentList = new ArrayList<>();
        switch (option){
            case "widgets":
                currentList = dashboardPage.widgetList;
                break;
            case "status":
                currentList = dashboardPage.statusList;
                break;
            default:
                System.out.println("The webelement list is not exist.");
        }
        for (WebElement elems : currentList) {
            if(elems.isSelected()){
                continue;
            }
            BrowserUtils.clickWithJS(elems);
            Assert.assertTrue(elems.isSelected());
        }

    }


}
