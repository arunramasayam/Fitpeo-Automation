package com.Fitpeo.FitpeoApp;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;

public class Homepage {
	WebDriver driver;
	
	//constructor
	public Homepage(WebDriver driver) {
		this.driver=driver;
		
	}
	
	public void openHomepage(String url) {
		try {
		driver.get(url);
		driver.manage().window().maximize();
		}
		catch(WebDriverException e) {
			System.err.println("WebDriver Excepiton:"+e.getMessage());
			e.printStackTrace();
		}
		catch(Exception e) {
			System.err.println("Error opening homepage. "+e.getMessage());
		}
	}		
	
	public String checkPageTitle() {
		String actualPageTitle=null;
		try {
		 actualPageTitle=driver.getTitle();
		}
		catch(Exception e) {
			System.err.println("Error while getting page Title. "+e.getMessage());
		}
		return actualPageTitle;
		
	}
	
	
}
