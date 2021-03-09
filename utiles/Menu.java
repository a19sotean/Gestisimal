package utiles;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Clase Men�, permite a�adir opciones y escoger alguna opci�n.
 * Esta clase se puede reutilizar para hacer otros ejercicios que requieran
 * un men�.
 * 
 * @author Andrea Sol�s Tejada
 *
 */

public class Menu {
  Scanner s = new Scanner(System.in);
  
  // Variables
  private String[] opciones;
  
  // Constructor
  public Menu(String... opciones) {
    this.opciones = new String[opciones.length];
    
    for(int i = 0; i < opciones.length; i++) {
      this.opciones[i] = opciones[i];
    }
  }
  
  // M�todo.
  public int elegirOpcion() {
    System.out.println("\nMen�\n");
    for (int i = 0; i < this.opciones.length; i++) {
      System.out.println(i+1 + ". " + this.opciones[i]);
    }
    System.out.print("\nElige una opci�n: ");
    int opcion = s.nextInt();
    
    while (opcion <= 0 || opcion > this.opciones.length) {
      System.out.println("La opci�n elegida es incorrecta, dime otra opci�n: ");
      opcion = s.nextInt();
    }
    return opcion;
  }

  @Override
  public String toString() {
    return "Menu [opciones=" + Arrays.toString(opciones) + "]";
  }
}