package testPage;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import reuse.Abstract;
import reuse.Reportlogger;

public class CartToSubmit extends Abstract {

	WebDriver driver;

	public CartToSubmit(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "div[class='cartSection']")
	WebElement cartSection;
	@FindBy(css = "div[class='cartSection'] h3")
	WebElement name;
	@FindBy(css = ".btn-primary")
	List<WebElement> options;
	@FindBy(xpath = "(//input[@class='input txt text-validated'])[2]")
	WebElement country;
	@FindBy(css = ".action__submit")
	WebElement placeOrder;
	@FindBy(xpath = "(//span[@class='ng-star-inserted'])[2]")
	WebElement india;

	public void submit(String itemname, String Buttonname) throws IOException {
		waitForElementToDisplay(cartSection);
		Reportlogger.logScreenShot(driver, "Cart PAge");
		if (name.getText().trim().equalsIgnoreCase((itemname))) {
			for (WebElement button : options) {
				if (button.getText().trim().contains(Buttonname)) {
					button.click();
					break;
				}
			}
		}
	}

	public void sumbitOrder() throws IOException {
		waitForElementToDisplay(country);
		Reportlogger.logScreenShot(driver, "Payment page");
		scrollToElement(country);
		country.sendKeys("India");
		Actions a = new Actions(driver);
		waitForElementToDisplay(india);
		a.sendKeys(Keys.ENTER).perform();
		waitForElementToDisplay(placeOrder);
		scrollToElement(placeOrder);
		placeOrder.click();
		

	}
	@FindBy(css = ".hero-primary")
	WebElement confirmText;
	@FindBy(xpath = "(//*[@class='line-item product-info-column m-3']/div)[1]")
	WebElement itemName;
	@FindBy(xpath = "(//*[@class='line-item product-info-column m-3']/div)[2]")
	WebElement ItemQty;
	@FindBy(xpath = "(//*[@class='line-item product-info-column']/div)[1]")
	WebElement price;

	

	public void orderConfirm(String expectedMsg) {
	    waitForElementToDisplay(confirmText);
	    waitForElementToDisplay(confirmText);
	    String actualMsg = confirmText.getText().trim();
	    if (actualMsg.equalsIgnoreCase(expectedMsg)) {
	        System.out.println("Item Name: " + itemName.getText().trim());
	        System.out.println("Item Qty: " + ItemQty.getText().trim());
	        System.out.println("Item Price: " + price.getText().trim());
	        System.out.println("Order Placed successfully ✅");
	    } else {
	        System.out.println("❌ Order confirmation message mismatch!");
	        System.out.println("Expected: " + expectedMsg);
	        System.out.println("Actual:   " + actualMsg);
	        Assert.fail("Order confirmation message did not match!");
	    }
	}

}
