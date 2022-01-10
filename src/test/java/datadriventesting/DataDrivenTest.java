package datadriventesting;

import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataDrivenTest
{
	WebDriver driver;
	@BeforeClass
	public void setup()
	{
		System.setProperty("webdriver.chrome.driver","C:\\Selenium\\Webdrivers\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@Test(dataProvider="LoginData")
	public void loginTest(String user,String pwd,String exp) throws InterruptedException
	{
		System.out.println(user+pwd +exp);
		driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
		WebElement UserName=driver.findElement(By.name("txtUsername"));
		UserName.clear();
		UserName.sendKeys(user);

		WebElement Password=driver.findElement(By.name("txtPassword"));
		Password.clear();
		Password.sendKeys(pwd);

		driver.findElement(By.name("Submit")).click();

		String exp_title="OrangeHRM";
		String act_title=driver.getTitle();

		if(exp.equals("Valid"))
		{
			if(exp_title.equals(act_title))
			{
				driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
				driver.findElement(By.cssSelector("#welcome")).click();
				driver.findElement(By.xpath("//a[normalize-space()='Logout']")).click();
				driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
				Assert.assertTrue(true);
			}
			else
			{
				Assert.assertTrue(false);
			}
		}
		else if(exp.equals("Invalid"))
		{
			if(exp_title.equals(act_title))
			{
				
				  driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
				  driver.findElement(By.cssSelector("#welcome")).click();
				  driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
				  driver.findElement(By.xpath("//a[normalize-space()='Logout']")).click();
				 
				Assert.assertTrue(false);
			}
			else 
			{
				Assert.assertTrue(true);
			}
		}
	}

	@DataProvider(name="LoginData")
	public String [][] getData()
	{
		String loginData[][]=
			{
					{"Admin","admin123","Valid"},
					{"Mithun","Mithun123","Invalid"},
					{"November","Ranjit123","Invalid"},
					{"Anand","November","Invalid"}
			};
		return loginData;
	}

	@AfterClass
	void teardown()
	{
		driver.close();
	}
}








