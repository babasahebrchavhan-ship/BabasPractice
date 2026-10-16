package Utility;

import Base.Class.BaseTest;
import Reports.ExtentReport;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(Utility.TestNGListeners.class)
public class EmployeeTest extends ExtentReport {
    ExtentTest test = null;
    ExtentReports extent=null;

      //extent.createTest("EmployeeTest");

        @DataProvider(name = "employeeData")
    public Object[][] getData() throws Exception {
        return ExcelUtils.getExcelData("one");
    }

    @Test(dataProvider = "employeeData", dataProviderClass = DataProviderClass.class,groups = "emp")
    public void testEmployeeData(String firstName,String lastName,String location,int experience) 
    {

        System.out.println("First Name : " + firstName);
        System.out.println("Last Name  : " + lastName);
        System.out.println("Location   : " + location);
        System.out.println("Experience : " + experience);
        System.out.println("----------------------------------");
    }
}