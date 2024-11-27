package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.Fitpeo.FitpeoApp.DriverManager;
import com.Fitpeo.FitpeoApp.EligiblePatientsSlider;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class EligiblePatientsSliderSteps {
	WebDriver driver;
	DriverManager driverManager;
	EligiblePatientsSlider slider;
	
	 @Before
	  public void setUp() {
		  //initialize driver and page objects
		  driverManager=new DriverManager();
		  driver=driverManager.getDriver();
		  slider=new EligiblePatientsSlider(driver);
	 }

	 
	 @Then("^user adjust the eligible patients slider to (.*)$")
	 public void adjustEligiblePatientsSliderValue(int slidervalue) {
		//Move to patients slider section
		  slider.scrollToSliderSection();
		  
		  //Ajust the patients  Slider value to 820, max value 2000
		  //Set slider value
		  int adjustedSliderVal=slider.AdjustSlider(slidervalue);

		  Assert.assertEquals(adjustedSliderVal, slidervalue);//Checking slider Value
		 
	 }
	 
	 @And("^the eligible patients text field value is updated to (.*)$")
	 public void validatePatientsTextFldSliderUpdate(int slidervalue) {
		 //Validate txt field after updating slider value
		 int patientsTextFieldVal=slider.getTextFieldVal();
		  Assert.assertEquals(patientsTextFieldVal, slidervalue);
	 }
	 
	  @After
	  public void tearDown() {
		  //cleanup
		  driverManager.quitDriver();
	  }

}
