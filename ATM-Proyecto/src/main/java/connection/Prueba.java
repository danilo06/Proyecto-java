package connection;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import modelo.Cuenta;

public class Prueba {

	private static Scanner entrada = new Scanner(System.in);

	public static void main(String[] args) {
		int valor = 0;
		AccountQueries este = new AccountQueries();
		List<Cuenta> datos = new ArrayList<Cuenta>();
		List<Cuenta> datos2 = new ArrayList<Cuenta>();
		datos = este.getAllCuenta();
		System.out.print(datos);
		System.out.println("\n-------------------------------");
		valor = este.setCuenta(1000, 1200, 12345);
		if (valor == 1)
			System.out.println("Cuenta 1 actualizada");
		valor = este.setCuenta(200,200,98765);
		if (valor == 1)
			System.out.println("Cuenta 2 actualizada");
	}

}
