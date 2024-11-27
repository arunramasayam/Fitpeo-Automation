package com.Fitpeo.FitpeoApp;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UpdateTextField {
	WebDriver driver;
	
	public UpdateTextField(WebDriver driver) {
		this.driver=driver;
	}
	
	
	//
	public String updatePatientsField(String eligiblePatients) {
		WebElement patientsTextFieldEle=null;
		String updatedPatientFieldVal=null;
		
		try{
			patientsTextFieldEle=new WebDriverWait(driver, Duration.ofSeconds(20)).
					until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='number']")));
			
			//Move & Click on Patients text field
			new Actions(driver).moveToElement(patientsTextFieldEle).click().perform();
			
			//Entering New Eligible patients value
			((JavascriptExecutor)driver).executeScript("arguments[0].value = '';", patientsTextFieldEle);
			
			new Actions(driver).moveToElement(patientsTextFieldEle).sendKeys(eligiblePatients).perform();
			
			
			//get Updated value in the text field
			new WebDriverWait(driver, Duration.ofSeconds(10))
		    .until(ExpectedConditions.attributeToBe(patientsTextFieldEle, "value", eligiblePatients));
			updatedPatientFieldVal=patientsTextFieldEle.getAttribute("value");
			
		}
		catch(NoSuchElementException e) {
			System.err.println("Element not found: " + e.getMessage());
		}
		catch(Exception e) {
			System.err.println("Error updating Eligible patients Number in the text field.\n"+e.getMessage());
			e.printStackTrace();
		}
		
		
	
		return updatedPatientFieldVal;
		
		
	}
	
	
	//Validate Slider Value post updation of patients field value
	public int sliderValueCheck() {
		WebElement sliderInp=null;
		int currentVal= 0;
		
		try {
			sliderInp = driver.findElement(By.xpath("//span/input[@type='range']"));
		    currentVal=Integer.parseInt(sliderInp.getAttribute("value"));
		}
		catch(NoSuchElementException e) {
			System.err.println("Element not found: " + e.getMessage());
		}
		catch(Exception e) {
			System.err.println("Error fetching Slider value after upading."+e.getMessage());
			e.printStackTrace();
		}
		return currentVal;
		
	}
}
