package com.Fitpeo.FitpeoApp;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import net.bytebuddy.asm.MemberSubstitution.Current;

public class RevenueCalculator {
	WebDriver driver;
	public RevenueCalculator(WebDriver driver) {
		this.driver=driver;
	}
	
	public void navigateToRevenueCalculator() {
		try {
		WebElement revenueCalculatorPageLinkEle=new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.elementToBeClickable(By.linkText("Revenue Calculator")));
		revenueCalculatorPageLinkEle.click();
		}
		catch(NoSuchElementException e) {
			  System.err.println("Element not found: " + e.getMessage());
			  }
		catch(Exception e) {
			System.err.println("Revenue Calculator page Link not available for navigation.\n"+e.getMessage());
			e.printStackTrace();
		}
		
		
	
	}
	
	public String getUrl() {
		String currentURL=null;
		try {
			currentURL=driver.getCurrentUrl();
		}
		catch(Exception e){
			System.err.println("Error getting current URL\n"+e.getMessage());
		}
		return currentURL;
	}

}
