package com.opencart.automation.factory;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class WebDriverFactory {

    private static final Logger logger =
            LogManager.getLogger(WebDriverFactory.class);

    public WebDriver getBrowser(String type) {

        logger.info("Creating browser: {}", type);

        if (type.equalsIgnoreCase("chrome")) {

            ChromeOptions options = new ChromeOptions();

            options.addArguments("--headless=new");
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");

            logger.info("Starting Chrome browser");
            return new ChromeDriver();

        }

        if (type.equalsIgnoreCase("firefox")) {
            FirefoxOptions options = new FirefoxOptions();

            options.addArguments("-headless");
            options.addArguments("--width=1920");
            options.addArguments("--height=1080");

            logger.info("Starting Firefox browser");
            return new FirefoxDriver();

        }

        if (type.equalsIgnoreCase("edge")) {

            EdgeOptions options = new EdgeOptions();

            options.addArguments("--headless=new");
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");

            logger.info("Starting Edge browser");
            return new EdgeDriver();

        }

        logger.error("Unsupported browser requested: {}", type);

        throw new IllegalArgumentException(
                "Unsupported browser: " + type
        );
    }
}