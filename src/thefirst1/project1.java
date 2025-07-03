package thefirst1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class project1 {
	
	// this is the browser that will be used across all my testing
	WebDriver driver = new EdgeDriver();
	
	String theURL = "https://www.saucedemo.com/";
	
	
	// this is the part that will be run before i start my real testing
	
	// @ = annotation يعني منطقة محجوزة لاشي معين في حالتنا المنطقة هاي هيه البيفور تيست
	@BeforeTest
	
	public void  myTestSetup () {
		
		driver.get(theURL);
		
		driver.manage().window().maximize();
	}
	
	
	// هاي الجزئية للتيست تبعي
	@Test
	public void login() throws InterruptedException {
 
		WebElement usernameInput = driver.findElement(By.name("user-name"));
		
		usernameInput.sendKeys("standard_user");
		
		WebElement passwordInput = driver.findElement(By.name("password"));
		
		passwordInput.sendKeys("secret_sauce");
		
		WebElement LoginButton = driver.findElement(By.xpath("//input[@data-test='login-button']"));
		
		LoginButton.click();
		WebElement AddtoButton = driver.findElement(By.xpath("//button[@data-test='add-to-cart-sauce-labs-backpack']"));

	    AddtoButton.click();
	    
	    WebElement Addtobutton =driver.findElement(By.xpath("//button[@data-test='add-to-cart-sauce-labs-bike-light']   "));
	    
	    Addtobutton.click();
	    
	    WebElement Addtobutton3 =driver.findElement(By.xpath("//button[@data-test='add-to-cart-sauce-labs-bolt-t-shirt'] "));

	    Addtobutton3.click();
	    
	    
	    
	}
	
	
	// هاي الجزئية للأشي الي بدي اياه يشتغل بعد ما اخلص التيست تبعي
	@AfterTest
	public void AfterTestIsDone() {
		
//		driver.quit();
	}
	
 
 
}
 


