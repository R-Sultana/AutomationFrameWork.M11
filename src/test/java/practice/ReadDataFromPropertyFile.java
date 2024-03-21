package practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadDataFromPropertyFile {

	public static void main(String[] args) throws IOException {
		
		//step1:open the document in java readable format
		FileInputStream fis= new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		
		//step2:create object of properties class from java.util
		Properties p = new Properties();
		
		//step3:load the document in properties class
		p.load(fis);
		
		//step4:provide the key and fetch data from property file
		String val1= p.getProperty("url");
		System.out.println(val1);
		
		String val2= p.getProperty("username");
		System.out.println(val2);

	}

}
