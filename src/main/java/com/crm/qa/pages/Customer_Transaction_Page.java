package com.crm.qa.pages;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Customer_Transaction_Page extends Customer_Withdraw_Page {
    
    @FindBy(xpath = "//button[@ng-class='btnClass1']")
    public WebElement Transactions_Button;
    
    @FindBy(xpath = "//button[@ng-click='reset()']")
    public WebElement Reset_Button;
    
    @FindBy(xpath = "//button[@ng-click='back()']")
    public WebElement Back_Button;
    
    @FindBy(xpath = "//button[@ng-click='byebye()']")
    public WebElement Logout_Button;

    public Customer_Transaction_Page() {
        PageFactory.initElements(driver, this);
    }
    
    // Method to perform various actions on the Transaction page
    public void Customer_Trans() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Click on the Transactions Button
        wait.until(ExpectedConditions.visibilityOf(Transactions_Button)).click();
        System.out.println("User selected Transactions Button");

        // Click on the Back Button
        wait.until(ExpectedConditions.visibilityOf(Back_Button)).click();
        System.out.println("User clicked Back Button");

        // Click on the Transactions Button again
        wait.until(ExpectedConditions.visibilityOf(Transactions_Button)).click();
        System.out.println("User selected Transactions Button");

        // Click on the Reset Button
        wait.until(ExpectedConditions.visibilityOf(Reset_Button)).click();
        System.out.println("User clicked Reset Button");

        // Click on the Logout Button
        wait.until(ExpectedConditions.visibilityOf(Logout_Button)).click();
        System.out.println("User clicked Logout Button");
    }
}
