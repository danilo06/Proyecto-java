package controlador;
// Retiro.java

import connection.AccountQueries;

// Representa una transacción de retiro en el ATM

import modelo.Cuenta;
import vista.Pantalla;
import vista.Teclado;

public class Retiro extends Transaccion {
	private int monto; // monto a retirar
	private Teclado teclado; // referencia al teclado
	private DispensadorEfectivo dispensadorEfectivo; // referencia al dispensador de efectivo
	int confirmarActualizacion;
	AccountQueries queries = new AccountQueries();

	// constante que corresponde a la opción del menú a cancelar
	private final static int CANCELO = 6;

	// constructor de Retiro
	public Retiro(Cuenta account, Pantalla pantallaATM, Teclado tecladoATM,
			DispensadorEfectivo dispensadorEfectivoATM) {
		// inicializa las variables de la superclase
		super(account, pantallaATM);

		// inicializa las referencias al teclado y al dispensador de efectivo
		teclado = tecladoATM;
		dispensadorEfectivo = dispensadorEfectivoATM;
	} // fin del constructor de Retiro

	// realiza la transacción
	public void ejecutar() {
		Cuenta cuenta = getCuentaU();
		boolean efectivoDispensado = false; // no se ha dispensado aún el efectivo
		double saldoDisponible; // monto disponible para retirar

		Pantalla pantalla = obtenerPantalla();

		// itera hasta que se dispense el efectivo o que cancele el usuario
		do {
			// obtiene un monto de retiro elegido por el usuario
			monto = mostrarMenuDeMontos();

			// comprueba si el usuario eligió un monto de retiro o si canceló
			if (monto != CANCELO) {
				// obtiene el saldo disponible de la cuenta implicada
				saldoDisponible = cuenta.obtenerSaldoDisponible();

				// comprueba si el usuario tiene suficiente dinero en la cuenta
				if (monto <= saldoDisponible) {
					// comprueba si el dispensador de efectivo tiene suficiente dinero
					if (dispensadorEfectivo.haySuficienteEfectivoDisponible(monto)) {
						// actualiza la cuenta implicada para reflejar el saldo
						cuenta.cargar(monto);
						confirmarActualizacion = queries.setCuenta(cuenta.obtenerSaldoDisponible(), cuenta.obtenerSaldoTotal(), cuenta.obtenerNumeroCuenta());

						dispensadorEfectivo.dispensarEfectivo(monto); // dispensar efectivo
						efectivoDispensado = true; // se dispensó el efectivo

						// instruye al usuario que tome efectivo
						pantalla.mostrarLineaMensaje("\nTome ahora su efectivo.");
					} // fin de if
					else // el dispensador no tiene suficiente efectivo
						pantalla.mostrarLineaMensaje("\nNo hay suficiente efectivo disponible en el ATM."
								+ "\n\nSeleccione un monto menor.");
				} // fin de if
				else // no hay suficiente dinero disponible en la cuenta del usuario
				{
					pantalla.mostrarLineaMensaje(
							"\nNo hay suficientes fondos en su cuenta." + "\n\nSeleccione un monto menor.");
				} // fin de else
			} // fin de if
			else // el usuario eligió la opción cancelar del menú
			{
				pantalla.mostrarLineaMensaje("\nCancelando transaccion...");
				return; // regresa al menú principal porque el usuario canceló
			} // fin de else
		} while (!efectivoDispensado);

	} // fin del método ejecutar

	// muestra un menú de montos de retiro y la opción para cancelar;
	// devuelve el monto elegido o 0 si el usuario elije cancelar
	private int mostrarMenuDeMontos() {
		int opcionUsuario = 0; // variable local para almacenar el valor de retorno

		Pantalla pantalla = obtenerPantalla(); // obtiene referencia a la pantalla

		// arreglo de montos que corresponde a los números del menú
		int montos[] = { 0, 20, 40, 60, 100, 200 };

		// itera mientras no se haya elegido una opción válida
		while (opcionUsuario == 0) {
			// muestra el menú
			pantalla.mostrarLineaMensaje("\nMenu de retiro:");
			pantalla.mostrarLineaMensaje("1 - $20");
			pantalla.mostrarLineaMensaje("2 - $40");
			pantalla.mostrarLineaMensaje("3 - $60");
			pantalla.mostrarLineaMensaje("4 - $100");
			pantalla.mostrarLineaMensaje("5 - $200");
			pantalla.mostrarLineaMensaje("6 - Cancelar transaccion");
			pantalla.mostrarMensaje("\nSeleccione un monto a retirar: ");

			int entrada = teclado.obtenerEntrada(); // obtiene la entrada del usuario mediante el teclado

			// determina cómo proceder con base en el valor de la entrada
			switch (entrada) {
			case 1: // si el usuario eligió un monto de retiro
			case 2: // (es decir, si eligió la opción 1, 2, 3, 4 o 5), devolver
			case 3: // el monto correspondiente del arreglo montos
			case 4:
			case 5:
				opcionUsuario = montos[entrada]; // guarda la elección del usuario
				break;
			case CANCELO: // el usuario eligió cancelar
				opcionUsuario = CANCELO; // guarda la elección del usuario
				break;
			default: // el usuario no introdujo un valor del 1 al 6
				pantalla.mostrarLineaMensaje("\nSeleccion invalida. Intente de nuevo.");
			} // fin de switch
		} // fin de while

		return opcionUsuario; // devuelve el monto de retiro o CANCELO
	} // fin del método mostrarMenuDeMontos
} // fin de la clase Retiro