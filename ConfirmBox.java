import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;

public class ConfirmBox {
	
	static boolean ans = false;

	public static boolean display(String title, String msg) {
		Stage window = new Stage();
		
		window.initModality(Modality.APPLICATION_MODAL); //blocks user events with other windows until this one is taken care of
		window.setTitle(title);
		window.setMinWidth(250);
		
		Label label = new Label(msg);
		Button yesBtn = new Button("Yes");
		Button noBtn = new Button("No");
		
		yesBtn.setOnAction(e -> {
			ans = true;
			window.close();
		});
		noBtn.setOnAction(e -> {
			ans = false;
			window.close();
		});
		
		VBox layout = new VBox(10);
		layout.getChildren().addAll(label, yesBtn, noBtn);
		layout.setAlignment(Pos.CENTER);
		
		Scene scene = new Scene(layout);
		window.setScene(scene);
		window.showAndWait();
		
		return ans;
	}
	
	
}
