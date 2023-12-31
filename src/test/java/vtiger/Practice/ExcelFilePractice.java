package vtiger.Practice;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelFilePractice {

	public static void main(String[] args) throws IOException {
		
		//Step 1: load the file in java readable format
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		
		//Step 2: create workbook
		Workbook wb = WorkbookFactory.create(fis);

		//Step 3: get control over sheet
		Sheet sheet = wb.getSheet("Organization");
		
		//Step 4: get control over row
		Row rw = sheet.getRow(1);
		
		//Step 5: get control over cell
		Cell ce = rw.getCell(2);
		
		//Step 5: read the data inside the cell
		String value = ce.getStringCellValue();
		System.out.println(value);
		

	}

}
