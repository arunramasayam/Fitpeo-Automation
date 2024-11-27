package stepDefinitions;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.Fitpeo.FitpeoApp.DriverManager;
import com.Fitpeo.FitpeoApp.SelectCPTCodes;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Then;

public class SelectCPTCodesSteps {
	WebDriver driver;
	SelectCPTCodes selectCPTcd;
	DriverManager driverManager;
	
	
	@Then("^user selects checkboxes based on the following CPT codes:$")
		public void selectCPTCodes(DataTable datatable) {
			  List<String> cptCodes=datatable.asList();
			  //validate CPT Codes are there for selection and selecting them
			  boolean cptCdaluesFound=selectCPTcd.selectCPTCodesByName(cptCodes);
			  Assert.assertTrue(cptCdaluesFound, "Some of the Cpt codes are not found from the given list");
			  
			  //validate selected CPT codes are found in the 'Selected CPT Codes' 
			  boolean cptCdSelectionFound=selectCPTcd.validateCptCdSelected(cptCodes);
			  Assert.assertTrue(cptCdSelectionFound, "Cpt code values are missing from the 'Select CPT Codes'");
			  
		}
	
	

	  @Before
	  public void setUp() {
		  //initialize driver and page objects
		  driverManager=new DriverManager();
		  driver=driverManager.getDriver();
		  selectCPTcd=new SelectCPTCodes(driver);
	 }

	  @After
	  public void tearDown() {
		  //cleanup
		  driverManager.quitDriver();
	  }

}
