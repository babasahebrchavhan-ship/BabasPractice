// java
package Utility;

import Base.Class.BaseTest;
import Reports.ExtentReporterNG;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.MediaEntityBuilder;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestNGListeners implements ITestListener {
    ExtentTest test;
    ExtentReports extent = ExtentReporterNG.getReportObject();
    private static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();

    @Override
    public void onTestStart(ITestResult result) {
        test = extent.createTest(result.getMethod().getMethodName());
        extentTest.set(test);
        System.out.println("Test started: " + result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        extentTest.get().log(Status.PASS, "Test Passed");
        System.out.println("Test passed: " + result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("Test failed: " + result.getName());
        extentTest.get().fail(result.getThrowable());

        try {
            String filePath = Utilities.getScreenshot(result.getMethod().getMethodName(), BaseTest.getDriver());
            extentTest.get().addScreenCaptureFromPath(filePath,result.getMethod().getMethodName());

            if (filePath != null) {
                extentTest.get().fail("Screenshot on Failure",
                        MediaEntityBuilder.createScreenCaptureFromPath(filePath).build());
                test.addScreenCaptureFromPath(filePath);
                extent.flush();

            } else {
                extentTest.get().warning("Screenshot not available (driver null or session closed).");
            }
        } catch (Exception e) {
            extentTest.get().warning("Failed to attach screenshot: " + e.getMessage());
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        extentTest.get().log(Status.SKIP, "Test Skipped");
        System.out.println("Test skipped: " + result.getName());
    }

    @Override
    public void onStart(ITestContext context) {
        System.out.println("Test execution started: " + context.getName());
    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.println("Test execution finished: " + context.getName());
        extent.flush();
        try {
            BaseTest.quitDriver();
        } catch (Exception e) {
            System.err.println("Error quitting driver in listener onFinish: " + e.getMessage());
        }
    }
}
