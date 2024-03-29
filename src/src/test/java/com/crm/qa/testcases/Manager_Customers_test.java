package com.crm.qa.testcases;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.pages.Manager_AddCustomer_Page;
import com.crm.qa.pages.Manager_Customer_page;
import com.crm.qa.pages.Manager_OpenAccount_page;



public class Manager_Customers_test extends Manager_OpenAccount_page {
	Manager_AddCustomer_Page ManagAddcustPage;
	Manager_OpenAccount_page ManagOpenACpage;
	Manager_Customer_page ManagCustpage;

	public Manager_Customers_test() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		ManagAddcustPage = new Manager_AddCustomer_Page();
		ManagOpenACpage = new Manager_OpenAccount_page();
		ManagCustpage = new Manager_Customer_page();
	}
	@Test
	 public void OpenAccountCustomerTest() {
        // Perform Bank Manager login
		ManagAddcustPage.loginAsBankManager();
        
        // Add a new customer with details from config properties
		ManagAddcustPage.addCustomer(prop.getProperty("firstname"), prop.getProperty("lastname"), prop.getProperty("postcode"));
		System.out.println("Customer Added By Bank manager successfully");
		
		ManagOpenACpage.OpenAccoount_valid();
		System.out.println("Account Opened By Bank manager successfully");
		
		ManagOpenACpage.OpenAccoount_invalid();
		System.out.println("Error - Please select an item in the list");
		
		ManagCustpage.CustomersTabletest();
		System.out.println("Customer Ashwin Deleted from list");
	}}