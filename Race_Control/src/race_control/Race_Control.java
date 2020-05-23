
package race_control;

import Clases.*;
import gestion.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Race_Control {


    public static void main(String[] args) throws IOException, FileNotFoundException, ClassNotFoundException {
        Scanner sc = new Scanner(System.in);
        ArrayList<Coche> coches = new ArrayList<>();
        ArrayList<Garaje> garajes = new ArrayList<>();
        ArrayList<Carrera> carreras = GestionFicheros.leerFicheroCarreras();
        ArrayList<Torneo> torneos = GestionFicheros.leerFicheroTorneos();
        Torneo torneo = new Torneo();
        
        
        Menu.menuPrincipal(sc ,coches, garajes, carreras,torneo,torneos );
        
        
        
    }
    
}
