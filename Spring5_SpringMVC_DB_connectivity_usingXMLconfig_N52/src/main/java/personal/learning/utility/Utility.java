package personal.learning.utility;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Utility {
	
	public static Date convertDateToDisplayFormat(String cusDob) {
		Date dateOfBirth = null;
		if(cusDob != null) {
			if(!cusDob.equals("")) {
				SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
				try {
					dateOfBirth = formatter.parse(cusDob);
				} catch (ParseException e) {
					System.out.println("Failed to parse date : " + e.getMessage());
					e.printStackTrace();
				} 
			}
		}
		return dateOfBirth;
	}
}
