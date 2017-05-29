package com.seleniumadvanced.seleniumgrid;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;

public class SeleniumGrid {
	private WebDriver driver;
	private String baseUrl;
	private String nodeURL;
  @BeforeMethod
  public void beforeMethod() throws MalformedURLException {

		baseUrl = "https://www.expedia.com/";
		nodeURL = "http://192.168.253.130:5555/wd/hub";
		DesiredCapabilities caps = DesiredCapabilities.firefox();
		caps.setBrowserName("firefox");
		caps.setPlatform(Platform.LINUX);
		driver = new RemoteWebDriver(new URL(nodeURL), caps);
		
		// Maximize the browser's window
		driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
  }
  @Test
  public void f() {
	  driver.get(baseUrl);
  }
  @AfterMethod
  public void afterMethod() {
  }

}
