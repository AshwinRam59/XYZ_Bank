package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;

public class Customer_Login_Page extends Manager_Customer_page {
    
    @FindBy(xpath = "//button[@ng-click='customer()']")
    public WebElement CustomerLogin_Button;
    
    @FindBy(xpath = "//select[@ng-model='custId']")
    public WebElement YourName_Button;
    
    @FindBy(xpath = "//option[text() = 'Ashwin Ramteke']")
    public WebElement CustomerName;
    
    @FindBy(xpath = "//button[@type = 'submit']")
    public WebElement Login_Button;
    
    @FindBy(xpath = "//button[@ng-click='deposit()']")
    public WebElement Deposit_Button;
    
    @FindBy(xpath = "//input[@placeholder='amount']")
    public WebElement Dep_Amount;
    
    @FindBy(xpath = "//button[@type = 'submit']")
    public WebElement AmountDeposit_Button;

    public Customer_Login_Page() {
        PageFactory.initElements(driver, this);
    }
    
    // Method to click on the Customer Login button
    public void loginAsCustomer() {
    CustomerLogin_Button.click();
        System.out.println("User clicked on Customer Button");
    }
    
    // Method to add a new customer with provided details
    public void Customer_Deposit(List<String> deposits){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        
        CustomerLogin_Button.click();
        System.out.println("User clicked on Customer Button");
        
        // Click on the Your Name Dropdown
        wait.until(ExpectedConditions.visibilityOf(YourName_Button)).click();
        System.out.println("User clicked on Your Name Dropdown");
        
        // Select the customer name 'Ashwin Ramteke'
        wait.until(ExpectedConditions.visibilityOf(CustomerName)).click();
        System.out.println("User selected name Ashwin Ramteke");
        
        // Click on the Login Button
        Login_Button.click();
        System.out.println("User clicked Login Button");
        
        // Click on the Deposit Button
        wait.until(ExpectedConditions.visibilityOf(Deposit_Button)).click();
        System.out.println("User selected  Deposit Button");
        
        // Deposit money for each specified amount
        for (String deposit : deposits) {
            Dep_Amount.clear();
            Dep_Amount.sendKeys(deposit);
            AmountDeposit_Button.click();
            System.out.println("Money deposited to account");
        }
    }
}
