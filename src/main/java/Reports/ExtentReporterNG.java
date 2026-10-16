package Reports;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ExtentReporterNG {

    public static ExtentReports getReportObject(){
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));
        String path = System.getProperty("user.dir")
                + File.separator + "reports"
                + File.separator + "index_" + timestamp + ".html";
        //String path=System.getProperty("user.dir")+"\\reports\\index.html";

        ExtentSparkReporter reporter=new ExtentSparkReporter(path);
        reporter.config().setReportName("Test Automation Results");
        reporter.config().setDocumentTitle("Test Results");

        ExtentReports extent=new ExtentReports();
        extent.attachReporter(reporter);
        extent.setSystemInfo("Tester", "Babasaheb Chavhan");
        return extent;

    }
}
