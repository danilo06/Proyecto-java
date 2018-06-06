package modelo;
import connection.AccountQueries;

// BaseDatosBanco.java
// Representa a la base de datos de información de cuentas bancarias

public class BaseDatosBanco
{
   private AccountQueries queries = new AccountQueries();
   
   // determina si el número de cuenta y el NIP especificados por el usuario coinciden
   // con los de una cuenta en la base de datos
   public boolean autenticarUsuario( int numeroCuentaUsuario, int nipUsuario )
   {
      // trata de obtener la cuenta con el número de cuenta
      Cuenta cuentaUsuario = queries.getCuenta(numeroCuentaUsuario);

      // si la cuenta existe, devuelve el resultado del método validarNIP de Cuenta
      if ( cuentaUsuario != null )
         return cuentaUsuario.validarNIP( nipUsuario );
      else
         return false; // no se encontró el número de cuenta, por lo que devuelve false
   } // fin del método autenticarUsuario

} // fin de la clase BaseDatosBanco

