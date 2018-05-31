package Proyecto.SistemaDeNomina;
	
import java.net.URL;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) throws Exception{
			
			Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("asd.fxml"));
			Scene scene = new Scene(root);			
			primaryStage.setScene(scene);
			primaryStage.show();	
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
