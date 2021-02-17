package Ecom.Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Ecom.Base.TestBase;

public class AccountPage extends TestBase{
@FindBy(css="ul#primary-menu li:nth-of-type(6)")WebElement Account;
@FindBy(css="input.woocommerce-Input.woocommerce-Input--text.input-text")WebElement Username;
@FindBy(css="input#password")WebElement Password;	
@FindBy(css="button.woocommerce-button.button.woocommerce-form-login__submit")WebElement Login;
@FindBy(css="nav.woocommerce-MyAccount-navigation>ul li:nth-of-type(4)")WebElement scroll;
@FindBy(css="nav.woocommerce-MyAccount-navigation>ul li:nth-of-type(2)")WebElement Orders;
@FindBy(css="div.woocommerce-MyAccount-content>div>a")WebElement verifyorders;
@FindBy(css="ul#primary-menu li:nth-of-type(5)")WebElement Accessories;
public AccountPage()
{
	PageFactory.initElements(driver, this);
}
public void Login(String username,String password)
{
	Username.sendKeys(username);
	Password.sendKeys(password);
	Login.click();
}
public void clickorderr()
{
	JavascriptExecutor js=(JavascriptExecutor)driver;
	js.executeScript("arguments[0].scrollIntoView(true)", scroll);
	ElementVisible(Orders);
	Orders.click();
}
public boolean VerifyOrders()
{
	return verifyorders.isDisplayed();
	 
}
public StorePage ClickAccessories()
{
//	JavascriptExecutor js=(JavascriptExecutor)driver;
//	js.executeScript("arguments[0].scrollIntoView(true)", Accessories);
	Accessories.click();
	return new StorePage();
}
}
