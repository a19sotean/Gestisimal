package gestisimal;

/**
 * 
 * Clase PrecioNegativoExcepcion que extiende de la clase Excepcion.
 * Aquí se trata la excepción de que el precio del artículo no puede ser negativo.
 * 
 * @author Andrea Solís Tejada
 *
 */

public class PrecioNegativoExcepcion extends Exception {

  public PrecioNegativoExcepcion(String string) {
    super(string);
  }

}
