package com.test.AnandSir_Maven;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class DragDrop extends SpiceJetDemo {

	public static void main(String[] args) {
		
		invokeBrowser("firefox");
		driver.get("https://demoqa.com/droppable");
		WebElement from=driver.findElement(By.id("draggable"));
		WebElement To=driver.findElement(By.id("droppable"));
		Actions act= new Actions(driver);
		//act.dragAndDrop(from, To).perform();
		act.clickAndHold(from).moveToElement(To).release().build().perform();
		//act.dragAndDropBy(To, 150, 200);
		WebElement dropMsg=driver.findElement(By.xpath("//p[contains(text(),'Dropped!')]"));
		
		if(dropMsg.isDisplayed())
		{
			System.out.println("Message is :"+dropMsg.getText());
			System.out.println("value has been changed");
		}
		else 
			System.out.println("value has not changed");
		

	}

}
