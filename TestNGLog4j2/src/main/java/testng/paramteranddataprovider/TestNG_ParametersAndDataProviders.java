package testng.paramteranddataprovider;



import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

import testng.logging.TestNG_TestCase;

public class TestNG_ParametersAndDataProviders {
	private WebDriver driver;
	private String baseUrl;
	static Logger log = LogManager.getLogger(TestNG_TestCase.class.getName());
	@BeforeClass
	public void beforeClass() {
		driver = new FirefoxDriver();
		baseUrl = "https://www.expedia.com/";

		// Maximize the browser's window
		driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(baseUrl);
		
	}
	

	@DataProvider(name="fieldsInputs")
	public static Object[][] searchData() {
		return new Object[][] {{"New York", "Chicago"},
				{"New York", "Boston"}};
	}
	
	/*@Parameters( { "origin", "dest" } )
	@Test
	public void searchFlights(String origin, String dest) throws Exception {
		SearchPage.navigateToFlightsTab(driver);
		SearchPage.fillOriginTextBox(driver, origin);
		SearchPage.fillDestinationTextBox(driver, dest);
		
		
		SearchPage.fillDepartureDateTextBox(driver);
		
		SearchPage.fillReturnDateTextBox(driver);
		SearchPage.clickOnSearchButton(driver);
	}*/
	
	@Test(dataProvider="fieldsInputs")
	public void searchFlightsWithMultiData(String origin, String dest) throws Exception {
	
		Thread.sleep(3000);
		SearchPage.navigateToFlightsTab(driver);
		SearchPage.clearAllFields(driver);
		SearchPage.fillOriginTextBox(driver, origin);
		SearchPage.fillDestinationTextBox(driver, dest);
		SearchPage.fillDepartureDateTextBox(driver);
		SearchPage.fillReturnDateTextBox(driver);
		SearchPage.clickOnSearchButton(driver);
	}

	@AfterClass
	public void afterClass() {
	}

}
