// java
package Base.Class;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterSuite;

public class BaseTest {
    public static WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        if (driver == null) {
            System.setProperty("webdriver.chrome.driver", "E:\\Java\\Program\\chromedriver.exe");
            driver = new ChromeDriver();

        }
    }

    // safe, idempotent quit helper
    public static void quitDriver() {
        if (driver != null) {
            try {
                driver.quit();
            } catch (Exception e) {
                System.err.println("Exception while quitting driver: " + e.getMessage());
            } finally {
                driver = null;
            }
        }
    }

    @AfterSuite(alwaysRun = true)
    public void afterSuite() {
       // quitDriver();
    }

    public static WebDriver getDriver() {
        return driver;
    }
}
