package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.Fitpeo.FitpeoApp.DriverManager;
import com.Fitpeo.FitpeoApp.Homepage;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;

public class FitPeoHomepageSteps {
	WebDriver driver;
	DriverManager driverManager;
	Homepage homepage;
	
	
	@Given("user navigates to the Fitpeo home page")
    public void navigateToHomePage() {
		String url = "https://www.fitpeo.com/";
        homepage.openHomepage(url);
        String actualPageTitle=homepage.checkPageTitle();
  	  Assert.assertEquals(actualPageTitle, "Remote Patient Monitoring (RPM) - fitpeo.com");
        
    }

	@Before
	public void setUp() {
	//Initialize driver and page objects
		driverManager=new DriverManager();
		driver =driverManager.getDriver();
		homepage=new Homepage(driver);
		  
	  }
	
	

	  @After	
	  public void tearDown() {
		  driverManager.quitDriver(); //cleanup
	  }
	  

}
