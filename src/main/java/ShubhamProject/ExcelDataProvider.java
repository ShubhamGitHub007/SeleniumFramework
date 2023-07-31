package ShubhamProject;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataProvider {
	XSSFWorkbook wb;
	
	public ExcelDataProvider()
	{
		File src = new File("./TestData/Data.xlsx");
		try {
			FileInputStream fis = new FileInputStream(src);
			wb=new XSSFWorkbook(fis);
		
		} catch (Exception e) {
			System.out.println("Cannot read excel: "+ e.getMessage());
			
		}
		
		
	}
	
	public String getStringData(int sheetIndex,int row,int column) {
		return wb.getSheetAt(sheetIndex).getRow(row).getCell(column).getStringCellValue();
		
	}
	
	public String getStringData(String sheetName,int row,int column) {
		return wb.getSheet(sheetName).getRow(row).getCell(column).getStringCellValue();
		
	}
	
	public double getNumericData(String sheetName,int row,int column) {
		return wb.getSheet(sheetName).getRow(row).getCell(column).getNumericCellValue();
	}
		
	public void writeDataFromExcel(int rowcount,int columncount,String Sheetname,String value)
	{
	    try
	    {
	    	File src = new File("./TestData/Data.xlsx");
	        FileInputStream input=new FileInputStream(src);
	        XSSFWorkbook wb=new XSSFWorkbook(input);
	        XSSFSheet sh=wb.getSheet(Sheetname);
	        XSSFRow row=sh.getRow(rowcount);
	        FileOutputStream webdata=new FileOutputStream(src);
	        row.createCell(columncount).setCellValue(value);
	        wb.write(webdata);
	        webdata.close();

	    }
	    catch(Exception e)
	    {

	    }
	}
	


		}


