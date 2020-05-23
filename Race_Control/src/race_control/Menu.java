
package race_control;

import Clases.*;
import gestion.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class Menu {
    public static void menuPrincipal(Scanner sc , ArrayList<Coche> coches,  ArrayList<Garaje> garajes, ArrayList<Carrera> carreras,Torneo torneo, ArrayList<Torneo> torneos) throws IOException{
        
    
    System.out.println("--------RACE CONTROL-------");
        int opc = 0;
        do {
            System.out.println("1- Control de coches");
            System.out.println("2- Control de garajes");
            System.out.println("3- Control de carreras");
            System.out.println("4- Cargar coches");
            System.out.println("0- Salir");
            System.out.println("Escriba el numero de la opción que desea seleccionar:");
            opc = sc.nextInt();
            sc.nextLine();
          switch(opc){
            case 1:
                menuCoches(sc, coches, garajes);
                break;
            case 2:
                menuGarajes(sc, garajes);
                break;
            case 3:
                menuCarreras(sc, coches, carreras,torneo, torneos);
                break;
            case 4:
                System.out.println("Desea cargar los coches y garajes guardado? (si/no)");
                String eleccion = sc.nextLine();
                if (eleccion.equalsIgnoreCase("si")) {
                    GestionFicheros.cargarCoches(sc, coches, garajes);
                    System.out.println("Guardado con éxito");
                }else if (eleccion.equalsIgnoreCase("no")) {
                    System.out.println("Operacion cancelada");
                }
                
                break;
            case 5:
                GestionTorneo.verTorneos(sc, torneos);
                break;
                
            case 0:
                System.out.println("Desea guardar antes de salir? (si/no)");
                String elec = sc.nextLine();
                if (elec.equalsIgnoreCase("si")) {
                    GestionFicheros.guardarCarreras(carreras);
                    GestionFicheros.guardarTorneos(torneos);
                    System.out.println("Guardado con éxito");
                }else if (elec.equalsIgnoreCase("no")) {
                    System.out.println("Saliendo sin guardar");
                }
                
                break;
        }   
        } while (opc != 0);
        
    }
    
    
    public static void menuCoches(Scanner sc ,ArrayList<Coche> coches,  ArrayList<Garaje> garajes){
        System.out.println("--------GESTIÓN DE COCHES-------");
        int opc = 0;
        do {
            System.out.println("1- Alta de coches");
            System.out.println("2- Baja de coches");
            System.out.println("3- Mostrar coches");
            System.out.println("0- Volver al menú principal");
            System.out.println("Escriba el numero de la opción que desea seleccionar:");

            opc = sc.nextInt();
            sc.nextLine();
          switch(opc){
            case 1:
                GestionCoches.altaCoche(sc, coches, garajes);
                break;
            case 2:
                GestionCoches.bajaCoche(sc, coches);
                break;
            case 3:
                GestionCoches.mostrarCoche(sc, coches);
                break;
            case 0:
                break;
        }   
        } while (opc != 0);
        
    }
    
    public static void menuCarreras(Scanner sc, ArrayList<Coche> coches, ArrayList<Carrera> carreras,Torneo torneo, ArrayList<Torneo> torneos){
        System.out.println("--------GESTIÓN DE CARRERAS-------");
        int opc = 0;
        do {
            System.out.println("1- Crear una carrera");
            System.out.println("2- Simular una carrera");
            System.out.println("3- Crear un torneo");
            System.out.println("4- Simular un torneo");
            System.out.println("5- Consultar histórico de carreras");
            System.out.println("6- Consultar histórico de torneos");
            System.out.println("0- Volver al menú principal");
            System.out.println("Escriba el numero de la opción que desea seleccionar:");
            opc = sc.nextInt();
            sc.nextLine();
          switch(opc){
            case 1:
                GestionCarrera.altaCarrera(sc, coches, carreras);
                break;
            case 2:
                GestionCarrera.pedirDatosCarrera(sc, carreras);
                break;
            case 3:
                GestionTorneo.crearTorneo(sc, torneo, coches);
                break;
            case 4:
                GestionTorneo.simularTorneo(sc, torneo, torneos);
                break;
            case 5:
                GestionCarrera.verCarreras(carreras);
                break;
            case 6:
                GestionTorneo.verTorneos(sc, torneos);
                break;
            case 0:
                
                break;
        }   
        } while (opc != 0);
    }
    
    
    public static void menuGarajes(Scanner sc, ArrayList<Garaje> garajes){
        System.out.println("--------GESTIÓN DE GARAJES-------");
        int opc = 0;
        do {
            System.out.println("1- Crear una garaje");
            System.out.println("2- Eliminar un garaje");
            System.out.println("3- Ver todos los garajes");
            System.out.println("0- Volver al menú principal");
            System.out.println("Escriba el numero de la opción que desea seleccionar:");
            opc = sc.nextInt();
            sc.nextLine();
          switch(opc){
            case 1:
                GestionGaraje.pedirDatosGaraje(sc, garajes);
                break;
            case 2:
                GestionGaraje.bajaGaraje(sc, garajes);
                break;
            case 3:
                GestionGaraje.verGarajes(sc, garajes);
                        
            case 0:
                break;
        }   
        } while (opc != 0);
    }
}
