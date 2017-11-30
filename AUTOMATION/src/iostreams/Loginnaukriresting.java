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

public class Loginnaukriresting {
	public WebDriver driver;
  @Test
  public void f() throws Exception{
	FileInputStream fi=new FileInputStream("E:\\SELENIUM WORKSPACE 2017\\FAST TRACK\\TEST DATA\\NAUKRI LOGIN TEST DATA.xls"); //path declaraton
	Workbook w=Workbook.getWorkbook(fi); //to read the data from login.xks file
	Sheet s=w.getSheet("logindata");
		for (int i = 1; i < s.getRows(); i++) {
		driver.findElement(By.xpath(".//*[@id='login_Layer']")).click();
		driver.findElement(By.xpath(".//*[@id='eLogin']")).sendKeys(s.getCell(0,i).getContents());
		Thread.sleep(2000);
		driver.findElement(By.xpath(".//*[@id='pLogin']")).sendKeys(s.getCell(1, i).getContents());
		driver.findElement(By.xpath(".//*[@id='lgnFrm']/div[8]/button")).click();
		try{
			driver.findElement(By.xpath(".//*[@id='eLogin']")).clear();
			driver.findElement(By.xpath(".//*[@id='pLogin']")).clear();
			
			System.out.println("Pass");
					}
		catch(Exception e){
			System.out.println("Fail");
					}
	} 
  }
  @BeforeTest
  public void beforeTest() {
	  System.setProperty("webdriver.chrome.driver","E:\\SELENIUM SOFTWARES 2017\\chromedriver.exe");
		driver=new ChromeDriver(); // to launch chrome browser
	  driver.manage().window().maximize();
	  driver.get("http://www.naukri.com");
  }
}
