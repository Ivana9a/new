package myStore.test;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
//import org.testng.annotations.AfterClass;

import MyStorePageObject.Registration;
import MyStorePageObject.SignIn;
import MyStorePageObject.DataSet;

public class SignInTest {
 
	WebDriver driver; 
	
	@BeforeClass 
	public void createDriver() {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		}
	
	@Test(priority = 1)
	public void navigateToRegPageTest() {
		driver.get(RegistrationTest.registration_url);
		Assert.assertEquals(driver.getCurrentUrl(), RegistrationTest.registration_url);
	}


	@Test(priority = 2)
	public void signUsersTest() {
		SoftAssert soft = new SoftAssert();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		DataSet.setExcel();
		DataSet.setWorkSheet(0);
		DataSet.setCellData(1, 12, "sign_in");
		for (int i = 2; i <= 30; i++) {
			if (driver.getCurrentUrl() != RegistrationTest.registration_url)
				driver.navigate().to(RegistrationTest.registration_url);
			System.out.println("User: " +DataSet.getCellData(i, 1));
			SignIn.inputSignInEmail(driver, DataSet.getCellData(i, 1));
			SignIn.inputSignInPass(driver, DataSet.getCellData(i, 4));
			SignIn.clickSignIn(driver);
			soft.assertTrue(Registration.signOut(driver).getText().contains("Sign out"));

			if (Registration.signOut(driver).getText().contains("Sign out")) {
				SignIn.clickSignOut(driver);
				DataSet.setCellData(i, 13, "PASS");
			} else {
				System.out.println("Log In Unsuccessful for id: " + i);
				DataSet.setCellData(i, 13, "FAIL");
			}
		}
		soft.assertAll();
	}

}
