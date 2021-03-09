package gestisimal;

/**
 * 
 * Clase UnidadesNegativasExcepcion que extiende de la clase Excepcion.
 * Aqu� se trata la excepci�n de que no pueden haber n�mero de unidades negativas
 * de la clase Articulo.
 * 
 * @author Andrea Sol�s Tejada
 *
 */

public class UnidadesNegativasExcepcion extends Exception {
  public UnidadesNegativasExcepcion(String string) {
    super(string);
  }
}
