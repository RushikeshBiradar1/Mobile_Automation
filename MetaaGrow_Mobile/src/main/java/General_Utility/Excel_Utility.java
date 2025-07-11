package General_Utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excel_Utility {
	
	public String ReadDataFromExcel(String ExcelPath, String sheetName, int rowcount, int cellcount) throws Throwable
	{
		FileInputStream fis = new FileInputStream(ExcelPath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		Row row = sh.getRow(rowcount);
		Cell cell = row.getCell(cellcount);
		String value = cell.getStringCellValue();
		return value;
		
	}
	
	public void CreateDataInExcel(String excelPath, String sheetName, int rowcount, int cellcount, String string) throws Throwable
	{
		FileInputStream fis = new FileInputStream(excelPath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.createSheet();
		Row row = sh.createRow(cellcount);
		Cell cell = row.createCell(cellcount);
		cell.setCellValue(string);
		
		FileOutputStream fos = new FileOutputStream(excelPath);
		wb.write(fos);
	}
	public int getLastRowcountFromExcel(String sheetName, String ExcelPath) throws Throwable
	{
		FileInputStream fis = new FileInputStream(ExcelPath);
		Workbook book = WorkbookFactory.create(fis);
		Sheet sh = book.getSheet(sheetName);
		int lastRowCount = sh.getLastRowNum();
		return lastRowCount;
		
	}
	public void setCellColor(int rowNum, int cellNum, IndexedColors color, String ExcelPath, String sheetName) throws Throwable, IOException {
		FileInputStream fis = new FileInputStream(ExcelPath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
        Row row = sh.getRow(rowNum);
        if (row == null) {
            row = sh.createRow(rowNum);
        }
        Cell cell = row.getCell(cellNum);
        if (cell == null) {
            cell = row.createCell(cellNum);
        }
        CellStyle style = wb.createCellStyle();
        style.setFillForegroundColor(color.getIndex());
        style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        cell.setCellStyle(style);
    }
}