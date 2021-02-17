package Ecom.Admin.TestCases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Ecom.Base.TestBase;
import Ecom.Pages.StorePage;
import Ecom.Pages.AccountPage;
import Ecom.Pages.CartPage;
import Ecom.Pages.CheckOutPage;
import Ecom.Pages.Homepage;

public class TestCart extends TestBase{
	AccountPage AccountPg;
	StorePage StorePg;
	CheckOutPage CheckOutPg;
	CartPage CartPg;
public TestCart()
{
	super();
}
@BeforeClass
public void Startup()
{
	setup();
	Homepage Hpag=new Homepage();
	AccountPg=Hpag.ClickAccount();
	AccountPg.Login(pop.getProperty("username"),pop.getProperty("password"));
	StorePg=AccountPg.ClickAccessories();
}
@Test(priority=1)
public void ShoppingProduct()
{
	StorePg.ClickProduct();
	StorePg.AddToCart();
	CartPg=StorePg.ViewCart();
}
@Test(priority=2)
public void ClickCheckOut()
{
	CheckOutPg=CartPg.ProceedToChkOut();
}
}
