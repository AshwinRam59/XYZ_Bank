package com.crm.qa.pages;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.testng.Assert;

public class Manager_OpenAccount_page extends Manager_AddCustomer_Page {
    
    @FindBy(xpath = "//button[@ng-click ='openAccount()']")
    WebElement OpenAccount_Button;

    @FindBy(id = "userSelect")
    WebElement NameList;

    @FindBy(xpath = "//option[text() = 'Ashwin Ramteke']")
    WebElement NameSelection;
    
    @FindBy(xpath = "//select[@ng-model = 'currency']")
    WebElement CurrencyList;

    @FindBy(xpath = "//option[text() = 'Rupee']")
    WebElement CurrencySelection;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement Process_Button;

    @FindBy(xpath = "//select[@ng-model = 'custId']")
    WebElement Field_Validatation;

    public Manager_OpenAccount_page() {
        PageFactory.initElements(driver, this);
    }

    // Method to open a valid account
    public void OpenAccoount_valid() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Click on the Open Account button
        wait.until(ExpectedConditions.visibilityOf(OpenAccount_Button)).click();
        System.out.println("User clicked on Open Account");

        // Click on the Name dropdown
        wait.until(ExpectedConditions.visibilityOf(NameList)).click();
        System.out.println("User clicked on Name Dropdown");

        // Select the name 'Ashwin Ramteke'
        wait.until(ExpectedConditions.visibilityOf(NameSelection)).click();
        System.out.println("User selected name Ashwin Ramteke");

        // Click on the Currency dropdown
        wait.until(ExpectedConditions.visibilityOf(CurrencyList)).click();
        System.out.println("User clicked on Currency Dropdown");

        // Select the currency 'Rupee'
        wait.until(ExpectedConditions.visibilityOf(CurrencySelection)).click();
        System.out.println("User selected currency Rupee");

        // Click on the Process button
        wait.until(ExpectedConditions.visibilityOf(Process_Button)).click();
        System.out.println("Account Opened for Ashwin Ramteke");

        // Accept the alert
        org.openqa.selenium.Alert alert1 = driver.switchTo().alert();
        alert1.accept();
    }

    // Method to open an invalid account
    public void OpenAccoount_invalid() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Click on the Name dropdown
        wait.until(ExpectedConditions.visibilityOf(NameList)).click();
        System.out.println("User clicked on Name Dropdown");

        // Click on the Currency dropdown
        wait.until(ExpectedConditions.visibilityOf(CurrencyList)).click();
        System.out.println("User clicked on Currency Dropdown");

        // Click on the Process button
        wait.until(ExpectedConditions.visibilityOf(Process_Button)).click();
        System.out.println("Account Opened for Ashwin Ramteke");

        // Validate the field
        Assert.assertTrue(wait.until(ExpectedConditions.visibilityOf(Field_Validatation)).isDisplayed());
        System.out.println("Error will come as Please select item in list");
    }
}
