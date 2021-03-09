package gestisimal;

/**
 * 
 * Clase UnidadesNegativasExcepcion que extiende de la clase Excepcion.
 * Aquí se trata la excepción de que no pueden haber número de unidades negativas
 * de la clase Articulo.
 * 
 * @author Andrea Solís Tejada
 *
 */

public class UnidadesNegativasExcepcion extends Exception {
  public UnidadesNegativasExcepcion(String string) {
    super(string);
  }
}
