package controladorFX;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

public class FormularioController implements Initializable {

	@FXML
	private Button btnLimpiar;

	@FXML
	private Button btnGuardar;

	@FXML
	private Button btnSalir;

	@FXML
	private DatePicker dateFechaNacimiento;

	@FXML
	private TextField txtNombre;

	@FXML
	private TextField txtApellido;

	@FXML
	private TextField txtDepartamento;

	@FXML
	private TextField txtNumeroSeguridadSocial;

	@FXML
	private ComboBox<String> cboTipoEmpleado;

	@FXML
	private ComboBox<String> cboEstadoCivil;

	@FXML
	private RadioButton rbFemenino;

	@FXML
	private ToggleGroup GroupSexo;

	@FXML
	private RadioButton rbMasculino;

	@FXML
	private TextField txtSalarioBase;

	@FXML
	private TextField txtVentasBruto;

	@FXML
	private TextField txtPorcentajeComision;

	@FXML
	private TextField txtSalarioSemanal;

	@FXML
	private TextField txtBono;

	@FXML
	private TextField txtHoras;

	@FXML
	private TextField txtSalario;
	
	@Override
	
	public void initialize(URL location, ResourceBundle resources) {
		
		cboEstadoCivil.getItems().add("Soltero");
		cboEstadoCivil.getItems().add("Casado");
		cboEstadoCivil.getItems().add("Viudo");
		cboEstadoCivil.getItems().add("Divorciado");
		cboEstadoCivil.getSelectionModel().select(0);
		cboTipoEmpleado.getItems().add("Empleado Asalariado");
		cboTipoEmpleado.getItems().add("Empleado por Comision");
		cboTipoEmpleado.getItems().add("Empleado por hora");
		cboTipoEmpleado.getItems().add("Empleado Sueldo Base + Comision");
		System.out.print("hello world");
		
	}
	
	@FXML
	void guardarDatos(ActionEvent event) {
		
	  
	}
	
	@FXML
	void limpiarPantalla(ActionEvent event) {

	}

	@FXML
	void salir(ActionEvent event) {

	}
	

}
