package Login;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class sadscenarioLogin {

	WebDriver driver = new EdgeDriver();

	String theWebSite = "https://automationteststore.com/";

	@BeforeTest
	public void setup() {

		driver.get(theWebSite);

		driver.manage().window().maximize();
	}

	@Test()

	public void create_Account() throws InterruptedException {

		String[] firstNames = { "ahmad", "ali", "omar", "anas", "zaid" };
		String[] lastNames = { "mahmoud", "jafaar", "rami", "sameer", "tareq" };
		String[] email_account = { "yazan@mail.com", "yazan22@mail.com","yazahhh@1222","yazan@1356" };
		String[] numberPhone = { "y726178461", "33445677", "08965544" };
		String[] faxtel = { "26461", "3677", "0844" , "66655"};
		String[] company = { "Amzon", "Aspire", "Zain", "Orange" };

		Random rand1 = new Random();
		Random rand2 = new Random();
		Random rand3 = new Random();
		Random rand4 = new Random();
		Random rand5 = new Random();
		Random rand6 = new Random();

		int randomFirstNameIndex = rand1.nextInt(firstNames.length);
		int randomLastNameIndex = rand2.nextInt(lastNames.length);
		int randomEmail_accountIndex = rand3.nextInt(lastNames.length);
		int randomNumberphoneIndex = rand4.nextInt(numberPhone.length);
		int randomFaxtelIndex = rand5.nextInt(faxtel.length);
		int randomCompanyIndex = rand6.nextInt(company.length);

		System.out.println(randomFirstNameIndex);
		System.out.println(randomLastNameIndex);
		System.out.println(randomEmail_accountIndex);
		System.out.println(randomNumberphoneIndex);
		System.out.println(randomFaxtelIndex);
		System.out.println(randomCompanyIndex);

		driver.navigate().to("https://automationteststore.com/index.php?rt=account/create");
		Thread.sleep(5000);

		WebElement firstNames1 = driver.findElement(By.id("AccountFrm_firstname"));
		WebElement lastNames1 = driver.findElement(By.id("AccountFrm_lastname"));
		WebElement create_mail = driver.findElement(By.id("AccountFrm_email"));
		WebElement numberPhone1 = driver.findElement(By.id("AccountFrm_telephone"));
		WebElement faxtel1 = driver.findElement(By.id("AccountFrm_fax"));
		WebElement company1 = driver.findElement(By.name("company"));

		firstNames1.sendKeys(firstNames[randomFirstNameIndex]);
		lastNames1.sendKeys(firstNames[randomLastNameIndex]);
		create_mail.sendKeys(email_account[randomEmail_accountIndex]);
		numberPhone1.sendKeys(numberPhone[randomNumberphoneIndex]);
		faxtel1.sendKeys(faxtel[randomFaxtelIndex]);
		company1.sendKeys(company[randomCompanyIndex]);

	}


	@AfterTest
	public void closingTheBrowser() {

		driver.close();

	}
}
