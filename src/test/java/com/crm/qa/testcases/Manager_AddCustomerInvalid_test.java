package com.crm.qa.testcases;

import org.testng.annotations.Test;
import org.openqa.selenium.NoAlertPresentException;
import static org.testng.Assert.assertTrue;
import org.testng.annotations.BeforeMethod;
import com.crm.qa.base.TestBase;
import com.crm.qa.pages.Manager_AddCustomer_Page;

public class Manager_AddCustomerInvalid_test extends TestBase {
    Manager_AddCustomer_Page MangAddCustPage;

    public Manager_AddCustomerInvalid_test() {
        super();
    }

	@BeforeMethod
    public void setUp() {
        initialization();
        MangAddCustPage = new Manager_AddCustomer_Page();
    }

    @Test
    public void verifyAddCustomerFunctionality() {
        // Perform Bank Manager login
        MangAddCustPage.loginAsBankManager();

        // Add a new customer with details from config properties
        MangAddCustPage.addCustomer(prop.getProperty("firstnamein"), prop.getProperty("lastnamein"), prop.getProperty("postcodein"));
        // Assert that an error is displayed
        assertTrue(isAlertPresent(), "Error message is not displayed for invalid data");
    }
    public boolean isAlertPresent() {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }
}