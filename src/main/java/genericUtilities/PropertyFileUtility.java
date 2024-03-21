package genericUtilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/** 
 * This a class consists of generic methods to use property file
 * @author reshma
 */

public class PropertyFileUtility {
	
	/**
	 * This method read data from property file and return the value to caller method
	 * 
	 * @param key
	 * @return
	 * @throws IOException
	 */

	public String readDataFromPropertyFile(String key) throws IOException  {
		
		FileInputStream fis= new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		Properties p= new Properties();
		p.load(fis);
		String value = p.getProperty(key);
		return value;
		
	}
}
