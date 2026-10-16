package Utility;

import java.io.File;
import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;

public class ExcelUtils {

    public static Object[][] getExcelData(String sheetName) throws Exception {

        String path = "E:\\Test Data\\ExcelOpSel\\files\\empolyees.xlsx";

        FileInputStream fis = new FileInputStream(new File(path));
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet = workbook.getSheet(sheetName);

        int rowCount = sheet.getLastRowNum();           // number of data rows
        int colCount = sheet.getRow(0).getLastCellNum(); // number of columns

        Object[][] data = new Object[rowCount][colCount];

        // Skip header row (row 0)
        for (int i = 1; i <= rowCount; i++) {

            Row row = sheet.getRow(i);

            for (int j = 0; j < colCount; j++) {
                Cell cell = row.getCell(j);

                if (cell == null) {
                    data[i - 1][j] = "";
                    continue;
                }

                switch (cell.getCellType()) {
                    case STRING:
                        data[i - 1][j] = cell.getStringCellValue().trim();
                        break;

                    case NUMERIC:
                        data[i - 1][j] = (int) cell.getNumericCellValue();
                        break;

                    default:
                        data[i - 1][j] = "";
                }
            }
        }

        workbook.close();
        return data;
    }
}