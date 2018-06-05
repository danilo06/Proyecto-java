package controlador;
// DispensadorEfectivo.java
// Representa al dispensador de efectivo del ATM

public class DispensadorEfectivo 
{
   // el número inicial predeterminado de billetes en el dispensador de efectivo
   private final static int CUENTA_INICIAL = 500;
   private int cuenta; // número restante de billetes de $20 
   
   // el constructor sin argumentos de DispensadorEfectivo inicializa cuenta con el valor predeterminado
   public DispensadorEfectivo()
   {
      cuenta = CUENTA_INICIAL; // establece el atributo cuenta al valor predeterminado
   } // fin del constructor de DispensadorEfectivo

   // simula la acción de dispensar el monto especificado de efectivo
   public void dispensarEfectivo( int monto )
   {
      int billetesRequeridos = monto / 20; // número de billetes de $20 requeridos
      cuenta -= billetesRequeridos; // actualiza la cuenta de billetes
   } // fin del método dispensarEfectivo

   // indica si el dispensador de efectivo puede dispensar el monto deseado
   public boolean haySuficienteEfectivoDisponible( int monto )
   {
      int billetesRequeridos = monto / 20; // número de billetes de $20 requeridos

      if ( cuenta >= billetesRequeridos  )
         return true; // hay suficientes billetes disponibles
      else 
         return false; // no hay suficientes billetes disponibles
   } // fin del método haySuficienteEfectivoDisponible
} // fin de la clase DispensadorEfectivo



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