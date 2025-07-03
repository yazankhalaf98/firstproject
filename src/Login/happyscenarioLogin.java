package Login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class happyscenarioLogin {
	
	
	
	
	
	WebDriver driver = new ChromeDriver();
	String TheWebsite ="https://www.google.com/";
	
	
@BeforeTest()
	
	public void logInPage () {
		
		WebElement Loginpage = driver.findElement(null);
		
		
		
	}
	
	
	@Test()
	public void serech () {    
		
		
		
		
		WebElement search = driver.findElement(By.xpath(TheWebsite));
	}
	
	
	
	
	

}
