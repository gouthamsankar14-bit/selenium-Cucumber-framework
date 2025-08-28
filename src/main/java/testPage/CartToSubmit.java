package testPage;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import reuse.Abstract;

public class CartToSubmit extends Abstract  {
	
	WebDriver driver;

	public CartToSubmit(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css = "div[class='cartSection']") WebElement cartSection;
	@FindBy(css = "div[class='cartSection'] h3") WebElement name;
	@FindBy(css = ".btn-primary") List<WebElement> options;
	@FindBy(xpath = "(//input[@class='input txt text-validated'])[2]")
	WebElement country;
	@FindBy(css = ".action__submit")
	WebElement placeOrder;
	@FindBy(xpath = "(//span[@class='ng-star-inserted'])[2]")
	WebElement india;
	
	public void submit(String itemname,String Buttonname ) {
		waitForElementToDisplay(cartSection);
		if(name.getText().trim().equalsIgnoreCase((itemname))){
			for(WebElement button:options ) {
				if(button.getText().trim().contains(Buttonname)) {
					button.click();
					break;
				}
			}
		}
	}
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
