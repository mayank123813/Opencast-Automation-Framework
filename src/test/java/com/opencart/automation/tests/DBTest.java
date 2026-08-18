package com.opencart.automation.tests;

import com.opencart.automation.base.BaseTest;
import com.opencart.automation.utils.DbUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.sql.SQLException;

public class DBTest extends BaseTest {

    @Test(groups = {"sanity","regression"})
    public void checkUIAndDBInputMatch() throws SQLException {
        int productId=42;

        String realProductName="dell laptop";
        String expectedProductName= DbUtils.getProductName(productId);

        Assert.assertEquals(realProductName,expectedProductName);
    }
}