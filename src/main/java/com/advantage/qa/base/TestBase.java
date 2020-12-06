package com.advantage.qa.base;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.advantage.qa.util.TestUtil;
import com.advantage.qa.util.WebEventListener;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties property;
	public static EventFiringWebDriver firingDriver;
	public static WebEventListener eventListener;
	
	public TestBase() {
		try {
			property = new Properties();
			FileInputStream fis = new FileInputStream("C:\\Users\\saif.k.HQ0\\eclipse-oct\\MavenDemon\\src\\main\\java\\com\\advantage\\qa\\config\\config.properties");
			property.load(fis);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void initialize() {
		String browserName = property.getProperty("browser");
		if(browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\jars and drivers\\drivers\\chrome\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		
		firingDriver = new EventFiringWebDriver(driver);
		eventListener = new WebEventListener();
		firingDriver.register(eventListener);
		
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		
		driver.get(property.getProperty("url"));
	}
}