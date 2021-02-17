package Ecom.Pages;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import Ecom.Base.TestBase;

public class CheckOutPage extends TestBase{
	JavascriptExecutor js=(JavascriptExecutor)driver;
	@FindBy(css="div.elementor-widget-container > h1.elementor-heading-title.elementor-size-default")WebElement verifycheckout;
	@FindBy(css="div.ast-site-identity")WebElement verifylogo;
	//@FindBy(css="div.woocommerce-billing-fields__field-wrapper p:nth-of-type(1)")WebElement firstname;
	@FindBy(css="input#billing_first_name")WebElement firstname;
	@FindBy(css="input#billing_last_name")WebElement lastname;
	@FindBy(css="span#select2-billing_country-container")WebElement country;
	@FindBy(css="input#billing_address_1")WebElement address;
	@FindBy(css="input#billing_city")WebElement city;
	@FindBy(css="input#billing_postcode")WebElement postcode;
	@FindBy(css="input#billing_phone")WebElement phone;
	@FindBy(css="input#billing_email")WebElement email;
	@FindBy(css="button#place_order")WebElement placeorder;
	@FindBy(css="#billing_address_2")WebElement ScrollByAddress;
	@FindBy(css="#order_comments")WebElement ScrollbyComments;
	@FindBy(css="input#billing_state")WebElement ScrollbyCountry;
	@FindBy(css="#payment > div > div > div > p")WebElement verifyplace;

	public CheckOutPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public boolean VerifyLogo()
	{
		ElementVisible(verifylogo);
		return verifylogo.isDisplayed();
	}
	public boolean VerifyCheckOut()
	{
		ElementVisible(verifycheckout);
		return verifycheckout.isDisplayed();
	}
	
	  public void PaymentDetl(String data[]) 
	  {
	  firstname.sendKeys(data[0]);
	  lastname.sendKeys(data[1]);
	  js.executeScript("arguments[0].scrollIntoView(true)", ScrollByAddress);
	  country.sendKeys(data[2]);
	  address.sendKeys(data[3]);
	  city.sendKeys(data[4]);
	  postcode.sendKeys(data[5]);
	  js.executeScript("arguments[0].scrollIntoView(true)", ScrollbyComments);
	  phone.sendKeys(data[6]);
	  email.clear(); 
	  email.sendKeys(data[7]);
	  js.executeScript("arguments[0].scrollIntoView(true)", ScrollbyCountry);
	  ElementVisible(placeorder);
	  placeorder.click(); 
	  }

//public void PaymentDetails() {
//		firstname.sendKeys("viki");
//		lastname.sendKeys("Prabhu");
//		js.executeScript("arguments[0].scrollIntoView(true)", scrollby);
//   // country.sendKeys(data[2]);
//	address.sendKeys("ada");
//	city.sendKeys("swdw");
//	postcode.sendKeys("5");
//	js.executeScript("arguments[0].scrollIntoView(true)", scrollby1);
//	phone.sendKeys("dwd");
//	email.sendKeys("dqwd");
//	placeorder.click();}
//}
}
