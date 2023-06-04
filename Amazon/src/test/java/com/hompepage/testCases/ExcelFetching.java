package com.hompepage.testCases;

import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelFetching {

	public static void main(String[] args) throws IOException {
		// This line of code will open the workbook
		FileInputStream file = new FileInputStream("C:\\Users\\ASUS\\OneDrive\\Desktop\\New Microsoft Excel Worksheet (3).xlsx");
		//this line of code will read Whole documents
		XSSFWorkbook wb = new XSSFWorkbook(file);
		//Will fetch the data from the particular sheet From instance of XSSFWorkbook
		XSSFSheet sheet = wb.getSheet("Sheet1");
		//Will the records values for the particular Row by using index
		XSSFRow row1 = sheet.getRow(0);
		//Will the records values for the particular Cell from the row by using index
		XSSFCell cell1 = row1.getCell(0);
		// To fetch the data from the selected cell we need to Analyze the datatype of the CellValues in Excel
		String Value = cell1.getStringCellValue();
	    System.out.println(Value);
	    XSSFCell cell2 = row1.getCell(1);
	    String Value2 = cell2.getStringCellValue();
	    System.out.println(Value2);
	}
}
