package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.Fitpeo.FitpeoApp.DriverManager;
import com.Fitpeo.FitpeoApp.UpdateTextField;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class UpdateEligiblePatientsTxtSteps {
	DriverManager driverManager;
	WebDriver driver;
	UpdateTextField updateTxtField;
	
	@Then("^user enters (.*) in the eligible patients text field$")
	  public void updatePatientTxtFieldTest(String  patientsTextFieldValue) { 
		  //Click on Patients text field and update value and check updated value
		  String updatedFieldValue=updateTxtField.updatePatientsField(patientsTextFieldValue);
		  Assert.assertEquals(updatedFieldValue,  patientsTextFieldValue);	  
		    }
	
	@And("^user should see the eligible patients slider value updated to (.*)$")
	public void validateSliderValPostTxtUpdate(String patientsTextFieldValue) {
		//Check slider Value after updating patients field
		  int currentSliderVal=updateTxtField.sliderValueCheck();
		  Assert.assertEquals(currentSliderVal,Integer.parseInt(patientsTextFieldValue));
	}
	
	@Before
	  public void setUp() {
		  //initialize driver and page objects
		  driverManager=new DriverManager();
		  driver=driverManager.getDriver();
		  updateTxtField=new UpdateTextField(driver);
	 }

	  @After
	  public void tearDown() {
		  //cleanup
		  driverManager.quitDriver();
	  }

}
