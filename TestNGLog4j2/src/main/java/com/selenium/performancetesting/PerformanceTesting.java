package com.selenium.performancetesting;

import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class PerformanceTesting {
	private WebDriver driver;
	private String baseUrl;
	private static final Logger log = LogManager.getLogger(PerformanceTesting.class.getName());
	long startTime;
	long endTime;
	long duration;
	double seconds;
	@BeforeMethod
	public void setUp() throws Exception {
		driver = new FirefoxDriver();
		baseUrl = "https://www.expedia.com/";
		
		// Maximize the browser's window
		driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test
	public void test() {
		startTime=System.nanoTime();
		driver.get(baseUrl);
		SearchPage.navigateToFlightsTab(driver);
		SearchPage.fillOriginTextBox(driver, "Newark, NJ, United States (EWR-Liberty Intl.)");
		SearchPage.destinationTextBox(driver).sendKeys("Houston");
		SearchPage.departureDateTextBox(driver);
		SearchPage.returnDateTextBox(driver);
		SearchPage.searchButton(driver);
		endTime=System.nanoTime();
		duration=startTime-endTime;
		seconds=(double)duration/1000000000.0;
		
		log.info("#####################################################");
		log.info("Time taken to execute this method: "+ seconds+ "seonds");
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(2000);
		driver.quit();
	}

}

