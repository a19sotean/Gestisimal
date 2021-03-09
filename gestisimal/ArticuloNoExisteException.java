package gestisimal;

/**
 * 
 * Clase NoExisteArticuloException que extiende de la clase Excepcion.
 * Aquí se trata la excepción de que no existe un artículo.
 * 
 * @author Andrea Solís Tejada
 *
 */

public class ArticuloNoExisteException extends Exception {

  public ArticuloNoExisteException(String string) {
    super(string);
  }

}
