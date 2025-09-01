package stepDefenition;

import java.io.IOException;

import basePack.DriverSetUp;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import testPage.AddProduct;
import testPage.CartToSubmit;
import testPage.Loginpage;
import testPage.Payment;

public class StepImplementation extends DriverSetUp {
	Payment pay;

	@Given("Go to ecommers site")
	public void go_to_ecommers_site() {
		// Browser already launched by Hooks
	}

	@Given("login using {string} and {string}")
	public void login_using_username_and_password(String username, String password) throws IOException {
		Loginpage login = new Loginpage(getdriver());
		login.logIn(username, password);
		System.out.println("Login successful ✅");
	}

	@When("add product {string} to card")
	public void add_product_to_card(String product) throws InterruptedException {
		AddProduct add = new AddProduct(getdriver());
		add.itemTocart(product);
		System.out.println("Product added ✅");
	}

	@And("checkout {string} and submit order")
	public void checkout_and_submit_order(String itemname) {
		CartToSubmit cart = new CartToSubmit(getdriver());
		cart.submit(itemname, "Checkout");
		pay = cart.sumbitOrder();
		System.out.println("Checkout completed ✅");
	}

	@Then("Verify {string} is displayed after placing the order")
	public void placeOrder(String expectedMsg) {
	    pay.orderConfirm(expectedMsg);
	}



}
