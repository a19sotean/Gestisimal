package gestisimal;

/**
 * 
 * Clase PrecioNegativoExcepcion que extiende de la clase Excepcion.
 * Aqu� se trata la excepci�n de que el precio del art�culo no puede ser negativo.
 * 
 * @author Andrea Sol�s Tejada
 *
 */

public class PrecioNegativoExcepcion extends Exception {

  public PrecioNegativoExcepcion(String string) {
    super(string);
  }

}
