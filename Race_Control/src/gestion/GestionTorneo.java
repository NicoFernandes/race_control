
package gestion;

import Clases.Carrera;
import Clases.Coche;
import Clases.Torneo;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class GestionTorneo {
    
    public static void crearTorneo(Scanner sc,  Torneo torneo,  ArrayList<Coche> coches){
        String garaje = "";
        
        System.out.println("Nombre del torneo: ");
        String nombreTorneo = sc.nextLine();
        if (torneo.getCarreras() == null) {
            System.out.println("Tipo del torneo: ESTANDAR/ELIMINACION");
            String tipoCarreras = sc.nextLine();
            
            System.out.println("Tipo de participantes: Monomarca/Mixto");
            String tipoParticipantes = sc.nextLine();
            ArrayList<Carrera> carrerasTorneo = new ArrayList<>();
            if (tipoParticipantes.equalsIgnoreCase("monomarca")) {
                System.out.println("Garaje del que se va a realizar el torneo: ");
                 garaje = sc.nextLine();
            }
           
            do {
                String nombre = " ";
                
                GestionCarrera.crearCarrera(sc, coches, carrerasTorneo, nombre, tipoCarreras, tipoParticipantes, garaje);
            } while (carrerasTorneo.size() < 10);
            
            torneo.setCarreras(carrerasTorneo);
            torneo.setNombre(nombreTorneo);
                    
        }else if (torneo.getCarreras() != null) {
            System.out.println("Ya hay un torneo en marcha en estos momentos, no se puede crear otro");
        }
                
    }
    
    
    public static void simularTorneo(Scanner sc, Torneo torneo, ArrayList<Torneo> torneos){
        if (torneo.getCarreras() == null) {
            System.out.println("Debes crear un torneo antes de simularlo");
        }else{
        Coche ganador = new Coche();
        int contador = 0;
        for (int i = 0; i < torneo.getCarreras().size(); i++) {
            GestionCarrera.simulacionCarrera(sc, torneo.getCarreras().get(i));
            System.out.println("------------------------------------------");
        }
        
        ArrayList<Coche> resultadosFinales = torneo.getCarreras().get(3).getParticipantes();
        Collections.sort(resultadosFinales);
        
        Coche[] podio = {resultadosFinales.get(0), resultadosFinales.get(1),resultadosFinales.get(2)};
        System.out.println("GANADOR TORNEO: " + podio[0].getMarca() + "  " + podio[0].getModelo() + " Puntuación: " + podio[0].getPuntos());
        System.out.println("SEGUNDO PUESTO: " + podio[1].getMarca() + "  " + podio[1].getModelo() + " Puntuación: " + podio[1].getPuntos());
        System.out.println("TERCER  PUESTO: " + podio[2].getMarca() + "  " + podio[2].getModelo() + " Puntuación: " + podio[2].getPuntos());
            
        torneo.setResultados(podio);
        torneos.add(torneo);
        
        }
        
        
        
    }
    
    public static void verTorneos(Scanner sc, ArrayList<Torneo> torneos){
        
        for (Torneo torneo : torneos) {
            System.out.println("Nombre del torneo: " + torneo.getNombre());
            Coche[] podio = torneo.getResultados();
            System.out.println("Ganador: " + podio[0].getMarca() + " " + podio[0].getModelo());
            System.out.println("Segundo puesto: " + podio[1].getMarca() + " " + podio[1].getModelo());
            System.out.println("Tercer puesto: " + podio[2].getMarca() + " " + podio[2].getModelo());
            System.out.println("--------------------------------------");
        }
    }
    
}
