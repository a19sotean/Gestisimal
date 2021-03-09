package gestisimal;

import java.util.Scanner;
import utiles.Menu;

/**
 * Clase TestAlmac�n, donde se realiza la comunicaci�n con el usuario (mostrar men� y recuperar opci�n del 
 * men�, mostrar errores, listar) y se manipula el almac�n.  Debes organizarla en m�todos que deleguen en 
 * la clase Almac�n (listar, a�adir, eliminar... al menos uno por cada una de las opciones del men�).
 * 
 * @author Andrea Sol�s Tejada
 *
 */

public class TestAlmacen {
  static Scanner s = new Scanner(System.in);
  
  private static Almacen almacen = new Almacen();
  
  public static void main(String[] args) {
    
    
    String[] opciones = new String[] {"A�adir un art�culo", "Eliminar un art�culo", "Incrementar las unidades de un art�culo",
                                      "Decrementar las unidades de un art�culo", "Modificar un art�culo", "Mostrar un art�culo", "Mostrar el almac�n", "Salir"};
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
          System.out.println("�Hasta pronto!");
          System.exit(0);
      }
    } while (true);
  }
  
  // M�todos utilizados para pedir los datos al usuario.
  
  private static String pedirNombre() {
    System.out.print("Dime el nombre del art�culo: ");
    String nombre = s.nextLine();
    return nombre;
  }
  
  private static int pedirCodigo() {
    System.out.print("Dime el c�digo del art�culo: ");
    int codigo = s.nextInt();
    s.nextLine();
    return codigo;
  }
  
  private static String pedirDescripcion() {
    System.out.print("Dime la descripci�n del art�culo: ");
    String descripcion = s.nextLine();
    return descripcion;
  }
  
  private static double pedirPrecioCompra() {
    System.out.print("Dime el precio de compra del art�culo: ");
    double precioCompra = s.nextDouble();
    s.nextLine();
    return precioCompra;
  }
  
  private static double pedirPrecioVenta() {
    System.out.print("Dime el precio de venta del art�culo: ");
    double precioVenta = s.nextDouble();
    s.nextLine();
    return precioVenta;
  }
  
  private static int pedirNumUnidades() {
    System.out.print("Dime el n�mero de unidades del art�culo: ");
    int numUnidades = s.nextInt();
    s.nextLine();
    return numUnidades;
  }
  
  private static int pedirStockSeguridad() {
    System.out.print("Dime el stock de seguridad del art�culo: ");
    int stockSeguridad = s.nextInt();
    s.nextLine();
    return stockSeguridad;
  }
  
  private static int pedirStockMaximo() {
    System.out.print("Dime el stock m�ximo del art�culo: ");
    int stockMaximo = s.nextInt();
    s.nextLine();
    return stockMaximo;
  }
  
  private static int pedirUnidadesIncrementar() {
    System.out.println("Dime cu�ntas unidades quieres incrementar: ");
    int unidades = s.nextInt();
    s.nextLine();
    return unidades;
  }
  
  private static int pedirUnidadesDecrementar() {
    System.out.println("Dime cu�ntas unidades quieres decrementar: ");
    int unidades = s.nextInt();
    s.nextLine();
    return unidades;
  }
  
  // M�todos para poner en el men� (emplean try catch)
  
  private static void annadirArticulo() {
    try {
      try {
        almacen.annadirArticulos(pedirNombre(), pedirDescripcion(), pedirPrecioCompra(), pedirPrecioVenta(), pedirNumUnidades(), pedirStockSeguridad(), pedirStockMaximo());
        System.out.println("Art�culo a�adido correctamente.");
      } catch (PrecioNegativoExcepcion e) {
        System.err.println("Error al a�adir el art�culo. " + e.getMessage());
      }
    } catch (UnidadesNegativasExcepcion e) {
      System.err.println("Error al a�adir el art�culo. " + e.getMessage());
    }
  }
  
  private static void eliminarArticulo() {
    if (almacen.eliminarArticulos(pedirCodigo())) {
      System.out.println("Art�culo eliminado correctamente.");
    } else {
      System.err.println("Error al eliminar el art�culo. No existe ning�n art�culo con ese c�digo.");
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
        System.out.println("Art�culo modificado correctamente.");
      } catch (UnidadesNegativasExcepcion | PrecioNegativoExcepcion e) {
        System.err.println("Error al modificar el art�culo. " + e.getMessage());
      }
    } catch (ArticuloNoExisteException e) {
      System.err.println("Error al modificar el art�culo. " + e.getMessage());
    }
  }
  
  private static void getArticulo() {
    try {
      System.out.print("Dime el c�digo del art�culo: ");
      int codigo = s.nextInt();
      System.out.println(almacen.getArticulo(codigo));
    } catch (ArticuloNoExisteException e) {
      System.err.println("Error al obtener el art�culo. " + e.getMessage());
    }
  }
  
}
