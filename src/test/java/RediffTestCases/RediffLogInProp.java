package RediffTestCases;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import RediffRepositoryPages.RediffHomePage;
import RediffRepositoryPages.RediffLoginPage;
import RediffRepositoryPages.RediffLoginPagePF;
import io.github.bonigarcia.wdm.WebDriverManager;

public class RediffLogInProp {
	@Test public void login() throws InterruptedException, IOException {
		WebDriverManager.chromedriver().setup(); 
		WebDriver driver= new ChromeDriver(); 
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://mail.rediff.com/cgi-bin/login.cgi"); 
		Thread.sleep(3000);
		
		Properties prop = new Properties(); 
		FileInputStream fis = new FileInputStream("C:\\\\Users\\\\Deepali\\\\eclipse-workspace\\\\AnandSir-Maven\\\\src\\\\test\\\\java\\\\RediffRepositoryPages\\\\data.properties");
		prop.load(fis);

		RediffLoginPage rl = new RediffLoginPage(driver);
		rl.userName().sendKeys(prop.getProperty("username"));
		rl.password().sendKeys(prop.getProperty("password"));
		rl.signIn().click(); 
		rl.home().click();

		RediffHomePage rh = new RediffHomePage(driver); rh.news().click();
		System.out.println(driver.getTitle()); Thread.sleep(3000); 
		driver.close();
	}

	
	
	
	  @Test public void login1() throws InterruptedException, IOException {
	  WebDriverManager.firefoxdriver().setup(); WebDriver driver= new
	  FirefoxDriver(); driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  driver.get("https://mail.rediff.com/cgi-bin/login.cgi"); Thread.sleep(3000);
	  
	  Properties prop = new Properties(); FileInputStream fis = new
	  FileInputStream(
	  "C:\\Users\\Deepali\\eclipse-workspace\\AnandSir-Maven\\src\\test\\java\\RediffRepositoryPages\\data.properties"
	  ); prop.load(fis);
	  
	  RediffLoginPagePF rl = new RediffLoginPagePF(driver);
	  rl.userName().sendKeys(prop.getProperty("username"));
	  rl.password().sendKeys(prop.getProperty("password")); rl.signIn().click();
	  rl.home().click();
	  
	  RediffHomePage rh = new RediffHomePage(driver); rh.news().click();
	  System.out.println(driver.getTitle()); Thread.sleep(3000); driver.close(); }
	 
	 
	 


}




