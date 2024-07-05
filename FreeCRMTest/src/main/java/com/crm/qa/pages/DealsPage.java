package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;
import com.crm.qa.util.TestUtil;

public class DealsPage extends TestBase{
	
	TestUtil testUtil = new TestUtil();
	
	@FindBy(xpath = "//h1[contains(text(),'Customer Service')]")
	WebElement customerServiceLable;
	
	@FindBy(xpath = "//input[@id='callername']")
	WebElement name;
	
	@FindBy(xpath = "//input[@id='callercity']")
	WebElement city;
	
	@FindBy(xpath = "//input[@id='callerstatus']")
	WebElement status;
	
	@FindBy(xpath = "//input[@id='newsletter']")
	WebElement monthlyNewsLetter;
	
	@FindBy(xpath = "//input[@id='rewards']")
	WebElement rewards;
	
	//Initializing the Page Objects:
	public DealsPage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyCustServiceLable() {
		return customerServiceLable.isDisplayed();
	}
	
	public void createNewReqst(String fname, String fcity, String fstatus) {
		name.sendKeys(fname);
		testUtil.delayTwoSec();
		city.sendKeys(fcity);
		testUtil.delayTwoSec();
		status.sendKeys(fstatus);
		testUtil.delayTwoSec();
		monthlyNewsLetter.click();
		testUtil.delayTwoSec();
		rewards.click();
		testUtil.delayTwoSec();
	}
	
}
