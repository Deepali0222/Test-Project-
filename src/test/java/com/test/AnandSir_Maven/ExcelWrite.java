package com.test.AnandSir_Maven;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelWrite {

	

	public static void main(String[] args) throws IOException {
	
		FileInputStream fis = new FileInputStream("C:\\Selenium\\AutomationData.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet seleniumsheet=workbook.getSheet("Selenium");
		int rowcount = seleniumsheet.getPhysicalNumberOfRows();
		int coloumcount=seleniumsheet.getRow(0).getPhysicalNumberOfCells();
		System.out.println(rowcount);
		System.out.println(coloumcount);
		XSSFRow row =seleniumsheet.getRow(8);
		XSSFCell cell=row.getCell(1);
		System.out.println(cell);
		cell.setCellValue("Successful IT Carrier");
		FileOutputStream fos = new FileOutputStream("C:\\Selenium\\AutomationData.xlsx");
		workbook.write(fos);
		
		
		

	}

}
