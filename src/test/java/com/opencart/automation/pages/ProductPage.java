package com.opencart.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class ProductPage extends BasePage {
    public ProductPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(css = "#menu-catalog a:first-child")
    private WebElement catalog;
    @FindBy(xpath = "(//ul[@id='collapse-1']//li)[2]")
    private WebElement product;
    @FindBy(css = "tr .btn-group a[data-bs-toggle='tooltip']")
    List<WebElement> edit;
    @FindBy(id="input-name-1")
    private WebElement productNameChange;
    @FindBy(css = ".fa-floppy-disk")
    private WebElement save;
    @FindBy(css = ".fa-reply")
    private WebElement back;
    @FindBy(css = "tr td:nth-child(3)")
    private List<WebElement> productName;

    public void clickEditButton() {
        wait.until(ExpectedConditions.elementToBeClickable(edit.get(0))).click();
    }

        public boolean verifyProductNameEdited(String expected) {
            return productName.stream()
                    .anyMatch(element ->
                            element.getText().equalsIgnoreCase(expected));
    }

    public void clickCatalog() {
        wait.until(ExpectedConditions.elementToBeClickable(catalog)).click();
    }
    public void clickProducts() {
        wait.until(ExpectedConditions.elementToBeClickable(product)).click();
    }
    public void changeProductName(String newName) {
        wait.until(ExpectedConditions.visibilityOf(productNameChange));

        productNameChange.clear();
        productNameChange.sendKeys(newName);
    }

    public void saveProduct() {
        wait.until(ExpectedConditions.elementToBeClickable(save)).click();
    }

    public void clickBack() {
        wait.until(ExpectedConditions.elementToBeClickable(back)).click();
    }

    public String getProductName() {
        return productNameChange.getAttribute("value");
    }

}