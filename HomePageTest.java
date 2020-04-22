package myStore.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import MyStorePageObject.HomePage;

public class HomePageTest {

	WebDriver driver;
	HomePage home;
	WebDriverWait wait;

	@BeforeClass
	public void startDriver() {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	@Test(priority = 1)
	public void clickWomenSubmenuTest() {
		driver.get(HomePage.HOME_URL);
		home = new HomePage();
		home.clickWomenSubmenu(driver);

		String actualUrl = driver.getCurrentUrl();
		String expectedUrl = "http://automationpractice.com/index.php?id_category=11&controller=category";

		Assert.assertEquals(actualUrl, expectedUrl);
	}

	@Test(priority = 2)
	public void clickDressesSubmenuTest() {
		home.clickDressesSubmenu(driver);

		String actualUrl = driver.getCurrentUrl();
		String expectedUrl = "http://automationpractice.com/index.php?id_category=11&controller=category";

		Assert.assertEquals(actualUrl, expectedUrl);
	}

	@Test(priority = 3)
	public void compareUrlTest() {
		driver.navigate().to(HomePage.HOME_URL);
		String WomenSummerDressesUrl = home.clickWomenSubmenu(driver);

		driver.navigate().to(HomePage.HOME_URL);
		String DressesSummerDressesUrl = home.clickDressesSubmenu(driver);

		Assert.assertEquals(WomenSummerDressesUrl, DressesSummerDressesUrl);
	}

	@AfterClass
	public void closeDriver() {
		driver.quit();
	}
}
