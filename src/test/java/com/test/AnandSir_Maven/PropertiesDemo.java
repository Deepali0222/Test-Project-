package com.test.AnandSir_Maven;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;

public class PropertiesDemo extends SpiceJetDemo {

	public static void main(String[] args)  {
		FileInputStream fis;
		Properties prop=null;
		
		try {
				fis = new FileInputStream("C:\\Users\\Deepali\\eclipse-workspace\\AnandSir-Maven\\data.properties");
			 prop = new Properties();
			try {
				prop.load(fis);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	String baseurl=prop.getProperty("baseurl");
	String username=prop.getProperty("username");
	String password=prop.getProperty("password");
	String browser=prop.getProperty("browser");
		
		System.out.println(baseurl+" "+username+" "+password+" "+browser);
		
		invokeBrowser(browser);
		driver.get(baseurl);
		
		driver.findElement(By.name("txtUsername")).sendKeys(username);
		driver.findElement(By.name("txtPassword")).sendKeys(password);
		driver.findElement(By.name("Submit")).click();
		
		
		
	}

}