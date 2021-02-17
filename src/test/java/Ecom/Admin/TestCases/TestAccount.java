package Ecom.Admin.TestCases;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import Ecom.Base.TestBase;
import Ecom.Pages.StorePage;
import Ecom.Pages.AccountPage;
import Ecom.Pages.Homepage;


public class TestAccount extends TestBase{
	
	AccountPage AccountPag;
	StorePage StorePg;
public TestAccount()
{
	super();
}
@BeforeClass
public void startup()
{
	setup();
	Homepage HomePag=new Homepage();
	AccountPag=HomePag.ClickAccount();
	AccountPag.Login(pop.getProperty("username"),pop.getProperty("password"));
}
@Test(priority=1)
public void ClickOrder()
{
	AccountPag.clickorderr();
	Assert.assertTrue(AccountPag.VerifyOrders());
}
@Test(priority=2)
public void ClickAccessories()
{
	StorePg=AccountPag.ClickAccessories();
}
}
