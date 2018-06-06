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
		List <Cuenta>datos = new ArrayList<Cuenta>();
		List <Cuenta>datos2 = new ArrayList<Cuenta>();
		datos = este.getAllCuenta();
		System.out.print(datos);
		System.out.println("\n-------------------------------");
		System.out.print("Valor cuenta: ");
		valor = entrada.nextInt();
		Cuenta cuenta = este.getCuenta(valor);
		if (cuenta == null)
		{
			System.out.println("Lista vacia");
		}else
		{
			System.out.println("Numero de cuenta: "+ cuenta.obtenerNumeroCuenta());
		}
		
	}

}
