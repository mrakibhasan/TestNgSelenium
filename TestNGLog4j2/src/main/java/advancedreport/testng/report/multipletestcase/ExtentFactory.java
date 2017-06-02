package advancedreport.testng.report.multipletestcase;

import com.relevantcodes.extentreports.ExtentReports;

public class ExtentFactory {
	public static ExtentReports getInstance() {
		ExtentReports extent;
		String Path = "D://Eclipse works Spaces//report-demo.html";
		extent = new ExtentReports(Path, false);
		extent
	     .addSystemInfo("Selenium Version", "3.40")
	     .addSystemInfo("Platform", "Windows");

		return extent;
	}
}