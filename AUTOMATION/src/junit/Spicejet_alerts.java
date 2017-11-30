package junit;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Spicejet_alerts {
	WebDriver driver;
	
	@Before
	public void browser() throws Exception {
		System.setProperty("webdriver.chrome.driver","E:\\SELENIUM SOFTWARES 2017\\chromedriver.exe");
		driver=new ChromeDriver(); // to launch chrome browser
		driver.get("http://www.spicejet.com"); // to insert url
		driver.manage().window().maximize();// to maximize browser
	}

	@After
	public void tearDown() throws Exception {
		String str;
		str=driver.switchTo().alert().getText();
		System.out.println(str);
		driver.switchTo().alert().accept();
	}

	@Test
	public void test() {
		driver.findElement(By.xpath(".//*[@id='ctl00_mainContent_rbtnl_Trip_1']")).click();
		driver.findElement(By.xpath(".//*[@id='ctl00_mainContent_ddl_originStation1_CTXT']")).click();
		driver.findElement(By.linkText("Bengaluru (BLR)")).click();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.findElement(By.linkText("Chennai (MAA)")).click();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.findElement(By.linkText("26")).click();
		new Select(driver.findElement(By.xpath(".//*[@id='ctl00_mainContent_ddl_Adult']"))).selectByVisibleText("9 Adults");
		new Select(driver.findElement(By.xpath(".//*[@id='ctl00_mainContent_ddl_Child']"))).selectByVisibleText("1 Child");
		driver.findElement(By.xpath(".//*[@id='ctl00_mainContent_btn_FindFlights']")).click();
				
	}
	

}
