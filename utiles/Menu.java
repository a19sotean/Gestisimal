package utiles;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Clase Menú, permite añadir opciones y escoger alguna opción.
 * Esta clase se puede reutilizar para hacer otros ejercicios que requieran
 * un menú.
 * 
 * @author Andrea Solís Tejada
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
  
  // Método.
  public int elegirOpcion() {
    System.out.println("\nMenú\n");
    for (int i = 0; i < this.opciones.length; i++) {
      System.out.println(i+1 + ". " + this.opciones[i]);
    }
    System.out.print("\nElige una opción: ");
    int opcion = s.nextInt();
    
    while (opcion <= 0 || opcion > this.opciones.length) {
      System.out.println("La opción elegida es incorrecta, dime otra opción: ");
      opcion = s.nextInt();
    }
    return opcion;
  }

  @Override
  public String toString() {
    return "Menu [opciones=" + Arrays.toString(opciones) + "]";
  }
}