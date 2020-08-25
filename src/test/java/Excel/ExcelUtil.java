package Excel;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtil {
	
	
	
		public static String readEXcel(String sheetname, String colname) throws Exception {
			
			XSSFWorkbook ExcelWBook;
			XSSFSheet ExcelWSheet;
		
//set excel path			
		String path = "C:\\QE\\Cucmberframework\\src\\test\\resources\\Testdata.xlsx";
		
//Create an object of FileInputStream class to read excel file
		FileInputStream ExcelFile = new FileInputStream(path);
		
// Access the required test data sheet
		 ExcelWBook =new XSSFWorkbook(ExcelFile);
//Read sheet inside the workbook by its name
		 ExcelWSheet = ExcelWBook.getSheet(sheetname);
//http://www.qamantra.com/2018/01/how-to-read-data-from-excel-using.html
// it will take value from first row
		 Row row = ExcelWSheet.getRow(0);
		 int lastcolumnused = row.getLastCellNum();
		 System.out.println(lastcolumnused);
		 int colnum = 0;
		  for (int i = 0; i < lastcolumnused; i++) {
		   if (row.getCell(i).getStringCellValue().equalsIgnoreCase(colname)) {
		    colnum = i;
		    break;
		   }
		  }
		  row = ExcelWSheet.getRow(1);
		  Cell column = row.getCell(colnum);
		  String CellValue = column.getStringCellValue();
		  return CellValue;
	}

}
