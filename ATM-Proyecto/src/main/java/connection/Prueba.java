package connection;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import modelo.Cuenta;
public class Prueba {

	private static Scanner entrada = new Scanner(System.in);
	
	public static void main(String[] args) {
		int valor = 0;
		PersonQueries este = new PersonQueries();
		List <Cuenta>datos = new ArrayList<Cuenta>();
		List <Cuenta>datos2 = new ArrayList<Cuenta>();
		datos = este.getAllCuenta();
		System.out.print(datos);
		System.out.print("\n-------------------------------");
		System.out.print("Valor cuenta: ");
		valor = entrada.nextInt();
		datos2= este.getCuenta(valor);
		System.out.print(datos2);
		
		Cuenta cuenta = new Cuenta();
		cuenta = datos2.get(0);
		System.out.print(cuenta.obtenerNumeroCuenta());
		
	}

}
