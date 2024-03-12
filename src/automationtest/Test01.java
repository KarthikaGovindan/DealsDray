package automationtest;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Test01 {
	WebDriver driver;
	@Parameters("browser")
	@BeforeTest
	public void setup(String browser)
	{
		if(browser.equalsIgnoreCase("chrome"))
		{
			driver=new ChromeDriver();
		}
		if(browser.equalsIgnoreCase("firefox"))
		{
			driver=new FirefoxDriver();
		}
	}
	@BeforeMethod
	public void url()
	{
		driver.get(" https://www.getcalley.com/page-sitemap.xml");
	}
	@Test
	@Parameters("browser")
	public void test(String browser) throws Exception
	{
		driver.findElement(By.xpath("//*[@id=\"sitemap\"]/tbody/tr[1]/td[1]/a")).click();
		File scrnshot1=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		if(browser.equalsIgnoreCase("chrome"))
		{
			FileHandler.copy(scrnshot1,new File("./Chrome_Screenshot_12_03_2024//scrnshot1.png"));
		}
		if(browser.equalsIgnoreCase("firefox"))
		{
			FileHandler.copy(scrnshot1,new File("./Firefox_Screenshot_12_03_2014//scrnshot1.png"));
		}
		
	}

}
