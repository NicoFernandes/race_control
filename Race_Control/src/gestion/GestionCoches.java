
package gestion;

import Clases.Coche;
import Clases.Garaje;
import java.util.ArrayList;
import java.util.Scanner;


public class GestionCoches {
    
    public static void altaCoche(Scanner sc, ArrayList<Coche> coches,  ArrayList<Garaje> garajes){
        Garaje garaje = null;
        boolean correcto = true;
        int num = 0;
        do {
            correcto = true;
            System.out.println("Numero del vehículo: ('0' para cancelar)");
            num = sc.nextInt();
            sc.nextLine();
            
            for (int i = 0; i < coches.size(); i++) {
                if (coches.get(i).getNumero_coche() == num) {
                    correcto = false;
                }
            }
            if (correcto == false) {
                System.out.println("Ya existe un coche con ese numero, por favor introduzca uno correcto");
            }
        } while (correcto == false && num > 0);
        
        
        if (num != 0) {
            System.out.println("Marca del vehículo");
        String marca = sc.nextLine();
        System.out.println("Modelo del vehículo");
        String modelo = sc.nextLine();
        System.out.println("Escriba el nombre del garaje al que pertenece el vehículo");
        if (garajes == null) {
            System.out.println("No hay garajes registradros, por favor registre uno nuevo y vuelva");
        }else{
            for (Garaje arrayGaraje : garajes) {
            System.out.println(arrayGaraje.getNombre());
        }
        
        String nombreGaraje = sc.nextLine();
        for (int i = 0; i < garajes.size(); i++) {
            if (garajes.get(i).getNombre().equalsIgnoreCase(nombreGaraje)) {
                garaje = garajes.get(i);
            }
        }
            coches.add(new Coche(num, marca, modelo, garaje));
        }
        }else{
            System.out.println("Alta de vehiculo cancelada");
        }
        
        
        
        
    }
    
    public static void bajaCoche (Scanner sc, ArrayList<Coche> coches){
        System.out.println("Numero del vehículo que desea eliminar");
        int num = sc.nextInt();
        for (int i = 0; i < coches.size(); i++) {
            if (coches.get(i).getNumero_coche() == num) {
                coches.remove(i);
                System.out.println("Coche elimnado con éxito");
            }
        }
    }
    
    
    
    public static void mostrarCoche(Scanner sc, ArrayList<Coche> coches){
        System.out.println("Numero Marca   Modelo"); 
        for (Coche coche : coches) {
            System.out.println(coche.getNumero_coche() + "    " + coche.getMarca() + "  " + coche.getModelo());
        }
    }
}
