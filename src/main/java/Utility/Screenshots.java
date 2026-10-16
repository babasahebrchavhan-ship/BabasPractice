package Utility;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class Screenshots {
    private static int i = 1;
    public static void takeScreenshot(String screenshotName, WebDriver driver) throws IOException {
        File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String filename = screenshotName + "_" + i +++ "_" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss_SSS")) + ".png";
        FileUtils.copyFile(source, new File(System.getProperty("user.dir") + "/Screenshots/" + filename));
    }
}
