
package gestion;

import Clases.Garaje;
import java.util.ArrayList;
import java.util.Scanner;

public class GestionGaraje {
    
    public static void pedirDatosGaraje(Scanner sc, ArrayList<Garaje> garajes){
        System.out.println("Nombre de la escudería: ");
        String nombre = sc.nextLine();
        altGaraje(sc, garajes, nombre);
    }
    public static void altGaraje (Scanner sc, ArrayList<Garaje> garajes, String nombre){
        boolean añadida = false;
        
        if (garajes.size() == 0) {
             garajes.add(new Garaje(nombre));
             System.out.println("Escudería añadida correctamente");
        }else{
        for (int i = 0; i < garajes.size(); i++) {
            if (!garajes.get(i).getNombre().equalsIgnoreCase(nombre)) {
                añadida = true;
            }
        }
        if (añadida == true) {
            garajes.add(new Garaje(nombre));
            System.out.println("Escudería añadida correctamente");
        }else{
            System.out.println("Error al añadir la escudería " + nombre + ", ya existe una con ese nombre");
        }
        }
        
        
    }
    
    public static void bajaGaraje (Scanner sc, ArrayList<Garaje> garajes){
        System.out.println("Nombre de la escudería que desea eliminar");
        String nombre = sc.nextLine();
        for (int i = 0; i < garajes.size(); i++) {
            if (garajes.get(i).getNombre().equalsIgnoreCase(nombre)) {
                garajes.remove(i);
                System.out.println("Eliminado con éxito");
            }
        }
    }
    
    public static void verGarajes(Scanner sc, ArrayList<Garaje> garajes){
        for (Garaje garaje : garajes) {
            System.out.println(garaje.getNombre());
        }
    }
}
