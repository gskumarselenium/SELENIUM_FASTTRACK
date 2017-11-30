package testng;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class Facebook_login {
	WebDriver driver;
	
  @Test
  public void login() throws Exception {
		driver.findElement(By.id("email")).sendKeys("inetsolv@gmail.com");
		//Thread.sleep(10000);
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.findElement(By.id("pass")).sendKeys("45885666");
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.findElement(By.xpath(".//*[@id='u_0_2']")).click();
	}

  
  @BeforeTest
  public void browser() throws Exception {
		System.setProperty("webdriver.chrome.driver","E:\\SELENIUM SOFTWARES 2017\\chromedriver.exe");
		driver=new ChromeDriver(); // to launch chrome browser
		driver.get("http://www.fb.com"); // to insert url
		driver.manage().window().maximize();// to maximize browser
	}

  @AfterTest
  public void afterTest() {
	  driver.quit();
  }

}
