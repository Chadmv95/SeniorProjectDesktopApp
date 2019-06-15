import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.collections.ObservableList;
import javafx.collections.FXCollections;


public class SpreadsheetScene {

	static VBox v;
	static TableView<MartenData> table;
	
	public SpreadsheetScene() {
		display();
	}
	
	public static VBox display() {
		
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
		table.setItems(getMartenData());
		table.getColumns().addAll(timeCol, tagCol, photoCountCol);
		
		v = new VBox();
		v.getChildren().addAll(table);		
		
		return v;
	}
	
	public static ObservableList<MartenData> getMartenData() {
		
		ObservableList<MartenData> d = FXCollections.observableArrayList();
		
		//TODO add items to d
		String[] row = {"1", "2", "3"};
		
		MartenData md = new MartenData();
		md.insertAll(row);

		d.add(md);
		d.add(md);
		d.add(md);
		d.add(md);
		d.add(md);
		
		return d;
		
	}
	
}