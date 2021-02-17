package Ecom.Admin.TestCases;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Ecom.Base.TestBase;
import Ecom.Pages.StorePage;
import Ecom.Pages.AccountPage;
import Ecom.Pages.CartPage;
import Ecom.Pages.CheckOutPage;
import Ecom.Pages.Homepage;
import Ecom.Util.ReadExcel;

public class TestCheckOut extends TestBase{
	AccountPage AccountPg;
	StorePage StorePg;
	CheckOutPage CheckOutPag;
	CartPage CartPag;
	String sheetName = "PlaceOrder";
	public TestCheckOut()
{
	super();
}
	@BeforeClass
	public void Startup()
	{
		setup();
		Homepage HomePag=new Homepage();
		AccountPg=HomePag.ClickAccount();
		AccountPg.Login(pop.getProperty("username"),pop.getProperty("password"));
		StorePg=AccountPg.ClickAccessories();
		StorePg.ClickProduct();
		StorePg.AddToCart();
		CartPag=StorePg.ViewCart();
		CheckOutPag=CartPag.ProceedToChkOut();
	}
	
@DataProvider
public Object[][] GetPaymentData() {
	Object data[][] =ReadExcel.getTestData(sheetName);
	return data;
}
@Test(dataProvider ="GetPaymentData")
public void Payment(String args[]) {
	//Assert.assertTrue(CheckOutPag.VerifyCheckOut());
	CheckOutPag.PaymentDetl(args);
}

}
