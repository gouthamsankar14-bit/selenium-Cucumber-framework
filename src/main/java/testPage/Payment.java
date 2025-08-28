package testPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import reuse.Abstract;

public class Payment extends Abstract {
	WebDriver driver;

	public Payment(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "(//input[@class='input txt text-validated'])[2]")
	WebElement country;
	@FindBy(xpath = ".action__submit")
	WebElement placeOrder;
	@FindBy(xpath = "(//span[@class='ng-star-inserted'])[2]")
	WebElement india;
	

	public void sumbitOrder() {
		waitForElementToDisplay(country);
		scrollToElement(country);
		country.sendKeys("india");
		Actions a = new Actions(driver);
		waitForElementToDisplay(india);
		a.scrollToElement(india).click().build().perform();
		waitForElementToDisplay(placeOrder);
		scrollToElement(placeOrder);
		placeOrder.click();

	}

}
