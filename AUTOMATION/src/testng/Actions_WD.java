package testng;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

public class Actions_WD {
	public WebDriver driver;
	
  @Test
  public void actions() throws Exception{
	  Actions a=new Actions(driver);
a.moveToElement(driver.findElement(By.xpath(".//*[@id='smoothmenu1']/ul/li[2]/a"))).build().perform();
Thread.sleep(5000);									
driver.findElement(By.linkText("Careers")).click();
Thread.sleep(5000);
a.keyDown(Keys.CONTROL).sendKeys(Keys.END).build().perform();
Thread.sleep(10000);
a.keyDown(Keys.CONTROL).sendKeys(Keys.HOME).build().perform();
 }
  @BeforeTest
  public void beforeTest() {
	  System.setProperty("webdriver.chrome.driver","E:\\SELENIUM SOFTWARES 2017\\chromedriver.exe");
		driver=new ChromeDriver(); // 
		driver.get("http://spicejet.com");
		driver.manage().window().maximize();
		  }

}
