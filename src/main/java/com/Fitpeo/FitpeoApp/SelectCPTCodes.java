package com.Fitpeo.FitpeoApp;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SelectCPTCodes {
	
	WebDriver driver;
	public SelectCPTCodes(WebDriver driver) {
		this.driver=driver;
		
	}
	
	//Select CPT Code by names matches within the list
	public boolean selectCPTCodesByName(List<String> cptCdNames) {
		
		int cptCodeCount=0;
		try {
			WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
			List<WebElement> cptCdClsEles=wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(
				By.xpath("//div[contains(@class,'MuiBox-root css-1eynrej')]")));
			List<WebElement> checkboxes = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(
				By.xpath("//input[contains(@class,'PrivateSwitchBase-input') and @type='checkbox']")));
		
		for(String cptName: cptCdNames) {
			boolean cptCodeFound=false;
		
		int cptCdClsElesSize=cptCdClsEles.size();
		
		for(int i=0; i<cptCdClsElesSize; i++) {
			String cptCdFound=cptCdClsEles.get(i).findElement(By.tagName("p")).getText();
			
			if(cptCdFound.equals(cptName)) {
				cptCodeCount++;
				cptCodeFound=true;
				checkboxes.get(i).click();
			}
		}
		
		if(!cptCodeFound) 
			System.err.println("Cpt code:"+cptName+" not found");
	
		}
		}
		catch (TimeoutException e) {
		    System.err.println("Timeout while waiting for elements: " + e.getMessage());
		} 
		catch (NoSuchElementException e) {
		    System.err.println("Element not found: " + e.getMessage());
		}
		catch(Exception e) {
			System.err.println("Error while selecting CPT codes\n"+e.getMessage());
			e.printStackTrace();
		}
	
	 return (cptCdNames.size()==cptCodeCount);
	 
}
	
	
	
	//Validate Selected Cpt codes matches the cptcodes list
	public boolean validateCptCdSelected(List<String> cptCdNames) {
		int cptCdSelectCount=0;
		try {
		WebElement selectedCptCdHeadingEle=driver.findElement(By.xpath("//div/p[contains(text(),'Selected CPT Codes')]"));
		Actions a=new Actions(driver);
		a.moveToElement(selectedCptCdHeadingEle).build().perform();
		List<WebElement> selectedCPTCdEles=selectedCptCdHeadingEle.findElements(By.xpath("//div[contains(@class,'MuiButtonBase-root') and @role='button']/span"));
		
		boolean cptCdSelectionFound;
		cptCdSelectCount=0;
		
		for(String cptCd: cptCdNames) {
			cptCdSelectionFound=false;
			
			for(int i=0; i<selectedCPTCdEles.size(); i++) {
				String cptCdTextFound=selectedCPTCdEles.get(i).getText();
				if(cptCdTextFound.equalsIgnoreCase(cptCd.replace("-", ""))) {
					cptCdSelectionFound=true;
					cptCdSelectCount++;
				}
					
				
			}
			if(!cptCdSelectionFound) {
				System.out.println("CPT code:"+cptCd+" is not found in the 'Selected CPT Codes' list");
			}
		}
		}
		catch (TimeoutException e) {
		    System.err.println("Timeout while waiting for elements: " + e.getMessage());
		} 
		catch(NoSuchElementException e) {
			System.err.println("Element not found: " + e.getMessage());
		}
		catch(Exception e) {
			System.err.println("Error validating Selected CPT Codes."+e.getMessage());
			e.printStackTrace();
		}
		return cptCdNames.size()==cptCdSelectCount;
		
	}
	
}
