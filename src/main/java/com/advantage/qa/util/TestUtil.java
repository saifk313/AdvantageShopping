package com.advantage.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.commons.io.FileUtils;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.ui.Select;

import com.advantage.qa.base.TestBase;

public class TestUtil extends TestBase {
	
	public static long PAGE_LOAD = 20;
	public static long IMPLICIT_WAIT = 10;
	static XSSFWorkbook book;
	static XSSFSheet sheet;
	
	public static void selectDropDown(String locator, String value) {
		Select select = new Select(driver.findElement(By.xpath(locator)));
		select.selectByVisibleText(value);
	}
	
	public static Object[][] readDatafromExcel(String sheetName) {
		try {
			File src = new File(property.getProperty("SHEET_PATH"));
			FileInputStream fis = new FileInputStream(src);
			book = new XSSFWorkbook(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		sheet = book.getSheet(sheetName);
		int rowCount = sheet.getLastRowNum();
		int columnCount = sheet.getRow(0).getLastCellNum();
		Object data[][] = new Object[rowCount][columnCount];
		
		for (int row = 0; row < rowCount; row++) {
			for (int column = 0; column < columnCount; column++) {
				data[row][column] = sheet.getRow(row + 1).getCell(column).toString();
			}
		}
		
		return data;
	}
	
	public static void takeScreenshotOnException() throws IOException {
		File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(srcFile, new File("C:\\Users\\saif.k.HQ0\\eclipse-oct\\MavenDemon\\src\\main\\java\\com\\advantage\\screenshot" + "\\screenshots\\" + System.currentTimeMillis() + ".png"));
	}
}