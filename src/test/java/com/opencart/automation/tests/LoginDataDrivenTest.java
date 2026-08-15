package com.opencart.automation.tests;

import com.opencart.automation.base.BaseTest;
import com.opencart.automation.data.TestDataProvider;
import com.opencart.automation.pages.HomePage;
import com.opencart.automation.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginDataDrivenTest extends BaseTest {

    @Test(dataProvider = "loginData",dataProviderClass = TestDataProvider.class)
    public void test(String username,String password){
        LoginPage loginPage=new LoginPage(driver);
        loginPage.login(username,password);
        HomePage homePage = new HomePage(driver);
        Assert.assertTrue(homePage.isMyAccountDisplayed(),"not displayed");
    }
}
