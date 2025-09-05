package net.trycloud.step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.trycloud.pages.NotesPage;
import net.trycloud.utilities.BrowserUtils;
import org.junit.Assert;

public class NotesStepDefs {
    NotesPage notesPage = new NotesPage();

    @When("the user click New Note")
    public void theUserClickNewNote() {
        notesPage.createNewNote.click();
        BrowserUtils.waitFor(1);

    }

    @When("the user write {string}")
    public void the_user_write(String note) {
        BrowserUtils.hover(notesPage.textPage);
        notesPage.textPage.click();
        notesPage.textPageInside.sendKeys(note);
        BrowserUtils.waitFor(5);
    }

    @Then("note title should match with first words of {string}")
    public void note_title_should_match_with_first_words_of(String note) {
        String actualNoteTitle = notesPage.lastNote.getAttribute("title").substring(0, 10);
        System.out.println("actualNoteTitle = " + actualNoteTitle);
        System.out.println("note = " + note);

        Assert.assertTrue(note.contains(actualNoteTitle));
        BrowserUtils.waitFor(2);
    }

    @And("the user click three dot on {string} title")
    public void theUserClickThreeDotOnTitle(String note) {
        notesPage.clickTextThreeDots(note);
    }

    @And("the user click add to favorite tab")
    public void theUserClickAddToFavoriteTab() {
        notesPage.clickRightDotsFeatures("Add to favorites");
    }

    @And("the user clicks three dot icon on note page")
    public void theUserClicksThreeDotIconOnNotePage() {
        notesPage.leftThreeDots.click();
    }

    @And("the user clicks on Details")
    public void theUserClicksOnDetails() {
        notesPage.DetailsBtn.click();
    }

    @Then("the user should see notes details")
    public void theUserShouldSeeNotesDetails() {
        BrowserUtils.waitFor(3);
        String textDetail = notesPage.detailsText.getText();
        System.out.println("textDetail = " + textDetail);
        Assert.assertTrue(textDetail.contains("word") & textDetail.contains("character"));

    }


    @And("the user enter category {string}")
    public void theUserEnterCategory(String name) {
        BrowserUtils.clickWithJS(notesPage.categoryInput);
        notesPage.categoryInput.sendKeys(name);
        notesPage.forwardBtn.click();
    }

    @And("the user clicks on categories tab")
    public void theUserClicksOnCategoriesTab() {
        BrowserUtils.clickWithJS(notesPage.categoriesTab);
        BrowserUtils.waitFor(5);
    }

    @Then("the user should see the category {string}")
    public void theUserShouldSeeTheCategory(String name) {
    }

    @And("the user clicks on delete button")
    public void theUserClicksOnDeleteButton() {
        notesPage.clickRightDotsFeatures("Delete note");
        BrowserUtils.waitFor(2);
    }

    @Then("the user should see deletion message")
    public void theUserShouldSeeDeletionMessage() {

        String deleteMsg= notesPage.deleteMessage.getText();
        Assert.assertTrue(deleteMsg.contains("Deleted"));

    }


    @And("the user should see {string} as favorites")
    public void theUserShouldSeeAsFavorites(String note) {
        Assert.assertTrue(notesPage.isTextTitleExistInFavorites(note));

    }
}
