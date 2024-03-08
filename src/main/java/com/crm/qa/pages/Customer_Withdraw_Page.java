package com.crm.qa.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

import org.testng.Assert;

public class Customer_Withdraw_Page extends Customer_Login_Page {
    
    
    @FindBy(xpath = "//button[@ng-click='withdrawl()']")
    public
    WebElement Withdraw_Button;
    
    @FindBy(xpath = "//input[@placeholder='amount']")
    public
    WebElement With_Amount;
    
    @FindBy(xpath = "//button[normalize-space()='Withdraw']")
    public
    WebElement AmountWithdraw_Button;
    
    @FindBy(xpath = "//strong[normalize-space()='1016']")
    WebElement AccNumber;

    @FindBy(xpath = "//strong[normalize-space()='0']")
    WebElement AccBalance;
   
   
    public Customer_Withdraw_Page() {
        PageFactory.initElements(driver, this);
    }
    
    
    // Method to withdraw money from the account
    public void Customer_Withdraw(List<String> withdrawals){
        // Wait for the Withdraw Button to be clickable
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(Withdraw_Button)).click();
		System.out.println("User selected Withdraw Button");
	
		for (String withdraw : withdrawals) {
		    // Wait for the Withdraw Amount field to be visible
		    With_Amount.clear();
			With_Amount.sendKeys(withdraw);
			
			// Wait for the Withdraw Button to be clickable
			wait.until(ExpectedConditions.elementToBeClickable(AmountWithdraw_Button)).click();
		    System.out.println("Money Withdrawn from account");
		}
		
		// Wait for the Account Number to be visible
		String S1 = wait.until(ExpectedConditions.visibilityOf(AccNumber)).getText();
		// Wait for the Account Balance to be visible
		String S2 = wait.until(ExpectedConditions.visibilityOf(AccBalance)).getText();
		
		// Assertion for Account Number and Account Balance
		Assert.assertEquals(S1, "1016", "Account Number is incorrect. Actual Account Number : " + S1);
		Assert.assertEquals(S2, "0", "Account Balance is incorrect. Actual Account Balance : " + S2);
    }
}
