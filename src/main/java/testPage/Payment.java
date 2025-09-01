	package testPage;
	
	import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
	
	
		@FindBy(css = ".hero-primary")
		WebElement confirmText;
		@FindBy(xpath = "(//*[@class='line-item product-info-column m-3']/div)[1]")
		WebElement itemName;
		@FindBy(xpath = "(//*[@class='line-item product-info-column m-3']/div)[2]")
		WebElement ItemQty;
		@FindBy(xpath = "(//*[@class='line-item product-info-column']/div)[1]")
		WebElement price;
	
		
	
		public void orderConfirm(String text) {
			waitForElementToDisplay(confirmText);
			if (confirmText.getText().trim().equals(text)) {
				System.out.println("Item Name: "+itemName.getText().trim());
				System.out.println("Item Qty: "+ItemQty.getText().trim());
				System.out.println("Item Price: "+price.getText().trim());
				System.out.println("Order Placed sccessfully");			
			}
	
		}
	
	}
