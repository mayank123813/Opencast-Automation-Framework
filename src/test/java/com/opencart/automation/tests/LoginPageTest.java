package com.opencart.automation.tests;

import com.opencart.automation.base.BaseTest;
import com.opencart.automation.pages.HomePage;
import com.opencart.automation.pages.LoginPage;
import com.opencart.automation.utils.ConfigLoader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginPageTest extends BaseTest {

    @Test(groups = {"smoke"})
    public void login(){
        LoginPage loginPage=new LoginPage(driver);
        HomePage homePage=loginPage.login(ConfigLoader.getProperty("username"),ConfigLoader.getProperty("password"));
        Assert.assertTrue(homePage.isMyAccountDisplayed(),"not displayed");
    }
}
