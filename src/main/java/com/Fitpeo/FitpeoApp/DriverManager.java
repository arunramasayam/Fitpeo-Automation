package com.Fitpeo.FitpeoApp;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverManager {

	 private static WebDriver driver;
	
	
	
	public WebDriver getDriver() {
		 if (driver == null) {
	            driver = initializeDriver();
	        }
		return driver;
	}


	//Initalizing the chrome driver
	@SuppressWarnings("deprecation")
	public WebDriver initializeDriver() {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		//Setting implicit wait time
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.MINUTES);
		return driver;
	}
	
	
	//Closing the driver
	public void quitDriver() {
		if(driver!=null) {
			driver.quit();
		}
	}

}
