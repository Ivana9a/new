package myStore.test;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import MyStorePageObject.SummerDress;

public class SummerDressTest {

	public static final String summer_dress_url = "http://automationpractice.com/index.php?id_category=11&controller=category";
	public static final String first_summer_dress_url = "http://automationpractice.com/index.php?id_product=5&controller=product";

	WebDriver driver;
	SummerDress dress;
	WebDriverWait wait;

	@BeforeClass
	public void startDriver() {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	@Test(priority = 1)
	public void navigateToFirstDressTest() {
		driver.navigate().to(summer_dress_url);
		dress = new SummerDress();
		dress.chooseFirstDress(driver);

		String actual_url = driver.getCurrentUrl();
		String expected_url = first_summer_dress_url;

		Assert.assertEquals(actual_url, expected_url);

	}

	@Test(priority = 2)
	public void addToCartTest() throws InterruptedException {
		driver.navigate().to(first_summer_dress_url);
		SummerDress.addDressesToCart(driver);

		Thread.sleep(3000);

		SoftAssert soft = new SoftAssert();
		soft.assertTrue(SummerDress.getDressName(driver).getText().contains("Printed Summer Dress"));
		soft.assertTrue(SummerDress.getDressColorSize(driver).getText().contains("Color : Blue, Size : M"));

		soft.assertEquals(SummerDress.getQuantity(driver).getAttribute("value"), "2");

		soft.assertAll();
	}

	@Test(priority = 3)
	public void proceedToCheckoutTest() {
		SummerDress.proceedToCheckout(driver);

		String actual_url = driver.getCurrentUrl();
		String expected_url = "http://automationpractice.com/index.php?controller=authentication&multi-shipping=0&display_guest_checkout=0&back=http%3A%2F%2Fautomationpractice.com%2Findex.php%3Fcontroller%3Dorder%26step%3D1%26multi-shipping%3D0";

		Assert.assertEquals(actual_url, expected_url);
	}

	@AfterClass
	public void closeDriver() {
		driver.quit();
	}
}
