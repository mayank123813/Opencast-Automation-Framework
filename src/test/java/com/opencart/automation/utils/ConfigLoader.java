package com.opencart.automation.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigLoader {

    private static final Logger logger =
            LogManager.getLogger(ConfigLoader.class);

    private static final Properties properties =
            new Properties();

    static {

        try (InputStream inputStream =
                     ConfigLoader.class
                             .getClassLoader()
                             .getResourceAsStream(
                                     "config.properties")) {

            if (inputStream == null) {

                logger.error(
                        "config.properties not found"
                );

                throw new RuntimeException(
                        "config.properties not found"
                );
            }

            properties.load(inputStream);

            logger.info(
                    "config.properties loaded successfully"
            );

        } catch (IOException e) {

            logger.error(
                    "Failed to load config.properties",
                    e
            );

            throw new RuntimeException(
                    "Failed to load config.properties",
                    e
            );
        }
    }

    public static String getProperty(String key) {

        logger.debug(
                "Reading configuration property: {}",
                key
        );

        return properties.getProperty(key);
    }
}