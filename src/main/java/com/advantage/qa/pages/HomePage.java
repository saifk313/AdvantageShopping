package com.advantage.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.advantage.qa.base.TestBase;

public class HomePage extends TestBase {
	
	@FindBy(xpath="//h3[contains(text(), 'SPECIAL OFFER')]")
	WebElement offerTag;
	
	@FindBy(xpath="//span[contains(text(),'dvantage')]")
	WebElement logoText;
	
	@FindBy(id="laptopsImg")
	WebElement laptopImage;
	
	@FindBy(id="tabletsImg")
	WebElement tabletImage;
	
	@FindBy(id="menuCart")
	WebElement menuCart;
	
	@FindBy(id="checkOutPopUp")
	WebElement checkOutPopUp;
	
//	@FindBy(id="details-button")
//	WebElement btnDetails;
//	
//	@FindBy(id="proceed-link")
//	WebElement linkProceed;
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean checkLogoText() {
		return logoText.isDisplayed();
	}
	
	public boolean checkOfferTag() {
		return offerTag.isDisplayed();
	}
	
	public String getTitle() {
		return driver.getTitle();
	}
	
	public CategoryPage laptopImageClick() {
//		btnDetails.click();
//		linkProceed.click();
		laptopImage.click();
		return new CategoryPage();
	}
	
	public CategoryPage tabletImageClick() {
		tabletImage.click();
		return new CategoryPage();
	}
	
	public OrderPaymentPage clickCheckOutPopUp() throws InterruptedException {
		Actions action = new Actions(driver);
		action.moveToElement(menuCart).build().perform();
		checkOutPopUp.click();
		Thread.sleep(2000);
		return new OrderPaymentPage();
	}
}