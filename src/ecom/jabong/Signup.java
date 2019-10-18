package ecom.jabong;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public class Signup {
	WebDriver driver;
	public void invokeBrowser(){
		try {
			// Set the web driver information 
			System.setProperty("webdriver.chrome.driver", "G:\\Java_Pavana\\drivers\\chromedriver.exe");
			driver = new ChromeDriver();
			// Delete all cookies before testing
			driver.manage().deleteAllCookies();
			driver.manage().window().maximize();
			// Set time for page load
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			//Get Web application to be tested
			driver.get("https://www.jabong.com");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//Testing Signup feature by passing all the respective values using element locator
	public void signUp() {
		try {
			driver.findElement(By.xpath("//*[@id=\"user-salutation\"]/a[3]")).click();
			driver.findElement(By.id("firstname")).sendKeys("abcd");
			driver.findElement(By.id("lastname")).sendKeys("efg");
			driver.findElement(By.id("email")).sendKeys("meandmaddyhate@gmail.com");
			driver.findElement(By.id("accessKey")).sendKeys("abcd321");
			driver.findElement(By.id("mobile")).sendKeys("9876543210");
			driver.findElement(By.id("female")).click();
			driver.findElement(By.id("btn-signup")).click();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		Signup obj = new Signup();
		obj.invokeBrowser();
		obj.signUp();
	}
}

