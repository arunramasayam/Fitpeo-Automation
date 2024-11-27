package com.Fitpeo.FitpeoApp;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EligiblePatientsSlider {
	WebDriver driver;
	public EligiblePatientsSlider(WebDriver driver) {
		this.driver=driver;
	}
	
	
	//Move to the slider section
	public void scrollToSliderSection()  {
		WebElement sliderSectionEle=null;
		try{
			sliderSectionEle=new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@class, 'MuiSlider-rail')]")));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(false);", sliderSectionEle);			
		}
		catch(Exception webEleException) {
			System.out.println("Slider Element not found for scrolling");
				webEleException.printStackTrace();		
		}
		
	}
	
	
	
	//Adjust the Slider value for eligible patients
	public int AdjustSlider(int sliderValue) {
		int currentSliderVal=0;
		WebElement sliderEle=null;
		
		try {
			
		WebElement sliderRailEle=new WebDriverWait(driver, Duration.ofSeconds(20)).
				until(ExpectedConditions.visibilityOfElementLocated(
						By.xpath("//*[contains(@class, 'MuiSlider-rail')]")));
		int sliderWidth =sliderRailEle.getSize().width;
		sliderEle=new WebDriverWait(driver, Duration.ofSeconds(20)).
				until(ExpectedConditions.visibilityOfElementLocated(
						By.xpath("//span/input[@type='range']")));
		int sliderMaxRange=Integer.parseInt(sliderEle.getAttribute("max"));
		currentSliderVal=currentSliderVal();
		int xOffset = ((sliderWidth) * (sliderValue-currentSliderVal)) / sliderMaxRange;
		
		Actions a=new Actions(driver); a.dragAndDropBy(sliderEle, xOffset,0).release(sliderEle).perform();
		
		}

		catch(Exception e) {
			System.err.println("Error whiling adjusting slider value.\n"+e.getMessage());
			e.printStackTrace();
		}
			
	     currentSliderVal=currentSliderVal();
		
		//to adjust slider val
		
		  if(currentSliderVal<sliderValue) {
			  sendKeysRight(sliderEle, currentSliderVal,sliderValue);
			  } 
		  if(currentSliderVal>sliderValue) { 
			  sendKeysLeft(sliderEle,currentSliderVal, sliderValue); 
			  }
		  //Returning current slider value
		  return currentSliderVal=currentSliderVal();
			
		}
		

	
	// Get Patients number from text field
	public int getTextFieldVal()  {
		int noOfPatients=0;
		try {
		WebElement textFieldEle=new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='number']")));
		new Actions(driver).moveToElement(textFieldEle).build().perform();
		noOfPatients=Integer.parseInt(textFieldEle.getAttribute("value"));
		}
		catch(Exception e) {
			System.err.println("Errror getting eligible patients text field  value\n"+e.getMessage());
			e.printStackTrace();
		}
		
		
		return noOfPatients;
		
	}
	
	
	// to get current slider value
	public int currentSliderVal() {
		
		int currentSliderVal=0;
		try {
			WebElement trackSliderEle=new WebDriverWait(driver,Duration.ofSeconds(20)).
					until(ExpectedConditions.visibilityOfElementLocated(
							By.xpath("//span/input[@type='range']")));
			
			currentSliderVal=Integer.parseInt(trackSliderEle.getAttribute("value"));
			
		}
		catch(Exception e) {
			System.err.println("Error finding current slider value."+e.getMessage());
			e.printStackTrace();
			
		}
		/*
		 * String getTrackWidth=sliderEle.getCssValue("width"); float
		 * trackWidth=Float.parseFloat(getTrackWidth.replace("px", "")); int
		 * currentSliderVal=(int) ((trackWidth*sliderMaxVal)/sliderWidth);
		 */
		return currentSliderVal;
		
	}
	
	
	
	
	//Sending right keys on slider to adjust the value
	public void sendKeysRight(WebElement sliderEle, int currentSliderVal, int sliderValue) {
		try {
			for(int  i=currentSliderVal; i<sliderValue; i++){
			sliderEle.sendKeys(Keys.ARROW_RIGHT);
			Thread.sleep(1000);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		}
		
	
	//Sending left keys on slider to adjust the value
		public void sendKeysLeft(WebElement sliderEle, int currentSliderVal, int sliderValue) {
			try {
			for(int  i=currentSliderVal; i>sliderValue; i--){
				sliderEle.sendKeys(Keys.ARROW_LEFT);
				Thread.sleep(1000);
			}
			}
			catch(Exception e) {
				e.printStackTrace();
			}

}
}
