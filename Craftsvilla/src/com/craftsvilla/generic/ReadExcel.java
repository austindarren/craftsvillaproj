package com.craftsvilla.generic;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.Reporter;


public class ReadExcel {

	public static File file= null;
	public static FileInputStream fin = null;
	public static Workbook wb = null;
	public static Sheet sh = null;
	
	public static String[][] getData(String filename, String sheetname){
		
		try
		{
			file = new File(filename);
			fin = new FileInputStream(file);
			wb = new XSSFWorkbook(fin);
			sh = wb.getSheet(sheetname);
		int rownum = sh.getLastRowNum()+1;	
		int cellnum = sh.getRow(0).getLastCellNum();
		
		String[][] data = new String[rownum][cellnum];
		
		for(int i=0;i<rownum;i++)
		{
			Row r = sh.getRow(i);
			for(int j=0;j<cellnum;j++)
			{
				Cell c = r.getCell(j);
				String value = new DataFormatter().formatCellValue(c);
				data[i][j] = value;
				return data;
			}
		}
				
					
		}
		catch(Exception e) {
			Reporter.log("unable to read excel sheet, FAIL");
			return null;
		}
		return null;
	}
	
}
