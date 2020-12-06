package com.advantage.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.advantage.qa.base.TestBase;

public class CategoryPage extends TestBase {
	
	@FindBy(name="buy_now") WebElement buttonBuyNow;
	@FindBy(id="accordionPrice") WebElement priceDropDown;
	@FindBy(xpath="//div[@class=\"noUi-origin noUi-connect\"]") WebElement priceSlider;
	@FindBy(id="accordionColor") WebElement colorDropDown;
	@FindBy(id="productsColors414141") WebElement colorBlack;
	@FindBy(id="8") WebElement laptop8;
	@FindBy(id="17") WebElement tablet17;
	
	public CategoryPage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean checkButtonBuyNow() {
		return buttonBuyNow.isDisplayed(); 
	}
	
	public void filterProducts() {
		priceDropDown.click();
		priceSlider.click();
		colorDropDown.click();
		colorBlack.click();	
	}
	
	public ProductPage clickLaptop8() throws InterruptedException {
		filterProducts();
		laptop8.click();
		Thread.sleep(2000);
		return new ProductPage();
	}
	
	public ProductPage clickTablet17() throws InterruptedException {
		tablet17.click();
		Thread.sleep(2000);
		return new ProductPage();
	}
}
