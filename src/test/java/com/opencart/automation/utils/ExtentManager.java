package com.opencart.automation.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {
   private static ExtentReports extent;
   public static ExtentReports getExtentReports() {
       if (extent == null) {
           ExtentSparkReporter sparkReporter = new ExtentSparkReporter("test-output/ExtentReport.html");

           extent = new ExtentReports();
           extent.attachReporter(sparkReporter);

           extent.setSystemInfo("fraemwork","opencart");
           extent.setSystemInfo("Enviroment","Qa");
           extent.setSystemInfo("Browser","chrome");
       }
       return extent;
   }
}
