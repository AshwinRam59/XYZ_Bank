package com.crm.qa.testcases;

import java.util.Arrays;
import java.util.List;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.pages.Customer_Login_Page;
import com.crm.qa.pages.Customer_Withdraw_Page;
import com.crm.qa.pages.Manager_AddCustomer_Page;
import com.crm.qa.pages.Manager_Customer_page;
import com.crm.qa.pages.Manager_OpenAccount_page;


public class Customer_Withdarw_test extends Manager_OpenAccount_page {
	Manager_AddCustomer_Page Manag_AddcustPage;
	Manager_OpenAccount_page Manag_OpenACpage;
	Manager_Customer_page ManagCustpage;
	Customer_Login_Page CustDepoPage;
	Customer_Withdraw_Page CustWithPage;
	

	public Customer_Withdarw_test() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		Manag_AddcustPage = new Manager_AddCustomer_Page();
		Manag_OpenACpage = new Manager_OpenAccount_page();
		ManagCustpage = new Manager_Customer_page();
		CustDepoPage = new Customer_Login_Page();
		CustWithPage= new Customer_Withdraw_Page();
		
		}
	@Test
	 public void DepositCustomerTest() throws InterruptedException {
        // Perform Bank Manager login
		Manag_AddcustPage.loginAsBankManager();
        
        // Add a new customer with details from config properties
		Manag_AddcustPage.addCustomer(prop.getProperty("firstname"), prop.getProperty("lastname"), prop.getProperty("postcode"));
		System.out.println("Customer Added By Bank manager successfully");
		
		Manag_OpenACpage.OpenAccoount_valid();
		System.out.println("Account Opened By Bank manager successfully");
		
		Manag_OpenACpage.OpenAccoount_invalid();
		System.out.println("Error - Please select an item in the list");
		
		ManagCustpage.CustomersTabletest();
		System.out.println("Customer Ashwin Deleted from list");
		
		List<String> deposits = Arrays.asList(prop.getProperty("deposits").split(","));
		CustDepoPage.Customer_Deposit(deposits);
		System.out.println("Amount Deposit to customer account");
		
		List<String> withdrawals = Arrays.asList(prop.getProperty("withdrawals").split(","));
		CustWithPage.Customer_Withdraw(withdrawals);
		System.out.println("Amount Withdraw from customer account");
	}}