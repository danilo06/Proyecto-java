package Proyecto.SistemaDeNomina;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class fxController {
	@FXML
	private Button btnSiguiente;

	@FXML
	private Button btnAtras;

	@FXML
	void CAMBIAR(ActionEvent event) {
		System.out.print("hello world");
	}

}
