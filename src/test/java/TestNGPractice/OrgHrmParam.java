package TestNGPractice;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
public class OrgHrmParam {
	static WebDriver driver;
		static void invokeBrowser(String Browser) {
		if(Browser.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else if(Browser.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup(); 
			driver=new FirefoxDriver();
		}
				/*
		 * System.setProperty("webdriver.gecko.driver",
		 * "C:\\Selenium\\Webdrivers\\geckodriver.exe"); driver=new FirefoxDriver();
		 */

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); }

	@Test
	@Parameters({ "val1", "val2", "val3", "val4" })
	public static void login(String Browser, String URL, String username, String Password) {
		invokeBrowser(Browser);
		driver.get(URL);
		driver.findElement(By.id("txtUsername")).sendKeys(username);
		driver.findElement(By.id("txtPassword")).sendKeys(Password);
		driver.findElement(By.id("btnLogin")).click();
	}
}
