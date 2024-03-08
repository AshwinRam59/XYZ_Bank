package com.crm.qa.testcases;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.crm.qa.base.TestBase;
import com.crm.qa.pages.Manager_AddCustomer_Page;

public class Manager_AddCustomer_test extends TestBase {
    Manager_AddCustomer_Page MangAddCustPage;

    public Manager_AddCustomer_test() {
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
        MangAddCustPage.addCustomer(prop.getProperty("firstname"), prop.getProperty("lastname"), prop.getProperty("postcode"));
    }
}
