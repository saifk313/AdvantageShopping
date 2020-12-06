package com.advantage.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.advantage.qa.base.TestBase;

public class ProductPage extends TestBase {
	
	@FindBy(className="plus")
	WebElement buttonIncrement;
	
	@FindBy(name="save_to_cart")
	WebElement buttonAddToCart;
	
	public ProductPage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean checkButtonIncrement() {
		return buttonIncrement.isDisplayed();
	}
	
	public HomePage verifyAddToCart() throws InterruptedException {
		buttonIncrement.click();
		buttonAddToCart.click();
		driver.navigate().to(property.getProperty("url"));
		Thread.sleep(1000);
		return new HomePage();	
	}
}
