package Flipkart.MavenJava;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ExcelSheet {

	
	public ArrayList<String> getData(String testcasename) throws IOException {
		
		ArrayList<String> a = new ArrayList<String>();
		
		//Path of the excel file
		FileInputStream fis = new FileInputStream("C:\\Documents\\Book1.xlsx");
		
		//Creating a workbook
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		
		
		int sheets = workbook.getNumberOfSheets();
		System.out.println(sheets);
		
		for(int i=0;i<sheets;i++ ) {
			
			if(workbook.getSheetName(i).equalsIgnoreCase("TestData"))
			{
				XSSFSheet sheet=workbook.getSheetAt(i);
				//Identify TestCases column by scanning the entire first row using Iterator
				Iterator<Row> rows= sheet.iterator(); //Sheet is collection of rows
				Row firstrow= rows.next();
				
			Iterator<Cell> cells=	firstrow.cellIterator(); //row is collection on cell
			
			int k=0;  //Fetching column index
			int column = 0;  //Fetching column index
			
			while(cells.hasNext()) {
				
			Cell	value =cells.next();
			if(value.getStringCellValue().equalsIgnoreCase("TestCases")) 
			{
				
				column =k; //Fetching column index
				
				
				
			}
			k++;  //Fetching column index
			
			}
			System.out.println("index of TestCases column = " +column);
				
		    //Once column is identified then scan entire column to identify purchase TestCases row
			while(rows.hasNext())
			{
			
				Row r=rows.next();
				if(r.getCell(column).getStringCellValue().equalsIgnoreCase(testcasename))
				{
					
					//After you grab purchase row, pull all the data of the row and feed into test
					Iterator<Cell> cellvalue =r.cellIterator();
					while(cellvalue.hasNext())
					{
						
						
						Cell cv= cellvalue.next();
						if(cv.getCellType()==CellType.STRING) 
						{
						a.add(cv.getStringCellValue());
						}
						else {
							
						a.add(NumberToTextConverter.toText(cv.getNumericCellValue()));
							
							
							
						}
							
					}
					
					
					
				}
			}
			
			
			}
			
			}
			
		return a;
			
			
		}
		
	
	
	}
	



;