package com.Example.pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {
    public LoginPage(){
        PageFactory.initElements(com.Example.utilities.Driver.getDriver(), this);
    }
    @FindBy(xpath = "//*[@id=\"loginLink\"]")
    public WebElement login;

    @FindBy(xpath = "//*[@id='UserName']")
    public WebElement usernameField;

    @FindBy(xpath = "//*[@id=\"Password\"]")
    public WebElement passwordField;

    @FindBy(xpath = "//*[@id=\"loginForm\"]/form/div[4]/div/input")
    public WebElement loginBtn;

    public void loginWithCredentials(String username, String password){
        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
        loginBtn.click();
    }
}
