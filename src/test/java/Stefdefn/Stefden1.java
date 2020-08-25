package Stefdefn;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Excel.ExcelUtil;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Stefden1  {
	
	//WebDriver driver;
	Hooks hok = new Hooks();
	
	WebDriver driver = hok.getDriver();
	ExcelUtil excel = new ExcelUtil();

	
	@Given("^User enter application url$")
	public void user_enter_application_url() throws Throwable {
		
				
		
		driver.navigate().to("https://www.amazon.in/");
	System.out.println(driver);
	driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);

		WebElement signinopt = driver.findElement(By.xpath("//a[@id='nav-link-accountList']"));
		System.out.println("gi2");
		signinopt.click();

	}

	
	@When("^user name and password is provided$")
	public void user_name_and_password_is_provided() throws Throwable {
		
		WebElement email = driver.findElement(By.xpath("//input[@type='email']"));
		WebElement contin =driver.findElement(By.xpath("//input[@id='continue']"));
		email.click();
	    email.sendKeys(excel.readEXcel("sample", "user"));
	    contin.click();
	    WebElement password =driver.findElement(By.xpath("//input[@type='password']"));
	    password.click();
	    password.sendKeys(excel.readEXcel("sample", "password"));
	   
	}

	@Then("^Login should be successful$")
	public void login_should_be_successful() throws Throwable {
		WebElement signin= driver.findElement(By.xpath("//input[@id='signInSubmit']"));
		 signin.click();
	}

	@Given("^Search for product with name(\\d+)$")
	public void search_for_product_with_name(int arg1) throws Throwable {
//		WebElement searchitem = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
//		WebElement clicksearch = driver.findElement(By.xpath(" //input[@type='submit']")); 
//		
//		searchitem.sendKeys("Item part number : 11874");
//		clicksearch.click();
		
		
	}

	@When("^Search result is displayed$")
	public void search_result_is_displayed() throws Throwable {
		WebElement searchresult = driver.findElement(By.xpath("//span[contains(text(),'TRESemme ')]"));
		searchresult.click();
		String parent=driver.getWindowHandle();
		//use this method or the iterator one
		for (String handle : driver.getWindowHandles()) {

		    driver.switchTo().window(handle);}
		
//		 Set<String> s= driver.getWindowHandles();

//		 Iterator<String> I1= s.iterator();
//
//		 while(I1.hasNext())
//		 {
//
//		 String child_window=I1.next();
//
//
//		 if(!parent.equals(child_window))
//		 {
//		 driver.switchTo().window(child_window);
//
//		 }
//		 }
		 
	}

	@When("^Click on add to cart button$")
	public void click_on_add_to_cart_button() throws Throwable {
		WebElement add = driver.findElement(By.id("add-to-cart-button"));
		add.click();
	    
	}

	@Then("^Item added to cart$")
	public void item_added_to_cart() throws Throwable {
	    
	}

	
}
