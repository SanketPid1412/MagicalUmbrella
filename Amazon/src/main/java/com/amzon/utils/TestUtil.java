package com.amzon.utils;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestUtil {
	public boolean waitForElement(WebDriver driver,By ele) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
			wait.until(ExpectedConditions.visibilityOfElementLocated(ele));
			driver.findElement(ele);
		} catch (Exception e) {
			return false;
		}
		return true;
	}
	public boolean clickElement(WebDriver driver,By ele) {
		try {
			driver.findElement(ele).click();
		} catch (Exception e) {
			try {
				WebElement element = driver.findElement(ele);
				JavascriptExecutor executor = (JavascriptExecutor)driver;
				executor.executeScript("arguments[0].click()",element );
			} catch (Exception e2) {
				return false;
			}
		}
		return true;
	}

	public boolean enterText(WebDriver driver,By ele,String input) {
		try {
			driver.findElement(ele).clear();
			driver.findElement(ele).sendKeys(input);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	public void sleep(int millisec) {
		try {
			Thread.sleep(millisec);
		} catch (Exception e) {
		}
	}

	public String getText(WebDriver driver,By ele) {
		String text;
		try {
			text=driver.findElement(ele).getText();
		} catch (Exception e) {
			text=null;
		}
		return text;
	}

	public String timeStamp() {
//		String date = new SimpleDateFormat("yyyy_MM_dd_hh_mm_ss").format(new Date());
//		return date;
		SimpleDateFormat formatter= new SimpleDateFormat("yyyy_MM_dd_hh_mm_ss");
		Date currentDate = new Date();
		String date = formatter.format(currentDate);
		return date;
	}
	
	public boolean scrollDown(WebDriver driver,By ele) {
		for(int i=1;i<=3;i++) {
			try {
				WebElement element = driver.findElement(ele);
				JavascriptExecutor js= ((JavascriptExecutor)driver);
				js.executeScript("arguments[0].scrollIntoViewIfNeeded(true);", element);
				driver.findElement(ele).isDisplayed();
				return true;
			} catch (Exception e) {
				if(i<3) {
					continue;
				}
			}
		}
		return false;
	}
	
}
