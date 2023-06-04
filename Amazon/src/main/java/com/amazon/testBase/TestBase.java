package com.amazon.testBase;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import com.amazon.testdata.TestData;
import com.amzon.utils.TestInterface;


public class TestBase implements TestInterface{
	protected static WebDriver driver = null;
	public static String userName;
	public static String password;
	Properties pro;
	public TestBase() {
		try {
			pro = new Properties();
			FileInputStream ip = new FileInputStream("C:\\Wishup_WorkSpace_!\\Amazon\\src\\main\\java\\com\\amazon\\testdata\\Config.properties");
			pro.load(ip);
			userName = pro.getProperty("userName");
			password = pro.getProperty("password");	
		} catch (Exception e) {
			
		}
	}
	@BeforeMethod
	public void testSetup() throws InterruptedException {
		driver= openBrowser("Chrome");
		openApplication(TestData.url, driver);
	}
	
	public WebDriver openBrowser(String BrowserName) {
		if(BrowserName.equals("Chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\SimplilearnSpace\\chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			options.addArguments("incognito");
			//options.addArguments("headless");
			options.addArguments("--disable-popup-blocking");
			options.addArguments("start-maximized");
			options.addArguments("--remote-allow-origins=*");
			options.addArguments("test-type");
			options.addArguments("start-maximized");
			options.addArguments("--window-size=1920,1080");
			options.addArguments("--enable-precise-memory-info");
			options.addArguments("--disable-popup-blocking");
			options.addArguments("--disable-default-apps");
			options.addArguments("test-type=browser");
			options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"}); 
			driver = new ChromeDriver(options);
		}else if(BrowserName.equals("Edge")) {
			System.setProperty("webdriver.edge.driver", "C:\\SimplilearnSpace\\chromedriver.exe");
			driver = new FirefoxDriver();
		}else if(BrowserName.equals("Firefox")) {
			System.setProperty("webdriver.chrome.driver", "C:\\SimplilearnSpace\\chromedriver.exe");
			driver = new EdgeDriver();
		}
		
		//driver.manage().window().maximize();
		return driver;
	}
	public void openApplication(String url,WebDriver driver) {
		driver.get(url);
	}
	public void closeBrowser(WebDriver driver) {
		driver.quit();
	}
	@AfterMethod
	public void tearDown() {
		testUtil.sleep(3000);
		closeBrowser(driver);
	} 
	public static boolean takeSnap(String testCaseID) {
		File tempScreenShot= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		File desiredLocation = new File("C:\\Wishup_WorkSpace_!\\Amazon\\Scrrenshots\\"+testCaseID+".png");
		try {
			FileHandler.copy(tempScreenShot, desiredLocation);
		} catch (Exception e) {
			return false;
		}
		return true;
	}
	
	
}
