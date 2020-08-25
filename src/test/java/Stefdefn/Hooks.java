package Stefdefn;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.Before;

public class Hooks {
	
	 WebDriver driver;
	
	 @Before
	public  WebDriver getDriver() {
	
		System.setProperty("webdriver.chrome.driver", "C:\\QE\\Cucmberframework\\driver\\chromedriver.exe");
		 driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		return driver;
	}
	

}
