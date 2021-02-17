package Ecom.Pages;

//import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Ecom.Base.TestBase;

public class StorePage extends TestBase {

	@FindBy(css = "ul.products.columns-4 li:nth-of-type(3)")WebElement product;
	@FindBy(css = "button.single_add_to_cart_button.button.alt")WebElement addtocart;
	@FindBy(css = "div.woocommerce-notices-wrapper > div > a")WebElement viewcart;
	
	public StorePage() {
		PageFactory.initElements(driver, this);
	}

	public void ClickProduct() {
		ElementVisible(product);
		product.click();
	}

	public void AddToCart() {
		addtocart.click();
	}

	public CartPage ViewCart() {
		viewcart.click();
		return new CartPage();
	}

}
