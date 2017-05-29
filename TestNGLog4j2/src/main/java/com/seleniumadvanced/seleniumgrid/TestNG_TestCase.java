package com.seleniumadvanced.seleniumgrid;

import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class TestNG_TestCase {
	private WebDriver driver;
	private String baseUrl;
	private String nodeURL;

	@BeforeMethod
	public void setUp() throws Exception {
		//System.setProperty("webdriver.chrome.driver", "C:/Users/Rakib/Downloads/chromeDriver/chromedriver.exe");
		
		//java -jar -Dwebdriver.chrome.driver=chromedriver selenium-server-standalone-3.4.0.jar -role bdriver -hub http://192.168.1.12:4444/grid/register -port 5555
		
		//java -jar selenium-server-standalone-3.4.0.jar -role node -nodeConfig gridnode.json // this command run from node

		baseUrl = "https://www.expedia.com/";
		nodeURL = "http://192.168.253.130:5555/wd/hub";
		DesiredCapabilities caps = DesiredCapabilities.firefox();
		caps.setBrowserName("firefox");
		caps.setPlatform(Platform.LINUX);
		driver = new RemoteWebDriver(new URL(nodeURL), caps);
		
		// Maximize the browser's window
		driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(baseUrl);
	}

	@Test
	public void test() {
		
		SearchPage.navigateToFlightsTab(driver);
		SearchPage.fillOriginTextBox(driver, "Newark, NJ, United States (EWR-Liberty Intl.)");
		SearchPage.destinationTextBox(driver).sendKeys("Houston");
		/*SearchPage.departureDateTextBox(driver);
		SearchPage.returnDateTextBox(driver);
		SearchPage.searchButton(driver);*/
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(2000);
		driver.quit();
	}

}

