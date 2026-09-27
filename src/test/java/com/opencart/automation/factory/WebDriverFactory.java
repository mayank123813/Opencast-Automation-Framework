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

            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");
            options.addArguments("--disable-gpu");
            options.addArguments("--start-maximized");
            options.addArguments("--disable-blink-features=AutomationControlled");
            options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
            options.setExperimentalOption("useAutomationExtension", false);

            logger.info("Starting Chrome browser");
            return new ChromeDriver(options);

        }

        if (type.equalsIgnoreCase("firefox")) {
            FirefoxOptions options = new FirefoxOptions();
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");
            options.addArguments("--disable-gpu");
            options.addArguments("--start-maximized");
            options.addArguments("--disable-blink-features=AutomationControlled");

            logger.info("Starting Firefox browser");
            return new FirefoxDriver(options);

        }

        if (type.equalsIgnoreCase("edge")) {

            EdgeOptions options = new EdgeOptions();

            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");
            options.addArguments("--disable-gpu");
            options.addArguments("--start-maximized");
            options.addArguments("--disable-blink-features=AutomationControlled");
            options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
            options.setExperimentalOption("useAutomationExtension", false);

            logger.info("Starting Edge browser");
            return new EdgeDriver(options);

        }

        logger.error("Unsupported browser requested: {}", type);

        throw new IllegalArgumentException(
                "Unsupported browser: " + type
        );
    }
}