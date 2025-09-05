package net.trycloud.step_definitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.trycloud.pages.HomePage;
import net.trycloud.pages.TaskPage;
import net.trycloud.utilities.BrowserUtils;
import org.junit.Assert;
import org.openqa.selenium.Keys;

public class List_of_Task_StepDefs {
    @When("user can click task icon")
    public void user_can_click_task_icon() {
        new HomePage ().TaskIcon.click ();
        BrowserUtils.waitFor ( 5 );
    }

    @When("Click Add to list")
    public void click_Add_to_list() {
        new TaskPage ().AddListIcon.click ();

    }

    @When("Enter {string} task and click save")
    public void enter_task_and_click_save(String TaskName) {

        new TaskPage ().NewListEnter.sendKeys (  TaskName);
     new TaskPage ().NewListEnter.sendKeys ( Keys.ENTER );
    }




    @Then("User cans see left drop down menu {string} appear in the {string} list")
    public void user_cans_see_left_drop_down_menu_appear_in_the_list(String expected, String listName) {
        Assert.assertEquals (expected,new TaskPage ().LeftDropdownResult.getAttribute ( "title" )  );
        BrowserUtils.waitFor ( 5 );
        new TaskPage ().deleteList ( listName );

    }

    @When("Enter your task {string}")
    public void enter_your_task(String task) {
        new TaskPage ().AddtoTask.sendKeys ( task );
        new TaskPage ().AddtoTask.sendKeys ( Keys.ENTER);


    }


    @Then("User can see created task {string} in the {string} list")
    public void user_can_see_created_task_in_the_list(String expected, String listName) {
        Assert.assertEquals ( expected,new TaskPage ().TaskResult.getText () );
        BrowserUtils.waitFor ( 3 );
        new TaskPage ().deleteList (listName);
    }

    @When("Click check box of task done")
    public void click_check_box_of_task_done() {
       new TaskPage ().checkBoxOfTask.click ();
    }

    @When("Click Completed Icon")
    public void click_Completed_Icon() {
        new TaskPage ().CompletedIcon.click ();

    }


    @Then("User can see task done {string} in the {string} list")
    public void user_can_see_task_done_in_the_list(String expected, String listName) {
        Assert.assertEquals ( expected,new TaskPage ().CompletedResult.getText () );
        new TaskPage ().deleteList (listName);
    }


    @When("Click Important Star")
    public void click_Important_Star() {
        new TaskPage ().ImportantStar.click ();
    }

    @When("Click  Important Icon")
    public void click_Important_Icon() {
       new TaskPage ().ImportantIcon.click ();
    }

    @Then("User can see  task on Important page {string}")
    public void user_can_see_task_on_Important_page(String expected) {

    }
    @Then("User can see  task on Important page {string} in the {string} list")
    public void user_can_see_task_on_Important_page_in_the_list(String expected, String listName) {
        Assert.assertEquals ( expected,new TaskPage ().ImportantResult.getText () );
        new TaskPage ().deleteList (listName);
    }

    @When("Click  Current Icon")
    public void click_Current_Icon() {
       new TaskPage ().CurrentIcon.click ();
       BrowserUtils.waitFor ( 5 );
    }


    @Then("User can see task on Current page {string} in the {string} list")
    public void user_can_see_task_on_Current_page_in_the_list(String expected, String listName) {
        Assert.assertEquals ( expected,new TaskPage ().CurrentResult.getText () );
        new TaskPage ().deleteList (listName);
    }






}
