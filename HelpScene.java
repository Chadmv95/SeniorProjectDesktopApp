import javafx.scene.*;
import javafx.scene.layout.VBox;
import javafx.scene.control.Label;


public class HelpScene {

	static Scene scene;
	
	public HelpScene() {
		display();
	}
	
	public static Scene display() {
		
		VBox v = new VBox(20);
		
		Label l = new Label(
				"This is where the text goes in the TextField!\n" +
				"Tthis is a new line!\n");
		
		v.getChildren().addAll(l);
		
		scene = new Scene(v, 200, 200);
		
		return scene;
	}
	
}