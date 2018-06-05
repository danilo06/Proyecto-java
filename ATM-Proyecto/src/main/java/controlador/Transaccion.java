package controlador;
// Transaccion.java
// La superclase abstracta Transaccion representa una transacción con el ATM

import modelo.BaseDatosBanco;
import vista.Pantalla;

public abstract class Transaccion
{
   private int numeroCuenta; // indica la cuenta implicada
   private Pantalla pantalla; // pantalla del ATM
   private BaseDatosBanco baseDatosBanco; // base de datos de información de cuentas

   // el constructor de Transaccion es invocado por las subclases mediante super()
   public Transaccion( int numeroCuentaUsuario, Pantalla pantallaATM, 
      BaseDatosBanco baseDatosBancoATM )
   {
      numeroCuenta = numeroCuentaUsuario;
      pantalla = pantallaATM;
      baseDatosBanco = baseDatosBancoATM;
   } // fin del constructor de Transaccion

   // devuelve el número de cuenta 
   public int obtenerNumeroCuenta()
   {
      return numeroCuenta; 
   } // fin del método obtenerNumeroCuenta

   // devuelve una referencia a la pantalla
   public Pantalla obtenerPantalla()
   {
      return pantalla;
   } // fin del método obtenerPantalla

   // devuelve una referencia a la base de datos del banco
   public BaseDatosBanco obtenerBaseDatosBanco()
   {
      return baseDatosBanco;
   } // fin del método obtenerBaseDatosBanco

   // realiza la transacción (cada subclase sobrescribe este método)
   abstract public void ejecutar();
} // fin de la clase Transaccion



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