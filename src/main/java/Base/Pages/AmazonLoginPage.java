package Base.Pages;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;

public class AmazonLoginPage {
    ChromeDriver driver=new ChromeDriver();
/*
    File src1=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
    //FileUtils.copyFile(src, new File("user.dir"+"//src//main//ScreenShots//screenshot.png"));

    FileUtils.copyFile(src1, new void File("user.dir"+"//src//main//ScreenShots//screenshot.png"));
*/
    File src1 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

    File dest = new File(System.getProperty("user.dir")
            + "//src//main//ScreenShots//screenshot.png");
    // FileUtils.copyFile(src1, dest);

}
