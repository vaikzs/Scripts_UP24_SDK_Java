package knoesis.org.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class ConversionManagement {

	// Function to convert seconds to Date Timestamp
		public String convertToDateTime(long second) {
			long millis = second * 1000;
			SimpleDateFormat df = new SimpleDateFormat("HH:mm:ss");
			df.setTimeZone(TimeZone.getTimeZone("UTC"));
			Date date = new Date(millis);
			return df.format(date);

		}

		// Function to convert Date Timestamp to Epoch Timestamp
		public String convertToEpoch(String time, int choice) {
			SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

			df.setTimeZone(TimeZone.getTimeZone("America/New_York"));
			if (choice == 1)
				time = time + " 00:00:00";

			Date date = null;

			try {
				date = df.parse(time);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			long epoch = date.getTime();
			// System.out.println(epoch);
			return epoch + "";

		}

		// Function to convert Epoch Timestamp to Date Timestamp
		public String convertFromEpoch(long etime) {
			SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
			df.setTimeZone(TimeZone.getTimeZone("America/New_York"));
			Date d = new Date(etime * 1000);
			return df.format(d);
		}
		
	
	
}
