package inicioPrograma;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;


public class Main extends Application {
	
	@Override
	public void start(Stage PrimaryStage) throws Exception {
	    Parent root = FXMLLoader.load(getClass().getResource("/view/inicial.fxml"));
	    Scene scene = new Scene(root);
	    PrimaryStage.setScene(scene);
	    PrimaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
}
