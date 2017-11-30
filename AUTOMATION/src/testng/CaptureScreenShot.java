package testng;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class CaptureScreenShot {
	public WebDriver driver;
	
public void takeScreenShot(String str) throws Exception{
File f=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);// screenshot will be captured
FileUtils.copyFile(f, new File("E:\\SELENIUM WORKSPACE 2017\\FAST TRACK\\SCREENSHOTS\\"+str+".png"));		
	}

  @Test
  public void links() throws Exception{
driver.findElement(By.linkText("Projects")).click();
takeScreenShot("projects link");
driver.findElement(By.linkText("Download")).click();
takeScreenShot("Download link");
driver.findElement(By.linkText("About")).click();
takeScreenShot("About link");
  }
  @BeforeTest
  public void beforeTest() {
	  System.setProperty("webdriver.chrome.driver","E:\\SELENIUM SOFTWARES 2017\\chromedriver.exe");
		driver=new ChromeDriver(); // to launch chrome browser
	  driver.get("http://seleniumhq.org/");
	    }

  @AfterTest
  public void afterTest() throws Exception {
	  Thread.sleep(5000);
	  driver.quit();
  }

}
