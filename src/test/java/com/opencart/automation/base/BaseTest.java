package com.opencart.automation.base;

import com.opencart.automation.factory.WebDriverFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.openqa.selenium.WebDriver;

public class BaseTest {

    protected WebDriver driver;

    private static final Logger logger =
            LogManager.getLogger(BaseTest.class);

    public WebDriver getDriver() {
        return driver;
    }

    @BeforeMethod
    public void setup() {

        logger.info("Starting browser setup");

        WebDriverFactory factory = new WebDriverFactory();

        driver = factory.getBrowser("chrome");

        logger.info("Chrome browser started");

        driver.manage().window().maximize();

        logger.info("Browser window maximized");

        driver.get("http://localhost/opencart/mayankadmin/");

        logger.info("Navigated to OpenCart application");
    }

    @AfterMethod
    public void tearDown() {

        if (driver != null) {

            logger.info("Closing browser");

            driver.quit();

            logger.info("Browser closed successfully");
        }
    }
}
