package junit;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Waitscript {
	 WebDriver driver;

	@Before
	public void browser()  {
		System.setProperty("webdriver.chrome.driver","E:\\SELENIUM SOFTWARES 2017\\chromedriver.exe");
		driver=new ChromeDriver(); // to launch chrome browser
		driver.get("http://www.fb.com"); // to insert url
		driver.manage().window().maximize();// to maximize browser
			}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void login() throws Exception {
		driver.findElement(By.id("email")).sendKeys("inetsolv@gmail.com");
		//Thread.sleep(10000);
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.findElement(By.id("pass")).sendKeys("45885666");
		driver.findElement(By.id("u_0_2")).click();
	}

}
