package testng.testsuite;

import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class TestNG_TestCase {
	private WebDriver driver;
	private String baseUrl;
	private static final Logger log = LogManager.getLogger(TestNG_TestCase.class.getName());

	@BeforeClass
	public void setUp() throws Exception {
		driver = new FirefoxDriver();
		baseUrl = "https://www.expedia.com/";
		
		// Maximize the browser's window
		driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test
	public void test1_fillBasicInfo() throws InterruptedException {
		driver.get(baseUrl);
		SearchPage.navigateToFlightsTab(driver);
		SearchPage.fillOriginTextBox(driver, "Newark, NJ, United States (EWR-Liberty Intl.)");
		SearchPage.destinationTextBox(driver).sendKeys("Houston");
		SearchPage.departureDateTextBox(driver);
		SearchPage.returnDateTextBox(driver);
		//SearchPage.searchButton(driver);
	}

	@Test
	public void test2_fillAdvancedInfo() throws InterruptedException {
		/*// Expedia remembers last settings, if you have previously visited the page clicked advanced options
		// Then next time, when automation runs that option will already be open
		// And automation will click it and this time it will close
		// And the test will faill because it will not be able to find not-stop and flight class checkboxes
		// We are adding If condition to find whether the advanced option is open or close
		WebElement advancedOption = driver.findElement(By.id("flight-advanced-options-hp-flight"));
		advancedOption.click();
		log.info("Advanced Options clicked");
		Thread.sleep(2000);
		WebElement nonStopCheckBox=driver.findElement(By.id("advanced-flight-nonstop-hp-flight"));
		nonStopCheckBox.click();
		log.info("NonStopCheck box clicked");
		Thread.sleep(2000);
		WebElement refundableFlight=driver.findElement(By.id("advanced-flight-nonstop-hp-flight"));
		refundableFlight.click();
		log.info("RefundableFlight box clicked");
		Thread.sleep(2000);
		String clicked = e.getAttribute("aria-pressed");
		System.out.println("Value of area-pressed is: " + clicked);
		if (clicked.contains("false")) {
			SearchPage.clickOnAdvancedLink(driver);
		}
		SearchPage.clickNonStopCheckBox(driver);
		SearchPage.selectFlightClass(driver, "first");*/
		WebElement advancedOption = driver.findElement(By.id("flight-advanced-options-hp-flight"));
		advancedOption.click();
		String clicked=advancedOption.getAttribute("aria-expanded");
		if (clicked.contains("false")) {
			advancedOption.click();
			log.info("Advanced Options clicked from inside if");
		}
		else advancedOption.click();
		log.info("Advanced Options clicked");
		Thread.sleep(2000);
		WebElement nonStopCheckBox=driver.findElement(By.id("advanced-flight-nonstop-hp-flight"));
		nonStopCheckBox.click();
		log.info("NonStopCheck box clicked");
		Thread.sleep(2000);
		WebElement refundableFlight=driver.findElement(By.id("advanced-flight-refundable-hp-flight"));
		refundableFlight.click();
		log.info("RefundableFlight box clicked");
		Thread.sleep(2000);
		/*WebElement selectionOption=driver.findElement(By.id("flight-advanced-preferred-airline-hp-flight"));
		selectionOption.click();
		Select selectPreferedFlight= new Select(selectionOption);
		selectPreferedFlight.select("BA");
		Thread.sleep(2000);
		WebElement selectFLightClass=driver.findElement(By.id("'flight-advanced-preferred-class-hp-flight"));
		selectFLightClass.click();
		Select selectPreferedFlightClass=new Select(selectFLightClass);
		selectPreferedFlightClass.selectByValue("first");*/
		Thread.sleep(2000);
		SearchPage.searchButton(driver);
	}

	
	@AfterClass
	public void tearDown() throws Exception {
		/*Thread.sleep(2000);
		driver.quit();*/
	}

}

