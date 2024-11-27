package com.Fitpeo.FitpeoApp;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TotalRecurringReimbursement {
	WebDriver driver;

	public TotalRecurringReimbursement(WebDriver driver) {
		this.driver = driver;
	}

	// Validate Total Recurring in Revenue Calculator page body level
	public String validateTotalReccuringReimbursmentBodyLevel() {
		String totalRecurReimbFoundBody=null;
		try {
			WebElement totalRecurringReimbursement = new WebDriverWait(driver,Duration.ofSeconds(20)).
					until(ExpectedConditions.visibilityOfElementLocated(
							By.xpath("//p[text()='Total Recurring Reimbursement for all Patients Per Month' and"
							+ " contains(@class,'MuiTypography-root')]")));
			
			//scrolling to Total Recurring Reimbursement section body level
			((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(false);",totalRecurringReimbursement); 
			
			 totalRecurReimbFoundBody = totalRecurringReimbursement.findElement(By.xpath("following-sibling::p")).getText();
		}  
		catch(NoSuchElementException e) {
			System.err.println("Element not found: " + e.getMessage());
		}
		catch (Exception e) {
			System.out.println("Total Recurring Reimbursement element at body  level not found."+e.getMessage());
			e.printStackTrace();
		}
	
		return totalRecurReimbFoundBody;
	}

	// Validate header Total Recurring in Revenue Calculator page
	public String validateHeaderTotalReccuringReimbursment() {

	    String totalRecurReimbFoundHeader=null;
		WebElement totalRecurrReimbHeaderEle = null;
		try {
			//scrolling to bottom so header section appears
			((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight);");
			totalRecurrReimbHeaderEle = new WebDriverWait(driver, Duration.ofSeconds(20))
		            .until(ExpectedConditions.presenceOfElementLocated(
		                    By.xpath("//p[text()='Total Recurring Reimbursement for all Patients Per Month:'"
		                    		+ " and contains(@class,'MuiTypography-root')]/p")));
			
			totalRecurReimbFoundHeader = totalRecurrReimbHeaderEle.getText();
			
		} 
		catch(NoSuchElementException e) {
			System.err.println("Element not found: " + e.getMessage());
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println("Total Recurring Reimbursement element at header  level not found."+e.getMessage());
			e.printStackTrace();
		}

		return totalRecurReimbFoundHeader;
	}

}
