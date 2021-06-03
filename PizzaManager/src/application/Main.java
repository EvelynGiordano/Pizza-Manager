package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;

/**
 * This is the main class that overrides the Application class's start method.
 * Incites the first GUI Pizza Manager window.
 * CHRISTOPHER DEFRANZA & EVELYN GIORDANO
 * @author Evelyn Giordano
 */
public class Main extends Application {
	/**
	 * Creates the first stage for Pizza Manager.
	 */
	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("Pizza.fxml"));
			Scene scene = new Scene(root, 600, 550);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setTitle("Pizza Manager");
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
}
