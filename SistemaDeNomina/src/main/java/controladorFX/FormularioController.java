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
import classEmployees.*;

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
		cboTipoEmpleado.getSelectionModel().select(0);

	}

	@FXML
	void guardarDatos(ActionEvent event) {
		float bonus = Float.parseFloat(txtBono.getText());
		switch (cboTipoEmpleado.getValue()) {
		case "Empleado Asalariado":
			float salarioSemanal = Float.parseFloat(txtSalarioSemanal.getText());
			SalariedEmployees salariedPerson = new SalariedEmployees(salarioSemanal, bonus, txtNumeroSeguridadSocial.getText(), txtNombre.getText(), txtApellido.getText(), dateFechaNacimiento.getValue(), cboTipoEmpleado.getValue(), txtDepartamento.getText());
			break;
		case "Empleado por Comision":
			int ventaTotal = Integer.parseInt(txtVentasBruto.getText());
			float commission = (Float.parseFloat(txtPorcentajeComision.getText()))/100;
			CommissionEmployees commissionPerson = new CommissionEmployees(ventaTotal, commission, bonus, txtNumeroSeguridadSocial.getText(), txtNombre.getText(), txtApellido.getText(), dateFechaNacimiento.getValue(), cboTipoEmpleado.getValue(), txtDepartamento.getText() );
			break;
		case "Empleado por hora":
			int horas = Integer.parseInt(txtHoras.getText());
			float salario = Float.parseFloat(txtSalario.getText());

			HourlEmployees hourPerson = new HourlEmployees(horas, salario, bonus, txtNumeroSeguridadSocial.getText(), txtNombre.getText(), txtApellido.getText(), dateFechaNacimiento.getValue(), cboTipoEmpleado.getValue(), txtDepartamento.getText());
			break;
		case "Empleado Sueldo Base + Comision":
			int ventaTotal2 = Integer.parseInt(txtVentasBruto.getText());
			float commission2 = (Float.parseFloat(txtPorcentajeComision.getText()))/100;
			float salarioBasico = Float.parseFloat(txtSalarioBase.getText());
			BasePluscommissionEmployees basePlusCommissionPerson = new BasePluscommissionEmployees(ventaTotal2, commission2, salarioBasico, bonus, txtNumeroSeguridadSocial.getText(), txtNombre.getText(), txtApellido.getText(), dateFechaNacimiento.getValue(), cboTipoEmpleado.getValue(), txtDepartamento.getText());
			System.out.print(basePlusCommissionPerson.toString());
			break;
		default:
			System.out.print("Error al cargar Tipo de empleado");
			break;
		}
	}

	@FXML
	void limpiarPantalla(ActionEvent event) {
		txtBono.clear();
		txtBono.clear();
		txtHoras.clear();
		txtNombre.clear();
		txtSalario.clear();
		txtApellido.clear();
		txtSalarioBase.clear();
		txtVentasBruto.clear();
		txtDepartamento.clear();
		txtSalarioSemanal.clear();
		txtPorcentajeComision.clear();
		txtNumeroSeguridadSocial.clear();
		cboEstadoCivil.getSelectionModel().select(0);
		cboTipoEmpleado.getSelectionModel().select(0);
	}

	@FXML
	void salir(ActionEvent event) {

	}

}
