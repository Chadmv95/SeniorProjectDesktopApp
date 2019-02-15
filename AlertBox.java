import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;

public class AlertBox {

	public AlertBox(String t, String m) {
		display(t, m);
	}

	private static void display(String title, String msg) {
		Stage window = new Stage();
		
		window.initModality(Modality.APPLICATION_MODAL); // blocks user events with other windows until this one is taken care of
		window.setTitle(title);
		window.setMinWidth(250);
		
		Label label = new Label(msg);
		Button closeBtn = new Button("Close Window");
		closeBtn.setOnAction(e -> window.close());
		
		VBox layout = new VBox(10);
		layout.getChildren().addAll(label, closeBtn);
		layout.setAlignment(Pos.CENTER);
		
		Scene scene = new Scene(layout);
		window.setScene(scene);
		window.showAndWait();
		
	}
	
}
