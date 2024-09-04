package practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadDataFromPropertyFileTest {

	public static void main(String[] args) throws IOException {
		// open the document in java readable format
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\CommonData.propertices");
		//Create object of properties class from java.util
		Properties p = new Properties();
		//load the file input stream to properties class
		p.load(fis);
		//provide key and read the file 
		String url = p.getProperty("url");
		System.out.println(url);
	}

}
