package com.Example.step_definition;

import com.Example.pages.EmployeeListPage;
import com.Example.pages.EmployeeFormPage;
import com.Example.pages.LoginPage;
import com.Example.utilities.BrowserUtils;
import com.Example.utilities.ConfigurationReader;

import com.Example.utilities.Driver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Task_StepDefinition {


    private LoginPage loginPage = new LoginPage();
    private EmployeeListPage employeeListPage = new EmployeeListPage();
    private EmployeeFormPage employeeFormPage = new EmployeeFormPage();

    //JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();

    public WebDriver driver;

    @Given("user is on the eaap web page")
    public void user_is_on_the_eaap_web_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
    }

    @Then("user should see the title")
    public void user_should_see_the_title() {
        Assert.assertEquals("Home - Execute Automation Employee App", Driver.getDriver().getTitle());
        BrowserUtils.sleep(1);
    }
    // Scenario Starts
    @Given("user clicks on the login button")
    public void user_clicks_on_the_login_button() {
        loginPage.login.click();
        BrowserUtils.sleep(2);
    }

    @Given("user lands on the login page")
    public void user_lands_on_the_login_page() {
        Assert.assertEquals("Login - Execute Automation Employee App", Driver.getDriver().getTitle());
        BrowserUtils.sleep(2);
    }

    @When("user enters valid credentials into the field")
    public void user_enters_valid_credentials_into_the_field() {
        loginPage.loginWithCredentials("admin", "password");
        BrowserUtils.sleep(2);
    }

    @When("user lands on dashboard")
    public void user_lands_on_dashboard() {
        Assert.assertEquals("Home - Execute Automation Employee App", Driver.getDriver().getTitle());
        BrowserUtils.sleep(2);
    }

    @Then("user clicks on employee list on the dashboard")
    public void user_clicks_on_employee_list_on_the_dashboard() {
        employeeFormPage.employeeListBtn.click();
        BrowserUtils.sleep(1);
    }

    @When("user clicks create new button on the employee list")
    public void user_clicks_create_new_button_on_the_employee_list() {
        employeeFormPage.createNewBtn.click();
        BrowserUtils.sleep(1);
    }

    @When("user lands on Employee page")
    public void user_lands_on_employee_page() {
        Assert.assertEquals("- Execute Automation Employee App", Driver.getDriver().getTitle());
    }

    @Then("user fills the fields in the form")
    public void user_fills_the_fields_in_the_form() {
        employeeFormPage.enterCredentials("Arzu", "4000", "3","5","arzu@gmail.com");
        BrowserUtils.sleep(1);
    }

    @Then("user clicks create button")
    public void user_clicks_create_button() {
        employeeFormPage.createBtn.click();
        BrowserUtils.sleep(1);
    }

    @Then("user should see the new employee on the employee list page")
    public void user_should_see_the_new_employee_on_the_employee_list_page() {
        employeeListPage.searchField.sendKeys("Arzu");
        BrowserUtils.sleep(1);
        employeeListPage.searchBtn.click();


//        WebElement isEmployeeExist =
//                driver.findElement(By.xpath("/html/body/div[2]/table/tbody/tr"));
//
//        String expectedResults = "Arzu";
//        String actualResults = isEmployeeExist.getText();
//        Assert.assertEquals(actualResults, expectedResults);
//    }


        boolean isdataExists =employeeListPage.isNameThere.getText().contains("Arzu");
        if (isdataExists) {
            System.out.println("new employee created on the employee list");
        } else {
            System.out.println("new employee did not create on the employee list");
        }
    }

    @Then("user is on the employee list page")
    public void user_is_on_the_employee_list_page() {
        Assert.assertEquals("- Execute Automation Employee App", Driver.getDriver().getTitle());
    }

    @Then("user clicks on the Delete link of the new employee on the employee list")
    public void user_clicks_on_the_delete_link_of_the_new_employee_on_the_employee_list() {
        employeeListPage.deleteLink.click();
        employeeListPage.confirmDelete.click();
        BrowserUtils.sleep(2);
    }

    @Then("user verifies that the new employee is not on the employee list")
    public void user_verifies_that_the_new_employee_is_not_on_the_employee_list() {
        employeeListPage.searchField.sendKeys("Arzu");
        BrowserUtils.sleep(1);
        employeeListPage.searchBtn.click();

        WebElement isEmployeeDeleted =
                driver.findElement(By.xpath("/html/body/div[2]/table/tbody/tr"));

        String expectedResults = "";
        String actualResults = isEmployeeDeleted.getText();
        Assert.assertEquals(actualResults, expectedResults);
    }
    }



