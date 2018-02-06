package knoesis.org.export.sleeps;

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
import java.util.Properties;

import knoesis.org.utils.ConversionManagement;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class ExportSleeps

{
	public static void main(String[] args) throws IOException {
		// Timestamp Conversion Functions
		ConversionManagement conversion = new ConversionManagement();
		//Properties file reader class
		PropertiesReader pr = new PropertiesReader();
		Properties prop = pr.getProperties();
		String start = prop.getProperty("start_time");

		String end = prop.getProperty("end_time");

		
		String url = "https://www.jawbone.com/nudge/api/v.1.1/users/@me/sleeps";

		URL request = new URL(url);

		HttpURLConnection con = (HttpURLConnection) request.openConnection();
		// This code is got via the Authorization Procedure Given by
		// Jawbone Authentication, Goto https://jawbone.com/up/developer/authentication for detailed information(Must Read)
		con.setRequestProperty(
        					"Authorization",
        					"Bearer <AUTHORIZATION_TOKEN>");
		con.setRequestProperty("start_time",
				conversion.convertToEpoch(start, 1));

		con.setRequestProperty("end_time", conversion.convertToEpoch(end, 1));

		con.setRequestProperty("accept", "application/json");

		BufferedReader br = new BufferedReader(new InputStreamReader(
				con.getInputStream()));
		String strTemp = "";
		String str = "";
		while (null != (strTemp = br.readLine())) {
			System.out.println(strTemp);
			str = str + strTemp;

		}
		//Using GSON parser to parse the response string
		JsonParser parser = new JsonParser();

		JsonObject o = (JsonObject) parser.parse(str);
		JsonArray ja = o.get("data").getAsJsonObject().get("items")
				.getAsJsonArray();
		// o = o.get("data").getAsJsonObject();
		// System.out.println(ja);

		File fout = new File("Dementia_Subject_Sleeps" + start.replace("/", "")
				+ "_" + end.replace("/", "") + ".csv");
		FileOutputStream fos = new FileOutputStream(fout);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
		try {
			bw.write("Time_Updated,XID,Title,Time_Created,Time_completed,Body,Sound sleep,TimeZone,Awakenings,Light sleep,Mind,Asleep Time,Awake,Reminder,Duration,Smart Alarm Fire,Quality,Awake Time,Sunrise,Sunset");
			bw.newLine();
			for (int i = 0; i < ja.size(); i++) {
				//Serializing using a Sleep Class
				Sleep sleep = new Sleep(ja.get(i).getAsJsonObject()
						.get("time_created").getAsLong(), ja.get(i)
						.getAsJsonObject().get("xid").toString(), ja.get(i)
						.getAsJsonObject().get("title").toString(), ja.get(i)
						.getAsJsonObject().get("time_created").getAsLong(), ja
						.get(i).getAsJsonObject().get("time_completed")
						.getAsLong(), ja.get(i).getAsJsonObject()
						.get("details").getAsJsonObject().get("body")
						.getAsLong(), ja.get(i).getAsJsonObject()
						.get("details").getAsJsonObject().get("sound")
						.getAsLong(), ja.get(i).getAsJsonObject()
						.get("details").getAsJsonObject().get("tz").toString(),
						ja.get(i).getAsJsonObject().get("details")
								.getAsJsonObject().get("awakenings")
								.getAsLong(), ja.get(i).getAsJsonObject()
								.get("details").getAsJsonObject().get("light")
								.getAsLong(), ja.get(i).getAsJsonObject()
								.get("details").getAsJsonObject().get("mind")
								.getAsLong(), ja.get(i).getAsJsonObject()
								.get("details").getAsJsonObject()
								.get("asleep_time").getAsLong(), ja.get(i)
								.getAsJsonObject().get("details")
								.getAsJsonObject().get("awake").getAsLong(), ja
								.get(i).getAsJsonObject().get("details")
								.getAsJsonObject().get("rem").getAsLong(), ja
								.get(i).getAsJsonObject().get("details")
								.getAsJsonObject().get("duration").getAsLong(),
						ja.get(i).getAsJsonObject().get("details")
								.getAsJsonObject().get("smart_alarm_fire")
								.getAsLong(), ja.get(i).getAsJsonObject()
								.get("details").getAsJsonObject()
								.get("quality").getAsLong(), ja.get(i)
								.getAsJsonObject().get("details")
								.getAsJsonObject().get("awake_time")
								.getAsLong(), ja.get(i).getAsJsonObject()
								.get("date").toString(), ja.get(i)
								.getAsJsonObject().get("details")
								.getAsJsonObject().get("sunrise").getAsLong(),
						ja.get(i).getAsJsonObject().get("details")
								.getAsJsonObject().get("sunset").getAsLong());
				//Writing as each row to a csv file
				bw.write(conversion.convertFromEpoch(sleep.getTime_updated())
						+ ","
						+ sleep.getXid()
						+ ","
						+ sleep.getTitle()
						+ ","
						+ conversion.convertFromEpoch(sleep.getTime_created())
						+ ","
						+ conversion.convertFromEpoch(sleep.getTime_completed())
						+ "," + sleep.getBody() + ","
						+ conversion.convertToDateTime(sleep.getSound()) + ","
						+ sleep.getTz() + "," + sleep.getAwakenings() + ","
						+ conversion.convertToDateTime(sleep.getLight()) + ","
						+ sleep.getMind() + ","
						+ conversion.convertFromEpoch(sleep.getAsleep_time())
						+ "," + conversion.convertToDateTime(sleep.getAwake())
						+ "," + sleep.getRem() + ","
						+ conversion.convertToDateTime(sleep.getDuration())
						+ "," + sleep.getSmart_alarm_fire() + ","
						+ sleep.getQuality() + ","
						+ conversion.convertFromEpoch(sleep.getAwake_time())
						+ "," + sleep.getSunrise() + "," + sleep.getSunset());
				bw.newLine();
			}
			System.out.println("Successfully saved to a .CSV file");

		} catch (IOException e) {
			e.printStackTrace();

		} finally {
			//Closing the bufferwriter
			bw.close();
		}

	}

}
