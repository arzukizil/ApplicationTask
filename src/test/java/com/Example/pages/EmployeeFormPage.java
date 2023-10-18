package com.Example.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EmployeeFormPage extends BasePage{

    @FindBy(xpath = "//a[normalize-space()='Employee List']")
    public WebElement employeeListBtn;

    @FindBy(xpath ="/html/body/div[2]/form/a")
    public WebElement createNewBtn;

    @FindBy(xpath = "//*[@class=\"btn btn-default\"]")
    public WebElement createBtn;

    @FindBy(xpath = "//*[@id=\"Name\"]")
    public WebElement nameField;

    @FindBy(xpath = "//*[@id=\"Salary\"]")
    public WebElement salaryField;

    @FindBy(xpath = "//*[@id=\"DurationWorked\"]")
    public WebElement durationField;

    @FindBy(xpath = "//*[@id=\"Grade\"]")
    public WebElement gradeField;

    @FindBy(xpath = "//*[@id=\"Email\"]")
    public WebElement emailField;


    public void enterCredentials(String name, String salary, String duration, String grade, String email){
        nameField.sendKeys(name);
        salaryField.sendKeys(salary);
        durationField.sendKeys(duration);
        gradeField.sendKeys(grade);
        emailField.sendKeys(email);

    }


}
