package utlilties;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.plaf.synth.SynthOptionPaneUI;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadXLSdata {
	
	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		ReadXLSdata red = new ReadXLSdata() ;
		List<Map<String, String>> testData = red.getData("Sheet1") ;
		for(Map<String, String> row : testData) {
		System.out.println(row) ;
		}
		//red.getData("Sheet1") ;
	} 
	
	// @DataProvider(name = "pyprogramdata")
	//public String[][] getData(String excelSheetName) throws EncryptedDocumentException, IOException
	public List<Map<String, String>> getData(String excelSheetName) throws EncryptedDocumentException, IOException
	{
		
		File f = new File(System.getProperty("user.dir") + "/src/test/resources/test-data/test-data.xlsx") ;
		FileInputStream fis = new FileInputStream(f) ;
		Workbook wb = WorkbookFactory.create(fis) ;
		Sheet sheetName = wb.getSheet(excelSheetName) ;
		
		int totalRows = sheetName.getLastRowNum() ;
		System.out.println(totalRows);
		Row rowCells = sheetName.getRow(0) ;
		int totalCols = rowCells.getLastCellNum() ;
		System.out.println(totalCols);
		
		DataFormatter format = new DataFormatter() ;
		
		//String testData[][] = new String[totalRows][totalCols] ;
		List<Map<String, String>> testDataList = new ArrayList<>() ;
		for(int i=1; i<=totalRows; i++) {
			Row currentRow = sheetName.getRow(i) ;
			Map<String, String> rowData = new HashMap<>() ;
			
			for(int j=0; j<totalCols; j++) {
				//testData[i-1][j] = format.formatCellValue(sheetName.getRow(i).getCell(j)) ;
				String columnName = format.formatCellValue(rowCells.getCell(j)) ;
				String cellValue = format.formatCellValue(currentRow.getCell(j)) ;
				rowData.put(columnName, cellValue) ;
				//System.out.println(columnName + ": " + cellValue);
				//System.out.println(testData[i-1][j]);
			}
			 testDataList.add(rowData) ;
			 //System.out.println(rowData);
		}
		 
		return testDataList ;
	}
	
	
}
