package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase{
	
	@FindBy(xpath = "//h1//strong")
//	@CacheLookup
	WebElement userNameLabel;
	
	@FindBy(xpath = "//*[text()=' Work Items']")
	WebElement workItemsLink;
	
	@FindBy(xpath = "//*[text()=' Customer Service']")
	WebElement customerServiceLink;
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public String verifyHomePageTitle() {
		return driver.getTitle();
	}
	
	public boolean verifyCorrectUserName() {
		return userNameLabel.isDisplayed();
	}
	
	public ContactsPage clickOnWorkItemsLink() {
		workItemsLink.click();
		return new ContactsPage();
	}
	
	public DealsPage clickOnCustomerServiceLink() {
		customerServiceLink.click();
		return new DealsPage();
	}
	
	
	
	
	
	
	
	
	
}
