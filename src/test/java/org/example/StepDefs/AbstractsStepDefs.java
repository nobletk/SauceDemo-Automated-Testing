package org.example.StepDefs;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.example.Pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public abstract class AbstractsStepDefs {
    private static final int WAIT_TIME = 10;

    static WebDriver driver;

    protected static HomePage homePage;

    static  {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(WAIT_TIME, TimeUnit.SECONDS);
        homePage = new HomePage(driver);
    }
}
