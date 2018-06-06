package controlador;
// SolicitudSaldo.java

// Representa una transacción de solicitud de saldo en el ATM

import modelo.Cuenta;
import vista.Pantalla;

public class SolicitudSaldo extends Transaccion {
	// constructor de SolicitudSaldo
	public SolicitudSaldo(Cuenta cuenta, Pantalla pantallaATM) {
		super(cuenta, pantallaATM);
	} // fin del constructor de SolicitudSaldo

	// realiza la transacción
	@Override
	public void ejecutar() {

		Pantalla pantalla = obtenerPantalla();
		Cuenta cuenta = getCuentaU();

		// obtiene el saldo disponible para la cuenta implicada
		double saldoDisponible = cuenta.obtenerSaldoDisponible();

		// obtiene el saldo total para la cuenta implicada
		double saldoTotal = cuenta.obtenerSaldoTotal();

		// muestra la información del saldo en la pantalla
		pantalla.mostrarLineaMensaje("\nInformacion de saldo:");
		pantalla.mostrarMensaje(" - Saldo disponible: ");
		pantalla.mostrarMontoDolares(saldoDisponible);
		pantalla.mostrarMensaje("\n - Saldo total:     ");
		pantalla.mostrarMontoDolares(saldoTotal);
		pantalla.mostrarLineaMensaje("");
	} // fin del método ejecutar
} // fin de la clase SolicitudSaldo
