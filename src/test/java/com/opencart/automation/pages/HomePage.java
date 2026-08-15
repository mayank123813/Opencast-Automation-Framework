package com.opencart.automation.pages;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage{

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//h1[text()='Dashboard']")
            private WebElement dashboard;

    public boolean isMyAccountDisplayed() {
        try {
            wait.until(ExpectedConditions.visibilityOf(dashboard));
            return dashboard.isDisplayed();
        }catch (TimeoutException e){
            return false;
        }
    }

}
