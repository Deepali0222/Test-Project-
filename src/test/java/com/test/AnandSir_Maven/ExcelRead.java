package com.test.AnandSir_Maven;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelRead {

	

	public static void main(String[] args) throws IOException {
		FileInputStream fis = new FileInputStream("C:\\Selenium\\AutomationData.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet seleniumsheet=workbook.getSheet("Selenium");
		int rowcount = seleniumsheet.getPhysicalNumberOfRows();
		int coloumcount=seleniumsheet.getRow(0).getPhysicalNumberOfCells();
		System.out.println(rowcount);
		System.out.println(coloumcount);
		for(int i=0;i<rowcount;i++) { for(int j=0;j<coloumcount;j++) { String
		cellvalue=seleniumsheet.getRow(i).getCell(j).getStringCellValue();
		System.out.print(cellvalue+" "); } System.out.println(); }
		 
		
		//String cellvalue=seleniumsheet.getRow(8).getCell(1).getStringCellValue();
		//System.out.println(cellvalue);
	}

}
