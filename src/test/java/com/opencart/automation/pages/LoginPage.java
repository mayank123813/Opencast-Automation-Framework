package com.opencart.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

    public LoginPage(WebDriver driver){
        super(driver);
    }

    @FindBy(id="input-username")
    private WebElement username;
    @FindBy(id="input-password")
    private WebElement password;
    @FindBy(css = ".btn-primary")
    private WebElement loginBtn;


    public HomePage login(String userName,String passWord){
        username.sendKeys(userName);
        password.sendKeys(passWord);
        loginBtn.click();

        return new HomePage(driver);
    }


}
