package MyStorePageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Registration {
	public static final By e_mail = By.xpath("//*[@id=\"email_create\"]");
	public static final By create_account = By.xpath("//form[@id='create-account_form']//span[1]");
	public static final By first_name = By.id("customer_firstname");
	public static final By last_name = By.xpath("//input[@id='customer_lastname']");
	public static final By password = By.xpath("//input[@id='passwd']");
	public static final By address_first_name = By.xpath("//input[@id='firstname']");
	public static final By address_lastname = By.xpath("//input[@id='lastname']");
	public static final By address = By.xpath("//input[@id='address1']");
	public static final By city = By.xpath("//input[@id='city']");
	public static final By state = By.xpath("//select[@id='id_state']");
	public static final By zip_code = By.xpath("//input[@id='postcode']");
	public static final By country = By.xpath("//select[@id='id_country']");
	public static final By mobile_phone = By.xpath("//input[@id='phone_mobile']");
	public static final By assign_alias = By.xpath("//input[@id='alias']");
	public static final By reg_btn = By.xpath("//span[contains(text(),'Register')]");
	public static final By sign_out = By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[2]");
	
	public static void inputEmail(WebDriver driver, String data) {
		driver.findElement(e_mail).sendKeys(data);
	}

	public static void createAccount(WebDriver driver) {
		driver.findElement(create_account).click();
	}

	public static void inputFirstName(WebDriver driver, String data) {
		driver.findElement(first_name).sendKeys(data);
	}

	public static void inputLastName(WebDriver driver, String data) {
		driver.findElement(last_name).sendKeys(data);
	}

	public static void inputPassword(WebDriver driver, String data) {
		driver.findElement(password).sendKeys(data);
	}

	public static void inputAddressFirstName(WebDriver driver, String data) {
		driver.findElement(address_first_name).sendKeys(data);
	}

	public static void inputAddressLastName(WebDriver driver, String data) {
		driver.findElement(address_lastname).sendKeys(data);
	}

	public static void inputAddress(WebDriver driver, String data) { 
		driver.findElement(address).sendKeys(data);
	}

	public static void inputCity(WebDriver driver, String data) {
		driver.findElement(city).sendKeys(data);
	}

	public static void chooseState(WebDriver driver, String data) {
	Select drpdState = new Select(driver.findElement(By.id("id_state")));
	drpdState.selectByVisibleText(data);
	}

	public static void inputZip(WebDriver driver, String data) {
		driver.findElement(zip_code).sendKeys(data);

	}

	public static Select country(WebDriver driver) {
		return new Select(driver.findElement(country));
	}

	public static void chooseCountry(WebDriver driver, String data) {
		country(driver).selectByVisibleText(data);

	}

	public static void inputMobilePhone(WebDriver driver, String data) {
		driver.findElement(mobile_phone).sendKeys(data);
	}

	public static void assignAddress(WebDriver driver, String data) {
		driver.findElement(assign_alias).sendKeys(data);
	}

	public static void clickOnRegButton(WebDriver driver) {
		driver.findElement(reg_btn).click();
	}
	public static void clickOnSignOut(WebDriver driver) {
		driver.findElement(sign_out).click();
	}
	
	public static WebElement signOut(WebDriver driver) {
		return driver.findElement(sign_out);
	}

}

