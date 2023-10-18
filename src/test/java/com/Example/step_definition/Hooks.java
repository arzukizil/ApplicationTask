package com.Example.step_definition;


import com.Example.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Hooks {

    public static WebDriver driver;
    @Before()
    public void setUp(){
        driver = Driver.getDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
    }





    // @Before (order =0)
    public void setupScenario(){
        System.out.println("====Setting up browser using Cucumber @Before");
    }

    //@Before(value="@login", order=1)
    public void setupScenarioForLogins(){
        System.out.println("======= this will only apply to scenarios with @login tag");
    }

    // @Before(value="@db", order=1)
    public void setupForDataBaseScenarios(){
        System.out.println("======= this will only apply to scenarios with @login tag");
    }
    @After
    public void teardownScenario(Scenario scenario){

        if(scenario.isFailed()) {
            byte[] screenshot = ((TakesScreenshot) com.Example.utilities.Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName());
        }
        //System.out.println("==== Closing the browser using Cucumber @After");
        //  System.out.println("==== Scenario ended/ Take screenshot if failed");

        //Driver.closeDriver();
    }
    //@BeforeStep
    public void setupStep(){
        System.out.println("-----> applying setup using @BeforeStep");
    }

    // @AfterStep
    public void afterStep(){
        System.out.println("-----> applying tearDown using @AfterStep");
    }
}
