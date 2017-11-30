package iostreams;
import java.io.FileInputStream;

import jxl.Sheet;
import jxl.Workbook;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Retesting {
	public WebDriver driver;
  @Test
  public void f() throws Exception{
	FileInputStream fi=new FileInputStream("E:\\SELENIUM WORKSPACE 2017\\FAST TRACK\\TEST DATA\\NAUKRI LOGIN TEST DATA.xls");
	Workbook w=Workbook.getWorkbook(fi);
	Sheet s=w.getSheet("logindata");
	for (int i = 1; i < s.getRows(); i++) {
		driver.findElement(By.xpath(".//*[@id='identifierId']")).sendKeys(s.getCell(0, i).getContents());
		driver.findElement(By.xpath(".//*[@id='identifierNext']/content/span")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(".//*[@id='password']/div[1]/div/div[1]/input")).sendKeys(s.getCell(1, i).getContents());
		driver.findElement(By.xpath(".//*[@id='passwordNext']/content/span")).click();
		Thread.sleep(2000);
		try{
			driver.findElement(By.cssSelector("css=span > svg")).click();
			driver.findElement(By.xpath(".//*[@id='identifierId']")).clear();
			/*driver.findElement(By.xpath(".//*[@id='gb']/div[1]/div[1]/div[2]/div[4]/div[1]/a/span")).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath(".//*[@id='gb_71']")).click();*/
			System.out.println("Pass");
					}
		catch(Exception e){
			System.out.println("Fail");
					}
		Thread.sleep(2000);
		driver.findElement(By.xpath(".//*[@id='link-signin-different']/a")).click();
		//driver.findElement(By.id("account-chooser-add-account")).click();
		
		
		//driver.get("http://gmail.com");
	}	 
  }
  @BeforeTest
  public void beforeTest() {
	  System.setProperty("webdriver.chrome.driver","E:\\SELENIUM SOFTWARES 2017\\chromedriver.exe");
		driver=new ChromeDriver();  
		  driver.manage().window().maximize();
	  driver.get("http://gmail.co.in");
  }
}
