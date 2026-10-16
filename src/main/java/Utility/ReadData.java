package Utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.hssf.record.PageBreakRecord.Break;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;


public class ReadData {

	public static void main(String[] args) throws IOException {
	/*	@DataProvider(name="GetExcelData")
		Public Object[][] getData()
		{
			
			 return Object;
		}*/
		String excelPath="E:\\Test Data\\ExcelOpSel\\files\\empolyees.xlsx";
		File excelFile=new File(excelPath);
		FileInputStream fis=new FileInputStream(excelFile);
		XSSFWorkbook workbook=new XSSFWorkbook(fis);
		XSSFSheet sheet=workbook.getSheet("one");
		
		int rows=sheet.getLastRowNum();
		int cols=sheet.getRow(1).getLastCellNum();
		
		for(int r=0;r<=rows;r++)
		{
			
			XSSFRow row=sheet.getRow(r);
			
			for(int c=0;c<cols;c++)
			{
				
				XSSFCell cell=row.getCell(c);
				CellType cellType=cell.getCellType();
				switch(cellType)
				{
				
				case STRING:
					System.out.print(cell.getStringCellValue());
					break;
				case NUMERIC:
					System.out.print(cell.getNumericCellValue());
					break;
				case BOOLEAN:
					System.out.print(cell.getBooleanCellValue());
					break;
					
				}
				System.out.print(" ");
			}
			System.out.println("");
			
		}
		
		
		}

	}

