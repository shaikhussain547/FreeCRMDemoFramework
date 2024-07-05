package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class ContactsPageTest extends TestBase{
	
	LoginPage loginPage;
	HomePage homePage;
	ContactsPage contactsPage;
	TestUtil testUtil;
	
	public ContactsPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
		contactsPage = new ContactsPage();
		testUtil = new TestUtil();
		testUtil.delayTwoSec();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		testUtil.delayTwoSec();
		contactsPage = homePage.clickOnWorkItemsLink();
	}
	
	@Test(priority=1)
	public void verifyContactsPageLable() {
		Assert.assertTrue(contactsPage.verifyContactsLable(),"Work item lable is missing on the page");
	}
	
	@Test(priority=2)
	public void printWorkItemsNums() {
		testUtil.delayTwoSec();
		contactsPage.printWorkItems();
	}
	
	@AfterMethod
	public void tearDown() {
		testUtil.delayTwoSec();
		driver.quit();
	}
	

}
