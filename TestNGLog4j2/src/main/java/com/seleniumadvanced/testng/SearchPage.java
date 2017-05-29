package com.seleniumadvanced.testng;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;

//import com.seleniumadvanced.testng.TestNG_TestCase;

public class SearchPage {
	public static WebElement element = null;
	private static final Logger log = LogManager.getLogger(TestNG_TestCase.class.getName());
	
	public static void navigateToFlightsTab(WebDriver driver) {
		driver.findElement(By.id("header-account-menu")).click();
		element = driver.findElement(By.id("tab-flight-tab-hp"));
		element.click();
		log.info("Navigate to flights tab");
		Reporter.log("Navigate to flights tab");
	}
	
	public static WebElement originTextBox(WebDriver driver) {
		element = driver.findElement(By.id("flight-origin-hp-flight"));
		log.info("Origin text box element found");
		return element;
		
	}
	
	public static void fillOriginTextBox(WebDriver driver, String origin) {
		element = originTextBox(driver);
		element.sendKeys(origin);
		log.info("Enter origin city as " + origin);
	}

	public static WebElement destinationTextBox(WebDriver driver) {
		element = driver.findElement(By.id("flight-destination-hp-flight"));
		log.info("Destination text box element found");
		return element;
		
	}
	
	public static void departureDateTextBox(WebDriver driver) {
		 driver.findElement(By.id("flight-departing-hp-flight")).click();
		 driver.findElement(By.xpath("//div[@class='datepicker-cal-month']//table//tbody//tr[4]//td[5]//button[contains(text(),25)]")).click();
		 log.info("Departure box found ");
	}
	
	public static void returnDateTextBox(WebDriver driver) {
		driver.findElement(By.id("flight-returning-hp-flight")).click();
		driver.findElement(By.xpath("//div[@id='flight-returning-wrapper-hp-flight']/div/div/div[3]/table/tbody/tr[1]/td[5]/button[contains(text(),1)]")).click();
		log.info("Return box found ");
	}
	public static void searchButton(WebDriver driver) {
		 driver.findElement(By.xpath("//div[@class='cols-nested']//label[@class='col search-btn-col']")).click();
		 log.info("clicked the search button");
		
	}

	
	
	
}
