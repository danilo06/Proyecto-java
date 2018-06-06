package modelo;

// Cuenta.java
// Representa a una cuenta bancaria

public class Cuenta {
	private int numeroCuenta; // número de cuenta
	private int nip; // NIP para autenticación
	private double saldoDisponible; // fondos disponibles para retirar
	private double saldoTotal; // fondos disponibles + depósitos pendientes
	
	public Cuenta() {
		
	}

	// el constructor de Cuenta inicializa los atributos
	public Cuenta(int elNumeroDeCuenta, int elNIP, double elSaldoDisponible, double elSaldoTotal) {
		numeroCuenta = elNumeroDeCuenta;
		nip = elNIP;
		saldoDisponible = elSaldoDisponible;
		saldoTotal = elSaldoTotal;
	} // fin del constructor de Cuenta

	// determina si un NIP especificado por el usuario coincide con el NIP en la
	// Cuenta
	public boolean validarNIP(int nipUsuario) {
		if (nipUsuario == nip)
			return true;
		else
			return false;
	} // fin del método validarNIP

	// devuelve el saldo disponible
	public double obtenerSaldoDisponible() {
		return saldoDisponible;
	} // fin de obtenerSaldoDisponible

	// devuelve el saldo total
	public double obtenerSaldoTotal() {
		return saldoTotal;
	} // fin del método obtenerSaldoTotal

	// abona un monto a la cuenta
	public void abonar(double monto) {
		saldoTotal += monto; // lo suma al saldo total
	} // fin del método abonar

	// carga un monto a la cuenta
	public void cargar(double monto) {
		saldoDisponible -= monto; // lo resta del saldo disponible
		saldoTotal -= monto; // lo resta del saldo total
	} // fin del método cargar

	// devuelve el número de cuenta
	public int obtenerNumeroCuenta() {
		return numeroCuenta;
	} // fin del método obtenerNumeroCuenta

	@Override
	public String toString() {
		return "Cuenta [numeroCuenta=" + numeroCuenta + ", nip=" + nip + ", saldoDisponible=" + saldoDisponible
				+ ", saldoTotal=" + saldoTotal + "]";
	}
	
} // fin de la clase Cuenta

/**************************************************************************
 * (C) Copyright 1992-2012 por Deitel & Associates, Inc. y * Pearson Education,
 * Inc. Todos los derechos reservados. * * RENUNCIA: Los autores y el editor de
 * este libro han realizado su mejor * esfuerzo para preparar este libro. Esto
 * incluye el desarrollo, la * investigación y prueba de las teorías y programas
 * para determinar su * efectividad. Los autores y el editor no hacen ninguna
 * garantía de * ningún tipo, expresa o implícita, en relación con estos
 * programas o * con la documentación contenida en estos libros. Los autores y
 * el * editor no serán responsables en ningún caso por los daños consecuentes *
 * en conexión con, o que surjan de, el suministro, desempeño o uso de * estos
 * programas. *
 *************************************************************************/