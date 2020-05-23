
package gestion;
import race_control.Menu;
import Clases.Carrera;
import Clases.Coche;
import java.util.ArrayList;
import java.util.Scanner;

public class GestionCarrera {
    public static void altaCarrera(Scanner sc,ArrayList<Coche> coches,ArrayList<Carrera> carreras){
        String garaje = "";
       System.out.println("Nombre del Gran Premio");
        String nombre = sc.nextLine();
        
        System.out.println("Tipo de carrera : ESTANDAR/ELIMINACION");
        String tipo = sc.nextLine(); 
        
        System.out.println("Carrera Monomarca o mixta?");
        String tipoParticipantes = sc.nextLine();
        
        if (tipoParticipantes.equalsIgnoreCase("Monomarca")) {
            System.out.println("Garaje del que se va a realizar el torneo: ");
                 garaje = sc.nextLine();
        }
        
        crearCarrera(sc, coches, carreras, nombre, tipo, tipoParticipantes, garaje);
    }
    
    
    public static void crearCarrera(Scanner sc, ArrayList<Coche> coches, ArrayList<Carrera> carreras,String  nombre,String tipo, String tipoParticipantes, String garaje){
        ArrayList<Coche> participantes = new ArrayList<>();
        Carrera carrera = new Carrera();
        carrera.setNombre(nombre);
        
        if (tipo.equalsIgnoreCase("ESTANDAR")) {
            carrera.carreraEstandar();
        }else{
            carrera.carreraEliminacion();
        }
        
        if (tipoParticipantes.equalsIgnoreCase("monomarca")) {
            for (int i = 0; i < coches.size(); i++) {
                if (coches.get(i).getGaraje().getNombre().equalsIgnoreCase(garaje)) {
                    participantes.add(coches.get(i));
                }
            }
        }else{
                boolean nombreCoincide = false;
                ArrayList<String> nombres = new ArrayList<>();
                ArrayList<Coche> listaFinal = new ArrayList<>();
                nombres.add(" ");
                for (int i = 0; i < coches.size(); i++) {
                    nombreCoincide = false;
                    for (int j = 0; j < nombres.size(); j++) {
                        if (coches.get(i).getGaraje().getNombre().equalsIgnoreCase(nombres.get(j))) {
                            
                            nombreCoincide = true;
                            
                        }
                    }
                    if(nombreCoincide == false) {
                        listaFinal.add(coches.get(i));
                        nombres.add(coches.get(i).getGaraje().getNombre());
                    }
                }
                participantes = listaFinal;
                
                
            }
        
        
        if (participantes != null) {
            carrera.setParticipantes(participantes);
        }else{
            carrera.setParticipantes(null);
        }
        
        carreras.add(carrera);
        
    }
    
    public static void verCarreras(ArrayList<Carrera> carreras){
        for (Carrera carrera : carreras) {
            System.out.println("Nombre del gran premio: " + carrera.getNombre());
            System.out.println("Tipo de Gran Premio: " + carrera.getTipo());
            Coche[] podio = carrera.getPodio();
            System.out.println("Primer puesto : " + podio[0].getMarca() + " " + podio[0].getModelo());
            System.out.println("Segundo puesto: " + podio[1].getMarca() + " " + podio[1].getModelo());
            System.out.println("Tercer puesto : " + podio[2].getMarca() + " " + podio[2].getModelo());
            System.out.println("--------------------------------------------------------------------");
            
       
                
            }
        
    }
    
    public static void pedirDatosCarrera(Scanner sc, ArrayList<Carrera> carreras){
             Carrera race = new Carrera();
            if (carreras.size() <= 0) {
                System.out.println("Debes crear un carrera antes de comenzar una simulación");
                
        }else{
        System.out.println("-------- SIMULACION -------");
        for (Carrera carrera : carreras) {
            System.out.println(carrera.getNombre());
            
        }
        System.out.println("Escriba el nombre del gran premio que desea disputar");
        String nombre = sc.nextLine();
        try{
            for (int i = 0; i < carreras.size(); i++) {
            if (carreras.get(i).getNombre().equalsIgnoreCase(nombre)) {
                race = carreras.get(i);
            }
        }
         simulacionCarrera(sc, race);
        }catch(Exception e){
            System.out.println("Error, no existe carrera con ese nombre");
        }
        
        
     }
    }
    
    
    public static void simulacionCarrera(Scanner sc, Carrera race){
        int random1 = 0;
        int random2 = 0;
        int random3 = 0;
        
        
        //SELECCION DE LOS COCHES GANADORES GENERANDO NUMEROS ALEATORIOS 
        
             random1 = (int) Math.floor(Math.random()*race.getParticipantes().size());
            do{
                random2 = (int) Math.floor(Math.random()*race.getParticipantes().size());
            }while (random2 == random1);
            do {
                random3 = (int) Math.floor(Math.random()*race.getParticipantes().size());
            } while (random3 == random1 && random3 == random2);
            

            //asignacion de la puntuacion 
            race.getParticipantes().get(random1).setPuntos(race.getParticipantes().get(random1).getPuntos() + 25 );
            race.getParticipantes().get(random2).setPuntos(race.getParticipantes().get(random2).getPuntos() + 18 );
            race.getParticipantes().get(random3).setPuntos(race.getParticipantes().get(random3).getPuntos() + 15 );
            Coche[] podio = {race.getParticipantes().get(random1),race.getParticipantes().get(random2),race.getParticipantes().get(random3)};
            race.setPodio(podio);
            //impresión resultados
            System.out.println("Ganador de la carrera: " + " " + race.getParticipantes().get(random1).getMarca()+ " " + race.getParticipantes().get(random1).getModelo()+ " " + race.getParticipantes().get(random1).getGaraje().getNombre());
            System.out.println("Segundo puesto: " + " " + race.getParticipantes().get(random2).getMarca() + " " + race.getParticipantes().get(random2).getModelo() + " " + race.getParticipantes().get(random2).getGaraje().getNombre());
            System.out.println("Tercer puesto: " + " " + race.getParticipantes().get(random3).getMarca() + " " + race.getParticipantes().get(random3).getModelo() + " " + race.getParticipantes().get(random3).getGaraje().getNombre());
       
       
       }
    }

