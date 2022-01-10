package RediffRepositoryPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RediffHomePage 
{

	WebDriver driver= null;
	public RediffHomePage(WebDriver driver)
	{
		this.driver=driver;
	
	}
	
	By news = By.linkText("NEWS");
	
	public WebElement news()
	{
		return driver.findElement(news);
	}
}
