package gestisimal;

/**
 * Clase Artículo que representa a los artículos del almacén.   
 * Su estado será: código, descripción, precio de compra, precio de venta, número de unidades (nunca negativas), 
 * stock de seguridad y stock máximo.
 * Como comportamiento: Consideramos que el código va a generarse de forma automática en el constructor, así no 
 * puede haber dos artículos con el mismo código. Esto implica que no puede modificarse el código de un artículo, 
 * sí el resto de las propiedades. Podremos mostrar el artículo, por lo que necesito una representación del artículo 
 * en forma de cadena (toString). 
 * 
 * @author Andrea Solís Tejada
 *
 */

public class Articulo {
  // Variables.
  private int codigo;
  private String nombre;
  private String descripcion;
  private double precioCompra;
  private double precioVenta;
  private int numUnidades;
  private int stockSeguridad;
  private int stockMaximo;
  private static int contador = 1;
  
  // Constructores.
  public Articulo(String nombre, String descripcion, double precioCompra, double precioVenta, int numUnidades, int stockSeguridad, int stockMaximo) throws UnidadesNegativasExcepcion, PrecioNegativoExcepcion {
    this.descripcion = descripcion;
    this.nombre = nombre;
    setPrecioCompra(precioCompra);
    setPrecioVenta(precioVenta);
    setNumUnidades(numUnidades);
    this.stockSeguridad = stockSeguridad;
    this.stockMaximo = stockMaximo;
    this.codigo = contador++;
  }
  
  public Articulo(int codigo2) {
    this.codigo = codigo2;
  }

  //Getters y setters.
  
  /**
   * @return the nombre
   */
  public String getNombre() {
    return nombre;
  }

  /**
   * @param nombre the nombre to set
   */
  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  /**
   * @return the descripcion
   */
  public String getDescripcion() {
    return descripcion;
  }

  /**
   * @param descripcion the descripcion to set
   */
  public void setDescripcion(String descripcion) {
    this.descripcion = descripcion;
  }

  /**
   * @return the precioCompra
   */
  public double getPrecioCompra() {
    return precioCompra;
  }

  /**
   * @param precioCompra the precioCompra to set
   * @throws PrecioNegativoExcepcion 
   */
  public void setPrecioCompra(double precioCompra) throws PrecioNegativoExcepcion {
    if (precioCompra < 0) {
      throw new PrecioNegativoExcepcion("El precio no pueden ser negativo.");
    }
    this.precioCompra = precioCompra;
  }

  /**
   * @return the precioVenta
   */
  public double getPrecioVenta() {
    return precioVenta;
  }

  /**
   * @param precioVenta the precioVenta to set
   * @throws PrecioNegativoExcepcion 
   */
  public void setPrecioVenta(double precioVenta) throws PrecioNegativoExcepcion {
    if (precioVenta < 0) {
      throw new PrecioNegativoExcepcion("El precio no pueden ser negativo.");
    }
    this.precioVenta = precioVenta;
  }

  /**
   * @return the numUnidades
   */
  public int getNumUnidades() {
    return numUnidades;
  }

  /**
   * @param numUnidades the numUnidades to set
   */
  public void setNumUnidades(int numUnidades) throws UnidadesNegativasExcepcion {
    if (numUnidades < 0) {
      throw new UnidadesNegativasExcepcion("Las unidades no pueden ser negativas.");
    }
    this.numUnidades = numUnidades;
  }

  /**
   * @return the stockSeguridad
   */
  public int getStockSeguridad() {
    return stockSeguridad;
  }

  /**
   * @param stockSeguridad the stockSeguridad to set
   */
  public void setStockSeguridad(int stockSeguridad) {
    this.stockSeguridad = stockSeguridad;
  }

  /**
   * @return the stockMaximo
   */
  public int getStockMaximo() {
    return stockMaximo;
  }

  /**
   * @param stockMaximo the stockMaximo to set
   */
  public void setStockMaximo(int stockMaximo) {
    this.stockMaximo = stockMaximo;
  }

  /**
   * @return the codigo
   */
  public int getCodigo() {
    return codigo;
  }

  // Métodos.
  
  @Override
  public String toString() {
    return "Articulo ---> Código: " + codigo + "\nnombre: " + nombre + "\ndescripción: " + descripcion + "\nprecio de compra: " + precioCompra + "\nprecio de venta: "
        + precioVenta + "\nnúmero de unidades: " + numUnidades + "\nStock de seguridad: " + stockSeguridad + "\nStock máximo: " + stockMaximo;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + codigo;
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Articulo other = (Articulo) obj;
    if (codigo != other.codigo)
      return false;
    return true;
  }
  
  /**
   * Este método incrementa el número de unidades de un artículo.
   * 
   * @param unidades
   * @throws UnidadesNegativasExcepcion
   */
  public void incrementarUnidades(int unidades) throws UnidadesNegativasExcepcion {
    setNumUnidades(getNumUnidades() + unidades);
  }
  
  /**
   * Este método decrementa el número de unidades de un artículo.
   * 
   * @param unidades
   * @throws UnidadesNegativasExcepcion
   */
  public void decrementarUnidades(int unidades) throws UnidadesNegativasExcepcion {
    setNumUnidades(getNumUnidades() - unidades);
  }
  
  /**
   * Modifica los artículos.
   * 
   * @param nombre
   * @param descripcion
   * @param precioCompra
   * @param precioVenta
   * @param unidades
   * @param stockSeguridad
   * @param stockMaximo
   * @throws UnidadesNegativasExcepcion
   * @throws PrecioNegativoExcepcion
   */
  public void modificar(String nombre, String descripcion, double precioCompra, double precioVenta, int unidades, int stockSeguridad, int stockMaximo) throws UnidadesNegativasExcepcion, PrecioNegativoExcepcion {
    setNombre(nombre);
    setDescripcion(descripcion);
    setPrecioCompra(precioCompra);
    setPrecioVenta(precioVenta);
    setNumUnidades(unidades);
    setStockSeguridad(stockSeguridad);
    setStockMaximo(stockMaximo);
  }
  
}
