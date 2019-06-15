import java.io.IOException;

import org.json.JSONException;

import javafx.scene.layout.*;
import javafx.scene.control.*;


public class SettingsScene {

	static VBox v;
	
	public SettingsScene() {
		display();
	}
	
	public static VBox display() {
		
		Options settings;
		Button submit;
		ChoiceBox<Integer> choiceBurstCount, choiceTimeBurst, choiceTimePowerSaver, choiceTimeTrigInt;
		TextField location, name;
		
		settings = new Options();
		
		v = new VBox();	
		name = new TextField("Enter Name Here");
		location = new TextField("Enter Location Here");
		submit = new Button("Submit");
		choiceBurstCount = new ChoiceBox<>();
		choiceTimeBurst = new ChoiceBox<>();
		choiceTimePowerSaver = new ChoiceBox<>();
		choiceTimeTrigInt = new ChoiceBox<>();
		
		choiceBurstCount.getItems().addAll(1,2,3,4,5,6,7,8,9,10); //number of pictures
		choiceTimeBurst.getItems().addAll(1,2,3,4,5,6,7,8,9,10); //seconds
		choiceTimePowerSaver.getItems().addAll(1*60,10*60,20*60,30*60,40*60,50*60,60*60); //seconds
		choiceTimeTrigInt.getItems().addAll(1*60,5*60,10*60,15*60,20*60); //seconds (1min - 20min)
		
		submit.setOnAction(e -> {
			settings.setLocation(location.getText());
			settings.setName(name.getText());
			settings.setBurstCount(choiceBurstCount.getValue());
			settings.setTimeBurst(choiceTimeBurst.getValue());
			settings.setTimePowerSaver(choiceTimePowerSaver.getValue());
			settings.setTimeTrigInt(choiceTimeTrigInt.getValue());
			
			try {
				settings.writeJSON("H:\\SCHOOLWORK\\SeniorProject\\DesktopApp\\Senior Project Desktop App\\src\\configuration.json");
			} catch (JSONException e1) {
				AlertBox.display("JSON Error", "Error reading JSON");
			} catch (IOException e1) {
				AlertBox.display("File Error", "Error reading file");
			}
			
		});
		
		v.getChildren().addAll(name, location, choiceBurstCount, choiceTimeBurst, choiceTimePowerSaver, choiceTimeTrigInt, submit);
		
		return v;
	}
	
}