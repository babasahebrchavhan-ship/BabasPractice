package Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.io.IOException;
import static Utility.ClearScreenshotFolder.clearScreenshotFolder;
import Utility.Screenshots;


public class TestUtilities extends Screenshots {
    public static void main(String[] args) throws IOException {
        System.setProperty("webdriver.chrome.driver","E:\\Webdriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com");
        takeScreenshot("test",driver);
        clearScreenshotFolder();
        driver.close();
    }
}

