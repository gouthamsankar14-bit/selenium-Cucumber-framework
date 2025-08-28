package basePack;

import java.io.File;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtendReport {
	private static ExtentReports extent;

	public static ExtentReports getInstnce(String classname) {

		if (extent == null) {
			String dirpath = "C:\\Users\\kgouthamsankar\\git colne_pull\\selenium-framework-login\\reports";
			String file = dirpath + File.separator + classname + ".html";

			ExtentSparkReporter report = new ExtentSparkReporter(file);

			report.config().setDocumentTitle("Login Page Test");
			report.config().setReportName("Test - " + classname);

			extent = new ExtentReports();
			
			extent.attachReporter(report);
			extent.setSystemInfo("Tester: ", "Goutham");
		}
		return extent;
	}

}
