package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.DealsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class DealsPageTest extends TestBase{
	
	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	DealsPage dealsPage;
	
	String sheetName = "Sheet1";
	
	public DealsPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
		testUtil = new TestUtil();
		testUtil.delayTwoSec();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		dealsPage = homePage.clickOnCustomerServiceLink();
		testUtil.delayTwoSec();
	}
	
	@Test(priority=1)
	public void validateCustServiceLableTest() {
		Assert.assertTrue(dealsPage.verifyCustServiceLable(),"Cust service lable not matched");
	}
	
	@DataProvider
	public Object[][] getCRMTestData() {
		Object data[][] = testUtil.getTestData(sheetName);
		return data;
	}
	
	@Test(priority=2, dataProvider="getCRMTestData")
	public void createNewReqstTest(String fname, String fcity, String fstatus) {
//		dealsPage.createNewReqst("John", "Hyd", "New");
		dealsPage.createNewReqst(fname, fcity, fstatus);
	}
	
	@AfterMethod
	public void tearDown() {
		testUtil.delayTwoSec();
		driver.quit();
	}
	
}
