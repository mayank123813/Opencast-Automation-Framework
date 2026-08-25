package com.opencart.automation.base;

import com.opencart.automation.factory.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    protected WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void setup() {

        WebDriverFactory factory = new WebDriverFactory();

        driver = factory.getBrowser("chrome");

        driver.manage().window().maximize();

        driver.get("http://localhost/opencart/mayankadmin/");
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {

        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

    public WebDriver getDriver() {
        return driver;
    }
}