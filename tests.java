import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import org.json.JSONException;
import org.junit.jupiter.api.Test;

class tests {

	@Test
	void testJSONReadWrite() {
		
		//create a new options object and change the location locally
		Options o = new Options();
		o.setLocation("New location!");
		
		//write the new location to the json file
		try {
			o.writeJSON("H:\\SCHOOLWORK\\SeniorProject\\DesktopApp\\Senior Project Desktop App\\src\\configuration.json");
		} catch (JSONException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//change the location locally
		o.setLocation("Doubly new location!");
		
		//read the json file and set values from the file
		try {
			o.readJSON("H:\\SCHOOLWORK\\SeniorProject\\DesktopApp\\Senior Project Desktop App\\src\\configuration.json");
		} catch (JSONException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//the new value for the location should be changed to the original
		//this should be the value read from the json file
		assertEquals("New location!", o.getLocation());
	}

}
