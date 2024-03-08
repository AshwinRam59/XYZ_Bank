package com.crm.qa.pages;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.testng.Assert;

public class Manager_Customer_page extends Manager_OpenAccount_page {
    
    @FindBy(xpath = "//button[@ng-click ='showCust()']")
    WebElement Customer_Button;
    
    @FindBy(xpath = "//div[@class='marTop ng-scope']")
    WebElement Table;
    
    @FindBy(xpath = "//input[@ng-model='searchCustomer']")
    WebElement Search;
    
    @FindBy(xpath = "//button[@ng-click='deleteCust(cust)']")
    WebElement Delete_Button;
    
    @FindBy(xpath = "//button[@ng-click='home()']")
    WebElement Home_Button;


    public Manager_Customer_page() {
        PageFactory.initElements(driver, this);
    }

    // Method to perform various actions on the Customers table
    public void CustomersTabletest() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Click on the Customer button
        wait.until(ExpectedConditions.visibilityOf(Customer_Button)).click();
        System.out.println("User clicked on Customer button");

        // Check if the Customers table is displayed
        Assert.assertTrue(wait.until(ExpectedConditions.visibilityOf(Table)).isDisplayed());
        System.out.println("User able to see details of existing customers");

        // Search for a customer named Hermoine
        wait.until(ExpectedConditions.visibilityOf(Search)).click();
        Search.sendKeys("Hermoine");
        System.out.println("User searched for name Hermoine");

        // Delete the customer Hermoine Granger from the list
        wait.until(ExpectedConditions.visibilityOf(Delete_Button)).click();
        System.out.println("Customer Hermoine Granger is deleted from the customer list");

        // Click on the Home button
        wait.until(ExpectedConditions.visibilityOf(Home_Button)).click();
        System.out.println("User Clicked on Home Button");
    }
}
