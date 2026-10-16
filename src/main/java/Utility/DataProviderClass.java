package Utility;

import org.testng.annotations.DataProvider;

public class DataProviderClass {

    @DataProvider(name = "employeeData")
    public Object[][] getData() throws Exception {
        return ExcelUtils.getExcelData("one");
    }
}