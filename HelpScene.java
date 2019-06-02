import javafx.scene.layout.VBox;
import javafx.scene.control.Label;


public class HelpScene {
	
	public HelpScene() {
		display();
	}
	
	public static VBox display() {
		
		VBox v = new VBox(20);
		
		Label l = new Label(
				"*************************HELP*************************\n" +
				"This is where the text goes in the TextField!\n" +
				"This is a new line!\n" +
				"*************************HELP*************************\n");
		
		v.getChildren().addAll(l);
		
		return v;
	}
	
}