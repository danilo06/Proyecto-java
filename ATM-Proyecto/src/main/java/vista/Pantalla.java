package vista;
// Pantalla.java
// Representa a la pantalla del ATM

public class Pantalla
{
   // muestra un mensaje sin un retorno de carro
   public void mostrarMensaje( String mensaje ) 
   {
      System.out.print( mensaje ); 
   } // fin del método mostrarMensaje

   // muestra un mensaje con un retorno de carro
   public void mostrarLineaMensaje( String mensaje ) 
   {
      System.out.println( mensaje );   
   } // fin del método mostrarLineaMensaje

   // muestra un monto en dólares
   public void mostrarMontoDolares( double monto )
   {
      System.out.printf( "$%,.2f", monto );   
   } // fin del método mostrarMontoDolares 
} // fin de la clase Pantalla



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