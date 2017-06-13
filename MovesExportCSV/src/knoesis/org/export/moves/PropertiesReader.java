package knoesis.org.export.moves;
/*
 * Author 
 * Vaikunth Sridharan
 * 
 * 
 */
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesReader {

	//Loading the .properties file
	public Properties getProperties() throws IOException {
			
		Properties prop = new Properties();
		InputStream input = null; 
		
		try {
			 
			input = new FileInputStream("input.properties");
	 
			// load a properties file
			prop.load(input);
	 
			 
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		
		return prop;
		
		
	}
	
	
	
	
}
