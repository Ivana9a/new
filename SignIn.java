package MyStorePageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignIn {
	public static final By signin_email = By.xpath("//input[@id='email']");
	public static final By signin_psw = By.xpath("//input[@id='passwd']");
	public static final By signin = By.xpath("//p[@class='submit']//span[1]");
	public static final By signout = By.xpath("//a[@class='logout']"); 
	public static final By signin_btn = By.xpath("//a[@class='login']");
	
	public static void inputSignInEmail(WebDriver driver, String data) {
		driver.findElement(signin_email).sendKeys(data);
	}

	public static void inputSignInPass(WebDriver driver, String data) {
		driver.findElement(signin_psw).sendKeys(data);
	}

	public static void clickSignIn(WebDriver driver) {
		driver.findElement(signin).click();

	}

	public static void clickSignOut(WebDriver driver) {
		driver.findElement(signout).click();
	}
	
	public static void clickSignInButton(WebDriver driver) {
		driver.findElement(signin_btn);
	}

}
