import java.io.IOException;
import java.io.File;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.FileChooser;


/**
 * @author Chad Vredeveld
 *	This class is a test for javafx gui elements
 */
public class tester extends Application {

	private static final int BUTTON_SIZE = 50;
	
	private BorderPane borderPane;
	
	File file;
	
	public static void main(String[] args) {
		launch(args);
	}
	
	
	public void start(Stage mainStage) throws Exception {
		
		VBox leftMenu = new VBox();
		leftMenu = createSidebar();

		borderPane = new BorderPane();
		Scene scene1 = new Scene(borderPane, 300, 250);	
		
		
		mainStage.setTitle("PIT Tracker Configurator");
		mainStage.setScene(scene1);
		mainStage.setWidth(800);
		mainStage.setHeight(600);
		mainStage.centerOnScreen();
		mainStage.setResizable(false);
		mainStage.show();
		
		AlertBox.display("Root Directory", "Please navigate and select the \"timestamps.csv\" file located on the SD card");
		
		FileChooser fc = new FileChooser();
		fc.setInitialDirectory(
                new File(System.getProperty("user.home"))
            );
		fc.getExtensionFilters().addAll( new FileChooser.ExtensionFilter("All files", "*.*"));
		fc.setTitle("Select timestamps.csv on SD Card");
		
		//continue to check for 
		file = new File("");
		boolean success = false;
		while(success == false) {
			try {
				file = fc.showOpenDialog(mainStage);
				success = true;
			}
			catch(Exception e) {
				e.printStackTrace();
				success = false;
				AlertBox.display("File Error", "Error getting file, please try again.");
			}
		}
		
		borderPane.setLeft(leftMenu);
		if(file != null) {
			borderPane.setCenter(SpreadsheetScene.display(file.toString()));
		} else {
			String fp = "C:\\";
			borderPane.setCenter(SpreadsheetScene.display(fp));
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
			String path = file.getParent() + "\\Photos\\";
			try {
				Runtime.getRuntime().exec("explorer.exe /select, " + path);
			} catch (IOException e1) {
				AlertBox.display("File Error", "Error opening: " + path);
			}
		});
		
		btn_spreadsheet.setOnAction(e -> {
			
			String path = file.toString();
			
			/*
			 * This is left commented out but it can be used to open the file in excel
			 * uncomment this block of code if this functionality is desired
			 * 
			try {
				Runtime.getRuntime().exec("excel " + path);
			} catch (IOException e1) {
				AlertBox.display("File Error", "Error opening: " + path +
						"\nRuntime Environment: " + Runtime.getRuntime());
			}
			*/
			
			borderPane.setCenter(SpreadsheetScene.display(path));
		});
		
		btn_help.setOnAction(e -> {
			borderPane.setCenter(HelpScene.display());
		});
		
		//add the buttons to the vbox and format them
		vb.setSpacing(10);
		vb.setPadding(new Insets(10, 10, 10, 10));
		vb.getChildren().addAll(btn_spreadsheet, btn_photos, btn_settings, btn_help);
		
		return vb;
	}
	
	

}

