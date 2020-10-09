package com.flipkart.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * This class initialize the value of driver and will be shared in all classes
 * 
 * @author gaurav kumar
 * @since 10th october 2020
 * 
 */
public class WebPlatformHandler {
	
	static WebDriver driver;
	public static Properties prop;
	
	
	 public WebPlatformHandler(){
		try {
		prop = new Properties();
		FileInputStream ip = new FileInputStream("./src/main/java/com/flipkart/config/config.properties");
		prop.load(ip);
		}
		catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	 /**
		 * Used to choose the browser and open the URL with maximize and clear cookies
		 * 
		 */ 
	public WebDriver Intialization() {
		try {
			driver = null;
			System.out.println("Opening the browser for automated test..");
			if(driver == null) {
				if(prop.getProperty("browserName").equalsIgnoreCase("chrome")) {
					System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
					driver = new ChromeDriver();
				}
				else if(prop.getProperty("browserName").equalsIgnoreCase("firefox")) {
					System.setProperty("webdriver.gecko.driver","./Drivers/geckodriver.exe" );
					driver = new FirefoxDriver();				
				}	
			}
			
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			WebDriver driver = getTargetDriver();	
			// Getting the URL of website
			driver.get(prop.getProperty("url"));	
		}
		catch(Exception e) {
			System.out.println("Failed to initialize driver" + e);
			throw new RuntimeException(e);
		}
		return driver;
	} 
		
	public WebDriver getTargetDriver() {	
		if (driver == null) {
			String message = "Driver is null, cannot continue. Application has probably crashed or Driver creation failed!";
			System.out.println(message);
		}
		PageFactory.initElements(driver, this);
		return driver;
	}
		

}
