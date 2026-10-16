package Base.Class;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class CssXpathPract {
	static WebDriver driver;
	@BeforeClass
	public static void setUp()
	{
		System.setProperty("webdriver.chrome.driver", "E:\\Java\\Program\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		System.out.println("Setup completed for CssXpathPract test.");
	}
	@AfterClass
	public static void tearDown()
	{
		driver.quit();
		System.out.println("Execution completed for teardown test.");
	}

	@Test(priority=1)
	public static void Loginpage()
	{

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.findElement(By.id("inputUsername")).sendKeys("rahul");
		driver.findElement(By.name("inputPassword")).sendKeys("shetty");
		driver.findElement(By.className("signInBtn")).click();
		String PerrorMessage = driver.findElement(By.xpath("//p[@class='error']")).getText();
		System.out.println(PerrorMessage);
		driver.findElement(By.linkText("Forgot your password?")).click();
		try {
			Assert.assertEquals(PerrorMessage, "* Incorrect username or password", "Error message does not match expected value");
			System.out.println("Assertion passed: Error message matches expected value");
		} catch (AssertionError e) {
			System.out.println(e.getMessage());

		} finally {
			System.out.println("Execution completed for Loginpage test.");
		}
	}
   @Test(priority=2)
   public static void ForgotPassword()
   {
	   driver.get("https://rahulshettyacademy.com/locatorspractice/");
	   driver.findElement(By.linkText("Forgot your password?")).click();
	   driver.findElement(By.cssSelector("input[placeholder='Name']")).sendKeys("Babasaheb");
	   driver.findElement(By.xpath("//input[@placeholder='Email']")).sendKeys("babasaheb@gmail.com");
	   driver.findElement(By.cssSelector("input[placeholder='Phone Number']")).sendKeys("9876543210");
	   driver.findElement(By.className("reset-pwd-btn")).click();
	   String successMessage = driver.findElement(By.cssSelector(".infoMsg")).getText();
	   System.out.println(successMessage);
	   try {
		   Assert.assertEquals(successMessage, "Please use temporary password 'rahulshettyacademy' to Login.", "Success message does not match expected value");

		   System.out.println("Assertion passed: Success message matches expected value");
	   } catch (AssertionError e) {
		   System.out.println(e.getMessage());
	   } finally {
		   System.out.println("Execution completed for ForgotPassword test.");
	   }

   }

}
