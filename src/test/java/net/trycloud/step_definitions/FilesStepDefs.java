package net.trycloud.step_definitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.trycloud.pages.DashboardPage;
import net.trycloud.pages.FilesPage;
import net.trycloud.utilities.BrowserUtils;
import net.trycloud.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.Keys;

public class FilesStepDefs {
    FilesPage filesPage = new FilesPage();
    @When("user clicks {string} module")
    public void user_clicks_module(String moduleName) {
        new DashboardPage().clickModulesWithText(moduleName);
    }
    @When("the user clicks on {string} add to favorites under its own three dots menu")
    public void the_user_clicks_on_an_existing_file_s_add_to_favorites_under_its_own_three_dots_menu(String fileName) {

        filesPage.fileActionMenu(fileName).click();
        filesPage.addToFavorites.click();
        BrowserUtils.waitFor(2);

    }

    @When("the user navigates to favorites tab")
    public void the_user_navigates_to_favorites_tab() {
        filesPage.favoritesTab.click();
        BrowserUtils.waitFor(2);
    }

    @Then("the user can verify that {string} has been added under the favorites tab")
    public void the_user_can_verify_that_the_file_has_been_added_under_the_favorites_tab(String fileName) {
        System.out.println("favorited file name = " + filesPage.favoritedFile.getText());
        Assert.assertTrue(filesPage.favoritedFile.getText().contains(fileName));
    }

    @When("the user clicks on {string} rename under its own three dots menu")
    public void the_user_clicks_on_an_existing_file_s_rename_under_its_own_three_dots_menu(String fileName) {

        filesPage.fileActionMenu(fileName).click();
        BrowserUtils.waitFor(2);
        filesPage.rename.click();
        BrowserUtils.waitFor(2);

    }

    @When("the user renames the file as {string}")
    public void the_user_renames_the_file(String newName) {
        Driver.get().switchTo().activeElement().sendKeys(newName + Keys.ENTER);
        BrowserUtils.waitFor(2);
        Driver.get().navigate().refresh();
    }

    @Then("the user can verify that the file has been renamed as {string}")
    public void the_user_can_verify_that_the_file_has_been_renamed(String newName) {

        Assert.assertTrue(filesPage.getFile(newName).isDisplayed());

    }

    @When("the user clicks on an existing file's details from its own three dots menu")
    public void the_user_clicks_on_an_existing_file_s_details_from_its_own_three_dots_menu() {

        filesPage.newName3dot.click();
        filesPage.datails.click();
    }

    @When("the user navigates to comments tab")
    public void the_user_navigates_to_comments_tab() {
        filesPage.commentsTab.click();

    }

    @When("put some comments")
    public void put_some_comments() {
        filesPage.commentsTextBox.sendKeys("some comments" + Keys.ENTER);
        BrowserUtils.waitFor(2);
    }

    @Then("the user can verify that comment has been added")
    public void the_user_can_verify_that_comment_has_been_added() {
        Assert.assertEquals("some comments", filesPage.addedComment.getText());

    }

    @When("click on any comment's own three dot menu and select delete")
    public void click_on_any_comment_s_own_three_dot_menu_and_select_delete() {
    BrowserUtils.waitFor(1);
        filesPage.comments3Dot.click();
    BrowserUtils.waitFor(1);
    filesPage.deleteComment.click();
    BrowserUtils.waitFor(1);
    }

    @Then("the user can verify that comment has been deleted")
    public void the_user_can_verify_that_comment_has_been_deleted() {
    BrowserUtils.waitFor(2);
        Assert.assertTrue(!filesPage.addedComment.isDisplayed());
    }

}
