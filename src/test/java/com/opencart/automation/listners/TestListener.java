package com.opencart.automation.listners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.opencart.automation.base.BaseTest;
import com.opencart.automation.utils.ExtentManager;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;

public class TestListener implements ITestListener {

    private static final Logger logger =
            LogManager.getLogger(TestListener.class);

    private ExtentReports extent =
            ExtentManager.getExtentReports();

    private ThreadLocal<ExtentTest> extentTest =
            new ThreadLocal<>();

    @Override
    public void onTestStart(ITestResult result) {

        ExtentTest test =
                extent.createTest(result.getName());

        extentTest.set(test);

        extentTest.get().info("Test execution started");

        logger.info(
                "TEST STARTED: {}",
                result.getName()
        );
    }

    @Override
    public void onTestSuccess(ITestResult result) {

        extentTest.get().pass("Test passed");

        logger.info(
                "TEST PASSED: {}",
                result.getName()
        );
    }

    @Override
    public void onTestFailure(ITestResult result) {

        WebDriver driver =
                ((BaseTest) result.getInstance()).getDriver();

        if (driver != null) {

            TakesScreenshot ts = (TakesScreenshot) driver;

            File src = ts.getScreenshotAs(OutputType.FILE);

            File des = new File(
                    "test-output/screenshots/"
                            + result.getName()
                            + ".png"
            );

            try {
                FileUtils.copyFile(src, des);

                extentTest.get().addScreenCaptureFromPath(
                        des.getPath()
                );

            } catch (IOException e) {
                logger.error("Unable to capture screenshot", e);
            }

        } else {

            logger.error(
                    "WebDriver is null. Screenshot cannot be captured."
            );
        }

        extentTest.get().fail(result.getThrowable());

        logger.error(
                "TEST FAILED: {}",
                result.getName()
        );

        logger.error(
                "Failure reason",
                result.getThrowable()
        );
    }

    @Override
    public void onTestSkipped(ITestResult result) {

        extentTest.get().skip("Test skipped");

        logger.warn(
                "TEST SKIPPED: {}",
                result.getName()
        );
    }

    @Override
    public void onFinish(ITestContext context) {

        extent.flush();

        logger.info("Test execution finished");
    }
}