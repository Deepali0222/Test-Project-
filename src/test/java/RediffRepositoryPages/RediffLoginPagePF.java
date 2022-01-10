package RediffRepositoryPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RediffLoginPagePF {

	WebDriver driver;
	public RediffLoginPagePF(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//input[@id='login1']") WebElement userName;
	@FindBy(xpath="//input[@id='password']") WebElement password;
	@FindBy(name="proceed") WebElement signIn;
	@FindBy(xpath="//a[contains(.,'rediff.com')]") WebElement home ;
	
	public WebElement userName()
	{
		return userName;
	}

	public WebElement password()
	{
		return password;
	}
	
	public WebElement signIn()
	{
		return signIn;
	}
	
	public WebElement home()
	{
		return home;
	}
}
