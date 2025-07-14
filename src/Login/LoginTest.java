package Login;

import java.time.Duration;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginTest {
	Random rand = new Random();


	WebDriver driver = new ChromeDriver();

	String Username;
	String TheLoginPassword = "Yazan123";

	String theWebSite = "https://automationteststore.com/";


	@BeforeTest()
	public void mysetup() {

		driver.get(theWebSite);

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

	}

	@Test(priority = 1, enabled = true)

	public void Sginup() throws InterruptedException {
		
		String ConfirmationMassage ="Your Account Has Been Created!";


		driver.navigate().to("https://automationteststore.com/index.php?rt=account/create");


		WebElement E_mailInput = driver.findElement(By.id("AccountFrm_email"));
		WebElement TelePhoneInput = driver.findElement(By.id("AccountFrm_telephone"));
		WebElement FaxInput = driver.findElement(By.id("AccountFrm_fax"));
		WebElement CompanyInput = driver.findElement(By.id("AccountFrm_company"));
		WebElement Adrees1Input = driver.findElement(By.id("AccountFrm_address_1"));
		WebElement CityInput = driver.findElement(By.name("city"));
		WebElement country = driver.findElement(By.id("AccountFrm_country_id"));
		WebElement State = driver.findElement(By.id("AccountFrm_zone_id"));
		WebElement ZibCode = driver.findElement(By.id("AccountFrm_postcode"));
		WebElement loginName = driver.findElement(By.id("AccountFrm_loginname"));
		WebElement Password = driver.findElement(By.id("AccountFrm_password"));
		WebElement PasswordConfirm = driver.findElement(By.id("AccountFrm_confirm"));
		WebElement Subscribe = driver.findElement(By.id("AccountFrm_newsletter1"));
		WebElement Agreebutton = driver.findElement(By.name("agree"));
		WebElement ContinueButton = driver.findElement(By.xpath("//button[@title='Continue']"));

		Thread.sleep(3000);

		int randomNumberforEmail = rand.nextInt(9800);
		String[] FirstName = { "Yazan", "ali", "ahmad", "talal" };
		int randomNameIndex = rand.nextInt(FirstName.length);
		String randomName = FirstName[randomNameIndex];

		WebElement FirstNameInput = driver.findElement(By.id("AccountFrm_firstname"));

		String[] LastName = { "Yazan", "yousef", "ahmad", "talal" };

		int randomLastNameIndex = rand.nextInt(LastName.length);
		String randomLastName = LastName[randomLastNameIndex];

		WebElement LastNameInput = driver.findElement(By.id("AccountFrm_lastname"));

		String email = randomName + randomLastName + randomNumberforEmail + "@gmail.com";
		String tele = ("0785075401");
		String fax = ("543526");
		String Company = ("Revton");
		String Adrees1 = ("Hay_nazal");
		String City = ("Amman");
		String zibcode = ("10888");
		String password = ("yazankh1223");
		String asswordconfirm = ("yazankh1223");

		Thread.sleep(3000);

		// Action

		FirstNameInput.sendKeys(randomName);
		LastNameInput.sendKeys(randomLastName);
		E_mailInput.sendKeys(email);
		TelePhoneInput.sendKeys(tele);
		FaxInput.sendKeys(fax);
		CompanyInput.sendKeys(Company);
		Adrees1Input.sendKeys(Adrees1);
		CityInput.sendKeys(City);
		ZibCode.sendKeys(zibcode);

		Thread.sleep(5000);

		Select myselectforCountry = new Select(country);
		int randomCountry = rand.nextInt(1, 240);
		myselectforCountry.selectByIndex(randomCountry);

		Thread.sleep(2000);

		int numberofState = State.findElements(By.tagName("option")).size();
		System.out.println(numberofState);

		Select myselectforState = new Select(State);
		int randomState = rand.nextInt(1, numberofState);
		myselectforState.selectByIndex(randomState);

		Thread.sleep(2000);

		Username = randomName + randomLastName + randomNumberforEmail;
		loginName.sendKeys(Username);
		Password.sendKeys(TheLoginPassword);
		PasswordConfirm.sendKeys(TheLoginPassword);
		Subscribe.click();
		Agreebutton.click();

		ContinueButton.click();
		Thread.sleep(2000);
		
		
		boolean ActualResult =driver.getPageSource().contains(ConfirmationMassage);
	    Assert.assertEquals(ActualResult, true , "your account has been created!");
		
	}

	@Test(priority = 2, enabled = true)
	public void LogOut() throws InterruptedException {
		
		String LogOutConfirmationMassage ="You have been logged off your account. It is now safe to leave the computer.";

		Thread.sleep(2000);
		WebElement Logout = driver.findElement(By.linkText("Logoff"));
		Logout.click();
		boolean ActualResult = driver.getPageSource().contains(LogOutConfirmationMassage);
		Assert.assertEquals(ActualResult, true);

	}
	
	
	@Test(priority = 3,enabled = true)
	public void Login() {
		
		String ConfirmationLoginPage = " Account Login";
		WebElement LoginRegitter = driver.findElement(By.partialLinkText("Login or re"));
		LoginRegitter.click();
		boolean ActualResult = driver.getPageSource().contains(ConfirmationLoginPage);
		Assert.assertEquals(ActualResult, true);
		
		
		WebElement Login = driver.findElement(By.id("loginFrm_loginname"));
		WebElement Password = driver.findElement(By.id("loginFrm_password"));
		Login.sendKeys(Username);
		Password.sendKeys(TheLoginPassword);

		driver.findElement(By.xpath("//button[@title='Login']")).click();
		
		
		
		
		
		
	}
	
	@Test (priority = 4 ,enabled = true)
	public void addItemTheCart() throws InterruptedException
	{
		
		
		String ConfirmationUrl ="https://automationteststore.com/index.php?rt=checkout/cart";
				
		driver.navigate().to("https://automationteststore.com/");
		String[] sectionsNames = { "featured", "latest", "bestseller", "special" };
		int randomSectionIndex = rand.nextInt(sectionsNames.length);
		WebElement TheFeatured = driver.findElement(By.id(sectionsNames[randomSectionIndex]));
		List<WebElement> AllItems = TheFeatured.findElements(By.className("prdocutname"));
		int randomProduct = rand.nextInt(AllItems.size());
		AllItems.get(randomProduct).click();
		Thread.sleep(2000);
		
		String ProductPage = driver.findElement(By.className("productpagecart")).getText();

		if (ProductPage.equals("Out of Stock")) {
			driver.navigate().back();
			System.out.println("sorry the item is not available");
		} else {
			System.out.println(driver.getCurrentUrl());
			if (driver.getCurrentUrl().contains("product_id=116")) {
				Thread.sleep(2000);
				System.out.println("@@@@@@@@@@@@@");
				driver.findElement(By.xpath("//label[@for='option344747']")).click();

			}
			driver.findElement(By.partialLinkText("Add to Cart")).click();
			
		}
		Thread.sleep(2000);
		boolean ActualResult= driver.getCurrentUrl().contains(ConfirmationUrl);
		Assert.assertEquals(ActualResult, true);
	}

	
	@Test (priority = 5 , enabled = false)
	public void Checkout() throws InterruptedException {
		
		WebElement Checkoutbutton =driver.findElement(By.id("cart_checkout2"));
		 Checkoutbutton.click();
		
		 
			 
			 
			 
			 
		 }
		
		
	@Test (priority = 6 , enabled = false)
	 public void ConfirmOrder() {
		 
	WebElement ConfirmOrder= driver.findElement(By.id("checkout_btn"));
	ConfirmOrder.click();
		
	}
	
	
	
	
	
	
	
	
	
	

	/*@AfterTest
	public void closingTheBrowser() {

		driver.close();

	}*/
}
