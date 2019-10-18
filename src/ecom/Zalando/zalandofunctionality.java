package ecom.Zalando;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class zalandofunctionality {
	WebDriver driver;
	private JavascriptExecutor jse;

	public void invokeBrowser() {
		try {
			System.setProperty("webdriver.chrome.driver", "G:\\Java_Pavana\\drivers\\chromedriver.exe");
			driver = new ChromeDriver();
			// Delete all cookies before testing
			driver.manage().deleteAllCookies();
			driver.manage().window().maximize();
			// Set time for page load
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			// Get Web application to be tested
			driver.get("https://www.zalando.de/");
			searchCourse();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void searchCourse() {
		//Search product using category
		try {
			driver.findElement(By.xpath(
					"//*[@id=\"z-navicat-header-root\"]/header/div[3]/div/div/div/div/z-grid/z-grid-item/div/div[1]/div[1]/div/a[1]")).click();
			driver.findElement(By.xpath(
					"//*[@id=\"z-navicat-header-root\"]/header/div[3]/div/div/div/div/z-grid/z-grid-item/div/div[2]/div[2]/div/ul/li[3]/a/span")).click();
			driver.findElement(
					By.xpath("//*[@id=\"z-nvg-cognac-root\"]/div[1]/z-grid/z-grid-item[1]/div/div/div/div[2]/a")).click();
			jse = (JavascriptExecutor) driver;
			WebElement ele = driver.findElement(By.xpath("//*[@id=\"z-nvg-cognac-root\"]/div[1]/z-grid/z-grid-item[2]/div/div[6]/z-grid/z-grid-item[1]/div/a"));
			jse.executeScript("arguments[0].click();", ele);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		zalandofunctionality obj = new zalandofunctionality();
		obj.invokeBrowser();
	}
}
