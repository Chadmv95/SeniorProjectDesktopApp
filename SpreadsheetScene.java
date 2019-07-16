import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.collections.ObservableList;

import java.io.IOException;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;


public class SpreadsheetScene {

	static VBox v;
	static TableView<MartenData> table;
	static ObservableList<MartenData> mdObservable;
	
	public SpreadsheetScene() {
		display("");
	}
	
	@SuppressWarnings("unchecked")
	public static VBox display(String path) {
		
		TableColumn<MartenData, String> timeCol = new TableColumn<>("Timestamp");
		timeCol.setMinWidth(250);
		timeCol.setCellValueFactory(new PropertyValueFactory<>("time"));
		
		TableColumn<MartenData, String> tagCol = new TableColumn<>("Tag ID");
		tagCol.setMinWidth(250);
		tagCol.setCellValueFactory(new PropertyValueFactory<>("tagID"));
		
		TableColumn<MartenData, String> photoCountCol = new TableColumn<>("Photo Count");
		photoCountCol.setMinWidth(100);
		photoCountCol.setCellValueFactory(new PropertyValueFactory<>("photoCount"));
		
		table = new TableView<>();
		getMartenData(path);
		table.setItems(mdObservable);
		table.getColumns().addAll(timeCol, tagCol, photoCountCol);
		
		//add a listener to tell when the user clicks on the table row
		table.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {

			@Override
			public void changed(ObservableValue arg0, Object arg1, Object arg2) {
				//only if it is not null, open explorer with the selected photos folder
				if(table.getSelectionModel().getSelectedItem() != null) {
					MartenData md = table.getSelectionModel().getSelectedItem();
					
					//trim the file off the directory, then add \photos\'timestamp'
					String tempPath = path.substring(0, path.lastIndexOf("\\")) + "\\Photos\\" + md.getTime();
					System.out.println(tempPath + "\\Photos\\" + md.getTime());
					try {
						Runtime.getRuntime().exec("explorer.exe /select, " + tempPath);
					} catch (IOException e1) {
						AlertBox.display("File Error", "Error opening: " + path);
					}
				}
			}
			
		});
		
		
		v = new VBox();
		v.getChildren().addAll(table);
		
		return v;
	}
	
	private static void getMartenData(String path) {
		
		mdObservable = FXCollections.observableArrayList();
		
		mdObservable = CSVReader.readCSV(mdObservable, path);
		
	}	
	
	
}