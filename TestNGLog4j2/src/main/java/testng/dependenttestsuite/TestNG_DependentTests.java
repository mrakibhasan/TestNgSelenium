package testng.dependenttestsuite;

import java.util.concurrent.TimeUnit;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;



public class TestNG_DependentTests {
	private WebDriver driver;
	private String baseUrl;
	static Logger log = LogManager.getLogger(TestNG_DependentTests.class.getName());
	@BeforeClass
	public void beforeClass() {
		driver = new FirefoxDriver();
		baseUrl = "https://www.expedia.com/";

		// Maximize the browser's window
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(baseUrl);
	}

	@Test
	public void searchFlights() throws Exception {
		driver.get(baseUrl);
		SearchPage.navigateToFlightsTab(driver);
		SearchPage.fillOriginTextBox(driver, "Newark, NJ, United States (EWR-Liberty Intl.)");
		SearchPage.destinationTextBox(driver).sendKeys("Houston");
		SearchPage.departureDateTextBox(driver);
	
		SearchPage.returnDateTextBox(driver);
		SearchPage.searchButton(driver);
	}

	@Test(dependsOnMethods={ "searchFlights" })
	public void selectMorningFlight() {
		SearchPage.clickMorningFlight(driver);
	}

	@AfterClass
	public void afterClass() {
	}
}
