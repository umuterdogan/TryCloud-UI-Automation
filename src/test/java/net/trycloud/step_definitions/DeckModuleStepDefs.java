package net.trycloud.step_definitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.trycloud.pages.DeckModulePage;
import net.trycloud.utilities.BrowserUtils;
import net.trycloud.utilities.ConfigurationReader;
import net.trycloud.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class DeckModuleStepDefs {

    DeckModulePage deckModulePage = new DeckModulePage();

    public static String selectedBoardName;

    public static String selectedListName;

    public static String selectedCardName;


    /**
     * Below codes are for AC_1 (Scenario_1)
     */

    @When("the user clicks on Add board button")
    public void the_user_clicks_on_add_board_button() {

        if (deckModulePage.hamburgerButton.getAttribute("aria-expanded").equalsIgnoreCase("false")) {
            deckModulePage.hamburgerButton.click();
        }

        deckModulePage.addBoardButton.click();

    }

    @When("the user enters a {string}")
    public void the_user_enters_a(String newBoardName) {

        deckModulePage.boardNameInputbox.sendKeys(newBoardName);
        BrowserUtils.waitFor(1);

    }

    @When("the user clicks on the arrow button")
    public void the_user_clicks_on_the_arrow_button() {

        deckModulePage.confirmIcon.click();
        Driver.get().navigate().refresh();
        BrowserUtils.waitFor(1);

    }

    @Then("the user should see the new {string} under All boards")
    public void the_user_should_see_the_new_under_all_boards(String newBoardName) {

        Assert.assertTrue(deckModulePage.listOfAllBoardsTexts().contains(newBoardName));

        System.out.println("AC_1: Created newBoardName  = " + newBoardName);

        selectedBoardName = newBoardName;
        BrowserUtils.waitFor(1);

    }


    /**
     * Below codes are for AC_2 (Scenario_2)
     */
    @When("the user clicks on an existing Board Name")
    public void the_user_clicks_on_an_existing_board_name() {

        System.out.println("SelectedBoardName = " + selectedBoardName);

        if (deckModulePage.hamburgerButton.getAttribute("aria-expanded").equalsIgnoreCase("false")) {
            deckModulePage.hamburgerButton.click();
        }

        WebElement boardName = Driver.get().findElement(By.xpath("//span[contains(.,'" + selectedBoardName + "')]"));
        boardName.click();

    }

    @When("the user clicks on Add list button")
    public void the_user_clicks_on_add_list_button() {

        deckModulePage.addListButton.click();
        BrowserUtils.waitFor(1);

    }

    @When("the user enters the name of the {string}")
    public void the_user_enters_the_name_of_the(String newListName) {

        deckModulePage.listNameInputbox.sendKeys(newListName);
        BrowserUtils.waitFor(1);

    }

    @When("the user clicks on the Submittance Arrow button")
    public void the_user_clicks_on_the_submittance_arrow_button() {

        deckModulePage.submittanceArrow.click();
        BrowserUtils.waitFor(1);
    }

    @Then("the {string} should be seen under the selected Board Name")
    public void the_should_be_seen_under_the_selected_board_name(String newListName) {

        Assert.assertTrue(deckModulePage.listOfAllListsTexts().contains(newListName));

        System.out.println("AC_2: Created newListName = " + newListName);

        selectedListName = newListName;

    }


    /**
     * Below codes are for AC_3 (Scenario_3)
     */
    @When("the user clicks on the plus button to Add card")
    public void the_user_clicks_on_the_plus_button_to_add_card() {

        System.out.println("AC_3: SelectedListName = " + selectedListName);

        WebElement plusButton = Driver.get().findElement(By.xpath("//h3[contains(.,'" + selectedListName + "')]/..//button[contains(@class,'action-item action-item--')]"));
        plusButton.click();
        BrowserUtils.waitFor(1);
    }

    @When("the user enters the {string}")
    public void the_user_enters_the(String newCardName) {

        deckModulePage.cardNameInputbox.sendKeys(newCardName);
        BrowserUtils.waitFor(1);

    }

    @When("the user clicks on the Confirmation Arrow")
    public void the_user_clicks_on_the_confirmation_arrow() {

        deckModulePage.confirmArrowButton.click();
        BrowserUtils.waitFor(1);


    }

    @Then("the {string} should be seen under the list and the right side")
    public void the_should_be_seen_under_the_list_and_the_right_side(String newCardName) {

        String createdCardName = Driver.get().findElement(By.xpath("//span[.='" + newCardName + "']")).getText();
        System.out.println("AC_3: CreatedCardName = " + createdCardName);

        String cardNameOntheRight = Driver.get().findElement(By.xpath("//h2[@class='app-sidebar-header__maintitle']")).getText();
        System.out.println("AC_3: CardNameOntheRight = " + cardNameOntheRight);

        Assert.assertEquals(cardNameOntheRight, createdCardName, newCardName);

        selectedCardName = createdCardName;


    }


    /**
     * Below codes are for AC_4 (Scenario_4)
     */
    @When("the user clicks on three dot button inside an existing card")
    public void the_user_clicks_on_three_dot_button_inside_an_existing_card() {

        System.out.println("AC_4: SelectedCardName = " + selectedCardName);

        WebElement threeDotButton = Driver.get().findElement(By.xpath(" //span[.='" + selectedCardName + "']/../../..//div[@class='action-item']"));
        threeDotButton.click();
        BrowserUtils.waitFor(1);

    }

    @When("the user clicks on Assign to me option inside the popover menu")
    public void the_user_clicks_on_Assign_to_me_option_inside_the_popover_menu() {

        deckModulePage.assignToMeOption.click();
        BrowserUtils.waitFor(1);

    }

    @Then("the user should be able to see the user profile icon next to the three dots icon")
    public void the_user_should_be_able_to_see_the_user_profile_icon_next_to_the_three_dots_icon() {

        WebElement userProfileIcon = Driver.get().findElement(By.xpath("//span[.='" + selectedCardName + "']/../../..//div//img[@src='/index.php/avatar/Employee61/32?v=0']"));
        System.out.println("userProfileIcon.getAttribute(\"src\") = " + userProfileIcon.getAttribute("src"));
        Assert.assertTrue(userProfileIcon.getAttribute("src").contains(ConfigurationReader.getProperty("username")));

    }


    /**
     * Below lines delete the last created Board and also List and Card under it
     */
    @When("the user clicks on the three dot icon next to the selected Board")
    public void the_user_clicks_on_the_three_dot_icon_next_to_the_selected_board() {

        WebElement threeDotButton = Driver.get().findElement(By.xpath("//span[contains(.,'" + selectedBoardName + "')]/../..//button[@aria-label='Actions']"));
        threeDotButton.click();
        BrowserUtils.waitFor(1);

    }

    @Then("the user clicks on Delete Board option inside the popover menu")
    public void the_user_clicks_on_delete_board_option_inside_the_popover_menu() {

        WebElement deleteBoardButton = Driver.get().findElement(By.xpath("//div[contains(@id,'popover')]//span[.='Delete board']"));
        deleteBoardButton.click();

        WebElement confirmDelete = Driver.get().findElement(By.xpath("//button[@class='error primary']"));
        confirmDelete.click();

        System.out.println("The last created board name has been deleted");


    }


}
