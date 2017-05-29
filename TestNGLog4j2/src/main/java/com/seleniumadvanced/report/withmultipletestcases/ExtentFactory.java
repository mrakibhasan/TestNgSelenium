package com.seleniumadvanced.report.withmultipletestcases;

import com.relevantcodes.extentreports.ExtentReports;

public class ExtentFactory {
	public static ExtentReports getInstance() {
		ExtentReports extent;
		String Path = "D://Eclipse works Spaces//report-demo.html";
		extent = new ExtentReports(Path, false);
		extent
	     .addSystemInfo("Selenium Version", "2.52")
	     .addSystemInfo("Platform", "Mac");

		return extent;
	}
}