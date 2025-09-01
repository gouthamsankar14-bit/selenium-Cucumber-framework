package basePack;

import java.io.File;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtendReport {
	private static ExtentReports extent;

	public static ExtentReports getInstnce(String scenarioName) {

		if (extent == null) {
	        String safeName = scenarioName.replaceAll("[^a-zA-Z0-9]", "_");
	        String dirpath = "C:\\Users\\kgouthamsankar\\git colne_pull\\selenium-framework-login\\reports";
	        String file = dirpath + File.separator + safeName + ".html";

	        ExtentSparkReporter report = new ExtentSparkReporter(file);
	        report.config().setDocumentTitle("Ecommerce Test Report");
	        report.config().setReportName("Scenario - " + scenarioName);

	        extent = new ExtentReports();
	        extent.attachReporter(report);
	        extent.setSystemInfo("Tester", "Goutham");
	    }
	    return extent;
	}

}
