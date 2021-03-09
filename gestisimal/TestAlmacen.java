package gestisimal;

import java.util.Scanner;
import utiles.Menu;

/**
 * Clase TestAlmacén, donde se realiza la comunicación con el usuario (mostrar menú y recuperar opción del 
 * menú, mostrar errores, listar) y se manipula el almacén.  Debes organizarla en métodos que deleguen en 
 * la clase Almacén (listar, añadir, eliminar... al menos uno por cada una de las opciones del menú).
 * 
 * @author Andrea Solís Tejada
 *
 */

public class TestAlmacen {
  static Scanner s = new Scanner(System.in);
  
  private static Almacen almacen = new Almacen();
  
  public static void main(String[] args) {
    
    
    String[] opciones = new String[] {"Añadir un artículo", "Eliminar un artículo", "Incrementar las unidades de un artículo",
                                      "Decrementar las unidades de un artículo", "Modificar un artículo", "Mostrar un artículo", "Mostrar el almacén", "Salir"};
    Menu menu = new Menu(opciones);
    
    do {
      switch (menu.elegirOpcion()) {
        case 1:
          annadirArticulo();
          break;
        case 2:
          eliminarArticulo();
          break;
        case 3:
          incrementarUnidades();
          break;
        case 4:
          decrementarUnidades();
          break;
        case 5:
          modificarArticulo();
          break;
        case 6:
          getArticulo();
          break;
        case 7:
          System.out.println(almacen);
          break;
        case 8:
          System.out.println("¡Hasta pronto!");
          System.exit(0);
      }
    } while (true);
  }
  
  // Métodos utilizados para pedir los datos al usuario.
  
  private static String pedirNombre() {
    System.out.print("Dime el nombre del artículo: ");
    String nombre = s.nextLine();
    return nombre;
  }
  
  private static int pedirCodigo() {
    System.out.print("Dime el código del artículo: ");
    int codigo = s.nextInt();
    s.nextLine();
    return codigo;
  }
  
  private static String pedirDescripcion() {
    System.out.print("Dime la descripción del artículo: ");
    String descripcion = s.nextLine();
    return descripcion;
  }
  
  private static double pedirPrecioCompra() {
    System.out.print("Dime el precio de compra del artículo: ");
    double precioCompra = s.nextDouble();
    s.nextLine();
    return precioCompra;
  }
  
  private static double pedirPrecioVenta() {
    System.out.print("Dime el precio de venta del artículo: ");
    double precioVenta = s.nextDouble();
    s.nextLine();
    return precioVenta;
  }
  
  private static int pedirNumUnidades() {
    System.out.print("Dime el número de unidades del artículo: ");
    int numUnidades = s.nextInt();
    s.nextLine();
    return numUnidades;
  }
  
  private static int pedirStockSeguridad() {
    System.out.print("Dime el stock de seguridad del artículo: ");
    int stockSeguridad = s.nextInt();
    s.nextLine();
    return stockSeguridad;
  }
  
  private static int pedirStockMaximo() {
    System.out.print("Dime el stock máximo del artículo: ");
    int stockMaximo = s.nextInt();
    s.nextLine();
    return stockMaximo;
  }
  
  private static int pedirUnidadesIncrementar() {
    System.out.println("Dime cuántas unidades quieres incrementar: ");
    int unidades = s.nextInt();
    s.nextLine();
    return unidades;
  }
  
  private static int pedirUnidadesDecrementar() {
    System.out.println("Dime cuántas unidades quieres decrementar: ");
    int unidades = s.nextInt();
    s.nextLine();
    return unidades;
  }
  
  // Métodos para poner en el menú (emplean try catch)
  
  private static void annadirArticulo() {
    try {
      try {
        almacen.annadirArticulos(pedirNombre(), pedirDescripcion(), pedirPrecioCompra(), pedirPrecioVenta(), pedirNumUnidades(), pedirStockSeguridad(), pedirStockMaximo());
        System.out.println("Artículo añadido correctamente.");
      } catch (PrecioNegativoExcepcion e) {
        System.err.println("Error al añadir el artículo. " + e.getMessage());
      }
    } catch (UnidadesNegativasExcepcion e) {
      System.err.println("Error al añadir el artículo. " + e.getMessage());
    }
  }
  
  private static void eliminarArticulo() {
    if (almacen.eliminarArticulos(pedirCodigo())) {
      System.out.println("Artículo eliminado correctamente.");
    } else {
      System.err.println("Error al eliminar el artículo. No existe ningún artículo con ese código.");
    }
  }
  
  private static void incrementarUnidades() {
    try {
      try {
        almacen.incrementarUnidades(pedirCodigo(), pedirUnidadesIncrementar());
        System.out.println("Unidades incrementadas correctamente.");
      } catch (ArticuloNoExisteException e) {
        System.err.println("Error al incrementar las unidades. " + e.getMessage());
      } 
    } catch (UnidadesNegativasExcepcion e) {
      System.err.println("Error al incrementar las unidades. " + e.getMessage());
    }
  }
  
  private static void decrementarUnidades() {
    try {
      try {
        almacen.decrementarUnidades(pedirCodigo(), pedirUnidadesDecrementar());
        System.out.println("Unidades decrementadas correctamente.");
      } catch (ArticuloNoExisteException e) {
        System.err.println("Error al decrementar las unidades. " + e.getMessage());
      } 
    } catch (UnidadesNegativasExcepcion e) {
      System.err.println("Error al decrementar las unidades. " + e.getMessage());
    }
  }
  
  private static void modificarArticulo() {
    try {
      try {
        almacen.modificar(pedirCodigo(), pedirNombre(), pedirDescripcion(), pedirPrecioCompra(), pedirPrecioVenta(), pedirNumUnidades(), pedirStockSeguridad(), pedirStockMaximo());
        System.out.println("Artículo modificado correctamente.");
      } catch (UnidadesNegativasExcepcion | PrecioNegativoExcepcion e) {
        System.err.println("Error al modificar el artículo. " + e.getMessage());
      }
    } catch (ArticuloNoExisteException e) {
      System.err.println("Error al modificar el artículo. " + e.getMessage());
    }
  }
  
  private static void getArticulo() {
    try {
      System.out.print("Dime el código del artículo: ");
      int codigo = s.nextInt();
      System.out.println(almacen.getArticulo(codigo));
    } catch (ArticuloNoExisteException e) {
      System.err.println("Error al obtener el artículo. " + e.getMessage());
    }
  }
  
}
