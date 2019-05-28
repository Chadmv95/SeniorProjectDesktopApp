import java.io.FileReader;
import java.io.FileWriter;
import java.io.Writer;
import java.io.IOException;

import org.json.*;


public class Options {

	//restraints
	private static final int nameMaxLength = 64;
	private static final int locationMaxLength = 256;
	private static final int maxBurstCount = 10;
	private static final int maxTimeBurst = 10; //10 seconds
	private static final int maxTimePowerSaver = 60 * 60; //60 minutes * 60 sec/min
	private static final int maxTimeTrigInt = 20 * 60; //20 minutes * 60 sec/min

	//initiate global settings variables
	private String name; //name of the device
	private String location; //location of the device
	private int burstCount; //number of pictures per burst
	private int timeBurst; //time between pictures during a burst
	private int timePowerSaver; //time until sleep is allowed
	private int timeTrigInt; //time after a burst until another burst is allowed
	

	/*
	 * Default constructor for the class.
	 * Sets default values to global options
	 */
	public Options() {
		name = "Marten Tracker #1";
		location = "Under some tree idk";
		burstCount = 3;				//3 pictures
		timeBurst = 5;				//5 seconds
		timePowerSaver = 30 * 60;	//30 minutes * 60 sec/min
		timeTrigInt = 5 * 60;		//5 minutes  * 60 sec/min
		
	}

	/*
	 * Overloaded constructor to set values to global 
	 * options from the specified JSON formatted file
	 * 
	 * @param f JSON formatted file
	 */
	public Options(String fp) {

			try{
				readJSON(fp);
			} catch(Exception e) {
				System.out.print("Unable to read JSON file at location: ");
				System.out.println(fp);
			}
				

	}

	/*
	 * sets global variables to values read from the file specified
	 * 
	 * @param file JSON formatted file to be read
	 */
	public void readJSON( String fp ) 
			throws IOException, JSONException {

		
		// for now, just set filepath here for testing
		fp = "H:\\SCHOOLWORK\\SeniorProject\\DesktopApp\\Senior Project Desktop App\\src\\configuration.json";
		
		FileReader file = new FileReader(fp);

		JSONTokener tok = new JSONTokener(file);
		JSONObject j = new JSONObject(tok);
		
		//read the file and set local variables
		this.setBurstCount(j.getInt("Burst Count"));
		this.setTimeBurst(j.getInt("Burst Time"));
		this.setTimePowerSaver(j.getInt("Power Saver Timeout"));
		this.setTimeTrigInt(j.getInt("Trigger Interval"));
		this.setName(j.getString("Name"));
		this.setLocation(j.getString("Location"));
		
		file.close(); //don't forget to close it!
	}
	
	/*
	 * This will take the given parameters and write them in JSON format
	 * to the file specified
	 * 
	 * @param fp String of the filepath to the config file
	 */
	public void writeJSON( String fp ) 
			throws IOException, JSONException {
		
		JSONObject j = new JSONObject();
		
		//get local variables and put them in the file with the specified key
		j.put("Burst Count", this.getBurstCount());
		j.put("Burst Time", this.getTimeBurst());
		j.put("Power Saver Timeout", this.getTimePowerSaver());
		j.put("Trigger Interval", this.getTimeTrigInt());
		j.put("Name", this.getName());
		j.put("Location", this.getLocation());

		// for now, just set filepath here for testing
		fp = "H:\\SCHOOLWORK\\SeniorProject\\DesktopApp\\Senior Project Desktop App\\src\\configuration.json";
		
		//open file with filewriter then write the JSONObject
		Writer file = new FileWriter(fp);
		file.write(j.toString());
		file.flush();
		file.close(); //don't forget to close!
		
		System.out.println("\nJSON Object: " + j); //print it out for testing
		
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		if(name.length() >= nameMaxLength || name.length() <= 0)
			new AlertBox("Name length out of bounds",
					"Name must be between 0 and " + nameMaxLength);
		else this.name = name;
	}


	public String getLocation() {
		return location;
	}


	public void setLocation(String location) {
		if(location.length() >= locationMaxLength || location.length() <= 0)
			new AlertBox("Location length out of bounds",
					"Location string must be between 0 and " + nameMaxLength);
		else this.location = location;
	}


	public int getBurstCount() {
		return burstCount;
	}

	public void setBurstCount(int burstCount) {
		if(burstCount > maxBurstCount || burstCount < 0)
			new AlertBox("Burst count out of bounds",
					"Burst count must be less than " + maxBurstCount);
		else this.burstCount = burstCount;
	}


	public int getTimeBurst() {
		return timeBurst;
	}


	public void setTimeBurst(int timeBurst) {
		if(timeBurst > maxTimeBurst || timeBurst < 1)
			new AlertBox("Burst time out of bounds",
					"Burst time must be between 1 and " + maxTimeBurst);
		else this.timeBurst = timeBurst;
	}


	public int getTimePowerSaver() {
		return timePowerSaver;
	}


	public void setTimePowerSaver(int timePowerSaver) {
		if(timePowerSaver > maxTimePowerSaver || timePowerSaver < 60)
			new AlertBox("Power saver timeout out of bounds",
					"Power saver timeout must be between 60 seconds and " + maxTimePowerSaver);
		else this.timePowerSaver = timePowerSaver;
	}


	public int getTimeTrigInt() {
		return timeTrigInt;
	}


	public void setTimeTrigInt(int timeTrigInt) {
		if(timeTrigInt > maxTimeTrigInt || timeTrigInt < 60)
			new AlertBox("Trigger interval out of bounds",
					"Trigger interval must be between 60 seconds and " + maxTimeTrigInt);
		else this.timeTrigInt = timeTrigInt;
	}


}
