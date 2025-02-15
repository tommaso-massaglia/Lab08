package it.polito.tdp.dizionariograph;

import it.polito.tdp.dizionariograph.model.Model;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.fxml.FXMLLoader;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("DizionarioGraph.fxml"));
			BorderPane root = (BorderPane) loader.load();
			
			Model model = new Model();
			DizionarioGraphController controller = new DizionarioGraphController();
			controller.setModel(model);
			
			Scene scene = new Scene(root, 320, 350);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			
			primaryStage.setScene(scene);
			primaryStage.show();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
