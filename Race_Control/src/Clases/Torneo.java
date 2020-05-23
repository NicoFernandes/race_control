
package Clases;

import java.io.Serializable;
import java.util.ArrayList;

public class Torneo implements Serializable{
    private String nombre;
    private ArrayList<Carrera> carreras;
    private Coche[] resultados;
    

    
    public Torneo() {
        }
    public Torneo(String nombre, ArrayList<Carrera> carreras, Coche[] resultados) {
        this.nombre = nombre;
        this.carreras = carreras;
        this.resultados = resultados;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    

    public ArrayList<Carrera> getCarreras() {
        return carreras;
    }

    public void setCarreras(ArrayList<Carrera> carreras) {
        this.carreras = carreras;
    }

    public Coche[] getResultados() {
        return resultados;
    }

    public void setResultados(Coche[] resultados) {
        this.resultados = resultados;
    }

    
    
    
    
    
}
