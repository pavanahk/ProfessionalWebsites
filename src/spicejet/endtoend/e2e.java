package spicejet.endtoend;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class e2e {

	public static void main(String[] args) {
		try {
			System.setProperty("webdriver.chrome.driver", "G:\\Java_Pavana\\drivers\\chromedriver.exe");
			WebDriver driver = new ChromeDriver();
			driver.get("https://www.spicejet.com/");
			driver.manage().deleteAllCookies();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_0")).click();
			driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
			driver.findElement(By.xpath("//a[@value='BLR']")).click();
			driver.findElement(By.id("ctl00_mainContent_ddl_destinationStation1_CTXT")).click();
			driver.findElement(By.xpath("(//a[@value='MAA'])[2]")).click(); //since both the dropdowns have same value we are giving index value as [2] to identify the city in "To"
			driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight.ui-state-active")).click();
			if(driver.findElement(By.id("Div1")).getAttribute("Style").contains("0.5")) //to make sure whether the "Return Date" is disabled when we select "One way"
			{
				System.out.println("it is disabled");
				Assert.assertTrue(true);
			}
			else
			{
				Assert.assertFalse(false);
			}
			driver.findElement(By.id("ctl00_mainContent_chk_SeniorCitizenDiscount")).click();
			driver.findElement(By.id("divpaxinfo")).click();  //Static Dropdown
			Select s=new Select(driver.findElement(By.id("ctl00_mainContent_ddl_Adult")));
			s.selectByVisibleText("6");
			System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
			driver.findElement(By.id("ctl00_mainContent_btn_FindFlights")).click();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}