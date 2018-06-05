package vista;

// Teclado.java
// Representa el teclado del ATM
import java.util.Scanner; // el programa usa a Scanner para obtener la entrada del usuario

public class Teclado
{
   private Scanner entrada; // lee datos de la línea de comandos
                         
   // el constructor sin argumentos inicializa el objeto Scanner
   public Teclado()
   {
      entrada = new Scanner( System.in );    
   } // fin del constructor sin argumentos de Teclado

   // devuelve un valor entero introducido por el usuario
   public int obtenerEntrada()
   {
      return entrada.nextInt(); // suponemos que el usuario introduce un entero  
   } // fin del método obtenerEntrada
} // fin de la clase Teclado  



/**************************************************************************
 * (C) Copyright 1992-2012 por Deitel & Associates, Inc. y                *
 * Pearson Education, Inc. Todos los derechos reservados.                 *
 *                                                                        *
 * RENUNCIA: Los autores y el editor de este libro han realizado su mejor *
 * esfuerzo para preparar este libro. Esto incluye el desarrollo, la      *
 * investigación y prueba de las teorías y programas para determinar su   *
 * efectividad. Los autores y el editor no hacen ninguna garantía de      *
 * ningún tipo, expresa o implícita, en relación con estos programas o    *
 * con la documentación contenida en estos libros. Los autores y el       *
 * editor no serán responsables en ningún caso por los daños consecuentes *
 * en conexión con, o que surjan de, el suministro, desempeño o uso de    *
 * estos programas.                                                       *
 *************************************************************************/