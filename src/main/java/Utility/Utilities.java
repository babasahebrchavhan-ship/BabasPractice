// java
package Utility;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.NoSuchSessionException;
import org.testng.annotations.Listeners;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Listeners(TestNGListeners.class)
public class Utilities {

    public static String getScreenshot(String name, WebDriver driver) {
        if (driver == null) {
            System.err.println("WebDriver is null - cannot take screenshot");
            return null;
        }
        try {
            TakesScreenshot ts = (TakesScreenshot) driver;
            File src = ts.getScreenshotAs(OutputType.FILE);

            String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));
            Path reportsDir = Path.of(System.getProperty("user.dir"), "reports", "screenshots");
            Files.createDirectories(reportsDir);

            Path dest = reportsDir.resolve(name + "_" + timestamp + ".png");
            Files.copy(src.toPath(), dest);

            return dest.toAbsolutePath().toString();
        } catch (NoSuchSessionException nse) {
            System.err.println("Cannot take screenshot - session closed: " + nse.getMessage());
            return null;
        } catch (IOException | RuntimeException e) {
            e.printStackTrace();
            return null;
        }
    }
}
