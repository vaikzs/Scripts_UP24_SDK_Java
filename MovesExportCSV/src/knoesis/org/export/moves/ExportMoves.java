package knoesis.org.export.moves;

/*
 * Author 
 * Vaikunth Sridharan
 * 
 * 
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Properties;
import java.util.Set;

import knoesis.org.utils.ConversionManagement;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class ExportMoves

{
	public static boolean stringContainsItemFromList(String inputString,ArrayList<String> items) {
		for (int i = 0; i < items.size(); i++) {
			if (inputString.contains(items.get(i))) {
				return true;
			}
		}
		return false;
	}
	
	public static void main(String[] args) throws IOException {
		// Timestamp Conversion Functions
		ConversionManagement conversion = new ConversionManagement();
		// Properties file reader class
		PropertiesReader pr = new PropertiesReader();
		Properties prop = pr.getProperties();

		// Start Time
		String start = prop.getProperty("start_time");

		// End Time
		String end = prop.getProperty("end_time");
		

		// dd/mm/yyyy + HH:mm:ss - Delta Time
		String delta = prop.getProperty("start_time") + " "
				+ prop.getProperty("deltaTime");
		

		long del_delta = (Long.parseLong(conversion.convertToEpoch(delta, 0)) - Long
				.parseLong(conversion.convertToEpoch(start, 1)));

		long i = Long.parseLong(conversion.convertToEpoch(start, 1));
		long e = Long.parseLong(conversion.convertToEpoch(end, 1));

		File fout = new File("Dementia_Subject_Moves" + start.replace("/", "")
				+ "_" + end.replace("/", "") + ".csv");
		FileOutputStream fos = new FileOutputStream(fout);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
		
		ArrayList<Move> mv = new ArrayList<Move>();
		String revS[] = start.split("/");
		String revE[] = end.split("/");
		while (i <= e) {
			
			
			
			String url = "https://jawbone.com/nudge/api/v.1.1/users/@me/moves";

			URL request = new URL(url);

			HttpURLConnection con = (HttpURLConnection) request
					.openConnection();
			// This code is got via the Authorization Procedure Given by
			// Jawbone Authentication, Goto https://jawbone.com/up/developer/authentication for detailed information(Must Read)
			con.setRequestProperty(
					"Authorization",
					"Bearer <AUTHORIZATION_TOKEN>");

			long j = i + del_delta;
		
			System.out.println(revS[2]+revS[1]+revS[0]);
			con.setRequestProperty("date",revS[2]+revS[1]+revS[0]);
			con.setRequestProperty("start_time", i + "");

			con.setRequestProperty("end_time", j + "");
			
			
			

			System.out.println(i + "   " + j);

			BufferedReader br = new BufferedReader(new InputStreamReader(
					con.getInputStream()));
			String strTemp = "";
			String str = "";
			while (null != (strTemp = br.readLine())) {

				str = str + strTemp;
				// System.out.println(strTemp);

			}
			// Using GSON parser to parse the response string
			JsonParser parser = new JsonParser();
			JsonObject o = (JsonObject) parser.parse(str);
			JsonArray ja = o.get("data").getAsJsonObject().get("items")
					.getAsJsonArray();

			for (int k = 0; k < ja.size(); k++) {
				// Serializing using Move Class
				mv.add(new Move(
						ja.get(k).getAsJsonObject().get("time_updated")
						.getAsLong(),
				ja.get(k).getAsJsonObject().get("xid").toString(),
				ja.get(k).getAsJsonObject().get("title").toString(),
				ja.get(k).getAsJsonObject().get("type").toString(),
				ja.get(k).getAsJsonObject().get("time_created")
						.getAsLong(),
				ja.get(k).getAsJsonObject().get("time_completed")
						.getAsLong(),
				ja.get(k).getAsJsonObject().get("details")
						.getAsJsonObject().get("active_time")
						.getAsLong(),
				ja.get(k).getAsJsonObject().get("details")
						.getAsJsonObject().get("inactive_time")
						.getAsLong(),
				ja.get(k).getAsJsonObject().get("details")
						.getAsJsonObject().get("wo_count").getAsLong(),
				ja.get(k).getAsJsonObject().get("details")
						.getAsJsonObject().get("wo_longest")
						.getAsLong(),
				ja.get(k).getAsJsonObject().get("details")
						.getAsJsonObject().get("bmr").getAsDouble(),
				ja.get(k).getAsJsonObject().get("details")
						.getAsJsonObject().get("bg_calories")
						.getAsDouble(),
				ja.get(k).getAsJsonObject().get("details")
						.getAsJsonObject().get("bmr_day").getAsDouble(),
				ja.get(k).getAsJsonObject().get("details")
						.getAsJsonObject().get("wo_active_time")
						.getAsLong(),
				ja.get(k).getAsJsonObject().get("details")
						.getAsJsonObject().get("distance").getAsLong(),
				ja.get(k).getAsJsonObject().get("details")
						.getAsJsonObject().get("tz").toString(),
				ja.get(k).getAsJsonObject().get("details")
						.getAsJsonObject().get("longest_active")
						.getAsLong(),
				ja.get(k).getAsJsonObject().get("details")
						.getAsJsonObject().get("longest_idle")
						.getAsLong(),
				ja.get(k).getAsJsonObject().get("details")
						.getAsJsonObject().get("calories")
						.getAsDouble(),
				ja.get(k).getAsJsonObject().get("details")
						.getAsJsonObject().get("km").getAsDouble(),
				ja.get(k).getAsJsonObject().get("details")
						.getAsJsonObject().get("steps").getAsLong(),
				ja.get(k).getAsJsonObject().get("details")
						.getAsJsonObject().get("wo_calories")
						.getAsDouble(),
				ja.get(k).getAsJsonObject().get("details")
						.getAsJsonObject().get("wo_time").getAsDouble(),
				ja.get(k).getAsJsonObject().get("date").toString()));

				// Writing as each row to a csv file
				
			}

			// Increment for next Query
			i = i + del_delta;
		}
		
		
		
		
		bw.write("XID,Title,Type,Time_Created,Time_completed,Active Time,InActive Time,Workout Count, Workout Longest,Estimated basal metabolic rate at current time,Basal Metabolic Rate Calories(outside the context of a workout),Estimated basal metabolic rate for entire day,Workout Active Time,Distance,Time Zone,Longest Active,Longest Idle,Calories,KM,Steps,Workout Calories,Workout Time,Date");
		bw.newLine();
		i = i/1000;
		//HashSet Removes redundancy
		Set<String> wholeStringCSV = new HashSet<String>();
		
		for(Move eachMove : mv )
		{    
			//Check if start date or end date is equal to the the date the comes as response.
			if(eachMove.getDate_().equals(revS[2]+revS[1]+revS[0])||eachMove.getDate_().equals(revE[2]+revE[1]+revE[0]))
			
			{
			
	     			wholeStringCSV.add(eachMove.getXid() + "," + eachMove.getTitle() + ","
						+ eachMove.getType() + ","
						+ conversion.convertFromEpoch(eachMove.getTime_created())
						+ ","
						+ conversion.convertFromEpoch(eachMove.getTime_completed())
						+ ","
						+ conversion.convertToDateTime(eachMove.getActive_time())
						+ ","
						+ conversion.convertToDateTime(eachMove.getInactive_time())
						+ "," + eachMove.getWo_count() + ","
						+ conversion.convertToDateTime(eachMove.getWo_longest())
						+ "," + eachMove.getBmr() + "," + eachMove.getBg_calories() + ","
						+ eachMove.getBmr_day() + ","
						+ conversion.convertToDateTime(eachMove.getWo_active_time())
						+ "," + eachMove.getDistance() + "," + eachMove.getTz() + ","
						+ conversion.convertToDateTime(eachMove.getLongest_active())
						+ ","
						+ conversion.convertToDateTime(eachMove.getLongest_idle())
						+ "," + eachMove.getCalories() + "," + eachMove.getKm() + ","
						+ eachMove.getSteps() + "," + eachMove.getWo_calories() + ","
						+ eachMove.getWo_time() + "," + eachMove.getDate_());
				}
			
		}
		
		for(String eachrow : wholeStringCSV)
		{
			
			bw.write(eachrow);
			bw.newLine();
			
			
		}
		
		
		
		System.out.println("Successfully saved to a .CSV file");
		bw.close();

	}
}
