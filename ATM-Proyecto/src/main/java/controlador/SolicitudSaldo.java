package controlador;
// SolicitudSaldo.java
// Representa una transacción de solicitud de saldo en el ATM

import modelo.BaseDatosBanco;
import vista.Pantalla;

public class SolicitudSaldo extends Transaccion
{
   // constructor de SolicitudSaldo
   public SolicitudSaldo( int numeroCuentaUsuario, Pantalla pantallaATM, 
      BaseDatosBanco baseDatosBanco )
   {
      super( numeroCuentaUsuario, pantallaATM, baseDatosBanco );
   } // fin del constructor de SolicitudSaldo

   // realiza la transacción
   @Override
   public void ejecutar()
   {
      // obtiene referencias a la base de datos del banco y la pantalla
      BaseDatosBanco baseDatosBanco = obtenerBaseDatosBanco();
      Pantalla pantalla = obtenerPantalla();

      // obtiene el saldo disponible para la cuenta implicada
      double saldoDisponible = 
         baseDatosBanco.obtenerSaldoDisponible( obtenerNumeroCuenta() );

      // obtiene el saldo total para la cuenta implicada
      double saldoTotal = 
         baseDatosBanco.obtenerSaldoTotal( obtenerNumeroCuenta() );
      
      // muestra la información del saldo en la pantalla
      pantalla.mostrarLineaMensaje( "\nInformacion de saldo:" );
      pantalla.mostrarMensaje( " - Saldo disponible: " ); 
      pantalla.mostrarMontoDolares( saldoDisponible );
      pantalla.mostrarMensaje( "\n - Saldo total:     " );
      pantalla.mostrarMontoDolares( saldoTotal );
      pantalla.mostrarLineaMensaje( "" );
   } // fin del método ejecutar
} // fin de la clase SolicitudSaldo



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