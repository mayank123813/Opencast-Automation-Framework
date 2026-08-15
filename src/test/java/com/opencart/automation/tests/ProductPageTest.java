package com.opencart.automation.tests;

import com.opencart.automation.base.BaseTest;
import com.opencart.automation.pages.HomePage;
import com.opencart.automation.pages.LoginPage;
import com.opencart.automation.pages.ProductPage;
import com.opencart.automation.utils.ConfigLoader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProductPageTest extends BaseTest {

    @Test
    public void checkProductNameChanged(){
        LoginPage loginPage=new LoginPage(driver);
        HomePage homePage=loginPage.login(ConfigLoader.getProperty("username"),ConfigLoader.getProperty("password"));

        ProductPage productPage=new ProductPage(driver);
        productPage.clickCatalog();
        productPage.clickProducts();
        productPage.clickEditButton();
        productPage.changeProductName("dell laptop");
        productPage.saveProduct();

        String updated= productPage.getProductName();
        productPage.clickBack();
        Assert.assertTrue(productPage.verifyProductNameEdited(updated));





    }
}
