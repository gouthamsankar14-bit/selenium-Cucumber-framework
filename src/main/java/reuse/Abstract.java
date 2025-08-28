package reuse;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Abstract {
	WebDriver driver;

	public Abstract(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}


	public Boolean waitForElementToDisapper(WebElement findby) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		return wait.until(ExpectedConditions.invisibilityOf(findby));
	}
	public WebElement waitForElementToDisplay(WebElement findby) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		return wait.until(ExpectedConditions.visibilityOf(findby));
	}
	public WebElement waitForElementToClicable(WebElement findby) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		return wait.until(ExpectedConditions.elementToBeClickable(findby));
	}
	public void waitForAllElementToDisplay(List<WebElement> findby) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		 wait.until(ExpectedConditions.visibilityOfAllElements(findby));
	}

	public void scrollToElement(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)", element);
	}

	public static String takeScreenshot(WebDriver driver, String fileName) throws IOException {

		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String dir = "C:\\Users\\kgouthamsankar\\git colne_pull\\selenium-framework-login\\reports\\screenshots";
		String time = new java.text.SimpleDateFormat("yyyyMMdd_HHmmss").format(new java.util.Date());
		String path = dir + File.separator + fileName + "_" + time + ".png";
		FileUtils.copyFile(src, new File(path));
		return path;
	}

	

	

}
