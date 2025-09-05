package net.trycloud.step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.trycloud.pages.DeletedFilesPage;
import net.trycloud.utilities.BrowserUtils;
import org.junit.Assert;

public class DeletedFilesStepDefs {

    DeletedFilesPage page = new DeletedFilesPage();
    String firstFileName = page.firstLineName.getText();
    int deletedFilesSize;
    

    @Given("the user deletes the file which is in the first line")
    public void the_user_deletes_the_file_which_is_in_the_first_line() {

        deletedFilesSize = page.allDeletedFiles.size();
        System.out.println("deletedFilesSize = " + deletedFilesSize);
        BrowserUtils.waitFor(1);
        page.firstLine3Dots.click();
        BrowserUtils.waitFor(1);
        page.deleteFileLink.click();
    }
    @When("the user clicks Deleted files link")
    public void the_user_clicks_Deleted_files_link() {
        page.deletedFilesTab.click();
    }
    @Then("the user should be able to see the the most recent deleted file in the first line")
    public void the_user_should_be_able_to_see_the_the_most_recent_deleted_file_in_the_first_line() {
        BrowserUtils.waitFor(3);
        page.deletedLink.click();
        page.deletedLink.click();
        BrowserUtils.waitFor(2);
        String deletedFirstLineFile = page.deletedFirstLineName.getText();

        Assert.assertEquals(firstFileName,deletedFirstLineFile);

        page.deletedFirstLineRestore.click();

    }
    @Then("the user should be able to order the all deleted files")
    public void the_user_should_be_able_to_order_the_all_deleted_files() {
        BrowserUtils.waitFor(3);
        page.deletedLink.click();
        page.deletedLink.click();
        BrowserUtils.waitFor(2);
        String deletedFirstLineFile = page.deletedFirstLineName.getText();

        System.out.println("firstFileName = " + firstFileName);
        System.out.println("deletedFirstLineFile = " + deletedFirstLineFile);
        Assert.assertNotEquals(firstFileName,deletedFirstLineFile);

    }
    @Then("the user should be able to order alphabetically all the deleted files")
    public void the_user_should_be_able_to_order_alphabetically_all_the_deleted_files() {
        BrowserUtils.waitFor(3);
        page.nameLink.click();

        String deletedFirstLineFileName = page.deletedFirstLineName.getText();

        BrowserUtils.waitFor(1);
        page.nameLink.click();

        String deletedLastLineFileName = page.getLastDeletedFileName();

        System.out.println("deletedFirstLineFileName = " + deletedFirstLineFileName);
        System.out.println("deletedLastLineFileName = " + deletedLastLineFileName);

        Assert.assertNotEquals(deletedFirstLineFileName,deletedLastLineFileName);
    }

    @Then("the user should be able to delete any deleted file permanently")
    public void the_user_should_be_able_to_delete_any_deleted_file_permanently() {
        BrowserUtils.waitFor(3);
        String firstName = page.deletedFirstLineName.getText();
        System.out.println("firstName = " + firstName);

        page.first3DotsDeletedFile.click();
        BrowserUtils.waitFor(1);
        page.deletePermanently.click();
        BrowserUtils.waitFor(3);

        String secondName = page.deletedFirstLineName.getText();
        System.out.println("secondName = " + secondName);

        Assert.assertNotEquals(firstName,secondName);

    }

    @Then("he user should be able to restore the file")
    public void he_user_should_be_able_to_restore_the_file() {
        BrowserUtils.waitFor(3);
        String firstName = page.deletedFirstLineName.getText();
        System.out.println("firstName = " + firstName);

        page.deletedFirstLineRestore.click();
        BrowserUtils.waitFor(3);
        page.allFiles.click();
        BrowserUtils.waitFor(3);

        System.out.println(page.getAllFileName().toString());

        for (String name:page.getAllFileName()) {
            if (name.equals(firstName)){
                Assert.assertEquals(firstName,name);
            }
        }


    }

    @Then("The user verifies the file has been permanently deleted")
    public void theUserVerifiesTheFileHasBeenPermanentlyDeleted() {
        BrowserUtils.waitFor(1);
        int allDeletedFilesAfterDeleting = page.allDeletedFiles.size();
        System.out.println("allDeletedFilesAfterDeleting = " + allDeletedFilesAfterDeleting);
        Assert.assertTrue(deletedFilesSize-allDeletedFilesAfterDeleting == 1);
    }
}
