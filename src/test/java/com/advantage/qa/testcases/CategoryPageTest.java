package com.advantage.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.advantage.qa.base.TestBase;
import com.advantage.qa.pages.CategoryPage;
import com.advantage.qa.pages.HomePage;
import com.advantage.qa.pages.ProductPage;

public class CategoryPageTest extends TestBase {
	
	HomePage homePage;
	CategoryPage categoryPage;
	ProductPage productPage;
	
	public CategoryPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialize();
		homePage = new HomePage();
		categoryPage = homePage.laptopImageClick();
	}
	
	@Test(priority=1)
	public void checkButtonBuyNowTest() {
		boolean flag = categoryPage.checkButtonBuyNow();
		Assert.assertTrue(flag);
	}
	
	@Test(priority=2)
	public void clickLaptop8Test() throws InterruptedException {
		productPage = categoryPage.clickLaptop8();
		
	}
	
	@Test(priority=2)
	public void clickTablet17Test() throws InterruptedException {
		productPage = categoryPage.clickTablet17();
		
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
