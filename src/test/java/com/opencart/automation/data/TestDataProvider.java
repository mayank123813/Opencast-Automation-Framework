package com.opencart.automation.data;

import com.opencart.automation.utils.ConfigLoader;
import com.opencart.automation.utils.ExcelReaderUtility;
import org.testng.annotations.DataProvider;

import java.io.IOException;

public class TestDataProvider {

    @DataProvider(name = "loginData")
    public Object[][] loginDta() throws IOException {


        return ExcelReaderUtility.getExcelData(
                "src/test/resources/testdata/TestData.xlsx",
                "Sheet1"
        );
    }
}
