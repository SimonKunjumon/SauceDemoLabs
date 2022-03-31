package com.saucelabs.excelutility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility 
{ 
	private static XSSFWorkbook excelWBook;
	private static XSSFSheet excelWsheet;
	
	public static String getCellData(int RowNum, int ColNum) throws IOException
	{
		FileInputStream ExcelFile = new FileInputStream(System.getProperty("user.dir") + "/src/main/resources" + "/TestDatas.xlsx");
		excelWBook = new XSSFWorkbook(ExcelFile);
		excelWsheet = excelWBook.getSheetAt(0);
		DataFormatter formatter = new DataFormatter();
		String data = formatter.formatCellValue(excelWsheet.getRow(RowNum).getCell(ColNum)); 
		return data;
		
     }

}
