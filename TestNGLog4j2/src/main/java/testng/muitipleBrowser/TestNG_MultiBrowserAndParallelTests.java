package testng.muitipleBrowser;

import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

import testng.testsuite.SearchPage;

public class TestNG_MultiBrowserAndParallelTests {
	private WebDriver driver;
	private String baseUrl;
	static Logger log = LogManager.getLogger(TestNG_MultiBrowserAndParallelTests.class.getName());

	@Parameters("browserType")
	@BeforeClass
	public void beforeClass(String browser) {
		if (browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else if (browser.equalsIgnoreCase("chrome")) {
			// http://chromedriver.storage.googleapis.com/index.html
			//System.setProperty("webdriver.chrome.driver", "/Users/tomara/Desktop/selenium/chromedriver");
			driver = new ChromeDriver();
		}
		
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
		//SearchPage.searchButton(driver);
	}

	@AfterClass
	public void afterClass() throws Exception {
		Thread.sleep(10000);
		driver.quit();
	}

}
