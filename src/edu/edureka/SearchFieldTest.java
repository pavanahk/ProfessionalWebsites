package edu.edureka;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SearchFieldTest {
	WebDriver driver;
	JavascriptExecutor jse;

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
			//Get Web application to be tested
			driver.get("http://www.edureka.co");
			searchCourse();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//Testing Search field by entering relevant search word
	public void searchCourse() {
		try {
			driver.findElement(By.id("search-inp3")).click();
			driver.findElement(By.id("search-inp-overlay-new")).sendKeys("Java");
			Thread.sleep(3000);
			driver.findElement(By.id("search-button-top")).click();
			driver.findElement(By.xpath("//*[@id=\"filterdropdown\"]")).click();
			driver.findElement(By.xpath(
					"//html//body//section[2]//div[1]//div[1]//div//div//div[1]//div[1]//ul//div//div//ul//li[1]//label"))
					.click();
			jse = (JavascriptExecutor) driver;
			jse.executeScript("scroll(1000,0)");

		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		SearchFieldTest obj = new SearchFieldTest();
		obj.invokeBrowser();
	}

}
