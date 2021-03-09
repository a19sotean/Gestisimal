package gestisimal;

import java.util.ArrayList;

/**
 * 
 * Clase Almacén que realice el alta, baja, modificación, entrada de mercancía (incrementa unidades), 
 * salida de mercancía (decrementa unidades).
 * El estado será un ArrayList de artículos. Esta clase es un envoltorio de un ArrayList.
 * Su comportamiento será: añadir artículos (no puede haber dos artículos iguales), eliminar artículos, 
 * incrementar las existencias de un artículo (se delega en la clase Artículo),  decrementar las existencias 
 * de un artículo (nunca por debajo de cero, se delega en la clase Artículo), devolver un artículo (para mostrarlo). 
 * Para listar el almacén podría devolverse una cadena con todos los artículos del almacén (toString).
 * 
 * @author Andrea Solís Tejada
 *
 */

public class Almacen {
  public ArrayList<Articulo> almacen = new ArrayList<Articulo>();
  
  // Métodos.
  
  /**
   * Añadir un artículo, también lanzo la excepción de que no puedo tener unidades negativas.
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
   * Eliminar un artículo indicando su código.
   * 
   * @param codigo2
   * @return true or false
   */
  public boolean eliminarArticulos(int codigo2) {
    return almacen.remove(new Articulo(codigo2));
  }
  
  /**
   * Método utilizado para obtener un artículo.
   * 
   * @param codigo2
   * @return
   * @throws ArticuloNoExisteException
   */
  public Articulo getArticulo(int codigo2) throws ArticuloNoExisteException {
    try {
      return almacen.get(almacen.indexOf(new Articulo(codigo2)));
    } catch (IndexOutOfBoundsException e) {
      throw new ArticuloNoExisteException("El artículo no existe.");
    }
  }
  
  /**
   * Método que incrementa las unidades de un artículo en el almacén.
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
   * Método que decrementa las unidades de un artículo en el almacén.
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
   * Método que modifica un artículo en el almacén.
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
