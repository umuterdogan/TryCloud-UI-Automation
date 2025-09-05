package net.trycloud.step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.trycloud.pages.ProfileSettingsPage;
import net.trycloud.utilities.BrowserUtils;
import net.trycloud.utilities.ConfigurationReader;
import net.trycloud.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class ProfileSettStepDefs {

    ProfileSettingsPage page = new ProfileSettingsPage();

    @Given("the user clicks settings label")
    public void the_user_clicks_settings_label() {
      page.settings.click();
    }

    @Then("the user should see following labels")
    public void the_user_should_see_following_labels(List <String> expectedLabels) {
        List<String> actualElementsText = BrowserUtils.getElementsText(page.personelInfoLabels);


        Assert.assertTrue(actualElementsText.containsAll(expectedLabels));

    }

    @Given("the user enters the name {string}")
    public void the_user_sendkeys(String name) {
        page.fullNameTextbox.clear();
        page.fullNameTextbox.sendKeys(name);
    }

    @Then("the user should be able to see the {string}")
    public void the_user_should_be_able_to_see_the(String expectedName) {

        String actualName = page.fullNameTextbox.getAttribute("value");
        Assert.assertEquals(expectedName,actualName);
    }



    @Given("the user clicks the phone icon-triangle")
    public void the_user_clicks_the_phone_icon_triangle() {
       page.phoneIconTriangle.click();
       BrowserUtils.waitFor(1);
    }

    @Given("the user clicks the private label")
    public void the_user_clicks_the_private_label() {
        BrowserUtils.waitFor(1);
      page.privateLabel.click();
        BrowserUtils.waitFor(1);

    }

    @Then("the user should see the private is selected")
    public void the_user_should_see_the_private_is_selected() {
        String actualPrivacy = page.phoneNumberPrivacy.getAttribute("value");
        Assert.assertEquals("private",actualPrivacy);

    }

    @Then("the user should see the localtime in page")
    public void the_user_should_see_the_localtime_in_page() {

     BrowserUtils.scrollToElement(page.localeTimeDiv);
     Assert.assertTrue(page.localeTimeDiv.isDisplayed());

    }

    @Then("User verifies that logged in user and profile user has same full name")
    public void userVerifiesThatLoggedInUserAndProfileUserHasSameFullName() {
        String actualProfileName = page.fullNameTextbox.getAttribute("value");
        String expectedProfileName = ConfigurationReader.getProperty("username");
        Assert.assertEquals(expectedProfileName,actualProfileName);
    }

    @When("User enters invalid format email {string} to settings")
    public void userEntersInvalidFormatEmailToSettings(String email) {
        page.emailBox.clear();
        page.emailBox.sendKeys(email);
        BrowserUtils.waitFor(2);
    }

    @Then("Verifies email value is empty")
    public void verifiesEmailValueIsEmpty() {
        Driver.get().navigate().refresh();
        Assert.assertTrue(page.emailBox.getAttribute("value").isEmpty());
    }
    String expectedEmail;
    @When("User enters valid format email {string} to settings")
    public void userEntersValidFormatEmailToSettings(String email) {
        expectedEmail = email;
        page.emailBox.clear();
        page.emailBox.sendKeys(email);
        BrowserUtils.waitFor(2);
    }

    @Then("Verifies email value is changed accordingly")
    public void verifiesEmailValueIsChangedAccordingly() {
        Driver.get().navigate().refresh();
        Assert.assertTrue(page.emailBox.getAttribute("value").contains(expectedEmail));
    }

    @When("User changes the language to {string}")
    public void userChangesTheLanguageTo(String languageSelection) {
        Select select = new Select(Driver.get().findElement(By.id("languageinput")));
        select.selectByVisibleText(languageSelection);
        String selected = select.getFirstSelectedOption().getText();
        System.out.println("selected = " + selected);
    }

    @Then("Verifies language box label changed as {string}")
    public void verifiesLanguageBoxLabelChangedAs(String expectedLanguageLabelValue) {
        System.out.println("page.getLanguageLabelValue(expectedLanguageLabelValue).getText() = " + page.getLanguageLabelValue(expectedLanguageLabelValue).getText());
        Assert.assertEquals(expectedLanguageLabelValue, page.getLanguageLabelValue(expectedLanguageLabelValue).getText());
    }
}
