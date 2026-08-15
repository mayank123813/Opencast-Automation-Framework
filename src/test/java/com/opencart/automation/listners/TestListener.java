package com.opencart.automation.listners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.opencart.automation.utils.ExtentManager;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

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

        extentTest.get().fail(
                result.getThrowable()
        );

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