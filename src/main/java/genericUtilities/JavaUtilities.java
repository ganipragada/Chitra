package genericUtilities;

import java.util.Date;

public class JavaUtilities {
	public String getSystemDate() {
		Date d = new Date();
		String[] sDate = d.toString().split(" ");
		String date = sDate[2] + "_" + sDate[1] + "_" + sDate[5] + " " + sDate[3].replace(":", "_");
		return  date;
	}

}
