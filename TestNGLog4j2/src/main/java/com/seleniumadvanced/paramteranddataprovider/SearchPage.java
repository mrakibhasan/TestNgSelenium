package com.seleniumadvanced.paramteranddataprovider;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;

import com.seleniumadvanced.TestNG_TestCase;
import com.seleniumadvanced.dependenttestsuite.WaitTypes;

public class SearchPage {
	public static WebElement element = null;
	static Logger log = LogManager.getLogger(TestNG_TestCase.class.getName());
	
	public static void clearAllFields(WebDriver driver) {
		driver.findElement(By.id("flight-origin-hp-flight")).clear();
		driver.findElement(By.id("flight-destination-hp-flight")).clear();
	}
	
	public static void navigateToFlightsTab(WebDriver driver) {
		driver.findElement(By.id("header-account-menu")).click();
		element = driver.findElement(By.id("tab-flight-tab-hp"));
		element.click();
		log.info("Navigate to flights tab");
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
	
	
	public static void fillDestinationTextBox(WebDriver driver, String dest) {
		element = destinationTextBox(driver);
		element.sendKeys(dest);
		log.info("Enter destination city as " + dest);
	}

	
	public static WebElement departureDateTextBox(WebDriver driver) {
		element = driver.findElement(By.id("flight-departing-hp-flight"));
		return element;
	}
	

	public static void fillDepartureDateTextBox(WebDriver driver) {
		element = departureDateTextBox(driver);
		element.click();
		WebElement deptrDate=driver.findElement(By.xpath("//button[@data-day='28']"));
		deptrDate.click();
		log.info("Enter departure date as " + deptrDate);
	}

	
	public static WebElement returnDateTextBox(WebDriver driver) {
		element = driver.findElement(By.id("flight-returning-hp-flight"));
		return element;
	}
	
	
	public static void fillReturnDateTextBox(WebDriver driver) {
		element = returnDateTextBox(driver);
		element.click();
		WebElement returntrDate=driver.findElement(By.xpath("//div[@id='flight-returning-wrapper-hp-flight']/div/div/div[3]/table/tbody/tr[1]/td[5]//button"));
		returntrDate.click();
		log.info("Enter return date as " + returntrDate);
	}


	public static WebElement searchButton(WebDriver driver) {
		element = driver.findElement(By.xpath("//div[@class='cols-nested']//label[@class='col search-btn-col']"));
		return element;
	}

	public static void clickOnSearchButton(WebDriver driver) {
		element = searchButton(driver);
		element.click();
	}
	
	public static void clickOnAdvancedLink(WebDriver driver) {
		element = driver.findElement(By.id("advanced-options"));
		element.click();
		log.info("Clicked on Advanced Options link");
	}
	
	public static void clickNonStopCheckBox(WebDriver driver) {
		element = driver.findElement(By.id("advanced-flight-nonstop"));
		element.click();
		log.info("Clicked non-stop check box");
	}
	
	public static void selectFlightClass(WebDriver driver, String flightClass) {
		Select options = new Select(driver.findElement(By.id("flight-advanced-preferred-class")));
		options.selectByValue(flightClass);
		log.info("Select flight class as " + flightClass);
	}
	
	public static void clickMorningFlight(WebDriver driver) {
		WebElement element = WaitTypes.getWhenVisible(driver, 
				By.xpath("//ul[@id='departureTimeList']//span[contains(text(), 'Morning')]//preceding-sibling::input"), 30);
		element.click();
		log.info("Clicked on Morning Time to filter the results");
	}
	
}
