package basePack;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import reuse.ExtentTestManager;

public class DriverSetUp {
	public static Properties prop;
	public static ExtentReports extent;
	String filePath = "C:\\Users\\kgouthamsankar\\eclipse-workspace\\cucmber_login\\src\\main\\resources\\gobal.property";
	public static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();

	public static WebDriver getdriver() {
		return driver.get();
	}

	public void htmlreport(String scenarioName) {
	    extent = ExtendReport.getInstnce(scenarioName);   // pass scenario name
	    ExtentTest test = extent.createTest("Test - " + scenarioName);
	    ExtentTestManager.setTest(test);
	}


	public void setUp() throws IOException {
		FileInputStream file = new FileInputStream(filePath);
		prop = new Properties();
		prop.load(file);
		String browserName = prop.getProperty("browser").toLowerCase();

		switch (browserName) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver.set(new ChromeDriver());
			break;
		default:
			throw new IllegalArgumentException("browser not supported " + browserName);
		}
		getdriver().manage().window().maximize();
		String url = prop.getProperty("url").toLowerCase();
		getdriver().get(url);

	}

	public void tearDown() {
		if (driver != null) {
			getdriver().quit();
			driver.remove();
		}
	}

	public void flushReport() {
		if (extent != null) {
			extent.flush();
		}
	}
}
