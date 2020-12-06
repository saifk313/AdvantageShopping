package com.advantage.qa.testcases;

import com.advantage.qa.base.TestBase;
import com.advantage.qa.pages.CategoryPage;
import com.advantage.qa.pages.HomePage;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import java.io.IOException;
import org.testng.annotations.Test;

public class HomePageTest extends TestBase {
	
	HomePage homepage;
	CategoryPage categoryPage;
	
	public HomePageTest() throws IOException {
		super();
	}
  
  @BeforeMethod
  public void setUp() {
	  initialize();
	  homepage = new HomePage();
  }
  
  @Test
  public void checkLogoTextTest() throws InterruptedException {
		Boolean flag = homepage.checkLogoText();
		Assert.assertTrue(flag);
		Thread.sleep(5000);
	}
  
  @Test
  public void getTitleTest() {
		String title = driver.getTitle();
		Assert.assertEquals(title, " Advantage Shopping");
	}
  
  @Test
  public void checkSpeakersImageTest() throws InterruptedException {
	  Boolean flag = homepage.checkOfferTag();
	  Assert.assertTrue(flag);
  }
  
  @Test
  public void laptopImageClickTest() throws InterruptedException {
	  categoryPage = homepage.laptopImageClick();
	  Thread.sleep(10000);
	  
  }

  @AfterMethod
  public void tearDown() {
	  driver.quit();
  }

}
