package com.Example.utilities;

import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class BrowserUtils {
    public static void sleep(int second){
        second *=1000;
        try {
            Thread.sleep(second);
        }catch (InterruptedException e ) {

        }
    }

    public static void wait(int seconds) {
        try {
            Thread.sleep(seconds * 2000L);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String getURL(){
        return Driver.getDriver().getCurrentUrl();
    }



    public static void clickWithMouseHoverAction(WebElement element){
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(element).pause(500).click(element).build().perform();
    }

    public static void openNewTab() {
        ((JavascriptExecutor) Driver.getDriver()).executeScript("window.open();");
    }

    //wait till a new window gets opened
    public static void waitForNewWindow() {
        try {
            WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(2));
            wait.until(ExpectedConditions.numberOfWindowsToBe(2));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void waitForInvisibilityOf(WebElement webElement) {
        // Driver.getDriver().manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(2));
        wait.until(ExpectedConditions.invisibilityOf(webElement));
    }


    public static void switchWindowAndVerify( String expectedInUrl, String expectedInTitle){

        Set<String> allWindowsHandles = Driver.getDriver().getWindowHandles();

        for (String each : allWindowsHandles) {

            Driver.getDriver().switchTo().window(each);

            System.out.println("Current URL: " + Driver.getDriver().getCurrentUrl());

            if (Driver.getDriver().getCurrentUrl().contains(expectedInUrl)){
                break;
            }
        }


        String actualTitle = Driver.getDriver().getTitle();
        Assert.assertTrue(actualTitle.contains(expectedInTitle));
    }

    public static void verifyTitle(WebDriver driver , String expectedTitle){

        Assert.assertEquals(Driver.getDriver().getTitle(), expectedTitle);

    }



    public static void verifyTitleContains(String expectedInTitle){
        Driver.getDriver().getCurrentUrl().contains(expectedInTitle);
    }

    public static List<String> dropDown(WebElement dropDownElement){
        System.out.println(dropDownElement);
        Select select = new Select(dropDownElement);
        List<WebElement> actualOptionsAsWebElements= select.getOptions();

        List<String> actualOptionsAsString=  new ArrayList<>();

        for (WebElement each : actualOptionsAsWebElements) {
            actualOptionsAsString.add(each.getText());
        }
        return actualOptionsAsString;
    }

    public static void clickRadioButton(List<WebElement> radioButtons, String attributeValue){

        for (WebElement each : radioButtons) {
            if(each.getAttribute("value").equalsIgnoreCase(attributeValue)) {
                each.click();
            }
        }
    }
}