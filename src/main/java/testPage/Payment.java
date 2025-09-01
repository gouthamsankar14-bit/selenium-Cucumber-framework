	package testPage;
	
	import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import reuse.Abstract;
	
	public class Payment extends Abstract {
		WebDriver driver;
	
		public Payment(WebDriver driver) {
			super(driver);
			this.driver = driver;
			PageFactory.initElements(driver, this);
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
