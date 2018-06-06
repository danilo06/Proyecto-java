package controlador;
// Transaccion.java

// La superclase abstracta Transaccion representa una transacción con el ATM

import modelo.*;
import vista.Pantalla;

public abstract class Transaccion {
	
	private Cuenta cuentaU;
	private Pantalla pantalla; // pantalla del ATM

	// el constructor de Transaccion es invocado por las subclases mediante super()
	public Transaccion(Cuenta cuentaUsuario, Pantalla pantallaATM) {
		cuentaU = cuentaUsuario;
		pantalla = pantallaATM;
	} // fin del constructor de Transaccion

	// devuelve el número de cuenta
	public int obtenerNumeroCuenta() {
		return cuentaU.obtenerNumeroCuenta();
	} // fin del método obtenerNumeroCuenta
	

	public Cuenta getCuentaU() {
		return cuentaU;
	}

	public void setCuentaU(Cuenta cuentaU) {
		this.cuentaU = cuentaU;
	}

	// devuelve una referencia a la pantalla
	public Pantalla obtenerPantalla() {
		return pantalla;
	} // fin del método obtenerPantalla


	// realiza la transacción (cada subclase sobrescribe este método)
	abstract public void ejecutar();
} // fin de la clase Transaccion
