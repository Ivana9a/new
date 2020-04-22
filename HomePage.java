package MyStorePageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
	
	WebDriverWait wait;
	
	public static final String HOME_URL = "http://automationpractice.com/index.php";
	public static final By women_navigate = By.xpath("//a[@class='sf-with-ul'][contains(text(),'Women')]");
	public static final By women_submenu_summer_dresses = By.xpath("//*[@id=\"block_top_menu\"]/ul/li[1]/ul/li[2]/ul/li[3]/a");
	public static final By dresses_navigate = By.xpath("//*[@id=\"block_top_menu\"]/ul/li[2]/a");
	public static final By dresses_submenu_summer_dresses = By.xpath("/html[1]/body[1]/div[1]/div[1]/header[1]/div[3]/div[1]/div[1]/div[6]/ul[1]/li[2]/ul[1]/li[3]/a[1]");
	
	
	public String clickWomenSubmenu(WebDriver driver) {
		Actions action = new Actions(driver);
		
		WebElement women_menu = driver.findElement(women_navigate);
		action.moveToElement(women_menu).perform();
		
		WebElement women_submenu = driver.findElement(women_submenu_summer_dresses);
		women_submenu.click();
		return driver.getCurrentUrl();
	}
	
	public String clickDressesSubmenu(WebDriver driver) {
		Actions action = new Actions(driver);
		
		WebElement dresses_menu = driver.findElement(dresses_navigate);
		action.moveToElement(dresses_menu).perform();
		
		WebElement dresses_submenu = driver.findElement(dresses_submenu_summer_dresses);
		dresses_submenu.click();
		return driver.getCurrentUrl();
	}
	
	public void wait_menu (WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("kji")));
	}
}