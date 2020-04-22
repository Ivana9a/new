package myStore.test;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

import MyStorePageObject.Registration;
import MyStorePageObject.DataSet;


public class RegistrationTest {
	
	public static final String registration_url = "http://automationpractice.com/index.php?controller=authentication&back=my-account";
	public static final String signin_email = "//input[@id='email']";
	public static final String signin_psw = "//input[@id='passwd']";
	public static final String signin = "//p[@class='submit']//span[1]";
	
	public static final String signin_btn = "//a[@class='login']";
	
	WebDriver driver;
	Registration reg;

  @BeforeClass
  public void startDriver() {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

  @Test(priority = 1)
  public void navigateToRegistrationPage() {
		driver.navigate().to(registration_url);
		
		Assert.assertEquals(driver.getCurrentUrl(),registration_url);
	}
  
  /*@Test(priority = 2)
  public void createAccount() throws InterruptedException {
		driver.navigate().to(registration_url);
		Thread.sleep(3000);
		Registration.inputEmail(driver, "xaxiavaanlahgaadftic023@gmail.com");
		Registration.createAccount(driver);
		Registration.inputFirstName(driver, "Ivana");  
		Registration.inputLastName(driver, "Kostic");
		Registration.inputPassword(driver, "09876");
		Registration.inputAddress(driver, "Jurija Gagarina 82");
		Registration.inputCity(driver, "Calabasas");
		Registration.chooseState(driver, "California");
		Registration.inputZip(driver, "07178");
		Registration.chooseCountry(driver, "United States");
		Registration.inputMobilePhone(driver, "6868455435");
		Registration.assignAddress(driver, "08086767");
		Registration.clickOnRegButton(driver);
		Registration.clickOnSignOut(driver);
		SoftAssert soft = new SoftAssert();
		soft.assertTrue(Registration.signOut(driver).getText().contains("Sign out"));
		
		//Registration.clickOnSignOut(driver);

	}*/
  
  @Test (priority = 3)
  public void randomUserRegistrationTest() {
		SoftAssert soft = new SoftAssert();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		DataSet.setExcel();
		DataSet.setWorkSheet(0);
		DataSet.setCellData(0, 13, "registration");

		for (int i = 1; i <= 30; i++) {
			if (driver.getCurrentUrl() != registration_url)
				driver.navigate().to(registration_url);
			
			Registration.inputEmail(driver, DataSet.getCellData(i, 1));
			Registration.createAccount(driver);
			Registration.inputFirstName(driver, DataSet.getCellData(i, 2));
			Registration.inputLastName(driver, DataSet.getCellData(i, 3));
			Registration.inputPassword(driver, DataSet.getCellData(i, 4));
			Registration.inputAddress(driver, DataSet.getCellData(i, 5));
			Registration.inputCity(driver, DataSet.getCellData(i, 6));
			Registration.chooseState(driver, DataSet.getCellData(i, 7));
			Registration.inputZip(driver, DataSet.getCellData(i, 8));
			Registration.chooseCountry(driver, DataSet.getCellData(i, 9));
			Registration.inputMobilePhone(driver, DataSet.getCellData(i, 10));
			Registration.assignAddress(driver, DataSet.getCellData(i, 11));
			Registration.clickOnRegButton(driver);

			soft.assertTrue(Registration.signOut(driver).getText().contains("Sign out"));
			
			if (Registration.signOut(driver).getText().contains("Sign out")) {
				Registration.clickOnSignOut(driver);
				DataSet.setCellData(i, 12, "Pass");
			} else {
				System.out.println("Error");
				DataSet.setCellData(i, 12, "Fail");
			}

		}
		soft.assertAll();
	}
  
  @AfterClass
  public void closeDriver() {
		driver.quit();
  }
}
