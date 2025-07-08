package Login;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginTest {

	WebDriver driver = new ChromeDriver();

	String theWebSite = "https://automationteststore.com/";

	@BeforeTest()
	public void mysetup() {

		driver.get(theWebSite);

		driver.manage().window().maximize();

	}

	@Test()

	public void mytestthefrom() throws InterruptedException {

		Random rand = new Random();

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
		String loginname = ("yazankh122");
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

		loginName.sendKeys(loginname);
		Password.sendKeys(password);
		PasswordConfirm.sendKeys(password);
		Subscribe.click();
		Agreebutton.click();

		ContinueButton.click();
		Thread.sleep(7000);

	}

	@AfterTest
	public void closingTheBrowser() {

		driver.close();

	}
}
