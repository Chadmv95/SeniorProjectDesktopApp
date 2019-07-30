import java.io.IOException;

import org.json.JSONException;

import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.Insets;


public class SettingsScene {

	static VBox v;
	
	public SettingsScene(String jsonPath) {
		display(jsonPath);
	}
	
	public static VBox display(String path) {
		
		Options settings;
		Button submit;
		ChoiceBox<Integer> choiceBurstCount, choiceTimeBurst, choiceTimePowerSaver, choiceTimeTrigInt;
		TextField location, name;
		Label burstCountLabel, timeBurstLabel, timePowerSaverLabel, timeTrigIntLabel, locationLabel, nameLabel;
		
		settings = new Options(path);
		
		v = new VBox();
		name = new TextField(settings.getName());
		location = new TextField(settings.getLocation());
		submit = new Button("Submit");
		
		burstCountLabel = new Label("Burst Count");
		timeBurstLabel = new Label("Burst Time (seconds)");
		timePowerSaverLabel = new Label("Power Saver Time (seconds)");
		timeTrigIntLabel = new Label("Trigger Interval Time (seconds)");
		locationLabel = new Label("Location");
		nameLabel = new Label("Device Name");
		
		choiceBurstCount = new ChoiceBox<>();
		choiceTimeBurst = new ChoiceBox<>();
		choiceTimePowerSaver = new ChoiceBox<>();
		choiceTimeTrigInt = new ChoiceBox<>();
		
		//add items to the choice box. this should probably be it's own class with error handling
		choiceBurstCount.getItems().addAll(1,2,3,4,5,6,7,8,9,10); //number of pictures
		choiceTimeBurst.getItems().addAll(1,2,3,4,5,6,7,8,9,10); //seconds
		choiceTimePowerSaver.getItems().addAll(1*60,10*60,20*60,30*60,40*60,50*60,60*60); //seconds
		choiceTimeTrigInt.getItems().addAll(5,15,30,1*60,5*60,10*60,15*60,20*60); //seconds (5sec - 20min)
		
		//set tool tips when the cursor is hovered over
		choiceBurstCount.setTooltip(new Tooltip("Number of pictures to be taken"));
		choiceTimeBurst.setTooltip(new Tooltip("Time between pictures during a burst"));
		choiceTimePowerSaver.setTooltip(new Tooltip("Amount of time before going to low power mode"));
		choiceTimeTrigInt.setTooltip(new Tooltip("Amount of time to wait before allowing the system to be triggered"));
		submit.setTooltip(new Tooltip("Apply and save selected settings"));
		
		//set default values
		choiceBurstCount.setValue(settings.getBurstCount());
		choiceTimeBurst.setValue(settings.getTimeBurst());
		choiceTimePowerSaver.setValue(settings.getTimePowerSaver());
		choiceTimeTrigInt.setValue(settings.getTimeTrigInt());
		
		//make the text fields larger and the submit button larger
		location.setPadding(new Insets(10, 10, 10, 10));
		name.setPadding(new Insets(10, 10, 10, 10));
		burstCountLabel.setPadding(new Insets		(5, 0, 0, 0));
		timeBurstLabel.setPadding(new Insets		(5, 0, 0, 0));
		timePowerSaverLabel.setPadding(new Insets	(5, 0, 0, 0));
		timeTrigIntLabel.setPadding(new Insets		(5, 0, 0, 0));
		locationLabel.setPadding(new Insets			(5, 0, 0, 0));
		nameLabel.setPadding(new Insets				(5, 0, 0, 0));
		submit.setPadding(new Insets(10, 10, 10, 10));
		
		v.setPadding(new Insets(0, 200, 50, 10));
	    v.setSpacing(2);
		
		submit.setOnAction(e -> {
			settings.setLocation(location.getText());
			settings.setName(name.getText());
			settings.setBurstCount(choiceBurstCount.getValue());
			settings.setTimeBurst(choiceTimeBurst.getValue());
			settings.setTimePowerSaver(choiceTimePowerSaver.getValue());
			settings.setTimeTrigInt(choiceTimeTrigInt.getValue());
			
			try {
				settings.writeJSON(path); //"H:\\SCHOOLWORK\\SeniorProject\\DesktopApp\\Senior Project Desktop App\\src\\configuration.json"
			} catch (JSONException e1) {
				AlertBox.display("JSON Error", "Error reading JSON file: \n" + path);
			} catch (IOException e1) {
				AlertBox.display("File Error", "Error reading file. Does the file configuration.json exist in this location?\n" + path);
			}
			
		});
		
		v.getChildren().addAll(nameLabel, name, 
				locationLabel, location,
				burstCountLabel, choiceBurstCount,
				timeBurstLabel, choiceTimeBurst,
				timePowerSaverLabel, choiceTimePowerSaver,
				timeTrigIntLabel, choiceTimeTrigInt,
				submit);
		
		return v;
	}
	
}