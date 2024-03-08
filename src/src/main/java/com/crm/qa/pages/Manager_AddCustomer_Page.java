package com.crm.qa.pages;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.crm.qa.base.TestBase;

public class Manager_AddCustomer_Page extends TestBase {
    
    @FindBy(xpath = "//button[@ng-click='manager()']")
    public WebElement ManagerLoginButton;
    
    @FindBy(xpath = "//button[@ng-class='btnClass1']")
    public WebElement AddCustomerButton;
    
    @FindBy(xpath = "//input[@ng-model='fName']")
    public WebElement FirstName;
    
    @FindBy(xpath = "//input[@ng-model='lName']")
    public WebElement LastName;
    
    @FindBy(xpath = "//input[@ng-model='postCd']")
    public WebElement PostCode;
    
    @FindBy(xpath = "//button[@type = 'submit']")
    public WebElement AddCustomerSubmitButton;

    public Manager_AddCustomer_Page() {
        PageFactory.initElements(driver, this);
    }
    
    // Method to click on the Bank Manager Login button
    public void loginAsBankManager() {
        ManagerLoginButton.click();
    }
    
    // Method to add a new customer with provided details
    public void addCustomer(String firstName, String lastName, String postCode){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        
        wait.until(ExpectedConditions.elementToBeClickable(AddCustomerButton)).click();
        FirstName.sendKeys(firstName);
        LastName.sendKeys(lastName);
        PostCode.sendKeys(postCode);
        AddCustomerSubmitButton.click();
        
        try {
            Alert alert = driver.switchTo().alert();
            alert.accept();
        } catch (NoAlertPresentException e) {
            // No alert present, do nothing
        }
    }
}
