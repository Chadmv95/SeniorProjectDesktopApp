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
	
	private PhotoScene photoScene;
	private HelpScene helpScene;
	private SettingsScene settingsScene;
	private SpreadsheetScene spreadsheetScene;
	private BorderPane borderPane;
	
	
	public static void main(String[] args) {
		launch(args);
	}
	
	
	public void start(Stage mainStage) throws Exception {
		
		VBox leftMenu = new VBox();
		VBox centerMenu = new VBox();

		borderPane = new BorderPane();

		
		Button b1 = new Button("Penis1");
		Button b2 = new Button("Penis2");
		Button b3 = new Button("Penis3");
		Button b4 = new Button("Penis4");
		Button b5 = new Button("Penis5");
		Button b6 = new Button("Penis6");
				
		centerMenu.getChildren().addAll(b1,b2,b3,b4,b5,b6);
		leftMenu = createSidebar();
		
		Scene scene1 = new Scene(borderPane, 300, 250);
		
		borderPane.setLeft(leftMenu);
		borderPane.setCenter(centerMenu);
		
		mainStage.setTitle("Window Title");
		mainStage.setScene(scene1);
		mainStage.setWidth(800);
		mainStage.setHeight(600);
		mainStage.centerOnScreen();
		mainStage.setResizable(false);
		mainStage.show();
		
//		mainStage.setScene(HelpScene.display());
//		
//		settingsScene = new SettingsScene();
//		
//		mainStage.setScene(settingsScene.display());
		
		
		
	}
	
	/*
	 * 
	 * 
	 * @param csvFile String for the filepath of the csv file
	 */
	private void readCSV(String csvFile) {
		
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
	private VBox createSidebar() {
		
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
		btn_spreadsheet.setGraphic(spreadsheet_view);
		btn_photos.setGraphic(photos_view);
		btn_settings.setGraphic(settings_view);
		btn_help.setGraphic(help_view);
		
		btn_settings.setOnAction(e -> {
			borderPane.setCenter(SettingsScene.display());
		});
		btn_photos.setOnAction(e -> {
			String path = "H:\\Pictures\\Concert\\adtr self help fest good quality.jpg";
			try {
				Runtime.getRuntime().exec("explorer.exe /select, " + path);
			} catch (IOException e1) {
				AlertBox.display("File Error", "Error opening: " + path);
			}
		});
		btn_spreadsheet.setOnAction(e -> {
			String path = "H:\\SCHOOLWORK\\CIS 263\\Project 2 Stocks\\CSV.csv";
			try {
				Runtime.getRuntime().exec("start dxdiag.exe");
			} catch (IOException e1) {
				AlertBox.display("File Error", "Error opening: " + path +
						"\nRuntime Environment: " + Runtime.getRuntime());
			}
		});
		btn_help.setOnAction(e -> {
			borderPane.setCenter(HelpScene.display());
		});
		
		//add the buttons to the vbox and format them
		vb.setSpacing(10);
		vb.setPadding(new Insets(10, 10, 10, 10));
		vb.getChildren().addAll(btn_settings, btn_photos, btn_spreadsheet, btn_help);
		
		return vb;
	}
	
	

}

