# OpenCart Automation Framework

This is a Selenium automation framework for OpenCart.

## Technologies

- Java
- Selenium WebDriver
- TestNG
- Maven
- Apache POI
- JDBC
- MariaDB / MySQL
- Extent Reports
- Log4j2
- Git / GitHub

## Features

- Page Object Model (POM)
- WebDriver Factory
- TestNG test execution
- Data-driven testing
- Excel-based test data
- Database validation using JDBC
- TestNG Listeners
- Parallel test execution
- Extent HTML reporting
- Log4j2 logging
- External configuration using config.properties
- Maven dependency management

## Page Object Model

The framework follows the Page Object Model design pattern.

Each application page has a separate Page Object class containing:

- Locators
- WebElements
- Page-specific actions

Test classes use page methods instead of directly implementing Selenium operations.

### Benefits

- Better maintainability
- Code reusability
- Separation of test and UI logic
- Easier locator maintenance
- Cleaner test classes

## WebDriver Factory

WebDriverFactory is responsible for creating browser instances.

Supported browsers:

- Chrome
- Firefox
- Edge

Example:

```java
WebDriverFactory factory = new WebDriverFactory();
WebDriver driver = factory.getBrowser("chrome");