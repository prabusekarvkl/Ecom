package Ecom.Base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestBase {
	public static WebDriver driver;
	public static Properties pop;

	public TestBase() {
		pop = new Properties();
		try {
			FileInputStream conf = new FileInputStream(
					System.getProperty("user.dir")+"./src/main/java/Ecom/config/config.properties");
			pop.load(conf);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void setup() {
		String BrowserName = pop.getProperty("browser");
		if (BrowserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver.exe");
			driver = new ChromeDriver();
		} else if (BrowserName.equals("chr")) {
			System.setProperty("webdriver.chrome.driver", "./src/test/resources/geckodriver.exe");
			driver = new ChromeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(150, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(150, TimeUnit.SECONDS);
		driver.get(pop.getProperty("url"));
	}
	public void ElementVisible(WebElement el)
	{
		WebDriverWait wait = new WebDriverWait(driver,150);
		wait.until(ExpectedConditions.visibilityOf(el));
	}
	public void ElementClickable(WebElement el)
	{
		WebDriverWait wait = new WebDriverWait(driver,150);
		wait.until(ExpectedConditions.elementToBeClickable(el));
	}
}
