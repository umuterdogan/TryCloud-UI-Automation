package net.trycloud.step_definitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.trycloud.pages.SearchDashboardPhotosPage;
import net.trycloud.utilities.BrowserUtils;
import net.trycloud.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SearchDashboardPhotosDefs {

    @When("User can click the magnifying glass icon")
    public void user_can_click_the_magnifying_glass_icon() {
        BrowserUtils.waitFor(5);
        new SearchDashboardPhotosPage().magnifying_glass_icon.click();
        BrowserUtils.waitFor(5);
    }

    @When("User can write {string} into the text box")
    public void user_can_write_into_the_text_box(String filename) {
        new SearchDashboardPhotosPage().textbox.sendKeys(filename);
        BrowserUtils.waitFor(5);
    }

    @When("User can click on the file name")
    public void user_can_click_on_the_file_name() {
        new SearchDashboardPhotosPage().clickButton.click();
        BrowserUtils.waitFor(5);

    }

    @Then("User can see the details side page of the {string}")
    public void user_can_see_the_details_side_page_of_the(String filename) {
        System.out.println("new SearchDashboardPhotosPage().detail.getText() = " + new SearchDashboardPhotosPage().detail.getText());
        Assert.assertTrue(new SearchDashboardPhotosPage().detail.getText().contains(filename));
    }

    @When("User can click contacts icon")
    public void user_can_click_contacts_icon() {
        new SearchDashboardPhotosPage().contacts.click();
        BrowserUtils.waitFor(3);
    }

    @When("User can write {string} into the contact text box")
    public void user_can_write_into_the_contact_text_box(String name) {
        new SearchDashboardPhotosPage().contactsTextBox.sendKeys(name);
        BrowserUtils.waitFor(2);
    }
    @Then("User can see the contact name related to keyword {string}")
    public void user_can_see_the_contact_name_related_to_keyword(String name) {
       Assert.assertTrue(new SearchDashboardPhotosPage().actualName.getText().contains(name));
    }

    @When("User can click photos icon")
    public void user_can_click_photos_icon() {
        BrowserUtils.waitFor(3);
       new SearchDashboardPhotosPage().photosIcon.click();
       BrowserUtils.waitFor(5);
    }

    @When("User should be on the {string}")
    public void user_should_be_on_the_photos_page(String url) {
        Assert.assertTrue(Driver.get().getCurrentUrl().contains(url));
        System.out.println("Driver.get().getCurrentUrl() = " + Driver.get().getCurrentUrl());

    }

    @Then("User can see only the images files with the extension of {string} or {string}")
    public void user_can_see_only_the_images_files_with_the_extension_of_jpeg_jpg(String jpeg,String jpg) {
        List<WebElement> extensions = new SearchDashboardPhotosPage().extensions;
        for (WebElement extension : extensions) {
            System.out.println("extension = " + extension.getAttribute("href"));
            Assert.assertTrue(extension.getAttribute("href").contains(jpeg)||extension.getAttribute("href").contains(jpg));
        }

        BrowserUtils.waitFor(3);
    }

    @When("User can click seamlessly icon on dashboard")
    public void user_can_click_seamlessly_icon_on_dashboard() {
       new SearchDashboardPhotosPage().seamlesly_icon.click();
       BrowserUtils.waitFor(2);
    }

    @Then("User should be on the files page as home page {string}")
    public void user_should_be_on_the_files_page_as_home_page(String current_Url) {
       Assert.assertTrue(Driver.get().getCurrentUrl().contains(current_Url));
    }

}
