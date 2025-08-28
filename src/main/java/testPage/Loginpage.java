package testPage;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import reuse.Abstract;
import reuse.Reportlogger;

public class Loginpage extends Abstract {
	WebDriver driver;

	public Loginpage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "userEmail") WebElement userEmail;
	@FindBy(id = "userPassword") WebElement userPassword;
	@FindBy(id = "login") WebElement login;
	@FindBy(css = "div[class='ng-star-inserted']") WebElement errmsg;
	@FindBy(xpath = "//h3") WebElement logged;

	public void logIn(String userMail, String UserPass) throws IOException {
		scrollToElement(userEmail);
		Reportlogger.logScreenShot(driver, "Before Entering Creads");
		
		waitForElementToDisplay(userEmail);
		userEmail.sendKeys(userMail);
		
		waitForElementToDisplay(userPassword);
		userPassword.sendKeys(UserPass);
		Reportlogger.logScreenShot(driver, "Creads entered");

		waitForElementToDisplay(login).click();

		waitForElementToDisplay(logged);
		if (logged.isDisplayed()) {
			scrollToElement(logged);
			Reportlogger.logScreenShot(driver, "logged in");
			Reportlogger.logPass("login pass");
		}else if (errmsg.isDisplayed()){
			scrollToElement(userEmail);
			Reportlogger.logScreenShot(driver, "login failed");
			Reportlogger.logFail("login failed");
		}
	}
}
