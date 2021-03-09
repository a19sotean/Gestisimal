package gestisimal;

import java.util.ArrayList;

/**
 * 
 * Clase Almac�n que realice el alta, baja, modificaci�n, entrada de mercanc�a (incrementa unidades), 
 * salida de mercanc�a (decrementa unidades).
 * El estado ser� un ArrayList de art�culos. Esta clase es un envoltorio de un ArrayList.
 * Su comportamiento ser�: a�adir art�culos (no puede haber dos art�culos iguales), eliminar art�culos, 
 * incrementar las existencias de un art�culo (se delega en la clase Art�culo),  decrementar las existencias 
 * de un art�culo (nunca por debajo de cero, se delega en la clase Art�culo), devolver un art�culo (para mostrarlo). 
 * Para listar el almac�n podr�a devolverse una cadena con todos los art�culos del almac�n (toString).
 * 
 * @author Andrea Sol�s Tejada
 *
 */

public class Almacen {
  public ArrayList<Articulo> almacen = new ArrayList<Articulo>();
  
  // M�todos.
  
  /**
   * A�adir un art�culo, tambi�n lanzo la excepci�n de que no puedo tener unidades negativas.
   * 
   * @param nombre
   * @param descripcion
   * @param precioCompra
   * @param precioVenta
   * @param numUnidades
   * @throws UnidadesNegativasExcepcion
   */
  public void annadirArticulos(String nombre, String descripcion, double precioCompra, double precioVenta, int numUnidades, int stockSeguridad, int stockMaximo) throws UnidadesNegativasExcepcion, PrecioNegativoExcepcion {
    almacen.add(new Articulo(nombre, descripcion, precioCompra, precioVenta, numUnidades, stockSeguridad, stockMaximo));
  }
  
  /**
   * Eliminar un art�culo indicando su c�digo.
   * 
   * @param codigo2
   * @return true or false
   */
  public boolean eliminarArticulos(int codigo2) {
    return almacen.remove(new Articulo(codigo2));
  }
  
  /**
   * M�todo utilizado para obtener un art�culo.
   * 
   * @param codigo2
   * @return
   * @throws ArticuloNoExisteException
   */
  public Articulo getArticulo(int codigo2) throws ArticuloNoExisteException {
    try {
      return almacen.get(almacen.indexOf(new Articulo(codigo2)));
    } catch (IndexOutOfBoundsException e) {
      throw new ArticuloNoExisteException("El art�culo no existe.");
    }
  }
  
  /**
   * M�todo que incrementa las unidades de un art�culo en el almac�n.
   * 
   * @param codigo2
   * @param unidades
   * @throws ArticuloNoExisteException 
   * @throws UnidadesNegativasExcepcion 
   */
  public void incrementarUnidades(int codigo2, int unidades) throws UnidadesNegativasExcepcion, ArticuloNoExisteException {
    getArticulo(codigo2).incrementarUnidades(unidades);
  }
  
  /**
   * M�todo que decrementa las unidades de un art�culo en el almac�n.
   * 
   * @param codigo2
   * @param unidades
   * @throws ArticuloNoExisteException 
   * @throws UnidadesNegativasExcepcion 
   */
  public void decrementarUnidades(int codigo2, int unidades) throws UnidadesNegativasExcepcion, ArticuloNoExisteException {
    getArticulo(codigo2).decrementarUnidades(unidades);
  }
  
  /**
   * M�todo que modifica un art�culo en el almac�n.
   * 
   * @param nombre
   * @param descripcion
   * @param precioCompra
   * @param precioVenta
   * @param unidades
   * @param stockSeguridad
   * @param stockMaximo
   * @param codigo2
   * @throws UnidadesNegativasExcepcion
   * @throws PrecioNegativoExcepcion
   * @throws ArticuloNoExisteException
   */
  public void modificar(int codigo2, String nombre, String descripcion, double precioCompra, double precioVenta, int unidades, int stockSeguridad, int stockMaximo) throws UnidadesNegativasExcepcion, PrecioNegativoExcepcion, ArticuloNoExisteException {
    getArticulo(codigo2).modificar(nombre, descripcion, precioCompra, precioVenta, unidades, stockSeguridad, stockMaximo);
  }

  @Override
  public String toString() {
    return "Almacen [almacen=" + almacen + "]";
  }
  
  

}
