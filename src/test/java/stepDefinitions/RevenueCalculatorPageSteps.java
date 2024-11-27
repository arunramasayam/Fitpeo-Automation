package stepDefinitions;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.Fitpeo.FitpeoApp.DriverManager;
import com.Fitpeo.FitpeoApp.RevenueCalculator;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.When;

public class RevenueCalculatorPageSteps {
	RevenueCalculator revenueCalc;
	WebDriver driver;
	DriverManager driverManager;
	
	
	
	@When("user navigate to the 'Revenue Calculator' tab")
	public void goToRevenueCalculatorPage() {
		revenueCalc.navigateToRevenueCalculator();
		String expectedURL="https://www.fitpeo.com/revenue-calculator";
		  WebDriverWait wait=new WebDriverWait(driver, Duration.ofMinutes(1));
		  wait.until(ExpectedConditions.urlMatches(expectedURL));
		  String actualPageURL=revenueCalc.getUrl();
		  Assert.assertEquals(actualPageURL, expectedURL);
	}
	
	 @Before
	  public void setUp() {
		  //initialize driver and page objects
		  driverManager=new DriverManager();
		  driver=driverManager.getDriver();
		  revenueCalc=new RevenueCalculator(driver);
		  }

	  @After
	  public void tearDown() {
		  //cleanup
		  driverManager.quitDriver();
	  }

}
