package com.test.AnandSir_Maven;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class SpiceJetHW extends SpiceJetDemo{

	public static void main(String[] args) {
		
		
		invokeBrowser("firefox");
		driver.get("https://book.spicejet.com/");
		WebElement OneWayRB = driver.findElement(By.cssSelector("label[for='ControlGroupSearchView_AvailabilitySearchInputSearchView_OneWay']"));
		
		if (OneWayRB.isSelected())
		{
			System.out.println("its clicked");
		}
		else
		{
			OneWayRB.click();
		}
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		String DepartureCity="Hyderabad";
		driver.findElement(By.xpath("//input[@id='ControlGroupSearchView_AvailabilitySearchInputSearchVieworiginStation1_CTXT']")).click();
		List<WebElement> listofcities=driver.findElements(By.xpath("//div[@class='search_options_menucontent']/div[@id='dropdownGroup1']//li/a"));
		
		System.out.println(listofcities.size());
		
		for(int i=0;i<listofcities.size();i++)
		{
			WebElement City=listofcities.get(i);
			String cityname=City.getText();
			System.out.println(cityname);
			if(cityname.contains(DepartureCity))
			{
				City.click();
			}
			
		}
		
		
		//Select from= new Select(DC);
		
		//from.selectByValue("AMD");
		
	}

}
