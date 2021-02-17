package Ecom.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Ecom.Base.TestBase;

public class CartPage extends TestBase{
	@FindBy(css="div.wc-proceed-to-checkout > a")WebElement proceedtocheckout;

	public CartPage() 
	{
		PageFactory.initElements(driver, this);
	}

	public CheckOutPage ProceedToChkOut() {
		proceedtocheckout.click();
		return new CheckOutPage();
	}
}
