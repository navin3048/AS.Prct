package vtiger.GenericUtilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 *  This class consist of generic methods related to excel sheet
 * @author kavya
 *
 */
public class ExcelFileUtility {
	/**
	 * This method will read data from excel sheet
	 * @param sheetName
	 * @param rowNo
	 * @param cellNo
	 * @return
	 * @throws IOException
	 */
	public String readDataFromExcel(String sheetName, int rowNo, int cellNo) throws IOException
	{
		//FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		FileInputStream fis = new FileInputStream(IConstantUtility.excelFilePath);
		Workbook wb = WorkbookFactory.create(fis);
		String value = wb.getSheet(sheetName).getRow(rowNo).getCell(cellNo).getStringCellValue();
		return value;
	}
	
	public void writeDataIntoExcel(String sheetName, int rowNo, int cellNo, String value) throws IOException
	{
		//FileInputStream fis = new FileInputStream("\\src\\test\\resources\\TestData.xlsx");
		FileInputStream fis = new FileInputStream(IConstantUtility.excelFilePath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		Row rw = sh.createRow(rowNo);
		Cell cel = rw.createCell(cellNo);
		cel.setCellValue(value);
		
		//FileOutputStream fos = new FileOutputStream(".\\src\\test\\resources\\TestData.xlsx");
		FileOutputStream fos = new FileOutputStream(IConstantUtility.excelFilePath);
		wb.write(fos);
		wb.close();
	}
	
	public Object[][] readDataFromExcelToDataProvider(String sheetName) throws IOException
	{
		FileInputStream fis = new FileInputStream(IConstantUtility.excelFilePath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		int lastRow = sh.getLastRowNum();
		short lastCell = sh.getRow(0).getLastCellNum();
		
		Object[][] data = new Object[lastRow][lastCell];
		
		for(int i=0;i<lastRow;i++)
		{
			for(int j=0;j<lastCell;j++)
			{
				data[i][j] = sh.getRow(i+1).getCell(j).getStringCellValue();
			}
		}
		
		return data;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
