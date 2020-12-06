package com.advantage.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.advantage.qa.base.TestBase;
import com.advantage.qa.util.TestUtil;

public class OrderPaymentPage extends TestBase {
	
	@FindBy(name="usernameInOrderPayment")
	WebElement username;
	
	@FindBy(name="passwordInOrderPayment")
	WebElement password;
	
	@FindBy(id="login_btnundefined")
	WebElement loginButton;
	
	@FindBy(id="next_btn")
	WebElement nextButton;
	
	@FindBy(name="masterCredit")
	WebElement masterCredit;
	
	@FindBy(id="creditCard")
	WebElement credit_no;
	
	@FindBy(name="cvv_number")
	WebElement cvv_no;
	
	@FindBy(name="cardholder_name")
	WebElement card_holder_name;
	
	@FindBy(id="pay_now_btn_ManualPayment")
	WebElement paymentButton;
	
	public OrderPaymentPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void checkLogin(String uname, String pass) {
		username.sendKeys(uname);
		password.sendKeys(pass);
		loginButton.click();
		nextButton.click();
		masterCredit.click();
	}
	
	public void paymentDetails(String cardNo, String cvvNo, String mnth, String yr, String holder_name) {
		credit_no.sendKeys(cardNo);
		cvv_no.sendKeys(cvvNo);
		TestUtil.selectDropDown("//*[@name='mmListbox']", "11");
		TestUtil.selectDropDown("//*[@name='yyyyListbox']", "2023");
		card_holder_name.sendKeys(holder_name);
	}
	
	public boolean checkPaymentButton() {
		return paymentButton.isDisplayed();
	}
}
