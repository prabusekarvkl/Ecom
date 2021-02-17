package Ecom.Admin.TestCases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import Ecom.Base.TestBase;
import Ecom.Pages.StorePage;
import Ecom.Pages.AccountPage;
import Ecom.Pages.CartPage;
import Ecom.Pages.Homepage;

public class TestStorePage extends TestBase {
	StorePage StorePg;
	AccountPage AccountPag;
	CartPage CartPag;

	public TestStorePage() {
		super();
	}

	@BeforeClass
	public void Startup() {
		setup();
		Homepage Hpag = new Homepage();
		AccountPag = Hpag.ClickAccount();
		AccountPag.Login(pop.getProperty("username"), pop.getProperty("password"));
		StorePg = AccountPag.ClickAccessories();

	}

	@Test
	public void ShoppingProduct() {
		StorePg.ClickProduct();
		StorePg.AddToCart();
		CartPag = StorePg.ViewCart();
	}
}
