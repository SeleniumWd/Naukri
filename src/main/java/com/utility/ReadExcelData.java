package com.utility;

import java.io.File;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelData {
	static String formatCellValue;
	
 public static String	readParticularData(int rowvalue,int column) {
	 String formatCellValue = null;
	 try {
		 File file = new File( "C:\\Users\\GOWTHAM M\\OneDrive\\Desktop\\DataDriven_testData.xlsx");
		 
		 Workbook book = new XSSFWorkbook(file);
		 Sheet sheet = book.getSheet("Sheet1");
		 Row row = sheet.getRow(rowvalue);
		 Cell cell = row.getCell(column);
		 
		 //--> Formate the data
         DataFormatter formatter = new DataFormatter()	;
          formatCellValue = formatter.formatCellValue(cell);
          
		
		
	} catch (Exception e) {
		e.printStackTrace();
	}
	return formatCellValue;
	 
		
	}
 

}
