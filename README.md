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

Opencast-Automation-Framework/
│
├── .idea/                           # IDE configurations
├── test-output/                     # Test execution outputs & artifacts
│   └── screenshots/                 # Captured failure screenshots (e.g., test.png)
│
├── src/
│   └── test/
│       ├── java/com/opencart/automation/
│       │   ├── base/                # Base setup & teardown
│       │   │   └── BaseTest.java
│       │   │
│       │   ├── factory/             # Driver initialization & management
│       │   │   └── WebDriverFactory.java
│       │   │
│       │   ├── pages/               # Page Object Model (POM) layer
│       │   │   ├── BasePage.java
│       │   │   ├── HomePage.java
│       │   │   ├── LoginPage.java
│       │   │   └── ProductPage.java
│       │   │
│       │   ├── tests/               # Test execution classes
│       │   │   ├── DBTest.java
│       │   │   ├── LoginDataDrivenTest.java
│       │   │   ├── LoginPageTest.java
│       │   │   └── ProductPageTest.java
│       │   │
│       │   ├── data/                # Data Providers for TestNG
│       │   │   └── TestDataProvider.java
│       │   │
│       │   ├── listners/            # TestNG Listeners for logging & reporting
│       │   │   └── TestListener.java
│       │   │
│       │   └── utils/               # Helper utilities
│       │       ├── ConfigLoader.java
│       │       ├── DbUtils.java
│       │       ├── ExcelReaderUtility.java
│       │       └── ExtentManager.java
│       │
│       └── resources/               # Configurations & static test data
│           ├── testdata/
│           │   └── TestData.xlsx    # Excel test data source
│           ├── config.properties    # Environment & global settings
│           └── log4j2.xml           # Logging configuration
│
├── pom.xml                          # Maven dependencies & build management
└── testng.xml                       # Test suite runner & execution configuration


+-----------------------+
                     |      testng.xml       |
                     +-----------+-----------+
                                 |
                                 v
                     +-----------------------+
                     |    Test Execution     |
                     |     (*Test.java)      |
                     +-----------+-----------+
                                 |
        +------------------------+------------------------+
        |                        |                        |
        v                        v                        v
+---------------+        +---------------+        +---------------+
|  BaseTest     |        |  Data Layer   |        |  Page Objects |
|  (Setup/      |        | (Excel, DB,   |        |  (BasePage,   |
|   Teardown)   |        | DataProvider) |        |   Pages)      |
+-------+-------+        +---------------+        +-------+-------+
        |                                                 |
        v                                                 v
+---------------+                                 +---------------+
| Driver Factory|                                 | Web Elements  |
| (WebDriver)   |                                 | & Actions     |
+-------+-------+                                 +-------+-------+
        |                                                 |
        +------------------------+------------------------+
                                 |
                                 v
                     +-----------------------+
                     |  Reporting & Logging  |
                     |  (Extent, Log4j2,     |
                     |   TestListener)       |