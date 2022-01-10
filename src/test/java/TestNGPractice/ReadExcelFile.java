package TestNGPractice;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ReadExcelFile {
	WebDriver driver ;
	@BeforeMethod
	public void invokeBrowser()
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		//WebDriverManager.firefoxdriver().setup();
		//driver=new FirefoxDriver();
		System.setProperty("webdriver.gecko.driver", "C:\\Selenium\\Webdrivers\\geckodriver.exe");
		driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test
	public void readData() throws IOException, InterruptedException
	{
		driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
		String excelPath ="C:\\Selenium\\OrgHRMLogin.xlsx";
		String fileName = "OrgHRMLogin";
		String sheetName= "Selenium";
		File file =new File(excelPath);
		FileInputStream fis = new FileInputStream(file);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheet(sheetName);
		int rowCount=sheet.getLastRowNum();
		System.out.println(rowCount);
		int i=1,j=1;
		while(true)
		{
			String username = sheet.getRow(i).getCell(0).getStringCellValue();
			String password = sheet.getRow(i).getCell(1).getStringCellValue();
			driver.findElement(By.id("txtUsername")).sendKeys(username);
			driver.findElement(By.id("txtPassword")).sendKeys(password);
			driver.findElement(By.id("btnLogin")).click();
			Thread.sleep(2000);
			boolean error=driver.findElement(By.id("spanMessage")).isDisplayed();
			if(error=true)
			{
				i++;
			}
			else
			{
				break;
			}
		}
		wb.close();

	}
	@AfterMethod()
	public void close()
	{

	}

}
