package Test;

import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.io.IOException;
import static Utility.ClearScreenshotFolder.clearScreenshotFolder;
import static Utility.Screenshots.takeScreenshot;

public class TestNGTest  {
  private WebDriver driver;

    @BeforeSuite
    public void setUp() {
        //System.setProperty("webdriver.chrome.driver","E:\\Webdriver\\chromedriver.exe");
        WebDriverManager.chromedriver().setup();
         driver = new ChromeDriver();
    }

    @Test(invocationCount = 1)
    public void TakeSS() throws IOException {
        driver.get("https://www.google.com");
        takeScreenshot("test", driver);
    }
    @Test
    public void clearScreenshotFolder1() throws IOException {
       clearScreenshotFolder();
    }

    @AfterSuite
    public void tearDown() {
        if(driver != null) {
            driver.close();
        }
    }
}