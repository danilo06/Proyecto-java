package Proyecto.SistemaDeNomina;
	
import java.net.URL;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	
	@Override
	public void start(Stage PrimaryStage) throws Exception {
	   
	    Parent root = FXMLLoader.load(getClass().getResource("/view/1.fxml"));
	    Scene scene = new Scene(root);// indicamos qué scene contendrá el Parent de cada ventana

	    PrimaryStage.setScene(scene);//declaras la escena de la ventana, en este caso sera la principal
	    PrimaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
}
