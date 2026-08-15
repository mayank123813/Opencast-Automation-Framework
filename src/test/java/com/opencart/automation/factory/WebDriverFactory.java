package com.opencart.automation.factory;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverFactory {

    private static final Logger logger =
            LogManager.getLogger(WebDriverFactory.class);

    public WebDriver getBrowser(String type) {

        logger.info("Creating browser: {}", type);

        if (type.equalsIgnoreCase("chrome")) {

            logger.info("Starting Chrome browser");
            return new ChromeDriver();

        }

        if (type.equalsIgnoreCase("firefox")) {

            logger.info("Starting Firefox browser");
            return new FirefoxDriver();

        }

        if (type.equalsIgnoreCase("edge")) {

            logger.info("Starting Edge browser");
            return new EdgeDriver();

        }

        logger.error("Unsupported browser requested: {}", type);

        throw new IllegalArgumentException(
                "Unsupported browser: " + type
        );
    }
}