package search.google;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SearchHotelsinMunich {
	WebDriver driver;
	public void invokeBrowser() {
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
			// Get Web application to be tested
			driver.get("https://www.google.com/");
			searchCourse();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void searchCourse() {
		try {
			// Search "Hotels in Munich" and click on first search result
			driver.findElement(By.xpath("//*[@id=\"tsf\"]/div[2]/div[1]/div[1]/div/div[2]/input"))
					.sendKeys("Hotels in Munich");
			driver.findElement(By.xpath("//*[@id=\"tsf\"]/div[2]/div[1]/div[2]/div[2]/ul/li[1]/div/div[2]/div/span"))
					.click();
			driver.findElement(By.xpath("//*[@id=\"vn1s0p1c0\"]/h3")).click();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		SearchHotelsinMunich obj = new SearchHotelsinMunich();
		obj.invokeBrowser();
	}
}