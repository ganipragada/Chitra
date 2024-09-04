package practice;

import java.io.IOException;

import genericUtilities.*;

public class GenericUtilityPracticeTest {

	public static void main(String[] args) throws IOException {
		PropertyFileUtilities pUtil =  new PropertyFileUtilities();
	String value = pUtil.readDataFromPropertyFile("url");
	System.out.println(value);
	
	ExcelFileUtilities eUtil = new ExcelFileUtilities();
	String lastName = eUtil.readDataFromExcelFile("Contacts",1, 2);
	System.out.println(lastName);
	
	JavaUtilities ju = new JavaUtilities();
	System.out.println(ju.getSystemDate());
	
	}

}
