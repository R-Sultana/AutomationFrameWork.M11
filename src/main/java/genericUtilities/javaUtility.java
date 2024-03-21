package genericUtilities;

import java.text.SimpleDateFormat;
import java.util.Date;
/**
 * The method returns current date format
 */
public class javaUtility {

	public String getDate() {
		Date d = new Date();
		SimpleDateFormat f = new SimpleDateFormat("dd-MM-yy hh-mm-ss");
		String date = f.format(d);
		return date;
	}
	

}
