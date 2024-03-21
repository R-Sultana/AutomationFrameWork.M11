package practice;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataFromExcel {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		//step1:open the doc in java format
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		
		//step2:create a workbook
		Workbook wb = WorkbookFactory.create(fis);
		
		//step3: navigate to required sheet
		Sheet sh = wb.getSheet("contacts");
		
		//step4: navigate to required row
		Row r=sh.getRow(1);
		
		//step5: navigate to required cell
		Cell c = r.getCell(2);
		
		//step6: capture data from cell
		String data = c.getStringCellValue();
		System.out.println(data);

	}

}
