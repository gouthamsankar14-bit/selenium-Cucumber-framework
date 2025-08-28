package reuse;

import com.aventstack.extentreports.ExtentTest;

public class ExtentTestManager {
	public static ThreadLocal<ExtentTest> extent = new ThreadLocal<ExtentTest>();

	public static ExtentTest getTest() {
		return extent.get();
	}

	public static void setTest(ExtentTest String) {
		extent.set(String);
	}
}
