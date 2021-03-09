package gestisimal;

/**
 * 
 * Clase NoExisteArticuloException que extiende de la clase Excepcion.
 * Aqu� se trata la excepci�n de que no existe un art�culo.
 * 
 * @author Andrea Sol�s Tejada
 *
 */

public class ArticuloNoExisteException extends Exception {

  public ArticuloNoExisteException(String string) {
    super(string);
  }

}
