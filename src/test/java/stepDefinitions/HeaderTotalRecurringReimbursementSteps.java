package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.Fitpeo.FitpeoApp.DriverManager;
import com.Fitpeo.FitpeoApp.TotalRecurringReimbursement;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;

public class HeaderTotalRecurringReimbursementSteps {
	WebDriver driver;
	TotalRecurringReimbursement totalReccurReimb;
	DriverManager driverManager;
	
	
	@And("^user should see the 'Total Recurring Reimbursement for all Patients Per Month' value is (.*) at header$")
	public void validateTotalReccurReimbHeader(String TotalRecurringReimbursement) {

		  //Validate header Total Recurring Reimbursement
		  String totalRecurringReimbHeaderFound=totalReccurReimb.validateHeaderTotalReccuringReimbursment();
		  Assert.assertEquals(totalRecurringReimbHeaderFound.trim(), TotalRecurringReimbursement.trim());
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
