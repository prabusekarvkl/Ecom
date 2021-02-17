package Ecom.Pages;

//import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Ecom.Base.TestBase;

public class Homepage extends TestBase {
	@FindBy(css="ul#primary-menu li:nth-of-type(6)")WebElement Account;
	
	public Homepage()
	{
		PageFactory.initElements(driver, this);
	}
	public AccountPage ClickAccount()
	{
		Account.click();
		return new AccountPage();
	}
	
}
