package RediffTestCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import RediffRepositoryPages.RediffHomePage;
import RediffRepositoryPages.RediffLoginPage;
import RediffRepositoryPages.RediffLoginPagePF;
import io.github.bonigarcia.wdm.WebDriverManager;

public class RediffLogin {

	/*
	 * @Test public void login() throws InterruptedException {
	 * WebDriverManager.chromedriver().setup(); WebDriver driver= new
	 * ChromeDriver(); driver.manage().window().maximize();
	 * driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	 * driver.get("https://mail.rediff.com/cgi-bin/login.cgi"); Thread.sleep(3000);
	 * 
	 * RediffLoginPage rl = new RediffLoginPage(driver);
	 * rl.userName().sendKeys("adafa"); rl.password().sendKeys("hyhy");
	 * rl.signIn().click(); rl.home().click();
	 * 
	 * RediffHomePage rh = new RediffHomePage(driver); rh.news().click();
	 * System.out.println(driver.getTitle()); Thread.sleep(3000); driver.close(); }
	 */
	
	@Test
	public void login() throws InterruptedException
	{
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver= new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
		Thread.sleep(3000);

		RediffLoginPagePF rl = new RediffLoginPagePF(driver);
		rl.userName().sendKeys("adafa");
		rl.password().sendKeys("hyhy");
		rl.signIn().click();
		rl.home().click();

		RediffHomePage rh = new RediffHomePage(driver);
		rh.news().click();
		System.out.println(driver.getTitle());
		Thread.sleep(3000);
		driver.close();
	}

}
