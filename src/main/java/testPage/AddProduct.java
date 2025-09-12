package testPage;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import reuse.Abstract;
import reuse.Reportlogger;

public class AddProduct extends Abstract {
	WebDriver driver;

	public AddProduct(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = ".btn-custom")
	List<WebElement> tab;
	@FindBy(xpath = "//div[@class='card-body']/h5")
	List<WebElement> product;
	@FindBy(css = ".btn.btn-custom")
	List<WebElement> cartButtons;
	@FindBy(id = "toast-container")
	WebElement toastContainer;
	@FindBy(css = ".ngx-spinner-overlay")
	WebElement spinnerOverlay;
	@FindBy(css = ".mt-1 p")
	WebElement page;

	public void itemTocart(String itemname) throws InterruptedException, IOException {
		waitForAllElementToDisplay(product);
		for (WebElement item : product) {
			if (item.getText().trim().contains(itemname)) {
				Reportlogger.logScreenShot(driver, "Item displayed");
				driver.findElement(By.cssSelector(".w-10")).click();
				break;

			}
		}
		scrollToElement(page);
		waitForElementToDisplay(toastContainer);
		waitForElementToDisapper(spinnerOverlay);
		for (WebElement btn : cartButtons) {
			if (btn.getText().trim().contains("Cart")) {
				scrollToElement(btn);
				
				waitForElementToClicable(btn);
				btn.click();
				break;
			}
		}

	}

}
