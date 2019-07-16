import javafx.scene.layout.VBox;
import javafx.scene.control.Label;


public class HelpScene {
	
	public HelpScene() {
		display();
	}
	
	public static VBox display() {
		
		VBox v = new VBox(20);
		
		Label l = new Label(
				"\n****************************DO****************************\n" +
				"-Copy the file timestamps.csv to your local drive\n" +
				"-Copy the folder Photos to your local drive\n" +
				"-Edit copied data AFTER copying to your computer's drive\n" +
				"-Ensure the timestamps.csv file has not been modified\n" +
				"-If the timestamps.csv file has been modified, delete the\n" +
				"     file from the SD card before deploying the device\n" +
				"\n" +
				"**************************DO NOT**************************\n" +
				"-Edit any files on the SD card\n" +
				"\n" +
				"*********************TROUBLESHOOTING********************\n" +
				"-Does the SD card contain these (unmodified) files?\n" +
				"     timestamps.csv\n" +
				"     configuration.json\n" +
				"     Photos folder?\n" +
				"-Do you have multiple instances of the program running?");
		
		v.getChildren().addAll(l);
		
		return v;
	}
	
}