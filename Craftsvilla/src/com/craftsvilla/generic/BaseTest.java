package com.craftsvilla.generic;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class BaseTest implements AutoConst{
	
	public static WebDriver driver=null;
	public WebDriverWait wait  = null;
	@Parameters("browser")
	@BeforeMethod
	public void openApplication(String browser){
		if(browser.equalsIgnoreCase("CHROME")) {
			System.setProperty(CHROME_KEY, CHROME_VALUE);
			driver = new ChromeDriver();
			
		}
		else if(browser.equalsIgnoreCase("FIREFOX")) {
			System.setProperty(GECKO_KEY, GECKO_VALUE);
			driver= new FirefoxDriver();
			
		} else
		{
			Reporter.log("invalid browser");
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		wait = new WebDriverWait(driver, 10);
		driver.get(APP_URL);
		
	}
	public void closeApplication() {
		
		driver.quit();
	}
	

}
