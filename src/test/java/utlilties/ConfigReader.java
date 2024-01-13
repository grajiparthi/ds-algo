package utlilties;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
	
private Properties prop;
	
	public Properties init_prop() {
		prop = new Properties();
		try {
		FileInputStream ip;
			ip = new FileInputStream("./src/test/resources/Config/config.properties");
			prop.load(ip);
			System.out.println("I am here....");
		} catch (FileNotFoundException e) {
			System.out.println("I am here....");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("I am here....");
			e.printStackTrace();
		}
				
		return prop;
	}

}
