/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestion;

import Clases.Carrera;
import Clases.Coche;
import Clases.Garaje;
import Clases.Torneo;
import java.io.BufferedReader;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Nicolás
 */
public class GestionFicheros {
    
    public static void cargarCoches(Scanner sc, ArrayList<Coche> coches, ArrayList<Garaje> garajes) throws FileNotFoundException, IOException{
        BufferedReader br = new BufferedReader(new FileReader("Coches.txt"));
        boolean garajeCoincide = false;
        ArrayList<String> nombres = new ArrayList<>();
        nombres.add("");
        ArrayList<Garaje> garajestemp = new ArrayList<>();
        String linea;
        int cantidad = 0;
        while((linea = br.readLine()) != null){
            String[] datos = linea.split(",");
            coches.add(new Coche(Integer.parseInt(datos[0]), datos[1], datos[2], new Garaje(datos[3])));
            garajestemp.add(new Garaje(datos[3]));
            
            cantidad++;
            
        }
        
        for (int i = 0; i < garajestemp.size(); i++) {
            garajeCoincide = false;
            for (int j = 0; j < nombres.size(); j++) {
                if (garajestemp.get(i).getNombre().equalsIgnoreCase(nombres.get(j))) {
                    garajeCoincide = true;
                }
            }
            if (garajeCoincide == false) {
                garajes.add(garajestemp.get(i));
                nombres.add(garajestemp.get(i).getNombre());
            }
        }
        
        
        
          
        
        System.out.println("Se han cargado un total de " + cantidad + " coches y " + (garajes.size() -1) + " garajes");
        
        
        
    }
    
    
    public static ArrayList<Carrera> leerFicheroCarreras() throws FileNotFoundException, IOException, ClassNotFoundException {
        ArrayList<Carrera> carreras = new ArrayList<>();
        File f = new File("carreras.txt");
        if (f.exists()) {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("carreras.txt"));
            try {
                while (true) {
                    Carrera carrera = (Carrera) ois.readObject();
                    carreras.add(carrera);
                }
            } catch (EOFException ex) {
                ois.close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        return carreras;
    }
    
    
    public static void guardarCarreras(ArrayList<Carrera> carreras) throws FileNotFoundException, IOException{
        File f = new File("carreras.txt");
        ObjectOutputStream oos;
            oos = new ObjectOutputStream(new FileOutputStream("carreras.txt"));
        
        for (int i = 0; i < carreras.size(); i++) {
            oos.writeObject(carreras.get(i));
        }
        oos.close();
    }
    
    public static ArrayList<Torneo> leerFicheroTorneos() throws FileNotFoundException, IOException, ClassNotFoundException {
        ArrayList<Torneo> torneos = new ArrayList<>();
        File f = new File("torneos.txt");
        if (f.exists()) {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("torneos.txt"));
            try {
                while (true) {
                    Torneo torneo = (Torneo) ois.readObject();
                    torneos.add(torneo);
                }
            } catch (EOFException ex) {
                ois.close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        return torneos;
    }
    public static void guardarTorneos(ArrayList<Torneo> torneos) throws FileNotFoundException, IOException{
        File f = new File("torneos.txt");
        ObjectOutputStream oos;
            oos = new ObjectOutputStream(new FileOutputStream("torneos.txt"));
        
        for (int i = 0; i < torneos.size(); i++) {
            oos.writeObject(torneos.get(i));
        }
        oos.close();
    }
    
}
