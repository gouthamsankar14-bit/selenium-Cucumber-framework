package reuse;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.Status;

public class Reportlogger extends Abstract {

	public Reportlogger(WebDriver driver) {
		super(driver);

	}

	public static void logInfo(String message) {
		
			ExtentTestManager.getTest().log(Status.INFO, message);
		
	}

	public static void logPass(String message) {
		ExtentTestManager.getTest().log(Status.PASS, message);
	}

	public static void logFail(String message) {
		ExtentTestManager.getTest().log(Status.FAIL, message);

	}

	public static String logScreenShot(WebDriver driver, String fileName) throws IOException {
		String screenshotPath = takeScreenshot(driver, fileName);
		ExtentTestManager.getTest().addScreenCaptureFromPath(screenshotPath, "Screenshot - " + fileName);
		return screenshotPath;
	}
}
