package com.craftsvilla.testscripts;

import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.craftsvilla.generic.BasePage;
import com.craftsvilla.pompages.HomePage;
import com.craftsvilla.pompages.SareeProductPage;
import com.craftsvilla.pompages.SareesPage;


public class SareeScripts extends BasePage
{


	public SareeScripts(WebDriver driver) {
		
		super(driver);
		
	}

	
	HomePage homepage = null;
	SareeProductPage sppage = null;
	SareesPage sareepage = null;
	
	@Test
	public void TC_01_ChooseSaree()
	{
		homepage = new HomePage(driver);
		sppage = new SareeProductPage(driver);
		sareepage = new SareesPage(driver);
		
		try
		{
			homepage.clickOnCartLink();
			sppage.sareeProductPage();
			
			
		}
		catch(Exception e)
		{
			Reporter.log("TC failed"+e );
			//report
		}
		
	}
	
}
