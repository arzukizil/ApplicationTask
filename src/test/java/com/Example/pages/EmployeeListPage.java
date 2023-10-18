package com.Example.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EmployeeListPage extends BasePage {

    @FindBy(xpath = "//*[@name=\"searchTerm\"]")
    public WebElement searchField;

    @FindBy(xpath = "//*[@class=\"btn btn-default\"]")
    public WebElement searchBtn;

    @FindBy(xpath = "/html/body/div[2]/table/tbody/tr[2]/td[1]")
    public WebElement isNameThere;

    @FindBy(xpath = "/html/body/div[2]/table/tbody/tr[2]/td[6]/a[3]")
    public WebElement deleteLink;

    @FindBy(xpath = "(//input[@value='Delete'])")

    public WebElement confirmDelete;

    @FindBy (xpath ="/html/body/div[2]/table/tbody/tr")
    public WebElement tableList;



}
