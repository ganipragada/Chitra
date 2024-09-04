package genericUtilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * The Class contains of reusable methods related to excel file
 * 
 * @author Ganendra
 *
 */

public class ExcelFileUtilities { 
	/**
	 * 
	 * @param sheet
	 * @param row
	 * @param cel
	 * @return value
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public String readDataFromExcelFile(String sheet, int row, int cel) throws EncryptedDocumentException, IOException {
		FileInputStream fuse = new FileInputStream(".\\src\\test\\resources\\testData.xlsx");
		Workbook wb = WorkbookFactory.create(fuse);
		String value = wb.getSheet(sheet).getRow(row).getCell(cel).getStringCellValue();
		return value;

	}

}
