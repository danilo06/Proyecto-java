package controlador;

import modelo.BaseDatosBanco;
import vista.Pantalla;
import vista.Teclado;

// Deposito.java
// Representa una transacción de depósito en el ATM

public class Deposito extends Transaccion
{
   private double monto; // monto a depositar
   private Teclado teclado; // referencia al teclado
   private RanuraDeposito ranuraDeposito; // referencia a la ranura de depósito
   private final static int CANCELO = 0; // constante para la opción de cancelar

   // constructor de Deposito
   public Deposito( int numeroCuentaUsuario, Pantalla pantallaATM, 
      BaseDatosBanco baseDatosBancoATM, Teclado tecladoATM, 
      RanuraDeposito ranuraDepositoATM )
   {
      // inicializa las variables de la superclase
      super( numeroCuentaUsuario, pantallaATM, baseDatosBancoATM );

      // inicializa las referencias al teclado y la ranura de depósito
      teclado = tecladoATM;
      ranuraDeposito = ranuraDepositoATM;
   } // fin del constructor de Deposito

   // realiza la transacción
   @Override
   public void ejecutar()
   {
      BaseDatosBanco baseDatosBanco = obtenerBaseDatosBanco(); // obtiene la referencia
      Pantalla pantalla = obtenerPantalla(); // obtiene la referencia

      monto = pedirMontoADepositar(); // obtiene el monto a depositar del usuario

      // comprueba si el usuario introdujo un monto a depositar o canceló
      if ( monto != CANCELO )
      {
         // solicita un sobre de depósito que contenga el monto especificado
         pantalla.mostrarMensaje( 
            "\nInserte un sobre que contenga " );
         pantalla.mostrarMontoDolares( monto );
         pantalla.mostrarLineaMensaje( "." );

         // recibe el sobre de depósito
         boolean seRecibioSobre = ranuraDeposito.seRecibioSobre();

         // comprueba si se recibió el sobre de depósito
         if ( seRecibioSobre )
         {  
            pantalla.mostrarLineaMensaje( "\nSe recibio su sobre de " + 
               "deposito.\nNOTA: El dinero que acaba de depositar no " + 
               "estara disponible sino hasta que verifiquemos el monto del " +
               "efectivo y cualquier cheque incluido." );
            
            // hace un abono a la cuenta para reflejar el depósito
            baseDatosBanco.abonar( obtenerNumeroCuenta(), monto ); 
         } // fin de if
         else // no se recibió el sobre de depósito
         {
            pantalla.mostrarLineaMensaje( "\nNo inserto un sobre de " +
               "deposito, por lo que el ATM ha cancelado su transaccion." );
         } // fin de else
      } // fin de if 
      else // el usuario canceló en vez de introducir el monto
      {
         pantalla.mostrarLineaMensaje( "\nCancelando transaccion..." );
      } // fin de else
   } // fin del método ejecutar

   // pide al usuario que introduzca un monto a depositar en centavos
   private double pedirMontoADepositar()
   {
      Pantalla pantalla = obtenerPantalla(); // obtiene referencia a la pantalla

      // muestra el indicador
      pantalla.mostrarMensaje( "\nIntroduzca un monto a depositar en " + 
         "CENTAVOS (o 0 para cancelar): " );
      int entrada = teclado.obtenerEntrada(); // recibe la entrada del monto de depósito
      
      // comprueba si el usuario canceló o introdujo un monto válido
      if ( entrada == CANCELO ) 
         return CANCELO;
      else
      {
         return ( double ) entrada / 100; // devuelve el monto en dólares
      } // fin de else
   } // fin del método pedirMontoADepositar
} // fin de la clase Deposito



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