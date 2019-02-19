import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


/**
 * @author Chad Vredeveld
 *	This class is a test for javafx gui elements
 */
public class tester extends Application {

	private static final int BUTTON_SIZE = 50;

	
	public static void main(String[] args) {
		launch(args);
	}
	
	
	public void start(Stage window) throws Exception {
		
		VBox leftMenu = new VBox();

		BorderPane borderPane = new BorderPane();
		borderPane.setLeft(leftMenu);
		leftMenu = create_Sidebar();
		
		Scene scene1 = new Scene(borderPane, 300, 250);
		
		borderPane.getChildren().add(leftMenu);
		
		window.setTitle("Window Title");
		window.setScene(scene1);
		window.setWidth(800);
		window.setHeight(600);
		window.show();
		
	}
	
	/*
	 * 
	 * 
	 * @param csvFile String for the filepath of the csv file
	 */
	private void readCSV(String csvFile) {
		
        //String csvFile = "/Users/chadvredeveld/documents/test.csv";
        String line = "";
        String cvsSplitBy = ",";

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

            while ((line = br.readLine()) != null) {

                // use comma as separator
                String[] country = line.split(cvsSplitBy);

                System.out.println("Country [code= " + country[4] + " , name=" + country[5] + "]");

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	
	/**
	 * This function creates the side panel for the buttons to switch
	 * between scenes in the center of the borderpane
	 * 
	 * @return VBox created for side panel
	 */
	private VBox create_Sidebar() {
		
		//vbox for the sidebar
		VBox vb = new VBox();
		
		//buttons for the icons
		Button btn_settings = new Button();
		Button btn_photos = new Button();
		Button btn_spreadsheet = new Button();
		Button btn_help = new Button();
		
		//load icons from project resources
		Image img_settings = new Image(getClass().getResourceAsStream("settings.png"));
		Image img_photos = new Image(getClass().getResourceAsStream("photos.png"));
		Image img_spreadsheet = new Image(getClass().getResourceAsStream("spreadsheet.png"));
		Image img_help = new Image(getClass().getResourceAsStream("question mark.png"));
		
		//create image views for each photo so we can change the size of the button
		ImageView settings_view = new ImageView(img_settings);
		settings_view.setFitHeight(BUTTON_SIZE);
		settings_view.setFitWidth(BUTTON_SIZE);
		ImageView photos_view = new ImageView(img_photos);
		photos_view.setFitHeight(BUTTON_SIZE);
		photos_view.setFitWidth(BUTTON_SIZE);
		ImageView spreadsheet_view = new ImageView(img_spreadsheet);
		spreadsheet_view.setFitHeight(BUTTON_SIZE);
		spreadsheet_view.setFitWidth(BUTTON_SIZE);
		ImageView help_view = new ImageView(img_help);
		help_view.setFitHeight(BUTTON_SIZE);
		help_view.setFitWidth(BUTTON_SIZE);
		
		
		//set the images to display on the button
		btn_settings.setGraphic(settings_view);
		btn_photos.setGraphic(photos_view);
		btn_spreadsheet.setGraphic(spreadsheet_view);
		btn_help.setGraphic(help_view);
		
		//TODO make these buttons able to manipulate the center borderpane
		//make the buttons actually do something
		btn_settings.setOnAction(e -> {
			System.out.println("Settings");
		});
		btn_photos.setOnAction(e -> {
			System.out.println("Photos");
		});
		btn_spreadsheet.setOnAction(e -> {
			System.out.println("Spreadsheet");
		});
		btn_help.setOnAction(e -> {
			System.out.println("Help me!");
		});
		
		//add the buttons to the vbox and format them
		vb.setSpacing(10);
		vb.setPadding(new Insets(10, 10, 10, 10));
		vb.getChildren().addAll(btn_settings, btn_photos, btn_spreadsheet, btn_help);
		
		return vb;
	}
	
	

}

