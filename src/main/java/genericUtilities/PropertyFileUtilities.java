package genericUtilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
/**
 * The Class contains of reusable methods related to property file
 * @author Ganendra
 *
 */
public class PropertyFileUtilities{
	/**
	 * This method read data from properties file and return the value to caller
	 * @param key
	 * @return value
	 * @throws IOException
	 */
	public String readDataFromPropertyFile(String key) throws IOException {
		FileInputStream fisp = new FileInputStream(".\\src\\test\\resources\\CommonData.propertices");
		Properties p = new Properties();
		p.load(fisp);
		String value = p.getProperty(key);
		return value;
		
	}

}
