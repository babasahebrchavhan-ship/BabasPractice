
package Reports;
import java.io.File;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import Base.Class.BaseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ExtentReport extends BaseTest {
    ExtentReports extent;

    @BeforeTest
    public void config()
    {

        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));
        String path = System.getProperty("user.dir")
                + File.separator + "reports"
                + File.separator + "Report" + timestamp + ".html";

        //String path=System.getProperty("user.dir")+"\\reports\\index.html";
        ExtentSparkReporter reporter=new ExtentSparkReporter(path);
        reporter.config().setReportName("Test Automation Results");
        reporter.config().setDocumentTitle("Test Results");

        extent=new ExtentReports();
        extent.attachReporter(reporter);
        extent.setSystemInfo("Tester", "Babasaheb Chavhan");

    }
    @Test(retryAnalyzer = Utility.Retry.class)
    public void InitialDemo() {

        ExtentTest test = null;
        try {
            test = extent.createTest("InitialDemo");
            //   System.setProperty("webdriver.chrome.driver","E:\\Java\\Program\\chromedriver.exe");
            // WebDriver driver=new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

            driver.get("https://www.google.in/");
            String getTitle = driver.getTitle();
            System.out.println("Page Title of Google Page: " + getTitle);
            Assert.assertEquals(getTitle, "Google");
            // if reached, mark pass
            test.pass("Title matched: " + getTitle);
        } catch (AssertionError ae) {
            // log assertion failures to extent and rethrow to keep test failing
            test.fail("Assertion failed: " + ae.getMessage());
            throw ae;
        } catch (Exception e) {
            // log unexpected exceptions to extent and rethrow
            test.fail(e);
            throw new RuntimeException(e);
        } finally {

            extent.flush();
        }

    }

    @Test(retryAnalyzer = Utility.Retry.class)
    public void TestMethod1()
    {
        extent.createTest("method1");
        System.out.println("My Method1");

        extent.flush();
    }

}
