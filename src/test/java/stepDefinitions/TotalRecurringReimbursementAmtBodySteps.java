package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.Fitpeo.FitpeoApp.DriverManager;
import com.Fitpeo.FitpeoApp.TotalRecurringReimbursement;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Then;

public class TotalRecurringReimbursementAmtBodySteps {
	WebDriver driver;
	TotalRecurringReimbursement totalReccurReimb;
	DriverManager driverManager;
	
	
	@Then("^user should see the 'Total Recurring Reimbursement for all Patients Per Month' value is (.*) at body level$")
	public void validateTotalReccurReimbBody(String TotalRecurringReimbursement) {
		//Validate Total Recurring Reimbursement at body level
		  String totalRecurringReimbBodyFound=totalReccurReimb.validateTotalReccuringReimbursmentBodyLevel();
		  Assert.assertEquals(totalRecurringReimbBodyFound, TotalRecurringReimbursement);
		  
	}
	
	 @Before
	  public void setUp() {
		  //initialize driver and page objects
		  driverManager=new DriverManager();
		  driver=driverManager.getDriver();
		  totalReccurReimb=new TotalRecurringReimbursement(driver);
	 }

	  @After
	  public void tearDown() {
		  //cleanup
		  driverManager.quitDriver();
	  }

}
