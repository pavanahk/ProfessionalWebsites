package ecom.jabong;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public class Search {
	WebDriver driver;
	private JavascriptExecutor jse;
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
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		//Get Web application to be teste
		driver.get("https://www.jabong.com");
		searchCourse();
	} catch (Exception e) {
		e.printStackTrace();
	}	
	}
//Testing Search field by entering relevant search word  
  public void searchCourse(){
	    try {
			driver.findElement(By.id("search")).sendKeys("Women's pants");
			driver.findElement(By.xpath("//html//body//div[1]//div[3]//header//div[1]//div[2]//div//div//div[1]//span")).click();
			Thread.sleep(3000);
			driver.get("https://www.jabong.com");
			driver.findElement(By.xpath("//html//body//div[1]//div[3]//header//div[1]//div[1]//nav//div//div[2]//ul//li[1]//a")).click();
			jse = (JavascriptExecutor)driver;
			jse.executeScript("scroll(0,1000)");
			driver.findElement(By.xpath("//html//body//section//section//section//div[7]//section//div[2]//a//img")).click();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	  }
	public static void main(String[] args) {
		Search obj = new Search();
		obj.invokeBrowser();

	}

}
