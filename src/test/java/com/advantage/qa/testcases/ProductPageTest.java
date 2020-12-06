package com.advantage.qa.testcases;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.advantage.qa.ExtentReports.ExtentReportListener;
import com.advantage.qa.base.TestBase;
import com.advantage.qa.pages.CategoryPage;
import com.advantage.qa.pages.HomePage;
import com.advantage.qa.pages.OrderPaymentPage;
import com.advantage.qa.pages.ProductPage;
import com.advantage.qa.util.TestUtil;

public class ProductPageTest extends TestBase {

	HomePage homePage;
	CategoryPage categoryPage;
	ProductPage productPage;
	OrderPaymentPage orderPaymentPage;
	String sheetLoginName = "login";
	String sheetCardName = "card_info";
	ExtentReportListener reportListener;
	Logger log = Logger.getLogger(ProductPageTest.class);

	public ProductPageTest() {
		super();
	}

	@BeforeTest
	public void setup() throws InterruptedException {
		initialize();
		log.info("*************** Launching Chrome ********************");
		reportListener = new ExtentReportListener();
		reportListener.setReport();
		homePage = new HomePage();
		categoryPage = homePage.laptopImageClick();
		productPage = categoryPage.clickLaptop8();
		orderPaymentPage = new OrderPaymentPage();
	}

	@DataProvider
	public Object[][] getLoginData() {
		Object[][] data = TestUtil.readDatafromExcel(sheetLoginName);
		return data;
	}

	@Test(priority = 1, dataProvider = "getLoginData")
	public void verifyAddToCartTest(String fname, String lname) throws InterruptedException {

		log.info("*************** verifyAddToCartTest ********************");
		reportListener.generateReport("verifyAddToCartTest");
		homePage = productPage.verifyAddToCart();
		categoryPage = homePage.tabletImageClick();
		productPage = categoryPage.clickTablet17();
		homePage = productPage.verifyAddToCart();
		orderPaymentPage = homePage.clickCheckOutPopUp();
		orderPaymentPage.checkLogin(fname, lname);
		Thread.sleep(3000);
	}

	@DataProvider
	public Object[][] getCardData() {
		Object[][] data = TestUtil.readDatafromExcel(sheetCardName);
		return data;
	}

	@Test(priority = 2, dataProvider = "getCardData")
	public void validatePaymentDetails(String cardNo, String cvv, String month, String year, String name) {
		log.info("*************** validatePaymentDetails ********************");
		reportListener.generateReport("validatePaymentDetails");
		orderPaymentPage.paymentDetails(cardNo, cvv, month, year, name);
	}

	@Test(priority = 3)
	public void checkPaymentButtonTest() {
		log.info("*************** checkPaymentButtonTest ********************");
		reportListener.generateReport("checkPaymentButtonTest");
		Assert.assertTrue(orderPaymentPage.checkPaymentButton());
	}

	@AfterMethod
	public void displayStatus(ITestResult result) throws IOException {
		reportListener.displayStatus(result);
	}

	@AfterTest
	public void tearDown() {
		reportListener.endReport();
		log.info("*************** Closing Browser ********************");
		driver.quit();
	}
}