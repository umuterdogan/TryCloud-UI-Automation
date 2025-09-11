package net.trycloud.step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.trycloud.pages.*;
import net.trycloud.utilities.BrowserUtils;
import net.trycloud.utilities.ConfigurationReader;
import net.trycloud.utilities.Driver;
import org.junit.Assert;

public class LoginPageStepDefs {

    @Given("the user on the login page")
    public void the_user_on_the_login_page() {
    Driver.get().get(ConfigurationReader.getProperty("url"));
    }

    @Given("the user is logged in")
    public void the_user_is_logged_in() {
        new LoginPage().login();

    }

    @Then("the user should see the title {string}")
    public void the_user_should_see_the_title(String expectedPageTitle) {
        Assert.assertEquals(expectedPageTitle,  Driver.get().getTitle());

    }

    @Then("the user should see the message {string}")
    public void the_user_should_see_the_message(String expectedErrorMessage) {
        String actualMessage="";
        switch (expectedErrorMessage){
            case "Wrong username or password.":
                actualMessage = new LoginPage().errorMessage.getText();
                break;
            case "You created the conversation":
                actualMessage = new TalkPage().createSuccessMsg.getText();
                break;
            default:
                System.out.println("The element not found.");
        }

        Assert.assertEquals(expectedErrorMessage,  actualMessage);
    }

    @Then("the user should see the url contains {string}")
    public void the_user_should_see_the_url(String expectedURL) {

        System.out.println(Driver.get().getCurrentUrl());
        Assert.assertTrue(Driver.get().getCurrentUrl().contains(expectedURL));

    }


    @Then("the user should see the username as {string}")
    public void the_user_should_see_the_username_as(String expectedUserName) {
       Assert.assertEquals(expectedUserName,  new HomePage().getUserName());

    }

    @Given("the user is logged in with {string}")
    public void the_user_is_logged_in_with(String submitType) {
       new LoginPage().login(submitType);
    }

    @Given("the user is logged in {string} and {string} with {string}")
    public void the_user_is_logged_in_and_with(String userName, String password, String submitType) {
    new LoginPage().login(userName,password,submitType);
    }

    @Given("the user enters the password")
    public void the_user_enters_the_password() {
 new LoginPage().userPasswordBox.sendKeys(ConfigurationReader.getProperty("password"));
    }

    @Then("the user should see the password form of dots")
    public void the_user_should_see_the_password_form_of_dots() {
      Assert.assertEquals("password",  new LoginPage().userPasswordBox.getAttribute("type"));

    }

    @Given("the user clicks the toggle button")
    public void the_user_clicks_the_toggle_button() {
     new LoginPage().toogleButton.click();
     BrowserUtils.waitFor(2);
    }

    @Then("the user  should see the password explicitly")
    public void the_user_should_see_the_password_explicitly() {
        Assert.assertEquals("text",new LoginPage().userPasswordBox.getAttribute("type"));

    }


    @Then("the user should see the forgot password link")
    public void the_user_should_see_the_forgot_password_link() {
      Assert.assertTrue(new LoginPage().forgotLabel.isDisplayed());
    }

    @When("the user clicks the forgot password link")
    public void the_user_clicks_the_forgot_pasword_link() {
        System.out.println("new LoginPage().userPasswordBox.getAttribute(\"aria-label\") = " + new LoginPage().userPasswordBox.getAttribute("aria-label"));

        new LoginPage().forgotLabel.click();
    }

    @Then("the user should see the {string} button")
    public void the_user_should_see_the_button(String expectedValue) {
        BrowserUtils.waitForVisibility(new LoginPage().resetPasswordButton,10);
         Assert.assertTrue(new LoginPage().resetPasswordButton.isDisplayed());
        Assert.assertEquals(expectedValue,new LoginPage().resetPasswordButton.getAttribute("value"));

    }


    @Then("the user should see the {string} as placeholder for {string} textbox")
    public void the_user_should_see_the_as_placeholder_for_textbox(String expectedValue, String textBoxType) {
        if (textBoxType.equals("password")){
            BrowserUtils.waitFor(1);
            Assert.assertEquals(expectedValue,new LoginPage().userPasswordBox.getAttribute("aria-label"));
        }
        if (textBoxType.equals("username")){
            BrowserUtils.waitFor(1);
            Assert.assertEquals(expectedValue,new LoginPage().userLoginBox.getAttribute("aria-label"));
        }

    }



}
